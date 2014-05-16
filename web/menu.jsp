<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="modelo.Menu"%>
<%@page import="modelo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="centertable" >
    <tr>
<%

boolean logged = false;
User userLogged = null;
if(session.getAttribute("user_locale")== null){
    response.sendRedirect("login.jsp");
}
ResourceBundle bundle = null;
try{

    userLogged = (User) session.getAttribute("userLogged");
    Locale userLocale =(Locale) session.getAttribute("user_locale");
    bundle= ResourceBundle.getBundle("MessagesBundle",userLocale);
    out.print("<td>"+_("Welcome",bundle)+" "+userLogged.getName()+"</td>");
    for(Menu mp:userLogged.getProfile().getMenus()){

    out.print("<td >"
            + "<a class='button' href='"+mp.getLink()+"'><div align='justify' class=\"minButtonWidth\">"
            + "<img width='10' height='10' src='"+mp.getIcon()+"'>   "+_(mp.getMenu(),bundle)+"</div></a></td>" );
    }
    out.print("<td><a class='button' href='change_locale.jsp?locale="+userLocale.toString()+"'>"+_("Locale Change",bundle)+"</a></td>");
    out.print("<td><a class='button' href='exit.jsp'>"+_("Logout",bundle)+"</a></td>");

    logged = true;

    
}catch(Exception e){
response.sendRedirect("login.jsp");
}
%>
<%!
public String _(String message,ResourceBundle bundle){
    return bundle.getString(message);
}
%>
    </tr>
</table>
