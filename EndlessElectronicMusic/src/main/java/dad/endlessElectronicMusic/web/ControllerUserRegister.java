package dad.endlessElectronicMusic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerUserRegister {

	@Value("${dad.servicio.url}")
	private String urlServicio;

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

		int arroba = mailReg.indexOf("@");
		String uMail = mailReg.substring(0, arroba);
		String ext = mailReg.substring(arroba+1, mailReg.length());

		int punto = ext.indexOf(".");
		String server = ext.substring(0, punto);
		ext = ext.substring(punto + 1, ext.length());
		
		
		String urlFinal = urlServicio + "/user/" + userReg + "/mail/" + uMail + "/"+ server +"/" + ext;

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(urlFinal, String.class);

		userRepo.save(u);

		return "redirect:/index.html";
	}

	@RequestMapping("/login")
	public String login() {

		return "redirect:/user-register.html";
	}

}
