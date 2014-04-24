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
    
       int linesA=0,columnsA=0;
        String operation = "";
        if(request.getParameter("operation") != null){
                operation = request.getParameter("operation");
            }
        if(session.getAttribute("result_"+operation+"_linesA") != null){
                linesA = (Integer)session.getAttribute("result_"+operation+"_linesA");
        }
        if(session.getAttribute("result_"+operation+"_columnsA") != null){
                columnsA = (Integer)session.getAttribute("result_"+operation+"_columnsA");
        }


    %>
    <body class="centertable" onload="refreshPage('matrixes', 'resposta_matrizes_dinamicas.jsp?operation=<%=operation%>&linesA=<%=linesA%>&columnsA=<%=columnsA%>&linesB=<%=linesA%>&columnsB=<%=columnsA%>');">
        <%@include file="menu.jsp" %>
        <form action="multiplicar_matrizes.do" method="POST" name="multiplica_matrizes">
        Linhas de A <input type="text" name="linesA" readonly="true" value="<%=linesA%>" id="linesA"  />
        Colunas de A e Linhas de B <input type="text" value="<%=columnsA%>" readonly="true"   name="columnsA" id="columnsA" />
        Colunas de B <input type="text" name="linesB" value="2" id="linesB" onkeyup="refreshPage('matrixes', 'resposta_matrizes_dinamicas.jsp?operation=<%=operation%>&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        <div id="matrixes" ></div>
        <input class="button"type="submit" name="OK"/>
        </form>
    </body>
</html>