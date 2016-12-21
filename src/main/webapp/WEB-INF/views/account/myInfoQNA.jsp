<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>Q&A</h2>
<table class="table my_info_qna_table">
	<thead>
		<tr>
			<th>문의내용</th>
			<th>등록일</th>
			<th>답변</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${empty list}">
		<tr>
		<td colspan='3'>
			 <p align="center"><b><span style="font-size:9pt;">현재 등록된 질문이 없습니다.</span></b></p>
		</td>
		</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="list" varStatus="asd" >

				<tr class="warning"  id='appendTr'>
					<td>${list.desc}</td>
					<td>  
					<fmt:parseDate value="${list.registerdate}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>  
					<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>  
					</td>   
					
					<td><span id="showAnswerByNumber" value='${list.no}'>${list.answerState}</span></td>
				</tr>
				<tr></tr>
							
			</c:forEach>
		</c:otherwise>
	</c:choose>	
	
	</tbody>
</table>