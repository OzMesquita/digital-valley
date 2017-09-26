package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Servidor;

public class JDBCServidorDAO extends JDBCDAO implements ServidorDAO {



	protected JDBCServidorDAO() {

	}

	@Override
	public void cadastrar(Servidor servidor) {
		super.open();

		try {
			String SQL = "INSERT INTO servidor (siape, id_pessoa_usuario,cargo) VALUES (?,?,?)";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, servidor.getSiape());
			ps.setInt(2, servidor.getId());
			ps.setString(3, servidor.getCargo().getCargo());
			ps.executeUpdate();
			ps.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar servidor, "+e.getMessage());
		}finally {
			super.close();
		}
	}

	@Override
	public Servidor buscar(String siape) {
		super.open();
		Servidor servidor = new Servidor();

		String SQL = "SELECT * FROM servidor WHERE siape = ?";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, siape);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				servidor.setSiape(rs.getString("siape"));
				
			}
			ps.close();
			rs.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		}finally {
			super.close();
		}
		return servidor;
	}
	
	public Servidor buscarPorSiape(String siape){
		super.open();
		Servidor servidor = new Servidor();

		String SQL = "SELECT * FROM servidor AS s, pessoa_usuario as p WHERE siape = ? and s.id_pessoa_usuario = p.id_pessoa_usuario;";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, siape);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				servidor.setSiape(rs.getString("siape"));
				servidor.setNome(rs.getString("nome"));
				
				ps.close();
				rs.close();
				return servidor;

			}
			ps.close();
			rs.close();
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		}finally {
			super.close();
		}
	}
        
	public List<Servidor> buscarPorNome(String nome){
		super.open();
		List<Servidor> servidores = new ArrayList<Servidor>();
                

		String SQL = "SELECT * FROM servidor AS s, pessoa_usuario as p WHERE nome = ? and s.id_pessoa_usuario = p.id_pessoa_usuario;";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, nome);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                                Servidor servidor = new Servidor();
				servidor.setSiape(rs.getString("siape"));
				servidor.setNome(rs.getString("nome"));
				
                                servidores.add(servidor);
                                
                        }
                        ps.close();
                        rs.close();
                        return servidores;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		}finally {
			super.close();
		}
	}
	
	

	@Override
	public List<Servidor> listar() {
		super.open();
		ArrayList<Servidor> servidores = new ArrayList<>();
		try {
			String SQL = "SELECT * FROM servidor";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
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
		}finally {
			super.close();
		}

		return servidores;
	}
	
	
	
}
