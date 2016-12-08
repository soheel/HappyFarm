package spring.web.service;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
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
	String searchId(MemberDTO memeberDto);
	
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
	List<ProductDTO> myPageOrderList(String email);
	
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
	String showAnswer(QnaDTO qnaDto);
	
	/**
	 * ������ - ��ι�ư ������ ��
	 * */
	List<DonationDTO> myPageDonation(String email);
	
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
	int myCartDelete(int no);
	
	/**
	 * ������ - ���/��ǰ/��ȯ ���� ��ȸ
	 * */
	List<ProductDTO> myPageCancelList(String email);
	
	/**
	 * ������ - ȯ�� ��ȸ
	 * */
	List<ProductDTO> myPageRefundList(String email);
	
}
