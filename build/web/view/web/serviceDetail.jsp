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
            .appoint{
                margin: 30px auto;
                width: 60%;
            }
            a{
                color: orange;
                font-size: 25px;
                padding-left: 10px;
            }
            .appoint:hover{
                background-color: #999999;
                letter-spacing: 2px;
                color: wheat;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <a href="services"> << Services</a>

        <c:set var = "s" scope = "request" value ="${requestScope.service}"/>
        <div class="info row" style="margin: 10px 30px;">
            <div class="col-md-5">
                <img src="images/${s.images}" alt="images/default.jpg" style="width: 100%; height: auto;">
            </div>
            <div class="col-md-7">
                <h1>${s.name}</h1>
                <p>
                    Price: ${s.price}$ 
                    <br> 
                    Time: ${s.time} min 
                    <br>
                    <h3>Description</h3>
                    ${s.description}
                </p>
                <div class="appoint" style="border: 2px solid #0066cc; text-align: center">
                    <a href="#">Appointment Now !</a>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
