package br.com.ngfor.caderno.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ngfor.caderno.model.enums.Perfil;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@NotEmpty(message = "Campo obrigatorio")
	private String nome;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = "Campo obrigatorio")
	private String email;

	@JsonIgnore
	@Column(nullable = false)
	@NotEmpty(message = "Campo obrigatorio")
	private String senha;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	@Column
	private Integer status;

	@Column
	private Integer restSenha;

	public Usuario() {

		this.addPerfil(Perfil.CLIENTE);

	}

	public Usuario(Integer id, String nome, String email, String senha, Integer status, Integer restSenha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.addPerfil(Perfil.CLIENTE);
		this.status = status;
		this.restSenha = restSenha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPerfis(List<String> perfis) {

		switch (perfis.get(0)) {
		case "ADMIN":
			this.perfis.add(1);

			break;
		case "CLIENTE":
			this.perfis.add(2);
			break;

		default:
			break;
		}
		
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRestSenha() {
		return restSenha;
	}

	public void setRestSenha(Integer restSenha) {
		this.restSenha = restSenha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", perfis=" + perfis
				+ ", status=" + status + ", restSenha=" + restSenha + "]";
	}

}
