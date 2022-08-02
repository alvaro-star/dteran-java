package br.edu.ifms.estudante.alvaro.detran.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.estudante.alvaro.detran.dtos.MultaDto;
import br.edu.ifms.estudante.alvaro.detran.models.CarroModel;
import br.edu.ifms.estudante.alvaro.detran.models.InfracaoModel;
import br.edu.ifms.estudante.alvaro.detran.models.MultaModel;
import br.edu.ifms.estudante.alvaro.detran.repositories.CarroRepository;
import br.edu.ifms.estudante.alvaro.detran.repositories.InfracaoRepository;
import br.edu.ifms.estudante.alvaro.detran.repositories.MultaRepository;

@RestController
@RequestMapping("/multa")
public class MultaController {

	@Autowired
	private MultaRepository multaRepository;
	@Autowired
	private CarroRepository carroRepository;
	@Autowired
	private InfracaoRepository infracaoRepository;
	
	
	
	@GetMapping
	public ResponseEntity<List<MultaModel>> getAllMultas(){
		return ResponseEntity.status(HttpStatus.OK).body(multaRepository.findAll());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Object> getOneMulta(@PathVariable(value = "id") Integer id){
    	Optional<MultaModel> multaModelOptional = multaRepository.findById(id);
    	if(!multaModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Multa not found");
    	}
    	return ResponseEntity.status(HttpStatus.OK).body(multaModelOptional.get());
    }
	
	@PostMapping
    public ResponseEntity<Object> saveMulta(@RequestBody @Valid MultaDto multaDto){
		
		Optional<CarroModel> carroModelOptional = carroRepository.findById(multaDto.getIdCarro());
		if(!carroModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not_found the car");
		}
		
		Optional<InfracaoModel> infracaoModelOptional = infracaoRepository.findById(multaDto.getIdInfracao());
		if(!infracaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not_found infracao");
		}
		
		var multaModel = new MultaModel();
		multaModel.setCidade(multaDto.getCidade());
		multaModel.setAno(multaDto.getAno());
		multaModel.setCarro(carroModelOptional.get());
		multaModel.setInfracao(infracaoModelOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(multaRepository.save(multaModel));
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") Integer id, 
    												@RequestBody @Valid MultaDto multaDto){
    	Optional<MultaModel> multaModelOptional = multaRepository.findById(id);
    	if(!multaModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Multa not found");
    	}
    	
    	
		Optional<CarroModel> carroModelOptional = carroRepository.findById(multaDto.getIdCarro());
		if(!carroModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not_found the car");
		}
		
		Optional<InfracaoModel> infracaoModelOptional = infracaoRepository.findById(multaDto.getIdInfracao());
		if(!infracaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not_found infracao");
		}
		
    	var multaModel = new MultaModel();
    	multaModel.setId(multaModelOptional.get().getId());
    	multaModel.setCidade(multaDto.getCidade());
    	multaModel.setAno(multaDto.getAno());
    	multaModel.setCarro(carroModelOptional.get());
		multaModel.setInfracao(infracaoModelOptional.get());
    	
    	return ResponseEntity.status(HttpStatus.OK).body(multaRepository.save(multaModel));
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") Integer id){
    	Optional<MultaModel> multaModelOptional = multaRepository.findById(id);
    	if(!multaModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    	}
    	multaRepository.delete(multaModelOptional.get());
    	return ResponseEntity.status(HttpStatus.OK).body("Deleted succesfully");
    }
}
