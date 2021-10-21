<%-- 
    Document   : about
    Created on : Oct 7, 2021, 8:48:27 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name = "viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/about.css">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Content -->
            <section class="justify-content-center about">
                <div class="row mb-5 justify-content-center">
                    <div class="col-md-5 text-left">
                        <h1>About us</h1>
                        <p>Our thoughtfully curated collection of superior hair, skin, and shave essentials are designed to unleash what makes you, you. 
                            You’ve got your own story, your own signature statement. 
                            We offer a curated collection of grooming must-haves to free your best self and fuel your next level.
                            Our superior assortment of hair, skin and shaving essentials gets the job done in the simplest, most powerful way possible.
                            <br>Since 1965, our top-notch products have proven that premium doesn’t have to be pretentious. 
                            Performance is everything so every formula is tried and tested at the award-winning Baxter Finley Barber + Shop in Los Angeles.
                        </p>

                    </div>
                    <div class="col-md-7" text-right>
                        <img src="images/baxter.png" style="width: 100%; height: auto">                             
                    </div>
                </div>
            </section>
            <iframe width="100%" height="500" src="https://www.youtube.com/embed/TJk-cBZdl1A?start=18" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>        
            <section class="pt-5 pb-5">
                <div class="container">
                    <div class="row mb-5 justify-content-center">
                        <div class="col-md-8 text-center">
                            <h1>Meet our Team</h1>
                        </div>
                    </div>
                    <!-- loop all barber in the shop -->
                <c:forEach items="${employees}" var="e">
                    <div class="row employeeList">
                        <div class="col-md-6 mb-5">
                            <img src="images/${e.images}" alt="images/default.jpg" class="img-fluid" style="width: 100%; height: auto">
                        </div>
                        <div class="col-md-6 pl-md-5">
                            <div class="e-name">${e.name}</div>
                            <h2>About</h2>
                            <div class="e-des">${e.description}</div>
                            <div class="e-insta">
                                <a href="${e.insta}">
                                    Follow Instagram <img src="images/instagram_icon.png" style="width: 30px; height: 30px">
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- loop all barber in the shop -->
            </div>
        </section>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
