<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">My Bookings</h1>
            </div>
        </div>
    </div>
</div>

<div class="site-section bg-light">
    <c:if test="${sessionScope.ID == null}">
        <c:redirect url="index.jsp"/>
    </c:if>
    <c:if test="${requestScope.BOOKING_LIST != null}">
        <c:if test="${not empty requestScope.BOOKING_LIST}" var="chk">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Booking ID</th>
                        <th>Room ID</th>
                        <th>Room name</th>
                        <th>Photo</th>
                        <th>Book date</th>
                        <th>Check in date</th>
                        <th>Check out date</th>
                        <th>Down payment</th>
                        <th>Confirm</th>
                        <th>total</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.BOOKING_LIST}" var="book" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${book.bookingID}</td>
                            <td>${book.roomID}</td>
                            <td>${book.room.roomName}</td>
                            <td><img src="${book.room.photo}" width="200" height="180"></td>
                            <td>${book.bookDate}</td>
                            <td>${book.checkInDate}</td>
                            <td>${book.checkOutDate}</td>
                            <td>${book.downPayment}</td>
                            <c:if test="${book.status ne true}" var="stt">
                                <td><font color="red">not yet</font></td>
                                </c:if>
                                <c:if test="${!stt}">
                                <td><font color="blue">Confirmed</font></td>
                                </c:if>
                            <td>${book.total}</td>
                    <form action="MainController" method="post" >
                        <td>
                            <input type="hidden" name="txtBookingID" value="${book.bookingID}">
                            <input type="hidden" name="txtRoomID" value="${book.roomID}">
                            <input type="submit" name="action" value="Cancel"></td>
                    </form>
                    </tr>

                </c:forEach>
                </tbody>

            </table>
            <font color="red">*Your booking request has been send to the admin. We will lock the room you booked for a short period time to confirm your request. To claim your room, please pay your down payment. Contact us <u><a href="contact.jsp">here</a></u> </font>
            </c:if>
        </c:if>
        <c:if test="${!chk}">
        You have no booking
    </c:if>
</div>
<%@include file="footer.jsp" %>
