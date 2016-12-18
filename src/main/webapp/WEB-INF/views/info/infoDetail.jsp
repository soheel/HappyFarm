<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<section class="noo-page-heading eff heading-2">
		<div class="container">
			<div class="noo-heading-content">
				<h1 class="page-title eff">Info Detail Page</h1>
				<div class="noo-page-breadcrumb eff">
					<a href="./" class="home">Organici</a>/<span>InfoDetail</span>
				</div>
			</div>
		</div>
	</section>

	<div class="main">
		<div class="commerce single-product noo-shop-main">
			<div class="container">
				<div class="row">
					<div class="noo-main col-md-9">
						<div class="summary entry-summary">
						<h1 class="product_title entry-title">${info.name}</h1>
							<div class="images">
								<div class="product-simple-image">
									<img style = "width : 800px; height : 600px;"
									src="<c:url value="/resources/img/info/"/>${info.desc}"
									alt="" />
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	<div class="noo-product-grid-wrap commerce product-style">  
									<div class="noo-sh-title">  
									<h2>연관된 상품 </h2>  
								</div>  
								<div class="noo-product-grid products row product-grid noo-grid-4">  
									<c:forEach items="${relatedProduct}" var="product">  
									<div class="fruit organic-fruits masonry-item col-md-4 col-sm-6">  
											<div class="noo-product-inner">  
										  
											<div class="noo-product-thumbnail">  
													<a href="<c:url value="/userProductController/showProductDetail?no=${product.no}"/>">  
													<img width="600" height="760" src='<c:url value="/resources/img/community/"/>${product.profile}' alt="" />  
													</a>  
												</div>  
											<div class="noo-product-title">   
												<h3><a href="<c:url value="/userEtcController/communityDetail?no=${past.no}"/>">${product.name}</a></h3>  
											</div>
												
											</div>											
										</div>
										</c:forEach>
									</div>
								</div>
								
								
	<div class="noo-footer-shop-now">
		<div class="container">
			<div class="col-md-7">
				<h4>- Every day fresh -</h4>
				<h3>organic food</h3>
			</div>
			<img src="<c:url value="/resources/img/footer/"/>organici-love-me.png"
				class="noo-image-footer" alt="" />
		</div>
	</div>