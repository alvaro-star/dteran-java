package br.edu.ifms.estudante.alvaro.detran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.estudante.alvaro.detran.models.InfracaoModel;

@Repository
public interface InfracaoRepository extends JpaRepository<InfracaoModel, Integer>{
}
