<%@page import="modelo.Menu"%>
<%@page import="modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="centertable" >
    <tr>
<%
boolean logged = false;
User userLogged = null;
try{

    userLogged = (User) session.getAttribute("userLogged");
    out.print("<td>Bem Vindo "+userLogged.getName()+"</td>");
    for(Menu mp:userLogged.getProfile().getMenus()){

    out.print("<td >"
            + "<a class='button' href='"+mp.getLink()+"'><div align='justify' class=\"minButtonWidth\">"
            + "<img width='10' height='10' src='"+mp.getIcone()+"'>   "+mp.getMenu()+"</div></a></td>" );
    }

    out.print("<td><a class='button' href='exit.jsp'>Sair</a></td>");

    logged = true;

}catch(Exception e){
response.sendRedirect("login.jsp");
}

%>
    </tr>
</table>
