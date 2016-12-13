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
											<tr class="cart_item">
												<td class="product-check">
													<div class="checks etrans">
														<input type="checkbox" id="ex_chk1">
														<label for="ex_chk1"></label> 
													</div>
												</td>
												<td class="product-name">
													으아아아아
												</td>
												<td class="product-phone">
													<span class="amount">thie</span> 
												</td>
												<td class="product-area">
													<span class="amount">&#36;3.95</span> 
												</td>
												<td class="product-content">
													<span class="amount">thie</span> 
												</td>
											</tr>
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
							<form action="" method="">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">기부업체 등록</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="product-name">
																기부업체 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="no" id="no"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="product-phone">
																연락처
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="phone" id="phone" />
														</div>
														<div class="form-row form-row-wide">
															<label for="product-addr">
																주소
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="addr" id="addr" />
														</div>
														
														<div class="form-row form-row-wide">
															<label for="product-content">
																설명
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="item" id="item" />
														</div>
													</div>
													<div class="col-md-1"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-default">등록</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
									</div>
								</div>
							</form>
						</div>
					</div>



					<!-- update Modal -->
					<div class="modal fade" id="update" role="dialog">
						<div class="modal-dialog">
							<form action="" method="">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">기부업체 수정</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="product-name">
																기부업체 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="no" id="no"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="product-phone">
																연락처
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="phone" id="phone" />
														</div>
														<div class="form-row form-row-wide">
															<label for="product-addr">
																주소
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="addr" id="addr" />
														</div>
														
														<div class="form-row form-row-wide">
															<label for="product-content">
																설명
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="item" id="item" />
														</div>
													</div>
													<div class="col-md-1"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-default">수정</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
									</div>
								</div>
							</form>
						</div>
					</div>