package dao;

import java.util.List;

import model.Pessoa;

public interface PessoaDAO {
	
	public void cadastrar(Pessoa pessoa);
	
	public void editar(Pessoa pessoa);
	
	public void remover(int id);
	
	public Pessoa buscarPorId(int id);
	
	public Pessoa buscarPorLogin(String login);
	
	public Pessoa buscarPorCpf(String cpf);
        
	public List<Pessoa> buscarPorNome(String nome);
	
        public Pessoa buscarPorEmail(String email);
	
	public List<Pessoa> listar();

	public Pessoa buscarPorMatriculaAndCPF(String matricula, String cpf);
}