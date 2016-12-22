$(function(){

	var $replyBtn = $('span.comment-reply a.comment-reply-link');
	var $replyCancleBtn = $('span.comment-reply a.comment-replyCancle-link');
	var $deleteBtn = $('span.comment-reply a.comment-delete-link');
	var $updateBtn = $('span.comment-reply a.comment-update-link');
	var $updateCancleBtn = $('span.comment-reply a.comment-updateCancle-link');
	
	/**
	 * request
	 */
	function Request()
	{
	    this.getParameter = function( name )
	    {
	        var rtnval = "";
	        var nowAddress = unescape(location.href);
	        var parameters = (nowAddress.slice(nowAddress.indexOf("?")+1,nowAddress.length)).split("&");
	 
	        for(var i = 0 ; i < parameters.length ; i++)
	        {
	            var varName = parameters[i].split("=")[0];
	            if(varName.toUpperCase() == name.toUpperCase())
	            {
	                rtnval = parameters[i].split("=")[1];
	                break;
	            }
	        }
	        return rtnval;
	    }
	}


	/**
	 * 어드민 덧글 입력 열기
	 */
	$replyBtn.on('click', function(){
		
		var request = new Request();
		
		/**
		 * 덧글을 쓸 글 번호
		 */
		var $no = $(this).parents().siblings('input[name=no]').val();
		
		/**
		 * 게시글 번호
		 */
		var $communityNo = request.getParameter("no");
		
		console.log("reply 게시글 번호 : " + $communityNo + ", 덧글 번호 : " + $no);


		var $command = $(this).parents('.comment-block');
		var commandArea = '<div id="respond" class="comment-respond reply">' 
							+ '<form id="communityReplyInsert" class="comment-form" action="" method="post">'
							+ '<input type="hidden" name="communityNo" value="' + $communityNo +'">'
							+ '<input type="hidden" name="no" value="' + $no +'">'
							+ '<div class="row">' 
							+ '<div class="col-sm-12">' 
							+ '<div class="comment-form-comment">'
							+ '<textarea class="form-control" placeholder="Enter Your Comment" id="comment" name="comment" cols="40" rows="6"></textarea>'
							+ '</div>' 
							+ '</div>' 
							+ '</div>' 
							+ '<div class="form-submit">' 
							+ '<input name="button" type="button" id="communityReplyInsertButton" class="submit" value="Post Comments" />'
							+ '</div>' 
							+ '</form>' 
							+ '</div>';

		$command.append(commandArea);
		$(this).hide();
		$(this).siblings('a.comment-replyCancle-link').show();
	});
	
	
	
	
	
	/**
	 * 어드민 덧글 작성 버튼
	 */
	$(document).on("click", "#communityReplyInsertButton", function(){
		
		var $formDate = $("#communityReplyInsert").serialize();
		
		$.post("communityReplyInsert", $formDate, function(result){
			if(result == 0){
				var url = "../userInfoController/loginPage";
				
				$(location).attr('href', url);
			}else{
				location.reload();
			}
		});
	});
	
	
	
	
	/**
	 * 어드민 덧글 달기 취소
	 */
	$replyCancleBtn.on('click', function(){
		var $command = $(this).parents('.comment-block').find('#respond');
		
		$command.remove();
		$(this).hide();
		$(this).siblings('a.comment-reply-link').show();
	});
	
	
	
	
	
	/**
	 * 덧글 삭제
	 */
	$deleteBtn.on('click', function(){

		/**
		 * 글 번호
		 */
		var $no = $(this).parents().siblings('input[name=no]').val();
		console.log("delete : " + $no);

		var message = "덧글을 삭제하시겠습니까?";

		if(!confirm(message)){
			return;
		}else{
			$.post("communityReplyDelete", {no:$no}, function(result){
				if(result == 0){
					var url = "../userInfoController/loginPage";
					
					$(location).attr('href', url);
				}else{
					location.reload();
				}
			});
		}
	});

	
	
	
	
	
	

	/**
	 * 덧글 수정
	 */
	$updateBtn.on('click', function(){
		
		/**
		 * 글 번호
		 */
		var $no = $(this).parents().siblings('input[name=no]').val();
		
		var $command = $(this).parents('.comment-block');
		var $content = $(this).parents().siblings('.comment-content').find('p').text();
		console.log("update : " + $no + ", content : " + $content);
		
		var commandArea = '<div id="respond" class="comment-respond reply">' 
							+ '<form id="communityReplyUpdate" class="comment-form" action="" method="post">' 
							+ '<input type="hidden" name="no" value="' + $no +'">'
							+ '<div class="row">' 
							+ '<div class="col-sm-12">' 
							+ '<div class="comment-form-comment">'
							+ '<textarea class="form-control" placeholder="Enter Your Comment" id="comment" name="comment" cols="40" rows="6">'
							+ $content 
							+ '</textarea>'
							+ '</div>' 
							+ '</div>' 
							+ '</div>' 
							+ '<div class="form-submit">' 
							+ '<input name="button" type="button" id="communityReplyUpdateButton" class="submit" value="Post Comments" />'
							+ '</div>' 
							+ '</form>' 
							+ '</div>';

		$command.append(commandArea);
		$(this).hide();
		$(this).siblings('a.comment-updateCancle-link').show();
	});
	
	
	
	/**
	 * 덧글 수정 버튼
	 */
	$(document).on('click', '#communityReplyUpdateButton', function(){
		
		var $formDate = $("#communityReplyUpdate").serialize();
		
		$.post("communityReplyUpdate", $formDate, function(result){
			if(result == 0){
				var url = "../userInfoController/loginPage";
				
				$(location).attr('href', url);
			}else{
				location.reload();
			}
		});
	});
	
	
	/**
	 * 덧글 수정 취소
	 */
	$updateCancleBtn.on('click', function(){
		var $command = $(this).parents('.comment-block').find('#respond');
		
		$command.remove();
		$(this).hide();
		$(this).siblings('a.comment-update-link').show();
	});
	
	
	/**
	 * 일반 댓글 작성
	 */
	$('#communityReplyButton').click(function(){
		
		var request = new Request();
		
		/**
		 * 게시글 번호
		 */
		var $communityNo = request.getParameter("no");
		var $formDate = $("#communityReply").serialize();
		var data = $formDate + "&communityNo=" + $communityNo;
		
		$.post("communityReply", data, function(result){
			if(result == 0){
				var url = "../userInfoController/loginPage";
				
				$(location).attr('href', url);
			}else{
				location.reload();
			}
		});
	});
});