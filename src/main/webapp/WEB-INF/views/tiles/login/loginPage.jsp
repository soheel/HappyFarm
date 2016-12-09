<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<title>Login Page</title>

		<link rel='stylesheet' href='<c:url value="/resources/css/"/>bootstrap.min.css' type='text/css' media='all' />
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>prettyPhoto.css' type='text/css' media='all' />
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.carousel.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>owl.theme.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>font-awesome.min.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Lato.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Pacifico.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Anonymous+Pro.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>Roboto.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>style.css' type='text/css' media='all'/>
		<link rel='stylesheet' href='<c:url value="/resources/css/"/>custom.css' type='text/css' media='all'/>
		<link rel="stylesheet" href='<c:url value="/resources/css/"/>magnific-popup.css' type='text/css' media='all' />
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>bootstrap.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery-migrate.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>modernizr-2.7.1.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>off-cavnass.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>script.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>custom.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>imagesloaded.pkgd.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>isotope.pkgd.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>portfolio.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.touchSwipe.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.carouFredSel-6.2.1.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.isotope.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>owl.carousel.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jflickrfeed.min.js'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.magnific-popup.js'></script>
	
	<script type="text/javascript">
	$(function(){

		/* 회원가입 페이지로 이동 */
		var $registerBtn = $("form.login div.form-row input[name='Register']");

		$registerBtn.click(function(){
			document.location.href = "<c:url value='/userInfoController/registerPage'/>";	
		})
		
		/* 이메일 중복 체크 */
		$("#reg_email").keyup(function() {
			if($(this).val() == ""){
				$("#emailCheck").text("*");
			}else {
				$.ajax({
					url : "<c:url value = '/userInfoController/idCheck'/>",
					type : "post",
					data : "email=" + $(this).val(),
					dataType : "text",
					success : function(result) {
						if(result == 'true') {
							$("#emailCheck").text("해당 아이디가 존재합니다.");
						}else {
							$("#emailCheck").text("사용 가능합니다.");
						}
					},
					error : function(err) {
						alert("err : " + err);
					}
				})
			}
			
		})
		
		
		/* 추천인 아이디 체크 */
		$("#recommandInput").keyup(function() {
			if($(this).val() == ""){
				$("#recommandCheck").text("*");
			}else {
				$.ajax({
					url : "<c:url value = '/userInfoController/recommandIdCheck'/>",
					type : "post",
					data : "email=" + $(this).val(),
					dataType : "text",
					success : function(result) {
						if(result == 'true') {
							$("#recommandCheck").text("해당 회원이 존재합니다.");
						}else {
							$("#recommandCheck").text("해당 회원이 존재하지 않습니다.");
						}
					},
					error : function(err) {
						alert("err : " + err);
					}
				})
			}
			
		})
		
		
	});
	</script>
</body>
</html>