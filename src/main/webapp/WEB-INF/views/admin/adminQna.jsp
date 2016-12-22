<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h4 class="modal-title">Q&amp;A</h4>
<div class="panel-group">

	<c:forEach items="${qnalist}" var="qna" varStatus="state">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
					<span> <input type="checkbox" name="checkAnswer"> <a
						data-toggle="collapse" href="#collapse${state.index}" class="question">${qna.desc}</a>
					</span>
				</div>
			</div>
				<form action="<c:url value='/manageController/qnaRegisterManage' />" method="post">
			<div id="collapse${state.index}" class="panel-collapse collapse">
					<div class="panel-body">
					<input type='hidden' id='no' value='${qna.no}'>
						<textarea id='desc'></textarea>
					</div>
					<div class="panel-footer">
						<input type="submit" id="registerAnswer" value="등록">
					</div>
			</div>
				</form>
		</div>
	</c:forEach>



	<input type="button" value="삭제" name="delete_btn">
</div>