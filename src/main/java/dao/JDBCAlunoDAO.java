package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.ConnectionFactory;

public class JDBCAlunoDAO implements AlunoDAO {
	Connection connection;

	public JDBCAlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void cadastrar(Aluno aluno) {
		
		String SQL = "INSERT INTO aluno (matricula, semestre_ingresso, id_pessoa_aluno) VALUES" + "(?,?,?)";
		
		try {
<<<<<<< HEAD
			String SQL = "INSERT INTO aluno (matricula, id_curso, semestre_ingresso, id_pessoa_usuario) VALUES"
					+ "(?,?,?,?)";

=======
>>>>>>> f78a0c097a6823c3a54ad1c7b35fa8decbdb4add
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, aluno.getMatricula());
<<<<<<< HEAD
			ps.setInt(2, aluno.getCurso().getId());
			ps.setString(3, aluno.getSemestreIngresso());
			ps.setInt(4, aluno.getId());

=======
			ps.setString(2, aluno.getSemestreIngresso());
			ps.setInt(3, aluno.getId());
			
>>>>>>> f78a0c097a6823c3a54ad1c7b35fa8decbdb4add
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
<<<<<<< HEAD

			String SQL = "SELECT * FROM aluno WHERE id_pessoa_usuario = ?";
=======
>>>>>>> f78a0c097a6823c3a54ad1c7b35fa8decbdb4add
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
<<<<<<< HEAD
			rs.next();

			aluno.setMatricula(rs.getString("matricula"));
			aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
			aluno.setId(rs.getInt("id_pessoa_usuario"));
			ps.close();
			rs.close();
=======
			
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
>>>>>>> f78a0c097a6823c3a54ad1c7b35fa8decbdb4add

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}
	}

	@Override
	public List<Aluno> listar() {
		String SQL = "SELECT * FROM aluno";
		try {
<<<<<<< HEAD
			String SQL = "SELECT * FROM aluno";
=======
			List<Aluno> alunos = new ArrayList<Aluno>();
>>>>>>> f78a0c097a6823c3a54ad1c7b35fa8decbdb4add
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

	@Override
	public void editar(Aluno aluno) {
		try {
			String SQL = "UPDATE aluno SET semestre_ingresso=?,matricula=?, id_curso=? WHERE id_pessoa_usuario = ?";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, aluno.getSemestreIngresso());
			ps.setString(2, aluno.getMatricula());
			ps.setInt(3, aluno.getCurso().getId());
			ps.setInt(4, aluno.getId());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao editar registro de aluno", e);
		}

	}
}
