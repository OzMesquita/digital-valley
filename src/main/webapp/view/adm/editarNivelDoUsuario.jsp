<%@page import="model.EnumCurso"%>
<%@page import="model.EnumCargo"%>
<%@page import="model.EnumPerfil"%>
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
		} else {
			session.setAttribute("pessoa", p);
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
											disabled value="<%=p.getId()%>"> <input
											type="hidden" name="idUsuario" value="<%=id%>">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>CPF</label> <input type="text" id="cpf"
											class="form-control" disabled value="<%=p.getCpf()%>">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label>Nome do Usuário</label> <input type="text"
											class="form-control" disabled value="<%=p.getNome()%>">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Data de Nascimento</label> <input type="text"
											class="form-control" disabled
											value="<%=p.getDataNascimento()%>">
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

					<!-- formulario para mudar o perfil -->
					
					<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="alert alert-danger" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>
					<div class="content">
					
					<%if(request.getParameter("sucessoEditarPerfil")!= null){ %>
					<div class="alert alert-success" role="alert">
  						<p>Perfil alterado com sucesso</p>
					</div>
					
				<%} %>
				
				
				
						<form action="AlterarPerfil" name="alterarPerfilForm"
							method="post">
							<input type="hidden" name="idUsuario" value="<%=request.getParameter("idUsuario") %>" >
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
									
										<input type="hidden" name="pessoa" value="<%=id%>"> <label
											for="select-perfil">Tipo de perfil </label> <select
											id="select-perfil" name="perfil" onchange="novoPerfilDados()">
											
											<option value="0">Selecione uma opção</option>

											<%
												EnumPerfil perfil[] = EnumPerfil.values();
													for (EnumPerfil e : perfil) {
														if (p.getUsuario().getPerfil().getValorPerfil() == e.getValorPerfil()) {
															continue;
														}
											%>
											<option value="<%=e.getValorPerfil()%>"><%=e.toString()%></option>
											
											<%
												}
											%>
				
										</select> <input type="submit" id="save" value="Salvar" />
									</div>
								</div>
							</div>
							<div class="row">

								<div id="hiddenAluno" style="visibility: hidden;">
									<label for="matricula">Matricula</label> <input id="matricula"
										type="text" name="matricula"><br> <label
										for="semestreDeIngresso">Semestre de Ingresso</label> <input
										type="text" name="semestreIngresso" id="semestreDeIngresso"
										maxlength="6" placeholder="Ex.: 2017.1"><br>
										<label for="curso" >Curso</label><br> 
										<select  class="form-control" name="curso" id="curso">
										<option disabled="disabled" selected="selected" value="0">Selecione
											um curso</option>
										<option value="1">Ciência da Computação</option>
										<option value="2">Engenharia Civil</option>
										<option value="3">Engenharia de Produção</option>
										<option value="4">Engenharia de Software</option>
										<option value="5">Engenharia Mecânica</option>
									</select>
								</div>


								<div id="hiddenServidor" style="visibility: hidden;">
									<label for="siape">SIAPE</label> <input id="siape" type="text"
										name="siape" class="siape"><br> <label
										for="cargo">Cargo</label> <select class="form-control"
										id="cargo" name="cargo">
										<option disabled="disabled" selected="selected" value="0">Selecione
											um cargo</option>
										<%
											EnumCargo cargos[] = EnumCargo.values();
												for (EnumCargo e : cargos) {
										%>
										<option value="<%=e.getCargo()%>"><%=e.getCargo()%></option>
										<%
											}
										%>
									</select>
								</div>

							</div>
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
										<%=p.getUsuario().getNivel()%></option>
									<option value="2">Usuário Comum</option>
									<option value="1">Administrador</option>
								</select> <input id="save" type="submit" value="Salvar"> <input
									type="hidden" name="idUsuario" value="<%=id%>">
							</form>
						</div>

						<br>

					</div>
					<hr>
				</div>
			</div>
			<%
				}
			%>


			<!-- aqui -->
		</div>
	</div>
</div>
<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/jquery.mask.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/validacao.js"
	type="text/javascript"></script>

<script type="text/javascript">
	function novoPerfilDados() {
		var option = document.getElementById("select-perfil");
		if (option.options[option.selectedIndex].text == "ADMINISTRADOR"
				|| option.options[option.selectedIndex].text == "VISITANTE") {
			document.getElementById("hiddenAluno").style.visibility = "hidden";
			document.getElementById("hiddenServidor").style.visibility = "hidden";
		}
		if (option.options[option.selectedIndex].text == "ALUNO") {
			document.getElementById("hiddenAluno").style.visibility = "visible";
			document.getElementById("hiddenServidor").style.visibility = "hidden";
		}
		if (option.options[option.selectedIndex].text == "SERVIDOR") {
			document.getElementById("hiddenServidor").style.visibility = "visible";
			document.getElementById("hiddenAluno").style.visibility = "hidden";
		}
	}
</script>

