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
            input{
                width: 100%;
                background-color: #66cc00;
                color: white;
                height: 40px;
            }
            input:hover{
                background-color: #66cc00;
                color: white;
                letter-spacing: 1px;
                transition: 0.5s;
            }
            .search-box input{
                width: 300px;
                background-color: white;
                color: black;
                margin-left: 30px;
                padding-left: 30px;
                border-radius: 40px;

            }
            .search-box input:focus{
                border: 5px solid #0099cc;
                
            }
            button{
                background-color: #ccccff;
                width: 100px;
                height: 37px;
                color: #cc00ff;
            }
            button:hover{
                color: white;
                background-color: #0099ff;
                letter-spacing: 1px;
                transition: 0.5s;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <a href="servicesWeb">  << Services</a>

            <h2>${requestScope.serviceType.typeName}</h2>

        <div class="search-box">
            <form action="serviceTypeWeb" method="post">
                <input type="text" placeholder="Search Name..." name="name"
                       <c:if test="${requestScope.name != null}">
                           value="${requestScope.name}"
                       </c:if>>                       
                <button>Search</button>
            </form>
        </div>
        <div class="row">
            <c:forEach items="${serviceList}" var="s">
                <div class="col-lg-3 col-md-3 col-sm-6 col-12 justify-content-center">
                    <form action="appointmentWeb" method="post">
                        <input type="hidden" value="${s.id}" name="picked">
                        <div class="service" style="border: 1px solid #993300; margin: 10px 10px; text-align: center">
                            <img src="images/${s.images}" alt="images/default.jpg" style="width: 100%; height: 300px">
                            <h3>${s.name}</h3>
                            <p>
                                Price: ${s.price}$ 
                                <br> 
                                Time: ${s.time} min 
                            </p>
                            <a href="serviceDetailWeb?sid=${s.id}">View Detail</a>
                            <br>
                            <input type="submit" value="Book thís service">
                        </div>
                    </form>
                </div>
            </c:forEach>
        </div>

        <a href="servicesWeb">  << Services</a>
        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
