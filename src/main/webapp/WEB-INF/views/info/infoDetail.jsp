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