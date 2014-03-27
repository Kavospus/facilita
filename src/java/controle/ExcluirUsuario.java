/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 * 
 * @author André
 */
public class ExcluirUsuario extends HttpServlet {

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
	    if (session.getAttribute("usuario") == null) {
		response.sendRedirect("index.jsp?erro=1");
	    } else {
		// TODO output your page here
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet DeletarUsuario</title>");
		out.println("</head>");
		out.println("<body>");
		try {
		    int id = Integer.parseInt(request.getParameter("id"));
		    Usuario u = new Usuario();
		    u.setId(id);

		    UsuarioDAO uDB = new UsuarioDAO();

		    uDB.conectar();
		    uDB.excluir(u);
		    uDB.desconectar();

		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Registros deletados com sucesso!');");
		    out.print(" window.open('listar_usuario.jsp','_parent');");
		    out.print("</script>");

		} catch (Exception e) {
		    out.print(e);
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
