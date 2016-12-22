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
		<link rel="stylesheet" href="<c:url value="/resources/css/"/>nanumgothic.css" type="text/css" media="all"/>
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
		
		var recommandIdExist = 0;
		/* 추천인 아이디 체크 */
		$("#recommandInput").keyup(function() {
			if($(this).val() == ""){
				$("#recommandCheck").text("해당 회원이 존재하지 않습니다.");
			}else {
				$.ajax({
					url : "<c:url value = '/userInfoController/recommandIdCheck'/>",
					type : "post",
					data : "email=" + $(this).val(),
					dataType : "text",
					success : function(result) {
						if(result == 'true') {
							$("#recommandCheck").text("해당 회원이 존재합니다.");
							recommandIdExist = 1;
						}else {
							$("#recommandCheck").text("해당 회원이 존재하지 않습니다.");
							recommandIdExist = 0;
						}
					},
					error : function(err) {
						alert("err : " + err);
					}
				})
			}
			
		})
		
		/* 회원가입 버튼 눌렀을 때 */
		$("#registerButton").click(function() {
			if($("#reg_email").val() == "") {
				alert("이메일을 입력하세요");
			}else if($("#reg_password").val() == ""){
				alert("비밀번호를 입력하세요");
			}else if($("#reg_name").val() == "") {
				alert("이름을 입력하세요");
			}else if($("#reg_phone").val() == "") {
				alert("연락처를 입력하세요");
			}else if(recommandIdExist == 0 && $("#recommandInput").val() != "") {
				alert("해당 추천인이 존재하지 않습니다");
			}
			else{
				$.ajax({
					url : "<c:url value = '/userInfoController/register'/>",
					type : "post",
					data : "email=" + $("#reg_email").val() + "&pwd=" + $("#reg_password").val() + "&name=" + $("#reg_name").val() + "&phone=" + $("#reg_phone").val() + "&recommand=" + $("#recommandInput").val(),
					dataType : "text",
					success : function(result) {
						if(result >= 1) {
							alert("회원가입을 축하드립니다!");
							location.href = "<c:url value = '/userInfoController/loginPage'/>"
						}else {
							alert("회원가입에 실패하였습니다.");
						}
					},
					error : function(err) {
						alert("회원가입에 실패하였습니다.");
					}
				})
			}
			
		})
		
		/* 이메일 찾기 */
		$("#searchIdButton").click(function() {
			alert(1);
			$.ajax({
				url : "<c:url value = '/userInfoController/searchId'/>",
				type : "post",
				data : "name=" + $("#name").val() + "&phone=" + $("#phone").val(),
				dataType : "text",
				success : function(result) {
					$("#searchIdBox").text("Email : " + result);
				},
				error : function(err) {
					alert("존재하지 않는 회원입니다.");
				}
			})
		})
		
		/* 비밀번호 찾기 */
		$("#searchPwdButton").click(function() {
			$.ajax({
				url : "<c:url value = '/userInfoController/searchPwd'/>",
				type : "post",
				data : "email=" + $("#email").val(),
				dataType : "text",
				success : function(result) {
					$("#searchIdBox").text("비밀번호는 " + result +"입니다.");
				},
				error : function(err) {
					alert("존재하지 않는 회원입니다.");
				}
			})
		})
		
	});
	</script>
</body>
</html>