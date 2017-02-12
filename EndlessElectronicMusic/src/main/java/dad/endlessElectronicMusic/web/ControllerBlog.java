package dad.endlessElectronicMusic.web;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;
*/
@Controller
public class ControllerBlog {
	/*
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public List<Evento> eventos() {
		return eventoRepository.findAll();
	}
	
	@GetMapping
	public List<Post> posts() {
		return postRepository.findAll();
	}
	*/
	@RequestMapping("/blog")
	public ModelAndView printBlog(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}

}
