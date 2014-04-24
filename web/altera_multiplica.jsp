<%-- 
    Document   : altera_multiplica
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
    
       int linesA=0,columnsA=0,columnsB=0;
        
        if(session.getAttribute("data_multiply_linesA") != null){
                linesA = (Integer)session.getAttribute("data_multiply_linesA");
        }
        if(session.getAttribute("data_multiply_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_multiply_columnsA");
        }
        if(session.getAttribute("data_multiply_columnsB") != null){
                columnsB = (Integer)session.getAttribute("data_multiply_columnsB");
        }


    %>
    <body class="centertable" onload="refreshPage('matrixes', 'altera_matrizes_dinamicas.jsp?operation=multiply&linesA=<%=linesA%>&columnsA=<%=columnsA%>&linesB=<%=columnsA%>&columnsB=<%=columnsB%>');">
        <%@include file="menu.jsp" %>
        <form action="multiply_matrices.do" method="POST" name="multiply_matrices">
        Linhas de A <input type="text" name="linesA" value="<%=linesA%>" id="linesA" onkeyup="refreshPage('matrixes', 'altera_matrizes_dinamicas.jsp?operation=multiply&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        Colunas de A e linhas de B <input type="text" value="<%=columnsA%>"  name="columnsA" id="columnsA" onkeyup="refreshPage('matrixes', 'altera_matrizes_dinamicas.jsp?operation=multiply&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        Colunas de B <input type="text" name="linesB" value="<%=columnsB%>"  id="linesB" onkeyup="refreshPage('matrixes', 'altera_matrizes_dinamicas.jsp?operation=multiply&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
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

