package dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.Usuario;
import util.ConnectionFactory;

public class JDBCAlunoDAO implements AlunoDAO {
	Connection connection;

	public JDBCAlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void cadastrar(Aluno aluno) {
		try {

			String SQL = "INSERT INTO aluno (matricula, id_curso, semestre_ingresso, id_pessoa_usuario) VALUES"
					+ "(?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, aluno.getMatricula());
			ps.setInt(2, aluno.getCurso().getId());
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
	public void preCadastrar(String nome, String matricula, int curso) {
		try {

			String SQL = "INSERT INTO pre_cadastro_aluno( matricula, nome, id_curso)"
							+"VALUES (?, ?, ?);";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, nome);
			ps.setInt(3, curso);

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao pre cadastrar um aluno em JDBCAlunoDAO", e);
		}
	}

	@Override
	public Aluno buscar(int id) {
		
		try {
			String SQL = "SELECT * FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario=? AND u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				curso.setId(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome_curso"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				aluno.setEmail(rs.getString("email"));
				
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
	public Aluno buscarPorMatricula(String matricula) {
		
		try {
			String SQL = "SELECT * FROM aluno AS a, pessoa_usuario AS p_u, curso AS c WHERE a.matricula= ? AND a.id_pessoa_usuario = p_u.id_pessoa_usuario AND a.id_curso = c.id_curso";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, matricula);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				curso.setId(rs.getInt("id_curso"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				aluno.setUsuario(usuario);
				
				
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
		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			String SQL = "SELECT * FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso";
			
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				curso.setId(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome_curso"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				aluno.setEmail(rs.getString("email"));
				
				alunos.add(aluno);
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
	@Override
	public boolean buscarPreCadastro(String matricula, String nome){
		try {
			String SQL = "SELECT * FROM pre_cadastro_aluno WHERE matricula = ? AND UPPER(nome) LIKE UPPER(?)";

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, "%"+nome+"%");

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				
				
				rs.close();
				ps.close();
				
				return true;
				
			}else{
				rs.close();
				ps.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}
	}
}
