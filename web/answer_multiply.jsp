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
    <body class="centertable" onload="refreshPage('matrixes', 'dynamic_answer_matrices.jsp?operation=<%=operation%>&linesA=<%=linesA%>&columnsA=<%=columnsA%>&linesB=<%=linesA%>&columnsB=<%=columnsA%>');">
        <%@include file="menu.jsp" %>
        <form action="multiply_matrices.do" method="POST" name="multiply_matrices">
        <%=_("Lines",bundle)+" "+_("of",bundle)%> A <input type="text" name="linesA" readonly="true" value="<%=linesA%>" id="linesA"  />
        <%=_("Columns",bundle)+" "+_("of",bundle)%> A <%=_("and",bundle)%> <%=_("Lines",bundle)+" "+_("of",bundle)%> B <input type="text" value="<%=columnsA%>" readonly="true"   name="columnsA" id="columnsA" />
        <%=_("Columns",bundle)+" "+_("of",bundle)%> B <input type="text" name="linesB" value="2" id="linesB" onkeyup="refreshPage('matrixes', 'dynamic_answer_matrices.jsp?operation=<%=operation%>&linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        <div id="matrixes" ></div>
        <input class="button"type="submit" value="<%=_("Calculate",bundle)%>"/>
        </form>
    </body>
</html>