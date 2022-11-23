package br.com.ngfor.caderno.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String sigla;

	@OneToMany(mappedBy = "maquina", cascade = CascadeType.ALL)
	private List<Alarme> alarmes;

	@OneToMany(mappedBy = "maquina", cascade = CascadeType.ALL)
	private List<Defeito> defeitos;

	@OneToMany(mappedBy = "maquina", cascade = CascadeType.ALL)
	private List<Senha> senhas;

	@OneToMany(mappedBy = "maquina", cascade = CascadeType.ALL)
	private List<Procedimento> procedimentos;

	public Maquina() {
		super();
	}

	public Maquina(Integer id, String sigla) {
		super();
		this.id = id;
		this.sigla = sigla;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Alarme> getAlarmes() {
		return alarmes;
	}

	public void setAlarmes(List<Alarme> alarmes) {
		this.alarmes = alarmes;
	}

	public List<Defeito> getDefeitos() {
		return defeitos;
	}

	public void setDefeitos(List<Defeito> defeitos) {
		this.defeitos = defeitos;
	}

	public List<Senha> getSenhas() {
		return senhas;
	}

	public void setSenhas(List<Senha> senhas) {
		this.senhas = senhas;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
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
		Maquina other = (Maquina) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {

		StringBuffer saida = new StringBuffer();

		saida.append("Maquina - ");
		saida.append(sigla);
		saida.append("\n");

		if (alarmes.size() > 0) {
			saida.append("\n>Alarmes<\n");

			for (Alarme alarme : alarmes) {
				saida.append(alarme.toString());

			}
		}

		if (defeitos.size() > 0) {
			saida.append("\n>Defeitos<\n");

			for (Defeito defeito : defeitos) {
				saida.append(defeito.toString());

			}
		}

		if (procedimentos.size() > 0) {
			saida.append("\n>Procedimentos<\n");

			for (Procedimento procedimento : procedimentos) {
				saida.append(procedimento.toString());

			}
		}

		
		if (senhas.size() > 0) {

			saida.append("\n>Senhas<\n ");

			for (Senha senha : senhas) {
				saida.append(senha.toString());

			}

		}

		saida.append(
				"\n-------------------------------------------------------------------------------------------------------");

		return saida.toString();
	}

}
