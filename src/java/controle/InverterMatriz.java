/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert data to calculates inverse matrices. 
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
import modelo.Inverter;
import modelo.Usuario;

public class InverterMatriz extends HttpServlet {

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
	    out.println("<title>Servlet InverteMatriz</title>");
	    out.println("</head>");
	    out.println("<body>");
	    try {
		int i, j, linesA = 0, columnsA = 0, erro = 0;

		if (request.getParameter("linesA") != null) {
		    try {
			linesA = Integer.parseInt(request.getParameter("linesA"));
		    } catch (Exception e) {
			erro = 1;
			out.print("<script language='JavaScript'>");
			out.print(" alert('Caracteres proibidos detectados!');");
			out.print(" window.open('altera_inversa.jsp','_parent');");
			out.print("</script>");
		    }
		}
		columnsA = linesA;

		double a[][] = new double[linesA][columnsA];
		double resultado[][];

		for (i = 0; i < linesA; i++) {
		    for (j = 0; j < columnsA; j++) {
			if (request.getParameter("a" + i + j) != null
				&& request.getParameter("a" + i + j) != "") {
			    try {
				a[i][j] = Double.parseDouble(request
					.getParameter("a" + i + j));
			    } catch (Exception e) {
				erro = 1;
				out.print("<script language='JavaScript'>");
				out.print(" alert('Caracteres proibidos detectados!');");
				out.print(" window.open('altera_inversa.jsp','_parent');");
				out.print("</script>");
			    }
			} else {
			    a[i][j] = 0;
			}
		    }
		}
		session.setAttribute("dados_inversa_a", a);
		session.setAttribute("dados_inversa_linesA", linesA);
		session.setAttribute("dados_inversa_columnsA", columnsA);
		if (erro == 0) {
		    Inverter inverter = new Inverter(a, linesA, columnsA);
		    inverter.calcular();
		    resultado = inverter.getResultado();
		    session.setAttribute("resultado_inversa", resultado);
		    session.setAttribute("resultado_inversa_linesA", linesA);
		    session.setAttribute("resultado_inversa_columnsA", columnsA);

		    inverter.setUsuario((Usuario) session.getAttribute("user"));
		    Usuario uP = inverter.getUsuario();
		    if (uP.temPermissao("/Facilita/listar_calculo.jsp",
			    "/Facilita", uP)) {
			CalculoDAO calculusDB = new CalculoDAO();
			calculusDB.conectar();
			if (request.getParameter("id") != null) {
			    inverter.setId(Integer.parseInt(request
				    .getParameter("id")));
			    calculusDB.alterar(inverter);
			} else {
			    calculusDB.inserir(inverter);
			}
			calculusDB.desconectar();
		    }
		    out.print("<script language='JavaScript'>");
		    out.print(" window.open('resultado_inversa.jsp','_parent');");
		    out.print("</script>");
		}
	    } catch (Exception e) {
		System.out.println(e.getMessage());
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
