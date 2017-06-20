package model;

import java.util.ArrayList;

public class Professor extends Servidor{

	private String titulo;
	private boolean coordenador;
	//private ArrayList<Turmas> turmas;
	
	public Professor(){
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}
}
