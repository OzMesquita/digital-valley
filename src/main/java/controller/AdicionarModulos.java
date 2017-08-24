package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Modulo;
import model.Perfil;
import model.Pessoa;
import util.Facade;


public class AdicionarModulos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Pessoa usuarioSelecionado = (Pessoa)session.getAttribute("usuarioSelecionado");
                Perfil perfilSelecionado = (Perfil) session.getAttribute("perfilSelecionado");
		String[] modulosAdicionados = request.getParameterValues("modulosCadadastrados");
		
                
                
		List<Modulo> modulosCadadastrados = new ArrayList<>();
		
                for(int i=0;i<modulosAdicionados.length;i++){
                    modulosCadadastrados.add(Facade.buscarModulosPorId(Integer.parseInt(modulosAdicionados[i])));
                }
                if(session.getAttribute("mostra").toString().toLowerCase().equals("usuarios")){
                    for (Modulo modulosCadadastrado : modulosCadadastrados) {
                        Facade.AdicionarModulosParaUsuario(usuarioSelecionado.getId(),modulosCadadastrado.getId());
                    }
                }
                if(session.getAttribute("mostra").toString().toLowerCase().equals("perfil")){
                    for (Modulo modulosCadadastrado : modulosCadadastrados) {
                        Facade.AdicionarModulosParaPerfil(perfilSelecionado.getId(),modulosCadadastrado.getId());
                    }
                }
                
                
		
	}

}
