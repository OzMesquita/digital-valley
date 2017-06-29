package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Aluno;
import model.Servidor;
import util.DAOFactory;

public class ServidorDAOTest {

	Servidor servidor = new Servidor();

	@Ignore
	@Test
	public void cadastrar() {
		servidor.setSiape("1234576");
		ServidorDAO sdao = DAOFactory.criarServidorDAO();

		servidor.setId(5);
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

}
