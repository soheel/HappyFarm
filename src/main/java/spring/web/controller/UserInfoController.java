package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userinfo")
@RequestMapping("/user")
public class UserInfoController {
	
	/**
	 * 로고 눌렀을 때
	 * */
	@RequestMapping("logo")
	public void logo() {
		
	}
	
	/**
	 * 회원가입
	 * */
	@RequestMapping("register")
	public void register(){
		
	}
	
	/**
	 * 계정찾기(id)
	 * */
	@RequestMapping("searchId")
	public void searchId() {
		
	}
	
	/**
	 * 계정찾기(pwd)
	 * 지정된 메일로 인증코드 보내기(ajax)
	 * */
	@RequestMapping("searchPwdSendCode")
	public void searchPwdSendCode() {
		
	}
	
	/**
	 * 계정찾기(pwd)
	 * 인증코드 확인
	 * 인증코드 맞으면 아래에 비밀번호 띄워주기(ajax)
	 * */
	@RequestMapping("searchPwdConfirm")
	public void searchPwdConfirm() {
		
	}
	
	/**
	 * 로그인
	 * 만약 아이디가 admin이면 관리자 페이지 로딩
	 * */
	@RequestMapping("login")
	public void login() {
		
	}
	
	/**
	 * 로그아웃
	 * */
	@RequestMapping("logout")
	public void logout() {
		
	}
	
	 /**
	  * id 중복확인 (ajax)
	  * */
	@RequestMapping("idCheck")
	public void idCheck() {
		
	}
	
	/**
	  * 추천인 id 중복확인 (ajax)
	  * */
	@RequestMapping("recommandIdCheck")
	public void recommandIdCheck() {
		
	}
	
	// 내정보
	
	/**
	 * 내정보 버튼 클릭했을 때, 첫 화면 로딩
	 * 마일리지, 진행중인주문내역 가져오기
	 * */
	@RequestMapping("myPageLoading")
	public void myPageLoading() {
		
	}
	
	/**
	 * 조회에관한 12가지 기능별 처리
	 * */
	@RequestMapping("showButton")
	public void showButton(String value) {
		
	}
	
	/**
	 * 내정보에서 쇼핑내역 눌렀을 때
	 * 자도으로 주문/배송 조회 클릭됨
	 * 처음에는 3개월까지만 주문내역을 가져오기
	 * */
	@RequestMapping("myPageOrderList")
	public void myPageOrderList() {
		
	}
	
	/**
	 * 주문/배송 조회에서 환불/반품/교환 버튼 클릭했을 때
	 * 새창으로 폼 띄워주기
	 * */
	@RequestMapping("requestRefundButton")
	public void requestRefundButton() {
		
	}
	
	/**
	 * 환불/반품/교환 폼에서 사유적어서 신청하기
	 * */
	@RequestMapping("requestRefund")
	public void requestRefund() {
		
	}
	
	/**
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때
	 * 목록삭제(ajax)
	 * */
	@RequestMapping("requestCancelButton")
	public void requestCancelButton() {
		
	}
	
	/**
	 * 내정보에서 취소/반품/교환 버튼 클릭했을 때
	 * 처음에는 3개월까지만 주문내역을 가져오기
	 * */
	@RequestMapping("myPageCancelList")
	public void myPageCancelList() {
		
	}
	
	/**
	 * 내정보에서 환불 버튼 클릭했을 때
	 * 처음에는 3개월까지만 주문내역을 가져오기
	 * */
	@RequestMapping("myPageRefundList")
	public void myPageRefundList() {
		
	}
	
	/**
	 * 내정보에서 Q&A 버튼 클릭했을 때
	 * 전체 질문 내역 띄워주기
	 * */
	@RequestMapping("myPageQna")
	public void myPageQna() {
		
	}
	
	/**
	 * Q&A 내역에서 글 제목을 클릭했을 때
	 * 새창띄워서 답변내용 보여주기
	 * */
	@RequestMapping("showAnswer")
	public void showAnswer() {
		
	}
	
	/**
	 * 내정보에서 기부 버튼 클릭했을 때
	 * 3개월까지의 내역 보여주기
	 * */
	@RequestMapping("myPageDonation")
	public void myPageDonation() {
		
	}
	
	/**
	 * 내정보에서 개인정보관리 버튼 클릭했을 때
	 * 내 정보 가져와서 아이디, 이름, 연락처 띄워주기
	 * */
	@RequestMapping("myPageInfoModify")
	public void myPageInfoModify() {
		
	}
	
	/**
	 * 내정보에서 마일리지 버튼 클릭했을 때
	 * 추천인 아이디(5명) + 외 ~명 띄우주기
	 * 마일리지 사용내역은 3개월까지 보여주기
	 * */
	@RequestMapping("myPageMileage")
	public void myPageMileage() {
		
	}
	
	/**
	 * 장바구니 버튼 클릭했을 때
	 * 페이징, cart 테이블에서 정보가져오기
	 * 총금액 띄워주기
	 * */
	@RequestMapping("myCart")
	public void myCart() {
		
	}
	
	/**
	 * 장바구니에서 삭제
	 * */
	@RequestMapping("myCartDelete")
	public void myCartDelete() {
		
	}
	
	/**
	 * 장바구니에 주문버튼 클릭했을 때
	 * */
	@RequestMapping("myCartOrder")
	public void myCartOrder() {
		
	}
}