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
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String descricao;

	@Column(columnDefinition = "TEXT")
	private String procedimento;

	@OneToOne()
	private Usuario autor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "maquina_procedimento_id")
	private Maquina maquina;

	public Procedimento() {

	}

	public Procedimento(Integer id, String descricao, String procedimento, Usuario autor, Maquina maquina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.procedimento = procedimento;
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
		Procedimento other = (Procedimento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {

		StringBuffer saida = new StringBuffer();

		saida.append("Descrição:\n");
		saida.append(descricao);
		saida.append("\n procedimento:\n");
		saida.append(procedimento);
		saida.append("\n----------------------------------------------------------- \n");

		return saida.toString();
	}

}
