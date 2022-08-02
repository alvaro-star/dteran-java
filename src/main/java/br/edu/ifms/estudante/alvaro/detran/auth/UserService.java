package br.edu.ifms.estudante.alvaro.detran.auth;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifms.estudante.alvaro.detran.configs.DetailUserData;
import br.edu.ifms.estudante.alvaro.detran.repositories.UsuarioRepository;

@Service
@Transactional
public class UserService {
	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;

	public UserService(UsuarioRepository repo) {
		this.repo = repo;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public DetailUserData save(DetailUserData user) {
		String rawPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(rawPassword);
		user.setSenha(encodedPassword);

		return repo.save(user);
	}
}
