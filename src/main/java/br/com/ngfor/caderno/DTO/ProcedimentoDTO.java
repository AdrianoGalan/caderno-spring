package br.com.ngfor.caderno.DTO;

import java.io.Serializable;

import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.model.Usuario;

public class ProcedimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String descricao;

	private String procedimento;

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

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
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
		return "ProcedimentoDTO [id=" + id + ", descricao=" + descricao + ", procedimento=" + procedimento + ", autor="
				+ autor + ", maquina=" + maquina + "]";
	}
	
	

}
