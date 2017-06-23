package util;

import dao.AlunoDAO;
import dao.JDBCAlunoDAO;
import dao.JDBCModuloDAO;
import dao.JDBCPessoaDAO;
import dao.JDBCUsuarioDAO;
import dao.ModuloDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;

public class DAOFactory {
	public static PessoaDAO criarPessoaDAO(){
		return new JDBCPessoaDAO();
	}	
	
	public static UsuarioDAO criarUsuarioDAO(){
		return new JDBCUsuarioDAO();
	}
	
	public static AlunoDAO criarAlunoDAO(){
		return new JDBCAlunoDAO();
	}
	
	public static ModuloDAO criarModuloDAO(){
		return new JDBCModuloDAO();
	}
}