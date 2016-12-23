<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
			<section class="noo-page-heading eff heading-2">
				<div class="container">
					<div class="noo-heading-content">
						<h1 class="page-title eff">Community Detail</h1>
						<div class="noo-page-breadcrumb eff">
							<a href="./" class="home">Organici</a>/<span>community Detail</span>
						</div>
					</div>
				</div>
			</section>
			<div class="main">
				<div class="commerce single-product noo-shop-main">
					<div class="container">
						<div class="row">
							<div class="noo-main col-md-9">
								<div class="product">
									<div class="single-inner">
										<h1 class="product_title entry-title">${community.name}</h1>
										<div class="related products profile_board">
										<img alt="" src="<c:url value = '/resources/img/community/'/>${community.desc}">
									</div>
										<div class="panel post">
											<div id="comments" class="comments-area">
												<h2 class="comments-title">${fn:length(commentList)} Comments</h2>
												<ol class="comments-list">
													<c:forEach items="${commentList}" var="comment">
														<c:if test="${comment.parentNo == null}">
															<li class="comment">
																<div class="comment-wrap">
																	<article class="comment-block">
																		<input type="hidden" name="no" value="${comment.no}">
																		<header class="comment-header">
																			<cite class="comment-author">
																				${comment.email}
																			</cite>
																			<div class="comment-meta">
																				<span class="time">
																					${comment.registerdate}
																				</span>
																			</div>
																		</header>
																		<div class="comment-content">
																			<p>${comment.content}</p>
																		</div>
																		<span class="comment-reply">
																			<c:if test="${sessionScope.email == 'admin'}">
																				<a class='comment-reply-link'><i class="fa fa-reply"></i> Reply</a>
																				<a class='comment-replyCancle-link'><i class="fa fa-reply"></i> Cancle</a>
																			</c:if>
																			<c:if test="${comment.email == sessionScope.email || sessionScope.email == 'admin'}">
																				<a class='comment-update-link'><i class="fa fa-pencil-square"></i> Update</a>
																				<a class='comment-updateCancle-link'><i class="fa fa-pencil-square"></i> Cancle</a>
																				<a class='comment-delete-link'><i class="fa fa-remove"></i> Delete</a>
																			</c:if>
																		</span>
																		
																		<!-- 입력, 수정 클릭시 나올 덧글창 나올 곳 -->
																	</article>
																</div>
																<c:forEach items="${commentList}" var="reply">
																	<c:if test="${reply.parentNo == comment.no}">
																		<ol class="children">
																			<li class="comment">
																				<div class="comment-wrap">
																					<div class="comment-img">
																						<img alt='' src='http://placehold.it/100x100' height='80' width='80' />
																					</div>
																					<article class="comment-block">
																						<input type="hidden" name="no" value="${reply.no}">
																						<header class="comment-header">
																							<cite class="comment-author">
																								${reply.email}
																							</cite>
																							<div class="comment-meta">
																								<span class="time">
																									${reply.registerdate}
																								</span>
																							</div>
																						</header>
																						<div class="comment-content">
																							<p>${reply.content}</p>
																						</div>
																						<span class="comment-reply">
																							<c:if test="${reply.email == sessionScope.email || sessionScope.email == 'admin'}">
																								<a class='comment-update-link'><i class="fa fa-pencil-square"></i> Update</a>
																								<a class='comment-updateCancle-link'><i class="fa fa-pencil-square"></i> Cancle</a>
																								<a class='comment-delete-link'><i class="fa fa-remove"></i> Delete</a>
																							</c:if>
																						</span>
																						<!-- 입력, 수정 클릭시 나올 덧글창 나올 곳 -->
																						
																					</article>
																				</div>
																			</li>
																		</ol><!-- .children -->
																	</c:if>
																</c:forEach>
															</li><!-- #comment-## -->
														</c:if>
													</c:forEach>
												</ol> <!-- /.comments-list -->
												<div id="respond-wrap">
													<div id="respond" class="comment-respond">
														<h3 id="reply-title" class="comment-reply-title">
															<span>Leave your thought</span>
														</h3>
														<form id="communityReply" class="comment-form" action="" method="post">
															<div class="row">
																<div class="col-sm-12">
																	<div class="comment-form-comment">
																		<textarea class="form-control" placeholder="Enter Your Comment" id="comment" name="comment" cols="40" rows="6"></textarea>
																	</div>
																</div>
															</div>
															<div class="form-submit">
																<input name="button" type="button" id="communityReplyButton" class="submit" value="Post Comments" />
															</div>
														</form>
													</div><!-- #respond -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>