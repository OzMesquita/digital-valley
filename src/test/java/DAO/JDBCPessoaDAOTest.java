package DAO;

import java.time.LocalDate;

import model.Pessoa;
import model.Usuario;
import util.DAOFactory;

public class JDBCPessoaDAOTest {
	
	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(673);	
		pessoa.setNome("Luan");	
		pessoa.setCpf("12345678909");
		pessoa.setEmail("luan@gmail.com");
		pessoa.setDataNascimento(LocalDate.of(1994, 8, 22));
		pessoa.setUsuario(new Usuario());
		pessoa.getUsuario().setLogin("ldharlin");
		pessoa.getUsuario().setSenha("luan123");		
		
		PessoaDAO pd = DAOFactory.criarPessoaDAO();
		
		pd.cadastrar(pessoa);
	
		
	}

}
