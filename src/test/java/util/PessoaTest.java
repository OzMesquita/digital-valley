package util;
import org.junit.Ignore;
import org.junit.Test;

import model.Pessoa;


public class PessoaTest {
	
	@Ignore	
	@Test
	public void testData() {
		Pessoa p = new Pessoa();
		p.setDataNascimento("02/03/1995");
	}
	
}
