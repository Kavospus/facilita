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
	    if (session.getAttribute("calculo") == null) {
		response.sendRedirect("index.jsp?erro=1");
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
		    Calculo calculo = calculusDB.carregaPorId(id);
		    operacao = calculo.getOperacao();
		    if (operacao.equals("Inverter")) {
			Inverter i = (Inverter) calculo;
			i.setDadosString();
			session.setAttribute("dados_t_a", i.getEntrada());
			session.setAttribute("dados_inversa_linesA",
				i.getDimensaoA());
			session.setAttribute("dados_inversa_columnsA",
				i.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_inversa.jsp?id="
				+ i.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Transpor")) {
			Transpor t = (Transpor) calculo;
			t.setDadosString();
			session.setAttribute("dados_transposta_a",
				t.getEntrada());
			session.setAttribute("dados_transposta_linesA",
				t.getDimensaoA());
			session.setAttribute("dados_transposta_columnsA",
				t.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_transposta.jsp?id="
				+ t.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Determinar")) {
			Determinar d = (Determinar) calculo;
			d.setDadosString();
			session.setAttribute("dados_determinante_a",
				d.getEntrada());
			session.setAttribute("dados_determinante_linesA",
				d.getDimensaoA());
			session.setAttribute("dados_determinante_columnsA",
				d.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_determinante.jsp?id="
				+ d.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Somar")) {
			Somar s = (Somar) calculo;
			s.setDadosString();
			session.setAttribute("dados_soma_a", s.getEntradaA());
			session.setAttribute("dados_soma_b", s.getEntradaB());
			session.setAttribute("dados_soma_linesA",
				s.getDimensaoA());
			session.setAttribute("dados_soma_columnsA",
				s.getDimensaoB());
			session.setAttribute("dados_soma_linesB",
				s.getDimensaoA());
			session.setAttribute("dados_soma_columnsB",
				s.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_soma.jsp?id="
				+ s.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Subtrair")) {
			Subtrair s = (Subtrair) calculo;
			s.setDadosString();
			session.setAttribute("dados_subtrai_a", s.getEntradaA());
			session.setAttribute("dados_subtrai_b", s.getEntradaB());
			session.setAttribute("dados_subtrai_linesA",
				s.getDimensaoA());
			session.setAttribute("dados_subtrai_columnsA",
				s.getDimensaoB());
			session.setAttribute("dados_subtrai_linesB",
				s.getDimensaoA());
			session.setAttribute("dados_subtrai_columnsB",
				s.getDimensaoB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_subtrai.jsp?id="
				+ s.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Multiplicar")) {
			Multiplicar menu = (Multiplicar) calculo;
			menu.setDadosString();
			session.setAttribute("dados_multiplica_a",
				menu.getEntradaA());
			session.setAttribute("dados_multiplica_b",
				menu.getEntradaB());
			session.setAttribute("dados_multiplica_linesA",
				menu.getDimensaoA());
			session.setAttribute("dados_multiplica_columnsA",
				menu.getDimensaoB());
			session.setAttribute("dados_multiplica_linesB",
				menu.getDimensaoB());
			session.setAttribute("dados_multiplica_columnsB",
				menu.getDimensaoC());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('altera_multiplica.jsp?id="
				+ menu.getId() + "','_parent');");
			out.print("</script>");
		    } else if (operacao.equals("Escalar")) {
			Escalar e = (Escalar) calculo;
			e.setDadosString();
			session.setAttribute("dados_escalar_a", e.getEntradaA());
			session.setAttribute("dados_escalar_n", e.getEntradaB());
			session.setAttribute("dados_escalar_linesA",
				e.getDimensaoA());
			session.setAttribute("dados_escalar_columnsA",
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
