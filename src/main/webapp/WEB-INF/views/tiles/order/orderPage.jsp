<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en-US">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<link rel="shortcut icon" href="<c:url value="/resources/images/"/>favicon.ico"/>
	<title>Shop</title>
	
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>bootstrap.min.css' type='text/css' media='all' />
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>prettyPhoto.css' type='text/css' media='all' />
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.carousel.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.theme.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>font-awesome.min.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>Lato.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>Pacifico.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>Anonymous+Pro.css' type='text/css' media='all'/>
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>Roboto.css" type="text/css" media="all"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>nanumgothic.css" type="text/css" media="all"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>Airways.css" type="text/css" media="all"/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>style.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>custom.css' type='text/css' media='all'/>
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>magnific-popup.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>shopOrder.css' type='text/css' media='all' />
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
	
		$(document).ready(function(){
			
			/* 마일리지 적은만큼 최종 결제금액 수정하기 */
			$("#useMileage").keyup(function(){
				var discount = $("#useMileage").val();
				var point = $("#totalPrice").val();
				var total= point-parseInt(discount);
				var result = numberWithCommas(total) + " 원";
				$("#amount").html(result);
				
				if(discount > parseInt(point)) {
					$("#amount").html(0);
				}
			});
		})
		
		function orderCheck() {
			var myMileage = parseInt(document.getElementById("hiddenMileage").value);
			
			// 마일리지 체크
			if(document.getElementById("useMileage").value != 0) {
				if(document.getElementById("useMileage").value < 1000 ||
						document.getElementById("useMileage").value > myMileage ) {
					alert("사용가능한 마일리지를 입력하세요")
					return false;
				}
				var totalPrice = parseInt(document.getElementById("totalPrice").value);
				if(document.getElementById("useMileage").value > totalPrice * 0.2) {
					alert("총 금액의 20% 까지만 기부 포인트로 결제하실 수 있습니다.")
					return false;
				}
			}
			
			// 수취인 체크 (addressee)
			if(document.getElementById("addressee").value == "") {
				alert("수취인을 입력하세요")
				return false;
			}
			
			// 주소 체크(sample6_postcode, sample6_address, sample6_address2)
			if(document.getElementById("sample6_postcode").value == "" || document.getElementById("sample6_address").value == "" ||
					document.getElementById("sample6_address2").value == "") {
				alert("주소를 빠짐없이 입력하세요");
				return false;
			}
			
			// 연락처 체크(phone1, phone2)
			if(document.getElementById("phone1").value == "" || document.getElementById("phone2").value == "") {
				alert("연락처를 입력하세요");
				return false;
			}
			
			return true;
		}
		
	</script>
</body>
</html>