package br.com.ngfor.caderno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ngfor.caderno.DTO.ProcedimentoDTO;
import br.com.ngfor.caderno.model.Procedimento;
import br.com.ngfor.caderno.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository rep;

	public List<Procedimento> getAll() {
		return rep.findAll();
	}

	public Optional<Procedimento> findById(Integer id) {

		return this.rep.findById(id);

	}

	public Procedimento insert(ProcedimentoDTO obj) {

		Procedimento objs = new Procedimento(null, obj.getDescricao(), obj.getProcedimento(), obj.getAutor(),
				obj.getMaquina());

		return this.rep.save(objs);

	}

	public Procedimento update(ProcedimentoDTO obj) {

		Procedimento objs = new Procedimento(obj.getId(), obj.getDescricao(), obj.getProcedimento(), obj.getAutor(),
				obj.getMaquina());

		return this.rep.save(objs);

	}

}
