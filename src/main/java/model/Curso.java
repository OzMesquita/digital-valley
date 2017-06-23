package model;

import java.util.ArrayList;

public class Curso {
	
	private String codigo;
	private String descricao;
	private ArrayList<Disciplina> disciplinas;
	
	public Curso(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public Curso() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}
