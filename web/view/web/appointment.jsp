<%-- 
    Document   : appointment
    Created on : Oct 7, 2021, 9:42:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            a{
                font-size: 25px;
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
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <section class="banner" style="background-image: url(${pageContext.request.contextPath}/images/appointment.jpg);">
            <form action="createAppointment" method="post">
                <h2> Hi, ${sessionScope.clientName == null ? "New Guest" : sessionScope.clientName}</h2>

                <h4> Phone </h4>
                <input type="text" required name="clientPhone" value="${sessionScope.clientPhone}" placeholder="Phone number"> <br>

                <h4> Name </h4> 
                <input type="text" required name="clientName"
                       value="${sessionScope.clientName == null ? "" : sessionScope.clientName}" placeholder="Your Name"> <br>

                <h4> Date </h4> 
                <input type="date" required name="date" placeholder="Choose day"> <br>

                <br>
                Choose hour <input type="text" name="fromHour" required placeholder="Open 8:00 am - Close 10:00pm">
                
                <br>
                <br>
                Choose your barber: 
                <select name="employee">
                    <c:forEach items="${employeeList}" var="e">
                        <option value="${e.id}"> ${e.name}</option>
                    </c:forEach>
                </select>

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
                                    <a href="serviceTypeWeb?st_id=${st.typeID}"> Add </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clear-box">
                    <a style='' href="clear"> Clear table </a>
                </div>
                <c:if test="${booked.size() > 0}">
                    <button type="submit">Confirm</button>
                </c:if>
            </form>
        </section>

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
