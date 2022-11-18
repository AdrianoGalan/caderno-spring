package br.com.ngfor.caderno.DTO;

import java.io.Serializable;

import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.model.Usuario;

public class AlarmeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String codigo;

	private String descricao;

	private String solucao;

	private Usuario autor;

	private Maquina maquina;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
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
		return "AlarmeDTO [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", solucao=" + solucao
				+ ", autor=" + autor + ", maquina=" + maquina + "]";
	}

}
