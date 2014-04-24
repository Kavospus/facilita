<%-- 
    Document   : form_inserir_usuario
    Author     : André
--%>

<%@page import="modelo.Perfil"%>
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
            function validaForm(){

            var form_inserir_usuario=document.form_inserir_usuario;
                var campo_nome=form_inserir_usuario.nome;
                var campo_id_perfil=form_inserir_usuario.id_perfil;
                var campo_login=form_inserir_usuario.login;
                var campo_senha=form_inserir_usuario.senha;

                if(campo_nome.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    campo_nome.focus();
                    return false;
                }
                if(campo_id_perfil.value=="0"){
                    alert("Todos os campos devem ser preenchidos!");
                    campo_id_perfil.focus();
                    return false;
                }
                if(campo_login.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    campo_login.focus();
                    return false;
                }
                if(campo_senha.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    campo_senha.focus();
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
                        <form name="form_inserir_usuario" action="inserir_usuario.do" method="POST" onsubmit="return validaForm()" >
                        <table align="center" width="300">
                            
                                <%

                                            try {
                                                PerfilDAO profileDB = new PerfilDAO();
                                                profileDB.conectar();
                                                ArrayList<Perfil> lista = profileDB.listar();

                                %>

                                <tr>
                                    <td>Nome:</td>
                                    <td><input type="text" size="45" name="nome"/> </td>
                                </tr>
                                <tr>
                                    <td>
                                        Perfil:
                                    </td>
                                    <td><select name="id_perfil" size="1">
                                            <option value="0">
                                                Selecione um profile
                                            </option>

                                            <%for (Perfil profile : lista) {%>

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
                                    <td><input type="password" size="45" name="senha"/> </td>
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
