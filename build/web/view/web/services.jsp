<%-- 
    Document   : hairstyle
    Created on : Oct 7, 2021, 8:48:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name = "viewport" content="width=device-width, initial-scale=1.0">
        <title>Our Service</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/services_style.css">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Content -->
            <h1>Popular Haircut</h1>
            <section class="pt-5 pb-5">
                <div class="container">
                <c:forEach items="${services}" var="s">
                    <div class="row">
                        <div class="col-md-6 mb-5">
                            <img src="images/${s.images}" alt="Image placeholder" class="img-fluid">
                        </div>
                        <div class="col-md-6 pl-md-5">
                            <h3>${s.name}</h3>
                            <p>Price: ${s.price}$</p>
                            <p>Time: ${s.time} min </p>
                            <details>
                                <summary>Description</summary>
                                <p>${s.description}</p>
                            </details>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
        <!-- END section -->



        <section class="site-section">
            <div class="container">
                <div class="row justify-content-center mb-5">
                    <div class="col-md-7 text-center">
                        <h1>More Hair Styles</h1>
                    </div>
                </div>
                <div class="row top-destination">
                    <div class="col-lg-2 col-md-4 col-sm-6 col-12">
                        <a href="#" class="place">
                            <img src="${pageContext.request.contextPath}/images/img_6.jpg" alt="Image placeholder">
                            <h2>Crew Hair Cut</h2>
                            <p>Learn More</p>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <!-- END section -->

        <section class="site-section">
            <div class="container">
                <div class="row justify-content-center mb-5">
                    <div class="col-md-7 text-center">
                        <h1>Top haircut of the month </h1>
                    </div>
                </div>
                <div class="row top-destination">
                    <div class="col-lg-2 col-md-4 col-sm-6 col-12">
                        <a href="#" class="place">
                            <img src="${pageContext.request.contextPath}/images/img_6.jpg" alt="Image placeholder">
                            <h2>Crew Hair Cut</h2>
                            <p>Learn More</p>
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <!--Services-->
        <section class="site-section">
            <div class="container">
                <div class="row justify-content-center mb-5">
                    <div class="col-md-7 text-center">
                        <h1>Our Services </h1>
                    </div>
                </div>
                <div class="row top-destination">
                    <div class="col-lg-2 col-md-4 col-sm-6 col-12">
                        <a href="#" class="place">
                            <img src="${pageContext.request.contextPath}/images/img_6.jpg" alt="Image placeholder">
                            <h2>Crew Hair Cut</h2>
                            <p>Learn More</p>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
