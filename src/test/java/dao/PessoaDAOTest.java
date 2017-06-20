package dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
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

		pessoa.setNome("Tágila Lima");
		pessoa.setCpf("01111111111");
		pessoa.setEmail("tagila@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1996, 10, 15));
		pessoa.setUsuario(new Usuario("tagila", "tag123"));
		PessoaDAO pd = DAOFactory.criarPessoaDAO();

		pd.cadastrar(pessoa);

	}

	@Ignore
	@Test
	public void editar() {
		pessoa.setId(3);
		pessoa.setNome("Lima");
		pessoa.setCpf("12345678901");
		pessoa.setEmail("tagila@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1996, 10, 15));
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();

		pdao.editar(pessoa);

	}

	@Ignore
	@Test
	public void remover() {

		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		pessoa.setId(3);
		pdao.remover(pessoa.getId());

	}

	//@Ignore
	@Test
	public void buscar() {//erro ao atribuir os dados do banco na pessoa criada aqui no teste.
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		pessoa.setId(2);

		Assert.assertTrue(pdao.buscar(pessoa.getId()) == null);
		
		 Pessoa p = pdao.buscar(pessoa.getId());
		
		System.out.println("===========================================");
		System.out.println("ID : " + p.getId());
		System.out.println("Nome : " + p.getNome());
		System.out.println("CPF : " + p.getCpf());
		System.out.println("email : " + p.getEmail());
		System.out.println("Data de Nascimento : " + p.getDataNascimento());
		System.out.println("Login : " + p.getUsuario().getLogin());
		System.out.println("===========================================");

	}

	@Ignore
	@Test
	public void listar() {//erro ao buscar id, sempre imprime o valor 0
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
	}

}
