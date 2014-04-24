<%-- 
    Document   : altera_inversa
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
    <%
    
        int i, j,linesA=0,columnsA=0;
        
        if(session.getAttribute("data_inverse_linesA") != null){
                linesA = (Integer)session.getAttribute("data_inverse_linesA");
        }
    %>
    <body class="centertable" onload="refreshPage('matrixes', 'altera_matriz_dinamica.jsp?operation=inverse&linesA=<%=linesA%>&columnsA=<%=linesA%>');">
        <%@include file="menu.jsp" %>
        <form action="inverter_matriz.do" method="POST" name="inverte_matriz">
        Linhas e Colunas <input type="text" name="linesA" id="linesA" value="<%=linesA%>" onkeyup="refreshPage('matrixes', 'altera_matriz_dinamica.jsp?operation=inverse&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('linesA').value)" />
        
        
        <div id="matrixes" ></div>
        <input class="button"type="submit" name="OK"/>
        <%
        if(request.getParameter("id")!=null){
        int id  = Integer.parseInt(request.getParameter("id"));
        %>
        <input type="text" hidden="true" name="id" value="<%=id%>"> 
        <%
        }
        %>
        
        </form>
                <%

    if(logged){
    if(session.getAttribute("calculus") == null){
       response.sendRedirect("index.jsp?erro=1");
    }
    }

%>
    </body>
</html>
