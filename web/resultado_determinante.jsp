<%-- 
    Document   : resultado_determinante
    Author     : Andre
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
    <body class="centertable">
        <%@include file="menu.jsp" %>
        <%
        int i, j,dima=0,dimb=0;
        
        if(session.getAttribute("dados_determinante_dima") != null){
                dima = (Integer)session.getAttribute("dados_determinante_dima");
        }
        if(session.getAttribute("dados_determinante_dimb") != null){
                dimb = (Integer)session.getAttribute("dados_determinante_dimb");
        }

        double a[][] = new double[dima][dimb];
        double resultado = 0;
        if(session.getAttribute("resultado_determinante") != null){
                resultado = (Double)session.getAttribute("resultado_determinante");
            }
        if(session.getAttribute("dados_determinante_a") != null){
                a = (double[][])session.getAttribute("dados_determinante_a");
            }
        out.print("Resultado do Determinante: "+resultado);
        %>
        <a href="index.jsp">Voltar</a>
        <a href="resposta_determinante_escalar.jsp">Escalar</a>

    </body>
</html>
