package model;

public class Perfil {
	private int id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfil() {
		super();
		this.nome = "PADRÃO";
	}
	
	public Perfil(String nome) {
		super();
		this.nome = nome;
	}
	
	//CLASSE INICIAD PELO GILBERTO LIMA
	
}
