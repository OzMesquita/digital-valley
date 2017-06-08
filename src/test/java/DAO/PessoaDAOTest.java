package DAO;

import java.time.LocalDate;

import org.junit.Test;

import model.Pessoa;
import model.Usuario;

public class PessoaDAOTest {
@Test
	public void salvarPessoa(){
		Pessoa p = new Pessoa();
		p.setNome("Maria");
		p.setCpf("12345678901");
		p.setDataNascimento(LocalDate.of(1990, 6, 20));
		p.setEmail("chicasilva@hotmail.com");
		
		Usuario u = new Usuario();
		u.setLogin("maria1");
		u.setSenha("1q2w3e4r");
		
		
		p.setUsuario(u);
		u.setPessoa(p);
		
		PessoaDAO pDAO = new PessoaDAO();
		pDAO.salvar(p);
		
		
	}

}
