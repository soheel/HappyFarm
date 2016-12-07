$(function(){

	var $categories_title = $(".shop_side #categories-title");
	var $categories_list = $(".shop_side .product-categories");
	var $shop_categories_btn = $(".shop_categories_btn");
	var type = true;


	$categories_list.hide();


	$categories_title.click(function()
	{
		if(type == true)
		{
			type = !type;
			$shop_categories_btn.css({
				"-webkit-transform": "rotate(180deg)", 
			  	"-moz-transform": "rotate(180deg)", 
			  	"-o-transform": "rotate(180deg)",
			  	"-ms-transform": "rotate(180deg)",
			  	"transform": "rotate(180deg)"
			});
			$categories_list.slideDown();	
		}
		else if(type == false)
		{
			type = !type;
			$shop_categories_btn.css({
				"-webkit-transform": "rotate(0deg)", 
			  	"-moz-transform": "rotate(0deg)", 
			  	"-o-transform": "rotate(0deg)",
			  	"-ms-transform": "rotate(0deg)",
			  	"transform": "rotate(0deg)"
			});
			$categories_list.slideUp();
		}
	});
});	