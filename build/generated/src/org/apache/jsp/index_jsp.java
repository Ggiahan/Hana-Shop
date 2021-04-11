package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hanlg.tblCategory.tblCategoryDTO;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_redirect_url_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <!-- Basic -->\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Mobile Metas -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Site Metas -->\r\n");
      out.write("        <title>Hana Shop - Home</title>\r\n");
      out.write("        <meta name=\"keywords\" content=\"\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Site Icons -->\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"images/logo2.png\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <!-- Site CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <!-- Responsive CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n");
      out.write("        <!-- Custom CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\r\n");
      out.write("\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <!-- Start Main Top -->\r\n");
      out.write("        <div class=\"main-top\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                        <div class=\"our-link\">\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    ");

                                        if (session.getAttribute("Fullname") != null) {
                                            String fullname = session.getAttribute("Fullname").toString();
                                    
      out.write("\r\n");
      out.write("                                    <a style=\"color: white\"><i class=\"fa fa-user \" ></i> WELCOME ");
out.print(fullname);
      out.write("</a>\r\n");
      out.write("                                    ");
} else if (session.getAttribute("email") != null) {
                                            String email = session.getAttribute("email").toString();

                                    
      out.write("\r\n");
      out.write("                                    <a style=\"color: white\"><i class=\"fa fa-user \" ></i> WELCOME ");
out.print(email);
      out.write("</a>\r\n");
      out.write("                                    ");
}else {
      out.write("\r\n");
      out.write("                                    <a href=\"login.jsp\"><i class=\"fa fa-user s_color\"></i> My Account</a>\r\n");
      out.write("                                    ");
}
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                    \r\n");
      out.write("                                    \r\n");
      out.write("                                   \r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!--\r\n");
      out.write("    <li><a href=\"#\"><i class=\"fas fa-location-arrow\"></i> Our location</a></li>\r\n");
      out.write("    <li><a href=\"#\"><i class=\"fas fa-headset\"></i> Contact Us</a></li>\r\n");
      out.write("                                -->\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\r\n");
      out.write("                        <div class=\"login-box\">\r\n");
      out.write("                              ");

                                            if (session.getAttribute("Fullname") != null) {
                                        
      out.write("\r\n");
      out.write("                            <form action=\"DispatchServlet\">\r\n");
      out.write("                                <button class=\"btn-danger\" type=\"submit\" value=\"Sign Out\" name=\"btAction\">Sign Out  </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            ");
 }else if (session.getAttribute("email") != null) {
                                        
      out.write("\r\n");
      out.write("                            <form action=\"DispatchServlet\">\r\n");
      out.write("                                <button class=\"btn-danger\" type=\"submit\" value=\"Sign Out\" name=\"btAction\">Sign Out  </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                       \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End Main Top -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Start Main Top -->\r\n");
      out.write("        <header class=\"main-header\">\r\n");
      out.write("            <!-- Start Navigation -->\r\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <!-- Start Header Navigation -->\r\n");
      out.write("                    <div class=\"navbar-header\">\r\n");
      out.write("                        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-menu\" aria-controls=\"navbars-rs-food\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                            <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"images/logo2.png\" class=\"logo\" alt=\"\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- End Header Navigation -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbar-menu\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav ml-auto\" data-in=\"fadeInDown\" data-out=\"fadeOutUp\">\r\n");
      out.write("                            <li class=\"nav-item active\"><a class=\"nav-link\" href=\"DispatchServlet?btAction=LoadAllproduct\">Home</a></li>                          \r\n");
      out.write("                                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"DispatchServlet?btAction=ShowProductOfCategory&category=All\">Menu</a></li>  \r\n");
      out.write("                            <li class=\"nav-item\"><a class=\"nav-link\" href=\"cart.jsp\"> <i class=\"fa fa-shopping-bag\"></i>\r\n");
      out.write("                                    \r\n");
      out.write("                                    My Cart</a></li>\r\n");
      out.write("                            <li class=\"nav-item\"><a class=\"nav-link\" href=\"checkout.jsp\">Checkout</a></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.navbar-collapse -->\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("            </nav>\r\n");
      out.write("            <!-- End Navigation -->\r\n");
      out.write("        </header>\r\n");
      out.write("        <!-- End Main Top -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Start Top Search -->\r\n");
      out.write("        <div class=\"top-search\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"input-group\">\r\n");
      out.write("                    <span class=\"input-group-addon\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("                    <span class=\"input-group-addon close-search\"><i class=\"fa fa-times\"></i></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End Top Search -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Start Slider -->\r\n");
      out.write("        <div id=\"slides-shop\" class=\"cover-slides\">\r\n");
      out.write("            <ul class=\"slides-container\">\r\n");
      out.write("                <li class=\"text-center\">\r\n");
      out.write("                    <img src=\"images/background.jpg\" alt=\"\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <h1 class=\"m-b-20\"><strong>Welcome To <br> Hana Shop</strong></h1>\r\n");
      out.write("                                <p class=\"m-b-40\">If this is coffee, please bring me some tea\r\n");
      out.write("                                    <br>But if this is tea, please bring me some coffee.</p>\r\n");
      out.write("                                <p><a class=\"btn hvr-hover\" href=\"#\">Shop New</a></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"text-center\">\r\n");
      out.write("                    <img src=\"images/banner-02.jpg\" alt=\"\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <h1 class=\"m-b-20\"><strong>Welcome To <br> Hana Shop</strong></h1>\r\n");
      out.write("                                <p class=\"m-b-40\">If this is coffee, please bring me some tea\r\n");
      out.write("                                    <br>But if this is tea, please bring me some coffee.</p>\r\n");
      out.write("                                <p><a class=\"btn hvr-hover\" href=\"#\">Shop New</a></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"text-center\">\r\n");
      out.write("                    <img src=\"images/banner-03.jpg\" alt=\"\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <h1 class=\"m-b-20\"><strong>Welcome To <br> Hana Shop</strong></h1>\r\n");
      out.write("                                <p class=\"m-b-40\">If this is coffee, please bring me some tea\r\n");
      out.write("                                    <br>But if this is tea, please bring me some coffee.</p>\r\n");
      out.write("                                <p><a class=\"btn hvr-hover\" href=\"#\">Shop New</a></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"slides-navigation\">\r\n");
      out.write("                <a href=\"#\" class=\"next\"><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("                <a href=\"#\" class=\"prev\"><i class=\"fa fa-angle-left\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End Slider -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Start Categories  -->\r\n");

            List<tblCategoryDTO> result = (List<tblCategoryDTO>) session.getAttribute("LISTCATEGORY");
            if (result != null) {
        
      out.write("\r\n");
      out.write("        <div class=\"categories-shop\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    ");

                int count = 0;
                for (tblCategoryDTO dto : result) {
                    String urlRewriting = "DispatchServlet"
                                + "?btAction=ShowProductOfCategory"
                                + "&category=" + dto.getCategoryname()
                                ;
            
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                <form action=\"DispatchServlet\">\r\n");
      out.write("                        <div class=\"shop-cat-box\">\r\n");
      out.write("                            <img class=\"img-fluid\" src=\"images/");
      out.print( dto.getCategoryname());
      out.write(".jpg\" alt=\"\" />\r\n");
      out.write("                            <a class=\"btn hvr-hover\" href=\"");
      out.print(urlRewriting);
      out.write("\" value=\" ");
      out.print( dto.getCategoryname());
      out.write(" \">");
      out.print( dto.getCategoryname());
      out.write("</a>                          \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>     \r\n");
      out.write("                    </div>\r\n");
      out.write("           \r\n");
      out.write("                        ");

                }
            
      out.write(" \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                    ");

            }
        
      out.write("\r\n");
      out.write("        <!-- End Categories -->\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("        <a href=\"#\" id=\"back-to-top\" title=\"Back to top\" style=\"display: none;\">&uarr;</a>\r\n");
      out.write("\r\n");
      out.write("        <!-- ALL JS FILES -->\r\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- ALL PLUGINS -->\r\n");
      out.write("        <script src=\"js/jquery.superslides.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap-select.js\"></script>\r\n");
      out.write("        <script src=\"js/inewsticker.js\"></script>\r\n");
      out.write("        <script src=\"js/bootsnav.js.\"></script>\r\n");
      out.write("        <script src=\"js/images-loded.min.js\"></script>\r\n");
      out.write("        <script src=\"js/isotope.min.js\"></script>\r\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"js/baguetteBox.min.js\"></script>\r\n");
      out.write("        <script src=\"js/form-validator.min.js\"></script>\r\n");
      out.write("        <script src=\"js/contact-form-script.js\"></script>\r\n");
      out.write("        <script src=\"js/custom.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.role=='ADMIN'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("             ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_redirect_0.setUrl("DispatchServlet?btAction=managersearch&category=All");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }
}
