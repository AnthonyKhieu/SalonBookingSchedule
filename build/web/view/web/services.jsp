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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/services_style.css">
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
                            <a href="serviceTypeWeb?st_id=${st.typeID}">${st.typeName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div style="text-align: center; margin-top: 20px; color: #009900;">
            <h1>Our services</h1>
        </div>
        <c:forEach items="${mappingServices.keySet()}" var="type" >
            <section class="content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 pr-5">
                            <h2 class="mb-3">${type.typeName}</h2>
                            <div class="mb-3 custom-nav">
                                <a href="#" class="btn btn-primary btn-sm custom-prev mr-2 mb-2"><span class="ion-android-arrow-back"></span></a> 
                                <a href="#" class="btn btn-primary btn-sm custom-next mr-2 mb-2"><span class="ion-android-arrow-forward"></span></a>
                            </div>
                            <div class="view"> <a href="serviceTypeWeb?st_id=${type.typeID}">View All >></a> </div>
                        </div>
                        <div class="col-md-9">
                            <div class="row">
                                <div class="col-md-12 slider-wrap">
                                    <div class="owl-carousel owl-theme no-nav js-carousel-1">
                                        <c:forEach items="${mappingServices.get(type)}" var="s">
                                            <a href="serviceDetailWeb?sid=${s.id}" class="img-bg" style="background-image: url('${pageContext.request.contextPath}/images/${s.images}')">
                                                <div class="text">
                                                    <span class="icon custom-icon flaticon-scissors"></span>
                                                    <h2>${s.name}</h2>
                                                    <p>Read More</p>
                                                </div>
                                            </a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </section>
        </c:forEach>
        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-migrate-3.0.0.js"></script>
        <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.stellar.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/magnific-popup-options.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
