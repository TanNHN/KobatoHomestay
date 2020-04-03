<%@include file="head.jsp"%>

<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">Your Cart</h1>
            </div>
        </div>
    </div>
</div>
<c:if test="${sessionScope.ID == null}">
    <c:redirect url="index.jsp"/>
</c:if>
<div class="site-section bg-light">
    <c:if test="${not empty sessionScope != null}">
        <c:if test="${not empty sessionScope.CART.cart}" var="chk">
            <br>
            <table border="1" bordercolor="#ff0000">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Room Name</th>
                        <th>Photo</th>
                        <th>Price</th>
                        <th>Book Date</th>
                        <th>Check In date</th>
                        <th>Check Out date</th>
                        <th>Down Payment</th>
                        <th>Total</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        <th>Confirm</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${sessionScope.CART.cart.values()}" var="book" varStatus="count">
                        <tr>
                    <form action="MainController" method="post">
                        <td>${count.count}</td>
                        <td><input type="hidden" name="txtName" value="${book.room.roomName}">${book.room.roomName}</td>
                        <td><img src="${book.room.photo}" height="180" width="200"></td>
                        <td><input type="hidden" name="txtPrice" value="${book.room.price}">${book.room.price}</td>
                        <td>${book.bookDate}</td>
                        <td><input type="hidden" name="txtCheckIn" value="${book.checkInDate}" />${book.checkInDate}</td>
                        <font color="red>">${requestScope.INVALID.checkInError}</font><br>
                        <td><input type="hidden" name="txtCheckOut"value="${book.checkOutDate}"/>${book.checkOutDate}</td>
                        <font color="red>">${requestScope.INVALID.checkOutError}</font><br>
                        <font color="red>">${requestScope.INVALID.dateDistanceError}</font> <br>
                        <td>${book.downPayment}</td>
                        <td>${book.total}</td>
                        <input type="hidden" name="txtPhoto" value="${book.room.photo}">
                        <input type="hidden" name="txtRoomID" value="${book.roomID}">
                        <td><input type="submit" name="action" value="Change Date"></td>
                        <td><input type="submit" value="Delete" name="action"></td>
                        <td><input type="submit" name="action" value="Book Room"></td>
                    </form>
                    </tr>


                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${!chk}">
            Your Cart is empty
        </c:if>


    </c:if>
</div>




<%@include file="footer.jsp" %>