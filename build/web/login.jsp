<%-- 
    Document   : login
    Created on : Nov 29, 2019, 12:10:06 AM
    Author     : Tan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Login Screen</title>
        <link rel="stylesheet" type="text/css" href="css/style1.css">

        <script>
            window.console = window.console || function (t) {};
            window.open = function () {
                console.log('window.open is disabled.');
            };
            window.print = function () {
                console.log('window.print is disabled.');
            };
            if (false) {
                window.ontouchstart = function () {};
            }
        </script>

    </head>

    <body>
        <div class="wrapper">
            <div class="container">
                <c:if test="${sessionScope.USER != null} ">
                    <c:redirect url="index.jsp"/>
                </c:if>
                <h1><font color="white">Welcome</font></h1>
                    ${requestScope.REGIST_STATUS}
                <form action="MainController" method="post">
                    <input type="text" name="txtUsername" placeholder="Username" value="${param.txtUsername}" />
                    <font color="white">${requestScope.INVALID.usernameError}</font>
                    <input type="password" name="txtPassword" placeholder="Password"/>
                    <font color="white">${requestScope.INVALID.passwordError}</font>
                    <input type="submit"  name="action" value="Login">
                    or 
                    <input type="submit"  name="action" value="Register">
                    <a href="index.jsp"><font color='white'><u>Back to main page</u></font></a>
                </form>
            </div>

            <!--- for more background effect, just  delete this comment line, thank you
            
            <ul class="bg-bubbles">
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
            
            -->
        </div>

        <script src='js/jquery.js'></script>
        <script>
            if (document.location.search.match(/type=embed/gi)) {
                window.parent.postMessage('resize', "*");
            }
        </script>

        <script src="js/timeout.js"></script>
        <script>
            $('#login-button').click(function (event) {
                event.preventDefault();
                $('form').fadeOut(800);
                $('.wrapper').addClass('form-success');
            });

        </script>

    </body>

</html>

