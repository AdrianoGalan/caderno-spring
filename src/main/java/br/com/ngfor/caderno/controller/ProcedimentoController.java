package br.com.ngfor.caderno.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ngfor.caderno.DTO.DefeitoDTO;
import br.com.ngfor.caderno.DTO.ProcedimentoDTO;
import br.com.ngfor.caderno.DTO.SenhaDTO;
import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Defeito;
import br.com.ngfor.caderno.model.Procedimento;
import br.com.ngfor.caderno.model.Senha;
import br.com.ngfor.caderno.repository.AlarmeRepository;
import br.com.ngfor.caderno.services.ProcedimentoService;

@RestController
@RequestMapping("/api/procedimentos")
public class ProcedimentoController {

	private final ProcedimentoService service;

	public ProcedimentoController(ProcedimentoService service) {
		super();
		this.service = service;

	}

	@GetMapping
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Procedimento> list() {
		return this.service.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Procedimento insert(@RequestBody ProcedimentoDTO obj) {

		return this.service.insert(obj);

	}
	
	@PutMapping("update")
	public URI update(@RequestBody ProcedimentoDTO obj) {

		Procedimento objs = this.service.update(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objs.getId()).toUri();

		return uri;

	}

}