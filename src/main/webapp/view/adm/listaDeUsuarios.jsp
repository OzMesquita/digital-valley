<%@page import="model.Servidor"%>
<%@page import="model.EnumNivel"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Usuario"%>
<%@page import="model.Aluno"%>
<%@page import="util.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Pessoa> usuarios = (List<Pessoa>) request.getAttribute("pessoas");
	String tipo = (String) request.getAttribute("tipo");
	String nome = request.getAttribute("nome") != null && !"".equals(request.getAttribute("nome")) ? (String) request.getAttribute("nome") : "";
	String mensagem = (String) session.getAttribute("msg");
	Integer quantidadeDePaginas = (Integer) request.getAttribute("quantidadeDePaginas");
	Integer paginaAtual = (Integer) request.getAttribute("paginaAtual");
	String url = (String) request.getAttribute("url");
%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Lista de Usuários</h1>
          <p class="lead text-muted">Aqui estão listados todos os usuários dos sistema.</p>
        </div>
      </section>
<div class="container">
		<div class="row">
			<form class="form-inline" action="<%=Constantes.getAdmUrl()%>/listar_usuarios"
					method="get">
			  <div class="form-group mb-2">
			    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Nome:">
			  </div>
			  <div class="form-group mx-sm-3 mb-2">
			    <label for="inputPassword2" class="sr-only">Password</label>
			    <input type="text" name="nome" class="form-control" id="inputPassword2" placeholder="Digite um nome" value="<%=nome %>">
			  </div>
			  <div class="form-group mx-sm-3 mb-2">
			   <select id="tipo" name="tipo"
									class="form-control">
					<option value="todos"
						<%="todos".equals(tipo) ? "selected" : ""%>>
							Todos</option>
					<option value="alunos"
						<%="alunos".equals(tipo) ? "selected" : ""%>>Alunos</option>
					<option value="servidores"
						<%="servidores".equals(tipo) ? "selected" : ""%>>
							Servidores</option>
				</select>
			</div>
			  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
			</form>
		</div>
		<div class="table-responsive">
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<th>CPF</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Nível</th>
				</thead>
				<tbody>
					<%
						for (Pessoa user : usuarios) {
					%>
					<tr>
						<td><%=user.getCpf()%></td>
						<td><a
							href="editarNivelDoUsuario.jsp?idUsuario=<%=user.getId()%>"><%=user.getNome()%></a></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getUsuario().getNivel()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<div class="btn-group" role="group" aria-label="Basic example">
			<%
				if (quantidadeDePaginas > 1) {
			%>
				 	<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item <%if (paginaAtual <= 1) {%>disabled<%}%>">
								<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%if(paginaAtual <=1){%>0<%}else{out.print(paginaAtual-1);}%>" id="formPag">
									<button class="page-link" type="submit" name="pagina" value="<%if (paginaAtual <= 1) {%>0<%}else{out.print(paginaAtual-1);}%>">
										Anterior
									</button>
								</form>
							</li>
							<%
							if(paginaAtual > 4 && (quantidadeDePaginas-paginaAtual) < 1)
							{
							%>
							<li>
								<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-4);%>" id="formPag">
									<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-4);%>"> 
										<%out.print(paginaAtual-4);%>
									</button>
								</form>
							</li>
							<%
							}
							if(paginaAtual > 3 && (quantidadeDePaginas-paginaAtual) < 2)
							{
							%>
							<li>
								<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-3);%>" id="formPag">
									<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-3);%>"> 
										<%out.print(paginaAtual-3);%>
									</button>
								</form>
							</li>
							<%
							}
							if(paginaAtual > 2)
							{
							%>
							<li>
								<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-2);%>" id="formPag">
									<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-2);%>"> 
										<%out.print(paginaAtual-2);%>
									</button>
								</form>
							</li>
							<%
							}
							if(paginaAtual>1)
							{
							%>
							<li>
								<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-1);%>" id="formPag">
									<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-1);%>"> 
										<%out.print(paginaAtual-1);%>
									</button>
								</form>
							</li>
							<%
							}
							%>
							<li class="page-item disabled">
						
						    	<span class="page-link"><%out.print(paginaAtual);%></span>
		
		   					 </li>
					
							<%
							if((quantidadeDePaginas-paginaAtual) > 0){%>	
								<li>
									<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+1);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+1);%>"> 
											<%out.print(paginaAtual+1);%>
										</button>
									</form>
							</li>
							<%
							}
							
							if((quantidadeDePaginas-paginaAtual) > 1)
							
							{%>	
								<li>
									<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+2);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+2);%>"> 
											<%out.print(paginaAtual+2);%>
										</button>
									</form>
								</li>
							<%}
							
							if((quantidadeDePaginas-paginaAtual) > 2 && paginaAtual < 3)
								
							{%>	
								<li>
									<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+3);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+3);%>"> 
											<%out.print(paginaAtual+3);%>
										</button>
									</form>
								</li>
							<%}
							
							if((quantidadeDePaginas-paginaAtual) > 3 && paginaAtual < 2)
								
							{%>	
								<li>
									<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+4);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+4);%>"> 
											<%out.print(paginaAtual+4);%>
										</button>
									</form>
								</li>
							<%}
							
							%>
							<li class="page-item <%if (paginaAtual >= quantidadeDePaginas) {%>disabled<%}%>">
								<form method="get" action="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%if(paginaAtual >= quantidadeDePaginas){%>1<%}else{out.print(paginaAtual+1);}%>" id="formPag">
									<button class="page-link" type="submit" name="pagina" value="<%if (paginaAtual >= quantidadeDePaginas) {%>1<%} else {out.print(paginaAtual+1);}%>">
										Próximo
									</button>
								</form>
							</li>		
						</ul>
					</nav> 		
				<%
 				}
				%> 
			</div>
		</div>
	</div>