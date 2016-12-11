package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserInfoDAO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.QnaDTO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDao;
	
	
	/**
	 * 회원가입
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return userInfoDao.registerMember(memberDto);
	}
	
	/**
	 * 계정찾기(id)
	 * */
	@Override
	public String searchId(MemberDTO memberDto) {
		return userInfoDao.searchId(memberDto);
	}
	
	/**
	 * 계정찾기(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return userInfoDao.searchPwdSendCode(email);
	}
	
	/**
	 * 계정찾기(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return userInfoDao.searchPwd(code);
	}
	
	/**
	 * 로그인하기
	 * */
	@Override
	public MemberDTO login(MemberDTO memberDto) {
		return userInfoDao.login(memberDto);
	}
	
	/**
	 * 아이디 중복확인
	 * */
	@Override
	public boolean checkId(String email) {
		return userInfoDao.checkId(email);
	}
	
	/**
	 * 마이페이지 이동시 -> 회원 마일리지 및 현재진행중인 거래내역 가져오기
	 * */
	@Override
	public Map<String, Object> myPageLoading(String email) {
		return userInfoDao.myPageLoading(email);
	}
	
	/**
	 * 회원 메인 페이지로 이동할 때 필요한 정보들
	 * (생산자에 대한 정보 , 인기 상품 3개에 대한 정보, 기부정보(저번달 총 모금액,이번달 총 모금액))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<ProductDTO> bestProductList = new ArrayList<ProductDTO>();
		List<Integer> list = userInfoDao.getBestProduct();
		System.out.println(list.size());
		for(Integer i : list) {
			bestProductList.add(userInfoDao.getProductByProductNo(i));
		}
		map.put("bestProduct", bestProductList);
		
		List<ProducerDTO> bestProducerList = new ArrayList<ProducerDTO>();
		list = userInfoDao.getBestProducer();
		for(Integer i : list) {
			bestProducerList.add(userInfoDao.getProducerByProducerNo(i));
		}
		map.put("bestProducer", bestProducerList);
		
		map.put("previousMonthDonationPrice", userInfoDao.getPreviousDonationPrice());
		
		return map;
	}
	
	/**
	 * MyPage의 쇼핑내역을 누를경우
	 * 바로 주문/배송조회가 이루어지면서
	 * 회원의 3개월간 주문조회 내역을 purchase테이블에서
	 * 가져와서 view에 뿌려줌
	 * */
	@Override
	public List<ProductDTO> myPageOrderList3(String email) {
		return userInfoDao.myPageOrderList3(email);
	}

	//6개월
	@Override
	public List<ProductDTO> myPageOrderList6(String email) {
		return userInfoDao.myPageOrderList6(email);
	}
	//12개월
	@Override
	public List<ProductDTO> myPageOrderList12(String email) {
		return userInfoDao.myPageOrderList12(email);
	}
	//All
	@Override
	public List<ProductDTO> myPageOrderListAll(String email) {
		return userInfoDao.myPageOrderListAll(email);
	}
	
	
	/**
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때
	 * 해당 목록 삭제
	 * */
	@Override
	public int deleteOrderProduct(int no) {
		return userInfoDao.deleteOrderProduct(no);
	}
	
	/**
	 * 해당 회원에 해당하는 qna 정보 가져오기
	 * */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		return userInfoDao.myPageQna(email);
	}
	
	/**
	 * 해당 질문글에 달린 답글 가져오기
	 * */
	@Override
	public String showAnswer(int no) {
		return userInfoDao.showAnswer(no);
	}
	
	/**
	 * 내정보 - 기부페이지 눌렀을 때
	 * */
	@Override
	public Map<String, Object> myPageDonation(String email) {
		return userInfoDao.myPageDonation(email);
	}
	
	/**
	 * 내정보 - 개인정보관리
	 * */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		return userInfoDao.myPageInfoModify(email);
	}
	@Override
	public int updateUserInfo(MemberDTO memberDto) {
		
		return userInfoDao.updateUserInfo(memberDto);
	}
	
	/**
	 * 내정보 - 장바구니 로딩
	 * */
	 @Override
	public Map<String, Object> myCart(String email) {
		return userInfoDao.myCart(email);
	}
	 
	 /**
	  * 내정보 - 장바구니 -> 주문하기 버튼을 눌렀을 때
	  * */
	 @Override
	public List<ProductDTO> myCartOrder(String email) {
		return userInfoDao.myCartOrder(email);
	}
	 /**
	  * 내정보  - 장바구니 -> 장바구니 안의 상품 삭제
	  * */
	 @Override
	public int myCartDelete(String email, String name) {
		return userInfoDao.myCartDelete(email,name);
	}
	 
	 /**
	  * 내정보 - 반품 ,교환,환불 내역 조회(3개월)
	  * */
	 //3개월
	 @Override
	public List<ProductDTO> myPageCancelList3(String email) {
		return userInfoDao.myPageCancelList3(email);
	}
	//6개월
	@Override
	public List<ProductDTO> myPageCancelList6(String email) {
		return userInfoDao.myPageCancelList6(email);
	}
	//12개월
	@Override
	public List<ProductDTO> myPageCancelList12(String email) {
		return userInfoDao.myPageCancelList12(email);
	}
	//All
	@Override
	public List<ProductDTO> myPageCancelListAll(String email) {
		return userInfoDao.myPageCancelListAll(email);
	}


	/**
	 * 내정보 - 환불 조회
	 */
	//3개월
	@Override
	public List<ProductDTO> myPageRefundList3(String email) {
		return userInfoDao.myPageRefundList3(email);
	}
	//6개월
	@Override
	public List<ProductDTO> myPageRefundList6(String email) {
		return userInfoDao.myPageRefundList6(email);
	}
	//12개월
	@Override
	public List<ProductDTO> myPageRefundList12(String email) {
		return userInfoDao.myPageRefundList12(email);
	}
	//All
	@Override
	public List<ProductDTO> myPageRefundListAll(String email) {
		return userInfoDao.myPageRefundListAll(email);
	}
	 
	/**
	 * 마일리지 사용내역 조회
	 * */
	//3개월
	@Override
	public List<PurchaseDTO> getmyPageMileage3(String email) {
		return userInfoDao.getmyPageMileage3(email);
	}
	//6개월
	@Override
	public List<PurchaseDTO> getmyPageMileage6(String email) {
		return userInfoDao.getmyPageMileage6(email);
	}
	//12개월
	@Override
	public List<PurchaseDTO> getmyPageMileage12(String email) {
		return userInfoDao.getmyPageMileage12(email);
	}
	//All
	@Override
	public List<PurchaseDTO> getmyPageMileageAll(String email) {
		return userInfoDao.getmyPageMileageAll(email);
	}
	 
	/**
	 * 내정보 - 마일리지 눌렀을 때
	 * */
	public Map<String,Object> myPageMileage(String email) {
		return userInfoDao.myPageMileage(email);
	}
	 
	
}
