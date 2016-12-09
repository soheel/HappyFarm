package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
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
		return sqlSession.insert("userInfoMapper.registerMember", memberDto);
	}

	/**
	 * ����ã��(id)
	 */
	@Override
	public String searchId(MemberDTO memeberDto) {
		return sqlSession.selectOne("userInfoMapper.searchId", memeberDto);
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
	public Map<String, Integer> myPageLoading(String email) {
		return sqlSession.selectOne("userInfoMapper.getMileageAndOrderlist", email);
	}

	/**
	 * MyPage�� ���γ����� ������� �ٷ� �ֹ�/�����ȸ�� �̷�����鼭 ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 */
	//3����
	@Override
	public List<ProductDTO> myPageOrderList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList3", email);
	}
	//6����
	@Override
	public List<ProductDTO> myPageOrderList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList6", email);
	}
	//12����
	@Override
	public List<ProductDTO> myPageOrderList12(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderList12", email);
	}
	//All
	@Override
	public List<ProductDTO> myPageOrderListAll(String email) {
		return sqlSession.selectList("userInfoMapper.getMypageOrderListAll", email);
	}
	
	
	/**
	 * ������ - ȯ�� / ��ȯ / ��ǰ ���� ��ȸ(3����)
	 */
	//3����
	@Override
	public List<ProductDTO> myPageCancelList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList3", email);
	}
	//6����
	@Override
	public List<ProductDTO> myPageCancelList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList6", email);
	}
	//12����
	@Override
	public List<ProductDTO> myPageCancelList12(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerList12", email);
	}
	//All
	@Override
	public List<ProductDTO> myPageCancelListAll(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageCancerListAll", email);
	}
	
	
	/**
	 * ������ - ȯ�� ��ȸ
	 */
	//3����
	@Override
	public List<ProductDTO> myPageRefundList3(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList3", email);
	}
	//6����
	@Override
	public List<ProductDTO> myPageRefundList6(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList6", email);
	}
	//12����
	@Override
	public List<ProductDTO> myPageRefundList12(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundList12", email);
	}
	//All
	@Override
	public List<ProductDTO> myPageRefundListAll(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageRefundListAll", email);
	}
	

	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ �� �ش� ��� ����
	 */
	@Override
	public int deleteOrderProduct(int no) {
		return sqlSession.delete("userInfoMapper.deleteOrderList", no);
	}

	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		return sqlSession.selectList("userInfoMapper.getMyPageQnaList", email);
	}

	/**
	 * �ش� �����ۿ� �޸� ��� ��������
	 */
	@Override
	public String showAnswer(int no) {
		return sqlSession.selectOne("userInfoMapper.getQnaAnswer", no);
	}

	/**
	 * ������ - ��������� ������ ��
	 */
	@Override
	public Map<String, Object> myPageDonation(String email) {
		List<DonationOrgDTO> donationInfo = sqlSession.selectList("userInfoMapper.getMyPageDonationInfo", email);
		int donationTotalInfo = sqlSession.selectOne("userInfoMapper.getMyPageTotalDonationInfo", email);
		
		Map<String,Object> map = new HashMap();
		map.put("donationOnfo", donationInfo);
		map.put("donationTotalInfo", donationTotalInfo);
				
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
	 * ������ - ���ϸ��� ������ ��
	 */
	public Map<String,Object> myPageMileage(String email) {
		List<MemberDTO> list1 = sqlSession.selectList("userInfoMapper.getMyPageRecommander", email, new RowBounds(0, 5));
		List<PurchaseDTO> list2= sqlSession.selectList("userInfoMapper.searchMyMileage3", email);
		
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
	public List<PurchaseDTO> getmyPageMileage3(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage3", email);
	}
	//6����
	@Override
	public List<PurchaseDTO> getmyPageMileage6(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage6", email);
	}
	//12����
	@Override
	public List<PurchaseDTO> getmyPageMileage12(String email) {
		return sqlSession.selectList("userInfoMapper.searchMyMileage12", email);
	}
	//All
	@Override
	public List<PurchaseDTO> getmyPageMileageAll(String email) {
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

}
