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
        <c:forEach items="${mappingServices.keySet()}" var="type" >
            <section class="site-section">
                <div class="container">
                    <div class="row justify-content-center mb-5">
                        <div class="col-md-7 text-center">
                            <h1>${type.typeName}</h1>
                        </div>
                    </div>
                    <div class="row top-destination">
                        <c:forEach items="${mappingServices.get(type)}" var="s">
                            <div class="col-lg-4 col-md-3 col-sm-6 col-12 justify-content-center">
                                <img src="images/${s.images}" alt="Image placeholder" style="width: 100%; height: auto">
                                <h3>${s.name}</h3>
                                <p>
                                Price: ${s.price}$ 
                                <br> 
                                ${s.time} min 
                                </p>
                                <button> Details </button>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </c:forEach>
        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
