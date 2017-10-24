<%-- 
    Document   : CadastroUsuario
    Created on : 02/06/2017, 15:28:14
    Author     : N2S-PC03
--%>

<%@page import="util.Constantes"%>
<%@page import="model.EnumCargo"%>
<%@page import="model.EnumCurso"%>
<%@page import="util.Constantes" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Language" content="pt-br">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets2/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets2/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Tela de cadastro</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!--     Fonts and icons     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet">

<!-- CSS Files -->
<link href="../assets2/css/bootstrap.min.css" rel="stylesheet" />
<link href="../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../assets2/css/demo.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="../assets2/css/newcss.css" type="text/css" />
</head>
<body>

	<% String mensagem  = (String) session.getAttribute("msg");
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
							id="wizardProfile" style="height: auto;">
							<form
								action="<%= session.getAttribute("nomeA") != null ? "cadastroAluno" : "cadastroServidor" %>"
								method="post" name="formCadastro">
								<div class="wizard-header">
									<h3>
										<b>Sistema Controle de Acesso</b> <br> <small>Preencha
											seus dados</small>
									</h3>
								</div>
								
								<div class="tab-content">
									<div class="">
										<div class="row">
											<div class="col-sm-8" style="margin-left: 15%;">
												<div id="alerta" style="color: red; text-align: center;">
													<small name="small" id="t_alerta"> <%= mensagem%>
													</small>
												</div>
												<div class="form-group">
													<label>Nome Completo </label> <input name="nome"
														type="text" class="form-control"
														value="<%= session.getAttribute("nomeA") != null ? session.getAttribute("nomeA") : session.getAttribute("nomeS") %>"
														readonly="true">
												</div>
												<div class="form-group">
													<label>CÛdigo Interno </label> <input name="codigo"
														type="text" class="form-control"
														value="<%= session.getAttribute("nomeA") != null ? session.getAttribute("matricula") : session.getAttribute("siape") %>"
														readonly="true">
												</div>
												<%if(session.getAttribute("nomeA")!=null){
                                                    	
                                                    	%>
												<div class="form-group">
													<label>Curso</label> <input name="curso" type="text"
														class="form-control"
														value="<%=EnumCurso.value((Integer) session.getAttribute("curso")) %>"
														readonly="true">
												</div>

												<div class="form-group">
													<label>Semestre de Ingresso</label> <input
														name="semestreDeIngresso"
														title="Preencha este campo corretamente" type="text"
														class="form-control" required maxlength="6"
														placeholder="Ex.: 2015.1"
														OnKeyPress="formatar('####.#',this)">
												</div>
												<%}else{ 
                                                   		
                                                   %>
												<div class="form-group">
													<label>Cargo</label> <select class="form-control"
														name="cargo">
														<option disabled="disabled" selected="selected" value="0">Selecione um cargo</option>
														<%
                                                   			EnumCargo cargos[]  =  EnumCargo.values();
                                                       		for(EnumCargo e: cargos){
                                                   			%>
														<option value="<%=e.getCargo() %>"><%=e.getCargo() %></option>
														<%
                                                   			} 
                                                   			%>
													</select>

												</div>
												<%	
                                                   	} %>
												<div class="form-group">
													<label>CPF </label> <input name="cpf" id="cpf"
														title="Preencha este campo corretamente" type="text"
														class="form-control" required maxlength="14"
														placeholder="012.345.678-90"
														OnKeyPress=" this.value = FormataCpf()">
												</div>
												<div class="form-group">
													<label>Data de Nascimento </label> <input name="nascimento" id="nascimento" 
														title="Preencha este campo corretamente" type="text"
														class="form-control" required >
												</div>
												<div class="form-group">
													<label>E-mail </label> <input name="email" id="email"
														title="Preencha este campo corretamente" type="email"
														class="form-control" required
														placeholder="Examplo@gmail.com">
												</div>
												<div class="form-group">
													<label>Login </label> <input name="login"
														title="Preencha este campo corretamente" type="text"
														class="form-control" required
														placeholder="Nome de usu·rio">
												</div>
												<div class="form-group">
													<label>Senha </label> <input name="senha"
														title="Preencha este campo corretamente" type="password"
														class="form-control" required placeholder="Digite a senha">
												</div>
												<div class="form-group">
													<label>Confirmar Senha </label> <input name="senha2"
														title="Preencha este campo corretamente" type="password"
														class="form-control" required
														placeholder="Digite a senha novamente"
														onchange="validaSenha()">
												</div>
												<div id="c_russas">
													<h3 style="margin-left: 50%;">
														<small><a href="../login.jsp">Voltar para
																tela de login</a></small>
													</h3>
												</div>
												<div class="pull-right">
													<input id="btnsalvar" type='submit' value='Salvar' />
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
			<div class="container">‚Ç¢ Todos os direitos reservados | N2S</div>
		</div>
	</div>
</body>

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
                        sessionStorage.setItem('msg','Senhas n√£o s√£o iguais');
                        a.innerHTML = '<small>'+sessionStorage.getItem('msg')+'</small>';
                        return false;
                    }
            }
        </script>



<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
	<!--   Core JS Files   -->
<script src="../assets2/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/jquery.mask.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/validacao.js"
	type="text/javascript"></script>
</html>
