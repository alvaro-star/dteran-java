package br.edu.ifms.estudante.alvaro.detran.configs;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifms.estudante.alvaro.detran.repositories.UsuarioRepository;

@Service
@Transactional
public class DetailUserServiceImpl implements UserDetailsService{

	
	private final UsuarioRepository usuarioRepository;
	
	public DetailUserServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DetailUserData usuarioModel = usuarioRepository.findByCpf(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found by username "+username));
		return new User(usuarioModel.getUsername(), usuarioModel.getPassword(), true, true, true, true, usuarioModel.getAuthorities());
	}

}
