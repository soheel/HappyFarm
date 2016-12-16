<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
						<div class="container">
							<h3 class="widget-title">개별 상품 관리</h3>
							<div class="row">
								<div class="noo-main col-md-12">
									<table id = "productManageTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="product-no">상품 No</th>
												<th class="product-name">상품이름</th>
												<th class="product-price">상품가격</th>
												<th class="product-no">카테고리</th>
												<th class="product-producer">생산자</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${productlist}" var="productlist">
											
											<tr class="cart_item">
												<td class="product-no">
													${productlist.no }
												</td>
												<td class="product-name">
													<span style = "font-weight : bold;">${productlist.name}</span>
													<span value = "${productlist.no }" style = "color : pink; cursor : pointer;" name = "modifyButtonProduct" data-toggle="modal" data-target="#update">[수정]</span>
													<span value = "${productlist.no }" style = "color : pink; cursor : pointer;" name = "deleteButtonProduct">[삭제]</span>
												</td>
												<td class="product-price">
													<span class="amount"><fmt:formatNumber value = '${productlist.price}' pattern='#,### 원'/></span> 
												</td>
												<td class="product-producer">
													[${productlist.subCategoryDto.categoryDto.name }] / [${productlist.subCategoryDto.name}]
												</td>
												<td class="product-producer">
													${productlist.producerDto.name }
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
							</div>
						</div>
					</div>

					<!-- insert Modal -->
					<div class="modal fade" id="insert" role="dialog">
						<div class="modal-dialog">
							<form action="<c:url value='/manageController/productRegisterManage'/>" method="post" enctype="multipart/form-data">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">상품등록</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="item_name">
																상품이름 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="item_price">
																가격
																<span class="required">*</span>
															</label>
															<input type="number" class="input-text" name="price" id="price" />
														</div>
														<div class="form-row form-row-wide">
															<label for="item_unit">
																단위
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="unit" id="unit" />
														</div>
														<div class="form-row form-row-wide">
															<label for="item_photo">
																대표 이미지
																<span class="required">*</span>
															</label>
															<input type="file" name="file" id="photo" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																설명 이미지
																<span class="required">*</span>
															</label>
															<input type="file" name="file" id="content" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																카테고리
																<span class="required">*</span>
															</label>
															<select>
																<option value="volvo">대분류</option>
																<option value="saab">Saab</option>
																<option value="opel">Opel</option>
																<option value="audi">Audi</option>
															</select>
															<select name = "subCategoryNo">
																<option value="volvo">소분류</option>
																<option value="1">Saab</option>
																<option value="2">Opel</option>
																<option value="3">Audi</option>
															</select>
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																생산자번호
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="producerNo" id="reg_phone" />
														</div>
														
													</div>
													<div class="col-md-1"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-default">확인</button>
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
										<h4 class="modal-title">상품수정</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="item_name">
																상품이름 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="item_price">
																가격
																<span class="required">*</span>
															</label>
															<input type="number" class="input-text" name="price" id="price" />
														</div>
														<div class="form-row form-row-wide">
															<label for="item_unit">
																단위
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="unit" id="unit" />
														</div>
														<div class="form-row form-row-wide">
															<label for="item_photo">
																사진
																<span class="required">*</span>
															</label>
															<input type="file" name="photo" id="photo" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																설명
																<span class="required">*</span>
															</label>
															<input type="file" name="content" id="content" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																카테고리
																<span class="required">*</span>
															</label>
															<select>
																<option value="volvo">대분류</option>
																<option value="saab">Saab</option>
																<option value="opel">Opel</option>
																<option value="audi">Audi</option>
															</select>
															<select>
																<option value="volvo">소분류</option>
																<option value="saab">Saab</option>
																<option value="opel">Opel</option>
																<option value="audi">Audi</option>
															</select>
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																생산자번호
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="phone" id="reg_phone" />
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