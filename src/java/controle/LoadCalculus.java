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
import modelo.Calculus;
import modelo.CalculusDAO;
import modelo.Determine;
import modelo.Scale;
import modelo.Invert;
import modelo.Multiply;
import modelo.Sum;
import modelo.Subtract;
import modelo.Transpose;


public class LoadCalculus extends HttpServlet {

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
	    } 
            else {
		/*
		 * TODO output your page here. You may use following sample
		 * code.
		 */
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet CarregarCalculo</title>");
		out.println("</head>");
		out.println("<body>");
		String operation;
		try {
		    int id = Integer.parseInt(request.getParameter("id"));
		    CalculusDAO calculusDB = new CalculusDAO();
		    calculusDB.connect();
		    Calculus calculus = calculusDB.selectById(id);
		    operation = calculus.getOperation();
		    if (operation.equals("Invert")) {
			                     invert(session, calculus, out);
		    } 
                    else if (operation.equals("Transpose")) {
			                     transpose(session, calculus, out);
		    } 
                    else if (operation.equals("Determine")) {
			                     determine(session, calculus, out);
		    } 
                    else if (operation.equals("Sum")) {
			                     sum(session, calculus, out);
		    } 
                    else if (operation.equals("Subtract")) {
			                     subtract(session, calculus, out);
		    } 
                    else if (operation.equals("Multiply")) {
			                     multiply(session, calculus, out);
		    } 
                    else if (operation.equals("Scale")) {
			                     scale(session, calculus, out);
		    }
                    else{
                        //Nothing to do
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
    
    public void invert(HttpSession session, Calculus calculus, PrintWriter out){
                Invert i = (Invert) calculus;
			i.setDataString();
			session.setAttribute("data_inverse_matrixA", i.getInput());
			session.setAttribute("data_inverse_linesA",
				i.getLinesA());
			session.setAttribute("data_inverse_columnsA",
				i.getColumnsA());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_inverse.jsp?id="
				+ i.getId() + "','_parent');");
			out.print("</script>");
    }
    
    public void transpose(HttpSession session, Calculus calculus, PrintWriter out){
                Transpose t = (Transpose) calculus;
			t.setDataString();
			session.setAttribute("data_transposed_matrixA",
				t.getInput());
			session.setAttribute("data_transposed_linesA",
				t.getLinesA());
			session.setAttribute("data_transposed_columnsA",
				t.getColumnsA());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_transposed.jsp?id="
				+ t.getId() + "','_parent');");
			out.print("</script>");
    }
    
    public void determine(HttpSession session, Calculus calculus, PrintWriter out){
                Determine determine = (Determine) calculus;
			determine.setDataString();
			session.setAttribute("data_determinant_matrixA",
				determine.getInput());
			session.setAttribute("data_determinant_linesA",
				determine.getLinesA());
			session.setAttribute("data_determinant_columnsA",
				determine.getColumnsA());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_determinant.jsp?id="
				+ determine.getId() + "','_parent');");
			out.print("</script>");
    }
    
    public void sum(HttpSession session, Calculus calculus, PrintWriter out){
                Sum s = (Sum) calculus;
			s.setDataString();
			session.setAttribute("data_sum_matrixA", s.getInputA());
			session.setAttribute("data_sum_matrixB", s.getInputB());
			session.setAttribute("data_sum_linesA",
				s.getLinesA());
			session.setAttribute("data_sum_columnsA",
				s.getColumnsA());
			session.setAttribute("data_sum_linesB",
				s.getLinesA());
			session.setAttribute("data_sum_columnsB",
				s.getColumnsA());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_sum.jsp?id="
				+ s.getId() + "','_parent');");
			out.print("</script>");
    }
    
    public void subtract(HttpSession session, Calculus calculus, PrintWriter out){
                Subtract s = (Subtract) calculus;
			s.setDataString();
			session.setAttribute("data_subtract_matrixA", s.getInputA());
			session.setAttribute("data_subtract_matrixB", s.getInputB());
			session.setAttribute("data_subtract_linesA",
				s.getLinesA());
			session.setAttribute("data_subtract_columnsA",
				s.getColumnsA());
			session.setAttribute("data_subtract_linesB",
				s.getLinesA());
			session.setAttribute("data_subtract_columnsB",
				s.getColumnsA());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_subtract.jsp?id="
				+ s.getId() + "','_parent');");
			out.print("</script>");
    }
    
    public void multiply(HttpSession session, Calculus calculus, PrintWriter out){
                Multiply menu = (Multiply) calculus;
			menu.setDataString();
			session.setAttribute("data_multiply_matrixA",
				menu.getInputA());
			session.setAttribute("data_multiply_matrixB",
				menu.getInputB());
			session.setAttribute("data_multiply_linesA",
				menu.getLinesA());
			session.setAttribute("data_multiply_columnsA",
				menu.getColumnsA());
			session.setAttribute("data_multiply_linesB",
				menu.getColumnsA());
			session.setAttribute("data_multiply_columnsB",
				menu.getLinesB());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_multiply.jsp?id="
				+ menu.getId() + "','_parent');");
			out.print("</script>");
    }
    
    public void scale(HttpSession session, Calculus calculus, PrintWriter out){
                Scale e = (Scale) calculus;
			e.setDataString();
			session.setAttribute("data_scalar_matrixA", e.getInputA());
			session.setAttribute("data_scalar_number", e.getInputB());
			session.setAttribute("data_scalar_linesA",
				e.getLinesA());
			session.setAttribute("data_scalar_columnsA",
				e.getColumnsA());
			out.print("<script language='JavaScript'>");
			out.print(" window.open('update_scalar.jsp?id="
				+ e.getId() + "','_parent');");
			out.print("</script>");
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
