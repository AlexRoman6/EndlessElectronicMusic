package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostConstruct
	public void init() {
		repository.save(new Usuario("Fran", "fmt@test.com", "1234", true, true));
	}

	@RequestMapping("/user-account")
	public ModelAndView printUserAccount(HttpServletRequest request) {

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		List<Usuario> users = repository.findAll();
		Usuario user = users.get(0);

		result.addObject("user", user);

		return result;

	}

	@PostMapping("/user-account")
	public ModelAndView changePass(HttpServletRequest request) {
		
		List<Usuario> users = repository.findAll();
		Usuario user = users.get(0);
		
		String oldPass = request.getParameter("oldPass");
		String newPass1 = request.getParameter("newPass1");
		String newPass2 = request.getParameter("newPass2");
		
		if(oldPass.equals(user.getContraseña())){
			if(newPass1.equals(newPass2)){
				repository.setPassUserByID(newPass1, user.getId());
				System.out.println("CAMBIOOOOOO");
			}
		}
		
		

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		

		result.addObject("user", user);

		return result;

	}

}
