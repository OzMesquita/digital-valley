<%@page import="util.Facade"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Modulo"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Cadastrar Módulos</h1>
          <p class="lead text-muted">Cadastre módulos no sistema.</p>
        </div>
      </section>
<div class="container">
  				<div class="row">
  					
					<div class="col-md-12">
  					<div class="card">
						  <h5 class="card-header">Cadastrar Módulo</h5>
						  <div class="card-body">
							<form action="cadastrarModulo" name="formCadastro" enctype="multipart/form-data" method="post">
							
						<div class="row">

					<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="alert alert-success" role="alert">	
					<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					<%} %>
					<%if(session.getAttribute(Constantes.getSessionMsgError()) != null){ %>
						<div class="alert alert-danger" role="alert">
					<%=session.getAttribute(Constantes.getSessionMsgError()) %>
				</div>
					<%session.setAttribute(Constantes.getSessionMsgError(), null); %>
					
				<%} %>		
							<div class="col-md-12">
								<div class="form-group">
									<label for="titulo">Título</label> <input type="text" id="titulo" placeholder="Digite um título para o módulo"
										name="titulo" class="form-control"  required
									>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label for="url">URL</label> <input type="text" id="url" placeholder="Digite uma URL para o módulo"
										name="url" class="form-control" required
									>
								</div>
							</div>
							<div class="col-md-12">
							<div class="form-group">
							    <label for="exampleFormControlTextarea1">Descrição</label>
							    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="descricao" placeholder="Digite uma descrição para o módulo" required></textarea>
							  </div>
							 </div>
							 <div class="col-md-12">
							<div class="form-group" style="width:100%">
							<div id="imagemLogo" >
								<img class="card-img-top"id="smallTemplate" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 150px; width: 150px; display: block;" src="<%=Constantes.getAppImgUrl()%>/i2.png" data-holder-rendered="true">
								<!-- <img id="smallTemplate" src="../../assets2/img/no_img.jpg" alt="Logo do módulo" width="300" height="300" /> -->
							</div>
							<label for="imagem">Logo Módulo</label>
									<label class="btn btn-outline-dark btn-file" style="width:100%">
									    <span id="text-btn-input-image">Selecionar Nova Imagem</span> <input type="file" name="imagem" id="imagem" style="display: none;">
									</label>
							</div>
							</div>
							 <div class="col-md-12">
							<div class="form-group">
						<label>Perfil de Acesso</label>
						<p>
							<input type="checkbox" id="perfil_todos_checkbox" name="todos"><strong>Todos</strong>
						</p>
						<%
							List<Perfil> perfis = Facade.ListarPeril();
							for (Perfil p : perfis) {
						%>
						<p>
							<input type="checkbox" class="perfil_checkbox"
								name="<%=p.getNome()%>" value="<%=p.getNome()%>"><%=p.getNome()%>
						</p>
						<%
							}
						%>
					</div>
					</div>
						<div class="col-md-12">
						<div class="form-group">
						<input type="submit"
							class="btn btn-primary text-center form-control" value="Salvar"
							title="Salvar alterações">
					</div>
					</div>
						</div>
					</div>
					
				</form>
  </div>
  </div>
  
 	
				
  
  
  				</div>
			</div>
<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=Constantes.getAppJsUrl()%>/marcarCheckBoxDePerfis.js"></script>
	
		<script>
		$(function () {
			$('#imagem').change(function () {
				var file = $(this).val();
				if (file == "") {
					$("#text-btn-input-image").html("Selecionar Nova Imagem");
					$(".btn-submit-image").hide();
				} else {
					$("#text-btn-input-image").html("Imagem Selecionada");
					$(".btn-submit-image").show();
				}
			});
		});
	</script>
	
	<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#smallTemplate').attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $("#imagem").change(function(){
        readURL(this);
    });
	</script>