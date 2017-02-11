package dad.endlessElectronicMusic.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerWeb {

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/index.html";

	}

}