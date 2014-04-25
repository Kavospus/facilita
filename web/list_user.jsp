<%-- 
    Document   : list_menu
    Author     : André
--%>

<%@page import="modelo.UserDAO"%>
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
            function verify(id){
                var url="delete_user.do?id="+id;
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
                                <td align="right" ><a class="button" href="insert_user_form.jsp">Inserir Usuário</a></td>
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
                                UserDAO userDB = new UserDAO();
                                userDB.connect();
                                ArrayList<User> userList = userDB.select();
                            for(User user:userList){%>

                            <tr>
                                <td>
                                    <%=user.getId()%>
                                </td>
                                <td>
                                    <%=user.getNome()%>
                                </td>
                                <td>
                                    <%=user.getLogin()%>
                                </td>
                                <td>
                                    <%=user.getSenha()%>
                                </td>
                                <td>
                                    <a class="button" href="update_user_form.jsp?id=<%=user.getId()%>"><img width='16' height='16' src="imagens/edit.png"></a>
                                    <a class="button" href="#" onclick="verify(<%=user.getId()%>)" ><img width='16' height='16' src="imagens/delete.png"></a>
                                </td>
                            </tr>

                            <% }
                            userDB.disconnect();
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
    User uP = new User();
    if(!uP.temPermissao(request.getRequestURI(),request.getContextPath(), userLogged)){
       response.sendRedirect("index.jsp?error=1");
    }else{
    session.setAttribute("user",true);
    }
    }

%>
    </body>
</html>
