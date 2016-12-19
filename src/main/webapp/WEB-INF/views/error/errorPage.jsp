<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<link rel='stylesheet' href='<c:url value="/resources/css/"/>bootstrap.min.css' type='text/css' media='all' />
<link rel='stylesheet' href='<c:url value="/resources/css/"/>errorPage.css' type='text/css' media='all' />
</head>
<body>
	<div class="container" id="errorView" >
		<div class="row col-md-12">
			<div class="col-md-1"></div>
			<div class="col-md-5 error_content">
				<p>error</p>
				<p>이런 길을 잘못 찾아오신 것 같은데요..</p>
				<input type="button" onclick="window.history.back()" value="뒤로가기">
			</div>
			<div class="col-md-5 error_img">
				<img alt="에러 이미지" src='<c:url value="/resources/img/error/"/>error_logo.png'>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>