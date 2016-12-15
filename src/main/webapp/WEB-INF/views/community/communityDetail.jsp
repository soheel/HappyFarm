<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<section class="noo-page-heading eff heading-6">
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
										<%-- <div class="summary entry-summary">
											<c:forEach items="${commentlist}" var="communityDTO">
												<c:forEach items="${communityDTO.communityCommentDTO}" var="comm">
													<p>${comm.no}</p>
													<p>${comm.content}</p>
													<p>${comm.registerdate}</p>
													<p>${comm.email}</p>
												</c:forEach>
											</c:forEach>
										</div> --%>
									</div>
									<div class="panel panel-white post">
										<div class="post-footer">
											<div class="input-group"> 
												<input class="form-control" placeholder="Add a comment" type="text">
												<span class="input-group-addon">
													<a href="#"><i class="fa fa-edit"></i></a>  
												</span>
											</div>
											<ul class="comments-list">
												<li class="comment">
													<a class="pull-left" href="#">
														<img class="avatar" src="http://bootdey.com/img/Content/user_1.jpg" alt="avatar">
													</a>
													<div class="comment-body">
														<div class="comment-heading">
															<h4 class="user">Gavino Free</h4>
															<h5 class="time">5 minutes ago</h5>
														</div>
														<p>Sure, oooooooooooooooohhhhhhhhhhhhhhhh</p>
													</div>
													<ul class="comments-list">
														<li class="comment">
															<a class="pull-left" href="#">
																<img class="avatar" src="http://bootdey.com/img/Content/user_3.jpg" alt="avatar">
															</a>
															<div class="comment-body">
																<div class="comment-heading">
																	<h4 class="user">Ryan Haywood</h4>
																	<h5 class="time">3 minutes ago</h5>
																</div>
																<p>Relax my friend</p>
															</div>
														</li> 
														<li class="comment">
															<a class="pull-left" href="#">
																<img class="avatar" src="http://bootdey.com/img/Content/user_2.jpg" alt="avatar">
															</a>
															<div class="comment-body">
																<div class="comment-heading">
																	<h4 class="user">Gavino Free</h4>
																	<h5 class="time">3 minutes ago</h5>
																</div>
																<p>Ok, cool.</p>
															</div>
														</li> 
													</ul>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>