/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import model.Aluno;
import model.Servidor;
import util.Facade;

/**
 *
 * @author Usuario
 */
public class ListaUsuarios extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            List<Pessoa> usuarios = new ArrayList<Pessoa>();
            HttpSession session = request.getSession();
            String nome = request.getParameter("busca");
            String filtro = request.getParameter("filtro");
            try{
	            if(nome != null && !"".equals(nome)){
	                if(filtro.equals("todos")){
	                    usuarios = (List<Pessoa>) Facade.buscarPessoaPorNome(nome);
	                }else{
	                    if(filtro.equals("alunos")){
	                        List<Aluno> lista = Facade.buscarAlunoPorNome(nome);
	                        for(Aluno a: lista){
	                            usuarios.add(Facade.buscarPessoaPorId(a.getId()));
	                        }
	                    }else{
	                        if(filtro.equals("servidores")){
	                           List<Servidor> lista = Facade.buscarServidorPorNome(nome);
	                            for(Servidor s: lista){
	                                usuarios.add(Facade.buscarPessoaPorId(s.getId()));
	                            } 
	                        }
	                    }
	                }
	            
	            }else{
	                if(filtro.equals("todos")){
	                    usuarios = (List<Pessoa>) Facade.buscarPessoas();
	                }else{
	                    if(filtro.equals("alunos")){
	                        List<Aluno> lista = Facade.buscarAlunos();
	                        for(Aluno a: lista){
	                            usuarios.add(Facade.buscarPessoaPorId(a.getId()));
	                        }
	                    }else{
	                        if(filtro.equals("servidores")){
	                           List<Servidor> lista = Facade.buscarServidor();
	                            for(Servidor s: lista){
	                                usuarios.add(Facade.buscarPessoaPorId(s.getId()));
	                            } 
	                        }
	                    }
	                }
	            }
            }catch (Exception e) {
            	 session.setAttribute("msg", "Não foi possivel listar os usuários");
			}
            finally{
            
	            session.setAttribute("usuarios", usuarios);
	            response.sendRedirect("/Controle_de_Acesso/view/adm/listaDeUsuarios.jsp");
            }
    }



}
