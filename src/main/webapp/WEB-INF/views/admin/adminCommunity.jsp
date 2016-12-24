<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
					<div class="container profile_view">
						<div class="row">
							<div class="noo-main col-md-12">
								<h3 class="widget-title">Community 관리</h3>
								<div class="row">	
									<table class="shop_table cart">
										<tr>
											<th>커뮤니티 No</th>
											<th>이름</th>
											<th>진행상태(1:진행중/ 2:진행완료)</th>
											<th>주최자</th> 
										</tr>
										<c:forEach items="${communitylist}" var="community">
											<tr>
												<td>
													${community.no }
												</td>
												<td>
													<span style = "font-weight : bold;">${community.name}</span> 
													<span value = "${community.no }" style = "color : pink; cursor : pointer;" name = "modifyButtonCommunity" data-toggle="modal" data-target="#update">[수정]</span>
													<span value = "${community.no }" style = "color : pink; cursor : pointer;" name = "deleteButtonCommunity">[삭제]</span>
												</td>
												<td>
													${community.state }
												</td>
												<td>
													${community.producerDTO.name }
												</td>
											</tr>
										</c:forEach>
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
							<form name="regCommunity" action="<c:url value='/manageController/communityRegisterManage'/>" method = "post" enctype="multipart/form-data">
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
																프로필 이미지
																<span class="required">*</span>
															</label>
															<input type="file" name="file"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_content">
																내용 이미지
																<span class="required">*</span>
															</label>
															<input type="file" name="file"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_name">
																주최자번호
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="producerNo"/>
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
							<form action="<c:url value='/manageController/communityModifyManage'/>" method = "post" enctype="multipart/form-data">
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
															<input type = "hidden" name="state">
															<input type = "hidden" name = "no">
															<input type="text" class="input-text" name="name" id="name"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_photo">
																프로필 이미지
																<span class="required">*</span>
															</label>
															<input type="hidden" name="profile">
															<input type="file" name="file"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_content">
																내용 이미지
																<span class="required">*</span>
															</label>
															<input type="hidden" name="desc">
															<input type="file" name="file"/>
														</div>
														<div class="form-row form-row-wide">
															<label for="community_name">
																주최자번호
																<span class="required">*</span>
															</label>
															<input type="text" class="input-text" name="producerNo"/>
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