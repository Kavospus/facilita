<%-- 
    Document   : listar_menu
    Author     : André
--%>

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
        <title>Lista de menus</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/teste.js"></script>
        <script type="text/javascript" language="JavaScript">
            function confirma(id){
                var url="excluir_menu.do?id="+id;
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
                                <td align="left" ><h1>Lista de Menus</h1></td>
                                <td align="right" ><a class="button" href="form_inserir_menu.jsp">Inserir Menu</a></td>
                            </tr>
                        </table>
                        
                        <table class="" width="500" align="center" >
                            <tr>
                                <td>Id</td>
                                <td>Menu</td>
                                <td>Link</td>
                                <td>Icone</td>
                                <td>Opções</td>
                            </tr>


                            <%
                            try{
                                MenuDAO menuDB = new MenuDAO();
                                menuDB.conectar();    
                                ArrayList<Menu> lista = menuDB.listar();
                            for(Menu menu:lista){%>

                            <tr>
                                <td>
                                    <%out.print(menu.getId());%>
                                </td>
                                <td>
                                    <%out.print(menu.getMenu());%>
                                </td>
                                <td>
                                    <%out.print(menu.getLink());%>
                                </td>
                                <td>
                                    <img width="16" height="16" src="<%out.print(menu.getIcone());%>">
                                </td>
                                <td>
                                    <a class="button" href="form_alterar_menu.jsp?id=<%out.print(menu.getId());%>"><img width='16' height='16' src="imagens/edit.png"></a>
                                    <a class="button" href="#" onclick="confirma(<%out.print(menu.getId());%>)" ><img width='16' height='16' src="imagens/delete.png"></a>
                                </td>
                            </tr>

                            <% }

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
    Usuario userPermission = new Usuario();
    if(!userPermission.temPermissao(request.getRequestURI(),request.getContextPath(), user)){
       response.sendRedirect("index.jsp?erro=1");
    }else{
    session.setAttribute("menu",true);
    }
    }

%>
    </body>
</html>
