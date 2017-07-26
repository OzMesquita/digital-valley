<%-- 
    Document   : CadastroUsuario
    Created on : 02/06/2017, 15:28:14
    Author     : N2S-PC03
--%>

<%@page import="Modelos.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="Content-Language" content="pt-br">
        <link rel="apple-touch-icon" sizes="76x76" href="assets2/img/apple-icon.png">
        <link rel="icon" type="image/png" href="assets2/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Tela de cadastro</title>

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
    </head>
    <body>
        <% Pessoa usuario = (Pessoa) session.getAttribute("usuario"); %>
        <% if( session.getAttribute("msg")== null){
            session.setAttribute("msg", " ");
        } %>
        <div class="image-container set-full-height" style="background: steelblue;">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2">
                        <div class="wizard-container">
                            <div class="card wizard-card" data-color="orange" id="wizardProfile" style="height:auto;">
                                <% if(usuario.instanceOf(Aluno)){ %>
									<form action="CadastrarAluno" method="post" name="formCadastro">
								<%}else{%>
									<form action="CadastrarServidor" method="post" name="formCadastro">
								<%}%>
                                    <div class="wizard-header">
                                        <h3>
                                           <b>Sistema Controle de Acesso</b> <br>
                                           <small>Preencha seus dados</small>
                                        </h3>
                                    </div>
                                    <div class="wizard-navigation">
                                        <ul>
                                            <li><a data-toggle="tab">Cadastro</a></li>
                                        </ul>
                                    </div>
                                    <div class="tab-content">
                                        <div class="" >
                                            <div class="row">
                                                <div class="col-sm-8" style="margin-left: 15%;">
                                                    <div id="alerta" style="color: red; text-align: center;">
                                                        <small name="small" id="t_alerta"> <script>sessionStorage.getItem('msg');</script> </small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Nome Completo </label>
                                                        <input name="nome" type="text" disabled class="form-control" value="<%= usuario.getNome() %>">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Código Interno </label>
                                                        <input name="codigo" type="text" disabled class="form-control" value="<%= usuario.getId()%>">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Curso </label>
                                                        <input name="curso" type="text" disabled class="form-control" valu="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>CPF </label><small style="color: gray;"> (Digite apenas os números)</small>
                                                        <input name="cpf" title="Preencha este campo corretamente" type="text" class="form-control" required maxlength="11" placeholder="01234567890" onkeypress="return SomenteNumero(event)">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Data de Nascimento </label>
                                                        <input name="nascimento" title="Preencha este campo corretamente" type="text" class="form-control" required maxlength="8"  placeholder="01021995" onkeypress="return SomenteNumero(event)">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>E-mail </label>
                                                        <input name="e_mail" title="Preencha este campo corretamente" type="email" class="form-control" required placeholder="Examplo@gmail.com">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Login </label>
                                                        <input name="login" title="Preencha este campo corretamente" type="text" class="form-control" required placeholder="Nome de usuário">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Senha </label><small style="color: gray;">No mínimo 4 dígitos</small>
                                                        <input name="senha" title="Preencha este campo corretamente" type="password" class="form-control" required placeholder="Digite a senha">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Confirmar Senha </label>
                                                        <input name="confirmaSenha" title="Preencha este campo corretamente" type="password" class="form-control"  required  placeholder="Digite a senha novamente">
                                                    </div>
                                                    <div id="c_russas"  >
                                                        <h3 style=" margin-left: 50%;">
                                                            <small><a href="login" >Voltar para tela de login</a></small>
                                                        </h3>
                                                    </div>
                                                    <div class="pull-right">
                                                        <input id="btnsalvar" type='submit' value='Salvar' onclick="return validaSenha()" />
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
    </body>
        <script>
            function SomenteNumero(e){
                var tecla=(window.event)?event.keyCode:e.which;   
                if((tecla>47 && tecla<58)) return true;
                else{
                    if (tecla===8 || tecla===0) return true;
                    else  return false;
                }
            }
        </script>
    
        <script>
            function formatar(mascara, documento){
                var i = documento.value.length;
                var saida = mascara.substring(0,1);
                var texto = mascara.substring(i)

                if (texto.substring(0,1) !== saida){
                        documento.value += texto.substring(0,1);
                }

            }
        </script>
    
        <script>
            function validaSenha(){
               var senha = document.formCadastro.senha.value;
               var csenha = document.formCadastro.confirmaSenha.value;
               var n = senha.localeCompare(csenha);
                    if(n === 0){
                        sessionStorage.setItem('msg',' ');
                        var a = document.formCadastro.getElementById('t_alerta').removedNode();
                        a.remove();
                        return true;
                    }else{
                        var a = document.getElementById('alerta');
                        sessionStorage.setItem('msg','Senhas não são iguais');
                        a.innerHTML = '<small>'+sessionStorage.getItem('msg')+'</small>';
                        return false;
                    }
            }
        </script>
    <!--   Core JS Files   -->
	<script src="assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets2/js/jquery.validate.min.js"></script>
        
        
</html>
