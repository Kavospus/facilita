<%-- 
    Document   : list_calculus
    Author     : Andre
--%>

<%@page import="modelo.Calculus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.CalculusDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Calculus</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript" language="JavaScript">
            function verify(id){
                var url="delete_calculus.do?id="+id;
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
                                <td align="center" ><h1>Lista de Calculos</h1></td>
                            </tr>
                        </table>
                        <table width="700" align="center" >
                            <tr>
                                <td>Id</td>
                                <td>Calculus</td>
                                <td>Entrada</td>
                                <td>Opções</td>
                            </tr>


                            <%

                                        try {
                                            User user = (User)session.getAttribute("userLogged");
                                            CalculusDAO calculusDB = new CalculusDAO();

                                            calculusDB.connect();

                                            ArrayList<Calculus> calculusList = calculusDB.select(user);

                                            for(Calculus calculus:calculusList){%>

                            <tr>
                                <td>
                                    <%out.print(calculus.getId());%>
                                </td>
                                <td>
                                    <%out.print(calculus.getOperation());%>
                                </td>
                                <td>
                                    <%out.print(calculus.getInputString());%>
                                </td>
                                <td>
                                    <a class="button" href="load_calculus.do?id=<%out.print(calculus.getId());%>"><img width='16' height='16' src="imagens/edit.png"></a>
                                    <a class="button" href="#" onclick="verify(<%out.print(calculus.getId());%>)"><img width='16' height='16' src="imagens/delete.png"></a>
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
    if(!userPermission.havePermission(request.getRequestURI(),request.getContextPath(), userLogged)){
       response.sendRedirect("index.jsp?erro=1");
    }else{
    session.setAttribute("calculus",true);
    }
    }
%>
    </body>
</html>
