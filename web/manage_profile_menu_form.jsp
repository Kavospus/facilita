<%-- 
    Document   : manage_profile_menu_form
    Author     : André
--%>

<%@page import="modelo.Menu"%>
<%@page import="modelo.MenuDAO"%>
<%@page import="modelo.Profile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ProfileDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulátio de Gerenciamento de Menu-Profile</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript" language="JavaScript">
            function verify(id_menu,id_profile,operation){
                var url="manage_profile_menu.do?id_menu="+id_menu+"&id_profile="+id_profile+"&operation="+operation;
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
                        <table  align="center" >
                            <tr>
                                <td align="left" ><h1>Vincular Menus</h1></td>
                            </tr>
                        </table>
                        <form name="form_gerenciar_menu" action="manage_profile_menu.do">

                            <%
                            
                                        try {
                                            int id_profile = Integer.parseInt(request.getParameter("id"));
                                            MenuDAO menuDB = new MenuDAO();
                                            menuDB.connect();
                                            ArrayList<Menu> menuListA = menuDB.menusNaoPerfil(id_profile);
                                            ArrayList<Menu> menuListB = menuDB.menusPerfil(id_profile);
                                            ProfileDAO profileDB = new ProfileDAO();

                                            profileDB.connect();

                                            Profile profile = profileDB.selectById(id_profile);

                                            %>
                                            <table align="center">
                                                <tr>
                                                    <td>
                                                        ID: <%=profile.getId()%>
                                                    </td>
                                                    <td>
                                                        Profile: <%=profile.getProfile()%>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                    Menu:
                                                    </td>
                                                    <td><select name="id_menu" size="1">
                                                    <option value="0">
                                                        Selecione um menu
                                                    </option>

                                                    <%for(Menu m1:menuListA){%>

                                                    <option value="<%=m1.getId()%>">
                                                        <%=m1.getMenu()%>
                                                    </option>
                                                    <%}%>
                                                </select>
                                                    </td>
                                                    <td>
                                                        <input type="text" hidden="true" value="<%=profile.getId()%>" name="id_profile">
                                                        <input type="text" hidden="true" value="1" name="operation">
                                                        <input class="button" type="submit" value="Vincular">
                                                    </td>
                                                </tr>


                                            </table>
                                          </form>
                            <table  align="center" >
                            <tr>
                                <td align="left" ><h1>Menus Vinculados</h1></td>
                            </tr>
                        </table>
                            <table class="" align="center" >
                            <tr>
                                <td>Id</td>
                                <td>Menu</td>
                                <td>Desvincular</td>
                            </tr>

                            <% for(Menu menu:menuListB){%>

                            <tr>
                                <td>
                                    <%out.print(menu.getId());%>
                                </td>
                                <td>
                                    <%out.print(menu.getMenu());%>
                                </td>
                                <td align="center">
                                    <a href="#" class="button" onclick="verify(<%out.print(menu.getId());%>,<%out.print(profile.getId());%>,2)"><img src="imagens/delete.png"></a>
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
    if(session.getAttribute("profile") == null){
       response.sendRedirect("index.jsp?erro=1");
    }
    }

%>
    </body>
</html>

