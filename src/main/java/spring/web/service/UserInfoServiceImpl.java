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
	 * ȸ������
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return userInfoDao.registerMember(memberDto);
	}
	
	/**
	 * ����ã��(id)
	 * */
	@Override
	public String searchId(MemberDTO memberDto) {
		return userInfoDao.searchId(memberDto);
	}
	
	/**
	 * ����ã��(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return userInfoDao.searchPwdSendCode(email);
	}
	
	/**
	 * ����ã��(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return userInfoDao.searchPwd(code);
	}
	
	/**
	 * �α����ϱ�
	 * */
	@Override
	public MemberDTO login(MemberDTO memberDto) {
		return userInfoDao.login(memberDto);
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * */
	@Override
	public boolean checkId(String email) {
		return userInfoDao.checkId(email);
	}
	
	/**
	 * ���������� �̵��� -> ȸ�� ���ϸ��� �� ������������ �ŷ����� ��������
	 * */
	@Override
	public Map<String, Object> myPageLoading(String email) {
		return userInfoDao.myPageLoading(email);
	}
	
	/**
	 * ȸ�� ���� �������� �̵��� �� �ʿ��� ������
	 * (�����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, �������(������ �� ��ݾ�,�̹��� �� ��ݾ�))
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
	 * MyPage�� ���γ����� �������
	 * �ٷ� �ֹ�/�����ȸ�� �̷�����鼭
	 * ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 * */
	@Override
	public List<ProductDTO> myPageOrderList3(String email) {
		return userInfoDao.myPageOrderList3(email);
	}

	//6����
	@Override
	public List<ProductDTO> myPageOrderList6(String email) {
		return userInfoDao.myPageOrderList6(email);
	}
	//12����
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
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * �ش� ��� ����
	 * */
	@Override
	public int deleteOrderProduct(int no) {
		return userInfoDao.deleteOrderProduct(no);
	}
	
	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 * */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		return userInfoDao.myPageQna(email);
	}
	
	/**
	 * �ش� �����ۿ� �޸� ��� ��������
	 * */
	@Override
	public String showAnswer(int no) {
		return userInfoDao.showAnswer(no);
	}
	
	/**
	 * ������ - ��������� ������ ��
	 * */
	@Override
	public Map<String, Object> myPageDonation(String email) {
		return userInfoDao.myPageDonation(email);
	}
	
	/**
	 * ������ - ������������
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
	 * ������ - ��ٱ��� �ε�
	 * */
	 @Override
	public Map<String, Object> myCart(String email) {
		return userInfoDao.myCart(email);
	}
	 
	 /**
	  * ������ - ��ٱ��� -> �ֹ��ϱ� ��ư�� ������ ��
	  * */
	 @Override
	public List<ProductDTO> myCartOrder(String email) {
		return userInfoDao.myCartOrder(email);
	}
	 /**
	  * ������  - ��ٱ��� -> ��ٱ��� ���� ��ǰ ����
	  * */
	 @Override
	public int myCartDelete(String email, String name) {
		return userInfoDao.myCartDelete(email,name);
	}
	 
	 /**
	  * ������ - ��ǰ ,��ȯ,ȯ�� ���� ��ȸ(3����)
	  * */
	 //3����
	 @Override
	public List<ProductDTO> myPageCancelList3(String email) {
		return userInfoDao.myPageCancelList3(email);
	}
	//6����
	@Override
	public List<ProductDTO> myPageCancelList6(String email) {
		return userInfoDao.myPageCancelList6(email);
	}
	//12����
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
	 * ������ - ȯ�� ��ȸ
	 */
	//3����
	@Override
	public List<ProductDTO> myPageRefundList3(String email) {
		return userInfoDao.myPageRefundList3(email);
	}
	//6����
	@Override
	public List<ProductDTO> myPageRefundList6(String email) {
		return userInfoDao.myPageRefundList6(email);
	}
	//12����
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
	 * ���ϸ��� ��볻�� ��ȸ
	 * */
	//3����
	@Override
	public List<PurchaseDTO> getmyPageMileage3(String email) {
		return userInfoDao.getmyPageMileage3(email);
	}
	//6����
	@Override
	public List<PurchaseDTO> getmyPageMileage6(String email) {
		return userInfoDao.getmyPageMileage6(email);
	}
	//12����
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
	 * ������ - ���ϸ��� ������ ��
	 * */
	public Map<String,Object> myPageMileage(String email) {
		return userInfoDao.myPageMileage(email);
	}
	 
	
}
