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

import br.com.ngfor.caderno.DTO.SenhaDTO;
import br.com.ngfor.caderno.model.Senha;
import br.com.ngfor.caderno.services.SenhaService;

@RestController
@RequestMapping("/api/senhas")
public class SenhaController {

	private final SenhaService service;

	public SenhaController(SenhaService service) {
		super();
		this.service = service;

	}

	@GetMapping
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Senha> list() {
		return this.service.getAll();
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Senha insert(@RequestBody SenhaDTO obj) {

		return this.service.insert(obj);

	}

	@PutMapping("update")
	public URI update(@RequestBody SenhaDTO obj) {

		Senha objs = this.service.update(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objs.getId()).toUri();

		return uri;

	}

}