<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Importação de Matriculas</h3>
			</div>
			
			
			<div class="panel-body">
				<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="alert alert-danger" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>
				<form action="importarAlunos" method="post">
					<div class="form-group">
						<label for="curso">Curso</label> <select required="true"
							class="form-control" name="curso" id="curso">
							<option disabled="disabled" selected="selected" value="0">Selecione um curso</option>
							<option value="1"> Ciência da Computação</option>
							<option value="2"> Engenharia Civil</option>
							<option value="3"> Engenharia de Produção</option>
							<option value="4"> Engenharia de Software</option>
							<option value="5"> Engenharia Mecânica</option>
						</select>
					</div>
					<div class="form-group">
						<label for="matriculas">Matriculas</label>
						<textarea name="matriculas" id="matriculas" required="true"
							class="form-control"></textarea>
					</div>
					<div class="form-group">
						<input type="submit"
							class="text-center btn btn-success form-control"
							value="Importar" title="Importar arquivo">
					</div>
				</form>
				
			</div>
		</div>
	</div>
</div>