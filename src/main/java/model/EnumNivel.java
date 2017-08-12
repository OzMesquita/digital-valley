package model;

public enum EnumNivel {
	ADMINISTRADOR(1), COMUM(2);

	private int valorNivel;

	EnumNivel(int valor) {
		valorNivel = valor;
	}

	public int getValorNivel() {
		if(valorNivel == 0){
			return 2;
		}
		return valorNivel;
	}

}