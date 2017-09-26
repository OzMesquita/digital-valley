package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Modulo;
import model.Perfil;
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
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			throw new RuntimeException("Erro ao buscar registro de modulo, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Modulo buscarPorNome(String nome) {
		Modulo modulo = new Modulo();

		String SQL = "SELECT id_modulo, titulo, url, imagem FROM public.modulo WHERE UPPER(titulo) like UPPER(?) ";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, '%' + nome + '%');

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));
				ps.close();
				rs.close();
			}
			return modulo;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de modulo, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Modulo> buscar(Pessoa pessoa) {
		ArrayList<Modulo> modulos = new ArrayList<Modulo>();
		try {
			String SQL = "SELECT * FROM usuario_modulo AS u_m, modulo AS m WHERE u_m.id_usuario = ? and m.id_modulo = u_m.id_modulo";

			PreparedStatement ps;
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, pessoa.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));

				modulos.add(modulo);
			}

			ps.close();
			rs.close();

			return modulos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Modulo> buscar(Perfil perfil) {
		ArrayList<Modulo> modulos = new ArrayList<Modulo>();
		try {
			String SQL = "SELECT * FROM perfil_modulo AS p_m, modulo AS m WHERE p_m.id_perfil = ? and m.id_modulo = p_m.id_modulo;";

			PreparedStatement ps;
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, perfil.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));

				modulos.add(modulo);
			}

			ps.close();
			rs.close();

			return modulos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar Perfis, erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

			}
			ps.close();
			rs.close();
			return modulos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void associarUsuarioModulo(int idUsuario, int idModulo) {
		try {
			String SQL = "INSERT INTO usuario_modulo(id_usuario, id_modulo) VALUES (?, ?)";

			PreparedStatement ps;

			ps = connection.prepareStatement(SQL);

			ps.setInt(1, idUsuario);
			ps.setInt(2, idModulo);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao associar módulo em JDBCModuloDAO", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void associarPerfilModulo(int idPerfil, int idModulo) {
		try {
			String SQL = "INSERT INTO perfil_modulo(id_perfil, id_modulo) VALUES (?, ?)";

			PreparedStatement ps;

			ps = connection.prepareStatement(SQL);

			ps.setInt(1, idPerfil);
			ps.setInt(2, idModulo);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao associar módulo em JDBCModuloDAO, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Modulo> listarDisponiveisParaPessoa(Pessoa pessoa) {
		try {
			String SQL = "SELECT * FROM modulo WHERE id_modulo NOT IN (SELECT id_modulo FROM usuario_modulo WHERE usuario_modulo.id_usuario = ?);";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, pessoa.getId());
			ResultSet rs = ps.executeQuery();
			List<Modulo> modulos = new ArrayList<Modulo>();
			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));
				modulos.add(modulo);
			}
			ps.close();
			rs.close();
			return modulos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Falha ao buscar módulos disponíveis para pessoa em JDBCModuloDAO, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Modulo> listarAssociadosParaPessoa(Pessoa pessoa) {
		try {
			String SQL = "SELECT * FROM modulo AS m, usuario_modulo AS um WHERE m.id_modulo = um.id_modulo AND um.id_usuario = ?;";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, pessoa.getId());
			ResultSet rs = ps.executeQuery();
			List<Modulo> modulos = new ArrayList<Modulo>();
			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));
				modulos.add(modulo);
			}
			ps.close();
			rs.close();
			return modulos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Falha ao buscar módulos disponíveis para pessoa em JDBCModuloDAO, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void desassociarUsuarioModulo(int idUsuario, int idModulo) {
		try {
			String SQL = "DELETE FROM usuario_modulo WHERE id_usuario = ? AND  id_modulo = ?";
			PreparedStatement ps;
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, idUsuario);
			ps.setInt(2, idModulo);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao associar módulo em JDBCModuloDAO", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Modulo> getModulosDePerfil(Perfil perfil) {
		try {
			String SQL = "SELECT * FROM modulo as m, perfil_modulo as pm WHERE m.id_modulo = pm.id_modulo AND pm.id_perfil = ?;";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, perfil.getId());
			ResultSet rs = ps.executeQuery();
			List<Modulo> modulos = new ArrayList<Modulo>();
			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));
				modulos.add(modulo);
			}
			ps.close();
			rs.close();
			return modulos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Falha ao buscar módulos disponíveis para pessoa em JDBCModuloDAO, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Modulo> getModulosDisponiveisParaPerfil(Perfil perfil) {
		try {
			String SQL = "SELECT * FROM modulo as m  WHERE m.id_modulo NOT IN (SELECT id_modulo FROM perfil_modulo WHERE id_perfil = ?);";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, perfil.getId());
			ResultSet rs = ps.executeQuery();
			List<Modulo> modulos = new ArrayList<Modulo>();
			while (rs.next()) {
				Modulo modulo = new Modulo();
				modulo.setId(rs.getInt("id_modulo"));
				modulo.setTitulo(rs.getString("titulo"));
				modulo.setUrl(rs.getString("url"));
				modulo.setImagem(rs.getString("imagem"));
				modulos.add(modulo);
			}
			ps.close();
			rs.close();
			return modulos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Falha ao buscar módulos disponíveis para pessoa em JDBCModuloDAO, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void desassociarPerfilModulo(int idPerfil, int idModulo) {
		try {
			String SQL = "DELETE FROM perfil_modulo WHERE id_modulo = ? AND id_perfil = ?;";
			PreparedStatement ps;
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, idModulo);
			ps.setInt(2, idPerfil);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao associar módulo em JDBCModuloDAO, Erro: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
