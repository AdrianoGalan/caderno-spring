package br.com.ngfor.caderno.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Senha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Column
	private String login;

	@Column
	private String senha;

	@OneToOne()
	private Usuario autor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "maquina_senha_id")
	private Maquina maquina;

	public Senha() {
		super();
	}

	public Senha(Integer id, String descricao, String login, String senha, Usuario autor, Maquina maquina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.login = login;
		this.senha = senha;
		this.autor = autor;
		this.maquina = maquina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
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
		Senha other = (Senha) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {


			StringBuffer saida = new StringBuffer();

			saida.append("Login => ");
			saida.append(login);
			saida.append("\nSenha => ");
			saida.append(senha);
			saida.append("\nDescrição => ");
			saida.append(descricao);
			saida.append("\n");

			return saida.toString();
		
	}

}
