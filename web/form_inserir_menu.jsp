<%-- 
    Document   : form_inserir_menu
    Author     : André
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Insersão - Menus</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script language="javascript" >
            function validateForm(){

                var form_inserir_menu=document.form_inserir_menu;
                var field_menu=form_inserir_menu.menu;
                var field_icon=form_inserir_menu.icon;
                var field_link=form_inserir_menu.link;


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
                                <td align="left" ><h1>Novo Menu</h1></td>
                            </tr>
                        </table>
                        <form name="form_inserir_menu" action="insert_menu.do" method="POST" onsubmit="return validateForm()">
                        <table align="center" >
                                <tr>
                                    <td>Nome:</td>
                                    <td><input type="text" size="45" name="menu"/> </td>
                                </tr>
                                <tr>
                                    <td>Icone URL:</td>
                                    <td><input type="text" size="45" name="icon" onblur="refreshPage('thumb','thumb.jsp?link='+this.value)"/> </td>
                                    <td><div align="center" id="thumb"></div></td>
                                </tr>
                                <tr>
                                    <td>Link:</td>
                                    <td><input type="text" size="45" name="link"/> </td>
                                </tr>
                                
                                <tr>
                                    <td></td>
                                    <td><input class="button" type="submit" value="inserir"/> </td>
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