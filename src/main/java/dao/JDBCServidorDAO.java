package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Servidor;
import util.ConnectionFactory;

public class JDBCServidorDAO implements ServidorDAO {

	Connection connection;

	public JDBCServidorDAO() {

		connection = ConnectionFactory.getConnection();

	}

	@Override
	public void cadastrar(Servidor servidor) {

		try {
			String SQL = "INSERT INTO servidor (siape, id_pessoa_usuario) VALUES (?,?)";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, servidor.getSiape());
			ps.setInt(2, servidor.getId());
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

			ps.setString(1, siape);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				servidor.setSiape(rs.getString("siape"));

				return servidor;

			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		}
	}

	@Override
	public List<Servidor> listar() {
		ArrayList<Servidor> servidores = new ArrayList<>();
		try {
			String SQL = "SELECT * FROM servidor";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Servidor servidor = new Servidor();
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				servidores.add(servidor);

				ps.close();
				rs.close();

				return servidores;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);
		}

		return null;
	}
}
