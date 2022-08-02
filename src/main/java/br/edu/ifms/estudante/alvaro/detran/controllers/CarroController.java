package br.edu.ifms.estudante.alvaro.detran.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.estudante.alvaro.detran.models.CarroModel;
import br.edu.ifms.estudante.alvaro.detran.repositories.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {
	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping
	@RolesAllowed({"ROLE_ADMIN", "ROLE_TEACHER", "ROLE_STUDENT"})
	public List<CarroModel> listar() {
		return carroRepository.findAll();
	}
	
	@PostMapping
	@RolesAllowed("ROLE_ADMIN")
	public CarroModel salvar(CarroModel carro) {
		return carroRepository.save(carro);
	}
	
}
