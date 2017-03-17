package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;
import dad.endlessElectronicMusic.socket.MailSender;

@Controller
public class ControllerUserRegister {

	@Autowired
	private UsuarioRepository userRepo;

	@RequestMapping("/user-register")
	public ModelAndView printUserRegister(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		ControllerIndex.renderUsuarios(request, result);

		return result;

	}

	@PostMapping("/register")
	public String newUser(@RequestParam String userReg, @RequestParam String mailReg, @RequestParam String passReg) {

		Usuario u = new Usuario(userReg, mailReg, passReg, true, false);
		
		MailSender.mailSender(userReg, mailReg);

		userRepo.save(u);

		return "redirect:/index.html";
	}

	@RequestMapping("/login")
	public String login() {
		
		
		return "redirect:/user-register.html";
	}
	
}
