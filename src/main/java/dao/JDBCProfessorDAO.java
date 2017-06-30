package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
			String SQL = "INSERT INTO professor (coordenador, id_pessoa_prof) VALUES " + " (?,?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setBoolean(1, professor.isCoordenador());
			ps.setInt(2, professor.getId());
			ps.executeUpdate();
			ps.close();
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar professor em JDBCProfessorDAO", e);
		}
		
	}
	@Override
	public void editar(Professor professor) {
		try {
		String SQL = "UPDATE professor SET coordenador=? WHERE id_pessoa_prof=?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setBoolean(1, professor.isCoordenador());
			ps.setInt(2,  professor.getId());
			ps.executeUpdate();
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao editar registro de professor", e);
		}

	}

	@Override
	public Professor buscar(int id) {

		String SQL = "SELECT * FROM professor AS p, pessoa_usuario AS u, servidor AS s WHERE p.id_pessoa_prof=? AND u.id_pessoa_usuario = p.id_pessoa_prof AND p.id_pessoa_prof = s.id_pessoa_usuario";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Professor professor = new Professor();
				professor.setCoordenador(rs.getBoolean("coordenador"));
				professor.setId(rs.getInt("id_pessoa_prof"));
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professor.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				professor.setEmail(rs.getString("email"));
				professor.setSiape(rs.getString("siape"));
				rs.close();
				ps.close();
				
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
			String SQL = "SELECT * FROM professor AS p, pessoa_usuario AS u, servidor AS s WHERE u.id_pessoa_usuario = p.id_pessoa_prof AND u.id_pessoa_usuario = s.id_pessoa_usuario";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setCoordenador(rs.getBoolean("coordenador"));
				professor.setId(rs.getInt("id_pessoa_prof"));
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professor.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				professor.setEmail(rs.getString("email"));
				professor.setSiape(rs.getString("siape"));
				
				professores.add(professor);
				
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
