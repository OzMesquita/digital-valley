<%-- 
    Document   : login
    Created on : 24/05/2017, 16:13:20
    Author     : N2S-PC03
--%>


<%@page import="controller.Login"%>
<%@page import="beans.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="pt">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets2/img/apple-icon.png">
    <link rel="icon" type="image/png" href="assets2/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Tela de login</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="assets2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="assets2/css/demo.css" rel="stylesheet" />
    <!--meu css -->
    <link rel="stylesheet" href="assets2/css/newcss.css" type="text/css" />
</head>
    <body> 
        
        <%if(session.getAttribute("usuario") == null){
            if(request.getParameter("login") != null){%>
                <jsp:useBean id="usuario" class="beans.UsuarioBean" scope="session" />
                <jsp:setProperty name="usuario" property="login" param="login"/>
                <jsp:setProperty name="usuario" property="senha" param="senha"/>
                <% RequestDispatcher rd =request.getRequestDispatcher("login");
                   rd.forward(request, response);
                %>
                
        <% }else{
        %>
            <div class="image-container set-full-height" style="background: steelblue;">
		<div class="container">
          <div class="row">
			<div class="col-sm-8 col-sm-offset-2">
                 <div class="wizard-container">
                     <div class="card wizard-card" data-color="orange" id="wizardProfile" style="height:20px;">
                     
                     <!--  formulario -->
                         <form action="login" method="post" name="formLogin">
                             <div class="wizard-header">
                                 <h3>
                                    SISTEMA CONTROLE DE ACESSO <br>
                                 </h3>
                             </div>
                             <div class="wizard-navigation">
                                 <ul>
                                     <li><a href="#about" data-toggle="tab">Login</a></li>
                                 </ul>
                             </div>
                             <div class="tab-content">
                                 <div class="tab-pane" id="about">
                                     <div class="row">
                                         <div class="col-sm-4 col-sm-offset-1">
                                             <div class="picture-container">
                                                 <div class="picture">
                                                     <img src="assets2/img/ufc_logo.png" class="picture-src" id="wizardPicturePreview" title=""/>
                                                 </div>
                                             </div>
                                         </div>
                                         <div class="col-sm-6">
                                             <div class="form-group">
                                                 <label>Login </label>
                                                 <input name="login" type="text" class="form-control">
                                             </div>
                                             <div class="form-group">
                                                 <label>Senha </label>
                                                 <input name="senha" type="password" class="form-control">
                                             </div>

                                             <div id="c_russas">
                                                 <h3>
                                                    <small>UFC - Campus Russas</small>
                                                 </h3>
                                             </div>
                                             <div id="cadastro">
                                                 Ainda não tem cadastro? <a href="CadastroUsuario.jsp">Cadastre-se</a>
                                             </div>

                                             <div class="pull-right">
                                                 <input id="btnsalvar" type='submit' value='Entrar' onclick="return validarLogin()"/>
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
		</div> 
		<div class="footer">
           <div class="container">
               ₢ Todos os direitos reservados | N2S
           </div>
		</div>
	</div>
        <%}}else{
            response.sendRedirect("PaginaDoAluno.jsp");
        }%>
    </body>

	<!--   Core JS Files   -->
	<script src="assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
	
	<!--  Plugin for the Wizard -->
	<script src="assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets2/js/jquery.validate.min.js"></script>
        
        
        <script type="text/javascript">
            function validarLogin(){
                if(document.formLogin.login.value === "" && document.formLogin.senha.value === ""){
                    alert("Login e Senha Inválidos");
                    return false;
                }else if(document.formLogin.login.value === "" ){
                    alert("Campo Login Inválido");
                    return false;
                }
                else if(document.formLogin.senha.value === ""){
                    alert("Campo Senha Inválido");
                    return false;
                }
            }
        </script>
 
</html>
