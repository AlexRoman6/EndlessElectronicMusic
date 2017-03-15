package dad.endlessElectronicMusic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		Usuario user = userRepository.findByUsuario(auth.getName());

		if (user == null) {
			throw new BadCredentialsException("User not found");
		}

		String password = (String) auth.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, user.getContraseña())) {
			throw new BadCredentialsException("Wrong password");
		}

		List<GrantedAuthority> roles = new ArrayList<>();

		if (user.isPrioridad()) {

			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			return new UsernamePasswordAuthenticationToken(user.getUsuario(), password, roles);
		}else{
			
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));

			return new UsernamePasswordAuthenticationToken(user.getUsuario(), password, roles);
		}

	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}
