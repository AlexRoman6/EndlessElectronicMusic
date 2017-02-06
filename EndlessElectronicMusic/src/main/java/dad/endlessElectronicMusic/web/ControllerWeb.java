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
		
		return result ;
		
	}
	
	@RequestMapping("/blog")
	public ModelAndView printBlog(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/blog-post")
	public ModelAndView printPost(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/contact")
	public ModelAndView printContact(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}

	@RequestMapping("/songs-category")
	public ModelAndView printSongCategory(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/songs-detail")
	public ModelAndView printSongDetail(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/team")
	public ModelAndView printTeam(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/team-member")
	public ModelAndView printTeamMember(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/user-account")
	public ModelAndView printUserAccount(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/user-register")
	public ModelAndView printUserRegister(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	@RequestMapping("/user-wishlist")
	public ModelAndView printUserWishlist(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		return result;
		
	}
	
	
//	public String index(Model model){
//		
//		model.addAttribute("resurces", m)
//		return "index";
//	
//	
//	}

}