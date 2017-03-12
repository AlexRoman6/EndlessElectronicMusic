package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerUserWishList {


	@RequestMapping("/user-wishlist")
	public ModelAndView printUserWishlist(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");


		return result;

	}

}
