/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class to insert a new user.
 */

package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.MD5Encrypter;
import modelo.Perfil;
import modelo.PerfilDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class InsertUser extends HttpServlet {

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
	    if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp?error=1");
	    } else {
		// TODO output your page here
		try {
		    int id_profile = 0;
		    if (request.getParameter("id_profile") != null) {
			try {
			    id_profile = Integer.parseInt(request
				    .getParameter("id_profile"));
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }
		    String name = request.getParameter("name");
		    String password = MD5Encrypter.encryptMD5(request
			    .getParameter("password"));
		    String login = request.getParameter("login");

		    Usuario user = new Usuario();
		    PerfilDAO profileDB = new PerfilDAO();
		    user.setSenha(password);
		    user.setLogin(login);
		    profileDB.conectar();
		    user.setPerfil(profileDB.carregaPorId(id_profile));
		    profileDB.desconectar();
		    user.setNome(name);

		    UsuarioDAO userDB = new UsuarioDAO();

		    userDB.conectar();
		    userDB.inserir(user);
		    userDB.desconectar();

		    out.print("<script language='JavaScript'>");
		    out.print(" alert('Registros inseridos com sucesso!');");
		    out.print(" window.open('listar_usuario.jsp','_parent');");
		    out.print("</script>");

		} catch (Exception e) {
		    out.print("<script language='JavaScript'>");
		    out.print(" alert('O usuário já existe!');");
		    out.print(" window.open('form_inserir_usuario.jsp','_parent');");
		    out.print("</script>");
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
