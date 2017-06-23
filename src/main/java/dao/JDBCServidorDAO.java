package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Usuario;
import util.ConnectionFactory;

public class JDBCServidorDAO implements ServidorDAO {
	
	Connection connection;

	public JDBCUsuarioDAO() {

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

}
