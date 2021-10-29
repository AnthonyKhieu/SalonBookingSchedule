package org.apache.jsp.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class account_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/customerTable.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Bootstrap Simple Data Table</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('[data-toggle=\"tooltip\"]').tooltip();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-xl\">\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <div class=\"table-wrapper\">\n");
      out.write("                    <div class=\"table-title\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-8\"><h2>Customer <b>Details</b></h2></div>\n");
      out.write("                            <div class=\"col-sm-4\">\n");
      out.write("                                <div class=\"search-box\">\n");
      out.write("                                    <i class=\"material-icons\">&#xE8B6;</i>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Search&hellip;\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <table class=\"table table-striped table-hover table-bordered\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Name <i class=\"fa fa-sort\"></i></th>\n");
      out.write("                                <th>Address</th>\n");
      out.write("                                <th>City <i class=\"fa fa-sort\"></i></th>\n");
      out.write("                                <th>Pin Code</th>\n");
      out.write("                                <th>Country <i class=\"fa fa-sort\"></i></th>\n");
      out.write("                                <th>Actions</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>Thomas Hardy</td>\n");
      out.write("                                <td>89 Chiaroscuro Rd.</td>\n");
      out.write("                                <td>Portland</td>\n");
      out.write("                                <td>97219</td>\n");
      out.write("                                <td>USA</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"#\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>2</td>\n");
      out.write("                                <td>Maria Anders</td>\n");
      out.write("                                <td>Obere Str. 57</td>\n");
      out.write("                                <td>Berlin</td>\n");
      out.write("                                <td>12209</td>\n");
      out.write("                                <td>Germany</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"#\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>3</td>\n");
      out.write("                                <td>Fran Wilson</td>\n");
      out.write("                                <td>C/ Araquil, 67</td>\n");
      out.write("                                <td>Madrid</td>\n");
      out.write("                                <td>28023</td>\n");
      out.write("                                <td>Spain</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"#\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>4</td>\n");
      out.write("                                <td>Dominique Perrier</td>\n");
      out.write("                                <td>25, rue Lauriston</td>\n");
      out.write("                                <td>Paris</td>\n");
      out.write("                                <td>75016</td>\n");
      out.write("                                <td>France</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"#\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>5</td>\n");
      out.write("                                <td>Martin Blank</td>\n");
      out.write("                                <td>Via Monte Bianco 34</td>\n");
      out.write("                                <td>Turin</td>\n");
      out.write("                                <td>10100</td>\n");
      out.write("                                <td>Italy</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"#\" class=\"view\" title=\"View\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n");
      out.write("                                    <a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>        \n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <div class=\"clearfix\">\n");
      out.write("                        <div class=\"hint-text\">Showing <b>5</b> out of <b>25</b> entries</div>\n");
      out.write("                        <ul class=\"pagination\">\n");
      out.write("                            <li class=\"page-item disabled\"><a href=\"#\"><i class=\"fa fa-angle-double-left\"></i></a></li>\n");
      out.write("                            <li class=\"page-item\"><a href=\"#\" class=\"page-link\">1</a></li>\n");
      out.write("                            <li class=\"page-item\"><a href=\"#\" class=\"page-link\">2</a></li>\n");
      out.write("                            <li class=\"page-item active\"><a href=\"#\" class=\"page-link\">3</a></li>\n");
      out.write("                            <li class=\"page-item\"><a href=\"#\" class=\"page-link\">4</a></li>\n");
      out.write("                            <li class=\"page-item\"><a href=\"#\" class=\"page-link\">5</a></li>\n");
      out.write("                            <li class=\"page-item\"><a href=\"#\" class=\"page-link\"><i class=\"fa fa-angle-double-right\"></i></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>  \n");
      out.write("        </div>\n");
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
