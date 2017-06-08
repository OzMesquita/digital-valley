package model;


public class Usuario {
	
	
	private String login;
	private String senha;
	private Pessoa pessoa;

	public String getLogin() {
		return login;
	}


	public void setLogin(String usuario) {
		this.login = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

}
