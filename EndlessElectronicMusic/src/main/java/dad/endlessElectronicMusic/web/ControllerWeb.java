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
import dad.endlessElectronicMusic.entidades.Imagen;
import dad.endlessElectronicMusic.entidades.ImagenRepository;
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
	
	@Autowired
	private ImagenRepository imageRepo;

	@PostConstruct
	public void init() {

		resetDB();
		
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/index.html";

	}

	private void resetDB() {
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
		Artista dimitrivegaslikemike = new Artista("Dimitri Vegas & Like Mike", "Belgica", "Big Room");
		Artista headhunterz = new Artista("Headhunterz", "Holanda", "Hardstyle");
		Artista zatox = new Artista("Zatox", "Italia", "Hardstyle");
		Artista oliverheldens = new Artista("Oliver Heldens", "Holanda", "Future House");
		Artista gunzforhire = new Artista("Gunz for Hire", "Holanda", "Hardstyle");
		Artista ww = new Artista("W&W", "Holanda", "Big Room");
		Artista theprophet = new Artista("The Prophet", "Holanda", "Hardstyle");
		artistRepo.save(martin);
		artistRepo.save(brennan);
		artistRepo.save(hardwell);
		artistRepo.save(dimitrivegaslikemike);
		artistRepo.save(headhunterz);
		artistRepo.save(zatox);
		artistRepo.save(oliverheldens);
		artistRepo.save(gunzforhire);
		artistRepo.save(ww);
		artistRepo.save(theprophet);

		// Create Imágenes
		
		Imagen imagen1 = new Imagen ("martin_garrix_animals.jpg");
		Imagen imagen2 = new Imagen ("brennan_heart_imaginary.jpeg");
		Imagen imagen3 = new Imagen ("hardwell_spaceman.jpg");
		Imagen imagen4 = new Imagen ("brennan_heart_lose_my_mind.jpg");
		Imagen imagen5 = new Imagen ("dimitri_vegas_like_mike_the_hum.jpg");
		Imagen imagen6 = new Imagen ("headhunterz_the_sacrifice.jpg");
		Imagen imagen7 = new Imagen ("martin_garrix_wizard.jpg");
		Imagen imagen8 = new Imagen ("brennan_heart_fifo.jpeg");
		Imagen imagen9 = new Imagen ("brennan_heart_alternate_reality.jpg");
		Imagen imagen10 = new Imagen ("hardwell_apollo.jpg");
		Imagen imagen11 = new Imagen ("dimitri_vegas_like_mike_madness.jpg");
		Imagen imagen12 = new Imagen ("headhunterz_scrap_attack.jpeg");
		Imagen imagen13 = new Imagen ("zatox_rumble_in_the_jungle.jpeg");
		Imagen imagen14 = new Imagen ("zatox_my_strength_is_hardstyle.jpg");
		Imagen imagen15 = new Imagen ("oliver_heldens_melody.jpg");
		Imagen imagen16 = new Imagen ("gunz_for_hire_executioner_style.jpg");
		Imagen imagen17 = new Imagen ("gunz_for_hire_may_god_be_with_you_all.jpg");
		Imagen imagen18 = new Imagen ("ww_caribbean_rave.jpg");
		Imagen imagen19 = new Imagen ("the_prophet_ay_caramba.jpg");
		Imagen imagen20 = new Imagen ("Tomorrowland.jpg");
		Imagen imagen21 = new Imagen ("ScaredToBeLonely.jpg");
		Imagen imagen22 = new Imagen ("Ultra.jpg");
		Imagen imagen23 = new Imagen ("DoItRight.png");
		Imagen imagen24 = new Imagen ("Dreambeach.jpg");
		Imagen imagen25 = new Imagen ("Avicii.jpg");
		imageRepo.save(imagen1);
		imageRepo.save(imagen2);
		imageRepo.save(imagen3);
		imageRepo.save(imagen4);
		imageRepo.save(imagen5);
		imageRepo.save(imagen6);
		imageRepo.save(imagen7);
		imageRepo.save(imagen8);
		imageRepo.save(imagen9);
		imageRepo.save(imagen10);
		imageRepo.save(imagen11);
		imageRepo.save(imagen12);
		imageRepo.save(imagen13);
		imageRepo.save(imagen14);
		imageRepo.save(imagen15);
		imageRepo.save(imagen16);
		imageRepo.save(imagen17);
		imageRepo.save(imagen18);
		imageRepo.save(imagen19);
		imageRepo.save(imagen20);
		imageRepo.save(imagen21);
		imageRepo.save(imagen22);
		imageRepo.save(imagen23);
		imageRepo.save(imagen24);
		imageRepo.save(imagen25);
		
		
		// Create Canción

		Cancion animals = new Cancion("Animals", martin, martin.getNombre(), "Big Room", 2013, new Date(11 / 02 / 2017),
				0, imagen1, "gCYcHz2k5x0");
		Cancion imaginary = new Cancion("Imaginary", brennan, brennan.getNombre(), "Hardstyle", 2013,
				new Date(11 / 02 / 2017), 0, imagen2, "h9I-9Sj4sKs");
		Cancion spaceman = new Cancion("Spaceman", hardwell, hardwell.getNombre(), "Electro House", 2012,
				new Date(13 / 02 / 2017), 0, imagen3, "lETmskoqh30");
		Cancion losemymind = new Cancion("Lose My Mind", brennan, brennan.getNombre(), "Hardstyle", 2011,
				new Date(14 / 02 / 2017), 0, imagen4, "JP6Tz5tP8EE");
		Cancion thehum = new Cancion("The Hum", dimitrivegaslikemike, dimitrivegaslikemike.getNombre(), "Big Room",
				2015, new Date(15 / 02 / 2017), 0, imagen5, "exJlapzPnlc");
		Cancion thesacrifice = new Cancion("The Sacrifice", headhunterz, headhunterz.getNombre(), "Hardstyle", 2006,
				new Date(15 / 02 / 2017), 0, imagen6, "a7uToulRNeQ");
		Cancion wizard = new Cancion("Wizard", martin, martin.getNombre(), "Big Room", 2013, new Date(15 / 02 / 2017),
				0, imagen7, "KnL2RJZTdA4");
		Cancion fifo = new Cancion("F.I.F.O", brennan, brennan.getNombre(), "Hardstyle", 2013, new Date(15 / 02 / 2017),
				0, imagen8, "T3SQZOW-iZk");
		Cancion alternatereality = new Cancion("Alternate Reality", brennan, brennan.getNombre(), "Hardstyle", 2010,
				new Date(15 / 02 / 2017), 0, imagen9, "t2Pavrg02_E");
		Cancion apollo = new Cancion("Apollo", hardwell, hardwell.getNombre(), "Electro House", 2013,
				new Date(15 / 02 / 2017), 0, imagen10, "q8kUckZ15fE");
		Cancion madness = new Cancion("Madness", dimitrivegaslikemike, dimitrivegaslikemike.getNombre(), "Big Room",
				2013, new Date(15 / 02 / 2017), 0, imagen11, "dHDImoc94XQ");
		Cancion scrapattack = new Cancion("Scrap Attack", headhunterz, headhunterz.getNombre(), "Hardstyle", 2009,
				new Date(15 / 02 / 2017), 0, imagen12, "OouY9rwIRjA");
		Cancion rumbleinthejungle = new Cancion("Rumble In The Jungle", zatox, zatox.getNombre(), "Hardstyle", 2015,
				new Date(15 / 02 / 2017), 0, imagen13, "EkiKN9sVFu0");
		Cancion mystrengthishardstyle = new Cancion("My Strength Is Hardstyle", zatox, zatox.getNombre(), "Hardstyle",
				2016, new Date(15 / 02 / 2017), 0, imagen14, "pKGQlh7xaeE");
		Cancion melody = new Cancion("Melody", oliverheldens, oliverheldens.getNombre(), "Future House", 2015,
				new Date(15 / 02 / 2017), 0, imagen15, "VMnPX3GeyEM");
		Cancion executionerstyle = new Cancion("Executioner Style", gunzforhire, gunzforhire.getNombre(), "Hardstyle",
				2016, new Date(15 / 02 / 2017), 0, imagen16, "snQQsXoU3l8");
		Cancion maygodbewithyouall = new Cancion("May God Be With You All", gunzforhire, gunzforhire.getNombre(),
				"Hardstyle", 2015, new Date(15 / 02 / 2017), 0, imagen17,
				"bp7D-kgQt5A");
		Cancion caribbeanrave = new Cancion("Caribbean Rave", ww, ww.getNombre(), "Big Room", 2016,
				new Date(11 / 02 / 2017), 0, imagen18, "t0thau7RIWA");
		Cancion aycaramba = new Cancion("Ay Caramba!", theprophet, theprophet.getNombre(), "Hardstyle", 2016,
				new Date(15 / 02 / 2017), 0, imagen19, "-06PzCM5Okc");

		songRepo.save(imaginary);
		songRepo.save(animals);
		songRepo.save(spaceman);
		songRepo.save(losemymind);
		songRepo.save(thehum);
		songRepo.save(thesacrifice);
		songRepo.save(wizard);
		songRepo.save(fifo);
		songRepo.save(alternatereality);
		songRepo.save(apollo);
		songRepo.save(madness);
		songRepo.save(scrapattack);
		songRepo.save(rumbleinthejungle);
		songRepo.save(mystrengthishardstyle);
		songRepo.save(melody);
		songRepo.save(executionerstyle);
		songRepo.save(maygodbewithyouall);
		songRepo.save(caribbeanrave);
		songRepo.save(aycaramba);

		// Create PostSimpleDateFormat sdf = new SimpleDateFormat("dd MMM
		// yyyy");

		// recordad que Enero es el mes 0, febrero el 1...
		Date fecha1 = new GregorianCalendar(2017, 6, 21).getTime();
		Date fecha2 = new GregorianCalendar(2017, 0, 27).getTime();
		Date fecha3 = new GregorianCalendar(2017, 2, 24).getTime();
		Date fecha4 = new GregorianCalendar(2016, 8, 22).getTime();
		Date fecha5 = new GregorianCalendar(2017, 7, 10).getTime();
		Date fecha6 = new GregorianCalendar(2017, 1, 1).getTime();

		Evento evento1 = new Evento("Tomorrowland", "Bélgica", fecha1, imagen20, "El mejor festival de Europa"
				+ " regresa. Los mejores artista del panorama internacional se citan un año más en Bélgica.");

		Post post1 = new Post("Scared To Be Lonely", fecha2, imagen21, "Lo último de Martin Garrix. "
				+ "Junto a Dua Lipa, el joven Dj holandés quiere comenzar el año a lo grande");

		Evento evento2 = new Evento("UMF", "Miami", fecha3, imagen22, "La reunión de los mejores DJs y "
				+ "productores del mundo vuelve a Miami para hacernos disfrutar durante tres días.");

		Post post2 = new Post("Do It Right", fecha4, imagen23, "El último tema del productor y DJ francés "
				+ "Martin Solveig, junto con Tkay Maidza, por fín ha llegado");

		Evento evento3 = new Evento("Dreambeach", "Villaricos", fecha5, imagen24,
				"Uno de los grandes festivales "
						+ "de España regresa con los mejores artistas para hacernos pasar un mes de agosto inolvidable en Villaricos.");

		Post post3 = new Post("Avicii trabaja en nueva música", fecha6, imagen25, "El Dj y pruductor sueco "
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

}