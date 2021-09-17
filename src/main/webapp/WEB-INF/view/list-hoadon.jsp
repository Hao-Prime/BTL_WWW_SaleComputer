<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách hóa đơn</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script src="<c:url value='/resources/jquery/jquery-3.5.0.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/bootstrap.min.js' />"></script>
</head>
<body>

	<div style="margin: 30px">
		<h1>
			Khách hàng:
			<c:out value="${khachhang.tenKH}" />
		</h1>

		<table class="table" style="width: 20%">
			<tr>
				<td>Email:</td>
				<td><c:out value="${khachhang.email}" /></td>
			</tr>

			<tr>
				<td>Số điện thoại:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><c:out value="${khachhang.soDT}" /></td>
			</tr>

			<tr>
				<td>Số CMND:</td>
				<td><c:out value="${khachhang.soCMND}" /></td>
			</tr>
		</table>
	</div>
	<br>


	<c:url var="viewImgUrl" value="/resources/img/eye.png" />
	<div style="margin: 30px">
		<table class="table"
			style="border: 1px solid; width: 100%; text-align: center;">
			<thead style="background: #d3dce3">
				<tr>
					<th style="text-align: center;">Mã hóa đơn</th>
					<th style="text-align: center;">Ngày đặt</th>
					<th style="text-align: center;">Ngày giao</th>
					<th style="text-align: center;">Ngày nhận</th>
					<th style="text-align: center;">Địa chỉ</th>
					<th style="text-align: center;">Ghi chú</th>
					<th style="text-align: center;">Xem chi tiết</th>
				</tr>
			</thead>
			<tbody style="background: #ccc">


				<c:forEach items="${khachhang.hoaDons}" var="hoadon">
					<c:url var="viewUrl" value="/chitiethoadon/list">
						<c:param name="maHD" value="${hoadon.maHD}" />
					</c:url>
					<tr>
						<td><c:out value="${hoadon.maHD}" /></td>
						<td><c:out value="${hoadon.ngayDat}" /></td>
						<td><c:out value="${hoadon.ngayGiao}" /></td>
						<td><c:out value="${hoadon.ngayNhan}" /></td>
						<td><c:out value="${hoadon.diaChi}" /></td>
						<td><c:out value="${hoadon.ghiChu}" /></td>
						<td><a href="${viewUrl}"><img src="${viewImgUrl}" /> </a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>



</body>
</html>