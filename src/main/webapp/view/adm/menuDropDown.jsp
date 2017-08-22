<%-- 
    Document   : menuDropDown
    Created on : 17/08/2017, 14:55:06
    Author     : N2S-PC03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../../assets2/css2/drop.css" rel="stylesheet" type="text/css" media="all" />
        <script src="../../assets2/js2/drop.js" type="text/javascript"></script>
    </head>
    <body>
        <%if(session.getAttribute("usuario")!= null){
            Usuario u = (Usuario) session.getAttribute("usuario");
        }else{response.sendRedirect("login.jsp");}
        %>
    
        <div class="wrapper-demo">
            <div id="dd" class="wrapper-dropdown-2" tabindex="1">Opções
                <ul class="dropdown">
                    <li title="Voltar a tela Inicial"><a href="#">Inicio</a></li>
                    <li title="Editar dados pessoais"><a href="#">Editar Perfil</a></li>
                    <%if(u.getNivel().equals("adm")){%>
                        <li title="Atribuir módulos aos usuários"><a href="#">Atribuir Módulos</a></li>
                        <li title="cadastrar novo módulo"><a href="#">Cadastrar Módulo</a></li>
                        <li title="Realizar importação de matriculas"><a href="#">Importar Matriculas</a></li>
                        <li title="Listar usuários do sistema"><a href="#">Listar Usuários</a></li>
                    <%}%>
                    <li title="Realizar logout"><a href="#">Sair</a></li>
                </ul>
            </div>
        </div>
        
        <script type="text/javascript">
            function DropDown(el) {
                    this.dd = el;
                    this.initEvents();
            }
            DropDown.prototype = {
                    initEvents : function() {
                            var obj = this;

                            obj.dd.on('click', function(event){
                                    $(this).toggleClass('active');
                                    event.stopPropagation();
                            }); 
                    }
            }
            $(function() {

                    var dd = new DropDown( $('#dd') );

                    $(document).click(function() {
                            // all dropdowns
                            $('.wrapper-dropdown-2').removeClass('active');
                    });

            });
        </script>
        
    </body>
</html>
