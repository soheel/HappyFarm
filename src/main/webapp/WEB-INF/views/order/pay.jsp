<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   

   <!-- 필요한 정보들을 input type = hidden으로 적어서 가져다 사용 -->
   <input id = "no" type = "hidden" value = "${purchase.no}" />
   <input id = "method" type = "hidden" value = "${purchase.method }" />
   <input id = "amount" type = "hidden" value = "${purchase.price - purchase.discount }"/>
   <input id = "totalPrice" type = "hidden" value = "${purchase.price}"/>
   <input id = "email" type = "hidden" value = "${purchase.email }"/>
   <input id = "name" type = "hidden" value = "${purchaseOrder.name }"/>
   <input id = "phone" type = "hidden" value = "${purchaseOrder.phone }"/>
   <input id = "addr" type = "hidden" value = "${addr }"/>
   <input id = "postCode" type = "hidden" value = "${purchaseOrder.postCode }"/>
   <input id = "originalPrice" type = "hidden" value = "${purchase.price }"/>
   <input id = "useMileage" type = "hidden" value = "${purchase.discount }"/>
   
   <section class="noo-page-heading eff heading-6">
   <div class="container">
      <div class="noo-heading-content">
         <h1 class="page-title eff">Shop Detail</h1>
         <div class="noo-page-breadcrumb eff">
            <a href="./" class="home">Organici</a>/<span>Shop Detail</span>
         </div>
      </div>
   </div>
</section>
<div class="main">
   <div class="commerce single-product noo-shop-main ">
      <div class="container">
         <div class="row commerce">
            <form>
               <div class="col-md-12 order_check_border form-row box_shadow" id = "show_pay_complete">
                     
               </div>
               <div class="col-md-12 form-row box_shadow" id = "show_pay_complete2">
                  
               </div>

               <div class="col-md-12 pay_button_space">
                  <input type="button" value="주문확인" onclick="location.href='<c:url value="/"/>'" class="pay_button">   
               </div>
            </form>
         </div>

<script type="text/javascript">
   window.onload = function() {
      
      // 입력 정보
      var no = document.getElementById("no").value;
      var method = document.getElementById("method").value;
      var amount = document.getElementById("amount").value;
      var totalPrice = document.getElementById("totalPrice").value;
      var email = document.getElementById("email").value;
      var name = document.getElementById("name").value;
      var phone = document.getElementById("phone").value;
      var addr = document.getElementById("addr").value;
      var postCode = document.getElementById("postCode").value;
      var useMileage = document.getElementById("useMileage").value;
      
      
         
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
              var msg = '<label class="pay_title"><span class="pay_enlargement">결제가</span> 완료되었습니다.</label>';
              msg += "<table class='pay_table'>";
              msg += "<tr>";
              msg += '<th style="width=20%">결제 금액 : </th><td>' + rsp.paid_amount + '</td>';
              msg += "</tr>";
              
              msg += "<tr>";
              msg += '<th>구매상품 번호 : </th><td>' + no + '</td>';
              msg += "</tr>";
              
              // 결제 수단에 따라 다른 메시지 출력
              var method = rsp.pay_method;
              if(method == 'card') {
                 msg += '카드사 승인번호 : ' + rsp.apply_num + '<br>';
                 alert(msg);
                 location.href = "<c:url value = '/userProductController/payComplete'/>?no=" + no;
              }else if(method == 'vbank') {
                 var bankNum=rsp.vbank_num;
                 var bankName = rsp.vbank_name;
                 var bankHolder = rsp.vbank_holder;
                 var bank
                 
                 /* 결제 완료 후 문자 전송 */
                 $.ajax({
                   url:"<c:url value = '/userProductController/paySendSms'/>",
                   type : "post",
                   data : { "name" : name, "phone" : phone, "bankNum" : bankNum,
                      "bankName" : bankName, "bankHolder" : bankHolder}
                })
               
                /*
                결제 완료 후 마일리지 차감
                및 결제함으로써 마일리지 적립
                */
                $.ajax({
                  url : "<c:url value = '/userProductController/reduceMileage'/>",
                  type : "post",
                  data : "useMileage=" + document.getElementById("useMileage").value
                })
               msg += "<tr>";
                 msg += '<th>가상계좌 입금 계좌번호 : </th><td>' + rsp.vbank_num + '</td>';
                 msg += "</tr>";
                 
                 msg += "<tr>";
                 msg += '<th>가상계좌 은행명 : </th><td>' + rsp.vbank_name + '</td>';
                 msg += "</tr>";
                 
                 msg += "<tr>";
                 msg += '<th>가상계좌 예금주 : </th><td>' + rsp.vbank_holder + '</td>';
                 msg += "</tr>";
                 
                 msg += "<tr>";
                 msg += '<th>가상계좌 입금기한 : </th><td>' + rsp.vbank_date + '</td>';
                 msg += "</tr>";
                 msg += "</table>";
                 
                 var msg2 = "<label class='pay_title'><span class='pay_enlargement'>배송지</span> 정보 확인</label>";
                 
                 msg2 += "<table class='pay_table'>";
                 
                 msg2 += '<tr>';
                 msg2 += '<th style="width=20%">수취인 : </th><td>' + name + '</td>';
                 msg2 += '</tr>';
                 
                 msg2 += '<tr>';
                 msg2 += '<th>주소 : </th><td>' + addr + '</td>';
                 msg2 += '</tr>';
                 
                 msg2 += '<tr>';
                 msg2 += '<th>연락처 : </th><td>' + phone + '</td>';
                 msg2 += '</tr>';
                 
                 msg2 += '</table>';
                 
              }else { // phone, trans
                 location.href = "<c:url value = '/userProductController/payComplete'/>";
              }
              document.getElementById("show_pay_complete").innerHTML = msg;
              document.getElementById("show_pay_complete2").innerHTML = msg2;
                               
              
          } else {
              var msg = '결제에 실패하였습니다.';
              msg += '에러내용 : ' + rsp.error_msg;
              alert(msg);
          }
          
      });
   }
</script>