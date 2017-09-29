<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>

<body class="cbp-spmenu-push">
	<% 
	String mensagem = (String)session.getAttribute("msg");
	if(mensagem == null){
		mensagem = "";
	}
     
    %>

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
												<label>Nova Senha</label> <input type="password" class="form-control" name="senha" placeholder="Nova senha"> 
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
									<input type="submit" class="btn-importar" value="Salvar"
										title="Salvar alterações">
									<div class="clearfix"></div>
								</form>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
