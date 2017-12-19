<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page import="util.Facade"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="cbp-spmenu-push">
	<%

        int id = Integer.parseInt(request.getParameter("idUsuario"));
        

        
		Pessoa p = Facade.buscarPessoaPorId(id);
		if (p == null) {
                    session.setAttribute("msg", "Nenhum usuário selecionado.");
		} else { session.setAttribute("pessoa", p);
	%>

	<div id="page-wrapper header">
		<div class="container-fluid" style="min-height: 400px">
			<!-- aqui -->

			<div class="col-md-8">
				<div class="card">
					<div class="header" style="text-align: center;">
						<h4 class="title">Perfil do Usuário</h4>
						<hr style="border: 1px solid lightgray">
					</div>
					<div class="content">
						<form action="AlterarEmail" method="post">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Código</label> <input type="text" class="form-control"
											disabled value="<%= p.getId()%>">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>CPF</label> <input type="text" id="cpf"
											class="form-control" disabled value="<%= p.getCpf()%>">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label>Nome do Usuário</label> <input type="text"
											class="form-control" disabled value="<%= p.getNome()%>">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Data de Nascimento</label> <input type="text"
											class="form-control" disabled
											value="<%= p.getDataNascimento()%>">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label>E-mail</label> <input type="text" name="email"
											class="form-control" required value="<%=p.getEmail()%>">
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<input id="save" type="submit" value="Salvar">
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card card-user">

					<div class="content">
						<div class="author">
							<form id="nivelUsuario" action="AlterarNivel" method="post">
								<div class="header">
									<label>Nivel do Usuário</label>
								</div>
								<select class="form-control" name="nivel" required>
									<option disabled="disable" selected="true">
										<%=p.getUsuario().getNivel() %></option>
									<option value="2">Usuário Comum</option>
									<option value="1">Administrador</option>
								</select> <input id="save" type="submit" value="Salvar">
							</form>
						</div>

						<br>

					</div>
					<hr>
				</div>
			</div>
<%} %>


			<!-- aqui -->
		</div>
	</div>
</div>

