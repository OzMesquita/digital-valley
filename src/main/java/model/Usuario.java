package model;


public class Usuario {
	
	private String login;
	private String senha;
	private Pessoa pessoa;

	public Usuario(){
		
	}
	public Usuario(String login, String senha, Pessoa pessoa) {
		super();
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
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
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

}
