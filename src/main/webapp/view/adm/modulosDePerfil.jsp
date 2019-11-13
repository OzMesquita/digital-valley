<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="model.EnumNivel"%>
<%@page import="util.Constantes"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String url = (String) request.getAttribute("url");
	List<Modulo> modulosDoPerfil = (List<Modulo>) request.getAttribute("modulosDoPerfil");
	List<Modulo> modulos = (List<Modulo>) request.getAttribute("modulos");
	Perfil perfil = (Perfil) request.getAttribute("perfil");
%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Associar módulos de perfil</h1>
          <p class="lead text-muted">Associe módulos ao perfil de <strong><%=perfil.getNome()%></strong>.</p>
        </div>
      </section>
<div class="container">
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default header">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Módulos Desassociados</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<th>Título</th>
						<th>URL</th>
						<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Modulo modulo : modulos) {
							%>
							<tr>
								<td><%=modulo.getTitulo()%></td>
								<td><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
										alt="<%=modulo.getTitulo()%>" style="height: 50px; width: 50px; display: block;" src="<%=Constantes.getAppUrl()%>/view/imagem_modulo?id_modulo=<%=modulo.getId()%>"></a></td>
								<td>
									<form method="POST" action="<%=url%>/associar_modulo_perfil">
										<input type="hidden" value="<%=perfil.getId()%>"
											name="perfil_id" /> <input type="hidden"
											value="<%=modulo.getId()%>" name="modulo_id" /> <input
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
		<div class="panel panel-default header">
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
								for (Modulo modulo : modulosDoPerfil) {
							%>
							<tr>
								<td col="10"><%=modulo.getTitulo()%></td>
								<td col="10"><a href="<%=modulo.getUrl()%>"><img id="img_modulo"
										alt="<%=modulo.getTitulo()%>" style="height: 50px; width: 50px; display: block;" src="<%=Constantes.getAppUrl()%>/view/imagem_modulo?id_modulo=<%=modulo.getId()%>"></a></td>
								<td>
									<form method="POST" action="<%=url%>/desassociar_modulo_perfil">
										<input type="hidden" value="<%=perfil.getId()%>"
											name="perfil_id" /> <input type="hidden"
											value="<%=modulo.getId()%>" name="modulo_id" /> <input
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