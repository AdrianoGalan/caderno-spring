package br.com.ngfor.caderno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.repository.MaquinaRepository;

@Service
public class MaquinaService {

	@Autowired
	private MaquinaRepository rep;

	public List<Maquina> getAll() {
		return rep.findAll();
	}

	public Optional<Maquina> findById(Integer id) {

		return this.rep.findById(id);

	}

	public Optional<Maquina> findBySigla(String sigla) {

		sigla = sigla.toUpperCase();
		sigla = sigla.trim();

		Optional<Maquina> maquina = this.rep.findBySigla(sigla);

		if (maquina != null) {
			return maquina;
		}

		return null;

	}

	

	public Maquina insert(Maquina obj) {

		obj.setSigla(obj.getSigla().trim());

		obj.setSigla(obj.getSigla().toUpperCase());

		return this.rep.save(obj);

	}

	public Maquina update(Maquina obj) {

		obj.setSigla(obj.getSigla().trim());

		obj.setSigla(obj.getSigla().toUpperCase());

		return this.rep.save(obj);

	}

}
