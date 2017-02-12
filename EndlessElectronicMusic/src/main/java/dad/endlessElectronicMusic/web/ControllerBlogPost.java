package dad.endlessElectronicMusic.web;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;

@Controller
public class ControllerBlogPost {
	/*
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ComentarioEventoRepository comentarioEventoRepository;
	
	@Autowired
	private ComentarioPostRepository comentarioPostRepository;
	
	@PostConstruct
	public void init() {
		
		Evento evento1 = new Evento("Tomorrowland", "Bélgica", , "El mejor festival de Europa");
		Post post1 = new Post("Nuevo tema", , "El último hit de este mes");
		
		eventoRepository.save(evento1);
		postRepository.save(post1);
		
		ComentarioEvento c1 = new ComentarioEvento(Alex, "Qué ganas!");
		ComentarioPost c2; = new ComentarioPost(Alex, "Temazo")
		
		c1.getEvento().add(evento1);
		c2.getPost().add(post1);
		
		comentarioEventoRepository.save(c1);
		comentarioPostRepository.save(c2);
	}
	*/
	@RequestMapping("/blog-post")
	public ModelAndView printPost(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}

}
