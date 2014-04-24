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


public class CalcularMinimos extends HttpServlet {

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
	    int quantidade = 0, opcao = 1, i, errom = 0;
	    double resultado[] = null;
	    String error = null;
	    if (request.getParameter("quantidade") != null) {
		try {
		    quantidade = Integer.parseInt(request
			    .getParameter("quantidade"));
		} catch (Exception e) {
		    errom = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('altera_minimos.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    if (request.getParameter("opcao") != null) {
		try {
		    opcao = Integer.parseInt(request.getParameter("opcao"));
		} catch (Exception e) {
		    errom = 1;
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Caracteres proibidos detectados!');");
		    out.print(" window.open('altera_minimos.jsp','_parent');");
		    out.print("</script>");
		}
	    }
	    double vx[] = new double[quantidade];
	    double vy[] = new double[quantidade];
	    for (i = 0; i < quantidade; i++) {
		if (request.getParameter("vx" + i) != null) {
		    try {
			vx[i] = Double.parseDouble(request.getParameter("vx"
				+ i));
		    } catch (Exception e) {
			errom = 1;
			out.print("<script language='JavaScript'>");
			out.print(" alert('Caracteres proibidos detectados!');");
			out.print(" window.open('altera_minimos.jsp','_parent');");
			out.print("</script>");
		    }
		}
		if (request.getParameter("vy" + i) != null) {
		    try {
			vy[i] = Double.parseDouble(request.getParameter("vy"
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
	    session.setAttribute("data_minimos_quantidade", quantidade);
	    session.setAttribute("data_minimos_opcao", opcao);
	    session.setAttribute("data_minimos_vx", vx);
	    session.setAttribute("data_minimos_vy", vy);
	    if (errom == 0) {
		Minimos menu = new Minimos();
		try {
		    resultado = menu.calculaMinimos(vx, vy, quantidade, opcao);
		} catch (SingularMatrixException e) {
		    error = "Matriz Singular";

		}

		session.setAttribute("result_minimos", resultado);
		session.setAttribute("erro_minimos", error);

		out.print("<script language='JavaScript'>");
		out.print(" window.open('resultado_minimos.jsp?dimens="
			+ resultado.length + "','_parent');");
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
