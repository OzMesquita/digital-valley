<%-- 
    Document   : RecuperarSenha
    Created on : 17/07/2017, 10:44:23
    Author     : N2S-PC03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets2/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets2/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Tela de recuperação</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!--     Fonts and icons     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet">

<!-- CSS Files -->
<link href="assets2/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="assets2/css/demo.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="assets2/css/newcss.css" type="text/css" />

<style>
#btn_confirma {
	width: 150px;
	height: 35px;
	background: steelblue;
	color: white;
	float: right;
}

#faixa_topo {
	height: 10%;
	color: white;
	background: steelblue;
	text-align: center;
	text-transform: uppercase;
}

#texto_faixa {
	margin-top: 1.2%;
}
</style>
</head>
<body>
	<% String mensagem = (String)session.getAttribute("msg");
    	if(mensagem == null){
    		mensagem = "";
    	}
    %>
	<div class="image-container set-full-height"
		style="background: steelblue;">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<div class="wizard-container">
						<div class="card wizard-card" data-color="orange"
							id="wizardProfile" style="height: 20px;">
							<div class="wizard-header">
								<h3>
									<b>Recuperação de Senha</b><br> <small>Nós
										mandaremos um <b>e-mail</b> com um link para você redefinir
										sua senha.
									</small>
								</h3>
							</div>
							<ul id="faixa_topo">
								<li id="texto_faixa">digite seu email</li>
							</ul>
							<div class="erroMsg">
								<small><%= mensagem %>
									<%session.setAttribute("msg", null);%></small>
							</div>
							<div class="row">
								<div class="col-sm-6" style="margin-left: 25%;">
									<div class="form-group">
										<div class="tab-content">
											<form method="post" action="RecuperarSenha"
												name="formVerifica">
												<label for="email">E-mail</label><input type="text"
													title="Preencha este campo" name="email"
													class="form-control" placeholder="exemplo@email.com"><br>
												<a href="login.jsp">Voltar para tela de login</a> <input
													id="btn_confirma" type="submit" value="Confirmar">
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer" style="margin-top: 0% !important">
				<div class="container">₢ Todos os direitos reservados | N2S</div>
			</div>
		</div>
	</div>
</body>
<!--   Core JS Files   -->
<script src="assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="assets2/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets2/js/jquery.bootstrap.wizard.js"
	type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="assets2/js/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="assets2/js/jquery.validate.min.js"></script>
</html>
