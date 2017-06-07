package model;

public enum EnumCurso {

	CIENCIADACOMPUTACAO(1), ENGENHARIACIVIL(2), ENGENHARIADEPRODUCAO(3), ENGENHARIADESOFTWARE(4), ENGENHARIAMECANINCA(5);

	public int valorCurso;

	EnumCurso(int valor) {
		valorCurso = valor;
	}

	public int getValorCurso() {
		return valorCurso;
	}
	
}
