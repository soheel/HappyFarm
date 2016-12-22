<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
							<h3 class="widget-title">주문 관리</h3>
							<div id = "accordion">
								<!-- 결제완료된 목록 -->
								<h3>결제 완료</h3>
								<div>
									<table id = "payCompleteListTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name">주문No</th>
												<th class="product-area">회원아이디</th>
												<th class="product-age">구매 가격</th>
												<th class="product-job">구매 상태</th>
												<th class="product-name">구매 형태</th>
												<th class="product-name">구매 날짜</th>
												<th class="product-name">주문자 이름</th>
												<th class="product-name">주문자 주소</th>
												<th class="product-name">주문자 연락처</th>
												
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${payCompleteList}" var="payCompleteList" varStatus="state"> 
											<tr class="cart_item">
												<td class="product-name">
													${payCompleteList.no }
												</td>
												<td class="product-area">
													<span class="amount">${payCompleteList.email}</span> 
												</td>
												<td class="product-age">
													<span class="amount">${payCompleteList.price}</span> 
												</td>
												<td class="product-job">
													결제완료
												</td>
												<td class="product-name">
													${payCompleteList.method}
												</td>
												<td class="product-name">
													<span class="amount">  
													<fmt:parseDate value="${payCompleteList.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
													<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
													</span> 
												</td>
												<td class="product-name">
													<span class="amount">${payCompleteList.purchaseOrderDto.name}</span>
												</td>
												<td class="product-name">
													<span class="amount">${payCompleteList.purchaseOrderDto.addr}</span>
												</td>
												<td class="product-name">
													<span class="amount">${payCompleteList.purchaseOrderDto.phone}</span>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							
							<!-- 주문완료된 목록 -->
							<h3>주문 완료</h3>
								<div>
									<table id = "orderCompleteListTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name">주문No</th>
												<th class="product-area">회원아이디</th>
												<th class="product-age">구매 가격</th>
												<th class="product-job">구매 상태</th>
												<th class="product-name">구매 형태</th>
												<th class="product-name">구매 날짜</th>
												<th class="product-name">주문자 이름</th>
												<th class="product-name">주문자 주소</th>
												<th class="product-name">주문자 연락처</th>
												
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${orderCompleteList}" var="orderCompleteList" varStatus="state"> 
											<tr class="cart_item">
												<td class="product-name">
												<span id = "order_complete_no">${orderCompleteList.no }</span>
												</td>
												<td class="product-area">
													<span class="amount">${orderCompleteList.email}</span> 
												</td>
												<td class="product-age">
													<span class="amount">${orderCompleteList.price}</span> 
												</td>
												<td class="product-job">
													주문완료<br><span value = "${orderCompleteList.no }" name = "deposit_complete" style = 'color : pink; cursor : pointer;'>[입금확인]</span>
												</td>
												<td class="product-name">
													${orderCompleteList.method}
												</td>
												<td class="product-name">
													<span class="amount">  
													<fmt:parseDate value="${orderCompleteList.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
													<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
													</span> 
												</td>
												<td class="product-name">
													<span class="amount">${orderCompleteList.purchaseOrderDto.name}</span>
												</td>
												<td class="product-name">
													<span class="amount">${orderCompleteList.purchaseOrderDto.addr}</span>
												</td>
												<td class="product-name">
													<span class="amount">${orderCompleteList.purchaseOrderDto.phone}</span>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								
								<!-- 환불/반품/교환 신청된 목록 -->
								<h3>환불/반품/교환 신청</h3>
								<div>
									<table id = "etcAskListTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name">주문No</th>
												<th class="product-area">회원아이디</th>
												<th class="product-age">구매 가격</th>
												<th class="product-job">구매 상태</th>
												<th class="product-name">구매 형태</th>
												<th class="product-name">구매 날짜</th>
												<th class="product-name">주문자 이름</th>
												<th class="product-name">주문자 주소</th>
												<th class="product-name">주문자 연락처</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${etcAskList}" var="etcAskList" varStatus="state"> 
											<tr class="cart_item">
												<td class="product-name">
													${etcAskList.no }
												</td>
												<td class="product-area">
													<span class="amount">${etcAskList.email}</span> 
												</td>
												<td class="product-age">
													<span class="amount">${etcAskList.price}</span> 
												</td>
												<td class="product-job">
													<c:choose>
														<c:when test="${etcAskList.stateNo == 3 }">
															환불신청<br>
															<span style = 'color : pink; cursor : pointer;' name = "etc_complete" value = "${etcAskList.no}">[상태변경]</span>
														</c:when>
														<c:when test="${etcAskList.stateNo == 4 }">
															반품신청<br>
															<span style = 'color : pink; cursor : pointer;' name = "etc_complete" value = "${etcAskList.no}">[상태변경]</span>
														</c:when>
														<c:when test="${etcAskList.stateNo == 5 }">
															교환신청<br>
															<span style = 'color : pink; cursor : pointer;' name = "etc_complete" value = "${etcAskList.no}">[상태변경]</span>
														</c:when>
													</c:choose>
												</td>
												<td class="product-name">
													${etcAskList.method}
												</td>
												<td class="product-name">
													<span class="amount">  
													<fmt:parseDate value="${etcAskList.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
													<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
													</span> 
												</td>
												<td class="product-name">
													<span class="amount">${etcAskList.purchaseOrderDto.name}</span>
												</td>
												<td class="product-name">
													<span class="amount">${etcAskList.purchaseOrderDto.addr}</span>
												</td>
												<td class="product-name">
													<span class="amount">${etcAskList.purchaseOrderDto.phone}</span>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								
								<!-- 환불/반품/교환 완료된 목록 -->
								<h3>환불/반품/교환 완료</h3>
								<div>
									<table id = "etcCompleteListTable" class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name">주문No</th>
												<th class="product-area">회원아이디</th>
												<th class="product-age">구매 가격</th>
												<th class="product-job">구매 상태</th>
												<th class="product-name">구매 형태</th>
												<th class="product-name">구매 날짜</th>
												<th class="product-name">주문자 이름</th>
												<th class="product-name">주문자 주소</th>
												<th class="product-name">주문자 연락처</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${etcCompleteList}" var="etcCompleteList" varStatus="state"> 
											<tr class="cart_item">
												<td class="product-name">
													${etcCompleteList.no }
												</td>
												<td class="product-area">
													<span class="amount">${etcCompleteList.email}</span> 
												</td>
												<td class="product-age">
													<span class="amount">${etcCompleteList.price}</span> 
												</td>
												<td class="product-job">
													<c:choose>
														<c:when test="${etcCompleteList.stateNo==6 }">
															환불완료
														</c:when>
														<c:when test="${etcCompleteList.stateNo==7 }">
															반품완료
														</c:when>
														<c:when test="${etcCompleteList.stateNo==8 }">
															교환완료
														</c:when>
													</c:choose>
													
												</td>
												<td class="product-name">
													${etcCompleteList.method}
												</td>
												<td class="product-name">
													<span class="amount">  
													<fmt:parseDate value="${etcCompleteList.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
													<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
													</span> 
												</td>
												<td class="product-name">
													<span class="amount">${etcCompleteList.purchaseOrderDto.name}</span>
												</td>
												<td class="product-name">
													<span class="amount">${etcCompleteList.purchaseOrderDto.addr}</span>
												</td>
												<td class="product-name">
													<span class="amount">${etcCompleteList.purchaseOrderDto.phone}</span>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
					</div>
	