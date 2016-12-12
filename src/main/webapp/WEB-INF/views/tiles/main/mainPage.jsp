<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<title>MainPage</title>

		<link rel='stylesheet' href='<c:url value="/resources/css/"/>bootstrap.min.css' type='text/css' media='all' />
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.carousel.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.theme.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>font-awesome.min.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Lato.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Pacifico.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Anonymous+Pro.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>style.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>custom.css' type='text/css' media='all'/>
		<link rel="stylesheet" href='<c:url value="/resources/css/"/>magnific-popup.css' type='text/css' media='all' />
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>

		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>bootstrap.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery-migrate.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>modernizr-2.7.1.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>off-cavnass.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>script.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>custom.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>imagesloaded.pkgd.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>isotope.pkgd.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>portfolio.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.touchSwipe.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.isotope.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>owl.carousel.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jflickrfeed.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.magnific-popup.js'></script>
	
	<script type="text/javascript">
		$(function() {
			$(document).on("click", "#addToCartDirect", function() {
				$.ajax({
					url : "<c:url value='/userProductController/addCartDirect'/>",
					type : "post",
					data : "productNo=" + $(this).parent().parent().parent().children("input[type=hidden]").val(),
					dataType : "text",
					success : function(result) {
						if(result >= 1) {
							alert("해당상품이 장바구니에 추가되었습니다.");
						}else {
							alert("해당상품이 이미 장바구니에 존재합니다.");
						}
					},
					error : function(err) {
						alert("해당상품이 이미 장바구니에 존재합니다.");
					}
				})
			})
			
			$("#test").mouseover(function() {
				$.ajax({
					url : "<c:url value='/userProductController/shopMenuLoading'/>",
					type : "post",
					dataType : "json",
					success : function(result) {
						if(result.length == 6) {
							for(var i = 0 ; i < 3; i++){
								/* 인기상품 갱신 */
								$("#best_product" + (i+1) + "_name").text(result[i].name);
								$("#best_product" + (i+1) + "_price").text(result[i].price + ' 원');
								$("#best_product" + (i+1) + "_profile").attr("src", "<c:url value='/resources/img/product/'/>" + result[i].profile);
								$("#best_product" + (i+1) + "_no").attr("href", "<c:url value='/userProductController/showProductDetail'/>?productNo=" + result[i].no);
								
								/* 계절상품 갱신 */
								$("#season_product" + (i+1) + "_name").text(result[i+3].name);
								$("#season_product" + (i+1) + "_price").text(result[i+3].price + ' 원');
								$("#season_product" + (i+1) + "_profile").attr("src", "<c:url value='/resources/img/product/'/>" + result[i+3].profile);
								$("#season_product" + (i+1) + "_no").attr("href", "<c:url value='/userProductController/showProductDetail'/>?productNo=" + result[i+3].no);
							}
						}else {
							for(var i = 0 ; i < 3; i++){
								/* 인기상품 갱신 */
								$("#best_product" + (i+1) + "_name").text(result[i].name);
								$("#best_product" + (i+1) + "_price").text(result[i].price + ' 원');
								$("#best_product" + (i+1) + "_profile").attr("src", "<c:url value='/resources/img/product/'/>" + result[i].profile);
								$("#best_product" + (i+1) + "_no").attr("href", "<c:url value='/userProductController/showProductDetail'/>?productNo=" + result[i].no);
								
								/* 계절상품 갱신 */
								$("#season_product" + (i+1) + "_name").text(result[i+3].name);
								$("#season_product" + (i+1) + "_price").text(result[i+3].price + ' 원');
								$("#season_product" + (i+1) + "_profile").attr("src", "<c:url value='/resources/img/product/'/>" + result[i+3].profile);
								$("#season_product" + (i+1) + "_no").attr("href", "<c:url value='/userProductController/showProductDetail'/>?productNo=" + result[i+3].no);
								
							}
							for(var j = 7 ; j <= result.length ; j++){
								/* 최근구매목록 갱신 */
								$("#recent_product" + (j-6) + "_name").text(result[j-7].name);
								$("#recent_product" + (j-6) + "_price").text(result[j-7].price + ' 원');
								$("#recent_product" + (j-6) + "_profile").attr("src", "<c:url value='/resources/img/product/'/>" + result[j-7].profile);
								$("#recent_product" + (j-6) + "_no").attr("href", "<c:url value='/userProductController/showProductDetail'/>?productNo=" + result[j-7].no);
							}
							
						}
						
				
					},
					error : function(err) {
						alert("err : " + err);
					}
				})
			})
		})
	</script>
</body>
</html>