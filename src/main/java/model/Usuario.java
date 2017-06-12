package model;

import javax.persistence.Column;

public class Usuario {
	
	
	@Column(length=20, nullable=false, unique= true)
	private String login;
	
	@Column(length=20, nullable=false)
	private String senha;

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
	

}
