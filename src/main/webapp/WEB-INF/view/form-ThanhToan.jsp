<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="btl.salecomputers.entity.ChiTietHoaDon"%>
<%@page import="java.util.List"%>
<%@page import="btl.salecomputers.entity.HoaDon"%>
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
<meta charset="UTF-8">
<title>Lap Hoa Don</title>
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











	</div>




	<div style="width: 80%; margin-left: 100px;">
		<div style="float: left; width: 40%;">



			<h3>Thông tin khách hàng</h3>
			<div style="margin: 10px">
				<form:form modelAttribute="hoadon" method="POST" action="${saveUrl}">
					<form:hidden path="maHD" />
					<table class="table" style="width: 100%">
						<tr>
							<td><form:label path="khachHang.tenKH">Tên khách hàng: </form:label></td>
							<td><c:out value="${hoadon.khachHang.tenKH}"></c:out></td>

						</tr>
						<tr>
							<td><form:label path="khachHang.soDT">Số điện thoại: </form:label></td>
							<td><c:out value="${hoadon.khachHang.soDT}"></c:out></td>
						</tr>
						<tr>
							<td><form:label path="diaChi">Địa chỉ: </form:label></td>
							<td><c:out value="${hoadon.diaChi}"></c:out></td>
						</tr>
						<tr>
							<td><form:label path="diaChi">Ngày đặt: </form:label></td>
							<td>
								<%
									LocalDate dateDat = LocalDate.now();
								DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
								String text = dateDat.format(formatters);
								out.print(text);
								%>
							</td>
						</tr>
						<tr>
							<td><form:label path="diaChi">Ngày giao: </form:label></td>
							<td>
								<%
									LocalDate dateGiao = LocalDate.now().plusDays(7);

								String text1 = dateGiao.format(formatters);
								out.print(text1);
								%>
							</td>
						</tr>
						<tr>
							<td><form:label path="diaChi">Ngày nhận: </form:label></td>
							<td>
								<%
									out.print(text1);
								%>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<div style="float: left; width: 60%;">
			<h3>Thông tin hóa đơn</h3>
			<div style="margin: 10px">
				<c:url var="saveHoaDon" value="/giohang/saveHoaDon" />
				<form:form modelAttribute="hoadon" method="POST">
					<form:hidden path="maHD" />
					<table class="table" style="text-align: center; width: 100%;">
						<tr style="height: 10%; width: 100%;">
							<th style="text-align: center;">STT</th>
							<th style="text-align: center;">Sản Phẩm</th>
							<th style="text-align: center;">Số Lượng</th>
							<th style="text-align: center;">Đơn Giá</th>
							<th style="text-align: center;">Thành Tiền</th>
						</tr>
						<%
							int i = 1, j = 0;
						double thanhtien = 0, tamtinh = 0;
						%>
						<c:forEach items="${hoadon.chiTietHoaDons}" var="cthd">
							<tr>
								<td>
									<%
										out.print(i);
									i++;
									%>
								</td>
								<td><c:out value="${cthd.mayTinh.tenMT}"></c:out></td>
								<td><c:out value="${cthd.soLuong}"></c:out></td>
								<td id="gia"><c:out value="${cthd.mayTinh.gia}" />00đ</td>
								<td id="tt">
									<%
										HoaDon hd = (HoaDon) request.getAttribute("hoadon");
									List<ChiTietHoaDon> cthds = hd.getChiTietHoaDons();
									ChiTietHoaDon chiTietHoaDon = cthds.get(j);
									j++;
									thanhtien = chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMayTinh().getGia();
									out.print(thanhtien);
									tamtinh += thanhtien;
									%>00đ
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3"></td>
							<td><b>Tổng tiền:</b></td>
							<td>
								<%
									out.print(tamtinh);
								%>00đ
							</td>
						</tr>
						<tr>
							<td colspan="3"></td>
							<td><b>Phí vận chuyển:</b></td>
							<td>50.000đ</td>
						</tr>
						<tr>
							<td colspan="3"></td>
							<td><b>Tổng thanh toán:</b></td>
							<td>
								<%
									tamtinh += 50;
								out.print(tamtinh);
								%>00đ
							</td>
						</tr>
						<tr>
							<td colspan="4"></td>

							<td><div>
									<c:url var="save" value="/giohang/saveHoaDon">
										<c:param name="maHD" value="${hoadon.maHD}" />
									</c:url>

									<a href="${save}"><input type="button" value="Xác nhận"
										style="border: 1px solid black; background-color: #FF4500; border-radius: 3px; float: right; height: 35px; width: 100%"></a>
								</div></td>
						</tr>
					</table>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>