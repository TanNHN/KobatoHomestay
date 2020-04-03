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
                <h1 class="mb-4">Change Password</h1>
            </div>
        </div>
        <div class="site-section bg-light">
            <c:if test="${sessionScope.ID == null}">
                <c:redirect url="index.jsp"/>
            </c:if>
            <form action="MainController">
                Your current password:<input class="text-black" style="border-color: black" type="password" name="txtPassword"><br>
                <font color="red">${requestScope.INVALID.passwordError}</font><br>
                New Password: <input class="text-black" style="border-color: black" type="password" name="txtNewPassword"><br>
                <font color="red">${requestScope.INVALID.newPasswordError}</font><br>
                Confirm new Password<input class="text-black" style="border-color: black" type="password" name="txtConfirmNewPassword"><br>
                <font color="red">${requestScope.INVALID.confirmPassword}</font><br>
                <input type="submit" name="action" value="Confirm Change Password">
                <a href="MainController?action=ViewProfile"><input type="button" value="Cancel"></a>
            </form>
        </div></div></div>
<%@include file="footer.jsp" %>