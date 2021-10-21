<%-- 
    Document   : contact
    Created on : Oct 7, 2021, 8:48:34 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Contact us </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
        </style>
        <script>
            function mess(){
                window.alert("Submit successfully!");
            }
        </script>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <h3>Contact Form</h3>

            <div class="container">
                <form action="contact" method="post">
                    <label for="name">Full Name</label>
                    <input type="text" name="name" placeholder="Your name..." required="">

                    <label for="email">Email</label>
                    <input type="text" name="email" placeholder="Your email...">
                    
                    <label for="title">Title</label>
                    <input type="text" name="title" placeholder="Title...">
                    
                    <label for="detail">Detail</label>
                    <textarea name="detail" placeholder="Write something.." style="height:200px"></textarea>

                    <input onclick="mess()" type="submit" value="Submit">
                </form>
            </div>
            
            <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
