package DAO;

import java.util.List;

import model.Aluno;

public interface AlunoDAO{

	public void cadastrar(Aluno aluno);
		
	public Aluno buscar(int id);
	
	public List<Aluno> listar();

}
