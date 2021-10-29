    <%-- 
    Document   : serviceList
    Created on : Oct 28, 2021, 4:59:32 PM
    Author     : Admin
--%>

<%-- 
    Document   : employee
    Created on : Oct 27, 2021, 5:20:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link href="${pageContext.request.contextPath}/css/customerTable.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title> Services </title>
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
            function openForm() {
                document.getElementById("myForm").style.display = "block";
            }

            function closeForm() {
                document.getElementById("myForm").style.display = "none";
            }
        </script>

    </head>
    <body>

        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2><a href="#">Home</a></h2>
                                <h1>Services <b>List</b></h1>
                            </div>
                            <div class="col-sm-6">
                                <div class="search-box">
                                    <form action="service" method="post">
                                        Search by Name <input type="text" name="searchName" class="form-control" placeholder="--All--"
                                                              <c:if test="${sessionScope.serviceModel.name != null}">
                                                                  value="${sessionScope.serviceModel.name}"
                                                              </c:if>
                                                              >
                                        Search by Service Type 
                                        <select name="searchType"> <br>
                                            <option value="0">--All--</option>
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
                                        <br>
                                        Search by Time <input type="text" name="searchTime" class="form-control" placeholder="--All--"
                                                              <c:if test="${sessionScope.serviceModel.time != null && sessionScope.serviceModel.time > 0}">
                                                                  value="${sessionScope.serviceModel.time}"
                                                              </c:if>
                                                              >
                                        Search by Price <input type="text" name="searchPrice" class="form-control" placeholder="--All--"
                                                               <c:if test="${sessionScope.serviceModel.price != null &&  sessionScope.serviceModel.price > 0}">
                                                                   value="${sessionScope.serviceModel.price}"
                                                               </c:if>
                                                               >
                                        <br>
                                        <button style="margin-left: 60px; width: 100px; height: 40px; border-radius: 10px"> 
                                            Search 
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hint-text"> <b> Total results : ${totalRecord}</b></div>
                    <div style="float: right">
                        <a href="#myForm" onclick="openForm()"> <h3> <b> New service </b> </h3> </a>
                    </div>
                    <!-- Table -->
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Images</th>
                                <th>Feature</th>
                                <th>Description</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allServices}" var="s">
                                <tr>
                            <form method="post" action="updateServices?sid=${s.id}">
                                <td><input type="text" name="name" value="${s.name}" required style="width: 120px"></td>
                                <td>
                                    <img src="images/${s.images}" alt="images/default.jpg" style="width: 100%; height: auto">
                                    <input type="text" name="old_images" value="${s.images}" style="display: none">

                                    <input type="file" name="new_images" accept="image/png, image/jpeg, image/jpg"
                                           style="color: transparent; margin: 10px auto" title="addfile"
                                           data-classButton="btn btn-primary" data-input="false" data-classIcon="icon-plus" data-buttonText="Your label here.">
                                </td>
                                <td style="width: 200px">                            
                                    Type: <select name="type"> <br>
                                        <c:forEach items="${allType}" var="st">
                                            <option value="${st.typeID}" 
                                                    <c:if test="${st.typeID 
                                                                  eq s.type.typeID}">
                                                          selected
                                                    </c:if>>
                                                ${st.typeName}
                                            </option>
                                        </c:forEach>
                                    </select> <br>
                                    Time: <input type="text" name="time" value="${s.time}" required style="width:50px; margin-top: 10px"> mins
                                    <br>
                                    Price: <input type="text" name="price" value="${s.price}" required style="width:50px; margin-top: 10px"> $
                                    <br>
                                    <b>Ordered : ${s.ordered}</b>
                                </td>
                                <td><textarea name="description" cols="30" rows="10">${s.description}</textarea></td>
                                <td>
                                    <a href="deleteServices?sid=${s.id}" class="delete" title="Delete" data-toggle="tooltip" 
                                       style="width: 30px; border: 2px solid black; text-align: center">
                                        <i class="material-icons">&#10007;</i>
                                    </a>
                                    <button class="edit" title="Save" data-toggle="tooltip"><i class="material-icons">&#10003;</i></button>
                                </td>
                            </form>
                            </tr>    
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- Page Selector -->
                    <div class="clearfix">
                        <div class="hint-text"> <b> Page ${pageCurrent} </b>  of <b>${totalPage}</b></div>
                        <ul class="pagination">
                            <li class="page-item page">
                                <c:if test="${pageCurrent != 1}">
                                    <a href="service?pageNo=${pageCurrent - 1}"> Previous </a>
                                </c:if>
                            </li>
                            <c:forEach var="pageNo" begin="1" end="${totalPage}">
                                <li class="page-item page
                                    <c:if test="${pageCurrent == pageNo}">
                                        active
                                    </c:if>">
                                    <a href="service?pageNo=${pageNo}">
                                        ${pageNo}
                                    </a>
                                </li>
                            </c:forEach> 
                            <li class="page-item page">
                                <c:if test="${pageCurrent != totalPage}">
                                    <a href="service?pageNo=${pageCurrent + 1}"> Next </a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                    <!-- Insert form -->
                    <div class="form-popup" id="myForm">
                        <form action="createServices" class="form-container" method="post">
                            <span onclick="closeForm()" style="float:right"> Close </span>
                            <h2 style="text-align: center; color:  #00cc33"> Insert form </h2>

                            Service Name: <input type="text" placeholder="Enter Name" name="name" required> <br>

                            Service Time: <input type="text" placeholder="Time" name="time" required> <br>
             
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
