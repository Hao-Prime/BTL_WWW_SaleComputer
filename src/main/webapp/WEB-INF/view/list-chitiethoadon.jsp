<%@page import="java.util.List"%>
<%@page import="btl.salecomputers.entity.ChiTietHoaDon"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="btl.salecomputers.service.HoaDonService"%>
<%@page import="btl.salecomputers.entity.HoaDon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Chi tiết hóa đơn</title>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script src="<c:url value='/resources/jquery/jquery-3.5.0.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/bootstrap.min.js' />"></script>
</head>
<body>
	<h1>
		Mã hóa đơn: <c:out value="${hoadon.maHD}" />
	</h1>
	<div style="margin: 30px">
	<table class="table" style="border: 1px solid; width: 60%; text-align: center">
		<thead style="background: #d3dce3">
			<tr>
				<th style="text-align: center; ">Mã máy tính</th>
				<th style="text-align: center; ">Tên sản phẩm</th>
				<th style="text-align: center; ">Số lượng</th>
				<th style="text-align: center; ">Đơn giá</th>
				<th style="text-align: center; ">Thành tiền</th>
			</tr>
		</thead>
		<tbody style="background: #ccc">
				<%
					int i = 0;
				%>		
				<c:forEach items="${hoadon.chiTietHoaDons}" var="chitiethoadon">
					<tr>
						<td><c:out value="${chitiethoadon.mayTinh.maMT}" /></td>
						<td><c:out value="${chitiethoadon.mayTinh.tenMT}" /></td>
						<td><c:out value="${chitiethoadon.soLuong}" /></td>
						<td><c:out value="${chitiethoadon.mayTinh.gia}" />00đ</td>
						
						
						<td><% 
							
							HoaDon hoaDon = (HoaDon)request.getAttribute("hoadon");
							ChiTietHoaDon ct = hoaDon.getChiTietHoaDons().get(i);
								int sol = ct.getSoLuong();
								double gia = ct.getMayTinh().getGia();
								out.println(sol*gia + "00đ");
							i++;
							
						%></td>
						

					</tr>
				</c:forEach>
			
		</tbody>
	</table>
	</div>
</body>
</html>