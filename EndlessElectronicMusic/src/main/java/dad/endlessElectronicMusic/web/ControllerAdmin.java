package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerAdmin {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/admin")
	public String adminIndex(Model model) {
		return "redirect:/admin/tables.html";

	}

	@RequestMapping("/admin/tables")
	public ModelAndView printAdminTables(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
	List<Usuario>totalusuarios=usuarioRepository.findAll();
	result.addObject("usuarios", totalusuarios);
		return result;

	}

	@RequestMapping("/admin/addUserSong")
	public ModelAndView printAdminAddUserSong(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		return result;

	}

	@RequestMapping("/admin/gallery")
	public ModelAndView printAdminGallery(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		return result;

	}

	@RequestMapping("/admin/addPost")
	public ModelAndView printAdminAddPost(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		return result;

	}

}
