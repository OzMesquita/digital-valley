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
							if (paginaAtual > 1) {
					%>
								<a
									href="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%=(paginaAtual - 1)%>" class="btn btn-secondary">
								 << </a>
					<%
							}
								for (int i = 1; i <= quantidadeDePaginas; i++) {
					%>
	
					<%
									if (i == paginaAtual) {
					%>
										<a href="<%=url%>/listar_modulos?pagina=<%=i%>" class="btn btn-secondary"><%=i%></a>
					<%
									} else {
					%>
										<a href="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%=i%>" class="btn btn-secondary"><%=i%></a>
					<%
									}
					%>
					<%
							}
							if (paginaAtual < quantidadeDePaginas) {
					%>
								<a href="<%=url%>/listar_modulos?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%=(paginaAtual + 1)%>" class="btn btn-secondary">>></a>
					<%
							}
						}
					%>
				</div>
			</div>
		
</div>