package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import model.Servidor;
import util.DAOFactory;

public class ServidorDAOTest {

	Servidor servidor = new Servidor();

	
	@Test
	public void cadastrar() {
		servidor.setSiape("1237654");
		ServidorDAO sdao = DAOFactory.criarServidorDAO();

		servidor.setId(75);
		sdao.cadastrar(servidor);
	}

	@Ignore
	@Test
	public void buscar() {
		ServidorDAO sdao = DAOFactory.criarServidorDAO();
		servidor.setSiape("7654321");

		Assert.assertTrue(sdao.buscar(servidor.getSiape()) != null);

	}

	@Ignore
	@Test
	public void listar() {
		ServidorDAO sdao = DAOFactory.criarServidorDAO();
		List<Servidor> servidores = sdao.listar();
		Assert.assertTrue(servidores != null);

	}
	
	@Test
	public void testBuscarPorSiape(){
		ServidorDAO sDAO = DAOFactory.criarServidorDAO();
		Assert.assertTrue(sDAO.buscarPorSiape("1231231") != null);
		
	}
	
	@Test
	public void testPreCadastro(){
		ServidorDAO sDAO = DAOFactory.criarServidorDAO();
		Assert.assertTrue(sDAO.buscarPreCadastro("1234567", "Ayslan"));
	}

}
