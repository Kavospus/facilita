/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to transpose matrices
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CalculusDAO;
import modelo.Transpose;
import modelo.User;

public class TransposeMatrix extends HttpServlet {

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
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet EscalarMatriz</title>");
	    out.println("</head>");
	    out.println("<body>");
	    
            transposeMatrix(request, response, session, out);
	    out.println("</body>");
	    out.println("</html>");
	} finally {
	    out.close();
	}
    }
    
    
    public void transposeMatrix(HttpServletRequest request,HttpServletResponse response,
        HttpSession session,PrintWriter out){
          int i=0;
            int j=0;
            int linesA = 0;
            int columnsA = 0;
            int error = 0;

	    if (request.getParameter("linesA") != null) {
		try {
		    linesA = Integer.parseInt(request.getParameter("linesA"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('"+ResourceBundle.getBundle("MessagesBundle",
                            (Locale)session.getAttribute("user_locale")).
                            getString("Forbidden characters detected")+"!');");
		    out.print(" window.open('update_transposed.jsp','_parent');");
		    out.print("</script>");
		}
	    }
            else{
                //Nothing to do
            }
	    if (request.getParameter("columnsA") != null) {
		try {
		    columnsA = Integer.parseInt(request.getParameter("columnsA"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('"+ResourceBundle.getBundle("MessagesBundle",
                            (Locale)session.getAttribute("user_locale")).
                            getString("Forbidden characters detected")+"!');");
		    out.print(" window.open('update_transposed.jsp','_parent');");
		    out.print("</script>");
		}
	    }
            else{
                //Nothing to do
            }

	    double matrixA[][] = new double[linesA][columnsA];
	    double result[][];

	    for (i = 0; i < linesA; i++) {
		for (j = 0; j < columnsA; j++) {
		    if (request.getParameter("matrixA" + i + j) != null
			    && request.getParameter("matrixA" + i + j) != "") {
			try {
			    matrixA[i][j] = Double.parseDouble(request
				    .getParameter("matrixA" + i + j));
			} catch (Exception e) {
			    error = 1;
			    out.print("<script language='JavaScript'>");
			    out.print(" alert('"+ResourceBundle.getBundle("MessagesBundle",
                                    (Locale)session.getAttribute("user_locale")).
                                    getString("Forbidden characters detected")+"!');");
			    out.print(" window.open('update_transposed.jsp','_parent');");
			    out.print("</script>");
			}
		    } 
                    else {
			matrixA[i][j] = 0;
		    }
		}
	    }
            
	    session.setAttribute("data_transposed_matrixA", matrixA);
	    session.setAttribute("data_transposed_linesA", linesA);
	    session.setAttribute("data_transposed_columnsA", columnsA);
	   
            if (error == 0) {
		Transpose transpor = new Transpose(matrixA, linesA, columnsA);
		transpor.calculate();
		result = transpor.getResult();
		session.setAttribute("result_transposed", result);
		session.setAttribute("result_transposed_linesA", columnsA);
		session.setAttribute("result_transposed_columnsA", linesA);
		try {
		    transpor.setUser((User) session.getAttribute("userLogged"));
		    User userPermission = transpor.getUser();
		    if (userPermission.havePermission("/Facilita/list_calculus.jsp",
			    "/Facilita", userPermission)) {
			CalculusDAO calculusDB = new CalculusDAO();
			calculusDB.connect();
			if (request.getParameter("id") != null) {
			    transpor.setId(Integer.parseInt(request
				    .getParameter("id")));
			    calculusDB.update(transpor);
			} 
                        else {
			    calculusDB.insert(transpor);
			}
			calculusDB.disconnect();
		    }
                    else{
                        //Nothing to do
                    }
		} catch (Exception e) {
		}
		out.print("<script language='JavaScript'>");
		out.print(" window.open('transposed_result.jsp','_parent');");
		out.print("</script>");
	    }
            else{
                //Nothing to do
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
