<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.List"%>
<%@page import="btl.salecomputers.entity.MayTinh"%>
<%@page import="btl.salecomputers.entity.HoaDon"%>
<%@page import="btl.salecomputers.entity.ChiTietHoaDon"%>
<%@page import="java.util.function.Function"%>
<%@page import="javax.swing.event.DocumentEvent"%>
<%@page import="javax.swing.text.Document"%>
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
<title>GioHang</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/trangchu.css" />

</head>
<body>
	<c:url var="deleteImgUrl" value="/resources/img/delete.png" />

	
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











	</div>












	<div style="width: 80%;padding-left:100px;padding-top:30px;">

		
			<div
				style="float: left; width: 60%;">
				<table class="table" style="height: 100%; width: 100%;">
					<tr style="height: 10%; width: 100%;">
						<th>STT</th>
						<th>Sản Phẩm</th>
						<th>Số Lượng</th>
						<th>Đơn Giá</th>
						<th>Thành Tiền</th>
						<th></th>
					</tr>
					<%
					int i = 1, j = 0;
					double thanhtien = 0, tamtinh = 0;
					%>
					<c:forEach items="${hoaDon.chiTietHoaDons}" var="cthd">
						<c:url var="congSL" value="/giohang/cong">
							<c:param name="maCTHD" value="${cthd.maCTHD}" />
						</c:url>
						<c:url var="truSL" value="/giohang/tru">
							<c:param name="maCTHD" value="${cthd.maCTHD}" />
						</c:url>
						<c:url var="delete" value="/giohang/delete">
							<c:param name="maCTHD" value="${cthd.maCTHD}" />
						</c:url>
						<tr>

							<td>
								<%
								out.print(i);
								i++;
								%>
							</td>
							<td><c:out value="${cthd.mayTinh.tenMT}"></c:out></td>
							<td><a href="${truSL}"><input type="button" value="-"
									style="height: auto; width: 30px; text-align: center;"></a>

								<input type="text" id="sl"
								value="<c:out value="${cthd.soLuong}"></c:out>" name="sl"
								style="height: auto; width: 30px; text-align: center;"
								readonly="readonly" /> <a href="${congSL}"><input
									type="button" value="+"
									style="height: auto; width: 30px; text-align: center;"></a>
							</td>
							<td id="gia"><c:out value="${cthd.mayTinh.gia}" />00đ</td>
							<td id="tt">
								<%
								HoaDon hd = (HoaDon) request.getAttribute("hoaDon");
								List<ChiTietHoaDon> cthds = hd.getChiTietHoaDons();
								ChiTietHoaDon chiTietHoaDon = cthds.get(j);
								j++;
								thanhtien = chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMayTinh().getGia();
								out.print(thanhtien);
								tamtinh += thanhtien;
								%>00đ
							</td>
							<td><a href="${delete}"><img src="${deleteImgUrl}" width="25" /> </a></td>
						</tr>

					</c:forEach>
				</table>
			</div>
			<div style="float: left; width: 30%; padding-left:4%;">
				<c:url var="saveUrl" value="/giohang/saveDiaChi" />
				<form:form modelAttribute="hoaDon" method="POST" action="${saveUrl}">
					<form:hidden path="maHD" />
					<table class="table" style="height: 50%; width: 100%">
						<tr>
							<th colspan="2"><h3>Thông tin giao hàng</h3></th>
						</tr>
						<tr>
							<td>Tên khách hàng:</td>
							<td style="width: 70%; text-align: center;"><c:out
									value="${hoaDon.khachHang.tenKH }"></c:out></td>
						</tr>
						<tr>
							<td>Số điện thoại:</td>
							<td style="width: 70%; text-align: center;"><c:out
									value="${hoaDon.khachHang.soDT }"></c:out></td>
						</tr>

						<tr>
							<td>Địa chỉ giao hàng:</td>
							<td style="width: 70%; text-align: center;"><form:input
									path="diaChi" /></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="Cập nhật"
								style="height: 100%; width: 100%" /></td>

						</tr>
					</table>

				</form:form>



				<table class="table" style="height: 50%; width: 100%">
					<tr>
						<th colspan="2"><h3>Thanh Toán</h3></th>
					</tr>
					<tr>
						<td>Tạm tính:</td>
						<td style="width: 70%; text-align: center;">
							<%
							out.print(tamtinh + "00đ");
							%>
						</td>
					</tr>
					<tr>
						<td>Phí vận chuyển:</td>
						<td style="width: 70%; text-align: center;">50.000đ</td>
					</tr>

					<tr>
						<td>Thành tiền:</td>
						<td style="width: 70%; text-align: center;">
							<%
							tamtinh += 50;
							out.print(tamtinh + "00đ");
							%>
						</td>
					</tr>

					<c:url var="thanhToan" value="/hoadon/showFormThanhToan">
						<c:param name="maHD" value="${hoaDon.maHD}" />
					</c:url>

					<tr>
						<td><a href="${pageContext.request.contextPath}/"> <input
								type="button" value="Sản phẩm"
								style="height: 100%; width: 100%;"></a></td>
						<td>
							<%-- <%
							Boolean kq = true;
							HoaDon hd = (HoaDon) request.getAttribute("hoaDon");
							if (hd.getDiaChi().equals("") || hd.getDiaChi() == null) {
								kq = false;
							}
							JOptionPane.showMessageDialog(null, "Nhập địa chỉ");
							%>  --%> <a href="${thanhToan}"><input type="button"
								value="Thanh toán"
								style="float: right; height: 100%; width: 100%"></a>
						</td>
					</tr>
				</table>
			</div>
		
	</div>
</body>
</html>