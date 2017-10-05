<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>
<%
	String url = (String) request.getAttribute("url");
	List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
	List<Perfil> perfis = (List<Perfil>) request.getAttribute("perfis");
	Integer quantidadeDePaginas = (Integer) request.getAttribute("quantidadeDePaginas");
	Integer paginaAtual = (Integer) request.getAttribute("paginaAtual");
	String nomePessoa = request.getAttribute("nomePessoa") != null && !"".equals(request.getAttribute("nomePessoa")) ? (String) request.getAttribute("nomePessoa") : "";
%>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 id="titulo_da_pagina">Atribuir módulos por pessoa</h3>
	</div>
	<div class="panel-body">
		<form action="<%=Constantes.getAdmUrl() + "/atribuir_modulos"%>"
			method="GET">

			<div class="row">
				<div class="col-md-4 col-md-offset-3">
					<div class="form-group">
						<label for="nome">Nome: </label> <input type="text" id="nome"
							name="nome" class="form-control"
							value="<%=nomePessoa %>" />
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<input type="submit" class="form-control btn btn-primary"
							id="botao_buscar" value="Buscar" />
					</div>
				</div>
			</div>
		</form>
		<div class="table-responsive">
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<th>Nome</th>
					<th>CPF</th>
					<th>E-mail</th>
					<th>Data Nascimento</th>
					<th>Opções</th>
				</thead>
				<tbody>
					<%
						for (Pessoa pessoa : pessoas) {
					%>
					<tr>
						<td><%=pessoa.getNome()%></td>
						<td><%=pessoa.getCpf()%></td>
						<td><%=pessoa.getEmail()%></td>
						<td><%=pessoa.getDataNascimento()%></td>
						<td><a
							href="<%=url%>/pessoa_modulos?pessoa_id=<%=pessoa.getId()%>">Gerenciar
								módulos</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<ul class="pagination text-center">			
				<%
					if (quantidadeDePaginas > 1) {
						if (paginaAtual > 1) {
				%>
				<li><a
					href="<%=url%>/atribuir_modulos?pagina=<%=(paginaAtual - 1)%>">
						<< </a></li>
				<%
					}
						for (int i = 1; i <= quantidadeDePaginas; i++) {
				%>

				<%
					if (i == paginaAtual) {
				%><li class="active"><a
					href="<%=url%>/atribuir_modulos?pagina=<%=i%>"><%=i%></a></li>
				<%
					} else {
				%>
				<li><a href="<%=url%>/atribuir_modulos?pagina=<%=i%>"><%=i%></a>
				</li>
				<%
					}
				%>
				<%
					}
						if (paginaAtual < quantidadeDePaginas) {
				%>
				<li><a
					href="<%=url%>/atribuir_modulos?nome=<%=nomePessoa %>&pagina=<%=(paginaAtual + 1)%>">>></a></li>
				<%
					}
					}
				%>
			</ul>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Atribuir módulos por perfil</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<th>Nome</th>
							<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Perfil perfil : perfis) {
							%>
							<tr>
								<td><%=perfil.getNome()%></td>
								<td><a
									href="<%=url%>/perfil_modulos?perfil_id=<%=perfil.getId()%>">Gerenciar
										módulos</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>