package br.com.ngfor.caderno.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ngfor.caderno.DTO.DefeitoDTO;
import br.com.ngfor.caderno.DTO.UsuarioUpdateDTO;
import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Defeito;
import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.model.Senha;
import br.com.ngfor.caderno.model.Usuario;
import br.com.ngfor.caderno.repository.AlarmeRepository;
import br.com.ngfor.caderno.services.AlarmeService;
import br.com.ngfor.caderno.services.MaquinaService;
import br.com.ngfor.caderno.services.SenhaService;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {

	private final MaquinaService service;

	public MaquinaController(MaquinaService service) {
		super();
		this.service = service;

	}

	@GetMapping
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Maquina> list() {
		return this.service.getAll();
	}

	@GetMapping("/{sigla}")
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public Optional<Maquina> findBySiga(@PathVariable(value = "sigla") String sigla) {
		return this.service.findBySigla(sigla);
	}

	@PutMapping("update")
	public URI update(@RequestBody Maquina obj) {
		


		Maquina objs = this.service.update(obj);
		
		System.err.println(objs);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objs.getId()).toUri();

		return uri;

	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Maquina insert(@RequestBody Maquina obj) {

		return this.service.insert(obj);

	}
	

}