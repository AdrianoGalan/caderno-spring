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

import br.com.ngfor.caderno.DTO.AlarmeDTO;
import br.com.ngfor.caderno.DTO.DefeitoDTO;
import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Defeito;
import br.com.ngfor.caderno.services.DefeitoService;

@RestController
@RequestMapping("/api/defeitos")
public class DefeitoController {

	private final DefeitoService service;

	public DefeitoController(DefeitoService service) {
		super();
		this.service = service;

	}

	@GetMapping
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Defeito> list() {
		return this.service.getAll();
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Defeito insert(@RequestBody DefeitoDTO obj) {

		return this.service.insert(obj);

	}
	
	@PutMapping("update")
	public URI update(@RequestBody DefeitoDTO obj) {

		Defeito objs = this.service.update(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objs.getId()).toUri();

		return uri;

	}
	

}