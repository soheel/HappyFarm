<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<div class="main">
				<div class="interact-banner">
					<div class="container">
						<div class="row">
							<div class="noo-traslate-atributes col-sm-12 col-md-6 hidden-xs">
								<div class="pt-.search-header55">
									<div class="noo-atributes">
										<img width="494" height="618" src='<c:url value="/resources/img/main/"/>image-01.png' alt="" />
										<div class="noo-atributes-item">
											<div class="noo-atributes-hover">
												<div class="noo-atributes-content">
													<strong>12 Green Apples</strong> 
													<p>Maecenas tristique gravida, odio et sagi ttis justo </p> 
												</div>
											</div>
											<span class="eff">
												<span class="eff1"></span>
												<span class="eff2"></span>
												<img width="64" height="64" src='<c:url value="/resources/img/main/"/>organicfood-1.png' alt=""/> 
											</span>
										</div>
										<div class="noo-atributes-item noo-atributes-item2 orange">
											<div class="noo-atributes-hover">
												<div class="noo-atributes-content">
													<strong>10 Orange Apples</strong> 
													<p>Maecenas tristique gravida, odio et sagi ttis justo </p> 
												</div>
											</div>
											<span class="eff">
												<span class="eff1"></span>
												<span class="eff2"></span>
												<img width="53" height="53" src='<c:url value="/resources/img/main/"/>organicfood-2.png' alt=""/>
											</span>
										</div>
										<div class="noo-atributes-item noo-atributes-item4 orange">
											<div class="noo-atributes-hover">
												<div class="noo-atributes-content">
													<strong>15 Pear Apples</strong> 
													<p>Maecenas tristique gravida, odio et sagi ttis justo </p> 
												</div>
											</div>
											<span class="eff">
												<span class="eff1"></span>
												<span class="eff2"></span>
												<img width="53" height="53" src='<c:url value="/resources/img/main/"/>organicfood-3.png' alt=""/> 
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="noo-traslate-product col-sm-12 col-md-6">
								<div class="pt-5">
									<div class="noo-short-intro">
										<h4>Special fruits</h4>
										<h2>organici store</h2>
										<div class="price">
											<span>- Only -</span>
											$99.00 
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="pt-15 pb-11">
					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div class="noo-product-grid-wrap commerce product-style">
									<div class="noo-sh-title">
										<h2>Our new products</h2>
										<p>Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt eronec dictum non nulla.</p>
									</div>
									
									<!-- 상품 목록 -->
									<div class="noo-product-grid products row product-grid noo-grid-4">
									
										
										<c:forEach items="${bestProduct }" var="bestProduct">
											<!-- 상품 하나하나 -->
											<div class="fruit organic-fruits masonry-item col-md-4 col-sm-6">
											<div class="noo-product-inner">
											
												<!-- 상품 -->
												<div class="noo-product-thumbnail">
													<a href="<c:url value="/userProductController/showProductDetail?productNo=${bestProduct.no }"/>">
														<img width="600" height="760" src='<c:url value="/resources/img/product/"/>${bestProduct.profile}' alt="" />
													</a>
													<div class="noo-rating">
														<div class="star-rating">
															<span style="width:${bestProduct.eval * 20}%"></span>
														</div>
													</div>
												</div>
												<div class="noo-product-title"> 
													<input id = "product_no" type = "hidden" value = "${bestProduct.no }">
													<h3><a href="<c:url value="/shop/"/>detail">${bestProduct.name }</a></h3>
													<span class="price"><span class="amount"><fmt:formatNumber value="${bestProduct.price }" pattern="#,###"/> 원</span></span>
													<div class="noo-product-action">
														<div class="noo-action" id="addToCartDirect">
															<input type = "button" value="Add to cart" class="single_add_to_cart_button button">
														</div>
													</div>
												</div>
											</div>
										</div>
										</c:forEach>

									</div> <!-- 상품 목록 끝 -->
									
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 식품 정보 -->
				<div class="feature-product">
					<div class="noo-sh-title text-center">
						<h2>Featured products</h2>
						<p>Maecenas tristique gravida odio, et sagi ttis justo interdum porta</p>
					</div>
					<div class="noo-product-masonry columns-3">
						<!-- info 하나하나 -->
						<c:forEach items="${infoList }" var="infoList">
							<div class="product-masonry">
							<img style = "padding : 10px;" width="644" height="380" src="<c:url value="/resources/img/info/"/>${infoList.profile}" alt="" /> 
							<div class="noo-link">
								<div class="noo-product-table">
									<div class="noo-product-table-cell">
										<h4>${infoList.name}</h4>
										<p>
											<a href = "">자세히 보기&hellip;</a>
										</p>
									</div>
								</div>
							</div> 
							</div>
						</c:forEach>
						
					
					</div>
				</div>
				
				<!-- 생산자 정보 -->
				<div class="pt-11 pb-10">
					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div class="noo-sh-title noo-farmer-title">
									<h2>Our farmer</h2>
									<p>
										Fusce sem enim, rhoncus volutpat condimentum ac, placerat semper ligula. Suspendisse in viverra justo ipsum dolor sit amet, consectetur adipiscing elit. 
									</p>
								</div>
							</div>
						</div>
						<div class="row">
						
						<c:forEach items="${bestProducer }" var="bestProducer">
							<!-- 생산자 하나하나 -->
							<div class="col-md-4 col-sm-6">
								<div class="noo-farmer">
									<div class="noo-farmer-thumbnail">
										<img style="width : 360px; height : 330.9px;" src="<c:url value="/resources/img/producer/"/>${bestProducer.profile}" alt="" />
									</div>
									<div class="noo-farmer-content">
										<h4>${bestProducer.name }</h4>
										<p>
											${bestProducer.addr }
										</p>
										<p>
											${bestProducer.phone }
										</p>

									</div>
								</div> 
							</div>
						</c:forEach>
							
						</div>
					</div>
				</div>	
				<div class="testimonial">
					<div class="noo_testimonial_wrap">
						<img width="328" height="851" src="<c:url value="/resources/img/main/"/>image_left.png" class="image_left" alt=""/>
						<img width="329" height="789" src="<c:url value="/resources/img/main/"/>image_right.png" class="image_right" alt="" /> 
						<div class="noo-testimonial-sync2 testimonial-three">
							<div class="item">
								<div class="testimonial-content">
									<h3 class="testi-title">Taylor McCartney</h3>
									<div>
										<i class="fa fa-quote-left"></i>
										<p>
											Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt ero. Donec dictum non nulla ut tris tique gravida odio lobortis tristique gravida. Aliquam erat volutpat. Pellentesque auctor, arcu id tristique.
										</p>
										<i class="fa fa-quote-right"></i>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="testimonial-content">
									<h3 class="testi-title">Ashley Simpsons</h3>
									<div>
										<i class="fa fa-quote-left"></i>
										<p>
											Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt ero. Donec dictum non nulla ut tris tique gravida odio lobortis tristique gravida. Aliquam erat volutpat. Pellentesque auctor, arcu id tristique.
										</p>
										<i class="fa fa-quote-right"></i>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="testimonial-content">
									<h3 class="testi-title">Olivia Jolie</h3>
									<div>
										<i class="fa fa-quote-left"></i>
										<p>
											Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt ero. Donec dictum non nulla ut tris tique gravida odio lobortis tristique gravida. Aliquam erat volutpat. Pellentesque auctor, arcu id tristique.
										</p>
										<i class="fa fa-quote-right"></i>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="testimonial-content">
									<h3 class="testi-title">Tyrion Lannister</h3>
									<div>
										<i class="fa fa-quote-left"></i>
										<p>
											Maecenas tristique gravida odio, et sagi ttis justo interdum porta. Duis et lacus mattis, tincidunt ero. Donec dictum non nulla ut tris tique gravida odio lobortis tristique gravida. Aliquam erat volutpat. Pellentesque auctor, arcu id tristique.
										</p>
										<i class="fa fa-quote-right"></i>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="testimonial-content">
									<h3 class="testi-title">테스트입니다</h3>
									<div>
										<i class="fa fa-quote-left"></i>
										<p>
											Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
											tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
											quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
											consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse.
										</p>
										<i class="fa fa-quote-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="noo-testimonial-sync1 testimonial-three">
							<div class="item">
								<div class="background_image">
									<img class="noo_testimonial_avatar" src="<c:url value="/resources/images/"/>avatar/avatar_120x120.jpg" alt=""/>
								</div>
								<div class="testimonial-name">
									<h4 class="noo_testimonial_name">- Taylor -</h4>
									<span class="noo_testimonial_position">( Web Desinger )</span>
								</div>
							</div>
							<div class="item">
								<div class="background_image">
									<img class="noo_testimonial_avatar" src="<c:url value="/resources/images/"/>avatar/avatar_120x120.jpg" alt=""/>
								</div>
								<div class="testimonial-name">
									<h4 class="noo_testimonial_name">- Ashley -</h4>
									<span class="noo_testimonial_position">( Developer )</span>
								</div>
							</div>
							<div class="item">
								<div class="background_image">
									<img class="noo_testimonial_avatar" src="<c:url value="/resources/images/"/>avatar/avatar_120x120.jpg" alt=""/>
								</div>
								<div class="testimonial-name">
									<h4 class="noo_testimonial_name">- Olivia -</h4>
									<span class="noo_testimonial_position">( Web Desinger )</span>
								</div>
							</div>
							<div class="item">
								<div class="background_image">
									<img class="noo_testimonial_avatar" src="<c:url value="/resources/images/"/>avatar/avatar_120x120.jpg" alt=""/>
								</div>
								<div class="testimonial-name">
									<h4 class="noo_testimonial_name">- Tyrion Lannister -</h4>
									<span class="noo_testimonial_position">( Ceo )</span>
								</div>
							</div>
							<div class="item">
								<div class="background_image">
									<img class="noo_testimonial_avatar" src="<c:url value="/resources/images/"/>avatar/avatar_120x120.jpg" alt=""/>
								</div>
								<div class="testimonial-name">
									<h4 class="noo_testimonial_name">- 테스트입니다 -</h4>
									<span class="noo_testimonial_position">( Test )</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>