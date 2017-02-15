package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.ComentarioEvento;
import dad.endlessElectronicMusic.entidades.ComentarioPost;
import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;

@Controller
public class ControllerBlogPost {

	@Autowired
	private PostRepository repositoryPost;

	@Autowired
	private EventoRepository repositoryEventos;

	@RequestMapping("/blog-post")
	public ModelAndView printPost(HttpServletRequest request, @RequestParam String type, @RequestParam String id) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		if(type.equals("posts")){
			
			Post p = repositoryPost.findOne(Long.parseLong(id, 10));
			List<ComentarioPost> c = p.getComentarios();
			
			result.addObject("post", p);
			result.addObject("numComentarios", c.size());
			result.addObject("comentarios", c);
		
		}else{
			
			Evento e = repositoryEventos.findOne(Long.parseLong(id, 10));
			List<ComentarioEvento> c = e.getComentarios();
			
			result.addObject("post", e);
			result.addObject("numComentarios", c.size());
			result.addObject("comentarios", c);
			
		}
		
		result.addObject("type", type);
		
		return result;
		
	}

}
