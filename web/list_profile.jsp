<%-- 
    Document   : list_profile
    Author     : André
--%>


<%@page import="modelo.UsuarioDAO"%>
<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de perfis</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript" language="JavaScript">
            function verify(id){
                var url="delete_profile.do?id="+id;
                var answer=confirm("Tem certeza que deseja excluir?\nclique em ok para confirmar ou em cancelar para desistir");
                if(answer){
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
                                <td align="left" ><h1>Lista de Perfis</h1></td>
                                <td align="right" ><a class="button" href="insert_profile_form.jsp">Inserir Perfil</a></td>
                            </tr>
                        </table>
                        <table class="" align="center" >
                            <tr>
                                <td>Id</td>
                                <td>Perfil</td>
                                <td>Opções</td>
                            </tr>


                            <%

                                        try {
                                            PerfilDAO profileDB = new PerfilDAO();

                                            profileDB.conectar();

                                            ArrayList<Perfil> profileList = profileDB.select();

                                            for(Perfil profile:profileList){%>

                            <tr>
                                <td>
                                    <%out.print(profile.getId());%>
                                </td>
                                <td>
                                    <%out.print(profile.getPerfil());%>
                                </td>
                                <td>
                                    <a class="button" href="manage_profile_menu_form.jsp?id=<%out.print(profile.getId());%>"><img width='16' height='16' src="imagens/gerenciar.png"></a>
                                    <a class="button" href="update_profile_form.jsp?id=<%out.print(profile.getId());%>&profile=<%out.print(profile.getPerfil());%>"><img width='16' height='16' src="imagens/edit.png"></a>
                                    <a class="button" href="#" onclick="verify(<%out.print(profile.getId());%>)"><img width='16' height='16' src="imagens/delete.png"></a>
                                </td>
                            </tr>

                            <% }


                                        } catch (Exception e) {
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
    User userPermission = new User();
    if(!userPermission.temPermissao(request.getRequestURI(),request.getContextPath(), userLogged)){
       response.sendRedirect("index.jsp?erro=1");
    }else{
    session.setAttribute("profile",true);
    }
    }

%>
    </body>
</html>
