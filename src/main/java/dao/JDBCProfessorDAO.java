package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar professor em JDBCProfessorDAO", e);
		}
		
	}

	@Override
	public Professor buscar(int id) {

		String SQL = "SELECT * FROM professor WHERE id_prof = ?";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Professor professor = new Professor();
				professor.setId(rs.getInt("id_prof"));
				
				rs.close();
				ps.close();
				
				connection.close();
				return professor;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de professor", e);
		}
	}

	@Override
	public List<Professor> listar() {
		List<Professor> professores = new ArrayList<Professor>();
		try {
			String SQL = "SELECT * FROM professor";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt("id_prof"));
				//Mais atributos
				//...
				
				professores.add(p);
				
			}

			ps.close();
			rs.close();
			
			connection.close();
			return professores;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar professor em JDBCProfessorDAO", e);

		}

	}

}
