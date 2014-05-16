<%-- 
    Document   : insert_profile_form
    Author     : André
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Insersão - Perfis</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script language="javascript" >
            function validateForm(){

                var insert_profile_form=document.insert_profile_form;
                var field_profile=insert_profile_form.profile;

                if(field_profile.value==""){
                    alert("Todos os campos devem ser preenchidos!");
                    field_profile.focus();
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
                    <td class="filled" valign="top">
                        <table  align="center" >
                            <tr>
                                <td align="left" ><h1><%=_("New",bundle)%> <%=_("Profile",bundle)%></h1></td>
                            </tr>
                        </table>
                        <form name="insert_profile_form" action="insert_profile.do" method="GET" onsubmit="return validateForm()">
                            <table align="center">
                                <tr>
                                    <td><%=_("Profile",bundle)%>:</td>
                                    <td><input type="text" size="45" name="profile"/> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input class="button" type="submit" value="<%=_("Insert",bundle)%>"/> </td>
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
    if(session.getAttribute("profile") == null){
       response.sendRedirect("index.jsp?error=1");
    }
    }

%>


    </body>
</html>
