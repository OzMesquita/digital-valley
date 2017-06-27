package dao;

import model.Modulo;
import model.Pessoa;
import util.DAOFactory;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ModuloDAOTest {

	private Modulo modulo = new Modulo();
	@Ignore
	@Test
	public void salvar() {
		modulo.setTitulo("Solicitação de Recorreção de prova");
		modulo.setUrl("Controle_de_Acesso/view/telaInicial.jsp");
		modulo.setImagem("assets2/img/new_logo.png");
		ModuloDAO md = DAOFactory.criarModuloDAO();

		md.cadastrar(modulo);
	}
	@Ignore
	@Test
	public void editar() {
		modulo.setId(5);
		modulo.setTitulo("Solicitação de Recorreção de prova");
		modulo.setUrl("Controle_de_Acesso/view/telaInicial.jsp");
		modulo.setImagem("assets2/img/new_logo.png");
		ModuloDAO md = DAOFactory.criarModuloDAO();

		md.editar(modulo);
	}
	@Ignore
	@Test
	public void remover() {
		modulo.setId(1);
		ModuloDAO md = DAOFactory.criarModuloDAO();
		md.remover(modulo.getId());
	}
	@Ignore
	@Test
	public void buscar() {
		ModuloDAO md = DAOFactory.criarModuloDAO();
		modulo.setId(3);

		Assert.assertTrue(md.buscar(modulo.getId()) != null);
	}
	
	@Test
	public void listarPorPessoa() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(8);
		ModuloDAO md = DAOFactory.criarModuloDAO();
		List<Modulo> modulos = md.buscar(pessoa);
		for(Modulo m: modulos){
			System.out.println("id"+m.getId());
		}
		Assert.assertTrue(modulos != null);

	}
	@Ignore
	@Test
	public void listar() {
		ModuloDAO md = DAOFactory.criarModuloDAO();
		List<Modulo> modulos = md.listar();
		Assert.assertTrue(modulos != null);

	}
}
