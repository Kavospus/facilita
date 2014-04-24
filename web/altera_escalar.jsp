<%-- 
    Document   : altera_determinante
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
    
       int linesA=0,columnsA=0;
       double n=0;
        
       if(session.getAttribute("dados_escalar_n") != null){
                n = (Double)session.getAttribute("dados_escalar_n");
       }
       if(session.getAttribute("dados_escalar_linesA") != null){
                linesA = (Integer)session.getAttribute("dados_escalar_linesA");
       }
       if(session.getAttribute("dados_escalar_columnsA") != null){
                columnsA = (Integer)session.getAttribute("dados_escalar_columnsA");
       }


    %>
    <body class="centertable" onload="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=escalar&linesA=<%=linesA%>&columnsA=<%=columnsA%>');">
        <%@include file="menu.jsp" %>
        <form action="escalar_matriz.do" method="POST" name="escalar_matriz">
        Escalar <input type="text" name="n" value="<%=n%>" id="n"/>
        Linhas <input type="text" name="linesA" value="<%=linesA%>" id="linesA" onkeyup="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=escalar&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value)" />
        Colunas <input type="text" value="<%=columnsA%>"  name="columnsA" id="columnsA" onkeyup="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=escalar&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value)" />
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
    if(session.getAttribute("calculus") == null){
       response.sendRedirect("index.jsp?erro=1");
    }
    }

%>
    </body>
</html>

