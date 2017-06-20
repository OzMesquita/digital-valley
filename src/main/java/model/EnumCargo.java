package model;

public enum EnumCargo {
	
	PROFESSOR(1), SECRETARIO(2), FUNCIONARIO(3);

	public int valorCargo;

	EnumCargo(int valor) {
		valorCargo = valor;
	}

	public int getValorCargo() {
		return valorCargo;
	}
	
}