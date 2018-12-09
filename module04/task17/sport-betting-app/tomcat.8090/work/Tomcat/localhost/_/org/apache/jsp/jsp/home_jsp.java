/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2018-12-09 20:44:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Sports bet</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\n");
      out.write("      <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("  <script>\n");
      out.write("  function validate()\n");
      out.write("  {\n");
      out.write("   var username = document.accountInfo.username.value;\n");
      out.write("   var birthday = document.accountInfo.birthday.value;\n");
      out.write("   var account = document.accountInfo.account.value;\n");
      out.write("   var currency = document.accountInfo.currency.value;\n");
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
      out.write("    <form action=\"/home\" method=\"post\" onsubmit=\"return validate()\">\n");
      out.write("      <div id=\"accountInfo\" class=\"input-group form-group\" >\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Name</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"username\" name=\"username\" required=\"\" type=\"text\" placeholder=\"Arnold Schwarzenegger\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your username is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Date of Birth:</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"birthday\" name=\"birthday\" required=\"\" type=\"text\" placeholder=\"1947-07-30\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your date of Birth is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Account number:</span>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"form-control\" id=\"account\" name=\"account\" required=\"\" type=\"text\" placeholder=\"12345678-12345678\">\n");
      out.write("        <div class=\"invalid-feedback\" style=\"width: 100%;\">\n");
      out.write("          Your account number is required.\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"input-group form-group\">\n");
      out.write("        <div class=\"input-group-prepend\">\n");
      out.write("          <span class=\"input-group-text\">Currency:</span>\n");
      out.write("        </div>\n");
      out.write("        <select class=\"custom-select\" id=\"currency\" name=\"currency\" required=\"\">\n");
      out.write("          <option value=\"USD\">USD</option>\n");
      out.write("          <option value=\"EUR\">EUR</option>\n");
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
      out.write("        <input class=\"form-control\" id=\"balance\" name=\"balance\" required=\"\" type=\"text\" placeholder=\"99999999\">\n");
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
