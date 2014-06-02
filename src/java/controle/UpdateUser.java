/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that change the user.
 */

package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.MD5Encrypter;
import modelo.ProfileDAO;
import modelo.User;
import modelo.UserDAO;


public class UpdateUser extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
    if(session.getAttribute("user") == null){
       response.sendRedirect("index.jsp?error=1");
    }
    else{
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlterarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            try {

                updateUser(request, response, session, out);

            } catch (Exception e) {
                out.print("<script language='JavaScript'>");
                out.print(" alert('O usuário já existe!');");
                out.print(" window.open('list_user.jsp','_parent');");
                out.print("</script>");
            }
            out.println("</body>");
            out.println("</html>");
            }
        } finally { 
            out.close();
        }
    } 
    
    public void updateUser(HttpServletRequest request,HttpServletResponse response,
        HttpSession session,PrintWriter out) throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));
                int id_profile = 0;
               
                if(request.getParameter("id_profile") != null){
                    try{
                        id_profile = Integer.parseInt(request.getParameter("id_profile"));
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    //Nothing to do
                }
                
                String name = request.getParameter("name");
                String password = MD5Encrypter.encryptMD5(request.getParameter("password"));
                String login = request.getParameter("login");

                User user = new User();
                ProfileDAO profileDB = new ProfileDAO();
                user.setId(id);
                user.setName(name);
                profileDB.connect();
                user.setProfile(profileDB.selectById(id_profile));
                profileDB.disconnect();
                user.setPassword(password);
                user.setLogin(login);



                UserDAO userDB = new UserDAO();

                userDB.connect();
                userDB.update(user);
                userDB.disconnect();

                out.print("<script language='JavaScript'>");
                out.print(" alert('"+ResourceBundle.getBundle("MessagesBundle",
                        (Locale)session.getAttribute("user_locale")).
                        getString("sucessfuly updated")+"!');");
                out.print(" window.open('list_user.jsp','_parent');");
                out.print("</script>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
