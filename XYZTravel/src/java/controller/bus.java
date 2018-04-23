package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class bus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       
       String bfrom = request.getParameter("bfrom");    
       String bto = request.getParameter("bto");
       //String option = request.getParameter("option");
       Connection con = null;
       Statement stmt = null;
       ResultSet rs = null;
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1", "cmpjcol1", "password");
            stmt = (Statement)con.createStatement();                                  
            rs = stmt.executeQuery("SELECT bus_from, bus_to FROM buses WHERE bus_from = '" + bfrom + "' AND bus_to = '" + bto + "'");         
            while (rs.next()) {
            String s = rs.getString("bus_from");
            String s1 = rs.getString("bus_to");
            HttpSession session=request.getSession();  
            session.setAttribute("bus_from",s);
            session.setAttribute("bus_to",s1);
            response.sendRedirect("busresults.jsp");
            out.println(s + "   ");
            } 
   
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            //response.sendRedirect("account.jsp");
            out.println("</body>");
            out.println("</html>");
        }
       
       catch (ClassNotFoundException ex)
        {
            out.println("Couldn't load database driver: " + ex.getMessage());
        } catch (SQLException ex) 
        {
            out.println("SQLException caught : " + ex.getMessage());
        }
        finally{
            out.close();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
