<%-- 
    Document   : insert_user_form
    Author     : André
--%>

<%@page import="modelo.Profile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulátio de Insersão - Usuário</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript">
            function validateForm(){

            var insert_user_form=document.insert_user_form;
                var field_name=insert_user_form.name;
                var field_id_profile=insert_user_form.id_profile;
                var field_login=insert_user_form.login;
                var field_password=insert_user_form.password;

                if(field_name.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_name.focus();
                    return false;
                }
                if(field_id_profile.value=="0"){
                    alert("Todos os campos devem ser preenchidos!");
                    field_id_profile.focus();
                    return false;
                }
                if(field_login.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_login.focus();
                    return false;
                }
                if(field_password.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_password.focus();
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
                                <td align="center" ><h1>Inserir Usuário</h1></td>
                            </tr>
                        </table>
                        <form name="insert_user_form" action="insert_user.do" method="POST" onsubmit="return validateForm()" >
                        <table align="center" width="300">
                            
                                <%

                                            try {
                                                PerfilDAO profileDB = new PerfilDAO();
                                                profileDB.conectar();
                                                ArrayList<Profile> profileList = profileDB.select();

                                %>

                                <tr>
                                    <td>Nome:</td>
                                    <td><input type="text" size="45" name="name"/> </td>
                                </tr>
                                <tr>
                                    <td>
                                        Profile:
                                    </td>
                                    <td><select name="id_profile" size="1">
                                            <option value="0">
                                                Selecione um profile
                                            </option>

                                            <%for (Profile profile : profileList) {%>

                                            <option value="<%=profile.getId()%>">
                                                <%=profile.getPerfil()%>
                                            </option>
                                            <%}%>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Login:</td>
                                    <td><input type="text" size="45" name="login"/> </td>
                                </tr>
                                <tr>
                                    <td>Senha:</td>
                                    <td><input type="password" size="45" name="password"/> </td>
                                </tr>

                                <tr>
                                    <td></td>
                                    <td><input class="button" type="submit" value="Inserir"/> </td>
                                </tr>
                            
                        </table>
                        </form>
                        <%
                                        profileDB.desconectar();
                                    } catch (Exception e) {
                                        out.println(e);

                                    }


                        %>
                    </td>
                </tr>
            </table>
        </div>
                    <div class="footer">
            </div>
                        </div>
<%

    if(logged){
    if(session.getAttribute("user") == null){
       response.sendRedirect("index.jsp?erro=1");
    }
    }

%>
    </body>
</html>
