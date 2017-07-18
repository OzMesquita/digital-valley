<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page import="model.Modulo" %>

<!doctype html>
<html lang="pt">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Cadastrar Módulo</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="../assets2/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="../assets2/css/demo.css" rel="stylesheet" />
        <!--meu css -->
        <link rel="stylesheet" href="newcss.css" type="text/css" />
        
        <style>
            #btn_confirma{
                width: 150px;
                height: 35px;
                background: steelblue;
                color: white;
                float: right;
            }
            #faixa_topo{
                height: 10%;
                color: white;
                background: steelblue;
                text-align: center;
                text-transform: uppercase;

            }
            #texto_faixa{
                margin-top: 1.2%;
            }
        
        </style>
    </head>
    <body>
        <div class="image-container set-full-height" style="background: steelblue;">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                    <div class="wizard-container">
                        <div class="card wizard-card" data-color="orange" id="wizardProfile" style="height:auto;">
                            <div class="wizard-header">
                                <h3>
                                    <b>Cadastro de Módulo</b><br>
                                    <small>Preencha as informações</small>
                                </h3>
                            </div>
                            <ul id="faixa_topo">
                                <li id="texto_faixa">Cadastro</li>
                            </ul>
                            <div class="row">
                                <div class="col-sm-8" style="margin-left: 15%;">
                                    <div class="form-group">
                                        <div class="tab-content">
                                            <form method="post" action="verificacao" name="formCadastro" >
                                                <label for="titulo" >Título</label><input type="text" title="Preencha este campo" name="titulo" required class="form-control"><br>
                                                <label for="url" >URL</label><input type="text" title="Preencha este campo" name="url" required class="form-control"><br>
                                                <label for="perfil" >Perfil de Acesso</label><br>
                                                <select name="perfil" class="form-control"  title="selecione o perfil de acesso para este módulo" style="font-family: inherit">
                                                    <option disabled="" selected="select" >Selecione</option>
                                                    <option value="2" >Option two</option>
                                                    <option value="3" >Option three</option>
                                                </select><br>
                                                <label for="imagem" >Imagem</label><input type="file" title="Preencha este campo" name="imagem" ><br>
                                                <div style="margin-top: 0% !important">
                                                    <input id="btn_confirma" type="submit" value="Confirmar">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer" style="margin-top: 5% !important">
                <div class="container">
                    ₢ Todos os direitos reservados | N2S
                </div>
            </div>
        </div>
    </div>
</body>

    <!--   Core JS Files   -->
	<script src="../assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="../assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="../assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../assets2/js/jquery.validate.min.js"></script>


</html>
