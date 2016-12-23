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
						 	<input style = "border-radius : 5%; height : 30px;" type = "text" placeholder = "  제목을 입력하세요" id = "qnaTitle"><br><br>
 							<textarea class="form-control qna-question-area" rows="1" id="comment" name="desc" style="resize: vertical" placeholder = "내용을 입력하세요"></textarea>
 							<div style = "text-align : right;">비밀번호 : <input type = "password"  placeholder = "*******" id = "qnaPassword" name = "pwd"></div>
 							<input type="button" class="btn btn-success" id="qnaRegisterBtn" value="등록"/>
						</div>
					</form>
				</div>
			</div>
			
			<div class="last_content">
				<table id = "qnaTable">
					<thead>
						<th width = "10%">글번호</th>
						<th width = "70%">글제목</th>
						<th width = "10%">작성자</th>
						<th width = "10%">작성일</th>
					</thead>
					
					<tbody>
					<c:forEach items="${qnaList }"  var="list">
						 <tr>
						 	<td>
						 		${list.no }
						 	</td>
						 	<td>
						 		<span name = "qnaName" value = "${list.no }">${list.name }</span>
						 	</td>
						 	<td>
						 		${list.email }
						 	</td>
						 	<td>
						 		${list.registerdate }
						 	</td>
						 </tr>
					</c:forEach>
				</tbody>
				</table>
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