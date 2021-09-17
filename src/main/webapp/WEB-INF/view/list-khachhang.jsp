<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="btl.salecomputers.util.SortUtils"%>

<!DOCTYPE html>
<html>
<head>

<title>Danh sách khách hàng</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/trangchu.css" />

</head>
<body>

	<c:url var="editImgUrl" value="/resources/img/edit.png" />
	<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
	<c:url var="viewImg1" value="/resources/img/eye1.png" />


	<c:url var="sortLinkGiaTang" value="/">
		<c:param name="sort" value="giatang"></c:param>
	</c:url>
	<c:url var="sortLinkGiaGiam" value="/">
		<c:param name="sort" value="giagiam"></c:param>
	</c:url>
	<c:url var="sortLinkRamTang" value="/">
		<c:param name="sort" value="ramtang"></c:param>
	</c:url>
	<c:url var="sortLinkRamGiam" value="/">
		<c:param name="sort" value="ramgiam"></c:param>
	</c:url>


	<div class="header">
		<table>
			<tr>
				<td><b><font size="6" color=black>COMPUTER</font></b><i>Website.Laptop:</i></td>
				<td><form:form
						action="${pageContext.request.contextPath}/search" method="GET">
						<input type="text" name="theSearchName"
							style="width: 400px; height: 25px;" />

						<input type="submit" value="Search" class="add-button"
							style="height: 30px;" />

					</form:form></td>
				<td width="20"></td>
				<td width="140">Email:<br> ${email}
				</td>
				<td><form:form
						action="${pageContext.request.contextPath}/showMyLoginPage"
						method="GET">
						<input type="submit" value="Đăng nhập" />
					</form:form> <form:form action="${pageContext.request.contextPath}/logout"
						method="POST">
						<input type="submit" value="Đăng xuất " />

					</form:form></td>

			</tr>
		</table>


	</div>
	<div class="topnav" id="myTopnav">
		<a href="${pageContext.request.contextPath}/" class="active">Home</a>
		<a href="${pageContext.request.contextPath}/">News</a>
		<div class="dropdown">
			<button class="dropbtn">
				Thương hiệu <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<c:forEach var="thuonghieu" items="${thuonghieus}">
					<a href="#">${thuonghieu.tenTH}</a>
				</c:forEach>

			</div>

		</div>



		<div class="dropdown">
			<button class="dropbtn">
				Sắp xếp giá <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="${sortLinkGiaTang}">Giá tăng dần</a> <a
					href="${ sortLinkGiaGiam}">Giá giảm dần</a>
			</div>

		</div>

		<div class="dropdown">
			<button class="dropbtn">
				Sắp xếp RAM <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="${sortLinkRamTang}">RAM tăng dần</a> <a
					href="${sortLinkRamGiam}">RAM giảm dần</a>
			</div>

		</div>
		<a href="#contact">Contact</a>

		<security:authorize access="hasRole('EMPLOYEE')">
			<a href="${pageContext.request.contextPath}/maytinh/showFormForAdd">Thêm
				Máy Tính</a>
			<a href="${pageContext.request.contextPath}/khachhang/list">Quản
				lý Khách Hàng</a>
		</security:authorize>
		<security:authorize access="hasRole('CUSTOMER')">
			<a href="${pageContext.request.contextPath}/giohang/xemGioHang">
				Giỏ hàng</a>
		</security:authorize>










	</div>








	<c:url var="editImgUrl" value="/resources/img/edit.png" />
	<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
	<c:url var="viewImgUrl" value="/resources/img/eye.png" />
	<c:url var="addUrl" value="/register/showRegistrationForm" />
	<p>
		<a href="${addUrl}">Thêm mới khách hàng</a>
	</p>

	<form:form action="search" method="GET">
					Tìm kiếm khách hàng: <input type="text" name="strFind" />

		<input type="submit" value="Search" class="add-button" />
	</form:form>
	<br>
	<table class="table" style="width:100%;">
		<thead style="background: #d3dce3">
			<tr>
				<th style="text-align: center;">Mã khách hàng</th>
				<th style="text-align: center;">Tên khách hàng</th>
				<th style="text-align: center;">Email</th>
				<th style="text-align: center;">Số điện thoại</th>
				<th style="text-align: center;">Số CMND</th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;">Hóa đơn</th>

			</tr>
		</thead>
		<tbody style="background: #ccc">
			<c:forEach items="${khachhangs}" var="khachhang">
				<c:url var="deleteUrl" value="/khachhang/delete">
					<c:param name="maKH" value="${khachhang.maKH}" />
				</c:url>
				<c:url var="editUrl" value="/khachhang/showFormForUpdate">
					<c:param name="maKH" value="${khachhang.maKH}" />
				</c:url>
				<c:url var="viewUrl" value="/hoadon/list">
					<c:param name="maKH" value="${khachhang.maKH}" />
				</c:url>
				<tr style="text-align: center;">
					<td><c:out value="${khachhang.maKH}" /></td>
					<td><c:out value="${khachhang.tenKH}" /></td>
					<td><c:out value="${khachhang.email}" /></td>
					<td><c:out value="${khachhang.soDT}" /></td>
					<td><c:out value="${khachhang.soCMND}" /></td>

					<td><a href="${editUrl}"><img src="${editImgUrl}"
							width="25" /> </a></td>

					<td><a href="${viewUrl}"><img src="${viewImgUrl}" /> </a></td>

				</tr>



			</c:forEach>
		</tbody>
	</table>
</body>
</html>