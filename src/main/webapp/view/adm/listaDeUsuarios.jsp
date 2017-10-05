<%@page import="model.Servidor"%>
<%@page import="model.EnumNivel"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Usuario"%>
<%@page import="model.Aluno"%>
<%@page import="util.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
	List<Pessoa> usuarios = (List<Pessoa>) request.getAttribute("pessoas");
	String tipo = (String) request.getAttribute("tipo");
	String nome = request.getAttribute("nome") != null && !"".equals(request.getAttribute("nome")) ? (String) request.getAttribute("nome") : "";
	String mensagem = (String) session.getAttribute("msg");
	Integer quantidadeDePaginas = (Integer) request.getAttribute("quantidadeDePaginas");
	Integer paginaAtual = (Integer) request.getAttribute("paginaAtual");
	String url = (String) request.getAttribute("url");
%>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 id="titulo_da_pagina">Usuários</h3>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form action="<%=Constantes.getAdmUrl()%>/listar_usuarios"
					method="get">
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								<label for="nome">Nome: </label> <input id="nome" type="text"
									name="nome" class="form-control" placeholder="Nome"
									value="<%=nome %>" />
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<input class="form-control btn btn-success" type="submit"
									value="Buscar" title="Buscar" id="botao_buscar" />
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="tipo">Tipo: </label> <select id="tipo" name="tipo"
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
						</div>
					</div>
				</form>
			</div>
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
			<ul class="pagination">
				<%
					if (quantidadeDePaginas > 1) {
						if (paginaAtual > 1) {
				%>
				<li><a
					href="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%=(paginaAtual - 1)%>">
						<< </a></li>
				<%
					}
						for (int i = 1; i <= quantidadeDePaginas; i++) {
				%>

				<%
					if (i == paginaAtual) {
				%><li class="active"><a
					href="<%=url%>/listar_usuarios?pagina=<%=i%>"><%=i%></a></li>
				<%
					} else {
				%>
				<li><a href="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%=i%>"><%=i%></a>
				</li>
				<%
					}
				%>
				<%
					}
						if (paginaAtual < quantidadeDePaginas) {
				%>
				<li><a
					href="<%=url%>/listar_usuarios?nome=<%=nome %>&tipo=<%=tipo %>&pagina=<%=(paginaAtual + 1)%>">>></a></li>
				<%
					}
					}
				%>
			</ul>
		</div>
	</div>
</div>