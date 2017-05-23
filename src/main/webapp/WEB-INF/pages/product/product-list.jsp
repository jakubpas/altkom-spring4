<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>

<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.quantity}</td>
					<td>${p.price}</td>
					<td><a href="${contextPath}/product/${p.id}/delete">x</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

