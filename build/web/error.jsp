<%-- 
    Document   : error
    Created on : Dec 4, 2019, 10:13:51 AM
    Author     : Tan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <font color="red"><h1>${requestScope.ERROR}</h1></font>
        <br>
        <a href="index.jsp">BACK TO MAIN PAGE</a>
    </body>
</html>
