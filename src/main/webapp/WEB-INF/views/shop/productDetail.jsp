<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<section class="noo-page-heading eff heading-6">
				<div class="container">
					<div class="noo-heading-content">
						<h1 class="page-title eff">Shop Detail</h1>
						<div class="noo-page-breadcrumb eff">
							<a href="./" class="home">Organici</a>/<span>Shop Detail</span>
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
												<a href="<c:url value="/resources/images/"/>product/product_405x515.jpg" data-rel="prettyPhoto">
													<img width="300" height="381" src="<c:url value="/resources/img/product/"/>${product.profile}" alt="" />
												</a>
											</div>
										</div>
										<div class="summary entry-summary">
											<input id = "product_no" type = "hidden" value = "${product.no }">
											<h1 class="product_title entry-title">${product.name}</h1>
											<p class="price"><span class="amount">${product.price}</span>원</p>
											<div class="product_meta">
												<span class="posted_in">Category: <a href="#">${categoryName }</a></span>
												<span class="posted_in">Unit: <a href="#">${product.unit }</a></span>
												<span class="posted_in">Producer: <a href="#">${producer.name }</a></span>
												
											</div>
											<form action = "<c:url value = '/userProductController/purchase?productNo=${product.no}&producerNo=${producer.no}&price=${product.price}'/>" method = "post" class="cart">
												<div class="quantity">
													<input id = "product_num" type="number" step="1" min="1" name="quantity" value="1" title="Qty" class="input-text qty text" size="4"/>
												</div>
												<input type = "button" id = "addToCart" value = "Add to Cart" class="single_add_to_cart_button button"/>
												<button type="submit" class="single_add_to_cart_button button">Purchase</button>
											</form>
											<div class="clear"></div>
											
										</div> 
									</div>
									<div class="commerce-tabs">
										<ul class="nav nav-tabs tabs">
									    	<li class="active">
									    		<a data-toggle="tab" href="#tab-1">Description</a>
									    	</li>
									    	<li>
									    		<a data-toggle="tab" href="#tab-2">Reviews</a>
									    	</li>
									    	<li>
									    		<a data-toggle="tab" href="#tab-3">Producer</a>
									    	</li>
									  	</ul>
										<div class="tab-content">
										
											<div class="tab-pane fade in active" id="tab-1">
												<img alt="" src="<c:url value='/resources/img/product/'/>${product.desc }">
											</div>
											<div id="tab-2" class="tab-pane fade">
												<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas tristique gravida, odio et sagi ttis justo. Susp endisse ultricies nisi vel quam suscipit, et rutrum odio porttitor. Donec dictum non nulla ut lobortis. Maecenas tristique gravida, odio et sagi ttis justo. Aliquam vitae mi a eros tincidunt ultricies. Donec porta gravida arcu. Morbi facilisis lorem felis, eu inerdum quam scelerisque eu. Phasellus vel turpis dictum, pulvinar nulla</p>
											</div>
											<div class="tab-pane fade" id="tab-3">
												<img style = "width : 200px; height : 200px; margin : auto;" alt="" src="<c:url value='/resources/img/producer/'/>${producer.profile}">
												<p>생산자 이름 : ${producer.name }</p>
												<p>생산지 : <span id = "producer_addr">${producer.addr}</span></p>
												<div id = "mapDiv" style = "width : 500px; height:400px;"></div>
												<p>생산자 연락처 : ${producer.phone}</p>
												
											</div>
										</div>
									</div>
									<div class="related products">
										<p>본 상품 가격의</p>
										<p>10%는 마일리지로적립됩니다.</p>
										<img src='<c:url value="/resources/images/"/>double_quote.png' class="absolute reverse_img quote quote_left">
										<img src='<c:url value="/resources/images/"/>double_quote.png' class=" absolute quote quote_right">
									</div>
								</div>
							</div>
					
		<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=a4323905bc104c7f43e6f2c4a13baa6b&libraries=services"></script>
		<script type="text/javascript">
		var addr = document.getElementById('producer_addr').innerHTML;
		 // 다음 지도
	    var geocoder = new daum.maps.services.Geocoder();
	    var callback = function(status, result) {
	        if (status === daum.maps.services.Status.OK) {
	        	var container = document.getElementById('mapDiv');
	        	var options = {
	        		center: new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng),
	        		level: 3
	        	};

	        	var map = new daum.maps.Map(container, options);
	        }
	    };
	    geocoder.addr2coord(addr, callback); // db에서 꺼내온 주소를 addr2coord함수의 첫번째 인수에 문자열로 넣어줌
		</script>