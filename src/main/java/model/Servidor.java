package model;

public class Servidor extends Pessoa{
	
	private String siape;	
	private EnumCargo cargo;


	public String getSiape() {
		return siape;
	}


	public void setSiape(String siape) {
		if(siape!=null && siape.length()!=7){
			this.siape = siape;			
		}

	}


	public EnumCargo getCargo() {
		return cargo;
	}


	public void setCargo(EnumCargo cargo) {
		this.cargo = cargo;
	}

}
