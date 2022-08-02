package br.edu.ifms.estudante.alvaro.detran.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.estudante.alvaro.detran.configs.DetailUserData;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	/*
	private final UsuarioRepository usuarioRepository;
	@Autowired
	private JwtTokenUtil jwtUtil;
	
    public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getEmail(), request.getPassword())
			);
			
			DetailUserData user = (DetailUserData) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}*/

	@PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody DetailUserData usuario) {
        return ResponseEntity.status(HttpStatus.OK).body("Vc esta logado");
    }
    
}
