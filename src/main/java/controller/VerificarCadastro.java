package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Servidor;
import util.Facade;

public class VerificarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String siape = request.getParameter("siape");
		String nome = request.getParameter("nome");
		String pagina = "verificacaoCadastro.jsp?erroVerificacao=1";
		HttpSession session = request.getSession();
		System.out.println("servlet");
		try {
			if (matricula != null) {

				Aluno aluno = Facade.verificacaoAluno(matricula);
				System.out.println("Entrou IF");
				if (aluno != null) {

					System.out.println("Nome: " + aluno.getNome());
					if (Facade.compararNomes(aluno.getNome(), nome)) {
						System.out.println("Login: " + aluno.getUsuario().getLogin());
						if (aluno.getUsuario().getLogin() != null) {
							throw new Exception("Erro, Aluno(a) " + aluno.getNome() + " já possui cadastro");
						}
						pagina = "/Controle_de_Acesso/cadastro/cadastraAluno.jsp";
						session.setAttribute("cadastro", "ok");
						System.out.println("sucesso");
					}else{
						throw new Exception("Matricula e/ou nome inválidos");
					}

				}
			}else if(siape != null){
				Servidor servidor = Facade.verificacaoServidor(siape);
				if(servidor != null){
					if(Facade.compararNomes(servidor.getNome(), nome)){
						if (servidor.getUsuario().getLogin() != null) {
							throw new Exception("Erro, Servidor(a) " + servidor.getNome() + " já possui cadastro");
						}
						pagina = "/Controle_de_Acesso/cadastro/cadastraAluno.jsp";
						session.setAttribute("cadastro", "ok");
						
					}else{
						throw new Exception("SIAPE e/ou nome inválidos");
					}
					
				}
				
			}
		} catch (Exception e) {
			session.setAttribute("excecao", e.getMessage());
			System.out.println("excecao : " + e.getMessage());
		}

		response.sendRedirect(pagina);

	}

}
