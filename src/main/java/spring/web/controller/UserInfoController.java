package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userinfo")
@RequestMapping("/user")
public class UserInfoController {
	
	/**
	 * �ΰ� ������ ��
	 * */
	@RequestMapping("logo")
	public void logo() {
		
	}
	
	/**
	 * ȸ������
	 * */
	@RequestMapping("register")
	public void register(){
		
	}
	
	/**
	 * ����ã��(id)
	 * */
	@RequestMapping("searchId")
	public void searchId() {
		
	}
	
	/**
	 * ����ã��(pwd)
	 * ������ ���Ϸ� �����ڵ� ������(ajax)
	 * */
	@RequestMapping("searchPwdSendCode")
	public void searchPwdSendCode() {
		
	}
	
	/**
	 * ����ã��(pwd)
	 * �����ڵ� Ȯ��
	 * �����ڵ� ������ �Ʒ��� ��й�ȣ ����ֱ�(ajax)
	 * */
	@RequestMapping("searchPwdConfirm")
	public void searchPwdConfirm() {
		
	}
	
	/**
	 * �α���
	 * ���� ���̵� admin�̸� ������ ������ �ε�
	 * */
	@RequestMapping("login")
	public void login() {
		
	}
	
	/**
	 * �α׾ƿ�
	 * */
	@RequestMapping("logout")
	public void logout() {
		
	}
	
	 /**
	  * id �ߺ�Ȯ�� (ajax)
	  * */
	@RequestMapping("idCheck")
	public void idCheck() {
		
	}
	
	/**
	  * ��õ�� id �ߺ�Ȯ�� (ajax)
	  * */
	@RequestMapping("recommandIdCheck")
	public void recommandIdCheck() {
		
	}
	
	// ������
	
	/**
	 * ������ ��ư Ŭ������ ��, ù ȭ�� �ε�
	 * ���ϸ���, ���������ֹ����� ��������
	 * */
	@RequestMapping("myPageLoading")
	public void myPageLoading() {
		
	}
	
	/**
	 * ��ȸ������ 12���� ��ɺ� ó��
	 * */
	@RequestMapping("showButton")
	public void showButton(String value) {
		
	}
	
	/**
	 * ���������� ���γ��� ������ ��
	 * �ڵ����� �ֹ�/��� ��ȸ Ŭ����
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageOrderList")
	public void myPageOrderList() {
		
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� ȯ��/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ��â���� �� ����ֱ�
	 * */
	@RequestMapping("requestRefundButton")
	public void requestRefundButton() {
		
	}
	
	/**
	 * ȯ��/��ǰ/��ȯ ������ ������� ��û�ϱ�
	 * */
	@RequestMapping("requestRefund")
	public void requestRefund() {
		
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * ��ϻ���(ajax)
	 * */
	@RequestMapping("requestCancelButton")
	public void requestCancelButton() {
		
	}
	
	/**
	 * ���������� ���/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageCancelList")
	public void myPageCancelList() {
		
	}
	
	/**
	 * ���������� ȯ�� ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageRefundList")
	public void myPageRefundList() {
		
	}
	
	/**
	 * ���������� Q&A ��ư Ŭ������ ��
	 * ��ü ���� ���� ����ֱ�
	 * */
	@RequestMapping("myPageQna")
	public void myPageQna() {
		
	}
	
	/**
	 * Q&A �������� �� ������ Ŭ������ ��
	 * ��â����� �亯���� �����ֱ�
	 * */
	@RequestMapping("showAnswer")
	public void showAnswer() {
		
	}
	
	/**
	 * ���������� ��� ��ư Ŭ������ ��
	 * 3���������� ���� �����ֱ�
	 * */
	@RequestMapping("myPageDonation")
	public void myPageDonation() {
		
	}
	
	/**
	 * ���������� ������������ ��ư Ŭ������ ��
	 * �� ���� �����ͼ� ���̵�, �̸�, ����ó ����ֱ�
	 * */
	@RequestMapping("myPageInfoModify")
	public void myPageInfoModify() {
		
	}
	
	/**
	 * ���������� ���ϸ��� ��ư Ŭ������ ��
	 * ��õ�� ���̵�(5��) + �� ~�� ����ֱ�
	 * ���ϸ��� ��볻���� 3�������� �����ֱ�
	 * */
	@RequestMapping("myPageMileage")
	public void myPageMileage() {
		
	}
	
	/**
	 * ��ٱ��� ��ư Ŭ������ ��
	 * ����¡, cart ���̺��� ������������
	 * �ѱݾ� ����ֱ�
	 * */
	@RequestMapping("myCart")
	public void myCart() {
		
	}
	
	/**
	 * ��ٱ��Ͽ��� ����
	 * */
	@RequestMapping("myCartDelete")
	public void myCartDelete() {
		
	}
	
	/**
	 * ��ٱ��Ͽ� �ֹ���ư Ŭ������ ��
	 * */
	@RequestMapping("myCartOrder")
	public void myCartOrder() {
		
	}
}