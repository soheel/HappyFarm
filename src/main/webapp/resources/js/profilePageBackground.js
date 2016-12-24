$(function(){

	var body = $('.profile_background');

	//1~4
	var random =  Math.floor(Math.random() * 4) + 1;
	var background = "profile_background" + random;

	body.addClass(background);
});
