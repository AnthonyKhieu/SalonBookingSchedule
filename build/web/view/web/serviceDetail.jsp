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
            input{
                height: 50px;
                border-radius: 20px;
                margin: 30px auto;
                width: 50%;
            }
            input{
                color: orange;
                font-size: 40px;
                font-weight: bold;
            }
            input:hover{
                background-color: #009900;
                letter-spacing: 2px;
                color: white;
                transition: 0.5s;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <a href="servicesWeb"> << Services</a>

        <c:set var = "s" scope = "request" value ="${requestScope.service}"/>
        <div class="info row" style="margin: 10px 30px;">
            <div class="col-md-5">
                <img src="images/${s.images}" alt="images/default.jpg" style="width: 100%; height: auto;">
            </div>
            <div class="col-md-7">
                <form action="appointmentWeb" method="post">
                    <input type="hidden" value="${s.id}" name="picked">
                    <h1>${s.name}</h1>
                    <p>
                        Type: ${s.type.typeName}
                        <br>
                        Price: ${s.price}$ 
                        <br> 
                        Time: ${s.time} min 
                        <br>
                    <h3>Description</h3>
                    ${s.description}
                    </p>
                    <input type="submit" value="Book now!">
                </form>
            </div>
        </div>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
