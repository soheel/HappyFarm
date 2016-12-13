$(function() {
	$("textarea.qna-question-area").keyup(function () {
		$(this).css("height","1px").css("height",(20+$(this).prop("scrollHeight"))+"px");	
	});
});