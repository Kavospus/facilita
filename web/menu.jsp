<%@page import="modelo.Menu"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="centertable" >
    <tr>
<%
boolean logged = false;
Usuario user = null;
try{

    user = (Usuario) session.getAttribute("user");
    out.print("<td>Bem Vindo "+user.getNome()+"</td>");
    for(Menu mp:user.getPerfil().getMenus()){

    out.print("<td >"
            + "<a class='button' href='"+mp.getLink()+"'><div align='justify' class=\"minButtonWidth\">"
            + "<img width='10' height='10' src='"+mp.getIcone()+"'>   "+mp.getMenu()+"</div></a></td>" );
    }

    out.print("<td><a class='button' href='sair.jsp'>Sair</a></td>");

    logged = true;

}catch(Exception e){
response.sendRedirect("login.jsp");
}

%>
    </tr>
</table>
