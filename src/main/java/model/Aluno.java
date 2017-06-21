package model;

public class Aluno extends Pessoa{
	
	private String matricula;
	private EnumCurso curso;
	private String semestreIngresso;
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		if(matricula != null && matricula.length() == 7 && matricula.matches("^[0-9]+$")){
			this.matricula = matricula;
		}else{
			throw new IllegalArgumentException("Erro: O parâmetro MATRICULA não pode ser nulo e deve conter apenas dígitos, valor informado " + matricula);
		}
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
		if (semestreIngresso != null && semestreIngresso.matches("^[0-9]+.[1-2]$")){
			this.semestreIngresso = semestreIngresso;
		}else{
			throw new IllegalArgumentException("Erro: O parâmetro SEMESTRE INGRESSO não pode ser nulo e deve conter apenas dígitos, Ex: 2017.1, valor informado " + semestreIngresso);
		}
	}

}
