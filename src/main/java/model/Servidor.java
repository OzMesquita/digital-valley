package model;

public class Servidor extends Pessoa{
	
	private String siape;	
	private EnumCargo cargo;


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
