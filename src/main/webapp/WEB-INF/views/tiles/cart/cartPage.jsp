<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en-US">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<link rel="shortcut icon" href="images/favicon.ico"/>
	<title>Cart</title>
	
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>bootstrap.min.css' type='text/css' media='all' />
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>prettyPhoto.css' type='text/css' media='all' />
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
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.prettyPhoto.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.prettyPhoto.init.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>off-cavnass.js'></script>	
	<script type='text/javascript' src='<c:url value="/resources/js/"/>script.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>custom.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>imagesloaded.pkgd.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>isotope.pkgd.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>portfolio.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.touchSwipe.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.carouFredSel-6.2.1.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.isotope.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>owl.carousel.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jflickrfeed.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.magnific-popup.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>core.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>widget.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>mouse.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>slider.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.ui.touch-punch.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>price-slider.js'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/"/>shop-categories-btn.js'></script>
	
	<script type="text/javascript">
	$(function() {
		var num = 0;
		var totalPrice = $("#totalPrice").text();

		/* 물건 개수를 수정할 때마다 가격 변경 */
		$(".quantity input[type=number]").change(function() {
			num = $(this).next().val(); /* 처음 저장한 개수 */
			var price = $(this).parent().parent().prev().children().text(); /* 상품의 개당 가격 */
			var changedNum = $(this).val() - num;
			$(this).next().val(parseInt(num) + parseInt(changedNum));
			var totalPrice = $("#totalPrice").text();
			$(this).parent().parent().next().children().text($(this).val() * $(this).parent().parent().prev().children().text());
			/* 변경될 때마다 totalPrice 변경해주기 */
			/* var chagnedtotalPrice = $("#totalPrice").text() + (changedNum * price);
			changedPrice를 $("#totalPrice")에 넣어주기 */
			$("#totalPrice").text((parseInt(totalPrice) + (changedNum * price)));
		});
		
		/* 상품별 체크박스 */
		$(".checkboxs input[type=checkbox]").change(function() {
			var totalPrice = $("#totalPrice").text();
			var price = $(this).parent().parent().next().next().next().next().children().text();

			if($(this).attr("checked") == 'checked'){
				$("#totalPrice").text(parseInt(totalPrice) + parseInt(price));
				$(this).parent().parent().next().next().next().children().children("input[type=number]").attr("disabled", false);
			}else {
				$("#totalPrice").text(totalPrice - price);
				$(this).parent().parent().next().next().next().children().children("input[type=number]").attr("disabled", true);
			}
			
		})
		
		/* 상품 전체 체크박스 */
		$("#checkAll").change(function() {
			if($(this).attr("checked") == 'checked'){
				$(".checkboxs input[type=checkbox]").attr("checked", true);
				$("#totalPrice").text(totalPrice);
				$("input[type=number]").prop("disabled", false);
			}else {
				$(".checkboxs input[type=checkbox]").attr("checked", false);
				$("#totalPrice").text(0);
				$("input[type=number]").prop("disabled", true);
			}
		})
	})
	</script>
</body>
</html>