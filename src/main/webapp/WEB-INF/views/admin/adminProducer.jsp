<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
						<div class="container">
							<h3 class="widget-title">생산자 관리</h3>
							<div class="row">
								<div class="noo-main col-md-12">
									<table id = "producerManageTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name">이름</th>
												<th class="product-area">주소</th>
												<th class="product-age">연락처</th>
												<th class="product-job">등록날짜</th>
												<th class="product-name">평점</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${producerlist}" var="producer" varStatus="state"> 
											<tr class="cart_item">
												<td class="product-name">
													<span style = "font-weight : bold;">${producer.name}</span> 
													<span value = "${producer.no }" style = "color : pink; cursor : pointer;" name = "modifyButton" data-toggle="modal" data-target="#update">[수정]</span>
													<span value = "${producer.no }" style = "color : pink; cursor : pointer;" name = "deleteButton">[삭제]</span>
												</td>
												<td class="product-area">
													<span class="amount">${producer.addr}</span> 
												</td>
												<td class="product-age">
													<span class="amount">${producer.phone}</span> 
												</td>
												<td class="product-job">
													<span class="amount">${producer.registerDate}</span> 
												</td>
												<td class="product-name">
													<div class="noo-rating">
														<div class="star-rating">
															<span style="width:${evalList[state.index] * 20}%"></span>
														</div>
													</div>
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
							<form name="regProducer" action="<c:url value='/manageController/producerRegisterManage'/>" method = "post" enctype="multipart/form-data">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">생산자 등록</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="producer_name">
																생산자 이름
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name" />
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_addr">
																주소
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="addr" id="addr" />
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_phone">
																연락처
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="phone" id="phone" />
														</div>
														
														<div class="form-row form-row-wide">
															<label for="producer_photo">
																사진
																<span class="required">*</span>
															</label>
															<input type="file" name="file" maxlength="60" size="40">
														</div>
													</div>
													<div class="col-md-1"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-default" id="producerRegister">등록</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- update Modal -->
					<div class="modal fade" id="update" role="dialog">
						<div class="modal-dialog">
							<form action="<c:url value='/manageController/producerModifyManage'/>" method="post" enctype="multipart/form-data">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">생산자 수정</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="producer_no">
																생산자 번호 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="no" id="no"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_name">
																생산자 이름
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name" />
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_addr">
																주소
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="addr" id="addr" />
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_phone">
																연락처
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="phone" id="phone" />
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_photo">
																사진
																<span class="required">*</span>
															</label>
															<input type="hidden" name="profile">
															<input type="file" name="file" id="file"/>
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