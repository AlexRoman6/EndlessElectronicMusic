package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.PostRepository;
import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerIndex {

	@Autowired
	private UsuarioRepository repositoryUsers;
	
	@Autowired
	private CancionRepository repositoryCancion;
	
	@Autowired
	private PostRepository repositoryPost;
	
	@Autowired
	private EventoRepository repositoryEventos;
	
	

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

			Usuario u = repositoryUsers.findOne(idUser);
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

		result.addObject("numUsers", repositoryUsers.findAll().size());
		result.addObject("numEventos", repositoryEventos.findAll().size());
		result.addObject("numBlogs", repositoryPost.findAll().size());
		result.addObject("numSongs", repositoryCancion.findAll().size());
		result.addObject("canciones", repositoryCancion.findAll(new Sort("addSong")));
		result.addObject("post", repositoryPost.findAll(new Sort("fecha")));
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

		List<Usuario> lUsers = repositoryUsers.findByUsuarioAndContraseña(userName, userPass);

		if (lUsers.size() == 1) {
			Usuario user = lUsers.get(0);

			sesion.setAttribute("idUser", user.getId());
		} else {
			sesion.setAttribute("idUser", null);
		}
		
		Long idUser = (Long) sesion.getAttribute("idUser");
		 //Long idUser = 1L;

		if (idUser != null) {

			Usuario u = repositoryUsers.findOne(idUser);
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
		
		result.addObject("numUsers", repositoryUsers.findAll().size());
		result.addObject("numEventos", repositoryEventos.findAll().size());
		result.addObject("numBlogs", repositoryPost.findAll().size());
		result.addObject("numSongs", repositoryCancion.findAll().size());
		result.addObject("canciones", repositoryCancion.findAll(new Sort("addSong")));
		result.addObject("post", repositoryPost.findAll(new Sort("fecha")));
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
