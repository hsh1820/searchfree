/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-02 12:05:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin.AdminReport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.searchfree.admin.model.vo.ReportAll;
import java.util.List;

public final class ReportList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.kh.searchfree.admin.model.vo.ReportAll");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	List<ReportAll> reportList = (List<ReportAll>)request.getAttribute("ReportList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("  <meta name=\"description\" content=\"\">\r\n");
      out.write("  <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("  <title>Admin Report</title>\r\n");
      out.write("\r\n");
      out.write("  <!-- Custom fonts for this template -->\r\n");
      out.write("  <link href=\"http://localhost:8080/searchfree/adminResources/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link\r\n");
      out.write("    href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"\r\n");
      out.write("    rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Custom styles for this template -->\r\n");
      out.write("  <link href=\"http://localhost:8080/searchfree/adminResources/css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Custom styles for this page -->\r\n");
      out.write("  <link href=\"http://localhost:8080/searchfree/adminResources/vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\" class=\"sidebar-toggled\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Page Wrapper -->\r\n");
      out.write("  <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 사이드바 -->\r\n");
      out.write("    <!-- Sidebar -->\r\n");
      out.write("    <ul class=\"navbar-nav bg-gradient-dark sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Sidebar - Brand -->\r\n");
      out.write("\t\t\t<a\r\n");
      out.write("\t\t\t\tclass=\"sidebar-brand d-flex align-items-center justify-content-center\"\r\n");
      out.write("\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("\"> <i class=\"fas fa-fw fa-cogs\"></i>\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-brand-text mx-3\">SearchFree</div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Divider -->\r\n");
      out.write("\t\t\t<hr class=\"sidebar-divider my-0\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Nav Item - Dashboard -->\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/admin/main'\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-fw fa-tachometer-alt\"></i> <span>Dashboard</span>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Heading -->\r\n");
      out.write("      <div class=\"sidebar-heading\">\r\n");
      out.write("        Admin Menu\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Members -->\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/admin/memberList\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-user\"></i> <span>Members</span></a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Tables Collapse Menu -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTables\"\r\n");
      out.write("          aria-expanded=\"true\" aria-controls=\"collapseTables\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-bars\"></i>\r\n");
      out.write("          <span>Tables</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div id=\"collapseTables\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("            <h6 class=\"collapse-header\">Table</h6>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" \r\n");
      out.write("\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/admin/AdminCategory/categoryManage\">Category</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/admin/AdminNotice/NoticeList\">Notice</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/admin/AdminNotice/QnaList\">Q&A</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/admin/AdminReport/ReportList\">Reports</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider d-none d-md-block\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Sidebar Toggler (Sidebar) -->\r\n");
      out.write("      <div class=\"text-center d-none d-md-inline\">\r\n");
      out.write("        <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("    <!-- End of Sidebar -->\r\n");
      out.write("    <!-- 사이드바 끝! -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper -->\r\n");
      out.write("    <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Main Content -->\r\n");
      out.write("      <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("         <!-- Topbar -->\r\n");
      out.write("         <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Sidebar Toggle (Topbar) -->\r\n");
      out.write("          <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\r\n");
      out.write("            <i class=\"fa fa-bars\"></i>\r\n");
      out.write("          </button>\r\n");
      out.write("\r\n");
      out.write("          <!-- Topbar Navbar -->\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Nav Item - Search Dropdown (Visible Only XS) -->\r\n");
      out.write("            <li class=\"nav-item dropdown no-arrow d-sm-none\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"searchDropdown\" role=\"button\" data-toggle=\"dropdown\"\r\n");
      out.write("                aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                <i class=\"fas fa-search fa-fw\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <!-- Dropdown - Messages -->\r\n");
      out.write("              <div class=\"dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in\"\r\n");
      out.write("                aria-labelledby=\"searchDropdown\">\r\n");
      out.write("                <form class=\"form-inline mr-auto w-100 navbar-search\">\r\n");
      out.write("                  <div class=\"input-group\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Search for...\"\r\n");
      out.write("                      aria-label=\"Search\" aria-describedby=\"basic-addon2\">\r\n");
      out.write("                    <div class=\"input-group-append\">\r\n");
      out.write("                      <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("                        <i class=\"fas fa-search fa-sm\"></i>\r\n");
      out.write("                      </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </form>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- <div class=\"topbar-divider d-none d-sm-block\"></div> -->\r\n");
      out.write("\r\n");
      out.write("            <!-- Nav Item - User Information -->\r\n");
      out.write("            <li class=\"nav-item dropdown no-arrow\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\" data-toggle=\"dropdown\"\r\n");
      out.write("                aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">Admin 001</span>\r\n");
      out.write("                <img class=\"img-profile rounded-circle\" src=\"https://image.flaticon.com/icons/png/512/2371/2371561.png\">\r\n");
      out.write("              </a>\r\n");
      out.write("              <!-- Dropdown - User Information -->\r\n");
      out.write("              <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\" aria-labelledby=\"userDropdown\">\r\n");
      out.write("                <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\r\n");
      out.write("                  <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("                  Logout\r\n");
      out.write("                </a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("          </ul>\r\n");
      out.write("\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!-- End of Topbar -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Content Wrapper -->\r\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Begin Page Content -->\r\n");
      out.write("          <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Page Heading -->\r\n");
      out.write("            <!-- <h1 class=\"h3 mb-2 text-gray-800\">전체 회원 조회</h1> -->\r\n");
      out.write("\r\n");
      out.write("            <!-- DataTales Example -->\r\n");
      out.write("            <!-- 테이블 시작 -->\r\n");
      out.write("            <div class=\"card shadow mb-4 border-left-primary\">\r\n");
      out.write("              <div class=\"card-header py-3\">\r\n");
      out.write("                <h4 class=\"m-0 font-weight-bold text-primary\">신고게시판 관리</h4>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"card-body \">\r\n");
      out.write("                <div class=\"table-responsive\">\r\n");
      out.write("                  <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <th>No.</th>\r\n");
      out.write("                        <th>신고 사유</th>\r\n");
      out.write("                        <th>Reported Id</th>\r\n");
      out.write("                        <th>Reported Date</th>\r\n");
      out.write("                        <th>Status</th>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tfoot>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <th>No.</th>\r\n");
      out.write("                        <th>신고 사유</th>\r\n");
      out.write("                        <th>Reported Id</th>\r\n");
      out.write("                        <th>Reported Date</th>\r\n");
      out.write("                        <th>Status</th>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                    </tfoot>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                   \r\n");
      out.write("                    ");
if (reportList.isEmpty()) { 
      out.write("\r\n");
      out.write("                    <tr><td colspan=\"5\" style=\"text-align: center;\" >신고 게시글이 존재하지 않습니다.</td></tr>\r\n");
      out.write("                    ");
}else{ 
      out.write("\r\n");
      out.write("                    \t");
for(ReportAll pl : reportList) { 
                    		int i = 1; 
      out.write("\r\n");
      out.write("                    \t\t<tr>\r\n");
      out.write("                    \t\t\t<td>");
      out.print(i );
      out.write("</td>\r\n");
      out.write("                    \t\t\t<td>");
if(pl.getReportCode()==11){ 
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">댓글 욕설</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==12){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">댓글 광고</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==13){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">댓글 부적절한 컨텐츠</a>\r\n");
      out.write("                   \t\t\t\t");
} else if(pl.getReportCode()==21){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">리뷰 욕설</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==22){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">리뷰 광고</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==23){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">리뷰 부적절한 컨텐츠</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==31){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">쪽지 욕설</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==32){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">쪽지 광고</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==33){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">쪽지 부적절한 컨텐츠</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==41){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">프로젝트 욕설</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==42){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">프로젝트 광고</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==43){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">프로젝트 부적절한 컨텐츠</a>\r\n");
      out.write("                    \t\t\t");
} else if(pl.getReportCode()==51){
      out.write("\r\n");
      out.write("                    \t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">회원 욕설</a>\r\n");
      out.write("                   \t\t\t\t");
} else if(pl.getReportCode()==52){
      out.write("\r\n");
      out.write("                   \t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">회원 광고</a>\r\n");
      out.write("                   \t\t\t\t");
} else {
      out.write("\r\n");
      out.write("                   \t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/reportList\">회원 부적절한 컨텐츠</a>\r\n");
      out.write("                   \t\t\t\t");
} 
      out.write("\r\n");
      out.write("                    \t\t\t</td>\r\n");
      out.write("                    \t\t\t<td>");
      out.print(pl.getMemberId() );
      out.write("</td>\r\n");
      out.write("                    \t\t\t<td>");
      out.print(pl.getReportCreateDT() );
      out.write("</td>\r\n");
      out.write("                    \t\t\t<td>\r\n");
      out.write("                    \t\t\t<a href=\"#\" id=\"statusdropdown\" role=\"button\" data-toggle=\"dropdown\"\r\n");
      out.write("                        \t\t  aria-haspopup=\"true\" aria-expanded=\"false\" > 확인 전\r\n");
      out.write("                        \t\t  </a>\r\n");
      out.write("                    \t\t\t</td>\r\n");
      out.write("                    \t\t</tr>\r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                      <!-- <tr>\r\n");
      out.write("                        <td>1</td>\r\n");
      out.write("                        <td><a href=\"admin_report_detail.html\">M001</a></td>\r\n");
      out.write("                        <td>user11</td>\r\n");
      out.write("                        <td>2019/12/31</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                          신고 관리 목록에서 처리\r\n");
      out.write("                          <a href=\"#\" id=\"statusdropdown\" role=\"button\" data-toggle=\"dropdown\"\r\n");
      out.write("                          aria-haspopup=\"true\" aria-expanded=\"false\" > 확인 전\r\n");
      out.write("                          </a>\r\n");
      out.write("                          <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow\"\r\n");
      out.write("                          aria-labelledby=\"statusdropdown\">\r\n");
      out.write("                          <div class=\"dropdown-header bg-primary\" id=\"statusdropdown\">\r\n");
      out.write("                          <span class=\"text-white\">상태변경</span></div>\r\n");
      out.write("                          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                          <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n");
      out.write("                            <span class=\"font-weight-bold\">처리완료</span>\r\n");
      out.write("                          </a>\r\n");
      out.write("                          <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n");
      out.write("                            <span class=\"font-weight-bold\">검토중</span>\r\n");
      out.write("                          </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </td>\r\n");
      out.write("                      </tr>  -->\r\n");
      out.write("                      \r\n");
      out.write("                    </tbody>\r\n");
      out.write("                  </table>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"admin btn\" class=\"float-right py-sm-4 \">\r\n");
      out.write("                <!-- 관리 버튼 -->\r\n");
      out.write("                  <!-- <a href=\"admin_editor.html\" class=\"btn btn-primary btn-icon-split\"><span class=\"text\"><i class=\"fas fa-wrench\"></i>&nbsp;수정</span></a>\r\n");
      out.write("                  <a href=\"admin_editor.html\" class=\"btn btn-primary btn-icon-split\"><span class=\"text\"><i class=\"fas fa-file-alt\"></i>&nbsp;등록</span></a>\r\n");
      out.write("                  <a href=\"#\" class=\"btn btn-danger btn-icon-split\"><span class=\"text\"><i class=\"fas fa-trash\"></i>&nbsp;삭제</span></a> -->\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              \r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- 테이블 끝 -->\r\n");
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer -->\r\n");
      out.write("        <footer class=\"sticky-footer bg-white\">\r\n");
      out.write("          <div class=\"container my-auto\">\r\n");
      out.write("            <div class=\"copyright text-center my-auto\">\r\n");
      out.write("              <span>Copyright &copy; Your Website 2019</span>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <!-- End of Footer -->\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End of Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Scroll to Top Button-->\r\n");
      out.write("    <a class=\"scroll-to-top rounded\" href=\"#page-top\">\r\n");
      out.write("      <i class=\"fas fa-angle-up\"></i>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("  <!-- Logout Modal-->\r\n");
      out.write("  <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <h5 class=\"modal-title\" id=\"exampleModalLabel\">로그아웃 하시겠습니까?</h5>\r\n");
      out.write("          <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("            <span aria-hidden=\"true\">×</span>\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">로그아웃 이후에는 세션이 만료되어 더이상 관리자 페이지를 이용할 수 없습니다.</div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("          <a class=\"btn btn-primary\" href=\"login.html\">네</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript-->\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Core plugin JavaScript-->\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom scripts for all pages-->\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/js/sb-admin-2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page level plugins -->\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/vendor/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/vendor/datatables/dataTables.bootstrap4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page level custom scripts -->\r\n");
      out.write("    <script src=\"http://localhost:8080/searchfree/adminResources/js/demo/datatables-demo.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
