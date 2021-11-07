<%-- 
    Document   : accountList
    Created on : Oct 31, 2021, 7:01:14 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
                height: 30px;
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
            .myForm{
                width: 50%;
                margin: 30px auto;
            }
        </style>
    </head>
    <body>
        <jsp:include page="adminHeader.jsp"></jsp:include>
            <div class="myForm">
                <form action="account" method="POST">   
                    <h2> New Account </h2>
                    <label for="Username"> Username  </label> <button> Check Account </button>
                    <input type="text" class="form-control" name="username" value="${requestScope.username}" required><br>
                    <label for="Password"> Password   </label>
                    <input type="text" class="form-control"  name="password" required><br>
                    <select name="role">
                        <option value="1"> Admin </option>
                        <option value="2"> Employee</option>
                    </select>
                <c:if test="${requestScope.mess == 'OK'}">
                    <input type="submit" value="Submit">
                </c:if>
            </form>
        </div>
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
