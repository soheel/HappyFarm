<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<section class="noo-page-heading eff heading-3">
			<div class="container">
				<div class="noo-heading-content">
					<h1 class="page-title eff">QnA Page</h1>
					<div class="noo-page-breadcrumb eff">
						<a href="./" class="home">Organici</a>/<span>QnA</span>
					</div>
				</div>
			</div>
	</section>
	
	<div class="main">
		<div class="container">
			<div class="first_content">
				<div class="qna_title">
					<span>Q&A</span>
				</div>
				<div class="related products qna_board">
					<form action="" method="post">
						 <div class="form-group">
  							<label for="comment">Question : </label>
 							<textarea class="form-control qna-question-area" rows="1" id="comment" name="desc" style="resize: vertical"></textarea>
 							<input type="button" class="btn btn-success" id="qnaRegisterBtn" value="등록"/>
						</div>
					</form>
				</div>
			</div>
			
			
			<div class="last_content">
				<div class="qna_title">
					<span>Q&A 내역</span>
				</div>
				<div class="related products qna_board">
					<div class="panel-group" id="accordion">
    					
    					<c:forEach items="${qnaList}" var="qna" varStatus="status">
    					
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse${status.count}">${qna.desc}</a>
        						</h4>
      						</div>
      						<c:choose>
      							<c:when test="${qna.answerState eq'N'}">
      								<div id="collapse${status.count}" class="panel-collapse collapse">
      									<div class="panel-body">답변이 달려있지 않습니다.</div>
      								</div>
      							</c:when>
      							<c:otherwise>
      							<c:forEach items="${answerList}" var="answer" >
      							<c:if test="${answerList}">
      								<div id="collapse${status.count}" class="panel-collapse collapse">
        								<div class="panel-body">${state.index}</div>
      								</div>
      								</c:if>
      								</c:forEach>
      							</c:otherwise>
      						</c:choose>
      						
    					</div>
    					
    					</c:forEach>
    					
  					</div> 
				</div>
			</div>
		</div>			
	</div>
	
	<div class="noo-footer-shop-now">
		<div class="container">
			<div class="col-md-7">
				<h4>- Every day fresh -</h4>
				<h3>organic food</h3>
			</div>
			<img src="<c:url value="/resources/img/footer/"/>organici-love-me.png" class="noo-image-footer" alt="" />
		</div>
	</div>