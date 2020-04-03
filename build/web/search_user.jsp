<%@include file="head.jsp" %>
<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
                <span class="caption mb-3">Luxurious Rooms</span>
                <h1 class="mb-4">Search user</h1>
            </div>
        </div>
    </div>
</div>

<div class="site-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                <h2 class="mb-5">Search User</h2>
            </div>
        </div>
        <c:if test="${sessionScope.ROLE ne 'admin'}">
            <c:redirect url="index.jsp"/>
        </c:if>

        <form action="MainController">
            <input  class="text-black" style="border-color: #3333ff" type="text" name="txtSearch" value="${param.txtSearch}">
            <input  type="submit" name="action" value="Search">
        </form>

        <c:if test="${not empty requestScope.INVALID}"> 
            <h3>Your update action at userID: ${param.txtID} is Invalid because:</h3><br>
            <font color="red">${requestScope.INVALID.fullNameError}</font> <br>
            <font color="red">${requestScope.INVALID.confirmPassword}</font> <br>
            <font color="red">${requestScope.INVALID.ageError}</font> <br>
            <font color="red">${requestScope.INVALID.phoneError}</font> <br>
        </c:if>
        <font color="red"> ${requestScope.STATUS}</font>
        <font color="red">${requestScope.ERROR}</font> <br>
        <c:if test="${requestScope.LIST_USER !=null}">
            <c:if test="${not empty requestScope.LIST_USER}" var="check">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>User ID</th>
                            <th>Account Name</th>
                            <th>Full name</th>
                            <th>Age</th>
                            <th>Phone</th>
                            <th>Role</th>
                            <th>View booking request</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.LIST_USER}" var="user" varStatus="counter">
                            <tr>
                        <form action="MainController" method="POST">
                            <td>${counter.count}</td>
                            <td><input type="hidden" name="txtID" value="${user.accountID}">${user.accountID}</td>
                            <td><input class="text-black" type="hidden" name="txtName" value="${user.accountName}">${user.accountName}</td>
                            <td><input class="text-black"  style="border-color: black"type="text" name="txtFullname" value="${user.fullname}"></td>
                            <td><input class="text-black"  style="border-color: black"type="text" name="txtAge" value="${user.age}"></td>
                            <td><input class="text-black"  style="border-color: black"type="text" name="txtPhone" value="${user.phone}"></td>
                            <td>
                                <select name="txtRole">
                                    <option value="admin"  <c:if test="${user.role eq 'admin'}">selected="true"</c:if>>admin</option>
                                    <option value="user"<c:if test="${user.role eq 'user'}">selected="true"</c:if>>user</option>
                                    </select>
                                </td>
                                <td><input type="submit" name="action" value="ShowAllBook"></td>
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}">
                            <td><input type="submit" name="action" value="Edit User"></td>
                            <td><input type="submit" name="action" value="Delete User"></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!check}">
                No result
            </c:if>

        </c:if>
        <a href="index.jsp">Back to MainPage</a>
    </div>
</div>

<%@include file="footer.jsp" %>
