package dad.endlessElectronicMusic.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String dateInString1 = "21-07-2017";
		Date fecha1 = null;

		try {
			fecha1 = sdf.parse(dateInString1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String dateInString2 = "27-01-2017";
		Date fecha2 = null;

		try {
			fecha2 = sdf.parse(dateInString2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String dateInString3 = "24-03-2017";
		Date fecha3 = null;

		try {
			fecha3 = sdf.parse(dateInString3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String dateInString4 = "22-09-2016";
		Date fecha4 = null;

		try {
			fecha4 = sdf.parse(dateInString4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Evento evento1 = new Evento("Tomorrowland", "Bélgica", fecha1, "Tomorrowland.jpg", "El mejor festival de Europa"
		+ " regresa. Los mejores artista del panorama internacional se citan un año más en Bélgica.");
		Post post1 = new Post("Scared To Be Lonely", fecha2, "ScaredToBeLonely.jpg", "Lo último de Martin Garrix. "
		+ "Junto a Dua Lipa, el joven Dj holandés quiere comenzar el año a lo grande");
		Evento evento2 = new Evento("UMF", "Miami", fecha3, "Ultra.jpg", "La reunión de los mejores DJs y "
		+ "productores del mundo vuelve a Miami para hacernos disfrutar durante tres días.");
		Post post2 = new Post("Do It Right", fecha4, "DoItRight.png", "El último tema del productor y DJ francés "
		+ "Martin Solveig, junto con Tkay Maidza, por fín ha llegado");

		eventoRepository.save(evento1);
		eventoRepository.save(evento2);
		postRepository.save(post1);
		postRepository.save(post2);

		Usuario usuario1 = new Usuario("Alex", "arm@test.com", "1234", true, true);
		usuarioRepository.save(usuario1);

		ComentarioEvento c1 = new ComentarioEvento(usuario1, "Qué ganas!");
		ComentarioPost c2 = new ComentarioPost(usuario1, "Temazo!");
		ComentarioEvento c3 = new ComentarioEvento(usuario1, "Ya falta menos!");
		ComentarioPost c4 = new ComentarioPost(usuario1, "Brutal!");

		c1.setEvento(evento1);
		c2.setPost(post1);
		c3.setEvento(evento2);
		c4.setPost(post2);

		comentarioEventoRepository.save(c1);
		comentarioPostRepository.save(c2);
		comentarioEventoRepository.save(c3);
		comentarioPostRepository.save(c4);

	}

	@RequestMapping("/blog")
	public ModelAndView printBlog(HttpServletRequest request, @RequestParam String type) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		if (type.equals("eventos")) {

			List<Evento> eventos = eventoRepository.findAll();
			result.addObject("evento", eventos);
		} else {

			List<Post> posts = postRepository.findAll();

			result.addObject("evento", posts);
		}

		return result;

	}

}
