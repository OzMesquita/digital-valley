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
<link href="<%=Constantes.getAppCssUrl()%>//sign.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="<%=Constantes.getAppCssUrl()%>/newcss.css" type="text/css" />

<style>
</style>

</head>
<body>

	<% String mensagem = (String) session.getAttribute("msg");
		session.setAttribute("nomeA", null);
		session.setAttribute("nomeS", null);
		session.setAttribute("matricula", null);
		session.setAttribute("siape", null);
    if(mensagem == null){
		mensagem ="";
	}%>


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
                <form class="form-horizontal" role="form" action="verificacao" name="formVerifica" method="post">
                	<%
                		if (mensagem != null && !mensagem.isEmpty()) {
                	%>
                	<div class="alert alert-danger">
						<%=mensagem%> <% session.setAttribute(Constantes.getSessionMsg(), null);%>
					</div>
					<%
                		}
					%>
					<div class="btn-group col-sm-12 col-sm-offset-1" role="group" aria-label="Menu aluno e servidor">
					  <button type="button" class="btn btn-outline-primary form-control active menu-tab-verificao" data-form-type="aluno">
                                Aluno</button>
                      <button type="button" class="btn btn-outline-primary form-control menu-tab-verificao" data-form-type="servidor">
                                Servidor</button>
					</div>
					<div class="margin-top-div" style="margin-top:20px;"></div>
					<div id="form-aluno">
	                    <div class="form-group">
	                        <div class="col-sm-12 col-sm-offset-1">
	                            <input type="number" name="matricula" class="form-control" id="inputEmail3" placeholder="Matrícula, ex.: 333333">
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="col-sm-12 col-sm-offset-1">
	                            <input type="text" name="nomeA" class="form-control" id="inputPassword3" placeholder="Nome Completo sem acentos, ex.: Joao Paulo Silva">
	                        </div>
	                    </div>
					</div>
					<div id="form-servidor" style="display:none;">
	                    <div class="form-group">
	                        <div class="col-sm-12 col-sm-offset-1">
	                            <input type="number" name="siape" class="form-control" id="inputEmail3" placeholder="Siape ex.: 333333" >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="col-sm-12 col-sm-offset-1">
	                            <input type="text" name="nomeS" class="form-control" id="inputPassword3" placeholder="Nome Completo, ex.: João Paulo Silva" >
	                        </div>
	                    </div>
					</div>
                    <div class="form-group">
                        <div class="col-sm-12 col-sm-offset-1">
                            <button type="submit" class="btn btn-outline-success form-control">
                                Confirmar</button>
                        </div>
                    </div>
                    <div class="col-sm-12 col-sm-offset-1">
                        <p class="text-center" >Ou você pode</p>
                        <div class="form-group">
	                            <a  href="login.jsp" class="btn btn-outline-dark form-control">
	                                Entrar</a>
	                    </div>
	                    <div class="form-group">
	                            <a  href="cadastrarVisitante.jsp" class="btn btn-outline-primary form-control">
	                                Cadastro comunidade</a>
	                    </div>
                    </div>
                </form>
                
                  <nav class="navbar navbar-light" style="width:100%;">
			    Guardião
			    <p>© <a href="http://n2s.russas.ufc.br" id="n2s" target="_blank">Núcleo de Soluções em Software (N2S)</a>, 2018.</p>
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

	$(document).ready(function () {
		$('.menu-tab-verificao').click(function () {
			var $this = $(this);
			var formType = $this.attr('data-form-type');
			$('.menu-tab-verificao').removeClass('active');
			$this.addClass('active');
			if (formType == 'aluno') {
				$('#form-servidor').hide();
				$('#form-aluno').show();
			} else {
				$('#form-servidor').show();
				$('#form-aluno').hide();
			}
		});
	});
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
