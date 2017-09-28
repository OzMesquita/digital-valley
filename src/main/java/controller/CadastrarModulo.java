package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Modulo;
import model.Perfil;
import util.Constantes;
import util.Facade;

public class CadastrarModulo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String url = request.getParameter("url");
		String imagem = request.getParameter("imagem");
		List<Perfil> perfis = Facade.ListarPeril();
		HttpSession session = request.getSession();
		
		
		String pagina = "cadastarModulo.jsp?erroCadastro=1";
		try {
				
			Modulo modulo = new Modulo();
			
			modulo.setImagem(imagem);
			modulo.setTitulo(titulo);
			modulo.setUrl(url);
			
			Facade.cadastrarModulo(modulo);
			
			modulo = Facade.buscarPorNome(modulo.getTitulo());
			String aux;
			for(Perfil p: perfis){
				aux = request.getParameter(p.getNome());
				if(aux.equals("ok")){
					util.Facade.adicionarModulosParaPerfil(p.getId(), modulo.getId());
				}
			}
			
			pagina = "cadastarModulo.jsp?sucessoCadastro=1";
			session.setAttribute(Constantes.SESSION_MSG, "Sucesso ao cadastrar Modulo "+modulo.getTitulo());
			
		} catch (Exception e) {
			session.setAttribute(Constantes.SESSION_MSG, e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}