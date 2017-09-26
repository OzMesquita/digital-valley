<%-- 
    Document   : atribuicaoDeModulos
    Created on : 02/09/2017, 18:19:47
    Author     : Usuario
--%>

<%@page import="dao.ModuloDAO"%>
<%@page import="dao.PessoaDAO"%>
<%@page import="dao.JDBCModuloDAO"%>
<%@page import="util.DAOFactory"%>
<%@page import="dao.PerfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../visu/css/wecss.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modulos de uma pessoa</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body class="cbp-spmenu-push">
	<%
		Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
		List<Modulo> modulosDisponiveis = (List<Modulo>) request.getAttribute("modulosDisponiveis");
		List<Modulo> modulosAssociados = (List<Modulo>) request.getAttribute("modulosAssociados");
		
		String url = Constantes.ADM_URL;
	%>
	<h1>Módulos associados</h1>
	<table>
		<thead>
			<th>ID</th>
			<th>Título</th>
			<th>URL</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulosAssociados) {
			%>
			<tr>
				<td><%=modulo.getId()%></td>
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
			<th>ID</th>
			<th>Título</th>
			<th>URL</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulosDisponiveis) {
			%>
			<tr>
				<td><%=modulo.getId()%></td>
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
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>
