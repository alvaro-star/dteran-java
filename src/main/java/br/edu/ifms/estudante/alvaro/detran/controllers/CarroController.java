package br.edu.ifms.estudante.alvaro.detran.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.estudante.alvaro.detran.models.Carro;
import br.edu.ifms.estudante.alvaro.detran.repositorys.Carros;

@Controller
public class CarroController {
	@Autowired
	private Carros carros;
	
	@GetMapping("/carro/carros")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("carro/ListaCarros");
		modelAndView.addObject("carros", carros.findAll());
		return modelAndView;
	}
	
	@PostMapping("/carro/carros")
	public String salvar(Carro carro) {
		this.carros.save(carro);
		return "redirect:/carro/carros";
	}
	
	@RequestMapping("/carro/insert")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("carro/form");
		modelAndView.addObject("carro", new Carro());
		return modelAndView;
	}
	
	
}
