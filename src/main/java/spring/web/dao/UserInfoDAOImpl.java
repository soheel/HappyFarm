package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.MemberRequestDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.QnaDTO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private SqlSession sqlSession;

	/**
	 * 회원가입
	 */
	@Override
	public int registerMember(MemberDTO memberDto) {
		if(memberDto.getRecommand().equals("")) {
			return sqlSession.insert("userInfoMapper.registerMemberRecommand", memberDto);
		}
		return sqlSession.insert("userInfoMapper.registerMember", memberDto);
	}

	/**
	 * 계정찾기(id)
	 */
	@Override
	public String searchId(MemberDTO memberDto) {
		
		return sqlSession.selectOne("userInfoMapper.searchId", memberDto);
	}

	/**
	 * 계정찾기(pwd-sendcode)
	 */
	@Override
	public String searchPwdSendCode(String email) {
		return sqlSession.selectOne("userInfoMapper.searchPwdSendCode", email);
	}

	/**
	 * 계정찾기(pwd)
	 */
	@Override
	public String searchPwd(String code) {
		return sqlSession.selectOne("userInfoMapper.searchPwd", code);
	}

	/**
	 * 로그인하기
	 */
	@Override
	public MemberDTO login(MemberDTO memberDto) {
		System.out.println("login dao");
		return sqlSession.selectOne("userInfoMapper.login", memberDto);
	}

	/**
	 * 아이디 중복확인
	 */
	@Override
	public boolean checkId(String email) {
		Object obj = sqlSession.selectOne("userInfoMapper.checkId", email);
		if(obj == null){
			return false;
		}
		
		return true;
	}

	/**
	 * 마이페이지 이동시 -> 회원 마일리지 및 현재진행중인 거래내역 가져오기
	 */
	@Override
	public Map<String, Object> myPageLoading(String email) {
		int mileage =sqlSession.selectOne("userInfoMapper.getMileage", email);
		List<MemberDTO> list = sqlSession.selectList("userInfoMapper.getOrderlist", email);
		System.out.println(list.size());
				
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("mileage", mileage);
		map.put("list", list);
		return map;
	}

	/**
	 * MyPage의 쇼핑내역을 누를경우 바로 주문/배송조회가 이루어지면서 회원의 3개월간 주문조회 내역을 purchase테이블에서
	 * 가져와서 view에 뿌려줌
	 */
	//3개월
	@Override
	public List<MemberDTO> myPageOrderList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList3", email);
	}
	//6개월
	@Override
	public List<MemberDTO> myPageOrderList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList6", email);
	}
	//12개월
	@Override
	public List<MemberDTO> myPageOrderList12(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList12", email);
	}
	//All
	@Override
	public List<MemberDTO> myPageOrderListAll(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderListAll", email);
	}
	
	
	/**
	 * 내정보 - 환불 / 교환 / 반품 내역 조회(3개월)
	 */
	//3개월
	@Override
	public List<MemberDTO> myPageCancelList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList3", email);
	}
	//6개월
	@Override
	public List<MemberDTO> myPageCancelList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList6", email);
	}
	//12개월
	@Override
	public List<MemberDTO> myPageCancelList12(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList12", email);
	}
	//All
	@Override
	public List<MemberDTO> myPageCancelListAll(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerListAll", email);
	}
	
	
	/**
	 * 내정보 - 환불 조회
	 */
	//3개월
	@Override
	public List<MemberDTO> myPageRefundList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList3", email);
	}
	//6개월
	@Override
	public List<MemberDTO> myPageRefundList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList6", email);
	}
	//12개월
	@Override
	public List<MemberDTO> myPageRefundList12(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList12", email);
	}
	//All
	@Override
	public List<MemberDTO> myPageRefundListAll(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundListAll", email);
	}
	

	/**
	 * 주문 상태에 대한 no 뽑아오기
	 * */
/*	@Override
	public List<Integer> getStateNoByStateName(PurchaseDTO purchaseDto) {
		List<Integer> stateNo= sqlSession.selectList("userInfoMapper.getStateNoByStateName", purchaseDto.getPurchaseStateDto().getName());
		
		return stateNo;
	}*/
	/**
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때 해당 목록 삭제
	 */
	public int deleteOrderProduct(int no) {
		
		return sqlSession.delete("userInfoMapper.deleteOrderList", no);
	};
	
	/**
	 * 비밀번호 체크
	 * */
	@Override
	public String checkPwd(String pwd) {
		 return sqlSession.selectOne("userInfoMapper.checkPwd", pwd);

	}
	
	/**
	 * 구매 상태에 따른 번호 가져오기
	 * */
	@Override
	public int getStateNo(String name) {
		return sqlSession.selectOne("userInfoMapper.getStateNo", name);
	}
	
	/**
	 * 주문 조회에서 교환/반품/환불 요청시
	 * */
	@Override
	public int insertRequest(MemberRequestDTO memberRequestDto) {
		int result = sqlSession.insert("userInfoMapper.chageByRequest", memberRequestDto);
		return result;
	}
	
	@Override
	public int updateByRequest(PurchaseDTO purchaseDto){
		return sqlSession.update("userInfoMapper.updateByRequest", purchaseDto);
	}
	
	
	/**
	 * 해당 회원에 해당하는 qna 정보 가져오기
	 */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		List<QnaDTO> QnaList =  sqlSession.selectList("userInfoMapper.getMyPageQnaList", email);
		return QnaList;
	}
	
	/**
	 * qna번호에 해당하는 qna가져오기
	 * */
	public String getAnswerByNo(int no) {
		String answer = sqlSession.selectOne("userInfoMapper.getQnaAnswer", no);
		System.out.println("dao answer :"+answer);
		return answer;
	};
	/**
	 * 내정보 - 기부페이지 눌렀을 때
	 */
	@Override
	public Map<String, Object> myPageDonation(String email) {
		List<MemberDTO> list = sqlSession.selectList("userInfoMapper.getMyPageDonationInfo", email);
		int donationTotalInfo; 
		if(sqlSession.selectOne("userInfoMapper.getMyPageTotalDonationInfo", email)==null){
			donationTotalInfo=0;
		}else{
			donationTotalInfo =sqlSession.selectOne("userInfoMapper.getMyPageTotalDonationInfo", email); 
		}
	
		Map<String,Object> map = new HashMap();
		map.put("list", list);
		map.put("donationTotalInfo", donationTotalInfo);
		
		System.out.println(map.size());
				
		return map;
	}

	/**
	 * 내정보 - 개인정보관리
	 */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		
		return sqlSession.selectOne("userInfoMapper.getUserInfo",email);
	}
	
	/**
	 * 수정
	 * */
	@Override
	public int updateUserInfo(MemberDTO memberDto) {
		return sqlSession.update("userInfoMapper.updateUserInfo", memberDto);
	}
	/**
	 * 내정보 - 마일리지 눌렀을 때
	 */
	public Map<String,Object> myPageMileage(String email) {
		List<String> list1 = sqlSession.selectList("userInfoMapper.getMyPageRecommander", email);
		List<MemberDTO> list2= sqlSession.selectList("userInfoMapper.searchMyMileage3", email);
		System.out.println("마일리지 : " +list2);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recommand", list1);
		map.put("usedMileage", list2);

		return map;
	}	
	
	/**
	 * 마일리지 사용내역 조회
	 * */
	//3개월
	@Override
	public List<MemberDTO> getmyPageMileage3(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage3", email);
	}
	//6개월
	@Override
	public List<MemberDTO> getmyPageMileage6(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage6", email);
	}
	//12개월
	@Override
	public List<MemberDTO> getmyPageMileage12(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage12", email);
	}
	//All
	@Override
	public List<MemberDTO> getmyPageMileageAll(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileageAll", email);
	}


	/**
	 * 아래의 5개 메소드는 로그인 성공 후 메인화면 로딩할 때 필요
	 * */
	@Override
	public List<Integer> getBestProduct() {
		return sqlSession.selectList("userInfoMapper.getBestProduct", null, new RowBounds(0, 4));
	}

	@Override
	public ProductDTO getProductByProductNo(int productNo) {
		return sqlSession.selectOne("userInfoMapper.getProductByProductNo", productNo);
	}

	@Override
	public ProducerDTO getProducerByProducerNo(int producerNo) {
		return sqlSession.selectOne("userInfoMapper.getProducerByProducerNo", producerNo);
	}

	@Override
	public List<Integer> getBestProducer() {
		return sqlSession.selectList("userInfoMapper.getBestProducer", null, new RowBounds(0, 3));
	}

	@Override
	public int getPreviousDonationPrice() {
		List<Object> list = sqlSession.selectList("userInfoMapper.getPreviousDonationPrice", null, new RowBounds(0, 1));
		int n = (Integer)list.get(0);
		return n;
	}

	/**
	 * 내정보 - 장바구니 로딩
	 */
	@Override
	public Map<String, Object> myCart(String email) {
		 List<ProductDTO> productList= sqlSession.selectList("userInfoMapper.MyCartLoading", email);
		 int totalPrice= sqlSession.selectOne("userInfoMapper.getTotalPriceInCart", email);
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("productList", productList);
		 map.put("totalPrice", totalPrice);
		
		 return map;
	}
	
	/**
	 * 내정보 - 장바구니 -> 주문하기 버튼을 눌렀을 때
	 */
	@Override
	public List<ProductDTO> myCartOrder(String email) {
		
		return null;
	}
	
	/**
	 * 내정보 - 장바구니 -> 장바구니 안의 상품 삭제
	 */
	@Override
	public int myCartDelete(String email, String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("name", name);
		
		return sqlSession.delete("userInfoMapper.deleteMyCartProduct", map);
	}

	@Override
	public List<InfomationDTO> infoLoading() {
		return sqlSession.selectList("userEtcMapper.infoLoading", null, new RowBounds(0, 6));
	}

}
