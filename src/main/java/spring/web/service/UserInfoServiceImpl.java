package spring.web.service;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public class UserInfoServiceImpl implements UserInfoService {

	/**
	 * ȸ������
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return 0;
	}
	
	/**
	 * ����ã��(id)
	 * */
	@Override
	public String searchId(MemberDTO memeberDto) {
		return null;
	}
	
	/**
	 * ����ã��(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return null;
	}
	
	/**
	 * ����ã��(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return null;
	}
	
	/**
	 * �α����ϱ�
	 * */
	@Override
	public MemberDTO login(String email, String pwd) {
		return null;
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * */
	@Override
	public boolean checkId(String email) {
		return false;
	}
	
	/**
	 * ���������� �̵��� -> ȸ�� ���ϸ��� �� ������������ �ŷ����� ��������
	 * */
	@Override
	public Map<String, Integer> myPageLoading(String email) {
		return null;
	}
	
	/**
	 * ȸ�� ���� �������� �̵��� �� �ʿ��� ������
	 * (�����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, �������(������ �� ��ݾ�,�̹��� �� ��ݾ�))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		return null;
	}
	
	/**
	 * MyPage�� ���γ����� �������
	 * �ٷ� �ֹ�/�����ȸ�� �̷�����鼭
	 * ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 * */
	@Override
	public List<ProductDTO> myPageOrderList(String email) {
		return null;
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * �ش� ��� ����
	 * */
	@Override
	public int deleteOrderProduct(String email) {
		
		return 0;
	}
	
	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 * */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		
		return null;
	}
	
	/**
	 * �ش� �����ۿ� �޸� ��� ��������
	 * */
	@Override
	public String showAnswer(QnaDTO qnaDto) {
		
		return null;
	}
	
	/**
	 * ������ - ��������� ������ ��
	 * */
	@Override
	public List<DonationDTO> myPageDonation(String email) {
		
		return null;
	}
	
	/**
	 * ������ - ������������
	 * */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		
		return null;
	}
	
	/**
	 * ������ - ��ٱ��� �ε�
	 * */
	 @Override
	public List<ProductDTO> myCart(String email) {
		
		return null;
	}
	 
	 /**
	  * ������ - ��ٱ��� -> �ֹ��ϱ� ��ư�� ������ ��
	  * */
	 @Override
	public List<ProductDTO> myCartOrder(String email) {
		
		return null;
	}
	
}
