package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;

@Controller
public class ControllerSongsCategory {

	@Autowired
	private CancionRepository cancionRepository;


	@RequestMapping("/songs-category")
	public ModelAndView printSongCategory(HttpServletRequest request, HttpSession sesion, @RequestParam String filter) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		result.addObject("upload", request.getContextPath() + "/upload");

		List<Cancion> canciones;
		if(filter.equals("valoracion") || filter.equals("anio")){
			canciones=cancionRepository.findAll(new Sort(new Order(Sort.Direction.DESC, filter)));
		}
		else{
		 canciones = cancionRepository.findAll(new Sort(filter));
		}
		result.addObject("cancion", canciones);

		result.addObject("total", canciones.size());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		ControllerIndex.renderUsuarios(request, result);
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}

		return result;

	}
	
	

}
