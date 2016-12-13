<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
						<div class="container">
							<h3 class="widget-title">세트 상품 관리</h3>
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
												<th class="product-name">세트이름</th>
												<th class="product-price">세트가격</th>
												<th class="product-producer">포함상품</th>
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
												<td class="product-price">
													<span class="amount">&#36;3.95</span> 
												</td>
												<td class="product-producer">
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
										<h4 class="modal-title">세트상품 등록</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="package_name">
																이름 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="package_price">
																가격
																<span class="required">*</span>
															</label>
															<input type="number" class="input-text" name="price" id="price" />
														</div>
														<div class="form-row form-row-wide">
															<label for="package_unit">
																사진
																<span class="required">*</span>
															</label>
															<input type="file" name="photo" id="photo" />
														</div>
														<div class="form-row form-row-wide">
															<label for="package_photo">
																설명
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="content" id="content" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																상품검색
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="search" id="search" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																상품
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
										<h4 class="modal-title">세트상품 수정</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="package_name">
																이름 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="package_price">
																가격
																<span class="required">*</span>
															</label>
															<input type="number" class="input-text" name="price" id="price" />
														</div>
														<div class="form-row form-row-wide">
															<label for="package_unit">
																사진
																<span class="required">*</span>
															</label>
															<input type="file" name="photo" id="photo" />
														</div>
														<div class="form-row form-row-wide">
															<label for="package_photo">
																설명
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="content" id="content" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																상품검색
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="search" id="search" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																상품
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