<%@page import="java.util.Locale"%>
<%
if(request.getParameter("locale").equalsIgnoreCase("en_US")){
    session.setAttribute("user_locale", new Locale("pt", "BR"));
}else if(request.getParameter("locale").equalsIgnoreCase("pt_BR")){
    session.setAttribute("user_locale", new Locale("en", "US"));
}
    response.sendRedirect("index.jsp");
%>
