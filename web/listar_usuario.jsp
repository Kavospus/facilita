<%-- 
    Document   : listar_menu
    Author     : André
--%>

<%@page import="modelo.UsuarioDAO"%>
<%@page import="modelo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.MenuDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuários</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript" language="JavaScript">
            function confirma(id){
                var url="excluir_usuario.do?id="+id;
                var resposta=confirm("Tem certeza que deseja excluir?\nclique em ok para confirmar ou em cancelar para desistir");
                if(resposta){
                    window.open(url,"_parent");
                }
            }
        </script>
    </head>
    <body>
        <div class="selfcontainer" align="center">
        <div class="header">
            <%@include file="menu.jsp" %>
        </div>
                    <div class="content">
                    <table class="filled tableMin">
                <tr>
                    <td class="filled" valign="top">
                        <table class="tableDist" align="center" >
                            <tr>
                                <td align="left" ><h1>Lista de Usuários</h1></td>
                                <td align="right" ><a class="button" href="form_inserir_usuario.jsp">Inserir Usuário</a></td>
                            </tr>
                        </table>
                        <table width="700"  align="center" >
                            <tr>
                                <td>Id</td>
                                <td>Nome</td>
                                <td>Login</td>
                                <td>Senha</td>
                                <td>Opções</td>
                            </tr>


                            <%
                            try{
                                UsuarioDAO uDB = new UsuarioDAO();
                                uDB.conectar();
                                ArrayList<Usuario> lista = uDB.listar();
                            for(Usuario u:lista){%>

                            <tr>
                                <td>
                                    <%=u.getId()%>
                                </td>
                                <td>
                                    <%=u.getNome()%>
                                </td>
                                <td>
                                    <%=u.getLogin()%>
                                </td>
                                <td>
                                    <%=u.getSenha()%>
                                </td>
                                <td>
                                    <a class="button" href="form_alterar_usuario.jsp?id=<%=u.getId()%>"><img width='16' height='16' src="imagens/edit.png"></a>
                                    <a class="button" href="#" onclick="confirma(<%=u.getId()%>)" ><img width='16' height='16' src="imagens/delete.png"></a>
                                </td>
                            </tr>

                            <% }
                            uDB.desconectar();
         }catch (Exception e) {
               out.println(e);
}
                            %>
                        </table>
                    </td>
                </tr>
            </table>
                        </div>
                                <div class="footer">
            </div>
        </div>
<%

    if(logged){
    Usuario uP = new Usuario();
    if(!uP.temPermissao(request.getRequestURI(),request.getContextPath(), user)){
       response.sendRedirect("index.jsp?erro=1");
    }else{
    session.setAttribute("usuario",true);
    }
    }

%>
    </body>
</html>
