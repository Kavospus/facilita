/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to login into the system.
 */


package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.User;
import modelo.UserDAO;

public class DoLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
				  HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	try {

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet EfetuarLogin</title>");
	    out.println("</head>");
	    out.println("<body>");

	    try {
                doLogin(request,response,session,out);
	    } catch (Exception ex) {
		 Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
	    }

	    out.println("</body>");
	    out.println("</html>");

	} finally {
	    out.close();
	}
    }

    public void doLogin(HttpServletRequest request,HttpServletResponse response,
        HttpSession session,PrintWriter out) throws Exception{
        String login = request.getParameter("user");
        String pass = request.getParameter("pass");

        UserDAO userDB = new UserDAO();
        userDB.connect();
        User user = userDB.logon(login, pass);

        if (user.getId() > 0) {
            session.setAttribute("userLogged", user);
            response.sendRedirect("index.jsp");
        }
                else {
            out.print("<script language='JavaScript'>");
            out.print(" alert('"+ResourceBundle.getBundle("MessagesBundle",
                            (Locale)session.getAttribute("user_locale")).
                            getString("Incorrect Login")+"!');");
            out.print(" window.open('login.jsp','_parent');");
            out.print("</script>");
        }
    }

    // <editor-fold defaultstate="collapsed"
// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
			 HttpServletResponse response) throws ServletException,
	    IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
			  HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
