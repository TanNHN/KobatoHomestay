<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">My Rooms</h1>
            </div>
        </div>
    </div>
</div>

<div class="site-section bg-light">
    <c:if test="${sessionScope.ID == null}">
        <c:redirect url="index.jsp"/>
    </c:if>
    <c:if test="${requestScope.MY_ROOM != null}" var="chk1">
        <c:if test="${not empty requestScope.MY_ROOM}" var="chk">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Room ID</th>
                        <th>Room name</th>
                        <th>Photo</th>
                        <th>Book date</th>
                        <th>Check in date</th>
                        <th>Check out date</th>
                        <th>Down payment</th>
                        <th>Confirm</th>
                        <th>total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.MY_ROOM}" var="room" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${room.roomID}</td>
                            <td>${room.room.roomName}</td>
                            <td><img src="${room.room.photo}" width="200" height="180"></td>
                            <td>${room.bookDate}</td>
                            <td>${room.checkInDate}</td>
                            <td>${room.checkOutDate}</td>
                            <td>${room.downPayment}</td>
                            <c:if test="${room.status ne true}" var="stt">
                                <td><font color="red">not yet</font></td>
                                </c:if>
                                <c:if test="${!stt}">
                                <td><font color="blue">Confirmed</font></td>
                                </c:if>
                            <td>${room.total}</td>
                        </tr>
                        <c:if test="${room.status ne true}" var="stt">
                        <font color="red">Complete the final step to claim your room</font>
                    </c:if>

                </c:forEach>
                </tbody>

            </table>

        </c:if>
        <c:if test="${!chk}">
            You have no room
        </c:if>
    </c:if>
    <c:if test="${!chk1}">
        You have no booking
    </c:if>
</div>
<%@include file="footer.jsp" %>
