package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;

public class JDBCPreCadastroServidorDAO implements PreCadastroServidorDAO {
	Connection connection;

	public JDBCPreCadastroServidorDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void preCadastrarServidor(String siape, String nome) {
		try {

			String SQL = "INSERT INTO pre_cadastro_servidor( siape, nome) VALUES (?, ?);";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, siape);
			ps.setString(2, nome);

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar um servidor:"+ e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean buscarPreCadastro(String siape, String nome){
		try {
			String SQL = "SELECT * FROM pre_cadastro_servidor WHERE siape = ? AND UPPER(nome) LIKE UPPER(?)";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, siape);
			ps.setString(2, "%"+nome+"%");

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				
				
				rs.close();
				ps.close();
				
				return true;
				
			}else{
				rs.close();
				ps.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro do servidor", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluirPreCadastro(String siape, String nome) {
		try {
			String SQL = "DELETE FROM pre_cadastro_servidor WHERE siape=? AND UPPER(nome) like UPPER(?)";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, siape);
			ps.setString(2, "%"+nome+"%");
			ps.executeUpdate();
			
				
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro do servidor", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
