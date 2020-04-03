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
                <h1 class="mb-4">Edit Profile</h1>
            </div>
        </div>
        <div class="site-section bg-light">
            <c:if test="${sessionScope.ID == null}">
                <c:redirect url="index.jsp"/>
            </c:if>
            Change Profile:<br>
            <form action="MainController">
                Fullname: <input class="text-black" style="border-color: black" type="text" name="txtFullname" value="${param.txtFullname}"><br>
                Age: <input class="text-black" style="border-color: black" type="text" name="txtAge" value="${param.txtAge}"><br>
                Phone: <input class="text-black" style="border-color: black" type="text" name="txtPhone" value="${param.txtPhone}"><br>
                <input type="hidden" name="txtID" value="${param.txtID}">
                <input class="text-black" style="border-color: black" type="submit" name="action" value="Update Profile"><br>
                <a href="MainController?action=ViewProfile"><input type="button" value="Cancel"></a>
            </form>
            <c:if test="${not empty requestScope.INVALID}"> 
                <h3>Your update action is invalid:</h3><br>
                <font color="red">${requestScope.INVALID.fullNameError}</font> <br>
                <font color="red">${requestScope.INVALID.confirmPassword}</font> <br>
                <font color="red">${requestScope.INVALID.ageError}</font> <br>
                <font color="red">${requestScope.INVALID.phoneError}</font> <br>
            </c:if>
        </div></div></div>
<%@include file="footer.jsp" %>