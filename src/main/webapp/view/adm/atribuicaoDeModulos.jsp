<%@page import="util.Facade"%>
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
	List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
	List<Perfil> perfis = (List<Perfil>) request.getAttribute("perfis");
	Integer quantidadeDePaginas = (Integer) request.getAttribute("quantidadeDePaginas");
	Integer paginaAtual = (Integer) request.getAttribute("paginaAtual");
	String nomePessoa = request.getAttribute("nomePessoa") != null && !"".equals(request.getAttribute("nomePessoa")) ? (String) request.getAttribute("nomePessoa") : "";
%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Atribuir Módulos</h1>
          <p class="lead text-muted">Atribua módulos para os usuários.</p>
        </div>
      </section>
<div class="container">
			<div class="row">
			<form action="<%=Constantes.getAdmUrl() + "/atribuir_modulos"%>"
			method="GET" class="form-inline">
				  <div class="form-group mb-2">
				    <label for="staticEmail2" class="sr-only">Buscar por nome:</label>
				    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Buscar por nome:">
				  </div>
				  <div class="form-group mx-sm-3 mb-2">
				    <label for="inputPassword2" class="sr-only">Busca</label>
				    <input type="text" class="form-control" id="inputPassword2" name="nome" placeholder="Digite um nome">
				  </div>
				  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
				</form>
				<!-- 
				<div class="col-md-4 col-md-offset-3">
					<div class="form-group">
						<label for="nome">Nome: </label> <input type="text" id="nome"
							name="nome" class="form-control"
							value="<%=nomePessoa %>" />
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<input type="submit" class="form-control btn btn-primary"
							id="botao_buscar" value="Buscar" />
					</div>
				</div> -->
			</div>
		<div class="table-responsive">
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<th>Nome</th>
					<th>CPF</th>
					<th>E-mail</th>
					<th>Data Nascimento</th>
					<th>Opções</th>
				</thead>
				<tbody>
					<%
						for (Pessoa pessoa : pessoas) {
					%>
					<tr>
						<td><%=pessoa.getNome()%></td>
						<td><%=pessoa.getCpf()%></td>
						<td><%=pessoa.getEmail()%></td>
						<td><%=Facade.converterLocalDateParaString(pessoa.getDataNascimento()) %></td>
						<td><a
							href="<%=url%>/pessoa_modulos?pessoa_id=<%=pessoa.getId()%>&perfil_id=<%=Facade.buscarPessoaPorId(pessoa.getId()).getUsuario().getPerfil().getValorPerfil()%>">Gerenciar
								módulos</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="text-center">
		<div class="btn-group" role="group" aria-label="Basic example">
				
				<%
					if (quantidadeDePaginas > 1) {
						%>
					 	<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item <%if (paginaAtual <= 1) {%>disabled<%}%>">
									<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%if(paginaAtual <=1){%>0<%}else{out.print(paginaAtual-1);}%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%if (paginaAtual <= 1) {%>0<%}else{out.print(paginaAtual-1);}%>">
											Anterior
										</button>
									</form>
								</li>
								<%
								if(paginaAtual > 4 && (quantidadeDePaginas-paginaAtual) < 1)
								{
								%>
								<li>
									<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual-4);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-4);%>"> 
											<%out.print(paginaAtual-4);%>
										</button>
									</form>
								</li>
								<%
								}
								if(paginaAtual > 3 && (quantidadeDePaginas-paginaAtual) < 2)
								{
								%>
								<li>
									<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual-3);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-3);%>"> 
											<%out.print(paginaAtual-3);%>
										</button>
									</form>
								</li>
								<%
								}
								if(paginaAtual > 2)
								{
								%>
								<li>
									<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual-2);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-2);%>"> 
											<%out.print(paginaAtual-2);%>
										</button>
									</form>
								</li>
								<%
								}
								if(paginaAtual>1)
								{
								%>
								<li>
									<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual-1);%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual-1);%>"> 
											<%out.print(paginaAtual-1);%>
										</button>
									</form>
								</li>
								<%
								}
								%>
								<li class="page-item disabled">
							
							    	<span class="page-link"><%out.print(paginaAtual);%></span>
			
			   					 </li>
						
								<%
								if((quantidadeDePaginas-paginaAtual) > 0){%>	
									<li>
										<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual+1);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+1);%>"> 
												<%out.print(paginaAtual+1);%>
											</button>
										</form>
								</li>
								<%
								}
								
								if((quantidadeDePaginas-paginaAtual) > 1)
								
								{%>	
									<li>
										<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual+2);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+2);%>"> 
												<%out.print(paginaAtual+2);%>
											</button>
										</form>
									</li>
								<%}
								
								if((quantidadeDePaginas-paginaAtual) > 2 && paginaAtual < 3)
									
								{%>	
									<li>
										<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual+3);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+3);%>"> 
												<%out.print(paginaAtual+3);%>
											</button>
										</form>
									</li>
								<%}
								
								if((quantidadeDePaginas-paginaAtual) > 3 && paginaAtual < 2)
									
								{%>	
									<li>
										<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%out.print(paginaAtual+4);%>" id="formPag">
											<button class="page-link" type="submit" name="pagina" value="<%out.print(paginaAtual+4);%>"> 
												<%out.print(paginaAtual+4);%>
											</button>
										</form>
									</li>
								<%}
								
								%>
								<li class="page-item <%if (paginaAtual >= quantidadeDePaginas) {%>disabled<%}%>">
									<form method="get" action="<%=url%>/atribuir_modulos?pagina=<%if(paginaAtual >= quantidadeDePaginas){%>1<%}else{out.print(paginaAtual+1);}%>" id="formPag">
										<button class="page-link" type="submit" name="pagina" value="<%if (paginaAtual >= quantidadeDePaginas) {%>1<%} else {out.print(paginaAtual+1);}%>">
											Próximo
										</button>
									</form>
								</li>		
							</ul>
						</nav> 		
					<%
				
					}
				%>
			</div>
		</div>
	
<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Atribuir módulos por perfil</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<th>Nome</th>
							<th>Opções</th>
						</thead>
						<tbody>
							<%
								for (Perfil perfil : perfis) {
							%>
							<tr>
								<td><%=perfil.getNome()%></td>
								<td><a
									href="<%=url%>/perfil_modulos?perfil_id=<%=perfil.getId()%>">Gerenciar
										módulos</a></td>
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
