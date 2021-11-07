<%-- 
    Document   : account
    Created on : Oct 24, 2021, 10:17:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
        <jsp:include page="${pageContext.request.contextPath}/adminHeader.jsp"></jsp:include>
            <div class="container-xl">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6"><h1>Contact <b>Details</b></h1></div>
                                <div class="col-sm-6">
                                    <div class="search-box">
                                        <form action="${pageContext.request.contextPath}/admin/customer" method="post">
                                            Search by Name <input type="text" name="searchName" class="form-control" placeholder="Search Name..."
                                            <c:if test="${sessionScope.searchModel.name != null}">
                                                value="${sessionScope.searchModel.name}"
                                            </c:if>
                                            >
                                        Search by Title <input type="text" name="searchTitle" class="form-control" placeholder="Search Phone..."
                                                               <c:if test="${sessionScope.searchModel.title != null}">
                                                                   value="${sessionScope.searchModel.title}"
                                                               </c:if>
                                                               >
                                        <br>
                                        <button style="text-align: center"> Search </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Title</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allContact}" var="c">
                                <tr>
                                    <td>${c.name}</td>
                                    <td>${c.email}</td>
                                    <td>${c.title}</td>
                                    <td>
                                        <button class="edit" title="Save" data-toggle="tooltip"><i class="material-icons">&#10003;</i></button>
                                        <a href="deleteContact?cid=${c.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#10007;</i></a>
                                    </td>
                                </tr>    
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text"> <b> Page ${pageCurrent} </b>  of <b>${totalPage}</b></div>
                        <ul class="pagination">
                            <li class="page-item page">
                                <c:if test="${pageCurrent != 1}">
                                    <a href="contact?pageNo=${pageCurrent - 1}"> Previous </a>
                                </c:if>
                            </li>
                            <c:set var = "page" value = "${pageCurrent + 2 < totalPage ? pageCurrent + 2 : totalPage }"/>
                            <c:forEach var="pageNo" begin="1" end="${page}">
                                <li class="page-item page
                                    <c:if test="${pageCurrent == pageNo}">
                                        active
                                    </c:if>">
                                    <a href="contact?pageNo=${pageNo}">
                                        ${pageNo}
                                    </a>
                                </li>
                            </c:forEach> 
                            <li class="page-item page">
                                <c:if test="${pageCurrent != totalPage}">
                                    <a href="contact?pageNo=${pageCurrent + 1}"> Next </a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
