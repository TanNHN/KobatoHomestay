<%@include file="head.jsp" %>

<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">Homestay Rooms</h1>
            </div>
        </div>
    </div>
</div>  

<c:if test="${not empty requestScope.ROOM}" var="chk">
    <div class="site-section bg-light">
        <div class="row">
            <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                <h2 class="mb-5">Make reservation</h2>
            </div>
        </div>
        <center>
            <form action="MainController" method="post">
                <font color="red">${requestScope.STATUS}</font><br>
                <img src="${requestScope.ROOM.photo}" width="300" height="250"><br>
                <br>
                <font color="blue" size="6">${requestScope.ROOM.roomName}</font><br>
                <br>
                <font color="gray" size="4">${requestScope.ROOM.info}</font><br>
                <br>
                <font color="red" size="5">$${requestScope.ROOM.price} / per night</font><br>
                <br>
                <input type="hidden" name="txtRoomID" value="${requestScope.ROOM.roomID}">
                <input type="hidden" name="txtPrice" value="${requestScope.ROOM.price}">
                <c:if test="${requestScope.ROOM.status ne true}" var="isUsed">
                    <font color="red" size="5">This room is currently in used</font>
                </c:if>
                <c:if test="${!isUsed}">
                    Check in:
                    <input type="date" name="txtCheckIn" id="startDate" width="276" value="${param.txtCheckIn}"  /><br>
                    <font color="red>">${requestScope.INVALID.checkInError}</font><br>
                    Check out:
                    <input type="date" name="txtCheckOut" id="endDate" width="276" value="${param.txtCheckOut}" /><br>
                    <font color="red>">${requestScope.INVALID.checkOutError}</font><br>
                   <font color="red>">${requestScope.INVALID.dateDistanceError}</font> <br>
                    <br/>
                    <input type="submit" name="action" value="Add to Cart">
                </c:if>
            </form>
        </center>
    </div>
</c:if>
<c:if test="${!chk}">
    <c:redirect url="rooms.jsp"/>
</c:if>

<%@include file="footer.jsp" %>