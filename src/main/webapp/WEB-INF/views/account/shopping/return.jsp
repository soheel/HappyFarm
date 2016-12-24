<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2 class="order_title">반품/교환 내역</h2>
	<input type="button" value="전체" name="id" class="searchReturnList">
	<input type="button" value="3개월" name="three_month" class="searchReturnList">
	<input type="button" value="6개월" name="six_month" class="searchReturnList">
	<input type="button" value="1년" name="year_month" class="searchReturnList">
<table class="table">
	<thead>
		<tr>
			<th>주문일자</th>
			<th>주문상품정보</th>
			<th>상품금액(수량)</th>
			<th>생산자</th>
			<th>현상황</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${empty list}">
	<td colspan='5'>
		 <p align="center"><b><span style="font-size:9pt;"> 해당 내역이 없습니다.</span></b></p>
	</td>
	</c:when>
	<c:otherwise>
	<c:forEach items="${list}" var="list">
			<c:forEach items="${list.purchaseDto}" var="purchaseDto">
			<tr class="warning">
				<td>  
				<fmt:parseDate value="${purchaseDto.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
				<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
				</td>  

				<c:forEach items="${purchaseDto.purchaseProductDto}" var="purchaseProductDto">
         		<td>${purchaseProductDto.productDto.name}</td>
         		<td>${purchaseProductDto.productDto.price}(${purchaseProductDto.productNum})</td>
         		<td>${purchaseProductDto.productDto.producerDto.name}</td> 
				</c:forEach> 
				<td>${purchaseDto.purchaseStateDto.name}</td>
			</tr>
			</c:forEach>
	</c:forEach>
	</c:otherwise>
	</c:choose>	
	</tbody>
</table>