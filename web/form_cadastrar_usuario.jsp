<%-- 
    Document   : cadastar_usuario
    Author     : Andre
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulátio de Cadastro - Usuário</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript">
            function validateForm(){

            var form_inserir_usuario=document.form_inserir_usuario;
                var field_name=form_inserir_usuario.name;
                var field_login=form_inserir_usuario.login;
                var field_password=form_inserir_usuario.password;

                if(field_name.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_name.focus();
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
                        <form name="form_inserir_usuario" action="cadastrar_usuario.do" method="POST" onsubmit="return validateForm()" >
                        <table align="center" width="300">
                            

                                <tr>
                                    <td>Nome:</td>
                                    <td><input type="text" size="45" name="name"/> </td>
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
                                    <td><a href="login.jsp">Voltar</a></td>
                                    <td><input class="button" type="submit" value="Cadastrar"/> </td>
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
    </body>
</html>