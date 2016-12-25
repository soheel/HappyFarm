<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<section class="noo-page-heading eff">
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
	<div class="commerce single-product">
		<div class="container">
			<div class="row commerce">
				<form action = "<c:url value = '/userProductController/pay'/>" method = "post" onSubmit='return orderCheck()' class="login">
				<!-- 상품 하나하나 -->
					<div class="col-md-12 order_check_border order_content form-row">
						<div class="order_title">
							<p>
								<span class="order_check_title">&lt;주문상품 확인&gt;</span>
							</p>
						</div>
						<div class="col-md-3">
							<img src="<c:url value = '/resources/img/product/'/>${product.profile}">
						</div>
						<div class="col-md-9 order_check_content">
							<p>
								<input name = "productNo" type = "hidden" value="${product.no}">
								<label>
									상품 이름
									<span class="required">:</span>
								</label>
								<input type="text" class="input-text" value="${product.name}" readonly="readonly"/>
							</p>
							
							<p>
							<input name="productNum" type="hidden" value="${quantity}">
								<label>
									수량 
									<span class="required">:</span>
								</label>
								<input type="text" class="input-text" value="${quantity}" readonly="readonly"/>
							</p>
							<p>
							<!-- PurchaseDTO의 price -->
							<input type = "hidden" id = "totalPrice" name = "price" value = "${totalPrice}">
								<label>
									총 금액(배송비 2500원이 포함된 금액입니다.)
									<span class="required">:</span>
								</label> 
								<input type="text" class="input-text" value="${totalPrice}" readonly="readonly"/>
							</p>
						</div>
					</div>

					<div class="col-md-12 seller_check_border order_content form-row">
						<div class="order_title">
							<p>
								<span  class="seller_check_title">&lt;판매자 정보&gt;</span>
							</p>
						</div>
						<p>
							<label>
								이름
								<span class="required">:</span>
							</label> 
							<input type="text" class="input-text" value="${producer.name}" readonly="readonly"/>
						</p>
						<p>
							<label>
								주소
								<span class="required">:</span>
							</label> 
							<input type="text" class="input-text" value="${producer.addr}" readonly="readonly"/>
						</p>
						<p>
							<label>
								연락처
								<span class="required">:</span>
							</label> 
							<input type="text" class="input-text" value="${producer.phone}" readonly="readonly"/>
						</p>
					</div>

					<div class="col-md-12 addr_check_border order_content form-row">
						<div class="order_title">
							<p>
								<span class="addr_check_title">&lt;배송지 정보 입력&gt;</span>
							</p>
						</div>
						<p>
						<!-- PurchaseOrderDTO의 name -->
							<label>
								수취인
								<span class="required">:</span>
							</label> 
							<label class="addr_check_name"> 
								<input id = "addressee" class="input-text" type="text" name="name">
							</label>
						</p>
						<p>
						<!-- PurchaseOrderDTO의 postcode -->
							<label>
								주소
								<span class="required">:</span>
							</label>
							<label class="addr_check_addr"> 
								<input name = "postCode" type="text" id="sample6_postcode" class="input-text" placeholder="우편번호">
								<input type="button" onclick="sample6_execDaumPostcode()" class="button" value="우편번호 찾기"><br>
								<p>
									<!-- PurchaseOrderDTO의 addr -->
									<input name = "addr" size = "50" type="text" id="sample6_address" class="input-text" placeholder="주소" style="width:40%">
									<!-- PurchaseOrderDTO의 detailAddr -->
									<input name = "detailAddr" type="text" size = "30" id="sample6_address2" class="input-text" placeholder="상세주소" style="width:30%">
								</p>
							</label>
						</p>
						<p>
						<!-- PurchaseOrderDTO의 phone -->
							<label>
								연락처
								<span class="required">:</span>
							</label>
							<span class="addr_check_phone"> 
								<select name = "phone">
									<option>010</option><option>011</option><option>016</option>
									<option>017</option><option>018</option><option>019</option>
								</select> - <input size = "5" type="text" name="phone" id = "phone1">
								- <input size = "5" type="text" name="phone" id = "phone2">
							</span>
						</p>
						<p>
							<label>
								배송시 요구사항
								<span class="required">:</span>
							</label> 
							<label class="addr_check_content"> 
								<input class="input-text" size = "80" type="text" name="content">
							</label>
						</p>
					</div>

					<div class="col-md-12 payment_check_border order_content form-row">
						<div class="order_title">
							<p>
								<span class="payment_title">&lt;결제 정보 입력&gt;</span>
							</p>
						</div>
						<p>
						<!-- PurchaseDTO의 method -->
							<label>
								결제방식선택
								<span class="required">:</span>
							</label>
							<label class="payment_count">
								 <select name = "method">
										<option value="card">카드</option>
										<option value="trans">실시간계좌이체</option>
										<option value="vbank">무통장입금</option>
										<option value="phone">휴대폰</option>
								</select>
							</label>
						</p>
					</div>
					
					<div class="col-md-12 payment_check_border order_content form-row">
						<div class="order_title">
							<p>
								<span class="payment_title">&lt;기부포인트&gt;</span>
							</p>
						</div>
						<p>
							<input type = "hidden" value = "${mileage}" id = "hiddenMileage"/>
							보유 기부포인트 : <label class = "my_mileage"><fmt:formatNumber value="${mileage}" pattern="#,###"/></label><br>
							
							<!-- PurchaseDTO의 discount -->
							기부포인트 사용 : <input id = "useMileage" name="discount" type ="number" value = "0" size = "8"><span class = "mileage_desc">(1000원 이상부터 사용이 가능합니다.)</span><br>
							<span class = "mileage_desc">[결제 금액의 20% 까지만 기부포인트로 결제 가능합니다.]</span>
						</p>
					</div>

					<div class="col-md-12 form-row order_final">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="final_check_border order_final_info">
								<p>
									<span class="payment_title">최종 결제 금액</span> 
									<h3>
										<label id="amount" class="amount" value='${totalPrice}'><fmt:formatNumber value="${totalPrice}" pattern="#,###" /> 원</label>
									</h3>
								</p>
								<input type="submit" value="결제" class="btn"> 
								<input type="button" value="취소" name="cancle" class="btn">
							</div>
							
							<div class="mileage_check_border order_final_info">
								<h3>총 금액의 5%인  
									<span id="donate">
										<fmt:formatNumber value="${totalPrice * 0.05 }" pattern="#,###"/>
									</span> 원이 기부됩니다
								</h3>
							</div>
						</div>
						<div class="col-md-3"></div>
					</div>
				</form>
			</div>