package DAD.MailService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TablonController {


	@GetMapping("/")
	public String tablon(Model model) {

		return "tablon";
	}

}