package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Pessoa;
import util.ConnectionFactory;


public class JDBCPessoaDAO implements PessoaDAO{

	Connection connection;
	
	public JDBCPessoaDAO(){
		
		connection = ConnectionFactory.getConnection();
		
	}
	
	
	@Override
	public void cadastrar(Pessoa pessoa) {
		try {
		String SQL = "INSERT INTO pessoa_usuario (nome, cpf, email, login, senha , data_nascimento,id) VALUES"
				+ "(?,?,?,?,?,?,?)";
		
			PreparedStatement ps =  connection.prepareStatement(SQL);
			
			ps.setString(1,pessoa.getNome());
			ps.setString(2,pessoa.getCpf());
			ps.setString(3, pessoa.getEmail());
			ps.setString(4, pessoa.getUsuario().getLogin());
			ps.setString(5, pessoa.getUsuario().getSenha());
			ps.setDate(6, Date.valueOf(pessoa.getDataNascimento()));
			ps.setInt(7, pessoa.getId());
		
			ps.executeUpdate();
			
			ps.close();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void editar(Pessoa pessoa) {
		
		
		
		
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
