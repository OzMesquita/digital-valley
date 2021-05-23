package model;

import org.junit.Ignore;
import org.junit.Test;

public class AlunoTest {

	Aluno a = new Aluno();
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void matriculaInvalida(){
		a.setMatricula("123");
	}

	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void semestreIgressoInvalido(){
		a.setSemestreIngresso(" ");
	}
	
	@Ignore
	@Test
	public void valido(){
		a.setMatricula("1234567");
		a.setSemestreIngresso("2017.1");
	}
}
