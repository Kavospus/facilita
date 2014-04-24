<%-- 
    Document   : listar_calculo
    Author     : Andre
--%>

<%@page import="modelo.Calculo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.CalculoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Calculo</title>
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <script type="text/javascript" language="JavaScript">
            function verify(id){
                var url="excluir_calculo.do?id="+id;
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
                                <td>Calculo</td>
                                <td>Entrada</td>
                                <td>Opções</td>
                            </tr>


                            <%

                                        try {
                                            user = (Usuario)session.getAttribute("userLogged");
                                            CalculoDAO calculusDB = new CalculoDAO();

                                            calculusDB.conectar();

                                            ArrayList<Calculo> lista = calculusDB.listar(userLogged);

                                            for(Calculo calculus:lista){%>

                            <tr>
                                <td>
                                    <%out.print(calculus.getId());%>
                                </td>
                                <td>
                                    <%out.print(calculus.getOperacao());%>
                                </td>
                                <td>
                                    <%out.print(calculus.getStringEntrada());%>
                                </td>
                                <td>
                                    <a class="button" href="carregar_calculo.do?id=<%out.print(calculus.getId());%>"><img width='16' height='16' src="imagens/edit.png"></a>
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
    Usuario userPermission = new Usuario();
    if(!userPermission.temPermissao(request.getRequestURI(),request.getContextPath(), userLogged)){
       response.sendRedirect("index.jsp?erro=1");
    }else{
    session.setAttribute("calculus",true);
    }
    }
%>
    </body>
</html>
