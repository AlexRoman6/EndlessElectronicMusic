package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerTeam {

	private String sLogin = "Iniciar Sesión";
	private String sRegister = "Registrarse";
	private String sPathRegister = "user-register.html";
	private String sPathLogin = "#";
	private String toModal = "#login-modal";
	private String modal = "modal";

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/team")
	public ModelAndView printTeam(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		ControllerIndex.loginString(sLogin, sRegister, sPathRegister, sPathLogin, toModal, modal, result, sesion,
				usuarioRepository);

		return result;

	}

}
