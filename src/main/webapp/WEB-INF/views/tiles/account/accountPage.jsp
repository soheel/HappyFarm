<%@ page language="java" contentType="text/html;charset=utf-8" %>
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
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>Airways.css" type="text/css" media="all"/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>style.css' type='text/css' media='all'/>
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>magnific-popup.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>myAccount.css' type='text/css' media='all' />
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
							<a href="<c:url value="/userInfoController/myPageLoading"/>">
								My Account
							</a>
						</li>
						<li class="dropdown">
							<a href="<c:url value="/account/shopping"/>" class="dropdown-toggle" data-toggle="dropdown">쇼핑내역<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-header">원하시는 메뉴를 선택해주세요.</li>
								<li><a href="<c:url value="/userInfoController/myPageOrderList"/>"> 주문 / 배송  </a></li>
								<li><a href="<c:url value="/userInfoController/myPageCancelList"/>"> 반품 / 교환 </a></li>
								<li><a href='<c:url value="/userInfoController/myPageRefundList"/>'> 환불 </a></li>
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
						<li>
							<a href="<c:url value="/userInfoController/myPageMileage"/>">MyPoint</a>
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
					<form class="find-profile order" method="post">	
						<input type="radio" name="type" value="refund" class="refundBtn">환불 신청 
						<input type="radio" name="type" value="return" class="refundBtn">반품 신청 
						<input type="radio" name="type" value="change" class="refundBtn">교환 신청 
						<br>
						<label for="find_id">
						사유
							<span class="required">*</span>
						</label>
						<input type="text" class="input-text" name="desc" id="order_board" value=""/>
						<br>
									
						<label for="find_pw">
						비밀번호 확인 
						<span class="required">*</span>
						</label>
						<input type="password" class="input-text" name="pwd" id="order_pw" value=""/>
						
						<br>	
						<input type="submit" class="button" name="select" value="확인" id="requsetChange"/>
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
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
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
		
		/* Data Table */
		$(document).ready(function(){
		    $('#myOrderTable').DataTable();
		});
		
		 $(document).on("click","#searchOrderListCancer", function(){
			 var no = $(this).attr("value");
			 //alert(str);
		 	 $.ajax({
		         url:"requestCancelButton",
		           type:"post",
		           dataType:"text",
		           data:"no="+no,
		           success:(function(result){
		        	   if(result==1){
							alert("목록에서 주문이 삭제되었습니다.");
							location.href="<c:url value='/userInfoController/searchOrderList'/>";
						}else{
							alert("삭제되지 않았습니다. 다시 시도해주시기 바랍니다.");
						}
		           }),
		           error: function(err){
		              alert("err :" + err)
		           } 
		      
		      	})  
		   	})
		   	
		   	
		   	
		   	$(document).on("click","#refundCheckBtn", function(){
		   		var no = $(this).attr("value");
		   		//alert(no);
		   		$("#requsetChange").click(function(){
				   		 var state = $(".refundBtn:checked").val();
				   		//alert(state); 
				   		//no+=$(".refundBtn:checked").val()+"/";
				   var desc = $("#order_board").val();
				  // no+= $("#order_board").val() +"/";
				   var pwd = $("#order_pw").val();
		   		//alert(no)
		   		//alert(no);
		   	   $.ajax({
		         url:"requestRefund",
		           type:"post",
		           dataType:"text",
		           data:"no="+no+"&state="+state+"&desc="+desc+"&pwd="+pwd,
		           success:(function(result){
		        	   if(result==1){
							//alert("성공");
							location.href="<c:url value='/userInfoController/myPageOrderList'/>";
						}else{
							//alert("실패");
						}
		           })
		  			})
		   		}) 
		   	});
		 	
		 $(document).on("click","#showAnswerByNumber", function(){
			 
			 var number = $(".my_info_qna_table tr").index($(this).parent().parent())+1;
			var no = $(this).attr("value");
			//alert(no);
			var q = $(this).parent().text();
			//alert(q);
			var $tr = $(this).next('tr');
			
			$.ajax({
		         url:"showAnswerByNo",
		           type:"post",
		           dataType:"text",
		           data:"no="+no,
		           success:(function(result){
		        		   //alert(result);
							var s = "<td colspan='3'>"+result+"</td>";
							var t = "<td colspan='3'>답글이 등록되지 않았습니다.</td>"
							
							if(q=='Y'){ 
								$(".my_info_qna_table tbody tr:nth-child("+number+")").children().remove();
								$(".my_info_qna_table tbody tr:nth-child("+number+")").append(s);
						 	}else{
								$(".my_info_qna_table tbody tr:nth-child("+number+")").children().remove();
						 		$(".my_info_qna_table tbody tr:nth-child("+number+")").append(t);
							} 
		           		})
		  			}) 
		  		if($(".my_info_qna_table tbody tr:nth-child("+number+")").is(":hidden")){
		  			$(".my_info_qna_table tbody tr:nth-child("+number+")").slideDown();
		  		}else{
		  			
		  			$(".my_info_qna_table tbody tr:nth-child("+number+")").slideUp();
		  		}	
		  			
				 })
				 
		 });
</script>
</body>
</html>