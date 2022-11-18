package br.com.ngfor.caderno.DTO;

import java.io.Serializable;

public class UsuarioInsert implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	public UsuarioInsert() {
		super();

	}

	public UsuarioInsert(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UsuarioInsert [email=" + email + "]";
	}
	
	

}
