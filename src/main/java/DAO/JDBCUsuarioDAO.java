package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Usuario;
import util.ConnectionFactory;

public class JDBCUsuarioDAO implements UsuarioDAO {

	Connection connection;

	public JDBCUsuarioDAO() {

		connection = ConnectionFactory.getConnection();

	}

	@Override
	public void cadastrar(Usuario usuario) {

		try {
			String SQL = "INSERT INTO pessoa_usuario (login, senha) WHERE id=? VALUES" + "(?,?)";

			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, usuario.getPessoa().getId());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar usuarios em JDBCUsuaruioDAO", e);
		}
	}

	@Override
	public void editar(Usuario usuario) {
		
		try {
			String SQL = "UPDATE pessoa_usuario SET login=?, senha=? WHERE id = ?";
				PreparedStatement ps = connection.prepareStatement(SQL);
				ps.setString(1, "login");
				ps.setString(2, "senha");
				ps.executeUpdate();
				ps.close();
			
			
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao editar registro de usuario", e);
			}

	}

}
