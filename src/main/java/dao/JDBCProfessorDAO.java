package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Professor;
import util.ConnectionFactory;

public class JDBCProfessorDAO implements ProfessorDAO{

	Connection connection;

	public JDBCProfessorDAO() {
		connection = ConnectionFactory.getConnection();
	}
		
	@Override
	public void cadastrar(Professor professor) {
		try {
			String SQL = "INSERT INTO professor (siape) VALUES " + " (?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, professor.getSiape());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar professor em JDBCProfessorDAO", e);
		}
		
	}

	@Override
	public Professor buscar(int id) {
		Professor professor = new Professor();
		
		String SQL = "SELECT * FROM professor WHERE id_prof = ?";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			ps.close();
			rs.close();
			return professor;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de professor", e);
		}
	}

	@Override
	public List<Professor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
