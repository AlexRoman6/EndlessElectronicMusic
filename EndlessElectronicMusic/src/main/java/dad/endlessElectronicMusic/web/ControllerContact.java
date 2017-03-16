package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerContact {


	@RequestMapping("/contact")
	public ModelAndView printContact(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		ControllerIndex.renderUsuarios(request, result);

		return result;

	}

}
