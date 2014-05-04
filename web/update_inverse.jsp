<%-- 
    Document   : update_inverse
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
    <body class="centertable" onload="refreshPage('matrixes', 'dynamic_update_matrix.jsp?operation=inverse&linesA=<%=linesA%>&columnsA=<%=linesA%>');">
        <%@include file="menu.jsp" %>
        <form action="invert_matrix.do" method="POST" name="invert_matrix">
        <%=_("Lines",bundle)%> <%=_("and",bundle)%> <%=_("Columns",bundle)%> <input type="text" name="linesA" id="linesA" value="<%=linesA%>" onkeyup="refreshPage('matrixes', 'dynamic_update_matrix.jsp?operation=inverse&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('linesA').value)" />
        
        
        <div id="matrixes" ></div>
        <input class="button"type="submit" value="<%=_("Calculate",bundle)%>"/>
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
       response.sendRedirect("index.jsp?error=1");
    }
    }

%>
    </body>
</html>
