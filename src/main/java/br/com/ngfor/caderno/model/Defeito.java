package br.com.ngfor.caderno.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Defeito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String descricao;

	@Column(columnDefinition="TEXT")
	private String solucao;
	
	@OneToOne()
	private Usuario autor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "maquina_defeito_id")
	private Maquina maquina;

	public Defeito() {
		super();
	}



	public Defeito(Integer id, String descricao, String solucao, Usuario autor, Maquina maquina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.solucao = solucao;
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
		Defeito other = (Defeito) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {

		StringBuffer saida = new StringBuffer();

		
		saida.append("Descrição => ");
		saida.append(descricao);
		saida.append("\nSolucao => ");
		saida.append(solucao);
		saida.append("\n");

		return saida.toString();

	}



}
