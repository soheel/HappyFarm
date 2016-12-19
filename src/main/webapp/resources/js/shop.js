$(function(){
	
	var $cer_img = $('.certification_img img');
	var $cer_form = $('.certification_form');
	var $cer_exit_btn = $('.certification_form .cetication_title .certification_form_exit');
	
	$cer_exit_btn.click(function(){
		
		if($cer_form.is(":hidden")){
			$cer_form.slideDown();
		}else{
			$cer_form.slideUp();
		}
		
	});
	
	$cer_img.click(function(){
		
		if($cer_form.is(":hidden")){
			$cer_form.slideDown();
		}else{
			$cer_form.slideUp();
		}
		
	});
});