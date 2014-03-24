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
    
       int dima=0,dimb=0,dimd=0;
        
        if(session.getAttribute("dados_multiplica_dima") != null){
                dima = (Integer)session.getAttribute("dados_multiplica_dima");
        }
        if(session.getAttribute("dados_multiplica_dimb") != null){
                dimb = (Integer)session.getAttribute("dados_multiplica_dimb");
        }
        if(session.getAttribute("dados_multiplica_dimd") != null){
                dimd = (Integer)session.getAttribute("dados_multiplica_dimd");
        }


    %>
    <body class="centertable" onload="refreshPage('matrizes', 'altera_matrizes_dinamicas.jsp?op=multiplica&dima=<%=dima%>&dimb=<%=dimb%>&dimc=<%=dimb%>&dimd=<%=dimd%>');">
        <%@include file="menu.jsp" %>
        <form action="multiplicar_matrizes.do" method="POST" name="multiplica_matrizes">
        Linhas de A <input type="text" name="dima" value="<%=dima%>" id="dima" onkeyup="refreshPage('matrizes', 'altera_matrizes_dinamicas.jsp?op=multiplica&dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value+'&dimc='+getElementById('dimb').value+'&dimd='+getElementById('dimc').value)" />
        Colunas de A e linhas de B <input type="text" value="<%=dimb%>"  name="dimb" id="dimb" onkeyup="refreshPage('matrizes', 'altera_matrizes_dinamicas.jsp?op=multiplica&dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value+'&dimc='+getElementById('dimb').value+'&dimd='+getElementById('dimc').value)" />
        Colunas de B <input type="text" name="dimc" value="<%=dimd%>"  id="dimc" onkeyup="refreshPage('matrizes', 'altera_matrizes_dinamicas.jsp?op=multiplica&dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value+'&dimc='+getElementById('dimb').value+'&dimd='+getElementById('dimc').value)" />
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

