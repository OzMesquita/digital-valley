package model;

public enum EnumCargo {
	
	PROFESSOR("Professor"), SECRETARIO("Secretário"), FUNCIONARIO("Funcionário");

	public String cargo;

	EnumCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}
	
}