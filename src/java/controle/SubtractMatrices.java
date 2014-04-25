/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to subtract matrices. 
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CalculusDAO;
import modelo.Subtract;
import modelo.User;


public class SubtractMatrices extends HttpServlet {

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
	    out.println("<title>Servlet MultiplicaMatrizes</title>");
	    out.println("</head>");
	    out.println("<body>");
	    int i, j, linesA = 0, columnsA = 0, error = 0;
	    if (request.getParameter("linesA") != null) {
		try {
		    linesA = Integer.parseInt(request.getParameter("linesA"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('update_subtract.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    if (request.getParameter("columnsA") != null) {
		try {
		    columnsA = Integer.parseInt(request.getParameter("columnsA"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('update_subtract.jsp','_parent');");
		    out.print("</script>");
		}
	    }

	    double matrixA[][] = new double[linesA][columnsA];
	    double matrixB[][] = new double[linesA][columnsA];
	    double result[][] = new double[linesA][columnsA];

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
			    out.print(" alert('Caracteres proibidos detectados!');");
			    out.print(" window.open('update_subtract.jsp','_parent');");
			    out.print("</script>");
			}
		    } else {
			matrixA[i][j] = 0;
		    }
		}
	    }
	    for (i = 0; i < linesA; i++) {
		for (j = 0; j < columnsA; j++) {
		    if (request.getParameter("matrixB" + i + j) != null
			    && request.getParameter("matrixB" + i + j) != "") {
			try {
			    matrixB[i][j] = Double.parseDouble(request
				    .getParameter("matrixB" + i + j));
			} catch (Exception e) {
			    error = 1;
			    out.print("<script language='JavaScript'>");
			    out.print(" alert('Caracteres proibidos detectados!');");
			    out.print(" window.open('update_subtract.jsp','_parent');");
			    out.print("</script>");
			}
		    } else {
			matrixB[i][j] = 0;
		    }
		}
	    }

	    session.setAttribute("data_subtract_matrixA", matrixA);
	    session.setAttribute("data_subtract_matrixB", matrixB);
	    session.setAttribute("data_subtract_linesA", linesA);
	    session.setAttribute("data_subtract_columnsA", columnsA);
	    session.setAttribute("data_subtract_linesB", linesA);
	    session.setAttribute("data_subtract_columnsB", columnsA);
	    if (error == 0) {
		Subtract s = new Subtract(matrixA, matrixB, linesA, columnsA);
		s.calculate();
		result = s.getResult();
		session.setAttribute("result_subtract", result);
		session.setAttribute("result_subtract_linesA", linesA);
		session.setAttribute("result_subtract_columnsA", columnsA);
		session.setAttribute("result_subtract_linesB", linesA);
		session.setAttribute("result_subtract_columnsB", columnsA);
		try {
		    s.setUser((User) session.getAttribute("userLogged"));
		    User userPermission = s.getUser();
		    if (userPermission.havePermission("/Facilita/list_calculus.jsp",
			    "/Facilita", userPermission)) {
			CalculusDAO calculusDB = new CalculusDAO();
			calculusDB.connect();
			if (request.getParameter("id") != null) {
			    s.setId(Integer.parseInt(request.getParameter("id")));
			    calculusDB.update(s);
			} else {
			    calculusDB.insert(s);
			}
			calculusDB.disconnect();
		    }
		} catch (Exception e) {
		}
		out.print("<script language='JavaScript'>");
		out.print(" window.open('subtract_result.jsp','_parent');");
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
