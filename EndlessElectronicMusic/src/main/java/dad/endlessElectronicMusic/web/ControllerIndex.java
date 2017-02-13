package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerIndex {

	@Autowired
	private UsuarioRepository repository;

	// private Long idUser = 0L;

	private String sLogin = "Iniciar Sesión";
	private String sRegister = "Registrarse";
	private String sPathRegister = "user-register.html";
	private String sPathLogin = "#";
	private String toModal = "#login-modal";

	@RequestMapping("/index")
	public ModelAndView printWelcome(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		Long idUser = (Long) sesion.getAttribute("idUser");
		 //Long idUser = 1L;

		if (idUser != null) {

			Usuario u = repository.findOne(idUser);
			sLogin = u.getUsuario().toUpperCase();
			sRegister = "Cerrar Sesión";
			sPathRegister = "logout.html";
			sPathLogin = "user-account.html";
			toModal = "";

		} else {
			sLogin = "Iniciar Sesión";
			sRegister = "Registrarse";
			sPathRegister = "user-register.html";
			sPathLogin = "#";
			toModal = "#login-modal";
		}

		result.addObject("sLogin", sLogin);
		result.addObject("sRegister", sRegister);
		result.addObject("SPathRegister", sPathRegister);
		result.addObject("SPathLogin", sPathLogin);
		result.addObject("toModal", toModal);

		return result;

	}

	@PostMapping("/index")
	public ModelAndView changePass(HttpServletRequest request, HttpSession sesion) {

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		String userName = request.getParameter("campoUser");
		String userPass = request.getParameter("campoPass");

		List<Usuario> lUsers = repository.findByUsuarioAndContraseña(userName, userPass);

		if (lUsers.size() == 1) {
			Usuario user = lUsers.get(0);

			sesion.setAttribute("idUser", user.getId());
		} else {
			sesion.setAttribute("idUser", null);
		}
		
		Long idUser = (Long) sesion.getAttribute("idUser");
		 //Long idUser = 1L;

		if (idUser != null) {

			Usuario u = repository.findOne(idUser);
			sLogin = u.getUsuario().toUpperCase();
			sRegister = "Cerrar Sesión";
			sPathRegister = "logout.html";
			sPathLogin = "user-account.html";
			toModal = "";

		} else {
			sLogin = "Iniciar Sesión";
			sRegister = "Registrarse";
			sPathRegister = "user-register.html";
			sPathLogin = "#";
			toModal = "#login-modal";
		}
		
		result.addObject("sLogin", sLogin);
		result.addObject("sRegister", sRegister);
		result.addObject("SPathRegister", sPathRegister);
		result.addObject("SPathLogin", sPathLogin);
		result.addObject("toModal", toModal);

		return result;

	}

	@RequestMapping("/logout")
	public String cerrarSesion(Model model, HttpSession sesion) {

		sesion.setAttribute("idUser", null);

		return "logout";
	}
}
