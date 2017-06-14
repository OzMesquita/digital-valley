package model;

public enum EnumNivel {
	BASICO(1), NORMAL(2), AVANÇADO(3);

	public int valorNivel;

	EnumNivel(int valor) {
		valorNivel = valor;
	}

	public int getValorNivel() {
		return valorNivel;
	}

}
