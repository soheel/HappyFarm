<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<section class="noo-page-heading eff heading-2">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Community Page</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Community</span>
					</div>
				</div>
			</div>
	</section>
	<div class="main">
			<div class="pt-15 pb-11">
				<div class="container">
					<div class="row">
						<div class="col-sm-12 col-xs-12">
							<div class="noo-product-grid-wrap commerce product-style">
								<div class="noo-sh-title">
									<h2>진행중인 행사들</h2>
									<p>각 생산자들이 주최하고있는 모임에 참여하세요!</p>
								</div>
								<div class="noo-product-grid products row product-grid noo-grid-4 tc">
									<c:forEach items="${communityIngList}" var="ing">
										<div class="fruit organic-fruits masonry-item col-xs-4 clear inline-block">
											<div class="noo-product-inner">
												<div class="noo-product-thumbnail">
													<a href="<c:url value="/userEtcController/communityDetail?no=${ing.no}"/>">
														<img width="600" height="760" src='<c:url value="/resources/img/community/"/>${ing.profile}' alt="" />
													</a>
												</div>
												<div class="noo-product-title"> 
													<h3><a href="<c:url value="/userEtcController/communityDetail?no=${ing.no}"/>">${ing.name}</a></h3>
													<span class="date">
														<span class="amount"><fmt:parseDate value="${ing.registerDate}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
															<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
														</span>
													</span> 
												</div>  	  
											</div>											  
										</div>
									</c:forEach> 
								</div>  
							</div>  
								  
								<div class="noo-product-grid-wrap commerce product-style mt50 mb20">  
									<div class="noo-sh-title">  
									<h2>진행완료된 행사들</h2>  
								</div>  
								<div class="noo-product-grid products row product-grid noo-grid-4">  
									<c:forEach items="${communityPastList}" var="past">  
									<div class="fruit organic-fruits masonry-item col-md-4 col-sm-6">  
											<div class="noo-product-inner">  
										  
											<div class="noo-product-thumbnail">  
													<a href="<c:url value="/userEtcController/communityDetail?no=${past.no}"/>">  
													<img width="600" height="760" src='<c:url value="/resources/img/community/"/>${past.profile}' alt="" />  
													</a>  
												</div>  
											<div class="noo-product-title">   
												<h3><a href="<c:url value="/userEtcController/communityDetail?no=${past.no}"/>">${past.name}</a></h3>  
												<span class="date"><span class="amount"><fmt:parseDate value="${past.registerDate}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
													<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
											</span></span>  

												</div>
												
											</div>											
										</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>