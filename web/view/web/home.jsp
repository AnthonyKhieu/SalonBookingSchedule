<%-- 
    Document   : home
    Created on : Oct 7, 2021, 7:08:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name = "viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home_style.css">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

        <!--Content-->
        <section class="banner" id = "banner" style="background-image: url(${pageContext.request.contextPath}/images/home.jpg);">
            <div class="content">
                <h2> Man Choice </h2>
                <p> Make your own style </p>
                <a href="appointment.jsp" class="btn"> Appointment </a>
            </div>
        </section>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
