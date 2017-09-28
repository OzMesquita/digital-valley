
		<div id="page-wrapper">
			<div class="container-fluid" style="min-height: 400px">
				<!-- aqui-->

				<div class="col-md-8" style="margin-left: 15%;">
					<div class="card">
						<div class="header" style="text-align: center;">
							<h4 class="title">Importação de Matriculas</h4>
							<hr style="border: 1px solid lightgray">
						</div>
						<div class="content">
							<form action="importarAlunos" method="post"
								style="margin-left: 20%;">
								<div class="row">
									<div class="col-md-8">
										<div class="form-group">
											<label>Curso</label> <select class="form-control"
												name="curso">
												<option disabled="disabled" selected="selected" value="0">Selecione um curso</option>
												<option value="1"> Ciência da Computação</option>
												<option value="2"> Engenharia Civil</option>
												<option value="3"> Engenharia de Produção</option>
												<option value="4"> Engenharia de Software</option>
												<option value="5"> Engenharia Mecânica</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-8">
										<div class="form-group">
											<label>Matriculas</label><small style="color: gray;">
											</small><br>
											<textarea name="matriculas" rows="10" cols="50"></textarea>
										</div>
									</div>
								</div>
								<input type="submit" id="salva" value="Importar"
									title="Importar arquivo">

							</form>
						</div>
					</div>
				</div>


				<!-- aqui-->
			</div>
		</div>

