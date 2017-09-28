<%@page import="util.Facade"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Modulo"%>

<div class="cbp-spmenu-push">
	<%  String mensagem = (String)session.getAttribute("msg");
            if(mensagem == null){
                mensagem = "";
            }
         %>


		<div id="page-wrapper">
			<div class="container-fluid" style="min-height: 400px">

				<!-- aqui -->
				<div class="row">
					<div class="col-md-6" style="margin-left: 25%;">
						<div class="card">
							<div class="header">
								<h4 class="title" style="text-align: center;">Cadastro de
									Módulo</h4>
								<hr style="border: 1px solid lightgray">
							</div>
							<div class="erroMsg">
								<small><%= mensagem %>
									<%session.setAttribute("msg", null);%></small>
							</div>
							<div class="content">
								<div id="corpo">
									<div id="centro">
										<form method="post" action="adm/cadastrarModulo"
											name="formCadastro">
											<label for="titulo">Título</label><input type="text"
												title="Preencha este campo" name="titulo" required
												class="form-control"><br> <label for="url">URL</label><input
												type="text" title="Preencha este campo" name="url" required
												class="form-control"><br> <label for="imagem">Imagem</label><input
												type="file" title="Preencha este campo" name="imagem"><br>
											<label for="perfil">Perfil de Acesso</label><br>
											<div style="margin-left: 3%">
												<input type="checkbox" class="marcar" name="todos" value=""
													onclick="marcardesmarcar()"> Todos<br>
												<%
                                                        	List<Perfil> perfis = Facade.ListarPeril();
                                                        	for(Perfil p: perfis){
                                                        %>
												<input type="checkbox" class="marcar"
													name="<%=p.getNome() %>" value="ok">
												<%=p.getNome() %><br>
												<%} %>
											</div>
											<div style="margin-top: 0% !important">
												<input id="btn_confirma" type="submit" value="Salvar"
													title="Salvar módulo">
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- aqui -->
			</div>
		</div>
</div>
