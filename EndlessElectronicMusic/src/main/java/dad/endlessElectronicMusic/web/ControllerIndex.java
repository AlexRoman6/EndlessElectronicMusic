package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
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
	private String modal = "modal";

	@RequestMapping("/index")
	public ModelAndView printWelcome(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		loginString(sLogin, sRegister, sPathRegister, sPathLogin, toModal, modal, result, sesion, repositoryUsers);

		List<Cancion> cancionesnuevas = repositoryCancion.findAll(new Sort(new Order(Sort.Direction.DESC, "id")));
		List<Cancion> cancionesnuevas1 = cancionesnuevas.subList(0, 3);
		List<Post> postnuevos = repositoryPost.findAll(new Sort(new Order(Sort.Direction.DESC, "id")));
		List<Post> postnuevos1 = postnuevos.subList(0, 2);
		result.addObject("numUsers", repositoryUsers.findAll().size());
		result.addObject("numEventos", repositoryEventos.findAll().size());
		result.addObject("numBlogs", repositoryPost.findAll().size());
		result.addObject("numSongs", repositoryCancion.findAll().size());
		result.addObject("canciones", cancionesnuevas1);
		result.addObject("post", postnuevos1);

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

		loginString(sLogin, sRegister, sPathRegister, sPathLogin, toModal, modal, result, sesion, repositoryUsers);

		result.addObject("numUsers", repositoryUsers.findAll().size());
		result.addObject("numEventos", repositoryEventos.findAll().size());
		result.addObject("numBlogs", repositoryPost.findAll().size());
		result.addObject("numSongs", repositoryCancion.findAll().size());
		result.addObject("canciones", repositoryCancion.findAll(new Sort("addSong")));
		result.addObject("post", repositoryPost.findAll(new Sort("fecha")));

		return result;

	}

	@RequestMapping("/logout")
	public String cerrarSesion(Model model, HttpSession sesion) {

		sesion.setAttribute("idUser", null);

		return "logout";
	}

	public static void loginString(String sLogin, String sRegister, String sPathRegister, String sPathLogin,
			String toModal, String modal, ModelAndView result, HttpSession sesion, UsuarioRepository repositoryUsers) {

		Long idUser = (Long) sesion.getAttribute("idUser");

		if (idUser != null) {

			Usuario u = repositoryUsers.findOne(idUser);
			sLogin = u.getUsuario().toUpperCase();
			sRegister = "Cerrar Sesión";
			sPathRegister = "logout.html";
			sPathLogin = "user-account.html";
			toModal = "";
			modal = "";

		} else {
			sLogin = "Iniciar Sesión";
			sRegister = "Registrarse";
			sPathRegister = "user-register.html";
			sPathLogin = "#";
			toModal = "#login-modal";
			modal = "modal";
		}

		result.addObject("sLogin", sLogin);
		result.addObject("sRegister", sRegister);
		result.addObject("SPathRegister", sPathRegister);
		result.addObject("SPathLogin", sPathLogin);
		result.addObject("toModal", toModal);
		result.addObject("modal", modal);

	}
}
