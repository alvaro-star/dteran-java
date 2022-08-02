package br.edu.ifms.estudante.alvaro.detran.auth;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.estudante.alvaro.detran.configs.DetailUserData;

@RestController
public class UserApi {

	@Autowired
	private UserService service;

	@PutMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody @Valid DetailUserData user) {
		DetailUserData createdUser = service.save(user);
		URI uri = URI.create("/users/" + createdUser.getId());

		UserDTO userDto = new UserDTO(createdUser.getId(), createdUser.getCpf());

		return ResponseEntity.created(uri).body(userDto);
	}
}
