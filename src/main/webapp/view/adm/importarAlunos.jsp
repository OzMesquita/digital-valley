<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Importar Alunos</h1>
          <p class="lead text-muted">Realize a importação de vários alunos ao mesmo tempo.</p>
        </div>
      </section>
<div class="container">
<div class="row">
<div class="col-md-12">
  					<div class="card">
						  <h5 class="card-header">Importar Alunos</h5>
						  <div class="card-body">

				<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="alert alert-danger" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>
				
				
				<%if(request.getParameter("sucesso")!= null){ %>
					<div class="alert alert-success" role="alert">
  						Pré cadastro dos alunos realizada com sucesso !
					</div>
					
				<%} %>
				<form action="importarAlunos" method="post">
					<div class="form-group">
						<label for="curso">Curso</label> <select required="required"
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
						<textarea name="matriculas" id="matriculas" required="required"
							class="form-control" placeholder="123456 Nome do Aluno 1
123457 Nome do Aluno 2"></textarea>
					</div>
					<div class="form-group">
						<input type="submit"
							class="text-center btn btn-primary form-control"
							value="Importar" title="Importar arquivo">
					</div>
				</form>
				
			</div>
			  </div>
  </div>
  </div>
			</div>