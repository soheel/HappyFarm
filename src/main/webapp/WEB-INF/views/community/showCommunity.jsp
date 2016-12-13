<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
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
							<div class="col-sm-12">
								<div class="noo-product-grid-wrap commerce product-style">
									<div class="noo-sh-title">
										<h2>Our new products</h2>
										<p>Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt eronec dictum non nulla.</p>
									</div>
									<div class="noo-product-grid products row product-grid noo-grid-4">
										<div class="fruit organic-fruits masonry-item col-md-4 col-sm-6">
										<c:forEach items="${communityIngList}" var="ing">
											<div class="noo-product-inner">
											
												<div class="noo-product-thumbnail">
													<a href="<c:url value="/userEtcController/communityDetail?no=${ing.no}"/>">
						
														<img width="600" height="760" src='<c:url value="/resources/images/"/>product/${ing.profile}' alt="" />
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
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>