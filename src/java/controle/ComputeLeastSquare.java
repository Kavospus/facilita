/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to calculates least-squares. 
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Minimos;
import org.ejml.factory.SingularMatrixException;


public class ComputeLeastSquare extends HttpServlet {

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
	    out.println("<title>Servlet CalculaMinimos</title>");
	    out.println("</head>");
	    out.println("<body>");
	    int quantity = 0, option = 1, i, errom = 0;
	    double result[] = null;
	    String error = null;
	    if (request.getParameter("quantity") != null) {
		try {
		    quantity = Integer.parseInt(request
			    .getParameter("quantity"));
		} catch (Exception e) {
		    errom = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('altera_minimos.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    if (request.getParameter("option") != null) {
		try {
		    option = Integer.parseInt(request.getParameter("option"));
		} catch (Exception e) {
		    errom = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('altera_minimos.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    double vectorX[] = new double[quantity];
	    double vectorY[] = new double[quantity];
	    for (i = 0; i < quantity; i++) {
		if (request.getParameter("vectorX" + i) != null) {
		    try {
			vectorX[i] = Double.parseDouble(request.getParameter("vectorX"
				+ i));
		    } catch (Exception e) {
			errom = 1;
			out.print("<script language='JavaScript'>");
			out.print(" alert('Caracteres proibidos detectados!');");
			out.print(" window.open('altera_minimos.jsp','_parent');");
			out.print("</script>");
		    }
		}
		if (request.getParameter("vectorY" + i) != null) {
		    try {
			vectorY[i] = Double.parseDouble(request.getParameter("vectorY"
				+ i));
		    } catch (Exception e) {
			errom = 1;
			out.print("<script language='JavaScript'>");
			out.print(" alert('Caracteres proibidos detectados!');");
			out.print(" window.open('altera_minimos.jsp','_parent');");
			out.print("</script>");
		    }
		}
	    }
	    session.setAttribute("data_least_squares_quantity", quantity);
	    session.setAttribute("data_least_squares_option", option);
	    session.setAttribute("data_least_squares_vectorX", vectorX);
	    session.setAttribute("data_least_squares_vectorY", vectorY);
	    if (errom == 0) {
		Minimos menu = new Minimos();
		try {
		    result = menu.calculaMinimos(vectorX, vectorY, quantity, option);
		} catch (SingularMatrixException e) {
		    error = "Matriz Singular";

		}

		session.setAttribute("result_least_squares", result);
		session.setAttribute("erro_minimos", error);

		out.print("<script language='JavaScript'>");
		out.print(" window.open('resultado_minimos.jsp?dimension="
			+ result.length + "','_parent');");
		out.print("</script>");
	    }
	    out.println("</body>");
	    out.println("</html>");
	} finally {
	    out.close();
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
