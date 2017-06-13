package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import util.ConnectionFactory;

public class JDBCPessoaDAO implements PessoaDAO {

	Connection connection;

	public JDBCPessoaDAO() {

		connection = ConnectionFactory.getConnection();

	}

	@Override
	public void cadastrar(Pessoa pessoa) {
		try {
			String SQL = "INSERT INTO pessoa_usuario (nome, cpf, email , data_nascimento,id) VALUES"
					+ "(?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getEmail());
			ps.setDate(4, Date.valueOf(pessoa.getDataNascimento()));
			ps.setInt(5, pessoa.getId());

			ps.executeUpdate();

			ps.close();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar pessoas em JDBCpessoaDAO", e);
		}

	}

	
	@Override
	public void editar(Pessoa pessoa) {
		try {
		String SQL = "UPDATE pessoa_usuario SET nome=?, cpf=?, email=?, data_nascimento = ?, login=? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getEmail());
			ps.setDate(4, Date.valueOf(pessoa.getDataNascimento()));
			ps.setString(5, pessoa.getUsuario().getLogin());
			ps.setInt(6, pessoa.getId());
		
			ps.executeUpdate();
			ps.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao editar registro de pessoa", e);
		}

	}

	@Override
	public void remover(int id) {

		try {
			String SQL = "DELETE FROM pessoa_usuario WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover registro de pessoas em JDBC pessoaDAO", e);
		}

	}

	@Override
	public Pessoa buscar(int id) {
		try {
			Pessoa pessoa = new Pessoa();
			String SQL = "SELECT * FROM pessoa_usuario WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			pessoa.setId(rs.findColumn("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setCpf(rs.getString("cpf"));
			pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
			pessoa.setEmail(rs.getString("email"));
			pessoa.getUsuario().setLogin(rs.getString("login"));
			pessoa.getUsuario().setSenha(rs.getString("senha"));
			pessoa.getUsuario().setPessoa(pessoa);
			ps.close();
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de pessoa", e);
		}

		return null;
	}

	@Override
	public List<Pessoa> listar() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			String SQL = "SELECT * FROM pessoa_usuario";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setEmail(rs.getString("email"));
				p.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				p.getUsuario().setLogin(rs.getString("login"));
				pessoas.add(p);
			}

			ps.close();
			rs.close();
			return pessoas;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);

		}

	}

}
