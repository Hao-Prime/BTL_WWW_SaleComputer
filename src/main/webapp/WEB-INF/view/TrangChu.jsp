<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Trang chủ</title>

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
				<td><form:form action="search" method="GET">
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
					<c:url var="sortThuongHieu" value="/">
						
						<c:param name="sort" value="${thuonghieu.maTH}"></c:param>
					</c:url>
					<a href="${sortThuongHieu}">${thuonghieu.tenTH}</a>
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

	<div id="container">
		<div id="content">


			<div class="grid-container">
				<c:forEach var="maytinh" items="${maytinhs}">
					<c:url var="viewUrl" value="/maytinh/showChiTietMayTinh">
						<c:param name="maMT" value="${maytinh.maMT}" />
					</c:url>
					<c:url var="updateLink" value="/maytinh/showFormForUpdate">
						<c:param name="maMT" value="${maytinh.maMT}" />
					</c:url>
					<c:url var="deleteLink" value="/maytinh/delete">
						<c:param name="maMT" value="${maytinh.maMT}" />
					</c:url>



					<div class="grid-item">
						<table height="290">
							<tr>
								<td height="10" style="position: absolute; padding-left: 160px;"><security:authorize
										access="hasRole('EMPLOYEE')">
										<a href="${updateLink}"><img src="${editImgUrl}"
											width="25" /></a>
									</security:authorize></td>
							</tr>
							<tr height="150">
								<td class="td1">
									<div class="img">
										<img src="data:image/jpg;base64,${maytinh.hinhAnh}"
											width="170" height="140"></img>
									</div>
								</td>
							</tr>




							<tr>

								<td style="text-align: left;"><b>${maytinh.tenMT}</b></td>

							</tr>

							<tr>

								<td style="text-align: left;"><font size="4" color=red>${maytinh.gia}</font></td>


							</tr>

							<tr>

								<td style="text-align: left;"><font size="3" color=black>RAM:
										${maytinh.ramMT} GB</font></td>

							</tr>
							<tr>

								<td style="text-align: left;"><font size="3" color=black>Màn
										hình: ${maytinh.manHinhMT} inch</font></td>

							</tr>
							<tr>

								<td style="text-align: left;"><font size="3" color=black>Thương
										hiệu: ${maytinh.thuongHieu}</font></td>

							</tr>


						</table>

						<table>
							<tr>
								<td width="30"></td>



								<td width="115"
									style="border: 1px solid black; background-color: #FF4500; border-radius: 3px;"><a
									href="${viewUrl}"><img src="${viewImg1}" width="42" /></a></td>



								<td width="30"><security:authorize
										access="hasRole('EMPLOYEE')">
										<a href="${deleteLink}"
											onclick="if (!(confirm('Bạn có chắc muốn xóa sản phẩm này'))) return false"><img
											src="${deleteImgUrl}" width="25" /></a>
									</security:authorize></td>


							</tr>
						</table>










					</div>
				</c:forEach>
			</div>

		</div>

	</div>


</body>

</html>









