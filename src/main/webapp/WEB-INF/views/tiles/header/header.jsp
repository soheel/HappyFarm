<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>headerPage</title>

</head>
<body>
	<div class="noo-spinner">
			<div class="spinner">
				<div class="cube1"></div>
				<div class="cube2"></div>
			</div>
		</div>
		<div class="site">
			<header class="noo-header header-2">
				<div class="noo-topbar">
					<div class="container">
						<ul>
							<li>
								<span><i class="fa fa-phone"></i></span>
								<a href="#">0123-88-89-0999</a>
							</li>
							<li>
								<span><i class="fa fa-envelope"></i></span>
								<a href="mailto:contact@organici.com">contact@organici.com</a>
							</li>
						</ul>
						<ul>
							<li>
								<span><i class="fa fa-user"></i></span>
								<a href="my-account.html">My Account</a>
							</li>
							<li>
								<a href="<c:url value="/cart"/>">
									<span class="has-cart">
										<i class="fa fa-shopping-cart"></i>
										<em>0</em>
									</span>
								</a>
								&nbsp; &#8209; &nbsp; <span class="amount">&#36;0.00</span>
							</li>
							<li>
								<a href="#" class="fa fa-search noo-search" id="noo-search"></a>
							</li>
							<li class="country">
								<a href="#"><img src='<c:url value="/resources/images/"/>korean.png' alt="korean"/></a>
								<a href="#"><img src='<c:url value="/resources/images/"/>eng.png' alt="eng"/></a>
							</li>
						</ul>
					</div>
				</div>
				<div class="navbar-wrapper">
					<div class="navbar navbar-default">
						<div class="container">
							<div class="menu-position">
								<div class="navbar-header pull-left">
									<h1 class="sr-only">Organici</h1> 
									<div class="noo_menu_canvas">
										<div class="btn-search noo-search topbar-has-search">
											<i class="fa fa-search"></i>
										</div>
										<div data-target=".nav-collapse" class="btn-navbar">
											<span></span>
											<span></span>
											<span></span>
										</div>
									</div>
									<a href="./" class="navbar-brand">
										<img class="noo-logo-img noo-logo-normal" src='<c:url value="/resources/images/"/>logo.png' alt="Organic Store">
									</a>
								</div>
								<nav class="pull-right noo-main-menu">
									<ul class="nav-collapse navbar-nav">
										<li><a href="<c:url value="/"/>">Home</a></li>
										<li class="menu-item-has-children noo_megamenu mega-col-columns-4">
											<a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=20"/>" id="test">Shop</a>
											<ul class="sub-menu">
												<li class="menu-item-has-children">
													<a href="<c:url value="/"/>shop">Shop page</a>
													<ul class="sub-menu">
														<li><a href="shop-list.html">Shop List</a></li>
														<li><a href="<c:url value="/shop/"/>detail">Shop Detail</a></li>
														<li><a href="my-account.html">My Account</a></li>
														<li><a href="cart.html">Cart</a></li>
														<li><a href="cart-empty.html">Empty Cart</a></li>
														<li><a href="wishlist.html">Wishlist</a></li>
													</ul>
												</li>
												<li class="menu-item-has-children">
													<div class="noo_megamenu_widget_area">
														<div class="widget commerce widget_products">
															<h3 class="widget-title">인기상품</h3>
															<ul class="product_list_widget">
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">French Bread</span>
																	</a>
																	<span class="amount">&#36;10.00</span>
																</li>
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">Cookie</span>
																	</a>
																	<span class="amount">&#36;15.00</span>
																</li>
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">Brown Bread</span>
																	</a>
																	<span class="amount">&#36;12.00</span>
																</li>
															</ul>
														</div>
													</div>
												</li>
												<li>
													<div class="noo_megamenu_widget_area">
														<div class="widget commerce widget_products">
															<h3 class="widget-title">계절별 상품</h3>
															<ul class="product_list_widget">
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">French Bread</span>
																	</a>
																	<span class="amount">&#36;10.00</span>
																</li>
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">Cookie</span>
																	</a>
																	<span class="amount">&#36;15.00</span>
																</li>
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">Brown Bread</span>
																	</a>
																	<span class="amount">&#36;12.00</span>
																</li>
															</ul>
														</div>
													</div>
												</li>
												<li>
													<div class="noo_megamenu_widget_area">
														<div class="widget commerce widget_products">
															<h3 class="widget-title">지난 구매 품목</h3>
															<ul class="product_list_widget">
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">French Bread</span>
																	</a>
																	<span class="amount">&#36;10.00</span>
																</li>
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">Cookie</span>
																	</a>
																	<span class="amount">&#36;15.00</span>
																</li>
																<li>
																	<a href="<c:url value="/shop/"/>detail">
																		<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span class="product-title">Brown Bread</span>
																	</a>
																	<span class="amount">&#36;12.00</span>
																</li>
															</ul>
														</div>
													</div>
												</li>
											</ul>
										</li>
										<li><a href="<c:url value="/userProductController/packageMenuListLoading"/>">Package</a></li>
										<li><a href="<c:url value="/userEtcController/communityLoading"/>">Community</a></li>
										<li><a href="<c:url value="/userEtcController/infoLoading"/>">Info</a></li>
										<li><a href="<c:url value="/userEtcController/qnaLoading"/>">Q&A</a></li>
										<li><a href="<c:url value="/userEtcController/donationLoading"/>">Donate</a></li>
										
										<!-- 
										<li class="menu-item-has-children">
											<a href="blog.html">Blog</a>
											<ul class="sub-menu">
												<li class="menu-item-has-children">
													<a href="blog-masonry.html">Blog Masonry</a>
													<ul class="sub-menu">
														<li><a href="blog-masonry-two-columns.html">2 Columns</a></li>
														<li><a href="blog-masonry.html">3 Columns</a></li>
														<li><a href="blog-masonry-four-columns.html">4 Columns</a></li>
													</ul>
												</li>
												<li><a href="blog.html">Blog Listing</a></li>
												<li><a href="blog-detail.html">Blog Single Default</a></li>
												<li><a href="blog-detail-video.html">Blog Single Video</a></li>
												<li><a href="blog-detail-audio.html">Blog Single SoundCloud</a></li>
												<li><a href="blog-detail-slider.html">Blog Single Slider</a></li>
											</ul>
										</li>
										 -->
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
				<div class="search-header5">
					<div class="remove-form"></div>
					<div class="container">
						<form action = "<c:url value = "/userProductController/search"/>" class="form-horizontal">
							<label class="note-search">Type and Press Enter to Search</label>
							<input type="search" name="keyword" class="form-control" value="" placeholder="Search...">
							<input type="submit" value="Search"/>
						</form> 
					</div>
				</div>
			</header>
</body>
</html>