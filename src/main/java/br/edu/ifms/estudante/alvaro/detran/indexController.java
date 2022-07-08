package br.edu.ifms.estudante.alvaro.detran;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
