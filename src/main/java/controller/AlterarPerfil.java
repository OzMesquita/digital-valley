package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import model.Curso;
import model.EnumPerfil;
import model.Pessoa;
import util.Constantes;
import util.Facade;

public class AlterarPerfil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "editarNivelDoUsuario.jsp?erroEditarPerfil=1";
		HttpSession session = request.getSession();
		try {
		
		int perfilNovo = Integer.valueOf(request.getParameter("perfil"));
		int idPessoa = Integer.valueOf(request.getParameter("pessoa"));
		int idCurso = Integer.valueOf(request.getParameter("curso"));
		String matricula = request.getParameter("matricula");
		String siape = request.getParameter("siape");
		String cargo = request.getParameter("cargo");
		String semestreIngresso = request.getParameter("semestreIngresso");
		
		Pessoa pessoa = Facade.buscarPessoaPorId(idPessoa);
		Curso curso = DAOFactory.criarCursoDAO().buscar(idCurso);
		
		
		switch(perfilNovo) {
			case 1:
				// para Administrador
				if(!pessoa.getUsuario().getPerfil().equals(EnumPerfil.ADMINISTRADOR)) {
					pessoa.getUsuario().setPerfil(EnumPerfil.ADMINISTRADOR);
					DAOFactory.criarUsuarioDAO().editar(pessoa.getUsuario());
					
				}else {
					throw new Exception("Usuário já é do Perfil Administrador");
				}
				
				
				break;
				
			case 2:
				// para aluno
				if(!pessoa.getUsuario().getPerfil().equals(EnumPerfil.ALUNO)) {
					Facade.alterarPerfilParaAluno(pessoa,matricula,semestreIngresso, curso);
					
					
				}else {
					throw new Exception("Usuário já é do Perfil Estudante");
				}
				break;
				
			case 3:
				// para servidor
				if(!pessoa.getUsuario().getPerfil().equals(EnumPerfil.SERVIDOR)) {
					Facade.alterarPerfilParaServidor(pessoa, siape, cargo);
					
				}else {
					throw new Exception("Usuário já é do Perfil Estudante");
				}
				
				
				break;
				
			case 4:
				// para Visitante
				if(!pessoa.getUsuario().getPerfil().equals(EnumPerfil.VISITANTE)) {
					pessoa.getUsuario().setPerfil(EnumPerfil.VISITANTE);
					DAOFactory.criarUsuarioDAO().editar(pessoa.getUsuario());
					
				}else {
					throw new Exception("Usuário já é do Perfil Visitante");
				}
				
				break;
		
		}
		pagina = "editarNivelDoUsuario.jsp?sucessoEditarPerfil=1";
		
		

		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect(pagina);
		
		
	}
}
