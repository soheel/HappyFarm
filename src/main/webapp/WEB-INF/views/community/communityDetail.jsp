<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
									<div class="panel post">
										<div id="comments" class="comments-area">
				                        	<h2 class="comments-title">3 Comments</h2>
				                        	<ol class="comments-list">
							        			<li class="comment">
				            						<div class="comment-wrap">
				                						<div class="comment-img">
				                    						<img alt='' src='http://placehold.it/100x100' height='80' width='80' />
				                    					</div>
				                						<article class="comment-block">
				                    						<header class="comment-header">
				                        						<cite class="comment-author">
				                        							admin
				                        						</cite>
										                        <div class="comment-meta">
										                            <span class="time">
										                                4 months ago
										                            </span>
										                        </div>
				                                            </header>
				                    						<div class="comment-content">
				                        						<p>fames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus</p>
				                    						</div>
				                    						<span class="comment-reply">
				                        						<a class='comment-reply-link' href='#'><i class="fa fa-reply"></i> Reply</a>
				                        					</span>
				                						</article>
			            							</div>
				        							<ol class="children">
				        								<li class="comment">
				            								<div class="comment-wrap">
				                								<div class="comment-img">
				                    								<img alt='' src='http://placehold.it/100x100' height='80' width='80' />
				                    							</div>
				                								<article class="comment-block">
				                    								<header class="comment-header">
				                        								<cite class="comment-author">
				                        									admin
				                                                    	</cite>
												                        <div class="comment-meta">
												                            <span class="time">
												                                4 months ago
												                            </span>
												                        </div>
				                                            		</header>
												                    <div class="comment-content">
												                        <p>fSames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus</p>
												                    </div>
				                    								<span class="comment-reply">
						                        						<a class='comment-reply-link' href='#'><i class="fa fa-reply"></i> Reply</a>
						                        					</span>
				                								</article>
												            </div>
												        </li><!-- #comment-## -->
													</ol><!-- .children -->
											        <li class="comment">
											            <div class="comment-wrap">
					                						<div class="comment-img">
					                    						<img alt='' src='http://placehold.it/100x100' height='80' width='80' />
					                    					</div>
					                						<article class="comment-block">
					                    						<header class="comment-header">
					                        						<cite class="comment-author">
					                        							admin
					                        						</cite>
											                        <div class="comment-meta">
											                            <span class="time">
											                                4 months ago
											                            </span>
											                        </div>
					                                            </header>
					                    						<div class="comment-content">
					                        						<p>fames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus</p>
					                    						</div>
					                    						<span class="comment-reply">
					                        						<a class='comment-reply-link' href='#'><i class="fa fa-reply"></i> Reply</a>
					                        					</span>
					                						</article>
					            						</div>
											        </li><!-- #comment-## -->
												</ol> <!-- /.comments-list -->
												<div id="respond-wrap">
					        						<div id="respond" class="comment-respond">
														<h3 id="reply-title" class="comment-reply-title">
															<span>Leave your thought</span>
														</h3>
														<form class="comment-form">
															<div class="row">
																<div class="comment-form-author col-sm-6">
																	<input id="author" name="author" type="text" placeholder="Enter Your Name*" class="form-control" value="" size="30" />
																</div>
																<div class="comment-form-email col-sm-6">
																	<input id="email" name="email" type="text" placeholder="Enter Your Email*" class="form-control" value="" size="30" />
																</div>
																<div class="col-sm-12">
																	<div class="comment-form-comment">
																		<textarea class="form-control" placeholder="Enter Your Comment" id="comment" name="comment" cols="40" rows="6"></textarea>
																	</div>
																</div>
															</div>
																<div class="form-submit">
																<input name="submit" type="submit" id="submit" class="submit" value="Post Comments" />
															</div>
														</form>
													</div><!-- #respond -->
								    			</div>
					    					</div>
										</div>
									</div>
								</div>