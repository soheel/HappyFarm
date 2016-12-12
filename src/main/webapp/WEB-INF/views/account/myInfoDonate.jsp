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
	<c:choose>
	<c:when test="${empty list}">
	<td colspan='3'>
		 <p align="center"><b><span style="font-size:9pt;"> 기부 내역이 없습니다. </span></b></p>
	</td>
	</c:when>
	<c:otherwise>
	<c:forEach items="${list}" var="memberDto">
		<c:forEach items="${memberDto.purchaseDto}" var="purchaseDto">
		<tr class="warning">
			<td>${purchaseDto.date}</td>
			<td>${(purchaseDto.price*0.05)}</td>
			<c:forEach items="${purchaseDto.purchaseProductDto}" var="purchaseProductDto">
         		<td>${purchaseProductDto.productDto.name}</td> 
			</c:forEach> 
		</tr>
		</c:forEach>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	</tbody>
</table>
<div>
	<ul>
		<li>총 기부금액</li>
		<li class="total-donate">${donationTotalInfo}</li>
	</ul>
</div>