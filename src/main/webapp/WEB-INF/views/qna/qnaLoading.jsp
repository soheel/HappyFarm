<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
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
 							<textarea class="form-control" rows="5" id="comment" name="question"></textarea>
 							<input type="button" class="btn btn-success" value="등록"/>
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
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">상품 결제와 동시에 기부가 이루어지나요???</a>
        						</h4>
      						</div>
      						<div id="collapse1" class="panel-collapse collapse in">
        						<div class="panel-body">네~ 그렇습니다..</div>
      						</div>
    					</div>
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse2">상품 결제와 동시에 기부가 이루어지나요???</a>
        						</h4>
      						</div>
      						<div id="collapse2" class="panel-collapse collapse">
        						<div class="panel-body">네~ 그렇습니다..</div>
      						</div>
    					</div>
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse3">상품 결제와 동시에 기부가 이루어지나요???</a>
        						</h4>
      						</div>
      						<div id="collapse3" class="panel-collapse collapse">
        						<div class="panel-body">네~ 그렇습니다..</div>
      						</div>
    					</div>
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse4">상품 결제와 동시에 기부가 이루어지나요???</a>
        						</h4>
      						</div>
      						<div id="collapse4" class="panel-collapse collapse">
        						<div class="panel-body">네~ 그렇습니다..</div>
      						</div>
    					</div>
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse5">상품 결제와 동시에 기부가 이루어지나요???</a>
        						</h4>
      						</div>
      						<div id="collapse5" class="panel-collapse collapse">
        						<div class="panel-body">네~ 그렇습니다..</div>
      						</div>
    					</div>
    					<div class="panel panel-info">
      						<div class="panel-heading">
        						<h4 class="panel-title">
          							<a data-toggle="collapse" data-parent="#accordion" href="#collapse6">상품 결제와 동시에 기부가 이루어지나요???</a>
        						</h4>
      						</div>
      						<div id="collapse6" class="panel-collapse collapse">
        						<div class="panel-body">네~ 그렇습니다..</div>
      						</div>
    					</div>
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
			<img src="<c:url value="/resources/images/"/>organici-love-me.png" class="noo-image-footer" alt="" />
		</div>
	</div>
</body>
</html>