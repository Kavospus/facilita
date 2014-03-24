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
    
        int i, j,dima=0,dimb=0;
        
        if(session.getAttribute("dados_inversa_dima") != null){
                dima = (Integer)session.getAttribute("dados_inversa_dima");
        }
    %>
    <body class="centertable" onload="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=inversa&dima=<%=dima%>&dimb=<%=dima%>');">
        <%@include file="menu.jsp" %>
        <form action="inverter_matriz.do" method="POST" name="inverte_matriz">
        Linhas e Colunas <input type="text" name="dima" id="dima" value="<%=dima%>" onkeyup="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=inversa&dima='+getElementById('dima').value+'&dimb='+getElementById('dima').value)" />
        
        
        <div id="matrizes" ></div>
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
    if(session.getAttribute("calculo") == null){
       response.sendRedirect("index.jsp?erro=1");
    }
    }

%>
    </body>
</html>
