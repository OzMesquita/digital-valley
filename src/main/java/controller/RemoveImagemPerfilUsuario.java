package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import model.Usuario;
import util.Constantes;
import util.Facade;

/**
 * Servlet implementation class RemoveImagemPerfilUsuario
 */
public class RemoveImagemPerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveImagemPerfilUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pagina = "view/editarUsuario.jsp?erroEditar=1";
			String sessionMsg = "";
			try {

				// configurar objetos
				Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
				usuarioDaSessao.getPessoa().setImagem(null);;				
				Facade.editarUsuarioESenha(usuarioDaSessao.getPessoa(), usuarioDaSessao);
				// salvar sessao
				session.setAttribute("usuario", usuarioDaSessao);
				if(sessionMsg.isEmpty()) {
					pagina = "view/editarUsuario.jsp?sucessoEditar=1";
					sessionMsg = "Imagem removida com sucesso!";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				sessionMsg += e.getMessage();
			}
			session.setAttribute(Constantes.getSessionMsg(), sessionMsg);
			
		response.sendRedirect(pagina);
	}

}
