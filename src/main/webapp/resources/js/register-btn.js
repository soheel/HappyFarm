$(function(){

	var $registerBtn = $("form.login div.form-row input[name='Register']");

	$registerBtn.click(function(){
		document.location.href = "login/register";	
	})
});