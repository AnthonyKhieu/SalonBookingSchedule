<%-- 
    Document   : appointment
    Created on : Oct 7, 2021, 9:42:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/appointment.css">
        <style>
            h4{
                color: #33cc00;
            }
            input{
                margin-top: 10px;
                width: 300px;
                text-align: center;
            }
            select{
                margin-top: 10px;
                height: 24px;
                border-radius: 30px;
            }
            p{
                color: white;
                font-size: 30px;
               
            }
            a{
                font-size: 20px;
                font-weight: 500;
            }
            .clear-box{
                width: 50%;
                border: 1px solid #66cc00;
                margin: 0px auto;
            }
            .clear-box:hover{
                background-color: activeborder;
            }
            table{
                margin: 10px auto;
                width: 600px;
                text-align: center;
                border: 2px solid grey;
            }
            td, th{
                padding: 1px 1px;
                border: 1px solid grey;
            }
            .tbl th{
                background-color: #00ffcc; 
                color: black;
            }
            .previous{
                display: none;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <section class="banner" style="background-image: url(${pageContext.request.contextPath}/images/appointment.jpg);">

            <form action="getAvalTime" method="post" 
                  <c:if test="${sessionScope.avalTime != null}">
                      style="display:none"
                  </c:if>
                  >
                <input type="hidden" required name="clientPhone" value="${sessionScope.clientPhone}" placeholder="Phone number">
              <h2> Hi, ${sessionScope.clientName == null ? "New Guest" : sessionScope.clientName}</h2>
                <h4> Phone </h4>
                <p style="color:white"> ${sessionScope.clientPhone} </p>
                <h4> Name </h4> 
                 <input type="text" required name="clientName"
                       value="${sessionScope.clientName == null ? "" : sessionScope.clientName}" placeholder="Your Name">
                <c:set var = "booked" scope="session" value = "${sessionScope.bookingServices}"/>
                <table>
                    <th>Type</th>
                    <th>Service</th>
                    <th>Actions</th>
                    <tbody>
                        <c:forEach items="${serviceType}" var="st">
                            <tr>
                                <td> ${st.typeName} </td>
                                <td> 
                                    <div id="picked">
                                        ${booked.get(st.typeID) != null ? booked.get(st.typeID).name : ""}
                                    </div>
                                </td>
                                <td>
                                    <a href="serviceTypeWeb?st_id=${st.typeID}">
                                        ${booked.get(st.typeID) != null ? "Change" : "Add"}
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clear-box">
                    <a style='' href="clear"> Clear table </a>
                </div>
                <table class="tbl"  
                       <c:if test="${sessionScope.bookingServices == null || sessionScope.bookingServices.size() == 0}">
                           style="display:none"
                       </c:if>>
                    <th>Date</th>
                    <th>Stylist</th>
                    <tr>
                        <td>
                            Choose Time
                            <input type="date" min="${sessionScope.currentDate}" max="${sessionScope.currentDate.plusDays(30)}" 
                                   required name="date"
                                   <c:if test="${sessionScope.picked != null}">
                                       value="${sessionScope.picked}"
                                   </c:if>
                                   >
                            <br>
                        </td>
                        <td>
                            Choose your barber: 
                            <select name="employee">
                                <c:forEach items="${employeeList}" var="e">
                                    <option value="${e.id}" ${sessionScope.eid == e.id ? "selected" : ""}>
                                        ${e.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <c:if test="${sessionScope.avalTime == null && sessionScope.bookingServices.size() > 0}">
                    <button>Next</button>
                </c:if>
            </form>
            <!-- Choose hour form -->

            <c:if test="${sessionScope.avalTime != null}">                
                <form action="appointmentCreateWeb" method="post" style="height: 400px">
                    <a href="getAvalTime" style="color: #33ff33"> << Edit the table</a> <br>
                    Choose Available Hour: 
                    <select name="fromHour">
                        <c:forEach items="${sessionScope.avalTime}" var="t">
                            <fmt:formatNumber var="hour" value="${t * 10 % 10 == 0 ? t : t - 0.5}" 
                                              minFractionDigits="0" maxFractionDigits="0"/>
                            <option value="${t}">
                                ${hour}:${t * 10 % 10 == 0 ? "00" : "30"} 
                            </option>
                        </c:forEach>
                    </select>
                    <br> <br> <textarea name="description" rows="8" style="width: 100%;" placeholder="Write something for us...">${e.description}</textarea>
                    <br>
                    <button> Booking </button>
                </form>
            </c:if>
        </section>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
