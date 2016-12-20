package spring.web.dao;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.MemberRequestDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.QnaDTO;

public interface UserInfoDAO {

	/**
	 * ȸ������
	 * */
	int registerMember(MemberDTO memberDto);
	
	/**
	 * ����ã��(id)
	 * */
	String searchId(MemberDTO memeberDto);
	
	/**
	 * ����ã��(pwd-sendcode)
	 * */
	String searchPwdSendCode(String email);
	
	/**
	 * ����ã��(pwd)
	 * */
	String searchPwd(String email);
	
	/**
	 * �α����ϱ�
	 * */
	MemberDTO login(MemberDTO memberDto);
	
	/**
	 * ���̵� �ߺ�Ȯ�� / ��õ�� ���̵� �ߺ�Ȯ��
	 * */
	boolean checkId(String email);
	
	/**
	 * ��й�ȣ üũ
	 * */
	String checkPwd(String pwd);
	 
	
	// -----------------------------------------------------
	
	/**
	 * ���� �α⸹�� ������ ���� ��������
	 * */
	List<Integer> getBestProducer();
	
	/**
	 * ������ ��αݾ� ��������
	 * */
	int getPreviousDonationPrice();
	
	/**
	 * shopMenuLoading()
	 * �α��ǰ 3�� ��������
	 * */
	List<Integer> getBestProduct();
	
	/**
	 * showProductDetail(int productNo) / order(int productNo, int num)
	 * productNo�� ProductDTO ��������
	 * */
	ProductDTO getProductByProductNo(int productNo);
	
	/**
	 * showProducerInfo(int producerNo)
	 * producerNo�� ProducerDTO ��������
	 * */
	ProducerDTO getProducerByProducerNo(int producerNo);
	
	/**
	 * ����ȭ�鿡 info 7�� ��������
	 * */
	List<InfomationDTO> infoLoading();
	
	// -----------------------------------------------------
	
	
	/**
	 * ȸ���� ������������ ������ ��
	 * ���������� ���� ���� �ε�
	 * */
	Map<String, Object> myPageLoading(String email); 
	
	/**
	 * MyPage�� ���γ����� �������
	 * �ٷ� �ֹ�/�����ȸ�� �̷�����鼭
	 * ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 * */
	List<MemberDTO> myPageOrderList3(String email);//3����
	List<MemberDTO> myPageOrderList6(String email);//6����
	List<MemberDTO> myPageOrderList12(String email);//1��
	List<MemberDTO> myPageOrderListAll(String email);//��ü
	
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * �ش� ��� ����
	 * */
	/*List<Integer> getStateNoByStateName(PurchaseDTO purchaseDto);*/
	int deleteOrderProduct(int no);
	
	/**
	 * ���Ż��¿� ���� ��ȣ ��������
	 * */
	int getStateNo(String name);
	
	/**
	 * �ֹ� ��ȸ���� ��ȯ/��ǰ/ȯ�� ��û��
	 * */
	int insertRequest(MemberRequestDTO memberRequestDto);
	
	/**
	 * ��û����� ������ ���, purchase���̺� update
	 * */
	int updateByRequest(PurchaseDTO purchaseDto);
	
	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 * */
	Map<String, Object> myPageQna(String email);
	
	/**
	 * ������ - ��ι�ư ������ ��
	 * */
	Map<String, Object> myPageDonation(String email);
	
	/**
	 * ������ - �������� ����
	 * */
	MemberDTO myPageInfoModify(String email);
	
	/**
	 * �������� ����
	 * */
	int updateUserInfo(MemberDTO memberDto);
	
	/**
	 * ������ - ���ϸ��� ������ ��
	 * */
	Map<String, Object> myPageMileage(String email);
	
	/**
	 * ������ - ��ٱ���
	 * */
	Map<String, Object> myCart(String email);
	
	/**
	 * ������ - ��ٱ��� -> �ֹ��ϱ� ��ư Ŭ����
	 * 				      �ֹ��������� �̵�
	 * */
	List<ProductDTO> myCartOrder(String email);
	
	/**
	 * ������ - ��ٱ��� -> ��ǰ ����
	 * */
	int myCartDelete(String email, String name);
	
	/**
	 * ������ - ��� / ��ȯ / ��ǰ ���� ��ȸ
	 * */
	List<MemberDTO> myPageCancelList3(String email);
	List<MemberDTO> myPageCancelList6(String email);//6����
	List<MemberDTO> myPageCancelList12(String email);//1��
	List<MemberDTO> myPageCancelListAll(String email);//��ü
	
	
	/**
	 * ������ - ȯ�� ��ȸ
	 * */
	List<MemberDTO> myPageRefundList3(String email);	
	List<MemberDTO> myPageRefundList6(String email);//6����
	List<MemberDTO> myPageRefundList12(String email);//1��
	List<MemberDTO> myPageRefundListAll(String email);//��ü
	
	/**
	 * ���ϸ��� ��볻�� ��ȸ
	 * */
	List<MemberDTO> getmyPageMileage3(String email);
	List<MemberDTO> getmyPageMileage6(String email);
	List<MemberDTO> getmyPageMileage12(String email);
	List<MemberDTO> getmyPageMileageAll(String email);
	
	
	/**
	 * ��õ���� ȸ���� ���ϸ��� 500�� ������Ű��
	 * */
	int modifyRecommandedMember(String email);
	
}
