<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <h1 class="mb-4">Users request</h1>
            </div>
        </div>
    </div>
</div>  
             <c:if test="${sessionScope.ROLE ne 'admin'}">
        <c:redirect url="index.jsp"/>
    </c:if>
<div class="site-section site-section-sm">
    <div class="container">

        <div class="site-section bg-light">
            <c:if test="${requestScope.BOOKING_LIST != null}">
                <c:if test="${not empty requestScope.BOOKING_LIST}" var="chk">
                    ${param.txtName}'s request<br>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>NO</th>
                                <th>User ID</th>
                                <th>User name</th>
                                <th>Full name</th>
                                <th>Phone</th>
                                <th>Room ID</th>
                                <th>Room name</th>
                                <th>Room photo</th>
                                <th>Room Price</th>
                                <th>Book Date</th>
                                <th>Check in date</th>
                                <th>Check out date</th>
                                <th>Down payment</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <c:forEach items="${requestScope.BOOKING_LIST}" var="booking" varStatus="count"> 
                                    <td>${count.count}</td>
                                    <td>${booking.accountID}</td>

                                    <td>${booking.account.accountName}</td>
                                    <td>${booking.account.fullname}</td>
                                    <td>${booking.account.phone}</td>
                                    <td>${booking.room.roomID}</td>
                                    <td>${booking.room.roomName}</td>
                                    <td><img src="${booking.room.photo}" height="180" width="200"></td>
                                    <td>${booking.room.price}</td>
                                    <td>${booking.bookDate}</td>
                                    <td>${booking.checkInDate}</td>
                                    <td>${booking.checkOutDate}</td>
                                    <td>${booking.downPayment}</td>
                                    <td>${booking.total}</td>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>

                </c:if>
                <c:if test="${!chk}">
                    Account: ${param.txtName} has no booking request
                </c:if>
            </div>
        </div>
    </div>

</c:if>
<%@include file="footer.jsp" %>