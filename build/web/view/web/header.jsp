<%-- 
    Document   : header
    Created on : Oct 7, 2021, 7:09:27 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name = "viewport" content="width=device-width, initial-scale=1.0">
        <title>Header</title>

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet"> 

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.css">
        <!-- Theme Style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    </head>
    <body>
        <header>
            <ul class="nav flex-column flex-sm-row justify-content-center">
                <li class="nav-item">
                    <img src="${pageContext.request.contextPath}/images/Logo.png"
                         style="width: 50px; height: 50px; border-radius: 50%;">
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/contactWeb">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/servicesWeb">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link login" href="${pageContext.request.contextPath}/login" 
                       style="color: #00cc33; border: 1px solid orange" >Login</a>
                </li>
            </ul> 

        </header>
        <section class="site-hero overlay" data-stellar-background-ratio="0.5" style="background-image: url(${pageContext.request.contextPath}/images/big_image_1.jpg);">
            <div class="container">
                <div class="row align-items-center site-hero-inner justify-content-center">

                    <iframe width="100%" height="500" src="https://www.youtube.com/embed/TJk-cBZdl1A?autoplay=1;start=18" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>        

                </div>
            </div>
        </section>
    </body>
</html>
