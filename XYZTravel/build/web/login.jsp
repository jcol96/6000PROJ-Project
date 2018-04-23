<!DOCTYPE html>
<html>
    <head>
        <title>Login/Register</title>
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
                <li><form><a href="city.xhtml" style="text-decoration:none;color:white">City Information</a></form></li>
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
            
            <h2>Login/Register</h2>
            <br/><br/>
            <div id="loginContainer">
                <form action="login" method="post" id="loginPage"> 
                    <h3 style="color:#BCBCBC">Login</h3>
                    <div>
                        <input type="text" placeholder="E-mail Address" required="" id="username" name="email"/>
                    </div>
                    <div>
                        <input type="password" placeholder="Password" required="" id="password" name="password"/>
                    </div>
                    <div>
                        <input type="submit" value="Log in" /><br/>
                        <a href="#">Lost your password?</a><br>
                    </div>
                </form>
            </div>
            <div id="regContainer">
                <form action="register" method="post" id="loginPage"> 
                    <h3 style="color:#BCBCBC">Register</h3>
                    <input type="text" placeholder="Email Address" required="" class="normalForm" name="email"/>
                    <input type="password" placeholder="Password" required="" class="normalForm" name="password"/>
                    <input type="text" placeholder="First Name" required="" class="normalForm" name="firstname"/>
                    <input type="text" placeholder="Surname" required="" class="normalForm" name="surname"/>
                    <input type="text" placeholder="Hometown" required="" class="normalForm" name="hometown"/>
                    <div id="registerSubmit" >                          
                        <input type="submit" value="Register" />
                    </div>
                </form>
            </div>
            <br/><br/>
            <div id="adminContainer">
                <form action="admin" method="post" id="loginPage"> 
                    <h3 style="color:#BCBCBC">Admin</h3>
                    <div>
                        <input type="text" placeholder="E-mail Address" required="" id="username" name="adminemail"/>
                    </div>
                    <div>
                        <input type="password" placeholder="Password" required="" id="password" name="adminpassword"/>
                    </div>
                    <div>
                        <input type="submit" value="Log in" /><br/>
                    </div>
                </form>
            </div>
            <br/>
        </div>
    </body>
</html>
