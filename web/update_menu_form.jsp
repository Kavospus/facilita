<%-- 
    Document   : update_menu_form
    Author     : André
--%>
<%@page import="modelo.Profile"%>
<%@page import="modelo.MenuDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Alteração - Menus</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script language="javascript" >
            function validateForm(){

                var update_menu_form=document.update_menu_form;
                var field_menu=update_menu_form.menu;
                var field_icon=update_menu_form.icon;
                var field_link=update_menu_form.link;


                if(field_menu.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_menu.focus();
                    return false;
                }
                if(field_icon.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_icon.focus();
                    return false;
                }
                if(field_link.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_link.focus();
                    return false;
                }
                return true;
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
                    <td class="" valign="top">
                        <table  align="center" >
                            <tr>
                                <td align="left" ><h1>Alterar Menu</h1></td>
                            </tr>
                        </table>
                        <form name="update_menu_form" action="update_menu.do" method="POST" onsubmit="return validateForm()">
                            <table width="500" align="center">
                                <%
                                    int id = 0;
                                    Menu menu = null;

                                        try {

                                        if (request.getParameter("id") != null) {
                                        id = Integer.parseInt(request.getParameter("id"));
                                        }

                                        MenuDAO menuDB = new MenuDAO();

                                        menuDB.conectar();
                                        menu = menuDB.selectById(id);
                                        menuDB.desconectar();
                                            
                                        } catch(SQLException e){

                                        out.println(e);

                                        }

                        %>
                                <tr>
                                    <td>Id:</td>
                                    <td><input readonly type="text" size="10" name="id" value="<%=menu.getId() %>" /> </td>
                                </tr>
                                <tr>
                                    <td>Menu:</td>
                                    <td><input type="text" size="45" name="menu" value="<%=menu.getMenu() %>" /> </td>
                                </tr>
                                <tr>
                                    <td>Icone URL:</td>
                                    <td><input type="text" size="45" name="icon" value="<%=menu.getIcone() %>" onblur="refreshPage('thumb','thumb.jsp?link='+this.value)" /> </td>
                                    <td ><div align="rigth" id="thumb"><img width="32" height="32" src="<%=menu.getIcone()%>"/></div></td>
                                </tr>
                                <tr>
                                    <td>Link:</td>
                                    <td><input type="text" size="45" name="link" value="<%=menu.getLink() %>" /> </td>
                                </tr>

                                <tr>
                                    <td></td>
                                    <td><input class="button" type="submit" value="Alterar"/> </td>
                                </tr>
                            </table>

                        </form>
                    </td>
                </tr>
            </table>
        </div>
                                <div class="footer">
            </div>
    </div>
<%

    if(logged){
    if(session.getAttribute("menu") == null){
       response.sendRedirect("index.jsp?erro=1");
    }
    }

%>
    </body>
</html>
