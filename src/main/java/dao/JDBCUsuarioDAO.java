package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String SQL = "UPDATE pessoa_usuario SET login=?, senha=?, nivel=? WHERE id_pessoa_usuario=?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getNivel() != null ? usuario.getNivel().getValorNivel() : 2);
			ps.setInt(4, usuario.getPessoa().getId());
			ps.executeUpdate();
			ps.close();

			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar usuarios em JDBCUsuaruioDAO", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void editar(Usuario usuario) {
		
		try {
			String SQL = "UPDATE pessoa_usuario SET login=?, senha=? WHERE id_pessoa_usuario = ?";
				PreparedStatement ps = connection.prepareStatement(SQL);
				ps.setString(1, usuario.getLogin());
				ps.setString(2, usuario.getSenha());
				ps.setInt(3, usuario.getPessoa().getId());
				ps.executeUpdate();
				ps.close();
			
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao editar registro de usuario", e);
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}

	@Override
	public boolean autenticar(String login, String senha) {
		try {
			String SQL = "SELECT * FROM pessoa_usuario as u WHERE u.login = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			 
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario(rs.getString("login"), rs.getString("senha"));
				if(usuario.getSenha().equals(senha)) {
					return true;
				}
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro: login e senha inválidos");
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	
	public void editarNivel(Usuario usuario) {
		try {
		String SQL = "UPDATE pessoa_usuario SET nivel =? WHERE id_pessoa_usuario =?";
		
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, usuario.getNivel().getValorNivel());
			ps.setInt(2, usuario.getPessoa().getId());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erroao editar nível de usuario");
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
