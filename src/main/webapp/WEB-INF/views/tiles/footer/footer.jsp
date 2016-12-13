<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<body>
	<footer class="wrap-footer footer-2 colophon wigetized">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-6 item-footer-four">
							<div class="widget widget_about"> 
								<div class="noo_about_widget">
									<a href="#">
										<img src='<c:url value="/resources/images/"/>logo.png' alt="" />
									</a>
									<p>
										Maecenas tristique gravida, odio et sagi ttis justo. Suspendisse ultricies nisi veafn. onec dictum non nulla ut lobortis tellus. 
									</p>
								</div>
							</div>
							<div class="widget widget_noo_social"> 
								<div class="noo_social">
									<div class="social-all">
										<a href="#" class="fa fa-facebook"></a>
										<a href="#" class="fa fa-google-plus"></a>
										<a href="#" class="fa fa-twitter"></a>
										<a href="#" class="fa fa-youtube"></a>
										<a href="#" class="fa fa-skype"></a>
									</div>
								</div>
							</div>
							<div class="widget widget_text">
								<div class="textwidget">
									<div class="copyright">
										2015 Oganici.<br/>
										Designed with <i class="fa fa-heart-o"></i> by TK-Themes.
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 item-footer-four">
							<div class="widget widget_text">
								<h4 class="widget-title">Contact</h4> 
								<div class="textwidget">
									<h5>Address</h5>
									<p>No 13, Sky Tower Street, New York, USA</p>
									<h5>Hotline</h5>
									<p>
										<a href="#">(+844) 123 456 78</a><br/>
										<a href="#">(+844) 888 97989</a>
									</p>
									<h5>Email</h5>
									<p>
										<a href="mailto:contact@organicistore.com">
											contact@organicistore.com
										</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-sm-6 item-footer-four">
							<div class="widget widget_noo_openhours">
								<h4 class="widget-title">Donate</h4> 
							</div>
							<div class="widget widget_noo_happyhours">
								<h4 class="widget-title">Happy Hours</h4> 
								<ul class="noo-happyhours">
									<li>

										<div>
											이전달의 총 기부액 : 
											<p><fmt:formatNumber value="${sessionScope.donationPrice }" groupingUsed="true"/>&nbsp;<i style="font-size:15px" class="fa">원</i></p>										 
										</div>
										
										<div>
											<a href="<c:url value="/userEtcController/donationLoading"/>"><p>Show More</p></a>
										</div>
									</li>
								</ul>
								<span></span>
								<span></span>
								<span></span>
								<span></span>
							</div>
						</div>
					</div>
				</div>
			</footer>
		</div>
	<a href="#" class="go-to-top hidden-print"><i class="fa fa-angle-up"></i></a>
	
	
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.min.js'></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
	
	<script type="text/javascript">
			
			$(function() {
				$("#test").mouseover(function() {
					$.ajax({
						url : "<c:url value='/userProductController/shopMenuLoading'/>",
						type : "post",
						dataType : "json",
						success : function(result) {
							if(result.length == 6) { // 로그인 하지 않았거나 최근 구매한 상품이 없는 회원의 경우
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
								for(var i = 0 ; i < 3; i++){ // 로그인을 한 상태에서 최근 구매한 상품이 있는 경우
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
				
				/* 장바구니 추가 */
				$(document).on("click", "#addToCart",function() {
					$.ajax({
						url : "<c:url value='/userProductController/addCart'/>",
						type : "post",
						data : "productNo=" + $("#product_no").val() + "&num=" + $("#product_num").val(),
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
				
				/* 장바구니추가(direct) */
				$(document).on("click", "#addToCartDirect",function() {
					$.ajax({
						url : "<c:url value='/userProductController/addCartDirect'/>",
						type : "post",
						data : "productNo=" + $("#product_no").val(),
						dataType : "text",
						success : function(result) {
							if(result >= 1) {
								alert("해당상품이 장바구니에 추가되었습니다.");
							}else {
								alert("해당상품이 이미 장바구니에 존재합니다.");
							}
						},
						error : function(err) {
							alert("해당상품이 이미 장바구니에 존재합니다!");
						}
					})
				})
				
				
				
			})
			
			/* 우편번호 검색 */
				function sample6_execDaumPostcode() {
			        new daum.Postcode({
			            oncomplete: function(data) {
			                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
			                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			                var fullAddr = ''; // 최종 주소 변수
			                var extraAddr = ''; // 조합형 주소 변수

			                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
			                    fullAddr = data.roadAddress;

			                } else { // 사용자가 지번 주소를 선택했을 경우(J)
			                    fullAddr = data.jibunAddress;
			                }

			                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
			                if(data.userSelectedType === 'R'){
			                    //법정동명이 있을 경우 추가한다.
			                    if(data.bname !== ''){
			                        extraAddr += data.bname;
			                    }
			                    // 건물명이 있을 경우 추가한다.
			                    if(data.buildingName !== ''){
			                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                    }
			                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
			                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
			                }

			                // 우편번호와 주소 정보를 해당 필드에 넣는다.
			                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
			                document.getElementById('sample6_address').value = fullAddr;

			                // 커서를 상세주소 필드로 이동한다.
			                document.getElementById('sample6_address2').focus();
			            }
			        }).open();
			    }
			</script>
</body>
</html>