<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<title>Form Add Khach Hang</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script src="<c:url value='/resources/jquery/jquery-3.5.0.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/bootstrap.min.js' />"></script>
</head>
<body style="margin-top: 50px;margin-left: 450px;">
	<h1>Thêm khách hàng</h1>
	<c:url var="saveUrl" value="/khachhang/saveKhachHang" />

	<form:form modelAttribute="khachhang" method="POST" action="${saveUrl}">
		<form:hidden path="maKH" />
		<%--
           This line is very important. Without this line, we'd actually lose context or we actually lose the id of the
           original customer. So we need to use this line to actually track the customer just so the back end system 
           knows which customer to form the update operation on. 
            --%>
		<div style="width: 40%;">
			<table class="table">
				<tr>
					<td><form:label path="tenKH">Tên khách hàng: </form:label></td>
					<td style="text-align: center; width: 50%"><form:input
							path="tenKH" /></td>
				</tr>

				<tr>
					<td><form:label path="email">Email: </form:label></td>
					<td style="text-align: center; width: 50%"><form:input
							path="email" readonly="true" /></td>
				</tr>

				<tr>
					<td><form:label path="soDT">Số điện thoại: </form:label></td>
					<td style="text-align: center; width: 50%"><form:input
							path="soDT" /></td>
				</tr>
				<tr>
					<td><form:label path="soCMND">Số CMND: </form:label></td>
					<td style="text-align: center; width: 50%"><form:input
							path="soCMND" /></td>
				</tr>
			</table>


			<input type="submit" value="Save" style="width: 20%;" />
		</div>
	</form:form>


</body>
</html>