<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="adminMain">
	<div class="row">
		<div class="col-md-12">
			<!-- button 영역 -->
			<div class="col-md-4">
				<a href="<c:url value="/manageController/productManage"/>">
					<div class="admin-btn admin-color-royalblue">개별 상품 관리</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="<c:url value="/admin/packageItem"/>">
					<div class="admin-btn admin-color-blueviolet">세트 상품 관리</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="<c:url value="/admin/producer"/>">
					<div class="admin-btn admin-color-greenyellow">생산자 관리</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="<c:url value="/admin/donate"/>">
					<div class="admin-btn admin-color-chocolate">기부 업체 관리</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="<c:url value="/admin/sales/total"/>">
					<div class="admin-btn admin-color-peru">매출 관리</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="<c:url value="/admin/user"/>">
					<div class="admin-btn admin-color-dimgray">회원 관리</div>
				</a>
			</div>
			<div class="col-md-6">
				<a href="<c:url value="/admin/cummunity"/>">
					<div class="admin-btn admin-color-mediumorchid">Community 관리</div>
				</a>
			</div>
			<div class="col-md-6">
				<a href="<c:url value="/admin/qna"/>">
					<div class="admin-btn admin-color-greenyellow">Q&A 관리</div>
				</a>
			</div>
		</div>
	</div>
</div>