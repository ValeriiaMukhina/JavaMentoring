/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.48
 * Generated at: 2018-12-03 20:39:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/Users/valeriia/Documents/Valeriia/GitLab/JavaMentoring/module04/task17/servlet-with-spring-example/temp/ROOT/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1543346300000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Sports bet</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"/js/bootstrap.min.js\"></script>\n");
      out.write("  <script>\n");
      out.write("  function validate()\n");
      out.write("  {\n");
      out.write("   var username = document.accountInfo.username.value;\n");
      out.write("   var birthday = document.accountInfo.birthday.value;\n");
      out.write("   var account = document.accountInfo.account.value;\n");
      out.write("   var currency = document.accountInfo.currencySelect.value;\n");
      out.write("   var balance = document.accountInfo.balance.value;\n");
      out.write("\n");
      out.write("   if (username==null || username==\"\")\n");
      out.write("   {\n");
      out.write("   alert(\"User Name can't be blank\");\n");
      out.write("   return false;\n");
      out.write("   }\n");
      out.write("   else if (birthday==null || birthday==\"\")\n");
      out.write("   {\n");
      out.write("   alert(\"Date of birth can't be blank\");\n");
      out.write("   return false;\n");
      out.write("   }\n");
      out.write("   else if (account==null || account==\"\")\n");
      out.write("   {\n");
      out.write("   alert(\"Account number can't be blank\");\n");
      out.write("   return false;\n");
      out.write("   }\n");
      out.write("   else if (balance==null || balance==\"\")\n");
      out.write("   {\n");
      out.write("   alert(\"Balance can't be blank\");\n");
      out.write("   return false;\n");
      out.write("   }\n");
      out.write("  </script>\n");
      out.write("  <style>\n");
      out.write("  .fakeimg {\n");
      out.write("      height: 200px;\n");
      out.write("      background: #aaa;\n");
      out.write("  }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("<div class=\"card border-primary\">\n");
      out.write("  <div class=\"card-header text-white bg-primary\">Account details</div>\n");
      out.write("  <div class=\"card-body\">\n");
      out.write("    <form action=\"RegisterServlet\" method=\"post\" onsubmit=\"return validate()\">\n");
      out.write("      <div id=\"accountInfo\" class=\"input-group form-group\" >\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Name</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"username\" required=\"\" type=\"text\" placeholder=\"Arnold Schwarzenegger\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your username is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Date of Birth:</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"birthday\" required=\"\" type=\"text\" placeholder=\"1947-07-30\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your date of Birth is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Account number:</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"account\" required=\"\" type=\"text\" placeholder=\"12345678-12345678\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your account number is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Currency:</span>\n");
      out.write("        </div>\n");
      out.write("        <select class=\"custom-select\" id=\"currencySelect\" required=\"\">\n");
      out.write("          <option value=\"\">USD</option>\n");
      out.write("          <option>EUR</option>\n");
      out.write("        </select>\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your currency is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Balance:</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"balance\" required=\"\" type=\"text\" placeholder=\"99999999\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your balance is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <button type=\"submit\" class=\"btn btn-primary\">Save</button>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("<div class=\"container\">\n");
      out.write("<div class=\"card border-primary\">\n");
      out.write("  <div class=\"card-header text-white bg-primary\">Wagers</div>\n");
      out.write("  <div class=\"card-body\">\n");
      out.write("    <div class=\"table-responsive\">\n");
      out.write("    <table class=\"table table-sm text-nowrap row-eq-height\">\n");
      out.write("    <thead>\n");
      out.write("    <tr>\n");
      out.write("      <th></th>\n");
      out.write("      <th>#</th>\n");
      out.write("      <th>Event title</th>\n");
      out.write("      <th>Event type</th>\n");
      out.write("      <th>Bet type</th>\n");
      out.write("      <th>Outcome value</th>\n");
      out.write("      <th>Outcome odd</th>\n");
      out.write("      <th>Wager amount</th>\n");
      out.write("      <th>Winner</th>\n");
      out.write("      <th>Processed</th>\n");
      out.write("    </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("    <tr>\n");
      out.write("      <td>\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary\">Remove</button>\n");
      out.write("      </td>\n");
      out.write("      <th scope=\"row\"> 1 </th>\n");
      out.write("      <td>MTK-FTC - 2018.01.12</td>\n");
      out.write("      <td>Football match</td>\n");
      out.write("      <td>Winner</td>\n");
      out.write("      <td>MTK</td>\n");
      out.write("      <td>1:2</td>\n");
      out.write("      <td>10 000 USD</td>\n");
      out.write("      <td>-</td>\n");
      out.write("      <td>-</td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td></td>\n");
      out.write("      <th scope=\"row\"> 2 </th>\n");
      out.write("      <td>MTK-FTC - 2018.01.12</td>\n");
      out.write("      <td>Football match</td>\n");
      out.write("      <td>Goals</td>\n");
      out.write("      <td>5</td>\n");
      out.write("      <td>1:3</td>\n");
      out.write("      <td>10 000 USD</td>\n");
      out.write("      <td>Yes</td>\n");
      out.write("      <td>Yes</td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td></td>\n");
      out.write("      <th scope=\"row\"> 3 </th>\n");
      out.write("      <td>MTK-FTC - 2018.01.12</td>\n");
      out.write("      <td>Football match</td>\n");
      out.write("      <td>Winner</td>\n");
      out.write("      <td>FTC</td>\n");
      out.write("      <td>1:5</td>\n");
      out.write("      <td>10 000 USD</td>\n");
      out.write("      <td>No</td>\n");
      out.write("      <td>Yes</td>\n");
      out.write("    </tr>\n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
