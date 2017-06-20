package model;

public enum EnumNivel {
	ADMINISTRADOR(1), COMUM(2);

	public int valorNivel;

	EnumNivel(int valor) {
		valorNivel = valor;
	}

	public int getValorNivel() {
		return valorNivel;
	}

}
