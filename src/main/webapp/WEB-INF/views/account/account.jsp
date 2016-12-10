<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2>나의 마일리지</h2>
<table class="table">
	<tr>
	 <th>현재 나의 마일리지</th>
	 <c:forEach items="memberDto" var="memberDto">
	 <td>${memberDto.mileage} </td>
	 </c:forEach>
	</tr>

</table>
<hr>
<h2>진행중인주문</h2>
<table class="table">
	<thead>
		<tr>
			<th>주문일자</th>
			<th>주문상품정보</th>
			<th>상품금액(수량)</th>
			<th>배송비(판매자)</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr class="warning">
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr class="warning">
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr class="warning">
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr class="warning">
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr>
			<td>Default</td>
			<td>Defaultson</td>
			<td>def@somemail.com</td>
			<td>def@somemail.com</td>
		</tr>
		<tr class="warning">
			<td>Warning</td>
			<td>Refs</td>
			<td>bo@example.com</td>
			<td>def@somemail.com</td>
		</tr>
	</tbody>
</table>
