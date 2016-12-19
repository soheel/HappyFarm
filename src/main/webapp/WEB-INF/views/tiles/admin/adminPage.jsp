<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<link rel="shortcut icon" href="<c:url value="/resources/images/"/>favicon.ico"/>
	<title>Admin Page</title>
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
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminPage.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminShopItem.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminCommunity.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminQna.css' type='text/css' media='all' />
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
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
							<a href='<c:url value="/admin"/>'>
								Admin Page
							</a>
						</li>
						<li>
							<a href="<c:url value="/manageController/productManage"/>">개별 상품 관리</a>
						</li>
						<li>
							<a href="<c:url value="/manageController/packageManage"/>">세트 상품 관리</a>
						</li>
						<li>
							<a href="<c:url value="/manageController/producerManage"/>">생산자 관리</a>
						</li>
						<li>
							<a href="<c:url value="/manageController/donationOrgManage"/>">기부 업체 관리</a>
						</li>
						<li class="dropdown">
                  			<a href="<c:url value="/manageController/salesManage"/>" class="dropdown-toggle" data-toggle="dropdown">매출 관리&nbsp;<span class="caret"></span></a>
                  			<ul class="dropdown-menu" role="menu">
                  				<!-- 
                    			<li class="dropdown-header">Dropdown heading</li>
                    			 -->
                    			<li><a href='<c:url value="/admin/sales/total"/>'>총 매출</a></li>
                    			<li><a href="<c:url value="/admin/sales/month"/>">월별 매출</a></li>
                    			<li><a href="<c:url value="/admin/sales/fame"/>">인기순</a></li>
                  			</ul>
                		</li>
						<li>
							<a href="<c:url value="/manageController/memberManage"/>">회원 관리</a>
						</li>
						<li>
							<a href="<c:url value="/manageController/communityManage"/>">Community 관리</a>
						</li>
						<li>
							<a href="<c:url value="/manageController/qnaManage"/>">Q&A 관리</a>
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
						<!-- page Content 내용 영역 -->
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
	<script type="text/javascript" src="<c:url value="/resources/js/"/>adminShopItem.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/"/>adminQna.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
	
</body>
<script type="text/javascript">
$(function(){
	
	/* 테이블 페이징 */
	/* Data Table */
		$(document).ready(function(){
		    $('#productManageTable').DataTable();
		    $('#producerManageTable').DataTable();
		});
	
	/* 생산자 정보 관리 */
	/* 해당 생산자의 정보 삭제 */
	$("span[name=deleteButton]").click(function() {
		var producerNo = $(this).attr("value");
		
		$.ajax({
			url : "<c:url value='/manageController/producerDeleteManage'/>",
			type : "post",
			data : "no=" + producerNo,
			dataType : "text",
			success : function(result) {
				if(result>=1) {
					alert(producerNo + ' 번 생산자 정보 삭제 완료');
					location.href = "<c:url value='/manageController/producerManage'/>"
				}
			},
			error : function(err) {
				alert("해당 회원정보 삭제 실패");
			}
		})
	})
	/* 해당회원의 정보 수정 */
	$("span[name=modifyButton]").click(function() {
		var producerNo = $(this).attr("value");
		
		$.ajax({
			url : "<c:url value='/manageController/producerModifyShowManage'/>",
			type : "post",
			data : "no=" + producerNo,
			dataType : "json",
			success : function(result) {
				$("input[name=no]").val(result.no);
				$("input[name=name]").val(result.name);
				$("input[name=addr]").val(result.addr);
				$("input[name=phone]").val(result.phone);
				$("input[name=profile]").val(result.profile);
			},
			error : function(err) {
				alert("err : " + err);
			}
		})
	})
	/* *************************************************************************** */
	
	/* 상품 정보 관리 */
	/* 해당 상품 등록 */
	$("span[name=deleteButtonProduct]").click(function() {
		var productNo = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/productDeleteManage'/>",
			type : "post",
			data : "no=" + productNo,
			dataType : "text",
			success : function(result) {
				if(result >= 1) {
					alert(productNo + ' 번 상품 정보 삭제 완료');
					location.href = "<c:url value='/manageController/productManage'/>"
				}
			},
			error : function(err) {
				alert("해당 상품정보 삭제 실패");
			}
		})
	})
	
	/* 해당 상품 수정 */
	$("span[name=modifyButtonProduct]").click(function() {
		var productNo = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/productModifyShowManage'/>",
			type : "post",
			data : "no=" + productNo,
			dataType : "json",
			success : function(result) {
				$("input[name=no]").val(result.no);
				$("input[name=name]").val(result.name);
				$("input[name=price]").val(result.price);
				$("input[name=unit]").val(result.unit);
				$("select[name=subCategoryNo]").val(result.subCategoryNo);
				$("input[name=producerNo]").val(result.producerNo);
				$("input[name=profile]").val(result.profile);
				$("input[name=desc]").val(result.desc);
				$("input[name=eval]").val(result.eval);
			},
			error : function(err) {
				alert("err : " + err);
			}
		})
	})
	
	/* *************************************************************************** */
	
	/* 회원 정보 관리 */
	/* 회원 정보 삭제 */
	$("span[name=deleteButtonMember]").click(function() {
		var memberEmail = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/memberDeleteManage'/>",
			type : "post",
			data : "email=" + memberEmail,
			dataType : "text",
			success : function(result) {
				if(result >= 1) {
					alert(memberEmail + ' 번 회원 정보 삭제 완료');
					location.href = "<c:url value='/manageController/memberManage'/>";
				}
			},
			error : function(err) {
				alert("해당 회원정보 삭제 실패");
			}
		})
	})
	
	/* *************************************************************************** */
	
	/* 기부 업체 관리 */
	/* 기부 업체 등록 및 수정 */
	$("input[name=modifyButtonDonationOrg]").click(function() {
		$.ajax({
			url : "<c:url value='/manageController/donationOrgModifyShowManage'/>",
			type : "post",
			dataType : "json",
			success : function(result) {
				$("input[name=name]").val(result.name);
				$("input[name=profile]").val(result.profile);
				$("input[name=desc]").val(result.desc);
				$("input[name=addr]").val(result.addr);
				$("input[name=phone]").val(result.phone);
			},
			error : function(err) {
				alert("err : " + err);
			}
		})
	})

	/* *************************************************************************** */
	
	/* 커뮤니티 관리 */
	/* 커뮤니티 삭제 */
	$("span[name=deleteButtonCommunity]").click(function() {
		var communityNo = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/communityDeleteManage'/>",
			type : "post",
			data : "no=" + communityNo,
			dataType : "text",
			success : function(result) {
				if(result >= 1) {
					alert(communityNo + ' 번 커뮤니티 정보 삭제 완료');
					location.href = "<c:url value='/manageController/communityManage'/>";
				}
			},
			error : function(err) {
				alert("해당 커뮤니티 삭제 실패");
			}
		})
	})
	
	/* 커뮤니티 수정 */
	$("span[name=modifyButtonCommunity]").click(function() {
		var communityNo = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/communityModifyShowManage'/>",
			type : "post",
			data : "no=" + communityNo,
			dataType : "json",
			success : function(result) {
				alert(result.desc);
				$("input[name=no]").val(result.no);
				$("input[name=name]").val(result.name);
				$("input[name=producerNo]").val(result.producerDTO.no);
				$("input[name=profile]").val(result.profile);
				$("input[name=desc]").val(result.desc);
				$("input[name=state]").val(result.state);
			},
			error : function(err) {
				alert("err : " + err);
			}
		})
	})
	
	/* *************************************************************************** */
	
    
}) 
</script>
</html>