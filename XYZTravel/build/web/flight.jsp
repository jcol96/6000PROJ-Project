<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
    <head>
        <title>Flights</title>
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
            <h2>Flights</h2>
            <p>Click <a href="flight.xhtml">here</a> to see all available flights with XYZ Travel</p>
            <p>Booking page did not load? Click <a href="booking.xhtml">here</a></p>
            <br/>
            <form action="flight.jsp" method="post"> 
                
                <h3>Search Flights</h3>
                <select class="form-control" name="flightfrom">
                    <option name="thevalue" value="0">-Select From-</option>
                    
                    <% 
                        try{
                            String query="SELECT DISTINCT flight_fromid, flight_from FROM flight ORDER BY flight_from ASC";
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while (rs.next())
                            {
                                %>
                                <option value="<%=rs.getInt("flight_fromid")%>"><%=rs.getString("flight_from")%></option> 
                                <%
                            }       
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                    %>    
                </select>
                <select class="form-control" name="flightto">
                    <option name="thevalue" value="0">-Select Destination-</option>
                    
                    <% 
                        try{
                            String query="SELECT DISTINCT flight_toid, flight_to FROM flight ORDER BY flight_to ASC";
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while (rs.next())
                            {
                                %>
                                <option value="<%=rs.getInt("flight_toid")%>"><%=rs.getString("flight_to")%></option> 
                                <%
                            }       
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                    %>    
                </select>
                <select class="form-control" name="flightdate">
                    <option name="thevalue" value="0">-Select Date-</option>
                    
                    <% 
                        try{
                            String query="SELECT DISTINCT flight_dateid, flight_date FROM flight ORDER BY flight_date ASC; ";
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection conn=DriverManager.getConnection(url, username, password);
                            Statement stmt=conn.createStatement();
                            ResultSet rs=stmt.executeQuery(query);
                            while (rs.next())
                            {
                                %>
                                <option value="<%=rs.getInt("flight_dateid")%>"><%=rs.getString("flight_date")%></option> 
                                <%
                            }       
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                    %>    
                </select>
                <input type="submit" value="Search Flights" onClick="this.form.submit();"/>
                <br/><br/>
                <table class="bookingtable" border="2" align="center" cellpadding="5" cellspacing="6" width="50%">
                    <tr>
                        <th>Flight ID</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Date</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Price</th>
                    </tr>
                    <%
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                            String username="cmpjcol1";
                            String password="password";
                            Connection con=DriverManager.getConnection(url, username, password);
                            Statement stm=con.createStatement();
                            
                            
                                ResultSet rset=stm.executeQuery("SELECT flight_id, flight_from, flight_to, flight_date, "
                                        + "flight_depart, flight_arrival, flight_price FROM flight WHERE flight_fromid"
                                        + " = " + Integer.parseInt(request.getParameter("flightfrom")) + " AND "
                                                + "flight_toid = " + Integer.parseInt(request.getParameter("flightto")) + " AND "
                                                        + "flight_dateid = " + Integer.parseInt(request.getParameter("flightdate")));
                                while (rset.next())
                                {
                    %>
                                        <td><%=rset.getInt("flight_id")%></td>
                                        <td><%=rset.getString("flight_from")%></td>
                                        <td><%=rset.getString("flight_to")%></td>
                                        <td><%=rset.getDate("flight_date")%></td>
                                        <td><%=rset.getTime("flight_depart")%></td>
                                        <td><%=rset.getTime("flight_arrival")%></td>
                                        <td>£<%=rset.getDouble("flight_price")%></td>
                                        <td><button onclick="if (! confirm('Please take note of the Bus ID, you will need this next')) return false" 
                                       value="Book" 
                                       href= "booking.xhtml">Book
                                            </button></td>
                                    </tr>
                    <%
                                }
                                rset.close();
                                con.close();
                            
                            
                        }
                        catch(Exception e)
                        {
                        e.printStackTrace();
                        out.println("Error " + e.getMessage());
                        }

                    %>
                </table>
            </form>
        </div>
    </body>
</html>
