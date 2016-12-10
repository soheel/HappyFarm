package spring.web.service;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.QnaDTO;

public interface UserInfoService {

	/**
	 * ȸ������
	 * */
	int registerMember(MemberDTO memberDto);
	
	/**
	 * ����ã��(id)
	 * */
	String searchId(MemberDTO memberDto);
	
	/**
	 * ����ã��(pwd-sendcode)
	 * */
	String searchPwdSendCode(String email);
	
	/**
	 * ����ã��(pwd)
	 * */
	String searchPwd(String code);
	
	/**
	 * �α����ϱ�
	 * */
	MemberDTO login(MemberDTO memberDto);
	
	/**
	 * ���̵� �ߺ�Ȯ�� / ��õ�� ���̵� �ߺ�Ȯ��
	 * */
	boolean checkId(String email);
	
	/**
	 * ȸ�� ���� �������� �̵��� �� �ʿ��� ������
	 * (�����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, �������(������ �� ��ݾ�,�̹��� �� ��ݾ�))
	 * */
	Map<String, Object> userMainLoading();
	
	/**
	 * ȸ���� ������������ ������ ��
	 * ���������� ���� ���� �ε�
	 * */
	Map<String, Integer> myPageLoading(String email); 
	
	/**
	 * MyPage�� ���γ����� �������
	 * �ٷ� �ֹ�/�����ȸ�� �̷�����鼭
	 * ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 * */
	List<ProductDTO> myPageOrderList3(String email);
	List<ProductDTO> myPageOrderList6(String email);//6����
	List<ProductDTO> myPageOrderList12(String email);//1��
	List<ProductDTO> myPageOrderListAll(String email);//��ü
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * �ش� ��� ����
	 * */
	int deleteOrderProduct(int no);
	
	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 * */
	List<QnaDTO> myPageQna(String email);
	
	/**
	 * �ش� qna�� �޸� ��� ��������
	 * */
	String showAnswer(int no);
	
	/**
	 * ������ - ��ι�ư ������ ��
	 * */
	Map<String, Object> myPageDonation(String email);
	
	/**
	 * ������ - �������� ����
	 * */
	MemberDTO myPageInfoModify(String email);
	
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
	 * ������ - ���/��ǰ/��ȯ ���� ��ȸ
	 * */
	List<ProductDTO> myPageCancelList3(String email);
	List<ProductDTO> myPageCancelList6(String email);//6����
	List<ProductDTO> myPageCancelList12(String email);//1��
	List<ProductDTO> myPageCancelListAll(String email);//��ü
	
	/**
	 * ������ - ȯ�� ��ȸ
	 * */
	List<ProductDTO> myPageRefundList3(String email);
	List<ProductDTO> myPageRefundList6(String email);//6����
	List<ProductDTO> myPageRefundList12(String email);//1��
	List<ProductDTO> myPageRefundListAll(String email);//��ü
	
	/**
	 * ���ϸ��� ��볻�� ��ȸ
	 * */
	List<PurchaseDTO> getmyPageMileage3(String email);
	List<PurchaseDTO> getmyPageMileage6(String email);
	List<PurchaseDTO> getmyPageMileage12(String email);
	List<PurchaseDTO> getmyPageMileageAll(String email);
	
}
