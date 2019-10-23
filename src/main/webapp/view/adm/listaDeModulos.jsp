<%@page import="model.Servidor"%>
<%@page import="model.EnumNivel"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Usuario"%>
<%@page import="model.Modulo"%>
<%@page import="util.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Modulo> modulos = (List<Modulo>) request.getAttribute("modulos");
	String tipo = (String) request.getAttribute("tipo");
	String nome = request.getAttribute("nome") != null && !"".equals(request.getAttribute("nome")) ? (String) request.getAttribute("nome") : "";
	Integer quantidadeDePaginas = (Integer) request.getAttribute("quantidadeDePaginas");
	Integer paginaAtual = (Integer) request.getAttribute("paginaAtual");
	String url = (String) request.getAttribute("url");
%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Lista de Módulos</h1>
          <p class="lead text-muted">Aqui estão listados todos os módulos dos sistema.</p>
        </div>
      </section>
<div class="container">
		<div class="row">
			<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
				<div class="alert alert-success" role="alert">	
					<%=session.getAttribute(Constantes.getSessionMsg()) %>
				</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
			<%} %>
			<%if(session.getAttribute(Constantes.getSessionMsgError()) != null){ %>
				<div class="alert alert-danger" role="alert">
					<%=session.getAttribute(Constantes.getSessionMsgError()) %>
				</div>
				<%session.setAttribute(Constantes.getSessionMsgError(), null); %>		
			<%} %>
			<div class="col-md-12">
				<div class="form-group">		
					<form class="form-inline" action="<%=Constantes.getAdmUrl()%>/listar_modulos"
					method="get">
			  			<div class="form-group mb-2">
			    			<input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Nome:">
			  			</div>
			 			 <div class="form-group mx-sm-3 mb-2">
			    			<label for="inputPassword2" class="sr-only">Password</label>
			   				 <input type="text" name="nome" class="form-control" id="inputPassword2" placeholder="Digite um nome" value="<%=nome %>">
			  			</div>
			  			<button type="submit" class="btn btn-primary mb-2">Buscar</button>
					</form>
				</div>
			</div>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<th>Nome</th>
						<th>Descrição</th>
						<th>Link</th>
					</thead>
					<tbody>
						<%
							for (Modulo m : modulos) {
						%>
						<tr>
							<td><a
								href="editarModulo.jsp?idModulo=<%=m.getId()%>"><%=m.getTitulo()%></a></td>
							<td><%=m.getDescricao()%></td>
							<td><%=m.getUrl()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="text-center">
				<div class="btn-group" role="group" aria-label="Basic example">
					<%
						if (quantidadeDePaginas > 1) {
							
					%>	
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item <%if (paginaAtual <= 1) {%>disabled<%}%>">
									<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%if(paginaAtual <=1){%>0<%}else{out.print(paginaAtual-1);}%>" id="formPag">
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
									<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-4);%>" id="formPag">
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
									<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-3);%>" id="formPag">
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
									<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-2);%>" id="formPag">
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
									<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual-1);%>" id="formPag">
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
								if((quantidadeDePaginas-paginaAtual) > 0 ){%>	
									<li>
										<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+1);%>" id="formPag">
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
										<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+2);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+2);%>"> 
												<%out.print(paginaAtual+2);%>
											</button>
										</form>
									</li>
								<%}
								
								if((quantidadeDePaginas-paginaAtual) > 2 && paginaAtual < 3)
									
								{%>	
									<li>
										<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+3);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+3);%>"> 
												<%out.print(paginaAtual+3);%>
											</button>
										</form>
									</li>
								<%}
								
							if((quantidadeDePaginas-paginaAtual) > 3 && paginaAtual < 2)
									
								{%>	
									<li>
										<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%out.print(paginaAtual+4);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+4);%>"> 
												<%out.print(paginaAtual+4);%>
											</button>
										</form>
									</li>
								<%}
								
								%>
								<li class="page-item <%if (paginaAtual >= quantidadeDePaginas) {%>disabled<%}%>">
									<form method="get" action="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%if(paginaAtual >= quantidadeDePaginas){%>1<%}else{out.print(paginaAtual+1);}%>" id="formPag">
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