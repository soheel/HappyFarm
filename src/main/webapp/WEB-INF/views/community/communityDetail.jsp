<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<section class="noo-page-heading eff heading-6">
				<div class="container">
					<div class="noo-heading-content">
						<h1 class="page-title eff">Community Detail</h1>
						<div class="noo-page-breadcrumb eff">
							<a href="./" class="home">Organici</a>/<span>community Detail</span>
						</div>
					</div>
				</div>
			</section>
			<div class="main">
				<div class="commerce single-product noo-shop-main">
					<div class="container">
						<div class="row">
							<div class="noo-main col-md-9">
								<!-- <div class="product">
									<div class="single-inner"> -->
										<h3> 세부사항 보기</h3>
										<div class="images">
											<div class="product-simple-image">
											<h1 class="product_title entry-title">${community.name}</h1>
												<a href="http://lorempixel.com/400/300/" data-rel="prettyPhoto">
													<img width="300" height="381" src="<c:url value="/resources/images/"/>product/${community.profile}/" alt="" />
												</a>
											</div>
										</div>
									
										<h3> 댓글 내용 보기</h3>
										<div class="summary entry-summary">
									
									<c:forEach items="${commentlist}" var="communityDTO">
										<c:forEach items="${communityDTO.communityCommentDTO}" var="comm">
											<p>${comm.no}</p>
											<p>${comm.content}</p>
											<p>${comm.registerdate}</p>
											<p>${comm.email}</p>
										</c:forEach>
									</c:forEach>

									</div>
									
									<h3> 오른쪽 바에 진행중인 행사 목록 띄어주기</h3>
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
										
										
										<!-- <div class="summary entry-summary">
											<h1 class="product_title entry-title"></h1>
											<p class="date"><span class="amount">2016.12.5 - 2016.12.9</span></p>
											<form class="cart">
												<div class="quantity">
													<input type="number" step="1" min="1" name="quantity" value="1" title="Qty" class="input-text qty text" size="4"/>
												</div>
												<button type="submit" class="single_add_to_cart_button button">Add to cart</button>
											</form>
											<div class="yith-wcwl-add-to-wishlist">
                                                <div class="yith-wcwl-add-button">
                                                    <a href="#" class="add_to_wishlist"></a>
                                                </div>
                                            </div>
											<div class="clear"></div>
											<div class="noo-social-share">
												<span>Share:</span>
												<a href="#share" class="noo-share" title="Share on Facebook">
													<i class="fa fa-facebook"></i>
												</a>
												<a href="#share" class="noo-share" title="Share on Twitter">
													<i class="fa fa-twitter"></i>
												</a>
												<a href="#share" class="noo-share" title="Share on Google+">
													<i class="fa fa-google-plus"></i>
												</a>
												<a href="#share" class="noo-share" title="Share on Pinterest">
													<i class="fa fa-pinterest"></i>
												</a>-->
											</div>
										</div>  
									</div>
									<div class="related products profile_board">
									12389
									</div>
									<div class="commerce-tabs">
										<ul class="nav nav-tabs tabs">
									    	<li>
									    		<a data-toggle="tab" href="#tab-1">Comments</a>
									    	</li>
									  	</ul>
										<div class="tab-content">
											<div class="tab-pane fade in active" id="tab-1">
												<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas tristique gravida, odio et sagi ttis justo. Susp endisse ultricies nisi vel quam suscipit, et rutrum odio porttitor. Donec dictum non nulla ut lobortis. Maecenas tristique gravida, odio et sagi ttis justo. Aliquam vitae mi a eros tincidunt ultricies. Donec porta gravida arcu. Morbi facilisis lorem felis, eu inerdum quam scelerisque eu. Phasellus vel turpis dictum, pulvinar nulla</p>
											</div>
										</div>
									
									</div>
									
								</div>
							</div>