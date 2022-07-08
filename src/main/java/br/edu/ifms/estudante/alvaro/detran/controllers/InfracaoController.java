package br.edu.ifms.estudante.alvaro.detran.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.estudante.alvaro.detran.models.Infracao;
import br.edu.ifms.estudante.alvaro.detran.repositorys.Infracoes;

@Controller
public class InfracaoController {
	@Autowired
	private Infracoes infracoes;
	
	@GetMapping("/infracao/infracoes")
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("infracao/ListaInfracoes");
		modelAndView.addObject("infracoes", infracoes.findAll());
		return modelAndView;
	}
	
	@PostMapping("/infracao/infracoes")
	public String salvar(Infracao infracao) {
		this.infracoes.save(infracao);
		return "redirect:infracao/infracoes";
	}
	
	@RequestMapping("/infracao/insert")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("infracao/form");
		modelAndView.addObject("infracao", new Infracao());
		return modelAndView;
	}
}
