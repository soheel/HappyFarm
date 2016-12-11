<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Donate Page</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Donate</span>
					</div>
				</div>
			</div>
	</section>
	
	<div class="container">
		<div class="table-responsive donate_table"> 
			<h3>기부 현황</h3>        
	  		<table class="table">
	  			<tr>
	  				<th>기부금액</th>
	  				<th>기부날짜</th>
	  			</tr>
	  			
	  			<c:forEach items="${requestScope.donationlist }" var="list">
	  				<tr>
	  					<td><fmt:formatNumber value="${list.price }"/></td>
	  					<td>${list.date }</td>
	  				</tr>
	  			</c:forEach>
	  			
	  		</table>
	  		<input type="button" class="btn btn-success" value="나의 기부 현황"/>
	  	</div>
	  	
	  	<h3>기부 업체</h3>
	  	<div class="related products qna_board">
			<img alt="" src="<c:url value='/resources/img/donation_org/'/>${donationOrg.profile}">
			<p>${donationOrg.desc }</p>
		</div>
  	</div>
	
	
	
	<div class="noo-footer-shop-now">
		<div class="container">
			<div class="col-md-7">
				<h4>- Every day fresh -</h4>
				<h3>organic food</h3>
			</div>
			<img src="<c:url value="/resources/images/"/>organici-love-me.png" class="noo-image-footer" alt="" />
		</div>
	</div>
</body>
</html>