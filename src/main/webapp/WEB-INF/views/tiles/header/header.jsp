<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
								<c:choose>
									<c:when test="${sessionScope.email == null }">
										<a href="<c:url value='/userInfoController/loginPage'/>">Login</a>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${sessionScope.email == 'admin' }">
												<a href="<c:url value='/userInfoController/adminPage'/>">ManagePage</a>
											</c:when>
											<c:otherwise>
												<a href="<c:url value='/userInfoController/myPageLoading'/>">My Account</a>
											</c:otherwise>
										</c:choose>
											<a href="<c:url value='/userInfoController/logout'/>">&nbsp;|&nbsp;Logout</a>
									</c:otherwise>
								</c:choose>
								
							</li>
							<li>
								<a href="<c:url value="/userInfoController/myCart"/>">
									<span class="has-cart">
										<i class="fa fa-shopping-cart"></i>
									</span>
								</a>
								
							</li>
							<li>
								<a href="#" class="fa fa-search noo-search" id="noo-search"></a>
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
									<a href="<c:url value="/"/>" class="navbar-brand">
										<img class="noo-logo-img noo-logo-normal" src='<c:url value="/resources/images/"/>logo.png' alt="Organic Store">
									</a>
								</div>
								<nav class="pull-right noo-main-menu">
									<ul class="nav-collapse navbar-nav">
										<li><a href="<c:url value="/"/>">Home</a></li>
										<li class="menu-item-has-children noo_megamenu mega-col-columns-4">
											<a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=5"/>" id="test">Shop</a>
											<ul class="sub-menu">
												<li class="menu-item-has-children">
													<a href="<c:url value="/"/>shop">Shop page</a>
													<ul class="sub-menu">
														<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=1"/>">과일/견과</a></li>
														<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=10"/>">채소</a></li>
														<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=20"/>">쌀/잡곡</a></li>
													</ul>
												</li>
												<li class="menu-item-has-children">
													<div class="noo_megamenu_widget_area">
														<div class="widget commerce widget_products">
															<h3 class="widget-title">인기상품</h3>
															<ul class="product_list_widget">
																<li>
																	<a id = "best_product1_no" href="<c:url value="/shop/"/>detail">
																		<img id ="best_product1_profile"  width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id ="best_product1_name" class="product-title"></span>
																	</a>
																	<span id ="best_product1_price" class="amount"></span>
																</li>
																<li>
																	<a id = "best_product2_no" href="<c:url value="/shop/"/>detail">
																		<img id = "best_product2_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "best_product2_name" class="product-title"></span>
																	</a>
																	<span id = "best_product2_price" class="amount"></span>
																</li>
																<li>
																	<a id = "best_product3_no" href="<c:url value="/shop/"/>detail">
																		<img id = "best_product3_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "best_product3_name" class="product-title"></span>
																	</a>
																	<span id = "best_product3_price" class="amount"></span>
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
																	<a id = "season_product1_no" href="<c:url value="/shop/"/>detail">
																		<img id = "season_product1_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "season_product1_name" class="product-title">French Bread</span>
																	</a>
																	<span id = "season_product1_price" class="amount">&#36;10.00</span>
																</li>
																<li>
																	<a id = "season_product2_no" href="<c:url value="/shop/"/>detail">
																		<img id = "season_product2_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "season_product2_name" class="product-title">Cookie</span>
																	</a>
																	<span id = "season_product2_price" class="amount">&#36;15.00</span>
																</li>
																<li>
																	<a id = "season_product3_no" href="<c:url value="/shop/"/>detail">
																		<img id = "season_product3_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "season_product3_name" class="product-title">Brown Bread</span>
																	</a>
																	<span id = "season_product3_price" class="amount">&#36;12.00</span>
																</li>
															</ul>
														</div>
													</div>
												</li>
												<li>
													<div class="noo_megamenu_widget_area">
														<div class="widget commerce widget_products">
															<h3 class="widget-title">최근 구매 상품</h3>
															<ul class="product_list_widget">
																<li>
																	<a id = "recent_product1_no" href="<c:url value="/userInfoController/loginPage"/>" onclick="chk();"> 
																		<img id = "recent_product1_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "recent_product1_name" class="product-title"></span>
																	</a>
																	<span id = "recent_product1_price" class="amount"></span>
																</li>
																<li>
																	<a id = "recent_product1_no" href="<c:url value="/userInfoController/loginPage"/>" onclick="chk();"> 
																		<img id = "recent_product2_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "recent_product2_name" class="product-title"></span>
																	</a>
																	<span id = "recent_product2_price" class="amount"></span>
																</li>
																<li>
																	<a id = "recent_product1_no" href="<c:url value="/userInfoController/loginPage"/>" onclick="chk();"> 
																		<img id = "recent_product3_profile" width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" /> 
																		<span id = "recent_product3_name" class="product-title"></span>
																	</a>
																	<span id = "recent_product3_price" class="amount"></span>
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