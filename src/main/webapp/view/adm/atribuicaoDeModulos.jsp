<%-- 
    Document   : atribuicaoDeModulos
    Created on : 02/09/2017, 18:19:47
    Author     : Usuario
--%>

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
<title>Editar</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	addEventListener("load", function() { 
							 setTimeout(hideURLbar, 0); 
							 }, false); 
	function hideURLbar(){ 
		window.scrollTo(0,1); 
	} 









</script>
<!-- Bootstrap Core CSS -->
<link href="../visu/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../visu/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="../visu/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js-->
<script src="../visu/js/jquery-1.11.1.min.js"></script>
<script src="../visu/js/modernizr.custom.js"></script>
<!--webfonts-->
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<!--animate-->
<link href="../visu/css/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="../visu/js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!--//end-animate-->
<!-- chart -->
<script src="../visu/js/Chart.js"></script>
<!-- //chart -->

<!-- Metis Menu -->
<script src="../visu/js/metisMenu.min.js"></script>
<script src="../visu/js/custom.js"></script>
<link href="../visu/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

</head>
<body class="cbp-spmenu-push">
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
		<input type="text" name="nome" value="<%=nomePessoa != null ? nomePessoa : "" %>" /> <input type="submit" value="Buscar" />
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
				href="<%=url%>/atribuicaoDeModulos.jsp?pagina=<%=i%>"><%=i%></a></strong>
			<%
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
			for (Perfil perfil: perfis) {
		%>
			<tr>
				<td><%=perfil.getNome() %></td>
				<td><a href="<%=url %>/perfil_modulos?perfil_id=<%=perfil.getId() %>">Gerenciar módulos</a></td>
			</tr>
		<% } %>
		</tbody>
	</table>
	<jsp:include page="../include/footer.jsp"></jsp:include>
	<script src="../visu/js/classie.js"></script>
	<script src="../visu/js/jquery.nicescroll.js"></script>
	<script src="../visu/js/scripts.js"></script>
	<script src="../visu/js/bootstrap.js"></script>
	<script
		src="<%=Constantes.APP_JS_URL%>/funcoesParaAtribuicaoDeModulo.js"></script>
	<script src="../visu/js/wejs.js"></script>
</body>
</html>
