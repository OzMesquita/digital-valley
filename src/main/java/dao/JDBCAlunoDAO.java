package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.ConnectionFactory;

public class JDBCAlunoDAO implements AlunoDAO{
	Connection connection;

	public JDBCAlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void cadastrar(Aluno aluno) {
		
		String SQL = "INSERT INTO aluno (matricula, semestre_ingresso, id_pessoa_aluno) VALUES" + "(?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, aluno.getMatricula());
			ps.setString(2, aluno.getSemestreIngresso());
			ps.setInt(3, aluno.getId());
			
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar um aluno em JDBCAlunoDAO", e);
		}
	}
	
	@Override
	public Aluno buscar(int id) {
		String SQL = "SELECT * FROM aluno WHERE id_pessoa_aluno = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_aluno"));

				rs.close();
				ps.close();
				return aluno;
				
			}else{
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}
	}
	
	@Override
	public List<Aluno> listar() {
		String SQL = "SELECT * FROM aluno";
		try {
			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setMatricula(rs.getString("matricula"));
				a.setSemestreIngresso(rs.getString("semestre_ingresso"));
				alunos.add(a);
			}
			
			rs.close();
			ps.close();
			return alunos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC AlunoDAO", e);

		}
	}
}
