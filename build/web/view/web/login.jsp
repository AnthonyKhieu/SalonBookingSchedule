<%-- 
    Document   : login
    Created on : Oct 8, 2021, 11:30:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Content -->
            <section class="banner justify-content-center" style="background-image: url(${pageContext.request.contextPath}/images/login.jpg);">
                <form action="login" method="post">
                    <div class="imgcontainer">
                        <img src="${pageContext.request.contextPath}/images/empty-white-male-avatar.jpg" alt="Avatar" class="avatar">
                    </div>
                    <div class="container">
                        <input type="text" placeholder="Enter Username" name="username" required> <br>
                        <input type="password" placeholder="Enter Password" name="password" required> <br>
                        <button type="submit">Login</button>
                        <label>
                            <input type="checkbox" checked="checked" name="remember"> Remember me
                        </label>
                    </div>

                    <div class="container" style="background-color:#f1f1f1">
                        <button type="button" class="cancelbtn">Cancel</button>
                        <span class="psw">Forgot <a href="#">password?</a></span>
                    </div>
                </form>
            </section>     
            <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
