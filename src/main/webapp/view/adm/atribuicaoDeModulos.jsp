<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>

<div class="cbp-spmenu-push">
	<%
		String url = (String) request.getAttribute("url");
		List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
		List<Perfil> perfis = (List<Perfil>) request.getAttribute("perfis");
		Integer quantidadeDePaginas = (Integer) request.getAttribute("quantidadeDePaginas");
		Integer paginaAtual = (Integer) request.getAttribute("paginaAtual");
		String nomePessoa = (String) request.getAttribute("nomePessoa");
	%>
	<h1>Atribuir por pessoa</h1>
	<form action="<%=Constantes.ADM_URL + "/atribuir_modulos"%>"
		method="GET">
		<input type="text" name="nome"
			value="<%=nomePessoa != null ? nomePessoa : ""%>" /> <input
			type="submit" value="Buscar" />
	</form>
	<table>
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
	<ul>
		<%
			if (paginaAtual > 1) {
		%>
		<li><a
			href="<%=url%>/atribuicaoDeModulos.jsp?pagina=<%=(paginaAtual - 1)%>">
				<< </a></li>
		<%
			}
			for (int i = 1; i <= quantidadeDePaginas; i++) {
		%>
		<li>
			<%
				if (i == paginaAtual) {
			%> <strong><a
				href="<%=url%>/atribuicaoDeModulos.jsp?pagina=<%=i%>"><%=i%></a></strong> <%
 	} else {
 %> <a href="<%=url%>/atribuicaoDeModulos.jsp?pagina=<%=i%>"><%=i%></a>
			<%
				}
			%>
		</li>
		<%
			}
			if (paginaAtual < quantidadeDePaginas) {
		%>
		<li><a
			href="<%=url%>/atribuicaoDeModulos.jsp?pagina=<%=(paginaAtual + 1)%>">>></a></li>
		<%
			}
		%>
	</ul>
	<h1>Atribuir por perfil</h1>
	<table>
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

