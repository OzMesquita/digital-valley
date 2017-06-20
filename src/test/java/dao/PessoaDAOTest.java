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
		
		pessoa.setId(6);
		pessoa.setNome("Francisca Tagila");
		pessoa.setCpf("11111111111");
		pessoa.setEmail("tagila@c.com");
		pessoa.setDataNascimento(LocalDate.of(1996, 10, 15));
		pessoa.setUsuario(new Usuario("tagila", "tag123", pessoa));
		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		
		pd.cadastrar(pessoa);

	}
	@Ignore
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
	@Test
	public void remover() {
		pessoa.setId(6);
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();	
		pdao.remover(pessoa.getId());
	}
	
	public void buscar() {
		
		pessoa.setId(3);
		pessoa.setNome("Tagila Lima");
		pessoa.setCpf("11111111111");
		pessoa.setDataNascimento(LocalDate.of(1996, 10, 15));
		pessoa.setEmail("tagila@c.com");
		pessoa.setUsuario(new Usuario("tagila", "tag123", pessoa));
		pessoa.getUsuario().setPessoa(pessoa);
		
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		
		pdao.buscar(pessoa.getId()); 
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
