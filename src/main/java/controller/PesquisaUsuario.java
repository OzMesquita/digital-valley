/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import util.Facade;

/**
 *
 * @author Usuario
 */
public class PesquisaUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            
            HttpSession session = request.getSession();
            String nome = request.getParameter("busca");
            
            List<Pessoa> usuarios = (List) Facade.buscarPessoaPorNome(nome);
            
            session.setAttribute("usuarios", usuarios);
            response.sendRedirect("TelaADM.jsp");
    }



}
