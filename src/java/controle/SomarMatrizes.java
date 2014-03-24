/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import modelo.Somar;
import modelo.Usuario;

/**
 *
 * @author Andre
 */
public class SomarMatrizes extends HttpServlet {

   
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MultiplicaMatrizes</title>");            
            out.println("</head>");
            out.println("<body>");
            int i,j,dima=0,dimb=0,erro=0;
            if(request.getParameter("dima") != null){
                try{
                dima = Integer.parseInt(request.getParameter("dima"));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_soma.jsp','_parent');");
                out.print("</script>");
                }
            }
            if(request.getParameter("dimb") != null){
                try{
                dimb = Integer.parseInt(request.getParameter("dimb"));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_soma.jsp','_parent');");
                out.print("</script>");
                }
            }

            double a[][] = new double[dima][dimb];
            double b[][] = new double[dima][dimb];
            double resultado[][] = new double[dima][dimb];
            
            for(i=0;i<dima;i++){
                for(j=0;j<dimb;j++){
            if(request.getParameter("a"+i+j) != null&& request.getParameter("a"+i+j) != ""){
            try{
                a[i][j] = Double.parseDouble(request.getParameter("a"+i+j));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_soma.jsp','_parent');");
                out.print("</script>");
                }
                }else
            { a[i][j] = 0;}
            }
            }
            for(i=0;i<dima;i++){
                for(j=0;j<dimb;j++){
            if(request.getParameter("b"+i+j) != null&& request.getParameter("b"+i+j) != ""){
            try{
                b[i][j] = Double.parseDouble(request.getParameter("b"+i+j));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_soma.jsp','_parent');");
                out.print("</script>");
                }
                }else
            { b[i][j] = 0;}
            }
            }
            
            session.setAttribute("dados_soma_a", a);
            session.setAttribute("dados_soma_b", b);
            session.setAttribute("dados_soma_dima", dima);
            session.setAttribute("dados_soma_dimb", dimb);
            session.setAttribute("dados_soma_dimc", dima);
            session.setAttribute("dados_soma_dimd", dimb);
            if(erro ==0){
            Somar s = new Somar(a, b, dima, dimb);
            s.calcular();
            resultado =s.getResultado();
            session.setAttribute("resultado_soma", resultado);
            session.setAttribute("resultado_soma_dima", dima);
            session.setAttribute("resultado_soma_dimb", dimb);
            session.setAttribute("resultado_soma_dimc", dima);
            session.setAttribute("resultado_soma_dimd", dimb);
            
            try {
                s.setUsuario((Usuario)session.getAttribute("user"));
                Usuario uP = s.getUsuario();
                if(uP.temPermissao("/Facilita/listar_calculo.jsp","/Facilita",uP)){
                CalculoDAO cDB = new CalculoDAO();
                cDB.conectar();
                if(request.getParameter("id")!=null){
                s.setId(Integer.parseInt(request.getParameter("id")));
                cDB.alterar(s);
                }else{
                cDB.inserir(s);
                }
                cDB.desconectar();    
                }
                } catch (Exception e) {
            }
            
            out.print("<script language='JavaScript'>");
            out.print(" window.open('resultado_soma.jsp','_parent');");
            out.print("</script>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
