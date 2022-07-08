package br.edu.ifms.estudante.alvaro.detran.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.estudante.alvaro.detran.models.Infracao;

public interface Infracoes extends JpaRepository<Infracao, Long>{

}
