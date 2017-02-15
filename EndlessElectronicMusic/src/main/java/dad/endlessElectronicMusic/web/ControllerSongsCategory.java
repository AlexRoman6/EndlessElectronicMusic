package dad.endlessElectronicMusic.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Artista;
import dad.endlessElectronicMusic.entidades.ArtistaRepository;
import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerSongsCategory {

	@Autowired
	private CancionRepository cancionRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	private String sLogin = "Iniciar Sesión";
	private String sRegister = "Registrarse";
	private String sPathRegister = "user-register.html";
	private String sPathLogin = "#";
	private String toModal = "#login-modal";
	private String modal = "modal";

	@PostConstruct
	public void init() {

		Artista martin = new Artista("Martin Garrix", "Holanda", "Big Room");
		Artista brennan = new Artista("Brennan Heart", "Holanda", "Hardstyle");
		Artista hardwell = new Artista("Hardwell", "Holanda", "Electro House");
		artistaRepository.save(martin);
		artistaRepository.save(brennan);
		artistaRepository.save(hardwell);
		Cancion animals = new Cancion("Animals", martin, martin.getNombre(), "Big Room", 2013, new Date(11 / 02 / 2017),
				0, "martin_garrix_animals.jpg", "https://www.youtube.com/watch?v=gCYcHz2k5x0");
		Cancion imaginary = new Cancion("Imaginary", brennan, brennan.getNombre(), "Hardstyle", 2013,
				new Date(11 / 02 / 2017), 0, "brennan_heart_imaginary.jpeg",
				"https://www.youtube.com/watch?v=h9I-9Sj4sKs");
		Cancion spaceman = new Cancion("Spaceman", hardwell, hardwell.getNombre(), "Electro House", 2012,
				new Date(13 / 02 / 2017), 0, "hardwell_spaceman.jpg", "https://www.youtube.com/watch?v=lETmskoqh30");
		Cancion losemymind = new Cancion("Lose My Mind", brennan, brennan.getNombre(), "Hardstyle", 2011,
				new Date(14 / 02 / 2017), 0, "brennan_heart_lose_my_mind.jpg",
				"https://www.youtube.com/watch?v=JP6Tz5tP8EE");
		cancionRepository.save(imaginary);
		cancionRepository.save(animals);
		cancionRepository.save(spaceman);
		cancionRepository.save(losemymind);

	}

	@RequestMapping("/songs-category")
	public ModelAndView printSongCategory(HttpServletRequest request, HttpSession sesion, @RequestParam String filter) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		ControllerIndex.loginString(sLogin, sRegister, sPathRegister, sPathLogin, toModal, modal, result, sesion,
				usuarioRepository);

		List<Cancion> canciones = cancionRepository.findAll(new Sort(filter));
		result.addObject("cancion", canciones);

		result.addObject("total", canciones.size());

		return result;

	}

}
