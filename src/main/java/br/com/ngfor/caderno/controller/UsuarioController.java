package br.com.ngfor.caderno.controller;

import java.net.URI;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ngfor.caderno.DTO.UsuarioInsert;
import br.com.ngfor.caderno.DTO.UsuarioUpdateDTO;
import br.com.ngfor.caderno.model.Usuario;
import br.com.ngfor.caderno.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioService service;

	private final BCryptPasswordEncoder pe;

	public UsuarioController(UsuarioService service, BCryptPasswordEncoder pe) {
		super();
		this.service = service;
		this.pe = pe;
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public URI insert(@RequestBody UsuarioInsert obj) {

		Usuario user = this.service.insert(obj, this.pe);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		System.err.println(uri);

		return uri;

	}

	@PutMapping("update")
	public URI update(@RequestBody UsuarioUpdateDTO obj) {

		Usuario u = this.service.findByEmail(obj.getEmail());

		u.setNome(obj.getNome());
		u.setSenha(this.pe.encode(obj.getSenha()));

		Usuario user = this.service.update(u);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return uri;

	}

	@PutMapping("reset")
	public URI reset(@RequestBody UsuarioUpdateDTO obj) {

		Usuario u = this.service.findByEmail(obj.getEmail());

		Usuario user = this.service.reset(u, this.pe);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return uri;

	}
	
	@PutMapping("delete")
	public URI delete(@RequestBody UsuarioUpdateDTO obj) {

		Usuario u = this.service.findByEmail(obj.getEmail());

		Usuario user = this.service.delete(u);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return uri;

	}

	@GetMapping
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Usuario> list() {
		return this.service.getAllStatusActive();
	}
	
	@GetMapping("/inativo")
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Usuario> listInactive() {
		return this.service.getAllStatusInative();
	}

	@GetMapping("/email/{email}")
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public Usuario getUsuarioByEmail(@PathVariable(value = "email") String email) {
		Usuario usuario = new Usuario();

		try {

			usuario = this.service.findByEmail(email);

		} catch (Exception e) {
			return null;
		}

		return usuario;

	}

	@GetMapping("/{id}")
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public Optional<Usuario> getUsuarioById(@PathVariable Integer id) {

		return this.service.findById(id);

	}

}