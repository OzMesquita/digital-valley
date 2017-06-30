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
		pessoa.setNome("Francisca Tagila Lima da Silva");
		pessoa.setCpf("11111111111");
		pessoa.setEmail("tagila@c.com");
		pessoa.setDataNascimento(LocalDate.of(1996, 10, 15));
		pessoa.setUsuario(new Usuario("tagila", "tag123"));
		PessoaDAO pd = DAOFactory.criarPessoaDAO();

		pd.cadastrar(pessoa);

	}
	@Ignore
	@Test
	public void editar() {
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
		pessoa.setId(6);
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		pdao.remover(pessoa.getId());

	}
	@Ignore
	@Test
	public void buscar() {
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		pessoa.setId(4);

		Assert.assertTrue(pdao.buscarPorId(pessoa.getId()) != null);

	}

	//@Ignore
	@Test
	public void buscarUsuario() {
		PessoaDAO pdao = DAOFactory.criarPessoaDAO();
		pessoa.setUsuario(new Usuario());
		pessoa.getUsuario().setLogin("deyvison");
		pessoa = pdao.buscarPorLogin("deyvison");

		Assert.assertTrue(pessoa != null);
		 System.out.println("Pessoa ID: "+ pessoa.getId());
		 System.out.println("Pessoa Nome: "+ pessoa.getNome());
		 System.out.println("Pessoa CPF: "+ pessoa.getCpf());
		// System.out.println("Pessoa Login: "+ pessoa.getUsuario().getLogin());
		// System.out.println("Pessoa Senha: "+ pessoa.getUsuario().getSenha());
		//

	}

	@Ignore
	@Test
	public void listar() {
		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		List<Pessoa> pessoas = pd.listar();
		Assert.assertTrue(pessoas != null);
	}

}
