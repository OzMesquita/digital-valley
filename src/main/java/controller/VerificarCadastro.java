package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.StringUtils;

import dao.AlunoDAO;
import dao.DAOFactory;
import dao.ServidorDAO;
import model.Aluno;
import model.Servidor;
import util.Constantes;
import util.Facade;

/**
 * Verifica cadastro no guardião
 *
 */
public class VerificarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String siape = request.getParameter("siape");
		String nomeA = request.getParameter("nomeA");
		String nomeS = request.getParameter("nomeS");
		String inserindoAluno = request.getParameter("inserindoAluno");
		String pagina = "verificacaoCadastro.jsp?erroVerificacao=1";
		HttpSession session = request.getSession();

		try {
			
			StringBuffer msgError = new StringBuffer();
		
			if (inserindoAluno.equals("aluno")) {
				if (matricula.isEmpty() || nomeA.isEmpty()) {
					msgError.append("Campos matricula e nome são requeridos");
				}

			} else if(inserindoAluno.equals("servidor")) {
				if (siape.isEmpty() ||nomeS.isEmpty()) {
					msgError.append("Campos SIAPE e nome são requeridos");
				}

			}
			
			if(!msgError.toString().isEmpty()) {
				throw new Exception(msgError.toString());
			}
			
			if (!matricula.equals("")) {
				/*Alteração para determinar tipo de erro gerado para o usuario*/
				Aluno a = DAOFactory.criarAlunoDAO().buscarPorMatricula(matricula);
				if( !(Facade.verificacaoAluno(matricula)) && a==null) {//torquei == por != e da problema
					throw new Exception("Matricula não encontrada. Entre em contato com N2S pelo email n2s@ufc.br!");
				}
				  else if( Facade.verificacaoAluno(matricula)==false && Facade.verificacaoAluno(matricula, nomeA)==true) {
					throw new Exception("Nome não identificado. Por favor verificar.");
				}
				/*Fim das alterações*/
				/*//alterei para testar se esse if é relevante.(Matheus)
				 * if (!Facade.verificacaoAluno(matricula, nomeA) ||
				 * Facade.verificacaoAluno(matricula, nomeA) ) {
				 */
					AlunoDAO aDAO = DAOFactory.criarAlunoDAO(); 
					Aluno aluno = aDAO.buscarPorMatricula(matricula);
					//Aluno aluno = DAOFactory.criarAlunoDAO().buscarPorMatricula(matricula); //teste
					//Aluno aluno = a; // teste
					
					if (aluno != null) { //troquei o == por != (Matheus)

						//throw new Exception("Aluno(a) " + aluno.getNome() + " já possui cadastro");
						throw new Exception("Aluno(a) de matricula " + aluno.getMatricula() + " já possui cadastro!");

					} else if(Facade.verificacaoAluno(matricula, nomeA)==true) {
						pagina = "cadastro/cadastrarUsuario.jsp";
						session.setAttribute("preCadastro", "ok");
						session.setAttribute("nomeA", nomeA);
						session.setAttribute("matricula", matricula);
						session.setAttribute("curso", util.Facade.buscarCursoPreCadastrado(matricula, nomeA));
					} else {//Se chegou nessa parte, significa que a matricula foi identificada.
						throw new Exception("Nome não identificado, verifique se digitou conforme recomendado!");
					}
				//}
				
				/*
				 * if (session.getAttribute("matricula") == null) {
				 * 
				 * throw new Exception("Pré-cadastro de aluno não identificado"); }
				 */

			} else if (!siape.equals("")) {
				/*Alteração para determinar tipo de erro gerado para o usuario*/
				Servidor s = DAOFactory.criarServidorDAO().buscarPorSiape(siape);
				if( !(Facade.verificacaoServidor(siape)) && s == null) {
					throw new Exception("Siape não encontrado. Entre em contato com N2S pelo email n2s@ufc.br!");
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
