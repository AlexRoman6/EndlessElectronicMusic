package dad.endlessElectronicMusic.web;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Artista;
import dad.endlessElectronicMusic.entidades.ArtistaRepository;
import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;

@Controller
public class ControllerSongDetail {
	
	
	@RequestMapping("/songs-detail")
	public ModelAndView printSongDetail(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}

}
