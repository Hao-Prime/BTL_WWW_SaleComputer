<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="btl.salecomputers.util.SortUtils"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ChiTietMayTinh</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/trangchu.css" />
</head>
</head>
<body>
	
	<c:url var="themGH" value="/giohang/showGioHang">
		<c:param name="maMT" value="${maytinh.maMT}" />
	</c:url>
	
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
				<td><form:form action="${pageContext.request.contextPath}/search" method="GET">
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
	
	
	
	
	
	<form:form modelAttribute="maytinh" method="GET" action="${themGH}">
		<form:hidden path="maMT" />
		<%--
           This line is very important. Without this line, we'd actually lose context or we actually lose the id of the
           original customer. So we need to use this line to actually track the customer just so the back end system 
           knows which customer to form the update operation on. 
            --%>
		<div style="margin: 30px">
			<table class="table" style="width: 100%; text-align: center;">
				<tr>
					<td rowspan="4"
						style="width: 50%; text-align: center; border: 3px double;"><img
						src="data:image/jpg;base64,${maytinh.hinhAnh}" width=400
						height=400 /></td>
					<td><b>Tên:</b></td>
					<td><c:out value="${maytinh.tenMT}" /></td>
				</tr>

				<tr>
					<td><b>RAM: </b></td>
					<td><c:out value="${maytinh.ramMT}" /> GB</td>
				</tr>

				<tr>
					<td><b>Màn Hình: </b></td>
					<td><c:out value="${maytinh.manHinhMT}" /> Inch</td>
				</tr>
				<tr>
					<td><b>Giá: </b></td>
					<td><c:out value="${maytinh.gia}" />00đ</td>
				</tr>

				<tr>
					<td><b>Mô tả:</b> <c:out value="${maytinh.moTa}" /></td>
					<td colspan="2" style="height: 100px;"><input type="submit"
						value="Thêm vào giỏ hàng" style="height: 50px; width: 50%;" /></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>