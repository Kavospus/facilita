/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to multiply a matrix by a scalar. 
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CalculoDAO;
import modelo.Escalar;
import modelo.Usuario;


public class EscalarMatriz extends HttpServlet {

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
	    int i, j, linesA = 0, columnsA = 0, error = 0;
	    double number = 0;
	    if (request.getParameter("linesA") != null) {
		try {
		    linesA = Integer.parseInt(request.getParameter("linesA"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('altera_escalar.jsp','_parent');");
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
		    out.print(" window.open('altera_escalar.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    if (request.getParameter("n") != null) {
		try {
		    number = Double.parseDouble(request.getParameter("number"));
		} catch (Exception e) {
		    error = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('altera_escalar.jsp','_parent');");
		    out.print("</script>");
		}
	    }

	    double a[][] = new double[linesA][columnsA];
	    double result[][];

	    for (i = 0; i < linesA; i++) {
		for (j = 0; j < columnsA; j++) {
		    if (request.getParameter("a" + i + j) != null
			    && request.getParameter("a" + i + j) != "") {
			try {
			    a[i][j] = Double.parseDouble(request
				    .getParameter("a" + i + j));
			} catch (Exception e) {
			    error = 1;
			    out.print("<script language='JavaScript'>");
			    out.print(" alert('Caracteres proibidos detectados!');");
			    out.print(" window.open('altera_escalar.jsp','_parent');");
			    out.print("</script>");
			}
		    } else {
			a[i][j] = 0;
		    }
		}
	    }
	    session.setAttribute("data_scalar_a", a);
	    session.setAttribute("data_scalar_linesA", linesA);
	    session.setAttribute("data_scalar_columnsA", columnsA);
	    session.setAttribute("data_scalar_n", number);
	    if (error == 0) {
		Escalar scalar = new Escalar(a, number, linesA, columnsA);
		scalar.calcular();
		result = scalar.getResultado();
		session.setAttribute("result_escalar", result);
		session.setAttribute("result_escalar_linesA", linesA);
		session.setAttribute("result_escalar_columnsA", columnsA);
		try {
		    scalar.setUsuario((Usuario) session.getAttribute("user"));
		    Usuario userPermission = scalar.getUsuario();
		    if (userPermission.temPermissao("/Facilita/listar_calculo.jsp",
			    "/Facilita", userPermission)) {
			CalculoDAO calculusDB = new CalculoDAO();
			calculusDB.conectar();
			if (request.getParameter("id") != null) {
			    scalar.setId(Integer.parseInt(request.getParameter("id")));
			    calculusDB.alterar(scalar);
			} else {
			    calculusDB.inserir(scalar);
			}
			calculusDB.desconectar();
		    }
		} catch (Exception x) {
		}
		out.print("<script language='JavaScript'>");
		out.print(" window.open('resultado_escalar.jsp','_parent');");
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
