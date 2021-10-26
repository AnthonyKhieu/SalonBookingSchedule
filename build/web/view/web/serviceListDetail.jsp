<%-- 
    Document   : serviceListDetail
    Created on : Oct 19, 2021, 10:34:33 AM
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
            .row{
                padding-left: 10px;
                padding-right: 10px
            }
            a{
                color: orange;
                font-size: 25px;
                padding-left: 10px;
            }
            h2{
                text-align: center;
            }
            h2::first-letter{
                color: blueviolet;
            }
            .service{
                border-top: 5px solid #cc00cc;
                
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <a href="services">  << Services</a>
            
            
            <h2>${st.name}</h2>
            <div class="row">
                <c:forEach items="${serviceList}" var="s">
                <div class="col-lg-3 col-md-3 col-sm-6 col-12 justify-content-center">
                    <div class="service" style="border: 1px solid #993300; margin: 10px 10px; text-align: center">
                        <img src="images/${s.images}" alt="images/default.jpg" style="width: 100%; height: 300px">
                        <h3>${s.name}</h3>
                        <p>
                            Price: ${s.price}$ 
                            <br> 
                            Time: ${s.time} min 
                        </p>
                        <a href="serviceDetail?sid=${s.id}">View Detail</a>
                    </div>
                </div>
            </c:forEach>
        </div>
            
            <a href="services">  << Services</a>
        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
