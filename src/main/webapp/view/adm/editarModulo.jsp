<%@page import="model.Usuario"%>
<%@page import="model.Modulo"%>
<%@page import="util.Facade"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%
		int id;
		if(request.getParameter("idModulo")!=null){
			id = Integer.parseInt(request.getParameter("idModulo"));
		}else{
			id = Integer.parseInt(session.getAttribute("idModulo").toString());
		}
     
		Modulo m = Facade.buscarModulosPorId(id);    
        
		if (m == null) {
                    session.setAttribute(Constantes.getSessionMsgError(), "Nenhum módulo selecionado.");
		} else { 
			session.setAttribute("modulo", m);
			session.setAttribute("idModulo", m.getId());
	%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Editar Módulo</h1>
          <p class="lead text-muted">Realize a edição do módulo  <%= m.getTitulo()%>.</p>
        </div>
      </section>
		<div class="container" style="min-height: 400px">
			<!-- aqui -->
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
			<div class="row">
			<div class="col-md-8">
				<div class="card">
						  <h5 class="card-header">Editar Modulo</h5>
						  <div class="card-body">
						<form action="EditarModulo" method="post">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>Código</label> <input type="text" class="form-control"
											disabled value="<%= m.getId()%>">
											<input type="hidden" name="idModulo" value="<%=id%>">
									</div>
								</div>
								<div class="col-md-9">
									<div class="form-group">
										<label>Titulo</label> <input type="text" 
											disabled class="form-control" value="<%= m.getTitulo()%>">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label>Descrição</label> <input type="text"
											class="form-control" name="descricao" value="<%= m.getDescricao()%>">
									</div>
								</div>
								</div>
								<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label>URL</label> <input type="text"
											class="form-control" name="url" value="<%= m.getUrl()%>">
									</div>
								</div>
							</div>

							<div class="clearfix"></div>
							<button id="save" type="submit" value="Salvar" class="btn btn-primary form-control">Salvar</button>
						</form>
					</div>
				</div>
				<div class="card">
						  <h5 class="card-header">Apagar Módulo</h5>
						  <div class="card-body">
							<form id="nivelUsuario" action="excluir_modulo" method="post">
								<button id="Apagar" type="submit" class="btn btn-danger form-control" value="Apagar">Apagar Modulo</button>
								<input type="hidden" name="idModulo" value="<%=m.getId()%>">
							</form>

						<br>

					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card">
						  <h5 class="card-header">Alterar Logo do Módulo</h5>
						  <div class="card-body">
							<form id="alterarFoto" action="alterarLogo" enctype="multipart/form-data" method="post">
							<div class="form-group" style="width:100%">
								<div id="imagemLogo" >
									<img class="card-img-top" id="smallTemplate" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 150px; width: 150px; display: block;" 
									src="<%=Constantes.getAppUrl()%>/view/imagem_modulo?id_modulo=<%=m.getId()%>" data-holder-rendered="true" >
									<%--<%=Constantes.getAppUrl()%>/view/imagem_modulo?id_modulo=<%=m.getId()%> --%>
									<%-- <img id="smallTemplate" src="<%=Constantes.getMODULES_IMAGES_DIR()%>/no_img" alt="Logo do módulo" width="80%" height="200" /> --%>
								</div>
								<label for="imagem">Logo Módulo</label>
										<label class="btn btn-outline-dark btn-file" style="width:100%">
										    <span id="text-btn-input-image">Selecionar Nova Imagem</span> <input type="file" name="imagem" id="imagem" style="display: none;">
										</label>
								<button id="Editar" type="submit" class="btn btn-primary form-control" value="EditarLogo" disabled="disabled">Editar logo do módulo</button>	
							</div>
							</form>

						<br>

					</div>
				</div>
				
			</div>

<%} %>

		</div>
			<!-- aqui -->
		</div>
		
		<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
	
		<script>
		$(function () {
			$('#imagem').change(function () {
				var file = $(this).val();
				if (file == "") {
					$("#text-btn-input-image").html("Selecionar Nova Imagem");
					$('#Editar')[0].disabled=true;
				} else {
					$("#text-btn-input-image").html("Imagem Selecionada");
					$('#Editar')[0].disabled=false;
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
