package model;

import java.util.ArrayList;

public class Curso {
	
	private int id;
	private String nome;
	private ArrayList<Disciplina> disciplinas;
	
	public Curso(String codigo, String descricao) {
		this.nome = descricao;
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public Curso() {
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
