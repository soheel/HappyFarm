<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
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
						<div class="product">
							<div class="single-inner">
								<div class="images">
									<div class="product-simple-image">
										<a
											href="<c:url value="/resources/images/"/>product/product_405x515.jpg"
											data-rel="prettyPhoto"> <img width="300" height="381"
											src="<c:url value="/resources/images/"/>product/product_405x515.jpg"
											alt="" />
										</a>
									</div>
								</div>
								<div class="summary entry-summary">
									<h1 class="product_title entry-title">Name</h1>
									<p class="price">
										<span class="amount">&#36;1.95</span>
									</p>
									<p class="description">Lorem ipsum dolor sit amet,
										consectetur adipiscing elit, sed do eiusmod tempor incididunt
										ut labore et dolore magna aliqua</p>
									<div class="product_meta">
										<span class="posted_in">Category: <a href="#">Vegetable</a></span>
										<span class="tagged_as">Tags: <a href="#">cucumbers</a>,
											<a href="#">vegetables</a></span>
									</div>
									<form class="cart">
										<div class="quantity">
											<input type="number" step="1" min="1" name="quantity"
												value="1" title="Qty" class="input-text qty text" size="4" />
										</div>
										<button type="submit" class="single_add_to_cart_button button">Add
											to cart</button>
									</form>
									<div class="yith-wcwl-add-to-wishlist">
										<div class="yith-wcwl-add-button">
											<a href="#" class="add_to_wishlist"></a>
										</div>
									</div>
									<div class="clear"></div>
									<div class="noo-social-share">
										<span>Share:</span> <a href="#share" class="noo-share"
											title="Share on Facebook"> <i class="fa fa-facebook"></i>
										</a> <a href="#share" class="noo-share" title="Share on Twitter">
											<i class="fa fa-twitter"></i>
										</a> <a href="#share" class="noo-share" title="Share on Google+">
											<i class="fa fa-google-plus"></i>
										</a> <a href="#share" class="noo-share" title="Share on Pinterest">
											<i class="fa fa-pinterest"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="related products info_profile_board">
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
					정보<br>
				</div>
			</div>
		</div>
	</div>

	<div class="noo-footer-shop-now">
		<div class="container">
			<div class="col-md-7">
				<h4>- Every day fresh -</h4>
				<h3>organic food</h3>
			</div>
			<img src="<c:url value="/resources/images/"/>organici-love-me.png"
				class="noo-image-footer" alt="" />
		</div>
	</div>
</body>
</html>