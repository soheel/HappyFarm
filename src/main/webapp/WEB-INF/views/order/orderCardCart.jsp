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
	<div class="commerce single-product noo-shop-main">
		<div class="container">
			<div class="row">
				<form action = "<c:url value = '/userProductController/payCart'/>" method = "post" onSubmit='return orderCheck()'>
				
				<c:forEach items="${productList}" var="product" varStatus="status">
					<!-- 상품 하나하나 -->
						<div class="col-md-12 order_check_border box_shadow">
							<div class="col-md-2">
								<img src="<c:url value = '/resources/img/product/'/>${product.profile}">
							</div>
							<div class="col-md-10 order_check_content">
								<p>
									<span class="order_check_title">&lt;주문상품 확인&gt;</span>
								</p>
								<p>
								<input name = "list[${status.index}].productNo" type = "hidden" value="${product.no}">
									상품 이름 :<span class="order_check_name"> ${product.name}</span>
								</p>
								<p>
								<input name = "list[${status.index}].productNum" type = "hidden" value="${numList[status.index]}">
									수량 : <span class="order_check_count"> ${numList[status.index]}</span>
								</p>
								<p>
								<!-- PurchaseDTO의 price -->
									총 금액 : <span class="order_check_total">${product.price * numList[status.index]} (배송비 2500원이 포함된 금액입니다.)</span>
								</p>
							</div>
						</div>
				</c:forEach>
				

					<div class="col-md-12 addr_check_border box_shadow">
						<p>
							<span class="addr_check_title">&lt;배송지 정보 입력&gt;</span>
						</p>
						<p>
						<!-- PurchaseOrderDTO의 name -->
							수취인 : <span class="addr_check_name" id = "addressee"> <input type="text"
								name="name">
							</span>
						</p>
						<p>
						<!-- PurchaseOrderDTO의 postcode -->
							주소 : <span class="addr_check_addr"> 
							<input name = "postCode" type="text" id="sample6_postcode" placeholder="우편번호">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<p>
							<!-- PurchaseOrderDTO의 addr -->
							&nbsp;&nbsp;&nbsp;<input name = "addr" size = "50" type="text" id="sample6_address" placeholder="주소">
							<!-- PurchaseOrderDTO의 detailAddr -->
							<input name = "detailAddr" type="text" size = "30" id="sample6_address2" placeholder="상세주소">
							</p>
							</span>
						</p>
						<p>
						<!-- PurchaseOrderDTO의 phone -->
							연락처 : <span class="addr_check_phone"> 
							<select name = "phone">
							<option>010</option><option>011</option><option>016</option>
							<option>017</option><option>018</option><option>019</option>
							</select> - <input size = "5" type="text" name="phone" id = "phone1">
								- <input size = "5" type="text" name="phone" id = "phone2">
							</span>
						</p>
						<p>
							배송시 요구사항 : <span class="addr_check_content"> 
							<input size = "80" type="text" name="content">
							</span>
						</p>
					</div>

					<div class="col-md-12 payment_check_border box_shadow">
						<p>
							<span class="payment_title">&lt;결제 정보 입력&gt;</span>
						</p>
						<p>
						<!-- PurchaseDTO의 method -->
							결제방식선택 : <span class="payment_count">
							 <select name = "method">
									<option value="card">카드</option>
									<option value="trans">실시간계좌이체</option>
									<option value="vbank">무통장입금</option>
									<option value="phone">휴대폰</option>
							</select>
							</span>
						</p>
					</div>
					
					<div class="col-md-12 payment_check_border box_shadow">
						<p>
							<span class="payment_title">&lt;기부포인트&gt;</span>
						</p>
						<p>
							<input type = "hidden" value = "${mileage}" id = "hiddenMileage"/>
							보유 기부포인트 : <span><fmt:formatNumber value="${mileage}" pattern="#,###"/></span><br>
							<!-- PurchaseDTO의 discount -->
							기부포인트 사용 : <input id = "useMileage" name="discount" type = "number" value = "0" size = "8"><span class = "mileage_desc">(1000원 이상부터 사용이 가능합니다.)</span><br>
							<span class = "mileage_desc">[결제 금액의 20% 까지만 기부포인트로 결제 가능합니다.]</span>
						</p>
					</div>

					<div class="col-md-12">
						<div class="col-md-6 mileage_check_border order_final_info">
						<h3>총 금액의 5%인<br> <span class="amount"></span><fmt:formatNumber value="${totalPrice * 0.05 }" pattern="#,###"/> 원이 기부됩니다</h3>
						</div>
						<div class="col-md-6 final_check_border box_shadow order_final_info">
							<p>
								<input type = "hidden" id = "totalPrice" name = "price" value = "${totalPrice}">
								최종 결제 금액 <h3><span id = "amount" class="amount"><fmt:formatNumber value="${totalPrice }" pattern="#,###" /> 원</span></h3>
							</p>
							<input type="submit" value="결제"> 
							<input type="button" value="취소" name="cancle">
						</div>
					</div>
				</form>
			</div>