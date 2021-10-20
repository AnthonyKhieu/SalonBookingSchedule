<%-- 
    Document   : serviceDetail
    Created on : Oct 18, 2021, 9:25:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name = "viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <style>
            a{
                color: orange;
                font-size: 25px;
                padding-left: 10px;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <a href="services"> << Services</a>

        <c:set var = "s" scope = "request" value ="${requestScope.service}"/>
        <div class="info">
            <img src="images/${s.images}" alt="images/default.jpg">
            <h3>${s.name}</h3>
            <p>
                Price: ${s.price}$ 
                <br> 
                ${s.time} min 
                <br>
                ${s.description}
            </p>
        </div>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
