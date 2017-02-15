package dad.endlessElectronicMusic.web;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dad.endlessElectronicMusic.entidades.Artista;
import dad.endlessElectronicMusic.entidades.ArtistaRepository;
import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
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
public class ControllerWeb {

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private CancionRepository songRepo;

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private EventoRepository eventRepo;

	@Autowired
	private ArtistaRepository artistRepo;

	@Autowired
	private ComentarioEventoRepository comenEvenRepo;

	@Autowired
	private ComentarioPostRepository comenPostRepo;

	@PostConstruct
	public void init() {

		// Create Usuarios

		Usuario fran = new Usuario("fran", "fmt@test.com", "1234", true, true);
		Usuario alex = new Usuario("alex", "arm@test.com", "1234", true, true);
		Usuario david = new Usuario("david", "dvd@test.com", "1234", true, true);

		userRepo.save(fran);
		userRepo.save(alex);
		userRepo.save(david);

		// Create Artistas

		Artista martin = new Artista("Martin Garrix", "Holanda", "Big Room");
		Artista brennan = new Artista("Brennan Heart", "Holanda", "Hardstyle");
		Artista hardwell = new Artista("Hardwell", "Holanda", "Electro House");
		Artista dimitrivegaslikemike= new Artista("Dimitri Vegas & Like Mike","Belgica","Big Room");
		Artista headhunterz =new Artista("Headhunterz","Holanda","Hardstyle");
		artistRepo.save(martin);
		artistRepo.save(brennan);
		artistRepo.save(hardwell);
		artistRepo.save(dimitrivegaslikemike);
		artistRepo.save(headhunterz);

		// Create Canción

		Cancion animals = new Cancion("Animals", martin, martin.getNombre(), "Big Room", 2013, new Date(11 / 02 / 2017),
				0, "martin_garrix_animals.jpg", "gCYcHz2k5x0");
		Cancion imaginary = new Cancion("Imaginary", brennan, brennan.getNombre(), "Hardstyle", 2013,
				new Date(11 / 02 / 2017), 0, "brennan_heart_imaginary.jpeg",
				"h9I-9Sj4sKs");
		Cancion spaceman = new Cancion("Spaceman", hardwell, hardwell.getNombre(), "Electro House", 2012,
				new Date(13 / 02 / 2017), 0, "hardwell_spaceman.jpg", "lETmskoqh30");
		Cancion losemymind = new Cancion("Lose My Mind", brennan, brennan.getNombre(), "Hardstyle", 2011,
				new Date(14 / 02 / 2017), 0, "brennan_heart_lose_my_mind.jpg",
				"JP6Tz5tP8EE");
		Cancion thehum= new Cancion("The Hum",dimitrivegaslikemike,dimitrivegaslikemike.getNombre(),"Big Room",2015,
				new Date(15/02/ 2017),0,"dimitri_vegas_like_mike_the_hum.jpg","exJlapzPnlc");
		Cancion thesacrifice= new Cancion("The Sacrifice",headhunterz,headhunterz.getNombre(),"Hardstyle",2006,
				new Date(15/02/ 2017),0,"headhunterz_the_sacrifice.jpg","a7uToulRNeQ");
		songRepo.save(imaginary);
		songRepo.save(animals);
		songRepo.save(spaceman);
		songRepo.save(losemymind);
		songRepo.save(thehum);
		songRepo.save(thesacrifice);

		// Create PostSimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		
		//recordad que Enero es el mes 0, febrero el 1...
		Date fecha1 = new GregorianCalendar(2017, 6, 21).getTime();
		Date fecha2 = new GregorianCalendar(2017, 0, 27).getTime();
		Date fecha3 = new GregorianCalendar(2017, 2, 24).getTime();
		Date fecha4 = new GregorianCalendar(2016, 8, 22).getTime();
		Date fecha5 = new GregorianCalendar(2017, 7, 10).getTime();
		Date fecha6 = new GregorianCalendar(2017, 1, 1).getTime();

		Evento evento1 = new Evento("Tomorrowland", "Bélgica", fecha1, "Tomorrowland.jpg", "El mejor festival de Europa"
				+ " regresa. Los mejores artista del panorama internacional se citan un año más en Bélgica.");
		
		Post post1 = new Post("Scared To Be Lonely", fecha2, "ScaredToBeLonely.jpg", "Lo último de Martin Garrix. "
				+ "Junto a Dua Lipa, el joven Dj holandés quiere comenzar el año a lo grande");
		
		Evento evento2 = new Evento("UMF", "Miami", fecha3, "Ultra.jpg", "La reunión de los mejores DJs y "
				+ "productores del mundo vuelve a Miami para hacernos disfrutar durante tres días.");
		
		Post post2 = new Post("Do It Right", fecha4, "DoItRight.png", "El último tema del productor y DJ francés "
				+ "Martin Solveig, junto con Tkay Maidza, por fín ha llegado");
		
		Evento evento3 = new Evento("Dreambeach", "Villaricos", fecha5, "Dreambeach.jpg", "Uno de los grandes festivales "
				+ "de España regresa con los mejores artistas para hacernos pasar un mes de agosto inolvidable en Villaricos.");
		
		Post post3 = new Post("Avicii trabaja en nueva música", fecha6, "Avicii.jpg", "El Dj y pruductor sueco "
				+ "cuelga varios videos en sus redes sociales en los que aprece elaborando su próximo álbum.");
		
		eventRepo.save(evento1);
		eventRepo.save(evento2);
		eventRepo.save(evento3);
		postRepo.save(post1);
		postRepo.save(post2);
		postRepo.save(post3);

		// Create Comentario

		ComentarioEvento c1 = new ComentarioEvento(fran, "Qué ganas!");
		ComentarioPost c2 = new ComentarioPost(alex, "Temazo!");
		ComentarioEvento c3 = new ComentarioEvento(david, "Ya falta menos!");
		ComentarioPost c4 = new ComentarioPost(alex, "Brutal!");
		ComentarioEvento c5 = new ComentarioEvento(alex, "Vamooossss!!");
		ComentarioPost c6 = new ComentarioPost(david, "Menudo crack! Tengo ganas de ver lo que está preparando.");
		ComentarioEvento c7 = new ComentarioEvento(alex, "Esto pinta bien");
		ComentarioPost c8 = new ComentarioPost(fran, "Se sale!!");
		ComentarioEvento c9 = new ComentarioEvento(alex, "Cómo me gustaría ir :(");
		ComentarioPost c10 = new ComentarioPost(david, "Buenisimooo!!");
		ComentarioEvento c11 = new ComentarioEvento(david, "A ver si empiezan a confirmar artistas.");
		ComentarioPost c12 = new ComentarioPost(fran, "Qué gran noticia.");

		c1.setEvento(evento1);
		c2.setPost(post1);
		c3.setEvento(evento2);
		c4.setPost(post2);
		c5.setEvento(evento3);
		c6.setPost(post3);
		c7.setEvento(evento1);
		c8.setPost(post1);
		c9.setEvento(evento2);
		c10.setPost(post2);
		c11.setEvento(evento3);
		c12.setPost(post3);

		comenEvenRepo.save(c1);
		comenPostRepo.save(c2);
		comenEvenRepo.save(c3);
		comenPostRepo.save(c4);
		comenEvenRepo.save(c5);
		comenPostRepo.save(c6);
		comenEvenRepo.save(c7);
		comenPostRepo.save(c8);
		comenEvenRepo.save(c9);
		comenPostRepo.save(c10);
		comenEvenRepo.save(c11);
		comenPostRepo.save(c12);

	}

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/index.html";

	}

}