<%-- 
    Document   : user_room_book
    Created on : Dec 11, 2019, 11:25:41 AM
    Author     : Tan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <c:if test="${sessionScope.ROLE ne 'admin'}">
        <c:redirect url="index.jsp"/>
    </c:if>
    <body>
        <c:if test="${requestScope.BOOK_LIST !=null}">
            <c:if test="${not empty requestScope.BOOK_LIST}" var="chk">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>Account ID</th>
                            <th>Account Name</th>
                            <th>Room ID</th>
                            <th>Room Name</th>
                            <th>Photo</th>
                            <th>Price</th>
                            <th>Book Date</th>
                            <th>Check In</th>
                            <th>Check Out</th>

                            <th>Down payment</th>
                            <th>Total</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.BOOK_LIST}" var="book" varStatus="count">
                            <tr>
                                <td>${count.count}</td>
                                <td>${book.bookingID}</td>
                                <td>${book.account.accountName}</td>
                                <td>${book.roomID}</td>
                                <td>${book.room.roomName}</td>
                                <td><img src="${book.room.photo}" width="200" height="180"></td>
                                <td>${book.room.price}</td>
                                <td>${book.bookDate}</td>
                                <td>${book.checkInDate}</td>
                                <td>${book.checkOutDate}</td>
                                <td>${book.downPayment}</td>

                                <td>${book.total}</td>
                                <c:if test="${book.status ne true}" var="stt">
                                    <td><font color="red">not yet</font></td>
                                    </c:if>
                                    <c:if test="${!stt}">
                                    <td><font color="blue">Confirmed</font></td>
                                    </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!chk}">
                This user doesn't have any booking
            </c:if>
        </c:if>
                <a href="MainController?action=Search&txtSearch=${param.txtSearch}">Back to search Page</a>
    </body>
</html>
