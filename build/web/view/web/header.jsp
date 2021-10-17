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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/services">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link login" href="login.jsp" 
                       style="color: #00cc33; border: 1px solid orange" >Login</a>
                </li>
            </ul> 
        </header>
    </body>
</html>
