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

<div class="site-section bg-light">
    <div class="container">

        <div class="row">
            <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                <h2 class="mb-5">Our Rooms</h2>
            </div>
        </div>
        <div class="row">
            <c:if test="${requestScope.ROOM_LIST == null}" var="chkRequest">
                <c:redirect url="ShowAllRoomController"/>
            </c:if>
            <c:if test="${!chkRequest}">
                <c:forEach items="${requestScope.ROOM_LIST}" var="room">

                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="hotel-room text-center">
                            <a href="#" class="d-block mb-0 thumbnail"><img src="${room.photo}" alt="Image" class="img-fluid"></a>
                            <div class="hotel-room-body">
                                <h3 class="heading mb-0"><a href="#">${room.roomName}</a></h3>
                                <strong class="price">$${room.price} / per night</strong>
                                <br><font color="gray">${room.info}</font>
                                <c:if test="${room.status == true}" var="avai">
                                    <br><font color="blue">Available</font>
                                </c:if>
                                <c:if test="${!avai}">
                                    <br><font color="red">Not Available</font>
                                </c:if>
                                <form action="MainController" method="post">       
                                    <input type="hidden" name="txtRoomID" value="${room.roomID}">
                                    <input type="submit" name="action" value="Room Detail">
                                </form>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>




<%@include file="footer.jsp" %>