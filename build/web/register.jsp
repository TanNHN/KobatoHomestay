<%-- 
    Document   : register
    Created on : Dec 2, 2019, 11:22:38 AM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SIGN UP</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //Custom Theme files -->
        <!-- web font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- //web font -->
    </head>
    <body>
        <!-- main -->
        <div class="main-w3layouts wrapper">
            <h1>Sign Up</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form action="MainController" method="post">
                        <input class="text" type="text" name="txtAccountname" placeholder="Username" value="${param.txtAccountname}">
                        <font color="pink">${requestScope.INVALID.usernameError}</font><br>
                        <input class="text" type="password" name="txtPassword" placeholder="Password">
                        <font color="pink">${requestScope.INVALID.passwordError}</font>  

                        <input class="text w3lpass" type="password" name="txtConfirmPassword" placeholder="Confirm Password" >
                        <font color="pink">${requestScope.INVALID.confirmPassword}  </font>  

                        <input class="text" type="text" name="txtFullName" placeholder="Fullname" value="${param.txtFullName}">
                        <font color="pink">${requestScope.INVALID.fullNameError}   </font>  <br>

                        <input class="text" type="text" name="txtPhone" placeholder="Phone" value="${param.txtPhone}"><br>
                        <font color="pink">${requestScope.INVALID.phoneError}   </font>  

                        <input class="text" type="text" name="txtAge" placeholder="Age" value="${param.txtAge}">
                        <font color="pink">${requestScope.INVALID.ageError}   </font>  <br>
                        <div class="wthree-text">
                            <label class="anim">
                                <input type="checkbox" class="checkbox" required="">
                                <span>I Agree To The Terms & Conditions</span>
                            </label>
                            <div class="clear"> </div>
                        </div>
                        <input type="submit" name="action" value="SIGNUP">
                    </form>
                    <p>Already have an Account? <a href="login.jsp"> Login Now!</a></p>
                </div>
            </div>
            <!-- copyright -->
            <div class="colorlibcopy-agile">
                <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>
            </div>
            <!-- //copyright -->
            <ul class="colorlib-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <!-- //main -->
    </body>
</html>
