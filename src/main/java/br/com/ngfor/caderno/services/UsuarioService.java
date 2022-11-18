package br.com.ngfor.caderno.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ngfor.caderno.DTO.UsuarioInsert;
import br.com.ngfor.caderno.model.Usuario;
import br.com.ngfor.caderno.repository.UsuarioRepository;
import br.com.ngfor.caderno.security.UserSS;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;

	public List<Usuario> getAll() {
		return rep.findAll();
	}
	
	public List<Usuario> getAllStatusActive() {
		return rep.findByStatus(1);
	}
	
	public List<Usuario> getAllStatusInative() {
		return rep.findByStatus(0);
	}

	public Optional<Usuario> findById(Integer id) {

		return this.rep.findById(id);

	}

	public Usuario insert(UsuarioInsert usuarioInset, BCryptPasswordEncoder pe) {

		String[] senha = usuarioInset.getEmail().split("@");
		Usuario obj = new Usuario();

		obj.setStatus(1);
		obj.setRestSenha(1);
		obj.setSenha(pe.encode(senha[0]));
		obj.setNome(senha[0]);
		obj.setEmail(usuarioInset.getEmail());

		return this.rep.save(obj);

	}

	public Usuario update(Usuario obj) {

		obj.setRestSenha(0);

		return this.rep.save(obj);

	}

	public Usuario reset(Usuario obj, BCryptPasswordEncoder pe) {

		String[] senha = obj.getEmail().split("@");

		obj.setRestSenha(1);
		obj.setStatus(1);
		obj.setSenha(pe.encode(senha[0]));

		return this.rep.save(obj);

	}

	public Usuario delete(Usuario obj) {

		obj.setRestSenha(1);
		obj.setStatus(0);

		return this.rep.save(obj);

	}

	public Usuario findByEmail(String email) {

		UserSS user = UserService.authenticated();
		/*
		 * if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
		 * throw new AuthorizationException("Acesso negado"); }
		 */

		Optional<Usuario> obj = rep.findByEmail(email);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Email: " + email + ", Tipo: " + Usuario.class.getName(), null));
	}

}
