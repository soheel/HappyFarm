<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
					<div class="container">
						<div class="row">
							<div class="noo-main col-md-12">
								<h3 class="widget-title">Community 관리</h3>
								<div class="row">	
									<table>
										<tr>
											<th><input type="checkbox" name=""></th>
											<th>사진</th>
											<th>이름</th>
											<th>desc..?</th>
											<th>별점</th> 
										</tr>
										<c:forEach items="${communitylist}" var="community">
											<tr>
												<td><input type="checkbox" name=""></td>
												<td>
													<img width="600" height="760" src="http://lorempixel.com/150/150/">
												</td>
												<td>
													<h3>
														<a href="#" data-toggle="modal" data-target="#update">${community.name }</a>
													</h3>
												</td>
												<td>
													<span class="price">
														<span class="amount">${community.desc }</span>
													</span>
												</td>
												<td>
													<div class="noo-rating">
														<div class="star-rating">
															<span style="width:60%"></span>
														</div>
													</div>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
								
								<%-- <div class="products row product-grid">
									<!-- 여기부터 농산묻 리스트 불러오는 곳 -->
									<c:forEach items="${communitylist}" var="community">
										<div class="masonry-item noo-product-column col-md-4 col-sm-6 product">
											<div class="noo-product-inner">
												<div class="noo-product-thumbnail">
													<a href="#"  data-toggle="modal" data-target="#update">
														<img width="600" height="760" src="http://lorempixel.com/260/330/">
													</a>
													<div class="noo-rating">
														<div class="star-rating">
															<span style="width:60%"></span>
														</div>
													</div>
												</div>
												<div class="noo-product-title"> 
													<h3><a href="#">${community.name }</a></h3>
													<span class="price"><span class="amount">${community.desc }</span></span>
												</div>
											</div>
										</div>
									</c:forEach>
									<!-- 여기까지 농산묻 리스트 불러오는 곳 -->
								</div> --%>
							</div>
							<div class="adminShopItem-action-btn">
								<input type="button" value="등록" name="insert" data-toggle="modal" data-target="#insert">
								<input type="button" value="삭제" name="delete">
							</div>
						</div>
					</div>

					<!-- add btn -->
					<!-- 
					<div class="round-button">
						<a href="#"  data-toggle="modal" data-target="#insert">+</a>
					</div> -->

					<!-- insert Modal -->
					<div class="modal fade" id="insert" role="dialog">
						<div class="modal-dialog">
							<form name="regCommunity" action="<c:url value='/manageController/communityRegisterManage'/>" enctype="multipart/form-data">
							
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Community 등록</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="community_name">
																이름 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_photo">
																사진
																<span class="required">*</span>
															</label>
															<input type="file" name="profile" id="profile" />
														</div>
														<div class="form-row form-row-wide">
															<label for="community_content">
																내용
																<span class="required">*</span>
															</label>
															<input type="file" name="desc" id="desc" />
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
										<h4 class="modal-title">Community 수정</h4>
									</div>
									<div class="modal-body shop-dialog">
										<div class="row">
											<div class="noo-main col-md-12">
												<div id="customer_login">
													<div class="col-md-1"></div>
													<div class="col-md-10">
														<div class="form-row form-row-wide">
															<label for="community_name">
																이름 
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_photo">
																사진
																<span class="required">*</span>
															</label>
															<input type="file" name="photo" id="photo" />
														</div>
														<div class="form-row form-row-wide">
															<label for="community_content">
																내용
																<span class="required">*</span>
															</label>
															<input type="file" name="content" id="content" />
														</div>
														<div class="form-row form-row-wide">
															<label for="community_explanation">
																설명
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="explanation" id="explanation" />
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