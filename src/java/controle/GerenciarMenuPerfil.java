/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Menu manager class of profiles.
 */

package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.MenuDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class GerenciarMenuPerfil extends HttpServlet {

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
	    if (session.getAttribute("perfil") == null) {
		response.sendRedirect("index.jsp?erro=1");
	    } else {

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet GerenciarMenuPerfil</title>");
		out.println("</head>");
		out.println("<body>");

		try {

		    int op = Integer.parseInt(request.getParameter("op"));
		    int id_menu = Integer.parseInt(request
			    .getParameter("id_menu"));
		    int id_perfil = Integer.parseInt(request
			    .getParameter("id_perfil"));

		    MenuDAO menuDB = new MenuDAO();
		    menuDB.conectar();

		    if (op == 1) {
			menuDB.vincularMenu(id_menu, id_perfil);
		    } else if (op == 2) {
			menuDB.desvincularMenu(id_menu, id_perfil);
		    }

		    menuDB.desconectar();

		    Usuario user = (Usuario) session.getAttribute("user");
		    UsuarioDAO userDB = new UsuarioDAO();
		    userDB.conectar();
		    Usuario nu = userDB.carregaPorId(user.getId());
		    userDB.desconectar();
		    session.removeAttribute("perfil");
		    session.removeAttribute("menu");
		    session.removeAttribute("orcamento");
		    session.removeAttribute("requisicao");
		    session.removeAttribute("produto");
		    session.removeAttribute("usuario");
		    session.setAttribute("user", nu);
		    session.setAttribute("perfil", true);
		    session.setAttribute("menu", null);
		    session.setAttribute("orcamento", null);
		    session.setAttribute("requisicao", null);
		    session.setAttribute("produto", null);
		    session.setAttribute("produto", null);
		    session.setAttribute("usuario", null);
		    response.sendRedirect("form_gerenciar_menu_perfil.jsp?id="
			    + id_perfil);

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
