<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container profile_view">
<h4 class="modal-title">Q&amp;A</h4>
	<div class="panel-group">
		<c:forEach items="${qnalist}" var="qna" varStatus="state">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<span style = "color : red">[글No] ${qna.no} <a href = "<c:url value = '/manageController/qnaDeleteManage?no=${qna.no }'/>"> [삭제]</a></span><hr>
						<span>[제목] <a data-toggle="collapse" href="#collapse${state.index}" class="question">${qna.name}</a></span><hr>
						<span>[등록일] ${qna.registerdate }</span><hr>
						<span>[내용] ${qna.desc }</span>
					</div>
				</div>
					<form action="<c:url value='/manageController/qnaRegisterManage' />" method="post">
						<div id="collapse${state.index}" class="panel-collapse collapse">
						<div class="panel-body">
						<input type='hidden' name='no' value='${qna.no}'>
						<input type='hidden' name='name' value='${qna.name}'>
							<textarea name = "desc" id='desc'></textarea>
						</div>
						<div class="panel-footer">
							<input type="submit" id="registerAnswer" value="등록">
						</div>
						</div>
					</form>
			</div>
			<br>
		</c:forEach>
		<c:if test="${fn:length(qnalist) eq 0}">
			미답변 질문이 없습니다.
		</c:if>
	</div>
</div>