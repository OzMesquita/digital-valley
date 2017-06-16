package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import model.Pessoa;
import model.Usuario;
import util.DAOFactory;

public class JDBCPessoaDAOTest {
	Pessoa pessoa = new Pessoa();

	@Test
	public void salvar() {
		pessoa.setId(681);
		pessoa.setNome("Mariaana");
		pessoa.setCpf("12345678909");
		pessoa.setEmail("luan@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1994, 8, 22));
		pessoa.setUsuario(new Usuario("ldharlin", "luan123", pessoa));

		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		
		pd.cadastrar(pessoa);

	}
	@Test
	public void editar() throws Exception {
	
	}
		
	
	public void remover(int id) {}
	
	
	
	public Pessoa buscar(int id) {
		return null;
	}
	
	
/*	
	//erro : " method listar() should be void"
	@Ignore
	@Test
	public List<Pessoa> listar() {
		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		List<Pessoa> pessoas = pd.listar();
		for (Pessoa pessoa : pessoas) {
			System.out.println("===========================================");
			System.out.println("ID : " + pessoa.getId());
			System.out.println("Nome : " + pessoa.getNome());
			System.out.println("CPF : " + pessoa.getCpf());
			System.out.println("email : " + pessoa.getEmail());
			System.out.println("Data de Nascimento : " + pessoa.getDataNascimento());
			System.out.println("Login : " + pessoa.getUsuario().getLogin());
			System.out.println("===========================================");

		}

		return pessoas;
	}
*/
	
}
