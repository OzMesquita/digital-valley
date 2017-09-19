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
		Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
		List<Modulo> modulos = (List<Modulo>) request.getAttribute("modulos");
		//paginacao
		Integer paginaAtual = request.getParameter("pagina") != null
				? Integer.valueOf(request.getParameter("pagina"))
				: 1;
		Integer fim = Constantes.NUMBER_OF_ROWS_PER_PAGE * paginaAtual;
		Integer inicio = fim - Constantes.NUMBER_OF_ROWS_PER_PAGE;
		Integer quantidadePorPagina = fim - inicio;
		Integer quantidadeDePaginas = quantidadeDePessoasDeNivelComum / quantidadePorPagina;
		//listagem				
		List<Pessoa> pessoas = pessoaDAO.buscarPorNivel(nivelComum, inicio, fim);
		String url = Constantes.ADM_URL;
	%>
	<form action="" method="GET"></form>
	<table>
		<thead>
			<th>ID</th>
			<th>Título</th>
			<th>URL</th>
			<th>Imagem</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%
				for (Modulo modulo : modulos) {
			%>
			<tr>
				<td><%=modulo.getId()%></td>
				<td><%=modulo.getTitulo()%></td>
				<td><%=modulo.getCpf()%></td>
				<td><%=modulo.getEmail()%></td>
				<td><%=modulo.getDataNascimento()%></td>
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
			href="<%=url%>/view/adm/atribuicaoDeModulos.jsp?pagina=<%=(paginaAtual - 1)%>">
				<< </a></li>
		<%
			}
			for (int i = 1; i <= quantidadeDePaginas; i++) {
		%>
		<li>
			<%
				if (i == paginaAtual) {
			%> <strong><a
				href="<%=url%>/view/adm/atribuicaoDeModulos.jsp?pagina=<%=i%>"><%=i%></a></strong>
			<%
				} else {
			%> <a href="<%=url%>/view/adm/atribuicaoDeModulos.jsp?pagina=<%=i%>"><%=i%></a>
			<%
				}
			%>
		</li>
		<%
			}
			if (paginaAtual < quantidadeDePaginas) {
		%>
		<li><a
			href="<%=url%>/view/adm/atribuicaoDeModulos.jsp?pagina=<%=(paginaAtual + 1)%>">>></a></li>
		<%
			}
		%>
	</ul>
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
