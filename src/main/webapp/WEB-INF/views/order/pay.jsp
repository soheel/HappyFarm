<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	

	<!-- 필요한 정보들을 input type = hidden으로 적어서 가져다 사용 -->
	<input id = "no" type = "hidden" value = "${purchase.no}" />
	<input id = "method" type = "hidden" value = "${purchase.method }" />
	<input id = "amount" type = "hidden" value = "${purchase.price - purchase.discount }"/>
	<input id = "email" type = "hidden" value = "${purchase.email }"/>
	<input id = "name" type = "hidden" value = "${purchaseOrder.name }"/>
	<input id = "phone" type = "hidden" value = "${purchaseOrder.phone }"/>
	<input id = "addr" type = "hidden" value = "${addr }"/>
	<input id = "postCode" type = "hidden" value = "${purchaseOrder.postCode }"/>
	
	<!-- 결제 결과 -->
	<div style = "border : 1px inset black;" class = "container">
		<span id = "show_pay_complete"></span>
	</div>
<script type="text/javascript">
	window.onload = function() {
		
		// 입력 정보
		var no = document.getElementById("no").value;
		var method = document.getElementById("method").value;
		var amount = document.getElementById("amount").value;
		var email = document.getElementById("email").value;
		var name = document.getElementById("name").value;
		var phone = document.getElementById("phone").value;
		var addr = document.getElementById("addr").value;
		var postCode = document.getElementById("postCode").value;
		
		var IMP = window.IMP; // 생략가능
		IMP.init('imp88265207'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

		IMP.request_pay({
		    pay_method : method,
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '결제',
		    amount : parseFloat(amount),
		    buyer_email : 'a',
		    buyer_name : name,
		    buyer_tel : phone,
		    buyer_addr : addr,
		    buyer_postcode : postCode,
		}, function(rsp) {
		    if ( rsp.success ) { // 결제 승인 or 가상계좌 발급 성공
		        var msg = '결제가 완료되었습니다.<br><hr>';
		        msg += '결제 금액 : ' + rsp.paid_amount + '<br>';
		        msg += '구매상품 번호 : ' + no + '<br>';
		        
		        // 결제 수단에 따라 다른 메시지 출력
		        var method = rsp.pay_method;
		        if(method == 'card') {
		        	msg += '카드사 승인번호 : ' + rsp.apply_num + '<br>';
		        	alert(msg);
			        location.href = "<c:url value = '/userProductController/payComplete'/>";
		        }else if(method == 'vbank') {
		        	msg += '가상계좌 입금 계좌번호 : ' + rsp.vbank_num + '<br>';
		        	msg += '가상계좌 은행명 : ' + rsp.vbank_name + '<br>';
		        	msg += '가상계좌 예금주 : ' + rsp.vbank_holder + '<br>';
		        	msg += '가상계좌 입금기한 : ' + rsp.vbank_date + '<br>';
		        	
		        }else { // phone, trans
			        location.href = "<c:url value = '/userProductController/payComplete'/>";
		        }
		        document.getElementById("show_pay_complete").innerHTML = msg;

		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		        alert(msg);
		    }
		    
		});
	}

</script>