package dad.endlessElectronicMusic.web;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
	   Random numAleatorio = new Random();
      
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
		
		String nombre=cancion.getNombreAutor();
		List<Cancion> cancionartista=cancionRepository.findAllByNombreAutor(nombre);
		cancionartista.remove(cancion);
		Cancion cancionartista1;
		if (cancionartista.size()==0){
			cancionartista1=null;
		}else
		{
			cancionartista1=cancionartista.get(numAleatorio.nextInt(cancionartista.size()));
		}
		result.addObject("cancionartista",cancionartista1);
		
		String genero=cancion.getGenero();
		List<Cancion> canciongenero=cancionRepository.findAllByGenero(genero);
		canciongenero.remove(cancion);
		Cancion canciongenero1;
		if (canciongenero.size()==0){
			canciongenero1=null;
		}else
		{
			canciongenero1=canciongenero.get(numAleatorio.nextInt(canciongenero.size()));
		}
		result.addObject("canciongenero",canciongenero1);
		
	
		return result;
		
	}

}
