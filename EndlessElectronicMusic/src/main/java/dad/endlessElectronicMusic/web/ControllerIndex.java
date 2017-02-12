package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerIndex {
	
	@RequestMapping("/index")
	public ModelAndView printWelcome(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		System.out.println(request.getContextPath() + "/resources");
		
		return result ;
		
	}

}
