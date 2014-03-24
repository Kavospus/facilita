<%-- 
    Document   : altera_soma
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
        <script type="text/javascript" src="js/ajax.js"></script>
        <title>JSP Page</title>
    </head>
    <%
    
       int dima=0,dimb=0;
        String op = "";
        if(request.getParameter("op") != null){
                op = request.getParameter("op");
            }
        if(session.getAttribute("resultado_"+op+"_dima") != null){
                dima = (Integer)session.getAttribute("resultado_"+op+"_dima");
        }
        if(session.getAttribute("resultado_"+op+"_dimb") != null){
                dimb = (Integer)session.getAttribute("resultado_"+op+"_dimb");
        }


    %>
    <body class="centertable" onload="refreshPage('matrizes', 'resposta_matrizes_dinamicas.jsp?op=<%=op%>&dima=<%=dima%>&dimb=<%=dimb%>&dimc=<%=dima%>&dimd=<%=dimb%>');">
        <%@include file="menu.jsp" %>
        <form action="somar_matrizes.do" method="POST" name="soma_matrizes">
            Linhas de A e B <input type="text" name="dima" readonly="true" value="<%=dima%>" id="dima"  />
        Colunas de A e B <input type="text" value="<%=dimb%>" readonly="true"   name="dimb" id="dimb" />
        <div id="matrizes" ></div>
        <input class="button"type="submit" name="OK"/>
        </form>
    </body>
</html>