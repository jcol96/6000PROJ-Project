package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class busresults_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
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
      out.write("                <li><form><a href=\"flight.xhtml\" style=\"text-decoration:none;color:white\">Flight</a></form></li>\n");
      out.write("                <li><form><a href=\"train.xhtml\" style=\"text-decoration:none;color:white\">Train</a></form></li>\n");
      out.write("                <li><form><a href=\"bus.xhtml\" style=\"text-decoration:none;color:white\">Bus</a></form></li>\n");
      out.write("                <li><form><a href=\"vehicle.xhtml\" style=\"text-decoration:none;color:white\">Vehicle Hire</a></form></li>\n");
      out.write("                <li><form><a href=\"city.xhtml\" style=\"text-decoration:none;color:white\">City information</a></form></li>\n");
      out.write("                <li><form><a href=\"locations.html\" style=\"text-decoration:none;color:white\">Locations</a></form></li>\n");
      out.write("                <li style=\"float:right\"><form><a href=\"login.jsp\" class=\"active\" style=\"text-decoration:none;color:white;float:right;\">Account</a></form></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"top\">\n");
      out.write("            <a href=\"index.xhtml\"><img src=\"resources/images/banner-alt.png\" alt=\"XYZ travel\" height=\"150\"></a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"content\" class=\"left_content\">            \n");
      out.write("            <h2>Buses</h2>\n");
      out.write("            <br/><br/>\n");
      out.write("            <form action=\"\" method=\"post\"> \n");
      out.write("                    <h3 style=\"color:#BCBCBC\">Search Buses</h3>\n");
      out.write("                    <table border=\"2\" align=\"center\" cellpadding=\"5\" cellspacing=\"6\" width=\"50%\">          \n");
      out.write("                        <tr>\n");
      out.write("                            <th align=\"center\" bgcolor=\"indigo\"style=\"color:white\" colspan=\"6\"><h1>Multiple Dropdown list with MySQL</h1></th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th align=\"right\">From:</th>\n");
      out.write("                            <td>\n");
      out.write("                                <select>\n");
      out.write("                                    <option value=\"-1\">-Select From-</option>\n");
      out.write("\n");
 
    try{
       String query="SELECT DISTINCT bus_fromid, bus_from FROM bus";
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
      out.write("             <option value=\"");
      out.print(rs.getInt("bus_fromid"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("bus_from"));
      out.write("</option> \n");
      out.write("           ");

       }        
}
    catch(Exception e)
    {
        e.printStackTrace();
        out.println("Error " + e.getMessage());
    }

      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th align=\"right\">To:</th>\n");
      out.write("                            <td><select>\n");
      out.write("                                    <option value=\"-1\">-Select Destination-</option>\n");
      out.write("\n");
 
    try{
       String query="SELECT * FROM bus";
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
      out.write("             <option value=\"");
      out.print(rs.getInt("bus_toid"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("bus_to"));
      out.write("</option> \n");
      out.write("           ");

       }        
}
    catch(Exception e)
    {
        e.printStackTrace();
        out.println("Error " + e.getMessage());
    }

      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            </td>\n");
      out.write("                            <tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th align=\"right\">Date:</th>\n");
      out.write("                            <td>\n");
      out.write("                                <select>\n");
      out.write("                                    <option value=\"-1\">-Select Date-</option>\n");
      out.write("\n");
 
    try{
       String query="SELECT * FROM bus";
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
      out.write("             <option value=\"");
      out.print(rs.getInt("bud_dateid"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("bus_date"));
      out.write("</option> \n");
      out.write("           ");

       }        
}
    catch(Exception e)
    {
        e.printStackTrace();
        out.println("Error " + e.getMessage());
    }

      out.write("\n");
      out.write("    \n");
      out.write("</tr>\n");
      out.write("                        </tr>\n");
      out.write("                                </select></td>\n");
      out.write("                                </table>\n");
      out.write("                                <input type=\"submit\" value=\"Search Book\" />\n");
      out.write("\n");
      out.write("                        \n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("           \n");
      out.write("           \n");
      out.write("        \n");
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
