<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Info Page</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Info</span>
					</div>
				</div>
			</div>
	</section>
	<div class="main">
				<div class="pt-15 pb-11">
					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div class="noo-product-grid-wrap commerce product-style">
									<div class="noo-sh-title">
										<h2>Our new Info</h2>
										<p>Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt eronec dictum non nulla.</p>
									</div>
									
									<div class="noo-product-grid products row product-grid noo-grid-4">
									
									<c:forEach items="${infoList}" var="info">
										<!-- 글 하나하나 -->
										<div class="fruit organic-fruits masonry-item col-md-4 col-sm-6">
											<div class="noo-product-inner">
												<div class="noo-product-thumbnail">
													<a href="<c:url value="/userEtcController/infoDetail"/>?no=${info.no}">
														<img width="600" height="760" src='<c:url value="/resources/img/info/"/>${info.profile}' alt="" />
													</a>
												</div>
												<div class="noo-product-title noo-info-title"> 
													<h3><a href="<c:url value="/userEtcController/infoDetail"/>?no=${info.no}">${info.name}</a></h3>
												</div>
											</div>
										</div>
										<!-- 글 하나하나 -->
									</c:forEach>
									
									</div>
									
								</div>
							</div>
						</div>
					</div>
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