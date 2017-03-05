package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerAdmin {

	@RequestMapping("/admin")
	public String adminIndex(Model model) {
		return "redirect:/admin/tables.html";

	}

	@RequestMapping("/admin/tables")
	public ModelAndView printAdminTables(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		return result;

	}

	@RequestMapping("/admin/dropzone")
	public ModelAndView printAdminDropzone(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

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
