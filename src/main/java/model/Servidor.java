package model;

import java.time.LocalDate;

public class Servidor extends Pessoa{
	
	private String siape;	
	protected EnumCargo cargo;

	public Servidor(){		
	}	

	public Servidor(String nome, String cpf, String email, Usuario usuario, LocalDate dataNascimento,String siape, EnumCargo cargo){
		super(nome, cpf,email,usuario,dataNascimento);
		this.siape = siape;
		this.cargo = cargo;
	}

	public Servidor(String nome, String cpf, String email, Usuario usuario, LocalDate dataNascimento,String siape){
		super(nome, cpf,email,usuario,dataNascimento);
		this.siape = siape;

	}
	
	
	public String getSiape() {
		return siape;
	}


	public void setSiape(String siape) {
		if(siape!=null && siape.length()==7 && siape.matches("^[0-9]+$")){
			this.siape = siape;			
		}else {
			throw new IllegalArgumentException(
					"Erro: O parâmetro SIAPE não pode ser nulo e deve ter 7 dígitos, valor informado " + siape);
		}

	}


	public EnumCargo getCargo() {
		return cargo;
	}


	public void setCargo(EnumCargo cargo) {
		this.cargo = cargo;
	}

}
