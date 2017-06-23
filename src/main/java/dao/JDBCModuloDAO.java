package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Modulo;
import model.Pessoa;
import util.ConnectionFactory;

public class JDBCModuloDAO implements ModuloDAO {

	Connection connection;

	public JDBCModuloDAO() {

		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void cadastrar(Modulo modulo) {
		try {
			String SQL = "INSERT INTO modulo (titulo, url, imagem) VALUES" + "(?,?,?)";

			PreparedStatement ps;

			ps = connection.prepareStatement(SQL);

			ps.setString(1, modulo.getTitulo());
			ps.setString(2, modulo.getUrl());
			ps.setString(3, modulo.getImagem());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar módulo em JDBCModuloDAO", e);
		}
	}

	@Override
	public void editar(Modulo modulo) {
		try {
			String SQL = "UPDATE modulo SET titulo=?, url=?, imagem=? WHERE id_modulo = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, modulo.getTitulo());
			ps.setString(2, modulo.getUrl());
			ps.setString(3, modulo.getImagem());
			ps.setInt(4, modulo.getId());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao editar módulo em JDBCModuloDAO", e);
		}

	}

	@Override
	public void remover(int id) {

		try {
			String SQL = "DELETE FROM modulo WHERE id_modulo = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover registro de pessoas em JDBC pessoaDAO", e);
		}

	}

	@Override
	public Modulo buscar(int id) {
		Modulo modulo = new Modulo();

		String SQL = "SELECT * FROM modulo WHERE id_modulo = ?";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			modulo.setTitulo(rs.getString("titulo"));
			modulo.setId(rs.getInt("id_modulo"));
			modulo.setUrl(rs.getString("url"));
			modulo.setImagem(rs.getString("imagem"));
			ps.close();
			rs.close();

			return modulo;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de pessoa", e);
		}

	}

	@Override
	public List<Modulo> buscar(Pessoa pessoa) {
		ArrayList<Modulo> modulos = new ArrayList<Modulo>();
		try {
			String SQL = "SELECT * FROM usuario_modulo WHERE id_usuario = ?";

			PreparedStatement ps;
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, pessoa.getId());

			ResultSet rs = ps.executeQuery();
			rs.next();

			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagens"));
				modulos.add(modulo);
			}

			ps.close();
			rs.close();

			return modulos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);
		}
	}

	@Override
	public List<Modulo> listar() {
		ArrayList<Modulo> modulos = new ArrayList<>();
		try {
			String SQL = "SELECT * FROM modulo";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));
				modulos.add(modulo);

				ps.close();
				rs.close();

				return modulos;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);
		}

		return null;
	}

}
