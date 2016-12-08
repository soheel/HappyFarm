<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">Community Page</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>Community</span>
					</div>
				</div>
			</div>
	</section>
	<div class="main">
		<div class="commerce commerce-page commerce-cart noo-shop-main">
			<div class="container">
				<div class="row">
					<div class="noo-main col-md-12">
						<table class="shop_table cart">
							<thead>
								<tr>
									<th class="product-check">
										<div class="checks etrans">
  											<input type="checkbox" id="checkAll">
  											<label for="checkAll"></label> 
  										</div>
									</th>
									<th class="product-thumbnail">Image</th>
									<th class="product-price">Price</th>
									<th class="product-quantity">Quantity</th>
									<th class="product-subtotal">Total</th>
									<th class="product-remove">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<tr class="cart_item">
									<td class="product-check">
										<div class="checks etrans">
  											<input type="checkbox" id="ex_chk1">
  											<label for="ex_chk1"></label> 
  										</div>
									</td>
									<td class="product-thumbnail">
										<a href="shop-detail.html">
											<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" />
										</a>
										<a href="shop-detail.html">Apples </a> 
									</td>
									<td class="product-price">
										<span class="amount">&#36;3.95</span> 
									</td>
									<td class="product-quantity">
										<div class="quantity">
											<input type="number" step="1" min="0" name="qty" value="1" class="input-text qty text" size="4"/>
										</div>
									</td>
									<td class="product-subtotal">
										<span class="amount">&#36;3.95</span> 
									</td>
									<td class="product-remove">
										<a href="#" class="remove">&times;</a> 
									</td>
								</tr>
								<tr class="cart_item">
									<td class="product-check">
										<div class="checks etrans">
  											<input type="checkbox" id="ex_chk2">
  											<label for="ex_chk2"></label> 
  										</div>
									</td>
									<td class="product-thumbnail">
										<a href="shop-detail.html">
											<img width="100" height="100" src="<c:url value="/resources/images/"/>product/product_100x100.jpg" alt="" />
										</a>
										<a href="shop-detail.html">Brown Bread </a> 
									</td>
									<td class="product-price">
										<span class="amount">&#36;1.05</span> 
									</td>
									<td class="product-quantity">
										<div class="quantity">
											<input type="number" step="1" min="0" name="qty" value="2" class="input-text qty text" size="4"/>
										</div>
									</td>
									<td class="product-subtotal">
										<span class="amount">&#36;1.05</span> 
									</td>
									<td class="product-remove">
										<a href="#" class="remove">&times;</a> 
									</td>
								</tr>
								<tr>
									<td colspan="6" class="actions">
										<div class="cart-action">
											<p>
												<label>총 금액 : <span><fmt:formatNumber value="1234567"/></span></label>
											</p>
											<input type="submit" class="button" name="update_cart" value="선택상품주문"/>
											<input type="submit" class="button" name="update_cart" value="전체상품주문"/>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>