package spring.web.dao;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
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
	
	// -----------------------------------------------------
	
	/**
	 * 가장 인기많은 생산자 정보 가져오기
	 * */
	List<Integer> getBestProducer();
	
	/**
	 * 저번달 기부금액 가져오기
	 * */
	int getPreviousDonationPrice();
	
	/**
	 * shopMenuLoading()
	 * 인기상품 3개 가져오기
	 * */
	List<Integer> getBestProduct();
	
	/**
	 * showProductDetail(int productNo) / order(int productNo, int num)
	 * productNo로 ProductDTO 가져오기
	 * */
	ProductDTO getProductByProductNo(int productNo);
	
	/**
	 * showProducerInfo(int producerNo)
	 * producerNo로 ProducerDTO 가져오기
	 * */
	ProducerDTO getProducerByProducerNo(int producerNo);
	
	// -----------------------------------------------------
	
	
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
	List<ProductDTO> myPageOrderList3(String email);//3개월
	List<ProductDTO> myPageOrderList6(String email);//6개월
	List<ProductDTO> myPageOrderList12(String email);//1년
	List<ProductDTO> myPageOrderListAll(String email);//전체
	
	
	/**
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때
	 * 해당 목록 삭제
	 * */
	int deleteOrderProduct(int no);
	
	/**
	 * 해당 회원에 해당하는 qna 정보 가져오기
	 * */
	List<QnaDTO> myPageQna(String email);
	
	/**
	 * 해당 qna에 달린 답글 가져오기
	 * */
	String showAnswer(int no);
	
	/**
	 * 내정보 - 기부버튼 눌렀을 때
	 * */
	Map<String, List<DonationOrgDTO>> myPageDonation(String email);
	
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
	
	/**
	 * 내정보 - 취소 / 교환 / 반품 내역 조회
	 * */
	List<ProductDTO> myPageCancelList3(String email);
	List<ProductDTO> myPageCancelList6(String email);//6개월
	List<ProductDTO> myPageCancelList12(String email);//1년
	List<ProductDTO> myPageCancelListAll(String email);//전체
	
	
	/**
	 * 내정보 - 환불 조회
	 * */
	List<ProductDTO> myPageRefundList3(String email);	
	List<ProductDTO> myPageRefundList6(String email);//6개월
	List<ProductDTO> myPageRefundList12(String email);//1년
	List<ProductDTO> myPageRefundListAll(String email);//전체
	
}
