package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerUserAccount {

	@Autowired
	private UsuarioRepository repository;

	@RequestMapping("/user-account")
	public ModelAndView printUserAccount(HttpServletRequest request, HttpSession sesion) {

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		String userName = ControllerIndex.renderUsuarios(request, result);
		String error = "Sin errores";
		

		result.addObject("error", error);
		
		Usuario u = repository.findByUsuario(userName);
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}
		
		if(u != null){

			result.addObject("uData", u);
		}

		return result;

	}

	@PostMapping("/user-account")
	public ModelAndView changePass(HttpServletRequest request, HttpSession sesion) {

		ModelAndView result = new ModelAndView();
		
		Usuario u = repository.findByUsuario(ControllerIndex.renderUsuarios(request, result));

		String oldPass = request.getParameter("oldPass");
		String newPass1 = request.getParameter("newPass1");
		String newPass2 = request.getParameter("newPass2");

		String error = "Sin errores";

		if (oldPass.isEmpty() || newPass1.isEmpty() || newPass2.isEmpty()) {
			error = "No se han detectado todos los campos de contraseña";
		} else {
			if (new BCryptPasswordEncoder().matches(oldPass, u.getContraseña())) {
				if (newPass1.equals(newPass2)) {
					repository.updatePass(new BCryptPasswordEncoder().encode(newPass1), u.getId());
					error = "Contraseña cambiada correctamente";
				} else {
					error = "Las nuevas contraseñas no coinciden";
				}
			} else {
				error = "La contraseña anterior no coincide con las nuevas";
			}
		}

		result.addObject("resources", request.getContextPath() + "/resources");

		result.addObject("uData", u);
		result.addObject("error", error);
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());

		return result;

	}

}
