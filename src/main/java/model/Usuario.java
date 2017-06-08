package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario {
	
	
	@Column(length=20, nullable=false, unique= true)
	private String usuario;
	
	@Column(length=20, nullable=false)
	private String senha;

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
