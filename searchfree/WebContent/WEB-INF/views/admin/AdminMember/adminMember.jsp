<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.searchfree.admin.model.vo.Member"%>
<%
		List<Member> list = (List<Member>)request.getAttribute("memberList");
	%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin Notice</title>

<!-- Custom fonts for this template -->
<link
	href="http://localhost:8080/searchfree/adminResources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="http://localhost:8080/searchfree/adminResources/css/sb-admin-2.min.css"
	rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="http://localhost:8080/searchfree/adminResources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">


<!-- Bootstrap core JavaScript-->
<script
	src="http://localhost:8080/searchfree/adminResources/vendor/jquery/jquery.min.js"></script>

<!-- Core plugin JavaScript-->
<script
	src="http://localhost:8080/searchfree/adminResources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script
	src="http://localhost:8080/searchfree/adminResources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script
	src="http://localhost:8080/searchfree/adminResources/vendor/datatables/jquery.dataTables.min.js"></script>

<!-- Page level custom scripts -->
<script
	src="http://localhost:8080/searchfree/adminResources/js/demo/datatables-demo.js"></script>

</head>



<body id="page-top" class="sidebar-toggled">

	<!-- Page Wrapper -->
	<div id="wrapper">


		<!-- 사이드바 -->
		<!-- Sidebar -->
		<ul class="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="<%=request.getContextPath()%>"> <i class="fas fa-fw fa-cogs"></i>
				<div class="sidebar-brand-text mx-3">SearchFree</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" onclick="location.href='<%=request.getContextPath()%>/admin/main'">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Admin Menu</div>


			<!-- Nav Item - Members -->
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/admin/memberList"> <i
					class="fas fa-fw fa-user"></i> <span>Members</span></a></li>

			<!-- Nav Item - Tables Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTables"
				aria-expanded="true" aria-controls="collapseTables"> <i
					class="fas fa-fw fa-bars"></i> <span>Tables</span>
			</a>
				<div id="collapseTables" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Table</h6>
						<a class="collapse-item" 
						href="<%=request.getContextPath() %>/admin/AdminCategory/categoryManage">Category</a> <a
							class="collapse-item"
							href="<%=request.getContextPath() %>/admin/AdminNotice/NoticeList">Notice</a>
						<a class="collapse-item"
							href="<%=request.getContextPath() %>/admin/AdminNotice/QnaList">Q&A</a>
						<a class="collapse-item"
						href="<%=request.getContextPath() %>/admin/AdminReport/ReportList">Reports</a>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->
		<!-- 사이드바 끝! -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>



						<!-- <div class="topbar-divider d-none d-sm-block"></div> -->

						<!-- <div class="topbar-divider d-none d-sm-block"></div> -->

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Admin
									001</span> <img class="img-profile rounded-circle"
								src="https://image.flaticon.com/icons/png/512/2371/2371561.png">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Content Wrapper -->
				<div id="content-wrapper" class="d-flex flex-column">

					<!-- Begin Page Content -->
					<div class="container-fluid">

						<div class="card shadow mb-4 border-left-primary">
							<div class="card-header py-3">
								<h4 class="m-0 font-weight-bold text-primary">회원 관리</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>No.</th>
												<th>ID</th>
												<th>Name</th>
												<th>E-mail</th>
												<th>Phone</th>
												<th>Level</th>
												<th>EnrollDate</th>
												<th>가입 상태</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>No.</th>
												<th>ID</th>
												<th>Name</th>
												<th>E-mail</th>
												<th>Phone</th>
												<th>Level</th>
												<th>EnrollDate</th>
												<th>가입 상태</th>
											</tr>
										</tfoot>
										<tbody>
										<%if(list.isEmpty()){ %>
										<tr><th colspan="9">회원이 존재하지 않습니다.</th></tr>
										<%}else{ %>
										<%for(Member mem : list){%>
											<tr>
												<td><%=mem.getMemberNo() %>
												</td>
												<td>
													<a href="memberDetail?memNo=<%=mem.getMemberNo()%>"
													id="memberDropdown" role="button" >
							                              <%=mem.getMemberId()%>
							                            </a>
												</td>
												<td><%=mem.getMemberNm()%></td>
												<td><%=mem.getMemberEmail()%></td>
												<td><%=mem.getMemberPhone()%></td>
												<td><% if(mem.getMemberGrade() == '1'){%>
													<p style="color:green;">
														<Strong>일반회원</Strong>
													</p>
													<%}else if(mem.getMemberGrade() == '2'){ %>
														<p style="color:blue;">
														<Strong>우수회원</Strong>
													</p>
													<%}else if(mem.getMemberGrade() == '3'){ %>
														<p style="color:red;">
														<Strong>관리자</Strong>
													</p>
													<%} %>
												</td>
												
												<td><%=mem.getMemberEnrollDate()%></td>
												<td><%=mem.getMemberStatus()%></td>
											</tr>
											<%} %>
											<%} %>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- /.container-fluid -->
				</div>
				<!-- End of Main Content -->


				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2019</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">로그아웃 이후에는 세션이 만료되어 더이상 관리자 페이지를 이용할 수
						없습니다.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">취소</button>
						<a class="btn btn-primary" href="login.html">네</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap core JavaScript-->
		<script
			src="http://localhost:8080/searchfree/adminResources/vendor/jquery/jquery.min.js"></script>
		<script
			src="http://localhost:8080/searchfree/adminResources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="http://localhost:8080/searchfree/adminResources/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script
			src="http://localhost:8080/searchfree/adminResources/js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script
			src="http://localhost:8080/searchfree/adminResources/vendor/datatables/jquery.dataTables.min.js"></script>
		<script
			src="http://localhost:8080/searchfree/adminResources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script
			src="http://localhost:8080/searchfree/adminResources/js/demo/datatables-demo.js"></script>
</body>

</html>