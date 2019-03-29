package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AlunoDAO;
import dao.DAOFactory;
import dao.ServidorDAO;
import model.Aluno;
import model.Servidor;
import util.Constantes;
import util.Facade;

public class VerificarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String siape = request.getParameter("siape");
		String nomeA = request.getParameter("nomeA");
		String nomeS = request.getParameter("nomeS");
		String pagina = "verificacaoCadastro.jsp?erroVerificacao=1";
		HttpSession session = request.getSession();

		try {
			if (!matricula.equals("")) {
				/*Alteração para determinar tipo de erro gerado para o usuario*/
				Aluno a = DAOFactory.criarAlunoDAO().buscarPorMatricula(matricula);
				if( !(Facade.verificacaoAluno(matricula)) && a==null) {
					throw new Exception("Matricula não encontrada. Por favor entre em contato contato com N2S");
				}else if( Facade.verificacaoAluno(matricula)==false && Facade.verificacaoAluno(matricula, nomeA)==true) {
					throw new Exception("Nome não identificado. Por favor verificar.");
				}
				/*Fim das alterações*/
				if (Facade.verificacaoAluno(matricula, nomeA)) {
					AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
					Aluno aluno = aDAO.buscarPorMatricula(matricula);
					if (aluno != null) {

						throw new Exception("Aluno(a) " + aluno.getNome() + " já possui cadastro");

					} else {
						pagina = "cadastro/cadastrarUsuario.jsp";
						session.setAttribute("preCadastro", "ok");
						session.setAttribute("nomeA", nomeA);
						session.setAttribute("matricula", matricula);
						session.setAttribute("curso", util.Facade.buscarCursoPreCadastrado(matricula, nomeA));
					}
				}
				
				if (session.getAttribute("matricula") == null) {

					throw new Exception("Pre cadastro de aluno não identificado");
				}

			} else if (!siape.equals("")) {
				/*Alteração para determinar tipo de erro gerado para o usuario*/
				Servidor s = DAOFactory.criarServidorDAO().buscarPorSiape(siape);
				if( !(Facade.verificacaoAluno(matricula)) && s == null) {
					throw new Exception("Matricula não encontrada. Por favor entre em contato contato com N2S");
				}else if( Facade.verificacaoServidor(siape)==false && Facade.verificacaoServidor(siape, nomeS)==true) {
					throw new Exception("Nome não identificado. Por favor verificar.");
				}				
				/*Fim das alterações*/
				if (Facade.verificacaoServidor(siape, nomeS)) {
					ServidorDAO sDAO = DAOFactory.criarServidorDAO();
					Servidor servidor = sDAO.buscarPorSiape(siape);
					if (servidor != null) {

						throw new Exception("Servidor(a) " + servidor.getNome() + " já possui cadastro");
					}
					
					pagina = "cadastro/cadastrarUsuario.jsp";
					session.setAttribute("preCadastro", "ok");
					session.setAttribute("nomeS", nomeS);
					session.setAttribute("siape", siape);

				} else if(session.getAttribute("")==null){
						session.setAttribute(Constantes.getSessionMsgError(), "Pre cadastro não identificado");
						throw new Exception("Pre cadastro não identificado");
					}
				}

		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());
		}

		response.sendRedirect(pagina);

	}

}
