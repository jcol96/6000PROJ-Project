package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login/Register</title>\n");
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
      out.write("                <li><form><a href=\"city.xhtml\" style=\"text-decoration:none;color:white\">City Information</a></form></li>\n");
      out.write("                <li><form><a href=\"locations.html\" style=\"text-decoration:none;color:white\">Locations</a></form></li>\n");
      out.write("                <li><form><a href=\"about.xhtml\" style=\"text-decoration:none;color:white\">About</a></form></li>\n");
      out.write("                <li style=\"float:right\"><form><a href=\"login.jsp\" class=\"active\" style=\"text-decoration:none;color:white;float:right;\">Account</a></form></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"top\">\n");
      out.write("            <a href=\"index.xhtml\"><img src=\"resources/images/banner-alt.png\" alt=\"XYZ travel\" height=\"150\"></a>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"content\" class=\"left_content\">\n");
      out.write("            \n");
      out.write("            <h2>Login/Register</h2>\n");
      out.write("            <br/><br/>\n");
      out.write("            <div id=\"loginContainer\">\n");
      out.write("                <form action=\"login\" method=\"post\" id=\"loginPage\"> \n");
      out.write("                    <h3 style=\"color:#BCBCBC\">Login</h3>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"text\" placeholder=\"E-mail Address\" required=\"\" id=\"username\" name=\"email\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"password\" placeholder=\"Password\" required=\"\" id=\"password\" name=\"password\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"submit\" value=\"Log in\" /><br/>\n");
      out.write("                        <a href=\"#\">Lost your password?</a><br>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"regContainer\">\n");
      out.write("                <form action=\"register\" method=\"post\" id=\"loginPage\"> \n");
      out.write("                    <h3 style=\"color:#BCBCBC\">Register</h3>\n");
      out.write("                    <input type=\"text\" placeholder=\"Email Address\" required=\"\" class=\"normalForm\" name=\"email\"/>\n");
      out.write("                    <input type=\"password\" placeholder=\"Password\" required=\"\" class=\"normalForm\" name=\"password\"/>\n");
      out.write("                    <input type=\"text\" placeholder=\"First Name\" required=\"\" class=\"normalForm\" name=\"firstname\"/>\n");
      out.write("                    <input type=\"text\" placeholder=\"Surname\" required=\"\" class=\"normalForm\" name=\"surname\"/>\n");
      out.write("                    <input type=\"text\" placeholder=\"Hometown\" required=\"\" class=\"normalForm\" name=\"hometown\"/>\n");
      out.write("                    <div id=\"registerSubmit\" >                          \n");
      out.write("                        <input type=\"submit\" value=\"Register\" />\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <br/><br/>\n");
      out.write("            <div id=\"adminContainer\">\n");
      out.write("                <form action=\"admin\" method=\"post\" id=\"loginPage\"> \n");
      out.write("                    <h3 style=\"color:#BCBCBC\">Admin</h3>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"text\" placeholder=\"E-mail Address\" required=\"\" id=\"username\" name=\"adminemail\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"password\" placeholder=\"Password\" required=\"\" id=\"password\" name=\"adminpassword\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"submit\" value=\"Log in\" /><br/>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
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
