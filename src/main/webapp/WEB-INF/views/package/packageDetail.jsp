<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<section class="noo-page-heading eff">
	<div class="container">
		<div class="noo-heading-content">
			<h1 class="page-title eff">Package Detail</h1>
			<div class="noo-page-breadcrumb eff">
				<a href="./" class="home">Organici</a>/<span>Package Detail</span>
			</div>
		</div>
	</div>
</section>
<div class="main">
	<div class="commerce single-product noo-shop-main">
		<div class="container">
			<div class="row">
				<div class="noo-main col-md-12">
					<div class="product">
						<div class="single-inner">
							<div class="images">
								<div class="project-slider">
									<div class="owl-carousel sync1">
										<div class="item">
											<a
												href="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												data-rel="prettyPhoto[product-gallery]"> <img
												width="561" height="713"
												src="<c:url value="/resources/img/product/"/>${packageProduct.profile}"
												alt="" />
											</a>
										</div>
										<div class="item">
											<a
												href="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												data-rel="prettyPhoto[product-gallery]"> <img
												width="300" height="381"
												src="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												alt="" />
											</a>
										</div>
										<div class="item">
											<a
												href="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												data-rel="prettyPhoto[product-gallery]"> <img
												width="300" height="381"
												src="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												alt="" />
											</a>
										</div>
										<div class="item">
											<a
												href="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												data-rel="prettyPhoto[product-gallery]"> <img
												width="300" height="381"
												src="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												alt="" />
											</a>
										</div>
										<div class="item">
											<a
												href="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												data-rel="prettyPhoto[product-gallery]"> <img
												width="260" height="330"
												src="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												alt="" />
											</a>
										</div>
										<div class="item">
											<a
												href="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												data-rel="prettyPhoto[product-gallery]"> <img
												width="260" height="330"
												src="<c:url value="/resources/images/"/>box/box_540x686.jpg"
												alt="" />
											</a>
										</div>
									</div>

								</div>
							</div>
							<div class="summary entry-summary">
								<input type = "hidden" id = "product_no" value="${packageProduct.no}">
								<h1 class="product_title entry-title">${packageProduct.name}</h1>
								<p class="price">
									<span class="amount"><fmt:formatNumber
											value='${packageProduct.price}' pattern='#,###' /> 원</span>
								</p>

								<div class="product_meta">
									<span class="tagged_as">Unit: <a href="#">${packageProduct.unit}</a></span>

								</div>
								<form action = "<c:url value = '/userProductController/purchase?productNo=${packageProduct.no}&producerNo=0&price=${packageProduct.price}'/>" method = "post" class="cart">
									<div class="quantity">
										<input type="number" step="1" min="1" name="quantity"
											value="1" title="Qty" class="input-text qty text" size="4" id = "product_num" />
									</div>
									<input type="button" id="addToCart" value="Add to Cart"
										class="single_add_to_cart_button button" />
									<button type="submit" class="single_add_to_cart_button button">Purchase</button>
								</form>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="product">
						<div class="commerce-tabs">
							<ul class="nav nav-tabs tabs">
								<li class="active"><a data-toggle="tab"
									href="#tab-noo_boxes_tab">Box contents</a></li>
								<li><a data-toggle="tab" href="#tab-description">Description</a>
								</li>
								<li><a data-toggle="tab" href="#tab-review">Reviews</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane fade in active" id="tab-noo_boxes_tab">
									<ul>

										<c:forEach items="${list}" var="list">
											<!-- 패키시 상품 내에있는 개별 상품 -->
											<li>
												<div class="box-item">
													<img width="150" height="150"
														src="<c:url value="/resources/img/product/"/>${list.profile}"
														alt="" /> <a
														href="<c:url value = '/userProductController/showProductDetail?productNo='/>${list.no}"><strong>${list.name}</strong></a>
													<span><fmt:formatNumber value='${list.price}'
															pattern='#,###' /> 원</span>
												</div>
											</li>
											<!-- 패키시 상품 내에있는 개별 상품 -->
										</c:forEach>

									</ul>
									<p class="ds">We do our best to send you the things youwill
										will chosen. Our photos do not show the actual quantities.</p>
								</div>
								<div id="tab-description" class="tab-pane fade">
									<img alt=""
										src="<c:url value='/resources/img/product/'/>${packageProduct.desc}">
								</div>
								<div id="tab-review" class="tab-pane fade">
									<div id="comments" class="comments-area">
										<h2 class="comments-title">3 Comments</h2>
										<ol class="comments-list">
											<li class="comment">
												<div class="comment-wrap">
													<div class="comment-img">
														<img alt='' src='http://placehold.it/100x100' height='80'
															width='80' />
													</div>
													<article class="comment-block">
														<header class="comment-header">
															<cite class="comment-author"> admin </cite>
															<div class="comment-meta">
																<span class="time"> 4 months ago </span>
															</div>
														</header>
														<div class="comment-content">
															<p>fames ac turpis egestas. Ut non enim eleifend
																felis pretium feugiat. Vivamus quis mi. Phasellus</p>
														</div>
														<span class="comment-reply"> <a
															class='comment-reply-link' href='#'><i
																class="fa fa-reply"></i> Reply</a>
														</span>
													</article>
												</div>
												<ol class="children">
													<li class="comment">
														<div class="comment-wrap">
															<div class="comment-img">
																<img alt='' src='http://placehold.it/100x100'
																	height='80' width='80' />
															</div>
															<article class="comment-block">
																<header class="comment-header">
																	<cite class="comment-author"> admin </cite>
																	<div class="comment-meta">
																		<span class="time"> 4 months ago </span>
																	</div>
																</header>
																<div class="comment-content">
																	<p>fSames ac turpis egestas. Ut non enim eleifend
																		felis pretium feugiat. Vivamus quis mi. Phasellus</p>
																</div>
																<span class="comment-reply"> <a
																	class='comment-reply-link' href='#'><i
																		class="fa fa-reply"></i> Reply</a>
																</span>
															</article>
														</div>
													</li>
													<!-- #comment-## -->
												</ol>
												<!-- .children -->
											</li>
											<!-- #comment-## -->
											<li class="comment">
												<div class="comment-wrap">
													<div class="comment-img">
														<img alt='' src='http://placehold.it/100x100' height='80'
															width='80' />
													</div>
													<article class="comment-block">
														<header class="comment-header">
															<cite class="comment-author"> admin </cite>
															<div class="comment-meta">
																<span class="time"> 4 months ago </span>
															</div>
														</header>
														<div class="comment-content">
															<p>fames ac turpis egestas. Ut non enim eleifend
																felis pretium feugiat. Vivamus quis mi. Phasellus</p>
														</div>
														<span class="comment-reply"> <a
															class='comment-reply-link' href='#'><i
																class="fa fa-reply"></i> Reply</a>
														</span>
													</article>
												</div>
											</li>
											<!-- #comment-## -->
										</ol>
										<!-- /.comments-list -->
										<div id="respond-wrap">
											<div id="respond" class="comment-respond">
												<h3 id="reply-title" class="comment-reply-title">
													<span>Leave your thought</span>
												</h3>
												<form class="comment-form">
													<div class="row">
														<div class="comment-form-author col-sm-6">
															<input id="author" name="author" type="text"
																placeholder="Enter Your Name*" class="form-control"
																value="" size="30" />
														</div>
														<div class="comment-form-email col-sm-6">
															<input id="email" name="email" type="text"
																placeholder="Enter Your Email*" class="form-control"
																value="" size="30" />
														</div>
														<div class="col-sm-12">
															<div class="comment-form-comment">
																<textarea class="form-control"
																	placeholder="Enter Your Comment" id="comment"
																	name="comment" cols="40" rows="6"></textarea>
															</div>
														</div>
													</div>
													<div class="form-submit">
														<input name="submit" type="submit" id="submit"
															class="submit" value="Post Comments" />
													</div>
												</form>
											</div>
											<!-- #respond -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>