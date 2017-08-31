package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AlunoDAO;
import dao.ServidorDAO;
import model.Aluno;
import model.Servidor;
import util.DAOFactory;
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
				if(Facade.verificacaoAluno(matricula, nomeA)){
					pagina = "cadastro/cadastrarUsuario.jsp";
					session.setAttribute("preCadastro", "ok");
					session.setAttribute("nomeA", nomeA);
					session.setAttribute("matricula", matricula);
					session.setAttribute("curso", util.Facade.buscarCursoPreCadastrado(matricula, nomeA));
				}else{
					AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
					Aluno aluno = aDAO.buscarPorMatricula(matricula);
					if(aluno != null){
						System.out.println("cadastrado");
						throw new Exception("Aluno(a) " + aluno.getNome() + " já possui cadastro");
					}else{
						System.out.println("nada");
						throw new Exception("Pre cadastro de aluno não identificado");
					}
				}
				
				
			}else if(!siape.equals("")){
				
				if(Facade.verificacaoServidor(siape, nomeS)){
					pagina = "cadastro/cadastrarUsuario.jsp";
					session.setAttribute("preCadastro", "ok");
					session.setAttribute("nomeS", nomeS);
					session.setAttribute("siape", siape);
					
				}else{
					ServidorDAO sDAO = DAOFactory.criarServidorDAO();
					Servidor servidor = sDAO.buscar(siape);
					if(servidor != null){
						System.out.println("cadastrado");
						throw new Exception("msg, Servidor(a) " + servidor.getNome() + " já possui cadastro");
					}else{
						System.out.println("nada");
						throw new Exception("msg, Pre cadastro não identificado");
					}
				}
				
			}
		} catch (Exception e) {
			session.setAttribute("msg", e.getMessage());
			System.out.println("excecao : " + e.getMessage());
		}

		response.sendRedirect(pagina);

	}

}
