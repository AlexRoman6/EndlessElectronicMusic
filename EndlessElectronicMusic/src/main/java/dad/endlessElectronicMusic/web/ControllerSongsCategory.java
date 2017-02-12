package dad.endlessElectronicMusic.web;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;

@Controller
public class ControllerSongsCategory {

	@Autowired
	CancionRepository repository;

	@RequestMapping("/songs-category")
	public ModelAndView printSongCategory(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		return result;

	}

	@GetMapping("/songs-category/{tipo}")
	public String enlace(Model model, @RequestParam String tipo) {
		
		List<Cancion> genero = repository.findAll(new Sort("tipo"));
		
		model.addAttribute("cancion", genero);

		return "songs-category";
	}
}
