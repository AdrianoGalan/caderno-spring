package br.com.ngfor.caderno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ngfor.caderno.DTO.AlarmeDTO;
import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Usuario;
import br.com.ngfor.caderno.repository.AlarmeRepository;

@Service
public class AlarmeService {

	@Autowired
	private AlarmeRepository rep;


	public List<Alarme> getAll() {
		return rep.findAll();
	}

	public Optional<Alarme> findById(Integer id) {

		return this.rep.findById(id);

	}

	public Alarme insert(AlarmeDTO obj) {

		Alarme alarme = new Alarme(null, obj.getCodigo(), obj.getDescricao(), obj.getSolucao(), obj.getAutor(),
				obj.getMaquina());

		return this.rep.save(alarme);

	}

	public Alarme update(AlarmeDTO obj) {

		Alarme alarme = new Alarme(obj.getId(), obj.getCodigo(), obj.getDescricao(), obj.getSolucao(), obj.getAutor(),
				obj.getMaquina());

		return this.rep.save(alarme);

	}

}
