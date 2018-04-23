package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class bus_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Buses</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">   \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/cssLayout.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/default.css\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"resources/images/favicon.ico\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"nav\" class=\"nav\">\n");
      out.write("            <ul>\n");
      out.write("                <li><form><a href=\"index.xhtml\" style=\"text-decoration:none;color:white\">Home</a></form></li>\n");
      out.write("                <li><form><a href=\"flight.jsp\" style=\"text-decoration:none;color:white\">Flight</a></form></li>\n");
      out.write("                <li><form><a href=\"train.jsp\" style=\"text-decoration:none;color:white\">Train</a></form></li>\n");
      out.write("                <li><form><a href=\"bus.jsp\" style=\"text-decoration:none;color:white\">Bus</a></form></li>\n");
      out.write("                <li><form><a href=\"vehicle.xhtml\" style=\"text-decoration:none;color:white\">Vehicle Hire</a></form></li>\n");
      out.write("                <li><form><a href=\"city.xhtml\" style=\"text-decoration:none;color:white\">City information</a></form></li>\n");
      out.write("                <li><form><a href=\"locations.html\" style=\"text-decoration:none;color:white\">Locations</a></form></li>\n");
      out.write("                <li><form><a href=\"about.xhtml\" style=\"text-decoration:none;color:white\">About</a></form></li>\n");
      out.write("                <li style=\"float:right\"><form><a href=\"login.jsp\" class=\"active\" style=\"text-decoration:none;color:white;float:right;\">Account</a></form></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"top\">\n");
      out.write("            <a href=\"index.xhtml\"><img src=\"resources/images/banner-alt.png\" alt=\"XYZ travel\" height=\"150\"></a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"content\" class=\"left_content\">   \n");
      out.write("            <br/>\n");
      out.write("            <h3>Click <a href=\"bus.xhtml\">here</a> to see all available buses with XYZ Travel</h3>\n");
      out.write("            <form action=\"bus.jsp\" method=\"post\"> \n");
      out.write("                <br/><br/>\n");
      out.write("                <h3>Search Buses</h3>\n");
      out.write("                <select class=\"form-control\" name=\"busfrom\">\n");
      out.write("                    <option name=\"thevalue\" value=\"0\">-Select From-</option>\n");
      out.write("                    \n");
      out.write("                    ");
 
                        try{
                            String query="SELECT DISTINCT bus_fromid, bus_from FROM bus ORDER BY bus_from ASC";
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while (rs.next())
                            {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(rs.getInt("bus_fromid"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("bus_from"));
      out.write("</option> \n");
      out.write("                                ");

                            }       
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                    
      out.write("    \n");
      out.write("                </select>\n");
      out.write("                <select class=\"form-control\" name=\"busto\">\n");
      out.write("                    <option name=\"thevalue\" value=\"0\">-Select Destination-</option>\n");
      out.write("                    \n");
      out.write("                    ");
 
                        try{
                            String query="SELECT DISTINCT bus_toid, bus_to FROM bus ORDER BY bus_to ASC";
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while (rs.next())
                            {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(rs.getInt("bus_toid"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("bus_to"));
      out.write("</option> \n");
      out.write("                                ");

                            }       
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                    
      out.write("    \n");
      out.write("                </select>\n");
      out.write("                <select class=\"form-control\" name=\"busdate\">\n");
      out.write("                    <option name=\"thevalue\" value=\"0\">-Select Date-</option>\n");
      out.write("                    \n");
      out.write("                    ");
 
                        try{
                            String query="SELECT DISTINCT bus_dateid, bus_date FROM bus ORDER BY bus_date ASC";
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while (rs.next())
                            {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(rs.getInt("bus_dateid"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("bus_date"));
      out.write("</option> \n");
      out.write("                                ");

                            }       
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                    
      out.write("    \n");
      out.write("                </select>\n");
      out.write("                <input type=\"submit\" value=\"Search Buses\" onClick=\"this.form.submit();\"/>\n");
      out.write("                <br/><br/>\n");
      out.write("                <table border=\"2\" align=\"center\" cellpadding=\"5\" cellspacing=\"6\" width=\"50%\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Bus ID</th>\n");
      out.write("                        <th>From</th>\n");
      out.write("                        <th>To</th>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Departure</th>\n");
      out.write("                        <th>Arrival</th>\n");
      out.write("                        <th>Price</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection con=DriverManager.getConnection(url, username, password);
                            Statement stm=con.createStatement();
                            
                            
                                ResultSet rset=stm.executeQuery("SELECT bus_id, bus_from, bus_to, bus_date, "
                                        + "bus_depart, bus_arrival, bus_price FROM bus WHERE bus_fromid"
                                        + " = " + Integer.parseInt(request.getParameter("busfrom")) + " AND "
                                                + "bus_toid = " + Integer.parseInt(request.getParameter("busto")) + " AND "
                                                        + "bus_dateid = " + Integer.parseInt(request.getParameter("busdate")));
                                while (rset.next())
                                {
                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>");
      out.print(rset.getInt("bus_id"));
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(rset.getString("bus_from"));
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(rset.getString("bus_to"));
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(rset.getDate("bus_date"));
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(rset.getTime("bus_depart"));
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(rset.getTime("bus_arrival"));
      out.write("</td>\n");
      out.write("                                        <td>£");
      out.print(rset.getDouble("bus_price"));
      out.write("</td>\n");
      out.write("                                        <td><element onclick=\"demo\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                    ");

                                }
                                rset.close();
                                con.close();
                            
                            
                        }
                        catch(Exception e)
                        {
                        e.printStackTrace();
                        out.println("Error " + e.getMessage());
                        }

                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("                <script>\n");
      out.write("document.getElementById(\"demo\").onclick = function() {myFunction()};\n");
      out.write("\n");
      out.write("function myFunction() {\n");
      out.write("    document.getElementById(\"demo\").innerHTML = \"YOU CLICKED ME!\";\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
