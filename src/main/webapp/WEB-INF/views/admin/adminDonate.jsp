<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart">
						<div class="container profile_view">
							<h3 class="widget-title">기부업체 관리</h3>
							<div class="row">
								<div class="noo-main col-md-12">
									<table class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name table_small tc">기부업체</th>
												<th class="product-addr table_medium">주소</th>
												<th class="product-phone table_small tc">연락처</th>
												<th class="product-content table_large">설명</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${donationlist}" var="donation"> 
											<tr class="cart_item">
												<td class="product-name tc">
													${donation.name}
												</td>
												<td class="product-area">
													<span class="amount">${donation.addr}</span> 
												</td>
												<td class="product-phone tc">
													<span class="amount">${donation.phone}</span> 
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
								<input type="button" value="등록/수정" name="modifyButtonDonationOrg" data-toggle="modal" data-target="#update">
							</div>
						</div>
					</div>
					<!-- update Modal -->
					<div class="modal fade" id="update" role="dialog">
						<div class="modal-dialog">
							<form action="<c:url value = '/manageController/donationOrgModifyManage'/>" method="post" enctype="multipart/form-data">
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
															<input type="text" class="input-text" name="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="product-phone">
																연락처
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="phone"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="product-addr">
																주소
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="addr"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="product-content">
																설명
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="desc"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="producer_photo">
																기부업체로고
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