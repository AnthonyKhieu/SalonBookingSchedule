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
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>
            <div style="text-align: center"><h1>Contact us</h1></div>
            <section class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <form action="contact" method="post">
                                <div class="row">
                                    <div class="col-md-4 form-group">
                                        <label for="name">Name</label>
                                        <input type="text"  class="form-control" name="name">
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="email">Email</label>
                                        <input type="email"  class="form-control " name="email">
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="phone">Title</label>
                                        <input type="text"  class="form-control" name="title">
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label for="detail">Detail</label>
                                        <textarea name="detail" class="form-control" cols="30" rows="8"></textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <input type="submit" value="Send Message" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END section -->

            <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
