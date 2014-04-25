/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to multiply matrices. 
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
import modelo.Multiply;
import modelo.User;

public class MultiplyMatrices extends HttpServlet {

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

	    int i, j, linesA = 0, columnsA = 0, linesB = 0, columnsB = 0, error = 0;

	    if (request.getParameter("linesA") != null) {
		try {
		    linesA = Integer.parseInt(request.getParameter("linesA"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('update_multiply.jsp','_parent');");
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
		    out.print(" window.open('update_multiply.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    if (request.getParameter("linesB") != null) {
		try {
		    linesB = Integer.parseInt(request.getParameter("linesB"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('update_multiply.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    columnsB = linesB;
	    linesB = columnsA;
	    double matrixA[][] = new double[linesA][columnsA];
	    double matrixB[][] = new double[linesB][columnsB];
	    double result[][] = new double[linesA][columnsB];

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
			    out.print(" window.open('update_multiply.jsp','_parent');");
			    out.print("</script>");
			}
		    } else {
			matrixA[i][j] = 0;
		    }
		}
	    }
	    for (i = 0; i < linesB; i++) {
		for (j = 0; j < columnsB; j++) {
		    if (request.getParameter("matrixB" + i + j) != null
			    && request.getParameter("matrixB" + i + j) != "") {
			try {
			    matrixB[i][j] = Double.parseDouble(request
				    .getParameter("matrixB" + i + j));
			} catch (Exception e) {
			    error = 1;
			    out.print("<script language='JavaScript'>");
			    out.print(" alert('Caracteres proibidos detectados!');");
			    out.print(" window.open('update_multiply.jsp','_parent');");
			    out.print("</script>");
			}
		    } else {
			matrixB[i][j] = 0;
		    }
		}
	    }

	    session.setAttribute("data_multiply_matrixA", matrixA);
	    session.setAttribute("data_multiply_b", matrixB);
	    session.setAttribute("data_multiply_linesA", linesA);
	    session.setAttribute("data_multiply_columnsA", columnsA);
	    session.setAttribute("data_multiply_linesB", linesB);
	    session.setAttribute("data_multiply_columnsB", columnsB);
	    if (error == 0) {
		Multiply menu = new Multiply(matrixA, matrixB, linesA, columnsA, columnsB);
		menu.calculate();
		result = menu.getResult();
		session.setAttribute("result_multiply", result);
		session.setAttribute("result_multiply_linesA", linesA);
		session.setAttribute("result_multiply_columnsA", columnsB);
		try {
		    menu.setUser((User) session.getAttribute("user"));
		    User userPermission = menu.getUser();
		    if (userPermission.havePermission("/Facilita/list_calculus.jsp",
			    "/Facilita", userPermission)) {
			CalculusDAO calculusDB = new CalculusDAO();
			calculusDB.connect();
			if (request.getParameter("id") != null) {
			    menu.setId(Integer.parseInt(request.getParameter("id")));
			    calculusDB.update(menu);
			} else {
			    calculusDB.insert(menu);
			}
			calculusDB.disconnect();
		    }
		} catch (Exception e) {
		}

		out.print("<script language='JavaScript'>");
		out.print(" window.open('multiply_result.jsp','_parent');");
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
