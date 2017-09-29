<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>

<div class="cbp-spmenu-push">
	<%
		Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
		List<Modulo> modulosDisponiveis = (List<Modulo>) request.getAttribute("modulosDisponiveis");
		List<Modulo> modulosAssociados = (List<Modulo>) request.getAttribute("modulosAssociados");
		String url = Constantes.getAdmUrl();
	%>
	<h1>Módulos associados</h1>
	<table>
		<thead>
			<th>Título</th>
			<th>URL</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulosAssociados) {
			%>
			<tr>
				<td><%=modulo.getTitulo()%></td>
				<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
						alt="<%=modulo.getTitulo()%>" src="<%=modulo.getImagem()%>"></a></td>
				<td>
					<form method="POST" action="<%=url%>/desassociar_modulo_pessoa">
						<input type="hidden" value="<%=pessoa.getId()%>" name="pessoa_id" />
						<input type="hidden" value="<%=modulo.getId()%>" name="modulo_id" />
						<input type="submit" value="Desassociar" />
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<h1>Módulos disponíveis</h1>
	<table>
		<thead>
			<th>Título</th>
			<th>URL</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulosDisponiveis) {
			%>
			<tr>
				<td><%=modulo.getTitulo()%></td>
				<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
						alt="<%=modulo.getTitulo()%>" src="<%=modulo.getImagem()%>"></a></td>
				<td>
					<form method="POST" action="<%=url%>/associar_modulo_pessoa">
						<input type="hidden" value="<%=pessoa.getId()%>" name="pessoa_id" />
						<input type="hidden" value="<%=modulo.getId()%>" name="modulo_id" />
						<input type="submit" value="Associar" />
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>
