<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <h1 class="mb-4">Create Room</h1>
            </div>
        </div>
    </div>
</div>  


<div class="site-section site-section-sm">
    <div class="container">
        <div class="row">

            <div class="col-md-12 col-lg-8 mb-5">

                <c:if test="${sessionScope.ROLE ne 'admin'}">
                    <c:redirect url="index.jsp"/>
                </c:if>

                <form action="MainController" method="POST" class=" bg-white">
                    <br>RoomID: <input class="text-black" style="border-color: black" type="text" name="txtID" value="${param.txtID}"  >  (Example:r(number))<br>
                    <font color="red">${requestScope.INVALID.roomIdERROR}</font><br>
                    <br>RoomName: <input class="text-black" style="border-color: black" type="text" name="txtName" value="${param.txtName}" placeholder="Room name"><br>
                    <font color="red">${requestScope.INVALID.roomNameERROR}</font><br>
                    <br>RoomPrice: <input class="text-black" style="border-color: black" type="text" name="txtPrice" value="${param.txtPrice}" placeholder="$/ day"><br>
                    <font color="red">${requestScope.INVALID.roomPriceError}</font><br>
                    <br>RoomInfo: <input class="text-black" style="border-color: black" type="text" name="txtInfo" value="${param.txtInfo}" placeholder="Room info"><br>
                    <font color="red">${requestScope.INVALID.roomInfoError}</font><br>
                    <br>Room Photo:<input class="text-black" style="border-color: black" type="text" name="txtPhoto" value="images/" placeholder="Room Photo"><br>
                    <font color="red">${requestScope.INVALID.roomPhotoError}</font><br>
                    <br>Note: copy your image to '\HomestayBooking\web\images' and input your image name(ex: images/*YOUR IMAGE*)<br>
                    Room Category: <select name="slCate">
                        <option value="cr1">Single Room</option>
                        <option value="cr2">Four People Room</option>
                        <option value="cr3">Family Room</option>
                        <option value="cr4">Deluxe Room</option>
                    </select>
                    <input type="submit" name="action" value="Create Room">
                </form>
            </div>
        </div>
    </div>
</div>



<%@include file="footer.jsp" %>