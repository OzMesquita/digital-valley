package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Servidor;
import model.Usuario;
import util.ConnectionFactory;

public class JDBCServidorDAO implements ServidorDAO {
	
	Connection connection;

	public JDBCServidorDAO() {

		connection = ConnectionFactory.getConnection();

	}

	@Override
	public void cadastrar(Servidor servidor) {

		try {
			String SQL = "INSERT INTO servidor (siape) VALUES " + " (?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, servidor.getSiape());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar servidor em JDBCServidorDAO", e);
		}
	}



	@Override
	public Servidor buscar(String siape) {
		Servidor servidor = new Servidor();
		
		String SQL = "SELECT * FROM servidor WHERE siape = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, "siape");
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			servidor.setId(rs.getInt("id_pessoa_usuario"));
			
		
		
		
		
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		}
		
		return null;
	}

	@Override
	public List<Servidor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
