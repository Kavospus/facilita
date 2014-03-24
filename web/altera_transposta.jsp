<%-- 
    Document   : altera_transposta
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
        
        if(session.getAttribute("dados_transposta_dima") != null){
                dima = (Integer)session.getAttribute("dados_transposta_dima");
        }
        if(session.getAttribute("dados_transposta_dimb") != null){
                dimb = (Integer)session.getAttribute("dados_transposta_dimb");
        }
    %>
    <body class="centertable" onload="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=transposta&dima=<%=dima%>&dimb=<%=dimb%>');">
        <%@include file="menu.jsp" %>
        <form action="transpor_matriz.do" method="POST" name="transpoe_matriz">
        Linhas<input type="text" name="dima" id="dima" value="<%=dima%>" onkeyup="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=transposta&dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value)" />
        Colunas<input type="text" name="dimb" id="dimb" value="<%=dimb%>" onkeyup="refreshPage('matrizes', 'altera_matriz_dinamica.jsp?op=transposta&dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value)" />
        
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
