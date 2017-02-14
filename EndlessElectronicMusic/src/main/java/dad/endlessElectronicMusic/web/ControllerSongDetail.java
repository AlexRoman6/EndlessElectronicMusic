package dad.endlessElectronicMusic.web;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Artista;
import dad.endlessElectronicMusic.entidades.ArtistaRepository;
import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;

@Controller
public class ControllerSongDetail {
	
	@Autowired
	private CancionRepository cancionRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	
	@RequestMapping("/songs-detail")
	public ModelAndView printSongDetail(HttpServletRequest request, @RequestParam Long filter) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		Cancion cancion = cancionRepository.findOne(filter);
		result.addObject("cancion", cancion);
		return result;
		
	}

}
