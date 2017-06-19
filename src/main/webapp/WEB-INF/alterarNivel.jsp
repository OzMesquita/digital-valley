<%@page import="java.time.LocalDate"%>
<%@page import="com.sun.prism.Texture.Usage"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Editar nivel</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <jsp:include  page="cabecalho.jsp" />
    </head>
    <body>
        <% session.setAttribute("usuario", new Usuario("beto22ufc", "1234"));
            session.setAttribute("pessoa", new Pessoa("beto", "11111111111", "betinlimma@gmail", (Usuario) session.getAttribute("usuario"), LocalDate.now()));
            
            
            Usuario usuarioDaSessao = (Usuario)session.getAttribute("usuario");
           Pessoa p = (Pessoa) session.getAttribute("pessoa");
        if(p == null){
        }else{ %>
        
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Editar Nível do Usuário </h4>
                            </div>
                                <div class="row">
                                    <form>

                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label>Código</label>
                                            <p> <%= p.getId()%> </p>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label>CPF</label>
                                            <p> <%= p.getCpf()%> </p>
                                        </div>
                                    </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Nome do Usuário</label>
                                            <p> <%= p.getNome() %> </p>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Data de Nascimento</label>
                                            <p> <%= p.getDataNascimento() %> </p>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>E-mail</label>
                                            <p> <%= p.getEmail()%> </p>
                                        </div>
                                    </div>
                                </div>


                                <button type="submit" class="btn btn-info btn-fill pull-right">Salvar Alterações</button>
                                <div class="clearfix"></div>
                            </form>
                        </div>
                        
                    </div>
                

                </div>
            </div>
        </div>
        </div>
        <% } %>

    </body>
</html>
