<%@include file="head.jsp" %>

<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">Manage Rooms</h1>
            </div>
        </div>
    </div>
</div>  
<div class="container">

    <div class="row">
        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
            <h2 class="mb-5">Manage Rooms</h2>
        </div>
    </div>
    <div class="container">
        <div class="site-navbar bg-light">
            <div class="py-1">
                <div class="row align-items-center">
                    <div class="col-10">
                        <nav class="site-navigation text-left" role="navigation">
                            <div class="container">

                                <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                <ul class="site-menu js-clone-nav d-none d-lg-block">

                                    <li class="has-children">
                                        <a href="MainController?action=ShowAllRoomWithStatus&txtStatus=1">Available Room</a>
                                        <ul class="dropdown arrow-top" >
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr1&txtStatus=1">Single Room</a></li>
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr2&txtStatus=1">Four people Room</a></li>
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr3&txtStatus=1">Family Room</a></li>
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr4&txtStatus=1">Deluxe Room</a></li>
                                        </ul>
                                    </li>
                                    <li class="has-children">
                                        <a href="MainController?action=ShowAllRoomWithStatus&txtStatus=0">Not Available Room</a>
                                        <ul class="dropdown arrow-top">
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr1&txtStatus=0">Single Room</a></li>
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr2&txtStatus=0">Four people Room</a></li>
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr3&txtStatus=0">Family Room</a></li>
                                            <li><a href="MainController?action=GetRoomFromCategoryWithStatus&txtCateID=cr4&txtStatus=0">Deluxe Room</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="create_room.jsp">Add new room</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <c:if test="${sessionScope.ROLE ne 'admin'}">
        <c:redirect url="index.jsp"/>
    </c:if>
    <div class="site-section bg-light">
        <div class="container">
            <div class="row">
                <c:if test="${not empty requestScope.ADMIN_ROOM_LIST}" var="chk">
                    <c:forEach items="${requestScope.ADMIN_ROOM_LIST}" var="room">
                        <div class="col-md-6 col-lg-4 mb-5">
                            <div class="hotel-room text-center">
                                <a href="#" class="d-block mb-0 thumbnail"><img src="${room.photo}" alt="Image" class="img-fluid"></a>
                                <div class="hotel-room-body">
                                    <h3 class="heading mb-0"><a href="#">${room.roomName}</a></h3>
                                    <strong class="price">$${room.price} / per night</strong>
                                    <br><font color="gray">${room.info}</font>
                                    <c:if test="${room.status == true}" var="avai">
                                        <br><font color="blue">Available</font>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="txtRoomCateID" value="${room.roomCategory}">
                                            <input type="hidden" name="txtRoomID" value="${room.roomID}">
                                            <input type="hidden" name="txtRoomName" value="${room.roomName}">
                                            <input type="hidden" name="txtPrice" value="${room.price}">
                                            <input type="hidden" name="txtStatus" value="${room.status}">
                                            <input type="hidden" name="txtInfo" value="${room.info}">
                                            <input type="hidden" name="txtPhoto" value="${room.photo}">
                                            <input type="submit" name="action" value="Edit Room">
                                            <input type="submit" name="action" value="Delete Room">
                                        </form>

                                    </c:if>
                                    <c:if test="${!avai}">
                                        <br><font color="red">Not Available</font>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!chk}">
                    <font size="40" >No Room</font> 
                </c:if>
            </div></div></div></div>


<%@include file="footer.jsp" %>