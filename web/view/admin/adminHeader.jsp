<%-- 
    Document   : adminHeader
    Created on : Oct 31, 2021, 3:23:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .headerBar{
                background-color: black;
            }

            .headerBar li a{
                font-size: 22px;
                color: white;
                margin-left: 0px;
            }
            .info{
                padding-left: 30px;
                color: background;
                font-size:30px;
                font-family: serif;
            }
            .headerBar li a:hover{
                background-color: activeborder;
                color: orange;
                font-weight: 700;
                transition: 0.4s;
            }
            .info span{
                color: #00cc33;

            }
        </style>
    </head>
    <body>
        <ul class="nav flex-column flex-sm-row justify-content-center headerBar">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/customer">Customers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/employee">Employees</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/service">Services</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/appointment">Appointments</a>
            </li>
             <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/accounts">Accounts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link login" href="${pageContext.request.contextPath}/logout" 
                   style="color: #00cc33; border: 1px solid orange" >Logout</a>
            </li>
        </ul> 
        <div class="info">
            <b> Welcome </b> <span> Your info </span>
        </div>
    </body>
</html>
