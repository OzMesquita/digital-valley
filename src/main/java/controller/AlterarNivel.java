package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.EnumNivel;
import model.EnumPerfil;
import model.Pessoa;
import model.Servidor;
import model.Usuario;
import util.Constantes;

public class AlterarNivel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer nivel= Integer.valueOf(request.getParameter("nivel"));
		int idUsuario = Integer.valueOf(request.getParameter("idUsuario"));
		String pagina = "editarNivelDoUsuario.jsp?idUsuario="+idUsuario;
		HttpSession session = request.getSession();

		try {
			
			Pessoa pessoa = util.Facade.buscarPessoaPorId(idUsuario);
			Usuario usuario = pessoa.getUsuario();
			usuario.setNivel(nivel);
			if(nivel == EnumNivel.ADMINISTRADOR.getValorNivel()) {
				usuario.setPerfil(EnumPerfil.ADMINISTRADOR);
			}else {
				if((usuario.getPessoa() instanceof Aluno)==false && (usuario.getPessoa() instanceof Servidor)==false) {
					usuario.setPerfil(EnumPerfil.VISITANTE);
				}else if(usuario.getPessoa() instanceof Aluno) {
					usuario.setPerfil(EnumPerfil.ALUNO);
				}else {
					usuario.setPerfil(EnumPerfil.SERVIDOR);
				}
			}
			
			
			util.Facade.editarPessoa(pessoa, usuario);
			pagina = util.Constantes.getAdmUrl()+"/listar_usuarios?sucessoEditar=1&idUsuario="+idUsuario;
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}

		
		response.sendRedirect(pagina);
		

	}

}