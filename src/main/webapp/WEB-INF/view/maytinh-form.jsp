<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html >
<html>
<head>

<title>Máy tính</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/trangchu.css" />

</head>
<body>

	<c:url var="saveUrl"
		value="/maytinh/saveMayTinh?${_csrf.parameterName}=${_csrf.token}" />
	
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











	</div>

	<div style="margin-left: auto; margin-right: auto; width: 40%;background-color:#DCDCDC;padding-left:10%;padding-bottom:5%;padding-top:2%">

		<h1>Thêm Máy Tính Mới</h1>


		<form:form action="${saveUrl}" method="post" modelAttribute="maytinh"
			enctype="multipart/form-data">
			<form:hidden path="maMT" />

			<table>
				<tr>

					<td><form:label path="tenMT">Tên Máy tính:</form:label></td>
					<td><form:input path="tenMT" /></td>
				</tr>

				<tr>
					<td><form:label path="ramMT">Ram:</form:label></td>
					<td><form:input path="ramMT" /></td>

				</tr>
				<tr>
					<td><form:label path="manHinhMT">Màn hình:</form:label></td>
					<td><form:input path="manHinhMT" /> inch</td>
				</tr>
				<tr>
					<td><form:label path="soLuong">Số lượng kho:</form:label></td>
					<td><form:input path="soLuong" /></td>
				</tr>
				<tr>
					<td><form:label path="gia">Giá:</form:label></td>
					<td><form:input path="gia" /> .000đ</td>

				</tr>
				<tr>
					<td><form:label path="moTa">Mô tả:</form:label></td>
					<td><form:input path="moTa" /></td>
				</tr>
				<tr>
					<td><form:label path="thuonghieu.maTH">Thương hiệu:</form:label></td>
					<td><form:select path="thuonghieu.maTH" >
					<form:options width="150" items="${thuonghieus}" itemValue="maTH" itemLabel="tenTH"/>
					</form:select>
					</td>
				</tr>
				

				<tr>
					<td>Hình ảnh :</td>
					<td><input type="file" name="photo" /></td>
				</tr>
			</table>

			<input type="submit" value="Save" />
		</form:form>

		<!--<form action="${saveUrl}" method="post" enctype="multipart/form-data">
        	<input type="file" name="hinhAnh"/>
     		 <input type="submit" value="Save" />
        </form>-->

	</div>

</body>
</html>
