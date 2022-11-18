package br.com.ngfor.caderno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ngfor.caderno.DTO.DefeitoDTO;
import br.com.ngfor.caderno.model.Defeito;
import br.com.ngfor.caderno.repository.DefeitoRepository;

@Service
public class DefeitoService {

	@Autowired
	private DefeitoRepository rep;

	public List<Defeito> getAll() {
		return rep.findAll();
	}

	public Optional<Defeito> findById(Integer id) {

		return this.rep.findById(id);

	}

	public Defeito insert(DefeitoDTO obj) {
		
		Defeito objs = new Defeito(null, obj.getDescricao(), obj.getSolucao(),obj.getAutor(), obj.getMaquina());

		return this.rep.save(objs);

	}

	public Defeito update(DefeitoDTO obj) {
		
		Defeito objs = new Defeito(obj.getId(), obj.getDescricao(), obj.getSolucao(),obj.getAutor(), obj.getMaquina());

		return this.rep.save(objs);

	}

}
