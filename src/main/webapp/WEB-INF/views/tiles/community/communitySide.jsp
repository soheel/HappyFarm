<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="noo-sidebar col-md-3">
	<div class="noo-sidebar-wrap">
	
	<h3>진행중인 행사</h3>
		<c:forEach items="${communityIngList}" var="ing">
			<div class="noo-product-inner">
				<div class="noo-product-thumbnail">
					<a href="<c:url value="/userEtcController/communityDetail?no=${ing.no}"/>">
						<img style = "border-radius : 26px; width : 250px; height : 200px;" src='<c:url value="/resources/img/community/"/>${ing.profile}' alt="" />
					</a>
				</div>
				<div class="noo-product-title"> 
					<h5><a href="">${ing.name}</a></h5>
					<fmt:parseDate value='${ing.registerDate}' var = 'date' pattern="yyyy-mm-dd"/>
					<span class="date"><span class="amount"><fmt:formatDate value="${date}" pattern="등록일 : yyyy-mm-dd"/></span></span>
				</div>		
			</div>
		</c:forEach>
	</div>  
</div>