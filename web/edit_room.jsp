<%@include file="head.jsp" %>

<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">Edit Rooms</h1>
            </div>
        </div>
    </div>
</div>  
<c:if test="${sessionScope.ROLE ne 'admin'}">
    <c:redirect url="index.jsp"/>
</c:if>
<div class="site-section bg-light">
    <div class="row">
        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
            <h2 class="mb-5">Room Editor</h2>
        </div>
    </div>
    <center>
        <form action="MainController" method="POST">
            <h3>Room ID: ${param.txtRoomID}</h3><br>
            <img src="${param.txtPhoto}" width="400" height="380"><br>
            Room Name: <input style="border-color: black" class="text-black" type="text" name="txtRoomName" value="${param.txtRoomName}">
            <font color="red">${requestScope.INVALID.roomNameERROR}</font><br>
            Room Price: <input style="border-color: black" class="text-black" type="text" name="txtPrice" value="${param.txtPrice}">
            <font color="red">${requestScope.INVALID.roomPriceError}</font><br>
            Room Info:<input style="border-color: black" class="text-black" type="text" name="txtInfo" value="${param.txtInfo}">
            <font color="red">${requestScope.INVALID.roomInfoError}</font><br>
            <br>
            Room Category: <select name="slCate">
                <option value="">Select one</option>
                <option value="cr1">Single Room</option>
                <option value="cr2">Four People Room</option>
                <option value="cr3">Family Room</option>
                <option value="cr4">Deluxe Room</option>
            </select><br>
            <font color="red">${requestScope.INVALID.roomCateError}</font><br>
            <input type="submit" value="Edit This Room" name="action">
            <input type="hidden" name="txtRoomID" value="${param.txtRoomID}" >
            <input type="hidden" name="txtPhoto" value="${param.txtPhoto}">
        </form>
        <a href="">
</div>
<%@include file="footer.jsp"%>