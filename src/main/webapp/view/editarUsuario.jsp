<%-- 
    Document   : editarUsuario
    Created on : 02/09/2017, 15:37:05
    Author     : Usuario
--%>

<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>editar</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="visu/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="visu/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="visu/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js-->
<script src="visu/js/jquery-1.11.1.min.js"></script>
<script src="visu/js/modernizr.custom.js"></script>
<!--webfonts-->
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<!--animate-->
<link href="visu/css/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="visu/js/wow.min.js"></script>
<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- chart -->
<script src="visu/js/Chart.js"></script>
<!-- //chart -->

<!-- Metis Menu -->
<script src="visu/js/metisMenu.min.js"></script>
<script src="visu/js/custom.js"></script>
<link href="visu/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

</head>
<body class="cbp-spmenu-push">
	<% Usuario usuario = (Usuario) session.getAttribute("usuario");
	String mensagem = (String)session.getAttribute("msg");
	if(mensagem == null){
		mensagem = "";
	}
    
    
    %>


	<div class="main-content">
		<jsp:include page="include/menu-left.jsp"></jsp:include>
		<jsp:include page="include/header-top.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="container-fluid" style="min-height: 400px">
				<!-- aqui-->
				<div class="col-md-12">
					<div class="card">
						<div class="header" style="text-align: center;">
							<h4 class="title">Informações do Usuário</h4>
							<hr style="border: 1px solid lightgray">
							<%if(request.getParameter("erro")!= null){%>
							<small class="msgErro" style="color: red;"> mensagens de
								erro</small>
							<%}%>
						</div>
						<div class="content">
							<div class="col-md-8" style="margin-left: 15%;">
								<form action="editarUsuario" method="post">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label>Código Interno</label> <input type="text"
													class="form-control" disabled
													value="<%= usuario.getPessoa().getId()%>">
											</div>
										</div>
										<div class="col-md-8">
											<div class="form-group">
												<label>Nome Completo</label> <input type="text"
													class="form-control" name="nome" disabled
													value="<%= usuario.getPessoa().getNome()%>">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>CPF</label> <input type="text" id="cpf" name="cpf"
													class="form-control" maxlength="14" placeholder="Cpf"
													onkeypress="formatar('###.###.###-##',this); return SomenteNumero(event)"
													value="<%= usuario.getPessoa().getCpf() %>">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Data de Nascimento</label> <input
													title="Preencha este campo corretamente" type="data"
													class="form-control" name="nascimento" maxlength="10"
													value="<%= usuario.getPessoa().getDataNascimento() %>"
													placeholder="12/02/1996" pattern="^\d{2}/\d{2}/\d{4}$"
													onkeypress="formatar('##/##/####',this); return SomenteNumero(event)">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>E-mail</label> <input type="email"
													class="form-control" name="email"
													value="<%= usuario.getPessoa().getEmail() %>">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label>Login</label> <input type="text" class="form-control"
													name="login" value="<%= usuario.getLogin() %>">
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label>Nova Senha</label> <input type="password"
													class="form-control" name="senha" placeholder="Nova senha">
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label>Confirmar Senha</label> <input type="password"
													class="form-control" name="cSenha"
													placeholder="Confirmar senha">
											</div>
										</div>
									</div>
									<input type="submit" id="salva" value="Salvar"
										title="Salvar alterações">
									<div class="clearfix"></div>
								</form>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- aqui-->
	</div>
	<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
	<!-- Classie -->
	<script src="visu/js/classie.js"></script>
	<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!--scrolling js-->
	<script src="visu/js/jquery.nicescroll.js"></script>
	<script src="visu/js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
	<script src="visu/js/bootstrap.js"> </script>

</body>
</html>
