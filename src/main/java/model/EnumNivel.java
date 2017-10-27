package model;

public enum EnumNivel {
	ADMINISTRADOR(1), ALUNO(2), SERVIDOR(3), VISITANTE(4) ;

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
	
	public static String value(Integer valor){
		switch(valor){
		case 1:
			return "Administrador";
		case 2:
			return "Aluno";
		default:
			return "";
		}
	
	}
	

}