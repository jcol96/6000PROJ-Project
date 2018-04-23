
<!DOCTYPE html>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
    <head>
        <title>Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">   
        <link rel="stylesheet" type="text/css" href="resources/css/cssLayout.css">
        <link rel="stylesheet" type="text/css" href="resources/css/default.css">
        <link rel="shortcut icon" type="image/png" href="resources/images/favicon.ico"/>
    </head>
    <body>
        <div id="nav" class="nav">
            <ul>
                <li><form><a href="index.xhtml" style="text-decoration:none;color:white">Home</a></form></li>
                <li><form><a href="flight.jsp" style="text-decoration:none;color:white">Flight</a></form></li>
                <li><form><a href="train.jsp" style="text-decoration:none;color:white">Train</a></form></li>
                <li><form><a href="bus.jsp" style="text-decoration:none;color:white">Bus</a></form></li>
                <li><form><a href="vehicle.xhtml" style="text-decoration:none;color:white">Vehicle Hire</a></form></li>
                <li><form><a href="city.xhtml" style="text-decoration:none;color:white">City information</a></form></li>
                <li><form><a href="locations.html" style="text-decoration:none;color:white">Locations</a></form></li>
                <li><form><a href="http://localhost:8080/XYZTravel/currency?Tester" style="text-decoration:none;color:white">Converter</a></form></li>
                <li><form><a href="about.xhtml" style="text-decoration:none;color:white">About</a></form></li>
                <li style="float:right"><form><a href="login.jsp" class="active" style="text-decoration:none;color:white;float:right;">Account</a></form></li>
            </ul>
        </div>
        <div id="top">
            <a href="index.xhtml"><img src="resources/images/banner-alt.png" alt="XYZ travel" height="150"></a>
        </div>
        <div id="content" class="left_content">            
            <h2>Admin</h2>
            <br/><br/>
            <h3>All registered XYZ Travel users</h3>
            <form method="post">
                <table class="logintable" border="2">
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Surname</th>
                        <th>Hometown</th>
                    </tr>
                    <%
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            String query="SELECT user_email, user_firstname, user_surname, user_hometown FROM users";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while(rs.next())
                            {
                                
                    %>
                    
                    <tr><td><%=rs.getString("user_email") %></td>
                        <td><%=rs.getString("user_firstname") %></td>
                        <td><%=rs.getString("user_surname") %></td>
                        <td><%=rs.getString("user_hometown") %></td></tr>
                     <%
                         }
                     %>
                </table>
                <%
                    rs.close();
                    stmt.close();
                    conn.close();}
catch(Exception e)
{
e.printStackTrace();
}
                %>
            </form>
            <h3>All registered XYZ Travel administrators</h3>
            <form method="post">
                <table class="logintable" border="2">
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Surname</th>
                    </tr>
                    <%
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            String query="SELECT admin_email, admin_firstname, admin_surname FROM admin";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while(rs.next())
                            {
                                
                    %>
                    
                    <tr><td><%=rs.getString("admin_email") %></td>
                        <td><%=rs.getString("admin_firstname") %></td>
                        <td><%=rs.getString("admin_surname") %></td></tr>
                     <%
                         }
                     %>
                </table>
                <%
                    rs.close();
                    stmt.close();
                    conn.close();}
catch(Exception e)
{
e.printStackTrace();
}
                %>
            </form>
        </div>
    </body>
</html>
