package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;

@Controller
public class ControllerBlog {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private PostRepository postRepository;


	@RequestMapping("/blog")
	public ModelAndView printBlog(HttpServletRequest request, HttpSession sesion, @RequestParam String type) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		result.addObject("upload", request.getContextPath() + "/upload");

		if (type.equals("eventos")) {

			List<Evento> eventos = eventoRepository.findAll();
			result.addObject("evento", eventos);
		} else {

			List<Post> posts = postRepository.findAll();

			result.addObject("evento", posts);
		}

		result.addObject("type", type);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		ControllerIndex.renderUsuarios(request, result);

		return result;

	}

}
