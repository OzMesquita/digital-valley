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
		List<Pessoa> usuarios = (List<Pessoa>) session.getAttribute("usuarios");
		String mensagem = (String) session.getAttribute("msg");
		if (usuarios != null && !usuarios.isEmpty()) {
			usuarios = (List<Pessoa>) session.getAttribute("usuarios");
		} else {

			usuarios = (ArrayList<Pessoa>) Facade.buscarPessoas();
		}
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
								<form action="ListaUsuario" method="get">
									<input id="txt_busca" type="search" name="busca"
										placeholder="Buscar por usuários..." /> <input
										style="margin-left: 1%;" class="btn_pad" type="submit"
										value="Buscar" title="Buscar Usuários" /> <select id="filtro"
										name="filtro" class="form-group " style="float: right">
										<option value="todos" selected="" onclick="filtro()">
											Todos</option>
										<option value="alunos" onclick="filtro()">Alunos</option>
										<option value="servidores" onclick="filtro()">
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




				<!-- aqui-->
			</div>
		</div>
	</div>