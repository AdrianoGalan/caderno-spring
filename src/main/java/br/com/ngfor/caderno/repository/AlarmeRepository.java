package br.com.ngfor.caderno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ngfor.caderno.model.Alarme;

@Repository
public interface AlarmeRepository extends JpaRepository<Alarme, Integer> {

}
