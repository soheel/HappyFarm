$(document).ready(function() {

	var trigger = $('.hamburger');
	var overlay = $('.overlay');
	var isClosed = false;

	var rootPath = window.location.host + "/controller/";
	var $infoView = $('#page-content-wrapper .container');

	trigger.click(function() {
		hamburger_cross();
	});

	function hamburger_cross() {

		if (isClosed == true) {
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
		} else {
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		}
	}

	$('[data-toggle="offcanvas"]').click(function() {
		$('#wrapper').toggleClass('toggled');
	});

	$('input[name="order-action"]').click(function() {
		$("#order-dialog").show();
	});	
	
	$('#order-dialog input[name="cancel"]').click(function(){
		$("#order-dialog").hide();
	})
	
	
	var $qnaTable = $(".my_info_qna_table tr:nth-child(2n-1)");

	$qnaTable.click(function(){

		var $tr = $(this).next('tr');

		if($tr.is(":hidden")){
			$tr.show();	
		}else{
			$tr.hide();
		}
		
	});
});