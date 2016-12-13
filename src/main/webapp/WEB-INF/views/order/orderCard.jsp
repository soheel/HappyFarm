<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="noo-page-heading eff heading-6">
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
				<form>
					<div class="col-md-12 order_check_border">
						<div class="col-md-4">
							<img src="http://lorempixel.com/400/200/">
						</div>
						<div class="col-md-8 order_check_content">
							<p>
								<span class="order_check_title">&lt;주문상품 확인&gt;</span>
							</p>
							<p>
								상품 이름 :<span class="order_check_name"></span>
							</p>
							<p>
								수량 : <span class="order_check_count"></span>
							</p>
							<p>
								배송비 : <span class="order_check_price"></span>
							</p>
							<p>
								총 금액 : <span class="order_check_total"></span>
							</p>
						</div>
					</div>

					<div class="col-md-12 seller_check_border">
						<p>
							<span class="seller_check_title">&lt;판매자 정보&gt;</span>
						</p>
						<p>
							이름 : <span class="seller_check_name"></span>
						</p>
						<p>
							주소 : <span class="seller_check_addr"></span>
						</p>
						<p>
							연락처 : <span class="seller_check_phone"></span>
						</p>
					</div>

					<div class="col-md-12 addr_check_border">
						<p>
							<span class="addr_check_title">&lt;배송지 정보 입력&gt;</span>
						</p>
						<p>
							수취인 : <span class="addr_check_name"> <input type="text"
								name="name">
							</span>
						</p>
						<p>
							주소 : <span class="addr_check_addr"> <input type="text"
								name="addr"> - <input type="text" name="addr">
							</span>
						</p>
						<p>
							연락처 : <span class="addr_check_phone"> <input type="text"
								name="phone"> - <input type="text" name="phone">
								- <input type="text" name="phone">
							</span>
						</p>
						<p>
							배송시 요구사항 : <span class="addr_check_content"> <input
								type="text" name="content">
							</span>
						</p>
					</div>

					<div class="col-md-12 payment_check_border">
						<p>
							<span class="payment_title">&lt;결제 정보 입력&gt;</span>
						</p>
						<p>
							<span class="payment_name">신용카드</span>
						</p>
						<p>
							카드 선택 : <span class="payment_count"> <select>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
							</select>
							</span>
						</p>
						<p>
							할부방식 : <span class="payment_count"> <select>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
									<option value="asd">asd</option>
							</select>
							</span>
						</p>
					</div>

					<div class="col-md-12">
						<div class="col-md-6 mileage_check_border">
							총 금액의 5%인<br> <span class="amount"></span>원이 기부됩니다
						</div>

						<div class="col-md-6 final_check_border">
							<p>
								최종 결제 금액 : <span class="amount"></span>원
							</p>
							<input type="submit" value="결제"> <input type="button"
								value="취소" name="cancle">
						</div>
					</div>
				</form>
			</div>