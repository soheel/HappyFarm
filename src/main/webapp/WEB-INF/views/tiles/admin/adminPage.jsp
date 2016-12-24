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
	<link rel="stylesheet" href="<c:url value="/resources/css/"/>Airways.css" type="text/css" media="all"/>
	<link rel='stylesheet' href='<c:url value="/resources/css/"/>style.css' type='text/css' media='all'/>
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>magnific-popup.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>myAccount.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminPage.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminShopItem.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminCommunity.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>adminQna.css' type='text/css' media='all' />
	<link rel="stylesheet" href='<c:url value="/resources/css/"/>dialogCenter.css' type='text/css' media='all' />
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
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
							<a href='<c:url value="/userInfoController/adminPage"/>'>
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
						<li>
							<a href="<c:url value="/manageController/orderManage"/>">주문 관리</a>
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
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type='text/javascript' src='<c:url value="/resources/js/smoothscroll-for-websites-master/"/>SmoothScroll.js'></script>
</body>
<script type="text/javascript">
$(function(){
	
	 $("#adminType").change(function(){
	        var textAreaContent = $("#adminMessage").val();  //VALUE OF TEXTAREA
	        var selectBoxVal = $(this).val();    //VALUE OF SELECT BOX
	       $("#adminMessage").val(selectBoxVal);   //ADD THE VALUE INSIDE TEXTAREA
	    });

	 
	 
	/* 테이블 페이징 */
	/* Data Table */
		$(document).ready(function(){
		    $('#productManageTable').DataTable();
		    $('#producerManageTable').DataTable();
		    $('#payCompleteListTable').DataTable();
		    $('#orderCompleteListTable').DataTable();
		    $('#etcAskListTable').DataTable();
		    $('#etcCompleteListTable').DataTable();
		});
	
	/* accordion */
	$( "#accordion" ).accordion({
      collapsible: true,
      heightStyle: "content"
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
	
	/** 해당 회원에게 메시지 보내기*/
	$("span[name=sendButton]").click(function() {
		var producerNo = $(this).attr("value");
		
		$.ajax({
			url : "<c:url value='/manageController/producerModifyShowManage'/>",
			type : "post",
			data : "no=" + producerNo,
			dataType : "json",
			success : function(result) {
				$("input[name=name]").val(result.name);
				$("input[name=phone]").val(result.phone);
			},
			error : function(err) {
				alert("err : " + err);
			}
		})
	})
	
	/* *************************************************************************** */
	
	/* 상품 정보 관리 */
	/* 해당 상품 삭제 */
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
	
	/* 패키지 상품 관리 */
	
	/* 등록 폼 초기화 */
	$("input[name=insert]").click(function() {
		$("input[name=name]").val("");
		$("input[name=price]").val("");
	})
	
	/* 패키지 상품 등록시 개별 상품 검색 */
    $("input[name=productSearch]").click(function() {
    	var productName = $("input[name=search]").val();
    	
    	$.ajax({
    		url : "<c:url value='/manageController/packageSearchProduct'/>",
			type : "post",
			data : "name=" + productName,
			dataType : "json",
			success : function(result) {
				var content = "";
				$.each(result, function(index, item) {
					content += "<span style='cursor:pointer' class = 'test' value='" + item.no + "'>" + item.name + " (상품번호 : " + item.no + ")</span><br>";
				})
				$("#searchResult").html(content);
			},
			error : function(err) {
				alert("err : " + err);
			}
    	})
    })
    
    /* 패키지 상품 수정시 개별 상품 검색 */
    $("input[name=productSearch2]").click(function() {
    	var productName = $("input[name=search2]").val();
    	
    	$.ajax({
    		url : "<c:url value='/manageController/packageSearchProduct'/>",
			type : "post",
			data : "name=" + productName,
			dataType : "json",
			success : function(result) {
				var content = "";
				$.each(result, function(index, item) {
					content += "<span style='cursor:pointer' class = 'test2' value='" + item.no + "'>" + item.name + " (상품번호 : " + item.no + ")</span><br>";
				})
				$("#searchResult2").html(content);
			},
			error : function(err) {
				alert("err : " + err);
			}
    	})
    })
    
    /* 패키지 상품 삭제 */
    $("span[name=deleteButtonPackage]").click(function() {
		var packageNo = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/productDeleteManage'/>",
			type : "post",
			data : "no=" + packageNo,
			dataType : "text",
			success : function(result) {
				if(result >= 1) {
					alert(packageNo + ' 번 패키지 상품 정보 삭제 완료');
					location.href = "<c:url value='/manageController/packageManage'/>"
				}
			},
			error : function(err) {
				alert("해당 패키지 상품정보 삭제 실패");
			}
		})
	})
    
    /* 패키지 상품에 포함될 개별 상품들 선택 */
    var arr = new Array();
    $(document).on("click", ".test", function() {
    	var selectProduct = $(this).attr('value');
    	
    	if(arr.indexOf(parseInt(selectProduct)) != -1) {
    		alert("이미 등록하신 상품입니다.");
    	}else {
    		alert(selectProduct + '번 상품이 추가되었습니다.');
    		var content = "";
        	content += "<input class = 'selected' type = 'text' readonly name='products' value='" + selectProduct + "'/>";
        	$("#select_product").append(content);
        	arr[arr.length] = parseInt(selectProduct);
    	}
    })
    
    /* 패키지 상품에 포함될 개별 상품들 선택 (수정폼) */
    var arr2 = new Array();
    $(document).on("click", ".test2", function() {
    	var selectProduct = $(this).attr('value');
    	
    	if(arr2.indexOf(parseInt(selectProduct)) != -1) {
    		alert("이미 등록하신 상품입니다.");
    	}else {
    		alert(selectProduct + '번 상품이 추가되었습니다.');
    		var content = "";
        	content += "<input class = 'selected' type = 'text' readonly name='products' value='" + selectProduct + "'/>";
        	$("#select_product2").append(content);
        	arr2[arr2.length] = parstInt(selectProduct);
    	}
    })

     $("#certification_Info").change(function(){
    	   var selectCertiVal = $(this).val(); 
    	   $("#certificationNo").val(selectCertiVal)
    })
    
    /* 생산자 select누르면 값 넣어주기 */
    $("#producer_Info").change(function(){
    	   var selectProducerVal = $(this).val(); 
    	   $("#reg_producerNo").val(selectProducerVal)
    })
    
    /* 생산자 select누르면 값 넣어주기 */
    $("#producer_Info2").change(function(){
    	   var selectProducerVal2 = $(this).val(); 
    	   $("#reg_producerNo2").val(selectProducerVal2)
    })
    
    
    /* 해당 패키지 상품 수정 불러오기 */
    /* 커뮤니티 수정 */
	$("span[name=modifyButtonPackage]").click(function() {
		var productNo = $(this).attr("value");
		$.ajax({
			url : "<c:url value='/manageController/packageModifyShowManage'/>",
			type : "post",
			data : "no=" + productNo,
			dataType : "json",
			success : function(result) {
				$("input[name=no]").val(result.package.packageNo);
				$("input[name=name]").val(result.package.productDTO.name);
				$("input[name=price]").val(result.package.productDTO.price);
				$("input[name=profile]").val(result.package.productDTO.profile);
				$("input[name=desc]").val(result.package.productDTO.desc);
				var content = "";
				$.each(result.productList, function(index, item) {
					content += "<input class = 'selected' type = 'text' readonly name='products' value='" + item + "'/>";
					if(arr2.indexOf(item) == -1) {
						arr2[arr2.length] = parseInt(item);
					}
				})
	        	$("#select_product2").html(content);
			},
			error : function(err) {
				alert("err : " + err);
			}
		})
	})
	
	/* 패키지 상품 내의 개별 상품을 검색하여 추가했는데 다시 삭제하고 싶을 때*/
	$(document).on("click", ".selected", function() {
		$(this).remove();
	})
	
	/* *************************************************************************** */
	
	/* 주문관리 */
	/* 주문완료에서 결제완료로 상태 변경하기 */
	$("span[name=deposit_complete]").click(function() {
		var price = $(this).next().val();
		var email = $(this).next().next().val();
		var state = confirm("고객으로부터 입금이 확인되었다면 '확인'버튼을 클릭하세요");
		if(state) {
			$.ajax({
				url : "<c:url value = '/manageController/orderDepositModifyManage'/>",
				type : "post",
				data : "purchaseNo=" + $(this).attr("value"),
				dataType : "text",
				success : function(result) {
					if(result >= 1) {
						alert('해당 주문이 "결제완료" 상태로 변경되었습니다.');
						
					 /*
						마일리지 적립
					 */
					 $.ajax({
						url : "<c:url value = '/userProductController/saveMileage'/>",
						type : "post",
						data : "saveMileage=" + (price*0.05) + "&email=" + email
					 })
						
						location.href = "<c:url value = '/manageController/orderManage'/>"
					}else {
						alert("상태 변경에 실패하였습니다.");
					}
				},
				error : function(err) {
					alert("상태 변경에 실패하였습니다.");
				}
			})
		}else {
		}
		
	})
	
	/* 환불/반품/교환 신청상태에서 완료상태로 변경하기 */
	$("span[name=etc_complete]").click(function() {
		var state = confirm("해당 주문의 요청상태를 '신청' 에서 '완료'로 변경하시겠습니까?");
		if(state) {
			$.ajax({
				url : "<c:url value = '/manageController/orderEtcModifyManage'/>",
				type : "post",
				data : "purchaseNo=" + $(this).attr("value"),
				dataType : "text",
				success : function(result) {
					if(result >= 1) {
						alert('해당 주문의 요청상태를 "완료"로 변경하였습니다.');
						location.href = "<c:url value = '/manageController/orderManage'/>"
					}else {
						alert("상태 변경에 실패하였습니다.");
					}
				},
				error : function(err) {
					alert("상태 변경에 실패하였습니다.");
				}
			})
		}else {
		}
	})

	
	/* 엑셀 다운로드 */
	$("#download_excel").click(function() {
		location.href = "<c:url value = '/excel/exceldown'/>";
	})
}) 
</script>
</html>