<%-- 
    Document   : index
    Author     : andrebsguedes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>JSP Page</title>
    </head>
    <body onload="erro()"class="fill">
        <div class="selfcontainer">
            <div id="titulo" class="centerimage">
            <img src="imagens/facilita.png">
        </div>
            <%@include file="menu.jsp" %>
        
        <div id="container" class="container centralize">
            <div id="operacoes" class="centro">
            <a class="button" href="recieve_least_squares.jsp"><%=_("Least Squares",bundle)%></a>
            <a class="button"  href="recieve_multiply.jsp"><%=_("Multiply",bundle)%></a>
            <a class="button"  href="recieve_determinant.jsp"><%=_("Determinant",bundle)%></a>
            <a class="button"  href="recieve_scalar.jsp"><%=_("Scalar",bundle)%></a>
            <a class="button"  href="recieve_inverse.jsp"><%=_("Invert",bundle)%></a>
            <a class="button"  href="recieve_sum.jsp"><%=_("Sum",bundle)%></a>
            <a class="button"  href="recieve_subtract.jsp"><%=_("Subtract",bundle)%></a>
            <a class="button"  href="recieve_transposed.jsp"><%=_("Transpose",bundle)%></a>
            </div>
        </div>
        </div>
            <%
                        try{
                        if(request.getParameter("error").equalsIgnoreCase("1")){
                            out.print("<script language='JavaScript'>");
                            out.print("function erro(){");
                            out.print("alert('"+_("no permission", bundle) +"!');}");
                            out.print("</script>");
                        }
                        }catch (Exception e){
                        }
             %>
    </body>

</html>
