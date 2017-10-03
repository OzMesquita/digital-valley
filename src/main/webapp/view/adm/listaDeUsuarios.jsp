<%@page import="model.Servidor"%>
<%@page import="model.EnumNivel"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Usuario"%>
<%@page import="model.Aluno"%>
<%@page import="util.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<div class="cbp-spmenu-push">
	<%
		List<Pessoa> usuarios = (List<Pessoa>) request.getAttribute("pessoas");
		String tipo = (String) request.getAttribute("tipo");
		String nome = (String) request.getAttribute("nome");
		String mensagem = (String) session.getAttribute("msg");		
	%>
	<div id="page-wrapper">
		<div class="container-fluid" style="min-height: 400px">
			<!-- aqui-->
			<div class="col-md-12">
				<div class="card">
					<div class="header" style="text-align: center;">
						<h4 class="title">Usuários</h4>
						<hr style="border: 1px solid lightgray">
						<div id="busca">
							<form action="<%=Constantes.getAdmUrl()%>/listar_usuarios"
								method="get">
								<input id="txt_busca" type="search" name="nome"
									placeholder="Nome" value="<%=nome != null ? nome : "" %>" /> <input class="btn_pad" type="submit"
									value="Buscar" title="Buscar" /> <select id="tipo" name="tipo"
									class="form-group " style="float: right">
									<option value="todos" <%="todos".equals(tipo) ? "selected" : "" %>>
											Todos</option>
									<option value="alunos" <%="alunos".equals(tipo) ? "selected" : "" %>>Alunos</option>
									<option value="servidores" <%="servidores".equals(tipo) ? "selected" : "" %>>
											Servidores</option>
								</select>
							</form>
						</div>

					</div>
					<div id="tabUsuarios">
						<table class="table table-hover table-striped">
							<thead>
								<th>CPF</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Nível</th>
							</thead>
							<tbody>
								<%
									for (Pessoa user : usuarios) {
								%>
								<tr>

									<td><%=user.getCpf()%></td>


									<td><a
										href="editarNivelDoUsuario.jsp?idUsuario=<%=user.getId()%>"><%=user.getNome()%></a></td>
									<td><%=user.getEmail()%></td>
									<td><%=user.getUsuario().getNivel()%></td>
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