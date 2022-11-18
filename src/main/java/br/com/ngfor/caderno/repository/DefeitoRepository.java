package br.com.ngfor.caderno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ngfor.caderno.model.Defeito;

@Repository
public interface DefeitoRepository extends JpaRepository<Defeito, Integer> {
	
	List<Defeito> findAll();

}
