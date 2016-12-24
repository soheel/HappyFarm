<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart">
						<div class="container profile_view">
							<h3 class="widget-title">개별 상품 관리</h3>
							<div class="row">
								<div class="noo-main col-md-12">
									<table id = "productManageTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="table_small tc">상품 No</th>
												<th>상품이름</th>
												<th class="table_small tc">상품가격</th>
												<th class="table_medium tc">카테고리</th>
												<th class="table_small tc">생산자</th>			
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${productlist}" var="productlist">
											
											<tr class="cart_item">
												<td class="product-no tc">
													${productlist.no }
												</td>
												<td>
													<span style = "font-weight : bold;">${productlist.name}</span>
													<span value = "${productlist.no }" style = "color : pink; cursor : pointer;" name = "modifyButtonProduct" data-toggle="modal" data-target="#update">[수정]</span>
													<span value = "${productlist.no }" style = "color : pink; cursor : pointer;" name = "deleteButtonProduct">[삭제]</span>
												</td>
												<td class="tc">
													<span class="amount"><fmt:formatNumber value = '${productlist.price}' pattern='#,### 원'/></span> 
												</td>
												<td class="tc">
													[${productlist.subCategoryDto.categoryDto.name }] / [${productlist.subCategoryDto.name}]
												</td>
												<td class="tc">
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
															<select name = "subCategoryNo">
																<option value="volvo">선택</option>
																<option value="1">사과,배</option>
																<option value="2">딸기,블루베리</option>
																<option value="3">바나나,키위,토마토</option>
																<option value="4">감/곶감</option>
																<option value="5">감귤,한라봉</option>
																<option value="6">땅콩,잣,호두</option>
																<option value="7">복숭아,자두,포도</option>
																<option value="8">건과,견과류</option>
																<option value="9">수박,참외,매실</option>
																
																<option value="10">두부,콩나물</option>
																<option value="11">고구마,감자,당근,연근</option>
																<option value="12">상추,깻잎,쌈채소</option>
																<option value="13">양파,마늘,생강,파</option>
																<option value="14">배추,무,김장채소</option>
																<option value="15">오이,호박,가지</option>
																<option value="16">시금치,미나리,아욱,건나물</option>
																<option value="17">브로콜리,양배추,샐러드,녹즙</option>
																<option value="18">새송이,느타리,버섯</option>
																<option value="19">파프리카,피망,고추</option>
																
																<option value="20">백미,현미,이유식</option>
																<option value="21">찹쌀,흑미</option>
																<option value="22">잡곡,콩,깨</option>
																<option value="23">고춧가루,미숫가루,곡물가루</option>
															</select>
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																생산자번호
																<span class="required">*</span>
																<select id="producer_Info">
																	<c:forEach items="${producerlist}" var="producer">
																	<option value="${producer.no}">${producer.name} (생산자 번호 ${producer.no})</option>
																	</c:forEach>
																</select>
															</label>
															<input type="text" class="input-text" name="producerNo" id="reg_producerNo"/>
														</div>
														
														<div class="form-row form-row-wide">
															<label for="reg_certification">
																유기농 인증 번호
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="no" id="reg_proCertificationno" />
														</div>
														
														<div class="form-row form-row-wide">
															<label for="reg_certification_kind">
																인증 분류 / 인증 번호
															</label>
															<input type="hidden" name="certificationNo" id="certificationNo"/>
															<select id="certification_Info">
																	<c:forEach items="${certificationList}" var="certi">
																	<option value="${certi.no}">${certi.name} (${certi.no})</option>
																	</c:forEach>
															</select>
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
							<form action="<c:url value='/manageController/productModifyManage'/>" method="post" enctype="multipart/form-data">
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
															<input type = "hidden" name = "no">
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
															<input type="hidden" name="profile">
															<input type="file" name="file" id="photo" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																설명
																<input type="hidden" name="desc">
																<span class="required">*</span>
															</label>
															<input type="file" name="file" id="desc" />
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																카테고리
																<span class="required">*</span>
															</label>
															<select name = "subCategoryNo">
																<option value="volvo">선택</option>
																<option value="1">사과,배</option>
																<option value="2">딸기,블루베리</option>
																<option value="3">바나나,키위,토마토</option>
																<option value="4">감/곶감</option>
																<option value="5">감귤,한라봉</option>
																<option value="6">땅콩,잣,호두</option>
																<option value="7">복숭아,자두,포도</option>
																<option value="8">건과,견과류</option>
																<option value="9">수박,참외,매실</option>
																
																<option value="10">두부,콩나물</option>
																<option value="11">고구마,감자,당근,연근</option>
																<option value="12">상추,깻잎,쌈채소</option>
																<option value="13">양파,마늘,생강,파</option>
																<option value="14">배추,무,김장채소</option>
																<option value="15">오이,호박,가지</option>
																<option value="16">시금치,미나리,아욱,건나물</option>
																<option value="17">브로콜리,양배추,샐러드,녹즙</option>
																<option value="18">새송이,느타리,버섯</option>
																<option value="19">파프리카,피망,고추</option>
																
																<option value="20">백미,현미,이유식</option>
																<option value="21">찹쌀,흑미</option>
																<option value="22">잡곡,콩,깨</option>
																<option value="23">고춧가루,미숫가루,곡물가루</option>
															</select>
															<input type = "hidden" name = "eval">
														</div>
														<div class="form-row form-row-wide">
															<label for="reg_password">
																생산자번호
																<span class="required">*</span>
																<select id="producer_Info2">
																	<c:forEach items="${producerlist}" var="producer">
																	<option value="${producer.no}">${producer.name} (생산자 번호 ${producer.no})</option>
																	</c:forEach>
																</select>
															</label>
															<input type="text" class="input-text" name="producerNo" id="reg_producerNo2"/>
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