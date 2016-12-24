<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart">
	<div class="container profile_view">
		<h3 class="widget-title">세트 상품 관리</h3>
		<div class="row">
			<div class="noo-main col-md-12">
				<table class="shop_table cart">
					<thead>
						<tr>
							<th class="product-name">상품No</th>
							<th class="product-price">세트상품 이름</th>
							<th class="product-producer">세트상품 가격</th>
							<th class="product-producer">포함 상품</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${packagelist}" var="packagelist"
							varStatus="state">
							<tr class="cart_item">
								<td class="product-name">${packagelist.packageNo }</td>
								<td class="product-price"><span style="font-weight: bold;">${packagelist.productDTO.name }</span>
									<span value="${packagelist.packageNo }"
									style="color: pink; cursor: pointer;"
									name="modifyButtonPackage" data-toggle="modal"
									data-target="#update">[수정]</span> <span
									value="${packagelist.packageNo }"
									style="color: pink; cursor: pointer;"
									name="deleteButtonPackage">[삭제]</span></td>
								<td class="product-producer"><span class="amount">${packagelist.productDTO.price }</span>
								</td>
								<td class="product-producer">
									${packageProductList[state.index]}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="adminShopItem-action-btn">
			<input type="button" value="등록" name="insert" data-toggle="modal"
				data-target="#insert">
		</div>
	</div>
</div>

<!-- insert Modal -->
<div class="modal fade" id="insert" role="dialog">
	<div class="modal-dialog">
		<form action="<c:url value='/manageController/packageRegisterManage'/>" method = "post" enctype="multipart/form-data">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">세트상품 등록</h4>
				</div>
				<div class="modal-body shop-dialog">
					<div class="row">
						<div class="noo-main col-md-12">
							<div id="customer_login">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<div class="form-row form-row-wide">
										<label for="package_name"> 이름 <span class="required">*</span>
										</label> <input type="text" class="input-text" name="name" id="name" />
									</div>
									<div class="form-row form-row-wide">
										<label for="package_price"> 가격 <span class="required">*</span>
										</label> <input type="number" class="input-text" name="price"
											id="price" />
									</div>
									<div class="form-row form-row-wide">
										<label for="package_unit"> 사진 <span class="required">*</span>
										</label> <input type="file" name="file"/>
									</div>
									<div class="form-row form-row-wide">
										<label for="package_unit"> 설명 이미지 <span class="required">*</span>
										</label> <input type="file" name="file"/>
									</div>
									<div class="form-row form-row-wide">
										<label for="reg_password"> 상품검색(이름) <span class="required">*</span>
										</label> <input type="text" class="input-text" name="search"
											/><input type = "button" value = "검색" name = "productSearch">
											<div id = "searchResult"></div>
									</div>
									<div class="form-row form-row-wide">
										<label for="reg_password"> 상품(클릭시 삭제) <span class="required">*</span>
										</label>
										<div id = "select_product"></div>
									</div>
								</div>
								<div class="col-md-1"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default">등록</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- update Modal -->
<div class="modal fade" id="update" role="dialog">
	<div class="modal-dialog">
		<form action="<c:url value='/manageController/packageModifyManage'/>" method = "post" enctype="multipart/form-data">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">세트상품 수정</h4>
				</div>
				<div class="modal-body shop-dialog">
					<div class="row">
						<div class="noo-main col-md-12">
							<div id="customer_login">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<div class="form-row form-row-wide">
										<label for="package_name"> 이름 <span class="required">*</span>
										</label> <input type="text" class="input-text" name="name" id="name" />
									</div>
									<div class="form-row form-row-wide">
										<label for="package_price"> 가격 <span class="required">*</span>
										</label> <input type="number" class="input-text" name="price"
											id="price" />
									</div>
									<div class="form-row form-row-wide">
										<label for="package_unit"> 사진 <span class="required">*</span>
										</label> <input type="file" name="file"/>
									</div>
									<div class="form-row form-row-wide">
										<label for="package_unit"> 설명 이미지 <span class="required">*</span>
										</label> <input type="file" name="file"/>
									</div>
									<div class="form-row form-row-wide">
										<label for="reg_password"> 상품검색(이름) <span class="required">*</span>
										</label> <input type="text" class="input-text" name="search2"
											/><input type = "button" value = "검색" name = "productSearch2">
											<div id = "searchResult2"></div>
									</div>
									<div class="form-row form-row-wide">
										<label for="reg_password"> 상품(클릭시 삭제) <span class="required">*</span>
										</label>
										<div id = "select_product2"></div>
									</div>
									<input type = "hidden" name = "no">
									<input type = "hidden" name = "profile">
									<input type = "hidden" name = "desc">
								</div>
								<div class="col-md-1"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default">수정</button>
					<button id = "modify_close" type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</form>
	</div>
</div>