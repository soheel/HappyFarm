<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>주문/배송 조회</h2>




<input type="button" value="전체" name="id" class="searchOrderList">
<input type="button" value="3개월" name="three_month" class="searchOrderList">
<input type="button" value="6개월" name="six_month" class="searchOrderList">
<input type="button" value="1년" name="year_month" class="searchOrderList">

<form id="deleteOrderList" method="post">
<table class="table">
	<thead>
		<tr>
			<th>주문일자</th>
			<th>주문상품정보</th>
			<th>상품금액(수량)</th>
			<th>생산자</th>
			<th>현상태</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${empty list}">
	<td colspan='6'>
		 <p align="center"><b><span style="font-size:9pt;">구매 내역이 없습니다.</span></b></p>
	</td>
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="memberDto">
		<c:forEach items="${memberDto.purchaseDto}" var="purchaseDto" varStatus="state">
		<tr class="warning">

		<td>
         <fmt:parseDate value="${purchaseDto.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>
         <fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>         
         </td>
		<input type ="text" value ="${purchaseDto.no}" name ="purchaseList[${state.index}].no" id="purchaseNo" hidden >

		<c:forEach items="${purchaseDto.purchaseProductDto}" var="purchaseProductDto">
         	<td>${purchaseProductDto.productDto.name}</td>
         	<td>${purchaseProductDto.productDto.price}(${purchaseProductDto.productNum})</td>
         	<td>${purchaseProductDto.productDto.producerDto.name}</td> 
		</c:forEach>
			<td>${purchaseDto.purchaseStateDto.name}</td>
			<input type ="text" value ="${purchaseDto.purchaseStateDto.name}" name ="purchaseList[${state.index}].purchaseStateDto.name" hidden >
			<c:choose>
			
			<c:when test="${purchaseDto.purchaseStateDto.name eq '주문완료'}">
			<td><span id="searchOrderListCancer" value="${purchaseDto.no}">취소</span></td>
			</c:when>
			<c:when test="${purchaseDto.purchaseStateDto.name eq '취소'}">
			<td>&nbsp;</td>
			</c:when>
			<c:otherwise>
				<td><span id="refundCheckBtn" value="${purchaseDto.no}">환불/반품/교환</span></td>
			</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
		</c:forEach>
		</c:otherwise>
		</c:choose>
	</tbody>
</table>


</form>