<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <h1 class="mb-4">My Profile</h1>
            </div>
        </div>
    </div>
</div>  
<div class="site-section site-section-sm">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <h1 class="mb-4">My Profile</h1>
            </div>
        </div>
        <div class="site-section bg-light">

            <c:if test="${sessionScope.ID == null}">
                <c:redirect url="index.jsp"/>
            </c:if>
            <font color="blue" style="font-size:20px">${requestScope.STATUS}</font></h3><br>
            <form action="MainController">
                Account Name: ${requestScope.USER.accountName}<br>
                Fullname: ${requestScope.USER.fullname}<br>
                Age: ${requestScope.USER.age}<br>
                Phone: ${requestScope.USER.phone}<br>
                <input type="hidden" name="txtID" value="${requestScope.USER.accountID}">
                <input type="hidden" name="txtFullname" value="${requestScope.USER.fullname}">
                <input type="hidden" name="txtAge" value="${requestScope.USER.age}">
                <input type="hidden" name="txtPhone" value="${requestScope.USER.phone}">
                <input type="submit" name="action" value="Edit Profile">
                <input type="submit" name="action" value="Change Password">


            </form>

            <a href="index.jsp">Back to Main page</a>
        </div></div></div>
<%@include file="footer.jsp" %>