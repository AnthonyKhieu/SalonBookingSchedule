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
        <title> Employee </title>
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
                                <h1>Employees <b>List</b></h1>
                            </div>
                            <div class="col-sm-6">
                                <div class="search-box">
                                    <form action="employee" method="post">
                                        Search Name <input type="text" name="searchName" class="form-control" placeholder="Search Name..."
                                                           <c:if test="${sessionScope.employeeModel.name != null}">
                                                               value="${sessionScope.employeeModel.name}"
                                                           </c:if>
                                                           >
                                        <br>
                                        <button style="text-align: center"> Search </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hint-text"> <b> Total results : ${totalRecord}</b></div>
                    <div style="float: right">
                        <button onclick="openForm()"> New employee </button>
                    </div>
                    <div class="form-popup" id="myForm" style="display: none; float: right">
                        <form action="createEmployee" class="form-container" method="post">
                            <label for="name"><b>Name</b></label>
                            <input type="text" placeholder="Enter Name" name="name" required>

                            <label for="insta"><b>Insta</b></label>
                            <input type="text" placeholder="Instagram Link" name="insta" required>

                            <label for="images"><b>Images</b></label>
                            <input type="file" accept="image/png, image/jpeg, image/jpg" name="images"
                                   style="color: transparent;">

                            <label for="description"><b>Description</b></label>
                            <input type="text" placeholder="Description" name="description" required>
                            <button onclick="closeForm()" type="submit" class="btn"> Add </button>
                            <button onclick="closeForm()" type="submit" class="btn"> Close </button>
                        </form>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Insta</th>
                                <th>Description</th>
                                <th>Images</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allEmployees}" var="e">
                                <tr>
                            <form method="post" action="updateEmployee?eid=${e.id}">
                                <td><input type="text" name="name" value="${e.name}"></td>
                                <td><input type="text" name="insta" value="${e.insta}" required></td>
                                <td><textarea name="description" cols="30" rows="8">${e.description}</textarea></td>
                                <td>
                                    <img src="images/${e.images}" alt="images/default.jpg" style="width: 100%; height: auto">
                                    <input type="text" name="old_images" value="${e.images}">
                                    <input type="file" name="new_images" accept="image/png, image/jpeg, image/jpg"
                                           style="color: transparent;" title="addfile"
                                           data-classButton="btn btn-primary" data-input="false" data-classIcon="icon-plus" data-buttonText="Your label here.">
                                </td>
                                <td>
                                    <button class="edit" title="Save" data-toggle="tooltip"><i class="material-icons">&#10003;</i></button>
                                    <a href="deleteEmployee?eid=${e.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#10007;</i></a>
                                </td>
                            </form>
                            </tr>    
                        </c:forEach>

                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text"> <b> Page ${pageCurrent} </b>  of <b>${totalPage}</b></div>
                        <ul class="pagination">
                            <li class="page-item page">
                                <c:if test="${pageCurrent != 1}">
                                    <a href="employee?pageNo=${pageCurrent - 1}"> Previous </a>
                                </c:if>
                            </li>
                            <c:forEach var="pageNo" begin="1" end="${totalPage}">
                                <li class="page-item page
                                    <c:if test="${pageCurrent == pageNo}">
                                        active
                                    </c:if>">
                                    <a href="employee?pageNo=${pageNo}">
                                        ${pageNo}
                                    </a>
                                </li>
                            </c:forEach> 
                            <li class="page-item page">
                                <c:if test="${pageCurrent != totalPage}">
                                    <a href="employee?pageNo=${pageCurrent + 1}"> Next </a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
