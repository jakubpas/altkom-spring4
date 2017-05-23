<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/layout/head.jsp"%>

<div class="jumbotron">
	<ul>
		<li>page = ${page}</li>
		<li>orderBy = ${orderBy}</li>
		<li>size = ${param.size}</li>
	</ul>
</div>

<form:form modelAttribute="product">
<form:input path="price"/><P>
<form:input path="name"/><p>
<form:input path="quantity"/><p>
<input type="submit" value = "Save">
</form:form>

<%@ include file="/WEB-INF/pages/layout/footer.jsp"%>

