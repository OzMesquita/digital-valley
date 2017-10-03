package dao;

import java.util.List;

import model.Aluno;

public interface AlunoDAO{

	public void cadastrar(Aluno aluno);
		
	public Aluno buscar(int id);
	
	public Aluno buscarPorMatricula(String matricula);
	
	public List<Aluno> buscarPorNome(String nome);
	
	public List<Aluno> listar();
	
	public void editar(Aluno aluno);
	
	public Aluno buscarTokenRecuperacao(String texto);
	
	
	

}