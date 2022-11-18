package br.com.ngfor.caderno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ngfor.caderno.model.Maquina;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {
	
	Optional<Maquina> findBySigla(String sigla);

}
