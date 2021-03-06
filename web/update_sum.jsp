<%-- 
    Document   : update_sum
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
        
        if(session.getAttribute("data_sum_linesA") != null){
                linesA = (Integer)session.getAttribute("data_sum_linesA");
        }
        if(session.getAttribute("data_sum_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_sum_columnsA");
        }


    %>
    <body class="centertable" onload="refreshPage('matrixes', 'dynamic_update_matrices.jsp?operation=sum&linesA=<%=linesA%>&columnsA=<%=columnsA%>&linesB=<%=linesA%>&columnsB=<%=columnsA%>');">
        <%@include file="menu.jsp" %>
        <form action="sum_matrices.do" method="POST" name="sum_matrices">
        <%=_("Lines",bundle)+" "+_("of",bundle)%> A <%=_("and",bundle)%> B <input type="text" name="linesA" value="<%=linesA%>" id="linesA" onkeyup="refreshPage('matrixes', 'dynamic_update_matrices.jsp?operation=sum&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('linesA').value+'&columnsB='+getElementById('columnsA').value)" />
        <%=_("Columns",bundle)+" "+_("of",bundle)%> A <%=_("and",bundle)%> B <input type="text" value="<%=columnsA%>"  name="columnsA" id="columnsA" onkeyup="refreshPage('matrixes', 'dynamic_update_matrices.jsp?operation=sum&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('linesA').value+'&columnsB='+getElementById('columnsA').value)" />
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