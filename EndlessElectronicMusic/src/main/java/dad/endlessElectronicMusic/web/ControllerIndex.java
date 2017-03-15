package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;
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

	@RequestMapping("/index")
	public ModelAndView printWelcome(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		result.addObject("upload", request.getContextPath() + "/upload");

		List<Cancion> cancionesnuevas = repositoryCancion.findAll(new Sort(new Order(Sort.Direction.DESC, "id")));
		List<Cancion> cancionesnuevas1 = cancionesnuevas.subList(0, 3);
		List<Post> postnuevos = repositoryPost.findAll(new Sort(new Order(Sort.Direction.DESC, "id")));
		List<Post> postnuevos1 = postnuevos.subList(0, 3);
		result.addObject("numUsers", repositoryUsers.findAll().size());
		result.addObject("numEventos", repositoryEventos.findAll().size());
		result.addObject("numBlogs", repositoryPost.findAll().size());
		result.addObject("numSongs", repositoryCancion.findAll().size());
		result.addObject("canciones", cancionesnuevas1);
		result.addObject("post", postnuevos1);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());

		return result;

	}
	
}
