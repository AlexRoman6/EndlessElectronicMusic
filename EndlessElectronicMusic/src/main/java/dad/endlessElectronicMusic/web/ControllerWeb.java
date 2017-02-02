package dad.endlessElectronicMusic.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerWeb {

	@RequestMapping("/greeting")
	public String greeting(Model model) {

		model.addAttribute("name", "World");

		return "greeting_template";
	}
	
	@RequestMapping("/index")
	public ModelAndView printWelcome(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	
//	public String index(Model model){
//		
//		model.addAttribute("resurces", m)
//		return "index";
//		
//	}

}