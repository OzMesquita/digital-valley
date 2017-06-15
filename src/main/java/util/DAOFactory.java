package util;

import DAO.AlunoDAO;
import DAO.JDBCAlunoDAO;
import DAO.JDBCPessoaDAO;
import DAO.JDBCUsuarioDAO;
import DAO.PessoaDAO;
import DAO.UsuarioDAO;

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
}