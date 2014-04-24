/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to load data to do the calculus. 
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Calculo;
import modelo.CalculoDAO;
import modelo.Determinar;
import modelo.Escalar;
import modelo.Inverter;
import modelo.Multiplicar;
import modelo.Somar;
import modelo.Subtrair;
import modelo.Transpor;


public class CarregarCalculo extends HttpServlet {

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
	    if (session.getAttribute("calculus") == null) {
		response.sendRedirect("index.jsp?error=1");
	    } else {
		/*
		 * TODO output your page here. You may use following sample
		 * code.
		 */
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet CarregarCalculo</title>");
		out.println("</head>");
		out.println("<body>");
		String operacao;
		try {
		    int id = Integer.parseInt(request.getParameter("id"));
		    CalculoDAO calculusDB = new CalculoDAO();
		    calculusDB.conectar();
		    Calculo calculus = calculusDB.carregaPorId(id);
		    operacao = calculus.getOperacao();
		    if (operacao.equals("Inverter")) {
			Inverter i = (Inverter) calculus;
			i.setDadosString();
			session.setAttribute("data_inverse_a", i.getEntrada());
			session.setAttribute("data_inverse_linesA",
				i.getDimensaoA());
			session.setAttribute("data_inverse_columnsA",
				i.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_inversa.jsp?id="
				+ i.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Transpor")) {
			Transpor t = (Transpor) calculus;
			t.setDadosString();
			session.setAttribute("data_transposed_a",
				t.getEntrada());
			session.setAttribute("data_transposed_linesA",
				t.getDimensaoA());
			session.setAttribute("data_transposed_columnsA",
				t.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_transposta.jsp?id="
				+ t.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Determinar")) {
			Determinar determine = (Determinar) calculus;
			determine.setDadosString();
			session.setAttribute("data_determinant_a",
				determine.getEntrada());
			session.setAttribute("data_determinant_linesA",
				determine.getDimensaoA());
			session.setAttribute("data_determinant_columnsA",
				determine.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_determinante.jsp?id="
				+ determine.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Somar")) {
			Somar s = (Somar) calculus;
			s.setDadosString();
			session.setAttribute("data_sum_a", s.getEntradaA());
			session.setAttribute("data_sum_b", s.getEntradaB());
			session.setAttribute("data_sum_linesA",
				s.getDimensaoA());
			session.setAttribute("data_sum_columnsA",
				s.getDimensaoB());
			session.setAttribute("data_sum_linesB",
				s.getDimensaoA());
			session.setAttribute("data_sum_columnsB",
				s.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_soma.jsp?id="
				+ s.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Subtrair")) {
			Subtrair s = (Subtrair) calculus;
			s.setDadosString();
			session.setAttribute("data_subtrai_a", s.getEntradaA());
			session.setAttribute("data_subtrai_b", s.getEntradaB());
			session.setAttribute("data_subtrai_linesA",
				s.getDimensaoA());
			session.setAttribute("data_subtrai_columnsA",
				s.getDimensaoB());
			session.setAttribute("data_subtrai_linesB",
				s.getDimensaoA());
			session.setAttribute("data_subtrai_columnsB",
				s.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_subtrai.jsp?id="
				+ s.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Multiplicar")) {
			Multiplicar menu = (Multiplicar) calculus;
			menu.setDadosString();
			session.setAttribute("data_multiplica_a",
				menu.getEntradaA());
			session.setAttribute("data_multiplica_b",
				menu.getEntradaB());
			session.setAttribute("data_multiplica_linesA",
				menu.getDimensaoA());
			session.setAttribute("data_multiplica_columnsA",
				menu.getDimensaoB());
			session.setAttribute("data_multiplica_linesB",
				menu.getDimensaoB());
			session.setAttribute("data_multiplica_columnsB",
				menu.getDimensaoC());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_multiplica.jsp?id="
				+ menu.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Escalar")) {
			Escalar e = (Escalar) calculus;
			e.setDadosString();
			session.setAttribute("data_scalar_a", e.getEntradaA());
			session.setAttribute("data_scalar_n", e.getEntradaB());
			session.setAttribute("data_scalar_linesA",
				e.getDimensaoA());
			session.setAttribute("data_scalar_columnsA",
				e.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_escalar.jsp?id="
				+ e.getId() + "','_parent');");
			out.print("</script>");
		    }

		} catch (Exception x) {
		    x.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	    }
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
