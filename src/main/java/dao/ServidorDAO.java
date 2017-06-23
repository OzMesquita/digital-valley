package dao;

import java.util.List;

import model.Servidor;

public interface ServidorDAO {

	public void cadastrar(Servidor servidor);
	
	public Servidor buscar(int id);
	
	public List<Servidor> listar();
	
}
