<%-- 
    Document   : about
    Created on : Oct 7, 2021, 8:48:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Content -->
            <section class="justify-content-center">
                <div class="row mb-5 justify-content-center">
                    <div class="col-md-8 text-left">
                        <h1>About us</h1>
                        <p> Bull House Barbers Barnsley was established in 2018, by business partners and professional barbers Eadon Asquith and Jay O’Neill. 
                        Jay and Eadon have been working side by side since early 2012 and between them, have more than fifteen years’ experience in barbering.
                        After perfecting their art and working at the very top of their game for a number of years, the two made the decision to take their expertise to the next level. 
                        Thus, the concept for Bull House Barbers was born! A barbershop in Barnsley that offers much more than your average haircut. 
                        A place for customers to sit back, relax and unwind from the stresses of day to day life. A premium barbershop in all senses of the word; except for the price.
                        </p>
                        <iframe width="100%" height="500" src="https://www.youtube.com/embed/TJk-cBZdl1A?start=18" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>                    
                    </div>
                </div>
            </section>
            <section class="pt-5 pb-5">
                <div class="container">
                    <div class="row mb-5 justify-content-center">
                        <div class="col-md-8 text-center">
                            <h1>Team</h1>
                            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis quia tempore magni dolore dolorum reprehenderit illum consectetur minima</p>
                        </div>
                    </div>
                    <div class="row">
                        <!-- loop all barber in the shop -->
                        <div class="col-md-6 mb-5">
                            <img src="images/img_5.jpg" alt="Image placeholder" class="img-fluid">
                        </div>
                        <div class="col-md-6 pl-md-5">
                            <h3>Jay Ramzee</h3>
                            <p class="lead">Expert Barber</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam facere a excepturi quod impedit rerum ipsum totam incidunt, necessitatibus id veritatis maiores quos saepe dolore commodi magnam fugiat. Incidunt, omnis.</p>
                            <p>Nobis quae eaque facere architecto eligendi, voluptas quasi, blanditiis aperiam possimus inventore quis nam! Cupiditate necessitatibus, voluptatem excepturi placeat exercitationem quos vitae ut vero dolorem, provident sit odio porro facere.</p>
                        </div>
                        <!-- loop all barber in the shop -->
                    </div>
                </div>
            </section>

            <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
