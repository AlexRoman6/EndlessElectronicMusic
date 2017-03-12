package dad.endlessElectronicMusic.web;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;

@Controller
public class ControllerSongDetail {
	Random numAleatorio = new Random();

	@Autowired
	private CancionRepository cancionRepository;

	@RequestMapping("/songs-detail")
	public ModelAndView printSongDetail(HttpServletRequest request, HttpSession sesion, @RequestParam Long filter) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		result.addObject("upload", request.getContextPath() + "/upload");

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
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());  

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
