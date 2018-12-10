<%-- 
    Document   : login
    Created on : 24/05/2017, 16:13:20
    Author     : N2S-PC03
--%>
<%@page import="model.Usuario"%>
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
<link href="<%=Constantes.getAppCssUrl()%>//sign.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="<%=Constantes.getAppCssUrl()%>/newcss.css" type="text/css" />

<style>
</style>

</head>
<body>

	<% String mensagem = (String) session.getAttribute("msg");
    Usuario usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null ){ response.sendRedirect(Constantes.getPreUrl() + Constantes.getAppUrl());}
	if(mensagem == null){
		mensagem ="";
	}
	%>


    <div class="container-fluid container-full-height container-full-width">
      <div class="row row-full-height">
        <div class="hidden-xs col-sm-6 col-md-8 col-full-height login-main-content" style="position:relative;">
            <div class="topics">
            	<a href="http://n2s.russas.ufc.br" id="n2s" target="_blank"><img src="assets2/img/n2s-logo.png" class="n2s_logo" /></a>
	            <h3>"Maximizando potenciais, desenvolvendo soluções".</h3>
            </div>
            <nav class="navbar navbar-light" style="position:absolute; left:0px; bottom: 0px; width:100%;">
			    Guardião
			    <p>© <a href="http://n2s.russas.ufc.br" id="n2s" target="_blank">Núcleo de Soluções em Software (N2S)</a>, 2018.</p>
			</nav>
        </div>
        <div class="col-sm-6 col-md-4 col-full-height login-form">
          <div>	
          		<p class="text-center">
          			<img src="assets2/img/brasao_ufc.png" class="brasao_ufc" />
          		</p>
                <form class="form-horizontal" role="form" action="alterarSenha" name="formVerifica" method="post">
                	<div class="row">
  					<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="<%=session.getAttribute(Constantes.getSessionMsg()).equals("Dados alterados com sucesso") ? "alert alert-success": "alert alert-danger" %>" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
					<%} %>	
					<div class="margin-top-div" style="margin-top:20px;"></div>
					<div id="form-aluno">
	                    <div class="form-group">
	                        <div class="col-sm-12 col-sm-offset-1">
	                            <input type="password" name="senha" class="form-control" id="inputPassword3" placeholder="Nova senha">
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="col-sm-12 col-sm-offset-1">
	                            <input type="password" name="senha_repetida" class="form-control" id="inputPassword3" placeholder="Confirme a senha">
	                        </div>
	                    </div>
	                     <div class="form-group">
                       	 	<div class="col-sm-12 col-sm-offset-1">
                            	<button type="submit" class="btn btn-outline-success form-control">
                                	Confirmar</button>
                        	</div>
                    	</div>
					</div>
                </form>
                
                    
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
