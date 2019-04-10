<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Importar Servidores</h1>
          <p class="lead text-muted">Realize a importação de vários servidores ao mesmo tempo.</p>
        </div>
      </section>
<div class="container">
<div class="row">
<div class="col-md-12">
  					<div class="card">
						  <h5 class="card-header">Importar Servidores</h5>
						  <div class="card-body">
					<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
						<div class="alert alert-sucess" role="alert">
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
					<form action="importarServidor" method="post">
						<div class="form-group">
							<label for="nome">Nome Completo </label> <input required="true"
								name="nome" id="nome" type="text" class="form-control">
						</div>
						<div class="form-group">
							<label for="siape">Siape </label><input required="true"
								name="siape" id="siape" type="text" class="form-control">
						</div>
						<div class="form-group">
							<input type="submit"
								class="btn btn-primary form-control text-center"
								value="Importar" title="Importar matriculas">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
		type="text/javascript"></script>
	<script src="<%=Constantes.getAppJsUrl()%>/jquery.mask.min.js"
		type="text/javascript"></script>
	<script src="<%=Constantes.getAppJsUrl()%>/validacao.js"
		type="text/javascript"></script>