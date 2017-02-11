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
	
	
	@Autowired
	private CancionRepository cancionRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	
	@PostConstruct 
	public void init(){
		
		Artista martin =new Artista("Martin Garrix","Holanda","Big Room");
		Artista brennan= new Artista("Brennan Heart","Holanda","Hardstyle");
		artistaRepository.save(martin);
		artistaRepository.save(brennan);
		Cancion animals= new Cancion("Animals",null,"Big Room",2013,new Date (11/02/2017),0,"martin_garrix_animals.jpg","https://www.youtube.com/watch?v=gCYcHz2k5x0");
		Cancion imaginary= new Cancion("Imaginary",null,"Hardstyle",2013,new Date (11/02/2017),0,"brennan_heart.jpeg","https://www.youtube.com/watch?v=h9I-9Sj4sKs");
		animals.setArtista(martin);
		imaginary.setArtista(brennan);
		cancionRepository.save(imaginary);
		
		
	}
	
	
	
	@RequestMapping("/songs-detail")
	public ModelAndView printSongDetail(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}

}
