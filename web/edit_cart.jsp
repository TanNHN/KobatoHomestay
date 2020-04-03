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
    <div class="row">
        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
            <h2 class="mb-5">Change Date</h2>
        </div>
    </div>
    <center>
        <img src="${param.txtPhoto}" width="300" height="280"><br>
        Room name: ${param.txtName}<br>
        <form action="MainController" method="post">
            <input type="hidden" name="txtPhoto" value="${param.txtPhoto}">
            <input type="hidden" name="txtRoomID" value="${param.txtRoomID}">
            <input type="hidden"name="txtPrice" value="${param.txtPrice}"><font color="red">$${param.txtPrice}/day</font><br>
            Check In: <input type="date" name="txtCheckIn" id="startDate" width="200" value="${param.txtCheckIn}" /><br>
            <font color="red>">${requestScope.INVALID.checkInError}</font><br>
            Check out:<input type="date" name="txtCheckOut" id="endDate" width="200" value="${param.txtCheckOut}"/><br>
            <font color="red>">${requestScope.INVALID.checkOutError}</font><br>
            <font color="red>">${requestScope.INVALID.dateDistanceError}</font> <br>

            <input type="submit" name="action" value="Confirm change"><br>
        </form>



        <a href="view_cart.jsp">Back to your Cart</a>
    </center>
</div>
<%@include file="footer.jsp" %>