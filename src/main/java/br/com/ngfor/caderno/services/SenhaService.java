package br.com.ngfor.caderno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ngfor.caderno.DTO.SenhaDTO;
import br.com.ngfor.caderno.model.Senha;
import br.com.ngfor.caderno.repository.SenhaRepository;

@Service
public class SenhaService {

	@Autowired
	private SenhaRepository rep;

	public List<Senha> getAll() {
		return rep.findAll();
	}

	public Optional<Senha> findById(Integer id) {

		return this.rep.findById(id);

	}

	public Senha insert(SenhaDTO obj) {
		
		Senha objs = new Senha(null, obj.getDescricao(), obj.getSenha(), obj.getLogin(),obj.getAutor(), obj.getMaquina());

		return this.rep.save(objs);

	}

	public Senha update(SenhaDTO obj) {

		Senha objs = new Senha(obj.getId(), obj.getDescricao(), obj.getSenha(), obj.getLogin(),obj.getAutor(), obj.getMaquina());

		return this.rep.save(objs);

	}

}
