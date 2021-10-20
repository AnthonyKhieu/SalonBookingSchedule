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
        <script src="${pageContext.request.contextPath}/js/button.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Content -->
            <div class="row">
                <div class="col-6">
                    <ul class="list_Services">
                    <c:forEach items="${servType}" var="st">
                        <li>
                            <a href="serviceType?st_id=${st.typeID}">${st.typeName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <c:forEach items="${mappingServices.keySet()}" var="type" >
            <section class="site-section">
                <div class="container">
                    <div class="justify-content-center mb-5">
                            <h1>Top ${type.typeName}</h1>
                            <span class="view"> <a href="serviceType?st_id=${type.typeID}">View All >></a> </span>
                    </div>
                    <div class="row data">
                        <c:forEach items="${mappingServices.get(type)}" var="s" begin="0" end="3">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-12 justify-content-center">
                                <div class="service">
                                    <img src="images/${s.images}" alt="images/default.jpg" style="width: 100%; height: 300px">
                                    <h3>${s.name}</h3>
                                    <p>
                                        Price: ${s.price}$ 
                                        <br> 
                                        ${s.time} min 
                                    </p>
                                    <div class="detail-btn">
                                        <a href="serviceDetail?sid=${s.id}"> Detail </a>
                                    </div>
                                </div>
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
