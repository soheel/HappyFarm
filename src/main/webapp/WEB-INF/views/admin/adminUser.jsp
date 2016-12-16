<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
						<div class="container">
							<h3 class="widget-title">회원 관리</h3>
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
												<th class="product-id">아이디(Email)</th>
												<th class="product-name">이름</th>
												<th class="product-phone">연락처</th>
												<th class="product-date">가입일</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${memberlist}" var="member"> 
									
											<tr class="cart_item">
												<td class="product-check">
													<div class="checks etrans">
														<input type="checkbox" id="ex_chk1">
														<label for="ex_chk1"></label> 
													</div>
												</td>
												<td class="product-id">
													${member.email }
												</td>
												<td class="product-name">
													<span class="amount">${member.name}</span> 
												</td>
												<td class="product-phone">
													<span class="amount">${member.phone}</span> 
												</td>
												<td class="product-date">
													<span class="amount"><fmt:formatDate value="${member.registerDate}" pattern="yyyy-MM-dd"/></span> 
												</td>
											</tr>
											</c:forEach>
											
										</tbody>
									</table>
								</div>
							</div>

							<div class="adminShopItem-action-btn">
								<input type="button" value="삭제" name="delete">
							</div>
						</div>
					</div>