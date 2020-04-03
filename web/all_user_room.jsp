<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">Customer Booked Room</h1>
            </div>
        </div>
    </div>
</div>
 <c:if test="${sessionScope.ROLE ne 'admin'}">
        <c:redirect url="index.jsp"/>
    </c:if>
<div class="site-section bg-light">
    <c:if test="${not empty requestScope.ROOM_LIST}" var="chk">
        <table border="1">
            <thead>
                <tr>
                    <th>Booking ID</th>
                    <th>ROOM ID</th>
                    <th>Room Name</th>
                    <th>Room Photo</th>
                    <th>Account ID</th>
                    <th>Account Name</th>
                    <th>Full Name</th>
                    <th>Phone</th>
                    <th>Date started booking</th>
                    <th>Check in date</th>
                    <th>Check out </th>
                    <th>Down payment</th>
                    <th>Confirm</th>
                    <th>Total</th>
                    <th>Confirm request</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.ROOM_LIST}" var="book">
                    <tr>
                        <td align="center">${book.bookingID}</td>
                        <td align="center">${book.room.roomID}</td>
                        <td align="center">${book.room.roomName}</td>
                        <td align="center"><img src="${book.room.photo}" width="200" height="180" /></td>
                        <td align="center">${book.account.accountID}</td>
                        <td align="center">${book.account.accountName}</td>
                        <td align="center">${book.account.fullname}</td>
                        <td align="center">${book.account.phone}</td>
                        <td align="center">${book.bookDate}</td>
                        <td align="center">${book.checkInDate}</td>
                        <td align="center">${book.checkOutDate}</td>
                        <td align="center">${book.downPayment}</td>
                        <c:if test="${book.status ne true}" var="stt">
                            <td> <font color="red">not yet</font></td>
                            </c:if>
                            <c:if test="${!stt}">
                            <td> <font color="blue">Confirmed</font></td>
                            </c:if>
                        <td align="center">${book.total}</td>

                <form action="MainController" method="POST">
                    <td><input type="hidden" name="txtBookingID" value="${book.bookingID}">
                        <input type="hidden" name="txtRoomID" value="${book.roomID}">
                        <input type="submit" name="action" value="Check Out"></td>
                </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${!chk}">
        There no is not any request this time
    </c:if>
</div>
<%@include file="footer.jsp" %>