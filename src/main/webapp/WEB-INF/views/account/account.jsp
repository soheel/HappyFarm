<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2>나의 마일리지</h2>
<table class="table">
	<tr>
	 <th>현재 나의 마일리지</th>
	 
	 <td>${mileage}</td>
	 
	</tr>

</table>
<hr>
<h2>진행중인주문</h2>
<table class="table">
	<thead>
		<tr>
			<th>주문일자</th>
			<th>주문상품정보</th>
			<th>상품금액(수량)</th>
			<th>생산자</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${empty list}">
	<td colspan='4'>
		 <p align="center"><b><span style="font-size:9pt;">현재 진행중인 상품 구매 목록이 없습니다.</span></b></p>
	</td>
	</c:when>
	<c:otherwise>
	<c:forEach items="${list}" var="dto">
		<tr class="warning">
			<td>${dto.purchaseDto.date}</td>
         	<td>${dto.purchaseDto.purchaseProductDto.productDto.name}</td>
         	<td>${dto.purchaseDto.purchaseProductDto.productDto.price}(${dto.purchaseDto.purchaseProductDto.productNum})</td>
         	<td>${dto.purchaseDto.purchaseProductDto.productDto.producerDto.name}</td>
		</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>	
	</tbody>
</table>