<%-- 
    Document   : verificaCadastro
    Created on : 07/07/2017, 08:59:58
    Author     : N2S-PC03
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
    <link rel="apple-touch-icon" sizes="76x76" href="assets2/img/apple-icon.png">
    <link rel="icon" type="image/png" href="assets2/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Tela de confirmação</title>

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
    <link rel="stylesheet" href="newcss.css" type="text/css" />
      
    <style>
        #btn_confirma{
            width: 150px;
            height: 35px;
            background: steelblue;
            color: white;
            float: right;
        }
        #selecionado{
            background: steelblue;
            color: white;
        }
    </style>
<title>Cadastre-se</title>
</head>
<body>
    <div class="image-container set-full-height" style="background: steelblue;">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                    <div class="wizard-container">
                        <div class="card wizard-card" data-color="orange" id="wizardProfile" style="height:20px;">
                            <%if(request.getParameter("tipoUsuario") == null){
                                session.setAttribute("status1", "selecionado");
                                response.sendRedirect("verificacaoCadastro.jsp?tipoUsuario=1");
                            }else{%>
                            
                            <%if(request.getParameter("tipoUsuario").equals("1")){
                                session.setAttribute("status1", "selecionado");
                                session.setAttribute("status2", "");
                            }
                            else{
                                session.setAttribute("status2", "selecionado");
                                session.setAttribute("status1", "");
                            }%>
                                <div class="wizard-header">
                                    <h3>
                                        <b>Escolha seu tipo de usuário</b>
                                    </h3>
                                </div>
                                <ul>
                                    <li><a href="verificacaoCadastro.jsp?tipoUsuario=1" id="<%=session.getAttribute("status1")%>">Aluno</a></li>
                                    <li><a href="verificacaoCadastro.jsp?tipoUsuario=2" id="<%=session.getAttribute("status2")%>">Servidor</a></li> 
                                </ul>
                                
                                <div class="row">
                                    <div class="col-sm-6" style="margin-left: 25%;">
                                    
                                   
                                    
                                    <div id="alerta" style="color: red; text-align: center;" >
                                    	<%if(session.getAttribute("excecao")!= null){
                                    	%>
                                    	<small><%=session.getAttribute("excecao") %></small>
                                    	
                                    	<%
                                    	session.removeAttribute("excecao");
                                    	} %>
                                    </div>
                                        <div class="form-group">
                                            <div class="tab-content">
                                                <form method="post" action="verificacao" name="formVerifica" >
                                                    <%if(request.getParameter("tipoUsuario").equals("1")){%>
                                                        <label for="matricula" >Matricula</label><input type="text" name="matricula" class="form-control"><br>
                                                    <% } %>	
                                                    <%if(request.getParameter("tipoUsuario").equals("2")){%>
                                                        <label for="siape" >Siape</label><input type="text" name="siape" class="form-control"><br>
                                                    <% } %>
                                                    <label for="nome" >Nome Completo</label><input type="text" name="nome" class="form-control"><br>
                                                    <a href="login.jsp">Voltar para tela de login</a>
                                                    <input id="btn_confirma" type="submit" value="Confirmar" onclick="validarCampos()">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            <%}%>
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
    </div>
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
            function validarCampos(){
                if(document.formVerifica.matricula.value === "" && document.formVerifica.nome.value === ""){
                    alert("Matricula e Nome Inválidos");
                    return false;
                }else if(document.formVerifica.matricula.value === "" ){
                    alert("Campo Matricula Inválido");
                    return false;
                }
                else if(document.formVerifica.nome.value === ""){
                    alert("Campo Nome Inválido");
                    return false;
                }
                //document.formVerifica.submit();
            }
        </script>
</html>