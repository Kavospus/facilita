<%-- 
    Document   : login
    Author     : André
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <title>Login</title>
    </head>
    <body>
<%
session.setAttribute("user_locale", request.getLocale());
ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", request.getLocale());
%>
        <div class="selfcontainer loginBox" align="center" >
            <form action="do_login.do" method="POST">
                <div class="content">
                    <table align="center" class="box ui-corner-all" >
                        <tr >
                            <td><%=bundle.getString("User")%>: </td>
                            <td><input type="text" name="user"/></td>
                        </tr>
                        <tr>
                            <td><%=bundle.getString("Password")%>: </td>
                            <td><input type="password" name="pass"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="button" type="submit" value="<%=bundle.getString("Login")%>" </td>
                        </tr>

                    </table>
                </div>
            </form>
            <div class="footer filled">
                
                <a href="register_user_form.jsp"><%=bundle.getString("Register")%></a>  <a href="do_guest_login.do"><%=bundle.getString("Login as Guest")%></a>
            </div>
        </div>
    </body>
</html>
