<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

		<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Package Grid</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Package</span>
					</div>
				</div>
			</div>
		</section>
		<div class="main">
			<div class="commerce noo-shop-main">
				<div class="container">
					<div class="row">
						<div class="noo-main col-md-9">
							<!-- 여기부터 농산묻 리스트 불러오는 곳 -->
							<div class="products row product-grid">
							
							<!-- 상품 하나하나 -->
							<c:forEach items="${list }" var="list">
							<div class="masonry-item noo-product-column col-md-4 col-sm-6 product">
									<div class="noo-product-inner">
										<div class="noo-product-thumbnail">
											<a href='<c:url value="/userProductController/showPackageDetail?productNo="/>${list.no}'>
												<img width="600" height="760" src="<c:url value="/resources/img/product/"/>${list.profile}" alt="" />
											</a>
											<div class="noo-rating">
												<div class="star-rating">
													<span style="width:${list.eval * 20}%"></span>
												</div>
											</div>
										</div>
										<div class="noo-product-title">
											<input id = "product_no" type = "hidden" value = "${list.no }">
											<h3><a href="<c:url value="/userProductController/showPackageDetail?productNo="/>${list.no}">${list.name }</a></h3>
											<span class="price"><span class="amount"><fmt:formatNumber value = '${list.price }' pattern = '#,###'/> 원</span></span>
											<div class="noo-product-action">
												<div class="noo-action">
													<div class="noo-action" id="addToCartDirect">
														<input type = "button" value="Add to cart" class="single_add_to_cart_button button">
													</div>
													<input type="hidden" value="${list.no }">
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
							<!-- 여기까지 농산묻 리스트 불러오는 곳 -->
								
							</div>
							<div class="pagination list-center">
								<span class="page-numbers current">1</span>
								<a class="page-numbers" href="#">2</a>
								<a class="page-numbers" href="#">3</a>
								<a class="next page-numbers" href="#"><i class="fa fa-long-arrow-right"></i></a>
							</div>
						</div>