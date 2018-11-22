<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page import="util.Facade"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%

        int id = Integer.parseInt(request.getParameter("idUsuario"));
        

        
		Pessoa p = Facade.buscarPessoaPorId(id);
		if (p == null) {
                    session.setAttribute("msg", "Nenhum usuário selecionado.");
		} else { session.setAttribute("pessoa", p);
	%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Editar perfil do usuário</h1>
          <p class="lead text-muted">Realize a edição do perfil do usuário <%= p.getNome()%>.</p>
        </div>
      </section>
		<div class="container" style="min-height: 400px">
			<!-- aqui -->
			<div class="row">
			<div class="col-md-8">
				<div class="card">
						  <h5 class="card-header">Editar Perfil</h5>
						  <div class="card-body">
						<form action="AlterarEmail" method="post">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Código</label> <input type="text" class="form-control"
											disabled value="<%= p.getId()%>">
											<input type="hidden" name="idUsuario" value="<%=id%>">
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
							<button id="save" type="submit" value="Salvar" class="btn btn-primary form-control">Salvar</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card">
						  <h5 class="card-header">Editar Nível</h5>
						  <div class="card-body">
							<form id="nivelUsuario" action="AlterarNivel" method="post">
							<div class="form-group">
								<select class="form-control" name="nivel" required>
									<option disabled="disable" selected="true">
										<%=p.getUsuario().getNivel() %></option>
									<option value="2">Usuário Comum</option>
									<option value="1">Administrador</option>
								</select>
								</div>
								<button id="save" type="submit" class="btn btn-primary form-control" value="Salvar">Salvar</button>
								<input type="hidden" name="idUsuario" value="<%=id%>">
							</form>

						<br>

					</div>
				</div>
			</div>
<%} %>

		</div>
			<!-- aqui -->
		</div>


