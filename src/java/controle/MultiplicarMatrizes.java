package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CalculoDAO;
import modelo.Multiplicar;
import modelo.Usuario;

public class MultiplicarMatrizes extends HttpServlet {

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
            
            int i,j,dima=0,dimb=0,dimc=0,dimd=0,erro=0;

            if(request.getParameter("dima") != null){
                try{
                dima = Integer.parseInt(request.getParameter("dima"));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_multiplica.jsp','_parent');");
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
                out.print(" window.open('altera_multiplica.jsp','_parent');");
                out.print("</script>");
                }
            }
            if(request.getParameter("dimc") != null){
                try{
                dimc = Integer.parseInt(request.getParameter("dimc"));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_multiplica.jsp','_parent');");
                out.print("</script>");
                }
            }
            dimd=dimc;
            dimc=dimb;
            double a[][] = new double[dima][dimb];
            double b[][] = new double[dimc][dimd];
            double resultado[][] = new double[dima][dimd];
            
            for(i=0;i<dima;i++){
                for(j=0;j<dimb;j++){
            if(request.getParameter("a"+i+j) != null&& request.getParameter("a"+i+j) != ""){
            try{
                a[i][j] = Double.parseDouble(request.getParameter("a"+i+j));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_multiplica.jsp','_parent');");
                out.print("</script>");
                }
                }else
            { a[i][j] = 0;}
            }
            }
            for(i=0;i<dimc;i++){
                for(j=0;j<dimd;j++){
            if(request.getParameter("b"+i+j) != null&& request.getParameter("b"+i+j) != ""){
            try{
                b[i][j] = Double.parseDouble(request.getParameter("b"+i+j));
                }catch(Exception e){
                erro = 1;
                out.print("<script language='JavaScript'>");
                out.print(" alert('Caracteres proibidos detectados!');");
                out.print(" window.open('altera_multiplica.jsp','_parent');");
                out.print("</script>");
                }
                }else
            { b[i][j] = 0;}
            }
            }
            
            session.setAttribute("dados_multiplica_a", a);
            session.setAttribute("dados_multiplica_b", b);
            session.setAttribute("dados_multiplica_dima", dima);
            session.setAttribute("dados_multiplica_dimb", dimb);
            session.setAttribute("dados_multiplica_dimc", dimc);
            session.setAttribute("dados_multiplica_dimd", dimd);
            if(erro==0){
            Multiplicar m = new Multiplicar(a, b, dima, dimb, dimd);
            m.calcular();
            resultado = m.getResultado();
            session.setAttribute("resultado_multiplica", resultado);
            session.setAttribute("resultado_multiplica_dima", dima);
            session.setAttribute("resultado_multiplica_dimb", dimd);
            try {
                m.setUsuario((Usuario)session.getAttribute("user"));
                Usuario uP = m.getUsuario();
                if(uP.temPermissao("/Facilita/listar_calculo.jsp","/Facilita",uP)){
                CalculoDAO cDB = new CalculoDAO();
                cDB.conectar();
                if(request.getParameter("id")!=null){
                m.setId(Integer.parseInt(request.getParameter("id")));
                cDB.alterar(m);
                }else{
                cDB.inserir(m);
                }
                cDB.desconectar();
                }
                } catch (Exception e) {
            }
            
            
            out.print("<script language='JavaScript'>");
            out.print(" window.open('resultado_multiplica.jsp','_parent');");
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
