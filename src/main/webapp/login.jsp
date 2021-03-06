<%-- 
    Document   : login
    Created on : 24/05/2017, 16:13:20
    Author     : N2S-PC03
--%>
<%@page import="util.Constantes"%>
<%@page import="controller.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="pt">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets2/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets2/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Tela de login</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!--     Fonts and icons     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet">
<!-- CSS Files -->
<link href="<%=Constantes.getAppCssUrl()%>/bootstrap.min.css" rel="stylesheet" />
<link href="<%=Constantes.getAppCssUrl()%>//gsdk-bootstrap-wizard.css" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="<%=Constantes.getAppCssUrl()%>//demo.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="<%=Constantes.getAppCssUrl()%>/newcss.css" type="text/css" />
</head>
<body>

	<%
		String mensagem;
		if (session.getAttribute(Constantes.getSessionMsg()) == null) {
			mensagem = "";
		} else {
			mensagem = (String) session.getAttribute(Constantes.getSessionMsg());

		}
		if(session.getAttribute("usuario")!=null){
			response.sendRedirect("view/telaInicial.jsp");
		}
	%>

	


	<div class="image-container set-full-height"
		style="background: steelblue;">
		<div class="container">
			<div class="row">

				<div class="col-sm-8 col-sm-offset-2">
					<div class="wizard-container">
						<div class="card wizard-card" data-color="orange"
							id="wizardProfile" >

							<!--  formulario -->
							<form action="login" method="post" name="formLogin">
								<div class="wizard-header">
									<h3>
										SISTEMA CONTROLE DE ACESSO <br>
									</h3>
								</div>
								<div class="wizard-navigation">
									<ul>
										<li><a href="#about" data-toggle="tab">LOGIN</a></li>
									</ul>
								</div>
								<div class="erroMsg">
									<small><%=mensagem%> <% session.setAttribute(Constantes.getSessionMsg(), null);%></small>
								</div>
								<div class="tab-content">
									<div class="tab-pane" id="about">
										<div class="row">
											<div class="col-sm-4 col-sm-offset-1">
												<div class="picture-container">
													<div class="picture">
														<img src="assets2/img/ufc_logo.png" class="picture-src"
															id="wizardPicturePreview" title="UFC - Campus Russas" />
													</div>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label>Login </label> <input name="login" type="text"
														class="form-control">
												</div>
												<div class="form-group">
													<label>Senha </label> <input name="senha" type="password"
														class="form-control">
												</div>

												<div id="c_russas">
													<h3>
														<small>UFC - Campus Russas</small>
													</h3>
												</div>
												<!--  essa div era só class pull-right -->
																								
												<div class="pull-right" id="divbtnsalvar">
													<input id="btnsalvar" type='submit' value='Entrar'
														onclick="return validarLogin()" />
												</div>
												<!-- Essa div id cadastro era acima da div do botao -->
<<<<<<< HEAD
												<div id="cadastro" 	class="col-sm-4 pull-left">
=======
												<div id="cadastro" class="pull-left hidden-xs hidden-sm">
													É servidor ou aluno e não tem cadastro? <a href="verificacaoCadastro.jsp">Cadastre-se aqui</a><br>
													É membro da comunidade e não tem cadastro? <a href="cadastrarVisitante.jsp">Cadastre-se aqui</a><br>
													<a href="recuperSenha.jsp" id="recSenha" style="margin-left: 10%">Esqueceu
														a senha?</a>
												</div>
												<div id="cadastro" class="pull-right visible-xs visible-sm">
>>>>>>> 3b610eae659d805e1e28560ec9748169a8175a6b
													É servidor ou aluno e não tem cadastro? <a href="verificacaoCadastro.jsp">Cadastre-se aqui</a><br>
													É membro da comunidade e não tem cadastro? <a href="cadastrarVisitante.jsp">Cadastre-se aqui</a><br>
													<a href="recuperSenha.jsp" id="recSenha" style="margin-left: 10%">Esqueceu
														a senha?</a>
												</div>

												
											</div>
										</div>
									</div>
								</div>
							</form>
							
						</div>



					</div>
				</div>


			</div>
			<!-- row  -->

		</div>
		<!-- container -->


		<div class="footer">
			<div class="container">₢ Todos os direitos reservados | N2S</div>
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


<script type="text/javascript">
	function validarLogin() {
		if (document.formLogin.login.value === ""
				&& document.formLogin.senha.value === "") {
			alert("Login e Senha Inválidos");
			return false;
		} else if (document.formLogin.login.value === "") {
			alert("Campo Login Inválido");
			return false;
		} else if (document.formLogin.senha.value === "") {
			alert("Campo Senha Inválido");
			return false;
		}
	}
</script>
<script>
window.onload = function() {
    if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
        console.log('Dispositivo Movel');
        $("#cadastro").removeAttr("id");
        $("#recSenha").removeAttr("style");
        
    }
}
</script>



</html>
