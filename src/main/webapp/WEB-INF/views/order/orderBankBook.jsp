<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<form>
					<div class="col-md-12 order_check_border order_check_content">
							<p>
								<span class="order_check_title">&lt;입금 정보&gt;</span>
							</p>
							<p>
								계좌 번호 : <span class="order_check_bank">우리은행</span> - <span class="order_check_no">12-3123-123-123</span>
							</p>
							<p>
								예금주 : <span class="order_check_name"></span>
							</p>
					</div>

					<div class="col-md-12 payment_check_border">
						<p>
							<span class="payment_check_title">&lt;결제 정보&gt;</span>
						</p>
						<p>
							이름 : <span class="payment_check_name"></span> 
							가격 : <span class="payment_check_price"></span>
							개수 : <span class="payment_check_count"></span>
						</p>
					</div>

					<div class="col-md-12 addr_check_border">
						<p>
							<span class="addr_check_title">&lt;배송지 정보 확인&gt;</span>
						</p>
						<p>
							수취인 : <span class="addr_check_name"></span>
						</p>
						<p>
							주소 : <span class="addr_check_addr">	</span>
						</p>
						<p>
							연락처 : <span class="addr_check_phone"></span>
						</p>
						<p>
							배송시 요구사항 : <span class="addr_check_content"></span>
						</p>
					</div>

					<div class="col-md-12">
						<input type="submit" value="주문확인">	
					</div>
				</form>
			</div>