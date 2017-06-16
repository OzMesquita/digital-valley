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
		
		pessoa.setId(1);
		pessoa.setNome("Tágila Lima");
		pessoa.setCpf("01111111111");
		pessoa.setEmail("tagila@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1996, 10, 15));
		pessoa.setUsuario(new Usuario("tagila", "tag123", pessoa));
		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		
		pd.cadastrar(pessoa);

	}
	
	@Test
	public void editar() {
		pessoa.setId(681);
		pessoa.setNome("Mariana");
		pessoa.setCpf("12345678909");
		pessoa.setEmail("luan@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1994, 8, 22));
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		
		pdao.editar(pessoa);
		
	}
	@Ignore
	@Test
	public void remover() {
				
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();	
		pdao.remover(pessoa.getId());
	}
	
	
	
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
