package dao;

import java.util.List;
import model.Pessoa;

public interface PessoaDAO {
	
	public void cadastrar(Pessoa pessoa);
	
	public void editar(Pessoa pessoa);
	
	public void remover(int id);
	
	public Pessoa buscar(int id);
	
	public Pessoa buscar(String login);
	
	public List<Pessoa> listar();
	

}