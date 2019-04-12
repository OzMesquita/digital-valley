package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Aluno;
import model.Pessoa;
import model.Servidor;
import model.Usuario;
import util.Constantes;
import util.Facade;
public class EditarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pagina = "editarUsuario.jsp?sucessoEditar=0";
			String sessionMsg = "";
			try {

				// configurar objetos
				Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
				Pessoa pessoaDaSessao = usuarioDaSessao.getPessoa();
				usuarioDaSessao.getPessoa().setDataNascimento(req.getParameter("nascimento"));
				usuarioDaSessao.getPessoa().setEmail(req.getParameter("email"));
				//usuarioDaSessao.setLogin(req.getParameter("login"));
				Facade.editarUsuarioESenha(usuarioDaSessao.getPessoa(), usuarioDaSessao);
				// salvar sessao
				session.setAttribute("usuario", usuarioDaSessao);
				if(sessionMsg.isEmpty()) {
					pagina = "editarUsuario.jsp?sucessoEditar=1";
					sessionMsg = "Dados alterados com sucesso";
					session.setAttribute(Constantes.getSessionMsg(), sessionMsg);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				sessionMsg += e.getMessage();
			}
			session.setAttribute(Constantes.getSessionMsgError(), sessionMsg);
			
		resp.sendRedirect(pagina);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("editarUsuario.jsp").forward(req, resp);
	}

}
