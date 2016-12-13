<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en-US">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<link rel="shortcut icon" href="<c:url value="/resources/images/"/>favicon.ico"/>
	<title>Cart</title>
	
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>bootstrap.min.css' type='text/css' media='all' />
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.carousel.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.theme.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>font-awesome.min.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>Lato.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>Pacifico.css' type='text/css' media='all'/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>Anonymous+Pro.css' type='text/css' media='all'/>
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>Roboto.css" type="text/css" media="all"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>nanumgothic.css" type="text/css" media="all"/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>style.css' type='text/css' media='all'/>
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>magnific-popup.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>myAccount.css' type='text/css' media='all' />
</head>
<body>
	<div class="noo-spinner">
		<div class="spinner">
			<div class="cube1"></div>
			<div class="cube2"></div>
		</div>
	</div>
	<div class="site">
		<tiles:insertAttribute name="header"/>
	<div class="main">
		<div class="commerce noo-account-main">
			<div id="wrapper">
				<div class="overlay"></div>

				<!-- Sidebar -->
				<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
					<ul class="nav sidebar-nav">
						<li class="sidebar-brand">
							<a href="<c:url value="/userInfoController/myPageLoading"/>">
								My Account
							</a>
						</li>
						<li class="dropdown">
							<a href="<c:url value="/account/shopping"/>" class="dropdown-toggle" data-toggle="dropdown">쇼핑내역<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-header">원하는 메뉴를 선택해주세요.</li>
								<li><a href="<c:url value="/userInfoController/myPageOrderList"/>">주문 / 배송 조회</a></li>
								<li><a href="<c:url value="/userInfoController/myPageCancelList"/>">취소 / 반품 / 교환</a></li>
								<li><a href='<c:url value="/userInfoController/myPageRefundList"/>'>환불내역</a></li>
							</ul>
						</li>
						<li>
							<a href="<c:url value="/userInfoController/myPageQna"/>">Q&A</a>
						</li>
						<li>
							<a href="<c:url value="/userInfoController/myPageDonation"/>">기부</a>
						</li>
						<li>
							<a href="<c:url value="/userInfoController/myPageInfoModify"/>">정보관리</a>
						</li>
					</ul>
				</nav>
				<!-- /#sidebar-wrapper -->

				<!-- Page Content -->
				<div id="page-content-wrapper">
					<button type="button" class="hamburger is-closed" data-toggle="offcanvas">
						<span class="hamb-top"></span>
						<span class="hamb-middle"></span>
						<span class="hamb-bottom"></span>
					</button>
					<div class="container">
						<!-- 사용자 내역 -->
						<tiles:insertAttribute name="content"/>
					</div>
				</div>
				<!-- /#page-content-wrapper -->

			</div>
			<!-- /#wrapper -->

				<!--
					copyRight : https://twitter.com/maridlcrmn
				-->
			</div>
		</div>
	</div>
	<div id="order-dialog">
		<div class="row">
			<div class="col-lg-3"></div>
	    	<div class="col-lg-6 col-centered">
				<div class="form-row form-row-wide dialog">
					<form class="find-profile order">
						<input type="radio" name="type" value="refund">환불
						<input type="radio" name="type" value="return">반품
						<input type="radio" name="type" value="change">교환
						<br>
						<label for="find_id">
						사유
							<span class="required">*</span>
						</label>
						<input type="text" class="input-text" name="id" id="order_board" value=""/>
						<br>
											
						<label for="find_pw">
						비밀번호 확인 
						<span class="required">*</span>
						</label>
						<input type="password" class="input-text" name="name" id="order_pw" value=""/>
						
						<br>	
						<input type="submit" class="button" name="select" value="확인" />
						<input type="button" class="button" name="cancel" value="취소" />
					</form>
				</div>
	    	</div>
	    	<div class="col-lg-3"></div>
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
	<script type="text/javascript" src="<c:url value="/resources/js/"/>myAccount.js"></script>
	<script type="text/javascript">
	//버튼의 value값에 따라 결과 나누기
	$(document).ready(function(){
		$(".searchOrderList").click(function(){
			//alert($(this).val());
			location.href="<c:url value='/userInfoController/searchOrderList'/>?value="+$(this).val();
		});
		
		$(".searchRefundList").click(function(){
			//alert($(this).val());
			location.href="<c:url value='/userInfoController/searchRefundList'/>?value="+$(this).val();
		});
		
		$(".searchReturnList").click(function(){
			//alert($(this).val());
			location.href="<c:url value='/userInfoController/searchReturnList'/>?value="+$(this).val();
		});
		
	});
</script>
</body>
</html>