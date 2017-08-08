package dao;

import java.util.List;

import model.Perfil;

public interface PerfilDAO {
	
	public void cadastrar(Perfil perfil);
	
	public void editar(Perfil perfil);
	
	public void excluir(Perfil perfil);
	
	public Perfil buscarPorId(int id);
	
	public List<Perfil> Listar();
	
}
