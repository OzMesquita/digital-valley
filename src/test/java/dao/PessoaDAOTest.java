package dao;

import java.time.LocalDate;


import org.junit.Ignore;
import org.junit.Test;

import dao.PessoaDAO;
import model.Pessoa;
import model.Usuario;
import util.DAOFactory;


public class PessoaDAOTest {
	
	private Pessoa pessoa = new Pessoa();

	@Ignore
	@Test
	public void salvar() {
		
		pessoa.setId(2);
		pessoa.setNome("Deyvison");
		pessoa.setCpf("12345678910");
		pessoa.setEmail("deyvison@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1994, 8, 22));
		pessoa.setUsuario(new Usuario("deyvison", "deyvison123", pessoa));
		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		
		pd.cadastrar(pessoa);

	}

		

	@Test
	public void editar() {
		pessoa.setId(3);
		pessoa.setNome("Deyvison2");
		pessoa.setCpf("12345678911");
		pessoa.setEmail("deyvison@.com");
		pessoa.setDataNascimento(LocalDate.of(1995, 8, 22));
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		pdao.editar(pessoa);
		
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
