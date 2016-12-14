<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="noo-sidebar col-md-3">
	<div class="noo-sidebar-wrap">
		<c:forEach items="${communityIngList}" var="ing">
			<div class="noo-product-inner">
				<div class="noo-product-thumbnail">
					<a href="<c:url value="/userEtcController/communityDetail?no=${ing.no}"/>">
						<img width="600" height="760" src='<c:url value="/resources/img/"/>product/${ing.profile}' alt="" />
					</a>
				</div>
				<div class="noo-product-title"> 
					<h3><a href="">${ing.name}</a></h3>
					<span class="date"><span class="amount">${ing.registerDate}</span></span>
				</div>		
			</div>
		</c:forEach>
	</div>  
</div>