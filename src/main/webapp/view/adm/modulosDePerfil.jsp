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
		List<Modulo> modulosDoPerfil = (List<Modulo>) request.getAttribute("modulosDoPerfil");
		List<Modulo> modulos = (List<Modulo>) request.getAttribute("modulos");
		Perfil perfil = (Perfil) request.getAttribute("perfil");
	%>
	<h1>Modulos Associados</h1>
	<table>
		<thead>
			<th>Título</th>
			<th>URL</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulosDoPerfil) {
			%>
			<tr>
				<td><%=modulo.getTitulo()%></td>
				<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
						alt="<%=modulo.getTitulo()%>" src="<%=modulo.getImagem()%>"></a></td>
				<td>
					<form method="POST" action="<%=url%>/desassociar_modulo_perfil">
						<input type="hidden" value="<%=perfil.getId()%>" name="perfil_id" />
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
	<h1>Modulos Desassociados</h1>
	<table>
		<thead>
			<th>Título</th>
			<th>URL</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulos) {
			%>
			<tr>
				<td><%=modulo.getTitulo()%></td>
				<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
						alt="<%=modulo.getTitulo()%>" src="<%=modulo.getImagem()%>"></a></td>
				<td>
					<form method="POST" action="<%=url%>/associar_modulo_perfil">
						<input type="hidden" value="<%=perfil.getId()%>" name="perfil_id" />
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

