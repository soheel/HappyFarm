<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>기부</h2>
<table class="table">
	<thead>
		<tr>
			<th>기부날짜</th>
			<th>기부금액</th>
			<th>상품명</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${donationInfo}" var="donate">
		<tr class="warning">
			<td>${donate.date}</td>
			<td>${donate.price}</td>
			<td></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div>
	<ul>
		<li>총 기부금액</li>
		<li class="total-donate">${donationTotalInfo}</li>
	</ul>
</div>