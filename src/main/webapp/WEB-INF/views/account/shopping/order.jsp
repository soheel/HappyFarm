<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>주문/배송 조회</h2>
<input type="button" value="전체" name="id">
<input type="button" value="3개월" name="three_month">
<input type="button" value="6개월" name="six_month">
<input type="button" value="1년" name="year_month">
<table class="table">
	<thead>
		<tr>
			<th>&nbsp;</th>
			<th>주문일자</th>
			<th>주문상품정보</th>
			<th>상품금액(수량)</th>
			<th>배송비(판매자)</th>
			<th>현상태</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><input type="checkbox" name="box"/></td>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr class="warning">
			<td><input type="checkbox" name="box"/></td>
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="box"/></td>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr class="warning">
			<td><input type="checkbox" name="box"/></td>
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="box"/></td>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr class="warning">
			<td><input type="checkbox" name="box"/></td>
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="box"/></td>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr class="warning">
			<td><input type="checkbox" name="box"/></td>
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="box"/></td>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
		<tr class="warning">
			<td><input type="checkbox" name="box"/></td>
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
			<td>결제완료</td>
		</tr>
	</tbody>
</table>
<input type="button" value="환불/반품/교환" name="order-action">
<input type="button" value="취소" name="cancel">