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
	 * ȸ������
	 */
	@Override
	public int registerMember(MemberDTO memberDto) {
		if(memberDto.getRecommand().equals("")) {
			return sqlSession.insert("userInfoMapper.registerMemberRecommand", memberDto);
		}
		return sqlSession.insert("userInfoMapper.registerMember", memberDto);
	}

	/**
	 * ����ã��(id)
	 */
	@Override
	public String searchId(MemberDTO memberDto) {
		
		return sqlSession.selectOne("userInfoMapper.searchId", memberDto);
	}

	/**
	 * ����ã��(pwd-sendcode)
	 */
	@Override
	public String searchPwdSendCode(String email) {
		return sqlSession.selectOne("userInfoMapper.searchPwdSendCode", email);
	}

	/**
	 * ����ã��(pwd)
	 */
	@Override
	public String searchPwd(String code) {
		return sqlSession.selectOne("userInfoMapper.searchPwd", code);
	}

	/**
	 * �α����ϱ�
	 */
	@Override
	public MemberDTO login(MemberDTO memberDto) {
		System.out.println("login dao");
		return sqlSession.selectOne("userInfoMapper.login", memberDto);
	}

	/**
	 * ���̵� �ߺ�Ȯ��
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
	 * ���������� �̵��� -> ȸ�� ���ϸ��� �� ������������ �ŷ����� ��������
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
	 * MyPage�� ���γ����� ������� �ٷ� �ֹ�/�����ȸ�� �̷�����鼭 ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 */
	//3����
	@Override
	public List<MemberDTO> myPageOrderList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList3", email);
	}
	//6����
	@Override
	public List<MemberDTO> myPageOrderList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList6", email);
	}
	//12����
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
	 * ������ - ȯ�� / ��ȯ / ��ǰ ���� ��ȸ(3����)
	 */
	//3����
	@Override
	public List<MemberDTO> myPageCancelList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList3", email);
	}
	//6����
	@Override
	public List<MemberDTO> myPageCancelList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList6", email);
	}
	//12����
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
	 * ������ - ȯ�� ��ȸ
	 */
	//3����
	@Override
	public List<MemberDTO> myPageRefundList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList3", email);
	}
	//6����
	@Override
	public List<MemberDTO> myPageRefundList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList6", email);
	}
	//12����
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
	 * �ֹ� ���¿� ���� no �̾ƿ���
	 * */
/*	@Override
	public List<Integer> getStateNoByStateName(PurchaseDTO purchaseDto) {
		List<Integer> stateNo= sqlSession.selectList("userInfoMapper.getStateNoByStateName", purchaseDto.getPurchaseStateDto().getName());
		
		return stateNo;
	}*/
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ �� �ش� ��� ����
	 */
	public int deleteOrderProduct(int no) {
		
		return sqlSession.delete("userInfoMapper.deleteOrderList", no);
	};
	
	/**
	 * ��й�ȣ üũ
	 * */
	@Override
	public String checkPwd(String pwd) {
		 return sqlSession.selectOne("userInfoMapper.checkPwd", pwd);

	}
	
	/**
	 * ���� ���¿� ���� ��ȣ ��������
	 * */
	@Override
	public int getStateNo(String name) {
		return sqlSession.selectOne("userInfoMapper.getStateNo", name);
	}
	
	/**
	 * �ֹ� ��ȸ���� ��ȯ/��ǰ/ȯ�� ��û��
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
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		List<QnaDTO> QnaList =  sqlSession.selectList("userInfoMapper.getMyPageQnaList", email);
		return QnaList;
	}
	
	/**
	 * qna��ȣ�� �ش��ϴ� qna��������
	 * */
	public String getAnswerByNo(int no) {
		String answer = sqlSession.selectOne("userInfoMapper.getQnaAnswer", no);
		System.out.println("dao answer :"+answer);
		return answer;
	};
	/**
	 * ������ - ��������� ������ ��
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
	 * ������ - ������������
	 */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		
		return sqlSession.selectOne("userInfoMapper.getUserInfo",email);
	}
	
	/**
	 * ����
	 * */
	@Override
	public int updateUserInfo(MemberDTO memberDto) {
		return sqlSession.update("userInfoMapper.updateUserInfo", memberDto);
	}
	/**
	 * ������ - ���ϸ��� ������ ��
	 */
	public Map<String,Object> myPageMileage(String email) {
		List<String> list1 = sqlSession.selectList("userInfoMapper.getMyPageRecommander", email);
		List<MemberDTO> list2= sqlSession.selectList("userInfoMapper.searchMyMileage3", email);
		System.out.println("���ϸ��� : " +list2);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recommand", list1);
		map.put("usedMileage", list2);

		return map;
	}	
	
	/**
	 * ���ϸ��� ��볻�� ��ȸ
	 * */
	//3����
	@Override
	public List<MemberDTO> getmyPageMileage3(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage3", email);
	}
	//6����
	@Override
	public List<MemberDTO> getmyPageMileage6(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage6", email);
	}
	//12����
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
	 * �Ʒ��� 5�� �޼ҵ�� �α��� ���� �� ����ȭ�� �ε��� �� �ʿ�
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
	 * ������ - ��ٱ��� �ε�
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
	 * ������ - ��ٱ��� -> �ֹ��ϱ� ��ư�� ������ ��
	 */
	@Override
	public List<ProductDTO> myCartOrder(String email) {
		
		return null;
	}
	
	/**
	 * ������ - ��ٱ��� -> ��ٱ��� ���� ��ǰ ����
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
