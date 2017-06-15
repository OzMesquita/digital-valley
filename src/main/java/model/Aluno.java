package model;

public class Aluno {
	
	private int matricula;
	private String nome;
	private EnumCurso curso;
	private String semestreIngresso;
	private Pessoa pessoa;
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {			
		this.matricula = matricula;
	}
	
	public EnumCurso getCurso() {
		return curso;
	}
	
	public void setCurso(EnumCurso curso) {
		this.curso = curso;
	}
	
	public String getSemestreIngresso() {
		return semestreIngresso;
	}
	
	public void setSemestreIngresso(String semestreIngresso) {
		this.semestreIngresso = semestreIngresso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
