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

		try {
			String SQL = "INSERT INTO pessoa_aluno (matricula, curso, semestre_ingresso, id_pessoa_al) VALUES" + "(?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, aluno.getMatricula());
            ps.setString(2, aluno.getCurso().toString());
			ps.setString(3, aluno.getSemestreIngresso());
			ps.setInt(4, aluno.getId());
			
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar um aluno em JDBCAlunoDAO", e);
		}
	}
	
	@Override
	public Aluno buscar(int id) {
		try {
			Aluno aluno = new Aluno();
			String SQL = "SELECT * FROM pessoa_aluno WHERE id_pessoa_al = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			aluno.setMatricula(rs.getString("matricula"));
			aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
			aluno.setId(rs.getInt("id_pessoa_al"));
			ps.close();
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}

		return null;
	}
	
	@Override
	public List<Aluno> listar() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			String SQL = "SELECT * FROM pessoa_aluno";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setMatricula(rs.getString("matricula"));
				a.setSemestreIngresso(rs.getString("semestre_ingresso"));
				alunos.add(a);
			}
			ps.close();
			rs.close();
			return alunos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC AlunoDAO", e);

		}
	}
}
