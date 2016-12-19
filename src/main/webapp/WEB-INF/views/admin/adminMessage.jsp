<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
						<div class="container">
							<h3 class="widget-title">기부업체 관리</h3>
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
												<th class="product-name">기부업체</th>
												<th class="product-phone">연락처</th>
												<th class="product-addr">주소</th>
												<th class="product-content">설명</th>
												
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${donationlist}" var="donation"> 
											<tr class="cart_item">
												<td class="product-check">
													<div class="checks etrans">
														<input type="checkbox" id="ex_chk1">
														<label for="ex_chk1"></label> 
													</div>
												</td>
												<td class="product-name">
													${donation.name}
												</td>
												<td class="product-phone">
													<span class="amount">${donation.phone}</span> 
												</td>
												<td class="product-area">
													<span class="amount">${donation.addr}</span> 
												</td>
												<td class="product-content">
													<span class="amount">${donation.desc}</span> 
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<div class="adminShopItem-action-btn">
								<input type="button" value="등록" name="insert" data-toggle="modal" data-target="#insert">
								<input type="button" value="수정" name="update" data-toggle="modal" data-target="#update">
								<input type="button" value="삭제" name="delete">
							</div>
						</div>
					</div>

					<!-- insert Modal -->
					<div class="modal fade" id="insert" role="dialog">
						<div class="modal-dialog">
							<form method="post" action="http://api.coolsms.co.kr/sendmsg" enctype="multipart/form-data">
									<ul>
										<li>User Id: <input type="text" name="user" value="" /></li>
										<li>Password: <input type="text" name="password" value="" /></li>
										<li>To: <input type="text" name="to" value="" /></li>
										<li>From: <input type="text" name="from" value="01090786137" /></li>
										<li>Subject: <input type="text" name="subject" value="" /></li>
										<li>Text: <input type="text" name="text" value="" /></li>
										<li>Type: <select name="type">
											<option value="SMS">SMS</option>
											<option value="LMS">LMS</option>
											<option value="MMS">MMS</option>
										</select></li>
										<li>Image: <input type="file" name="image" /></li>
										<li><input type="submit" value="Submit" /></li>
									</ul>
								</form>

						</div>
					</div>