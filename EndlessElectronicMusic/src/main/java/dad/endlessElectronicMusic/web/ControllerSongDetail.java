package dad.endlessElectronicMusic.web;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerSongDetail {
	Random numAleatorio = new Random();

	@Autowired
	private CancionRepository cancionRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	private String sLogin = "Iniciar Sesión";
	private String sRegister = "Registrarse";
	private String sPathRegister = "user-register.html";
	private String sPathLogin = "#";
	private String toModal = "#login-modal";
	private String modal = "modal";

	@RequestMapping("/songs-detail")
	public ModelAndView printSongDetail(HttpServletRequest request, HttpSession sesion, @RequestParam Long filter) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		ControllerIndex.loginString(sLogin, sRegister, sPathRegister, sPathLogin, toModal, modal, result, sesion,
				usuarioRepository);

		Cancion cancion = cancionRepository.findOne(filter);
		result.addObject("cancion", cancion);

		String nombre = cancion.getNombreAutor();
		List<Cancion> cancionartista = cancionRepository.findAllByNombreAutor(nombre);
		cancionartista.remove(cancion);
		Cancion cancionartista1;
		if (cancionartista.size() == 0) {
			cancionartista1 = null;
		} else {
			cancionartista1 = cancionartista.get(numAleatorio.nextInt(cancionartista.size()));
		}
		result.addObject("cancionartista", cancionartista1);

		String genero = cancion.getGenero();
		List<Cancion> canciongenero = cancionRepository.findAllByGenero(genero);
		canciongenero.remove(cancion);
		Cancion canciongenero1;
		if (canciongenero.size() == 0) {
			canciongenero1 = null;
		} else {
			canciongenero1 = canciongenero.get(numAleatorio.nextInt(canciongenero.size()));
		}
		result.addObject("canciongenero", canciongenero1);
		result.addObject("id", filter);

		return result;

	}

	@RequestMapping("/vote")
	public ModelAndView voteSong(HttpServletRequest request, HttpSession sesion, @RequestParam int vote,
			@RequestParam Long id) {

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		Cancion c = cancionRepository.findOne(id);

		if (vote == 0) {
			cancionRepository.updateVote(c.getValoracion() - 1, id);
		} else {
			cancionRepository.updateVote(c.getValoracion() + 1, id);
		}

		result.addObject("id", id);

		return result;

	}

}
