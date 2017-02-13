package dad.endlessElectronicMusic.web;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.ComentarioEvento;
import dad.endlessElectronicMusic.entidades.ComentarioEventoRepository;
import dad.endlessElectronicMusic.entidades.ComentarioPost;
import dad.endlessElectronicMusic.entidades.ComentarioPostRepository;
import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;
import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerBlog {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ComentarioEventoRepository comentarioEventoRepository;
	
	@Autowired
	private ComentarioPostRepository comentarioPostRepository;
	
	@PostConstruct
	public void init() {
		
		
		Date fecha1 = new Date (21/07/2017);
		Date fecha2 = new Date (13/02/2017);
		
		Evento evento1 = new Evento("Tomorrowland", "Bélgica", fecha1, "El mejor festival de Europa");
		Post post1 = new Post("Nuevo tema", fecha2, "El último hit de este mes");
		
		eventoRepository.save(evento1);
		postRepository.save(post1);
		
		Usuario usuario1 = new Usuario("Alex", "arm@test.com", "1234", true, true);		
		usuarioRepository.save(usuario1);
		
		ComentarioEvento c1 = new ComentarioEvento(usuario1, "Qué ganas!");
		ComentarioPost c2 = new ComentarioPost(usuario1, "Temazo!");
		
		c1.setEvento(evento1);
		c2.setPost(post1);
		
		comentarioEventoRepository.save(c1);
		comentarioPostRepository.save(c2);				
		
	}
		
	public List<Evento> eventos() {
		return eventoRepository.findAll();
	}
		
	public List<Post> posts() {
		return postRepository.findAll();
	}
	
	@RequestMapping("/blog")
	public ModelAndView printBlog(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}

}
