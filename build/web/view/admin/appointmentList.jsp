<%-- 
    Document   : appointment
    Created on : Nov 5, 2021, 3:16:28 PM
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
    </head>
    <body>
    <head>
        <meta charset="utf-8">
        <link href="${pageContext.request.contextPath}/css/customerTable.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap Simple Data Table</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <jsp:include page="adminHeader.jsp"></jsp:include>
            <div class="container-xl">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h2><a href="#">Home</a></h2>
                                    <h1>Appointment <b>List</b></h1>
                                </div>
                                <div class="col-sm-6">
                                    <div class="search-box">
                                        <form action="appointment" method="post">
                                            Search by Customer Name <input type="text" name="searchCustomer" class="form-control" placeholder="--All--"
                                            <c:if test="${sessionScope.appointmentModel.customer.name != null}">
                                                value="${sessionScope.appointmentModel.customer.name}"
                                            </c:if>
                                            >
                                        <br>
                                        Search by Employee 
                                        <select name="searchEmployee"> <br>
                                            <option value="0">--All--</option>
                                            <c:forEach items="${allEmployees}" var="e">
                                                <option value="${e.id}" 
                                                        <c:if test="${e.id 
                                                                      eq sessionScope.appointmentModel.employee.id}">
                                                              selected
                                                        </c:if>>
                                                    ${e.name}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <br>
                                        Search by Date <input type="date" name="searchDate" class="form-control" placeholder="--All--"
                                                              <c:if test="${sessionScope.appointmentModel.date != null}">
                                                                  value="${sessionScope.appointmentModel.date}"
                                                              </c:if>
                                                              >
                                        <br>                                                                         
                                        <button style="margin-left: 100px; width: 100px; height: 40px; border-radius: 10px"> 
                                            Search 
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hint-text"> <b> Total results : ${totalRecord}</b></div>
                    <!-- Table -->
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Employee</th>
                                <th>Customer</th>
                                <th>Date</th>
                                <th>Start time</th>
                                <th>End time</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allAppointments}" var="a">
                                <tr>
                                    <td>${a.id}</td>
                                    <td>${a.employee.name}</td>
                                    <td>${a.customer.name}</td>
                                    <td>${a.date} </td>
                                    <td>
                                        <fmt:formatNumber var="fhour" value="${a.fromHour * 10 % 10 == 0 ? a.fromHour : a.fromHour - 0.5}" 
                                                          minFractionDigits="0" maxFractionDigits="0"/>
                                        ${fhour}:${a.fromHour * 10 % 10 == 0 ? "00" : "30"} 
                                    </td>
                                    <td>
                                        <fmt:formatNumber var="thour" value="${a.toHour * 10 % 10 == 0 ? a.toHour : a.toHour - 0.5}" 
                                                          minFractionDigits="0" maxFractionDigits="0"/>
                                        ${thour}:${a.toHour * 10 % 10 == 0 ? "00" : "30"} 
                                    </td>
                                    <td>
                                        <a href="deleteAppointment?aid=${a.id}" class="delete" title="Delete" data-toggle="tooltip" 
                                           style="width: 30px; border: 2px solid black; text-align: center">
                                            <i class="material-icons" style="font-size:24px">&#10007;</i>
                                        </a>
                                        <a href="updateAppointment?aid=${a.id}" class="edit" title="Edit" data-toggle="tooltip" 
                                           style="width: 30px; border: 2px solid black; text-align: center">
                                            <i class="fa fa-pencil" style="font-size:24px"></i>
                                        </a>
                                    </td>
                                </tr>    
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- Page -->
                    <div class="clearfix">
                        <div class="hint-text"> <b> Page ${pageCurrent} </b>  of <b>${totalPage}</b></div>
                        <ul class="pagination">
                            <li class="page-item page">
                                <c:if test="${pageCurrent - 2 > 1}">
                                    <a href="appointment?pageNo=1"> First </a>
                                </c:if>
                            </li>
                            <c:set var = "pageHead" value = "${pageCurrent - 2 > 1 ? pageCurrent - 2 : 1 }"/>
                            <c:set var = "pageTail" value = "${pageCurrent + 2 < totalPage ? pageCurrent + 2 : totalPage }"/>
                            <c:forEach var="pageNo" begin="${pageHead}" end="${pageTail}">
                                <li class="page-item page
                                    <c:if test="${pageCurrent == pageNo}">
                                        active
                                    </c:if>">
                                    <a href="appointment?pageNo=${pageNo}">
                                        ${pageNo}
                                    </a>
                                </li>
                            </c:forEach> 
                            <li class="page-item page">
                                <c:if test="${pageCurrent < totalPage - 2}">
                                    <a href="appointment?pageNo=${totalPage}"> Last </a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                    <!-- Insert form -->
                    <div class="form-popup" id="myForm">
                        <form action="createApponitment" class="form-container" method="post">
                            <span onclick="closeForm()" style="float:right"> Close </span>
                            <h2 style="text-align: center; color:  #00cc33"> Insert form </h2>

                            Choose Employee <input type="text" placeholder="Enter Name" name="name" required> <br>

                            <input type="text" placeholder="Time" name="time" required> <br>

                            Service Price: <input type="text" placeholder="Price" name="price" required> <br>
                            <div style="padding-top: 10px">
                                Images: <input type="file" accept="image/png, image/jpeg, image/jpg" name="images"
                                               style="color: transparent; border: none;">
                            </div>
                            <div style="float: right">
                                Services Type: <select name="type"> <br>
                                    <c:forEach items="${allType}" var="st">
                                        <option value="${st.typeID}" 
                                                <c:if test="${st.typeID 
                                                              eq sessionScope.serviceModel.type.typeID}">
                                                      selected
                                                </c:if>>
                                            ${st.typeName}
                                        </option>
                                    </c:forEach>
                                </select> 
                            </div>
                            <textarea name="description" cols="30" rows="10" placeholder="Write something..." style="width: 100%"></textarea>
                            <button class="btn"> Add </button>
                        </form>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
