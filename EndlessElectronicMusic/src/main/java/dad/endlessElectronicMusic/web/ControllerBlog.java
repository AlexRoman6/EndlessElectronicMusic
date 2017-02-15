package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerBlog {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	private String sLogin = "Iniciar Sesión";
	private String sRegister = "Registrarse";
	private String sPathRegister = "user-register.html";
	private String sPathLogin = "#";
	private String toModal = "#login-modal";
	private String modal = "modal";

	@RequestMapping("/blog")
	public ModelAndView printBlog(HttpServletRequest request, HttpSession sesion, @RequestParam String type) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		ControllerIndex.loginString(sLogin, sRegister, sPathRegister, sPathLogin, toModal, modal, result, sesion,
				usuarioRepository);

		if (type.equals("eventos")) {

			List<Evento> eventos = eventoRepository.findAll();
			result.addObject("evento", eventos);
		} else {

			List<Post> posts = postRepository.findAll();

			result.addObject("evento", posts);
		}

		result.addObject("type", type);

		return result;

	}

}
