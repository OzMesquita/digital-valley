package DAO;

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
			String SQL = "INSERT INTO pessoa_aluno ( matricula, curso, semestreIngresso) WHERE id=? VALUES" + "(?,?,?)";

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, aluno.getPessoa().getId());
			ps.setInt(2, aluno.getMatricula());
            ps.setString(3, aluno.getCurso().toString());
			ps.setString(4, aluno.getSemestreIngresso());
			
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
			String SQL = "SELECT * FROM pessoa_aluno WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			aluno.setNome(rs.getString("nome"));
			aluno.setMatricula(rs.getInt("matricula"));
			//aluno.setCurso(rs.getString("curso"));
			aluno.setSemestreIngresso(rs.getString("semestreIngresso"));
			
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
				a.setNome(rs.getString("nome"));
				a.setMatricula(rs.getInt("matricula"));
				//a.setCurso(rs.getString("curso"));
				a.setSemestreIngresso(rs.getString("semestreIngresso"));
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
