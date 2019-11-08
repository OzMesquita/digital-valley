<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>
<%@page import="util.Facade"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
	List<Modulo> modulosDisponiveis = (List<Modulo>) request.getAttribute("modulosDisponiveis");
	List<Modulo> modulosAssociados = (List<Modulo>) request.getAttribute("modulosAssociados");
	List<Modulo> modulosARemover = new ArrayList<Modulo>();
	for(Modulo m:modulosAssociados){
		for(Modulo m2: modulosDisponiveis){
			if(m2.getId() == m.getId()){
				modulosARemover.add(m2);
			}
		}
	}
	
	for(Modulo m: modulosARemover){
		modulosDisponiveis.remove(m);
	}
	String url = Constantes.getAdmUrl();
%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Associar módulos de pessoa</h1>
          <p class="lead text-muted">Associe módulos ao usuário <strong><%=pessoa.getNome()%></strong> de CPF <strong><%=pessoa.getCpf()%></strong>.</p>
        </div>
      </section>
<div class="container">
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Módulos Desassociados</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<th>Título</th>
							<th>URL</th>
							<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Modulo modulo : modulosDisponiveis) {
							%>
							<tr>
								<td><%=modulo.getTitulo()%></td>
								<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
										alt="<%=modulo.getTitulo()%>" style="width:50px; height:50px;" src="<%=Constantes.getAppUrl()%>/view/imagem_modulo?id_modulo=<%=modulo.getId()%>"></a></td>
								<td>
									<form method="POST" action="<%=url%>/associar_modulo_pessoa">
										<input type="hidden" value="<%=pessoa.getId()%>"
											name="pessoa_id" /> <input type="hidden"
											value="<%=modulo.getId()%>" name="modulo_id" /> <input type="hidden" value="<%= Facade.buscarPessoaPorId(pessoa.getId()).getUsuario().getPerfil().getValorPerfil() %>" 
											name="perfil_id" /> <input
											type="submit" class="btn btn-success" value="Associar" />
									</form>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Módulos Associados</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<th>Título</th>
							<th>URL</th>
							<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Modulo modulo : modulosAssociados) {
							%>
							<tr>
								<td><%=modulo.getTitulo()%></td>
								<td><a href="<%=modulo.getUrl()%>"> <img
										id="img_modulo" alt="<%=modulo.getTitulo()%>"
										style="width:50px; height:50px;" src="<%=Constantes.getAppUrl()%>/view/imagem_modulo?id_modulo=<%=modulo.getId()%>">
								</a></td>
								<td>
									<form method="POST" action="<%=url%>/desassociar_modulo_pessoa">
										<input type="hidden" value="<%=pessoa.getId()%>"
											name="pessoa_id" /> <input type="hidden"
											value="<%=modulo.getId()%>" name="modulo_id" /><input type="hidden" value="<%= Facade.buscarPessoaPorId(pessoa.getId()).getUsuario().getPerfil().getValorPerfil()%>"
											name="perfil_id" /> <input
											type="submit" class="btn btn-danger" value="Desassociar" />
									</form>
								</td>
							</tr>
							<%
								}
							%>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</div>