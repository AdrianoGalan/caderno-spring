package br.com.ngfor.caderno.DTO;

import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.model.Usuario;

public class SenhaDTO {
	
	private Integer id;

	private String descricao;

	private String login;

	private String senha;

	private Usuario autor;

	private Maquina maquina;
	
	

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
	public String toString() {
		return "SenhaDTO [id=" + id + ", descricao=" + descricao + ", login=" + login + ", senha=" + senha + ", autor="
				+ autor + ", maquina=" + maquina + "]";
	}
	
	

}