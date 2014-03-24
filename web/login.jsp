<%-- 
    Document   : login
    Author     : André
--%>

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
        <div class="selfcontainer loginBox" align="center" >
            <form action="efetuar_login.do" method="POST">
                <div class="content">
                    <table align="center" class="box ui-corner-all" >
                        <tr >
                            <td>Usuário: </td>
                            <td><input type="text" name="user"/></td>
                        </tr>
                        <tr>
                            <td>Senha: </td>
                            <td><input type="password" name="pass"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="button" type="submit" value="Login" </td>
                        </tr>

                    </table>
                </div>
            </form>
            <div class="footer filled">
                
                <a href="form_cadastrar_usuario.jsp">Cadastre-se</a>  <a href="efetuar_login_convidado.do">Entrar como Convidado</a>
            </div>
        </div>
    </body>
</html>
