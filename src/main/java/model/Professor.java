package model;

import java.time.LocalDate;

public class Professor extends Servidor{

	private boolean coordenador;

	public Professor(){
		super();
	}
	
	public Professor(String nome, String cpf, String email, Usuario usuario, LocalDate dataNascimento,String siape, EnumCargo cargo, boolean coordenador){
		super(nome,cpf,email,usuario,dataNascimento,siape,cargo);
		this.coordenador=coordenador;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}
}
