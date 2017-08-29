package dao;

import java.util.List;

import model.Servidor;

public interface ServidorDAO {

	public void cadastrar(Servidor servidor);
	
	public Servidor buscar(String siape);
	
	public Servidor buscarPorSiape(String siape);
	
	public List<Servidor> listar();
	
	
	
}