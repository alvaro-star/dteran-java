package br.edu.ifms.estudante.alvaro.detran.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.estudante.alvaro.detran.configs.DetailUserData;

@Repository
public interface UsuarioRepository extends JpaRepository<DetailUserData, Integer>{

	Optional<DetailUserData> findByCpf(String cpf);
}
