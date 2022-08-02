package br.edu.ifms.estudante.alvaro.detran.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.estudante.alvaro.detran.configs.DetailUserData;
import br.edu.ifms.estudante.alvaro.detran.configs.JwtTokenUtil;

@RestController
public class AuthApi {
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getCpf(), request.getSenha())
			);
			
			DetailUserData user = (DetailUserData) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getCpf(), accessToken);
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
