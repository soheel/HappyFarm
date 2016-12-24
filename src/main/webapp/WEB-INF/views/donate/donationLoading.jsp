<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<section class="noo-page-heading eff heading-3">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Donate Page</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Donate</span>
					</div>
				</div>
			</div>
	</section>
	<div class=" commerce">
		<div class="container">
			<div class="first_content">
				<div class="donate_title">
						<span>기부 현황</span>
				</div>
				<div class="table-responsive donate_table">
			  		<table class="table">
			  			<thead>
			  				<tr>
				  				<th>기부금액</th>
				  				<th>기부날짜</th>
			  				</tr>
			  			</thead>
			  			
			  			<c:forEach items="${requestScope.donationlist }" var="list">
			  				<tr>
			  					<td><fmt:formatNumber value="${list.price }"/></td>
			  					<td>  
		  						<fmt:parseDate value="${list.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
								<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
		  						</td>  
		
			  				</tr>
			  			</c:forEach>
			  		</table>
			  		<input type="button" class="button" value="나의 기부 현황" id="GoMyDonation"/>
			  		<a href="<c:url value='/userInfoController/myPageDonation'/>"></a>
			  	</div>
			</div>
			<div class="donate_title">
				<span>기부 업체</span>
			</div>
			<div class="related products donate_board">
				<table>
					<tr>
						<td class="donate_board_img">
							<a href = "http://www.unicef.or.kr/" target="blank">
								<img alt="" src="<c:url value='/resources/img/donation_org/'/>${donationOrg.profile}">
							</a>
						</td>
						
						<td class="donate_board_content">
							${donationOrg.desc }
						</td>
					</tr>
				</table>		
			</div>
	  	</div>
  	</div>
	
	
	
	<div class="noo-footer-shop-now">
		<div class="container">
			<div class="col-md-7">
				<h4>- Every day fresh -</h4>
				<h3>organic food</h3>
			</div>
			<img src="<c:url value="/resources/img/footer/"/>organici-love-me.png" class="noo-image-footer" alt="" />
		</div>
	</div>