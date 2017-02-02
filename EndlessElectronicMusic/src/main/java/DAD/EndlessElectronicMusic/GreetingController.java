package DAD.EndlessElectronicMusic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting(Model model) {

		model.addAttribute("banner", "Esto lo está editando el programa");

		return "index";
	}

}
