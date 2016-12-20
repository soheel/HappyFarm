<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

		<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Shop</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">HappyFarm</a>/<span>Shop</span>
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
								<!-- <div class="product-style-control pull-right">
									<span class="noo-list"><a href="shop-list.html"><i class="fa fa-th-list"></i></a></span>
									<span class="noo-grid active"><i class="fa fa-th-large"></i></span>
								</div> -->
							</div>
							
							
							
							<!-- 여기부터 농산물 리스트 불러오는 곳 -->
							<div class="products row product-grid">
							<c:set var="i" value="0" />
							<c:set var="j" value="3" />
								<table id="item_list">
							  		<c:forEach items="${list }" var="list">
							    		<c:if test="${i%j == 0 }">
							    			<tr>
							    		</c:if>
							       		<td>
							       			<!--  상품 하나하나 -->
											<div class="masonry-item noo-product-column col-md-12 product">
												<div class="noo-product-inner">
													<div class="noo-product-thumbnail">
														<a href='<c:url value="/userProductController/showProductDetail?productNo=${list.no}"/>'>
															<!-- 농산물 이미지 -->
															<img width="600" height="760" src='<c:url value = '/resources/img/product/'/>${list.profile}' alt="" />
														</a>
														<div class="noo-rating"> <!-- 평점 -->
															<div class="star-rating">
																<span style="width:${list.eval * 20}%"></span> <!-- width 값을 주면 별이 그려짐 -->
															</div>
														</div>
													</div>
													<div class="noo-product-title">
														<!-- 농산물 이름 --> 
														<input id = "product_no" type = "hidden" value = "${list.no}">
														<h3><a href="<c:url value="/shop/detail"/>">${list.name}</a></h3>
														<!-- 농산물 가격 -->
														<span class="price"><span class="amount"><fmt:formatNumber value = '${list.price}' pattern = '#,###'/></span> 원</span>
														<div class="noo-product-action">
															<div class="noo-action">
																<!-- 장바구니에 담기 버튼 -->
																<div class="noo-action" id="addToCartDirect">
																	<input type = "button" value="Add to cart" class="single_add_to_cart_button button">
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
							       		</td>
							    		<c:if test="${i%j == j-1 }">
							    			</tr>
							    		</c:if>
							    		<c:set var="i" value="${i+1 }" />
								  		</c:forEach>
								</table>
							</div>
							<!-- 여기까지 농산물 리스트 불러오는 곳 --> 
							
							<div class="pagination list-center">
								<span class="page-numbers current">1</span>
								<a class="page-numbers" href="#">2</a>
								<a class="page-numbers" href="#">3</a>
								<a class="next page-numbers" href="#"><i class="fa fa-long-arrow-right"></i></a>
							</div>
						</div>
						
						
						<%-- <div class="masonry-item noo-product-column col-md-4 col-sm-6 product">
										<div class="noo-product-inner">
											<div class="noo-product-thumbnail">
												<a href='<c:url value="/userProductController/showProductDetail?productNo=${list.no}"/>'>
													<!-- 농산물 이미지 -->
													<img width="600" height="760" src='<c:url value = '/resources/img/product/'/>${list.profile}' alt="" />
												</a>
												<div class="noo-rating"> <!-- 평점 -->
													<div class="star-rating">
														<span style="width:${list.eval * 20}%"></span> <!-- width 값을 주면 별이 그려짐 -->
													</div>
												</div>
											</div>
											<div class="noo-product-title">
												<!-- 농산물 이름 --> 
												<input id = "product_no" type = "hidden" value = "${list.no}">
												<h3><a href="<c:url value="/shop/detail"/>">${list.name}</a></h3>
												<!-- 농산물 가격 -->
												<span class="price"><span class="amount"><fmt:formatNumber value = '${list.price}' pattern = '#,###'/></span> 원</span>
												<div class="noo-product-action">
													<div class="noo-action">
														<!-- 장바구니에 담기 버튼 -->
														<div class="noo-action" id="addToCartDirect">
															<input type = "button" value="Add to cart" class="single_add_to_cart_button button">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div> --%>