package spring.web.dao;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface UserInfoDAO {

	/**
	 * 회원가입
	 * */
	int registerMember(MemberDTO memberDto);
	
	/**
	 * 계정찾기(id)
	 * */
	String searchId(MemberDTO memeberDto);
	
	/**
	 * 계정찾기(pwd-sendcode)
	 * */
	String searchPwdSendCode(String email);
	
	/**
	 * 계정찾기(pwd)
	 * */
	String searchPwd(String code);
	
	/**
	 * 로그인하기
	 * */
	MemberDTO login(MemberDTO memberDto);
	
	/**
	 * 아이디 중복확인 / 추천인 아이디 중복확인
	 * */
	boolean checkId(String email);
	
	/**
	 * 회원 메인 페이지로 이동할 때 필요한 정보들
	 * (생산자에 대한 정보 , 인기 상품 3개에 대한 정보, 기부정보(저번달 총 모금액,이번달 총 모금액))
	 * */
	Map<String, Object> userMainLoading();
	
	/**
	 * 회원이 마이페이지를 눌렀을 때
	 * 마이페이지 메인 정보 로딩
	 * */
	Map<String, Integer> myPageLoading(String email); 
	
	/**
	 * MyPage의 쇼핑내역을 누를경우
	 * 바로 주문/배송조회가 이루어지면서
	 * 회원의 3개월간 주문조회 내역을 purchase테이블에서
	 * 가져와서 view에 뿌려줌
	 * */
	List<ProductDTO> myPageOrderList(String email);
	
	/**
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때
	 * 해당 목록 삭제
	 * */
	int deleteOrderProduct(String email);
	
	/**
	 * 해당 회원에 해당하는 qna 정보 가져오기
	 * */
	List<QnaDTO> myPageQna(String email);
	
	/**
	 * 해당 qna에 달린 답글 가져오기
	 * */
	String showAnswer(QnaDTO qnaDto);
	
	/**
	 * 내정보 - 기부버튼 눌렀을 때
	 * */
	List<DonationDTO> myPageDonation(String email);
	
	/**
	 * 내정보 - 개인정보 관리
	 * */
	MemberDTO myPageInfoModify(String email);
	
	/**
	 * 내정보 - 마일리지 눌렀을 때
	 * */
	Map<String, Object> myPageMileage(String email);
	
	/**
	 * 내정보 - 장바구니
	 * */
	Map<String, Object> myCart(String email);
	
	/**
	 * 내정보 - 장바구니 -> 주문하기 버튼 클릭시
	 * 				      주문페이지로 이동
	 * */
	List<ProductDTO> myCartOrder(String email);
	
	/**
	 * 내정보 - 장바구니 -> 상품 삭제
	 * */
	int myCartDelete(int no);
	
	
}
