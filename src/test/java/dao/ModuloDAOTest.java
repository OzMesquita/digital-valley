package dao;

import model.Modulo;
import model.Perfil;
import model.Pessoa;

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
		modulo.setImagem("../assets2/img/new_logo.png");
		ModuloDAO md = DAOFactory.criarModuloDAO();

		md.cadastrar(modulo);
	}
	@Ignore
	@Test
	public void editar() {
		modulo.setId(4);
		modulo.setTitulo("Solicitação de Recorreção de prova");
		modulo.setUrl("Controle_de_Acesso/view/telaInicial.jsp");
		modulo.setImagem("../assets2/img/Revisao-de-Prova.jpg");
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
	@Ignore
	@Test
	public void listarPorPessoa() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(5);
		ModuloDAO md = DAOFactory.criarModuloDAO();
		List<Modulo> modulos = md.buscar(pessoa);
		System.out.println("Listar por pessoa: "+modulos.size());
		for(Modulo m: modulos){
			System.out.println("id "+m.getId());
			System.out.println("titulo "+m.getTitulo());
		}
		Assert.assertTrue(modulos != null);

	}
	
	@Ignore
	@Test
	public void listar() {
		ModuloDAO md = DAOFactory.criarModuloDAO();
		List<Modulo> modulos = md.listar();
		for(Modulo m:modulos){
			System.out.println("Nome: "+m.getTitulo());
			System.out.println("Imagem: "+m.getImagem());
		}
		Assert.assertTrue(modulos != null);

	}
	
	@Ignore
	@Test
	public void testAssociarUsuario(){
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		mDAO.associarUsuarioModulo(6, 4);
	}
	
	@Ignore
	@Test
	public void testAssociarPerfil(){
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		mDAO.associarPerfilModulo(5, 10);
	}
	
	@Ignore
	@Test
	public void testBuscarPorNome(){
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		Modulo m = mDAO.buscarPorNome("MODULO 1") ;
		System.out.println(m.getTitulo());
		Assert.assertTrue(m!= null);
	}
	
	@Test
	public void testListarModuloPorPerfil(){
		ModuloDAO mDAO = dao.DAOFactory.criarModuloDAO();
		Perfil p = new Perfil();
		p.setNome("Aluno");
		p.setId(1);
		List<Modulo> modulos = mDAO.buscar(p);
		
		for(Modulo m: modulos){
			System.out.println(m.getTitulo());
		}
	}
	
}
