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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="<%=Constantes.getAppCssUrl()%>/sign.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="<%=Constantes.getAppCssUrl()%>/newcss.css" type="text/css" />

<style>
</style>

</head>
<body>

	<%
		String mensagem = null;
		if (session.getAttribute(Constantes.getSessionMsg()) == null) {
			mensagem = null;
		} else {
			mensagem = (String) session.getAttribute(Constantes.getSessionMsg());

		}
		if(session.getAttribute("usuario")!=null){
			response.sendRedirect("view/telaInicial.jsp");
		}
	%>


    <div class="container-fluid container-full-height container-full-width">
      <div class="row row-full-height">
        <div class="hidden-xs col-sm-6 col-md-8 col-full-height login-main-content" style="position:relative;">
            <div class="topics">
            	<a href="http://n2s.russas.ufc.br" id="n2s" target="_blank"><img src="assets2/img/n2s-logo.png" class="n2s_logo" /></a>
	            <h3>Maximizando potenciais, desenvolvendo soluções.</h3>
            </div>
            
        </div>
        <div class="col-sm-6 col-md-4 col-full-height login-form">
          <div>	
          		<p class="text-center">
          			<img src="assets2/img/brasao_ufc.png" class="brasao_ufc" />
          		</p>
                <form class="form-horizontal" role="form" action="login" method="post" name="formLogin">
                	<%
                		if (mensagem != null && !mensagem.isEmpty()) {
                	%>
                	<div class="alert alert-danger">
						<%=mensagem%> <% session.setAttribute(Constantes.getSessionMsg(), null);%>
					</div>
					<%
                		}
					%>
                    <div class="form-group">
                        <div class="col-sm-12 col-sm-offset-1">
                            <input type="text" name="login" class="form-control" id="inputEmail3" placeholder="Digite o seu Login" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 col-sm-offset-1">
                            <input type="password" name="senha" class="form-control" id="inputPassword3" placeholder="Digite sua senha" required>
                        </div>
                    </div>
                    <div class="col-sm-12 col-sm-offset-1">
                        <p><a href="recuperSenha.jsp" class="text-center" >Esqueceu a senha?</a></p>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 col-sm-offset-1">
                            <button type="submit" class="btn btn-outline-success form-control">
                                Entrar</button>
                        </div>
                    </div>
                    <div class="col-sm-12 col-sm-offset-1">
                        <p class="text-center" >Não possui cadastro?</p>
                        <div class="form-group">
	                            <a  href="verificacaoCadastro.jsp" class="btn btn-outline-dark form-control">
	                                Cadastro Servidor ou Aluno</a>
	                    </div>
	                    <div class="form-group">
	                            <a  href="cadastrarVisitante.jsp" class="btn btn-outline-primary form-control">
	                                Cadastro comunidade</a>
	                    </div>
                    </div>
                </form>
                
                <nav class="navbar navbar-light" style="width:100%;">
			    Guardião
			    <p>© <a href="http://n2s.russas.ufc.br" id="n2s" target="_blank">Núcleo de Soluções em Software (N2S)</a>, 2019.</p>
			    <p><a href="mailto:n2s@ufc.br?subject=Ajuda no Guardião" id="n2smail" target="_blank" title="">Precisa de ajuda?</a></p>
			</nav>    
            </div>            
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




</html>
