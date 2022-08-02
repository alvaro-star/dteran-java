package br.edu.ifms.estudante.alvaro.detran.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.estudante.alvaro.detran.models.InfracaoModel;
import br.edu.ifms.estudante.alvaro.detran.repositories.InfracaoRepository;

@RestController
public class InfracaoController {
	@Autowired
	private InfracaoRepository infracaoRepository;
	
	@GetMapping
	public List<InfracaoModel> listar() {
		return infracaoRepository.findAll();
	}
	
	@PostMapping
	public InfracaoModel salvar(InfracaoModel infracaoModel) {
		return infracaoRepository.save(infracaoModel);
	}
}
