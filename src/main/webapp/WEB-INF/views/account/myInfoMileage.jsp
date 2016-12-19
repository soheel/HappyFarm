<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="row">
	<h2>추천인</h2>
	<table class="table">
		<c:choose>
			<c:when test="${empty recommand}">
				<tr>
					<td>현재 추천인이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${recommand}" var="recommand" varStatus="state">
					<c:if test="${state.index lt 5}">
					<tr>
						<td>${recommand}</td>
					</tr>
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>
				<c:if test="${fn:length(recommand)>5}">
					<tr>
						<td>외 ${extra}</td>
					</tr>
				</c:if>
	</table>
</div>
<h2>point 사용 이력</h2>
<table class="table">
	<thead>
		<tr>
			<th>사용 날짜</th>
			<th>구매번호</th>
			<th>사용량</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty usedMileage}">
				<tr>
					<td>현재 사용내역이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${usedMileage}" var="memberDto">
					<c:forEach items="${memberDto.purchaseDto}" var="purchaseDto">
						<c:forEach items="${purchaseDto.purchaseProductDto}"
							var="purchaseProductDto">
							<tr>
								<td>  
								<fmt:parseDate value="${purchaseDto.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
								<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
								</td>  
								<td>${purchaseDto.no}</td>
								<td>${purchaseDto.discount}</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
