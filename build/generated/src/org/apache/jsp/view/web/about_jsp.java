package org.apache.jsp.view.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/about.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Header -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Content -->\n");
      out.write("            <section class=\"justify-content-center\">\n");
      out.write("                <div class=\"row mb-5 justify-content-center\">\n");
      out.write("                    <div class=\"col-md-8 text-left\">\n");
      out.write("                        <h1>About us</h1>\n");
      out.write("                        <p> Bull House Barbers Barnsley was established in 2018, by business partners and professional barbers Eadon Asquith and Jay O’Neill. \n");
      out.write("                            Jay and Eadon have been working side by side since early 2012 and between them, have more than fifteen years’ experience in barbering.\n");
      out.write("                            After perfecting their art and working at the very top of their game for a number of years, the two made the decision to take their expertise to the next level. \n");
      out.write("                            Thus, the concept for Bull House Barbers was born! A barbershop in Barnsley that offers much more than your average haircut. \n");
      out.write("                            A place for customers to sit back, relax and unwind from the stresses of day to day life. A premium barbershop in all senses of the word; except for the price.\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4\" text-right>\n");
      out.write("                        <iframe width=\"100%\" height=\"500\" src=\"https://www.youtube.com/embed/TJk-cBZdl1A?start=18\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>                    \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <section class=\"pt-5 pb-5\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row mb-5 justify-content-center\">\n");
      out.write("                        <div class=\"col-md-8 text-center\">\n");
      out.write("                            <h1>Team</h1>\n");
      out.write("                            <p class=\"lead\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis quia tempore magni dolore dolorum reprehenderit illum consectetur minima</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <!-- loop all barber in the shop -->\n");
      out.write("                        <div class=\"col-md-6 mb-5\">\n");
      out.write("                            <img src=\"images/img_5.jpg\" alt=\"Image placeholder\" class=\"img-fluid\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 pl-md-5\">\n");
      out.write("                            <h3>Jay Ramzee</h3>\n");
      out.write("                            <p class=\"lead\">Expert Barber</p>\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam facere a excepturi quod impedit rerum ipsum totam incidunt, necessitatibus id veritatis maiores quos saepe dolore commodi magnam fugiat. Incidunt, omnis.</p>\n");
      out.write("                            <p>Nobis quae eaque facere architecto eligendi, voluptas quasi, blanditiis aperiam possimus inventore quis nam! Cupiditate necessitatibus, voluptatem excepturi placeat exercitationem quos vitae ut vero dolorem, provident sit odio porro facere.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- loop all barber in the shop -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <!-- Footer -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
