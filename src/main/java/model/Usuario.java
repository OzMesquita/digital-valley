package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
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
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id > 0){
			this.id = id;
		}else{
			throw new IllegalArgumentException("Erro: O valor do id deve ser maior do que 0, valor informardo: "+id);	
		}
	}
	
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		if(login != null &&login.length() >= 4){
			this.login = login;
		}else{
			throw new IllegalArgumentException("Erro: O valor do login não pode ser nulo e deve possuir pelo menos 4 caracteres, valor informado: "+login);
		}
		

	}
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		if(senha != null && senha.length() >= 6){
			this.senha = senha;
		}else{
			throw new IllegalArgumentException("Erro: O valor da senha não pode ser nulo e deve possuir pelo menos 6 caracteres, valor informado: "+id);
		}
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}