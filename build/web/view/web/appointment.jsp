<%-- 
    Document   : appointment
    Created on : Oct 7, 2021, 9:42:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/appointment.css">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

        <section class="banner" style="background-image: url(${pageContext.request.contextPath}/images/appointment.jpg);">
            <form action="appointment" method="post">
                <h2> Appointment now!</h2>
                <div class="phone">
                    <input type="text" required name="phone" placeholder="PhoneNumber">
                </div>
                <div class="date">
                    <input type="date" required name="date" placeholder="Choose day">
                </div>
                <div class="hour">
                    <input type="hour" required name="hour" placeholder="What's times do you want to cut?">
                </div>
                <button type="submit">Confirm</button>
            </form>
        </section>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
