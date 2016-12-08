<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Shop Grid</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Shop Grid</span>
					</div>
				</div>
			</div>
		</section>
		<div class="main">
			<div class="commerce noo-shop-main">
				<div class="container">
					<div class="row">
						<div class="noo-main col-md-9">
							<div class="noo-catalog">
								<p class="commerce-result-count">Showing 1&ndash;9 of 18 results</p>
								<div class="product-style-control pull-right">
									<span class="noo-list"><a href="shop-list.html"><i class="fa fa-th-list"></i></a></span>
									<span class="noo-grid active"><i class="fa fa-th-large"></i></span>
								</div>
								<form class="commerce-ordering">
									<select name="orderby" class="orderby">
										<option value="" selected='selected'>Default sorting</option>
										<option value="">Sort by popularity</option>
										<option value="">Sort by average rating</option>
										<option value="">Sort by newness</option>
										<option value="">Sort by price: low to high</option>
									</select>
								</form>
							</div>
							
							
							<!-- 여기부터 농산묻 리스트 불러오는 곳 -->
							<div class="products row product-grid">
								<div class="masonry-item noo-product-column col-md-4 col-sm-6 product"> <!-- 한 상품의 div -->
									<div class="noo-product-inner">
										<div class="noo-product-thumbnail">
											<a href='<c:url value="/userProductController/showProductDetail?productNo=1"/>'>
												<!-- 농산물 이미지 -->
												<img width="600" height="760" src="<c:url value="/resources/images/"/>product/product_260x330.jpg" alt="" />
											</a>
											<div class="noo-rating"> <!-- 평점 -->
												<div class="star-rating">
													<span style="width:0%"></span> <!-- width 값을 주면 별이 그려짐 -->
												</div>
											</div>
										</div>
										<div class="noo-product-title">
											<!-- 농산물 이름 --> 
											<h3><a href="<c:url value="/shop/detail"/>">Apples</a></h3>
											<!-- 농산물 가격 -->
											<span class="price"><span class="amount">&#36;3.95</span></span>
											<div class="noo-product-action">
												<div class="noo-action">
													<!-- 장바구니에 담기 버튼 -->
													<a href="#" class="button product_type_simple add_to_cart_button">
														<span>Add to cart</span>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 여기까지 농산묻 리스트 불러오는 곳 -->

							</div>
							<div class="pagination list-center">
								<span class="page-numbers current">1</span>
								<a class="page-numbers" href="#">2</a>
								<a class="page-numbers" href="#">3</a>
								<a class="next page-numbers" href="#"><i class="fa fa-long-arrow-right"></i></a>
							</div>
						</div>
	</body>
</html>