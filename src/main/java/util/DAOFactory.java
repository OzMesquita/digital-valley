package util;

import DAO.JDBCPessoaDAO;
import DAO.PessoaDAO;

public class DAOFactory {
	public static PessoaDAO criarPessoaDAO(){
		return new JDBCPessoaDAO();
	}	
	
	
}