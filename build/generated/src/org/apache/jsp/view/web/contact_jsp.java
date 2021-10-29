package org.apache.jsp.view.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title> Contact us </title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Header -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <div style=\"text-align: center\"><h1>Contact us</h1></div>\n");
      out.write("            <section class=\"site-section\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <form action=\"contact\" method=\"post\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-4 form-group\">\n");
      out.write("                                        <label for=\"name\">Name</label>\n");
      out.write("                                        <input type=\"text\"  class=\"form-control\" name=\"name\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-4 form-group\">\n");
      out.write("                                        <label for=\"email\">Email</label>\n");
      out.write("                                        <input type=\"email\"  class=\"form-control \" name=\"email\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-4 form-group\">\n");
      out.write("                                        <label for=\"phone\">Title</label>\n");
      out.write("                                        <input type=\"text\"  class=\"form-control\" name=\"title\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12 form-group\">\n");
      out.write("                                        <label for=\"detail\">Detail</label>\n");
      out.write("                                        <textarea name=\"detail\" class=\"form-control\" cols=\"30\" rows=\"8\"></textarea>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-6 form-group\">\n");
      out.write("                                        <input type=\"submit\" value=\"Send Message\" class=\"btn btn-primary\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!-- END section -->\n");
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
