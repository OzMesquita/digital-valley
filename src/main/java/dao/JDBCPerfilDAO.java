package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Perfil;

public class JDBCPerfilDAO implements PerfilDAO{
	
	private Connection connection;
	
	public JDBCPerfilDAO(){
		this.connection = util.ConnectionFactory.getConnection();
	}

	@Override
	public void cadastrar(Perfil perfil) {
		try {
			String SQL = "INSERT INTO perfil(id, nome) VALUES (?, ?)";

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, perfil.getId());
			ps.setString(2, perfil.getNome());

			ps.executeUpdate();
			ps.close();

			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar pessoas em JDBCPerfilDAO: "+e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void editar(Perfil perfil) {
		try {
			String SQL = "INSERT INTO perfil(id, nome) VALUES (?, ?)";

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, perfil.getId());
			ps.setString(2, perfil.getNome());

			ps.executeUpdate();
			ps.close();

			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar pessoas em JDBCPerfilDAO: "+e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void excluir(Perfil perfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Perfil buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Perfil> Listar() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
