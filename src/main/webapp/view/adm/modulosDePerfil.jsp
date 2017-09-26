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
