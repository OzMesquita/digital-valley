	<%@page import="javax.swing.text.Document"%>
<%
	int numeroCurso=0;
	String matriculas ="";
	if(session.getAttribute("matriculas") != null && session.getAttribute("curso")!= null){ 
		numeroCurso = Integer.valueOf(session.getAttribute("curso").toString());
		matriculas = session.getAttribute("matriculas").toString();
		session.removeAttribute("matriculas");
		session.removeAttribute("curso");
		
	}%>


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
				
				<form action="importarAlunos" method="post">
					<div class="form-group">
						<label for="curso">Curso</label> 
						<select required="required" class="form-control" name="curso" id="curso">
							<option value=""> Selecione um curso</option>
							<option value="1" <%if(numeroCurso == 1){%>selected="selected"<%}%>> Ciência da Computação</option>
							<option value="2" <%if(numeroCurso == 2){%>selected="selected"<%}%>> Engenharia Civil</option>
							<option value="3" <%if(numeroCurso == 3){%>selected="selected"<%}%>> Engenharia de Produção</option>
							<option value="4" <%if(numeroCurso == 4){%>selected="selected"<%}%>> Engenharia de Software</option>
							<option value="5" <%if(numeroCurso == 5){%>selected="selected"<%}%>> Engenharia Mecânica</option>
						</select>
					</div>
					<div class="form-group">
						<label for="matriculas">Matrículas e Nomes</label>
						<textarea name="matriculas" id="matriculas" required="required"
							class="form-control" placeholder="123456 Nome do Aluno 1
123457 Nome do Aluno 2"><%if(matriculas != ""){out.print(matriculas);}%></textarea>
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
			