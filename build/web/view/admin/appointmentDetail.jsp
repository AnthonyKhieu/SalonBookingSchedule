<%-- 
    Document   : appointmentControl
    Created on : Nov 7, 2021, 11:32:32 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Data table</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            button{
                width: 200px;
                height: 50px;
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
            option{
                width: 100%;
            }
        </style>
        <script>
            function getToHour(start, totalTime) {
                var end = parseFloat(start) + totalTime;
                document.getElementById("end").value = end;
            }
        </script>
    </head>
    <body>
        <!-- Navigation-->
        <jsp:include page="adminHeader.jsp"></jsp:include>
            <!-- Product section-->
            <section class="py-5">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="row gx-4 gx-lg-5 align-items-center">
                        <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${pageContext.request.contextPath}/images/big_image_2.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">Appointment Details</h1>
                        <form action="updateAppointment" method="post">
                            <input type="hidden" value="${sessionScope.appointment.id}" name="aid">
                            <div>Appointment ID: ${sessionScope.appointment.id}</div>
                            <div>
                                Start-time:
                                <fmt:formatNumber var="fhour" value="${sessionScope.appointment.fromHour * 10 % 10 == 0 ? sessionScope.appointment.fromHour : sessionScope.appointment.fromHour - 0.5}" 
                                                  minFractionDigits="0" maxFractionDigits="0"/>
                                ${fhour}:${sessionScope.appointment.fromHour * 10 % 10 == 0 ? "00" : "30"} 
                            </div>
                            <div>
                                Date: <input type="date" name="date" value="${sessionScope.appointment.date}">
                            </div>
                            <div>
                                Customer: ${sessionScope.appointment.customer.name} --- Phone: ${sessionScope.appointment.customer.phone}
                            </div>
                            <div>
                                Employee: ${sessionScope.appointment.employee.name}
                            </div>
                            <div>
                                Services:
                                <table>
                                    <th>Type</th>
                                    <th>Service</th>
                                    <tbody>
                                        <c:forEach items="${mappingServices.keySet()}" var="st">
                                            <tr>
                                                <td>${st.typeName}</td>
                                                <td>
                                                    <select name="booked${st.typeID}">
                                                        <option value="0">None</option>
                                                        <c:forEach items="${mappingServices.get(st)}" var="service">
                                                            <option 
                                                                <c:forEach items="${sessionScope.appointment.services}" var="serv">
                                                                    <c:if test="${serv.id == service.id}">
                                                                        selected
                                                                    </c:if>
                                                                </c:forEach> value="${serv.id}"> 
                                                                ${service.name} 
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <button class="btn btn-outline-dark flex-shrink-0">
                                Save
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>