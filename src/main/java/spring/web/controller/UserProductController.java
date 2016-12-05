package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserProductController {

	/**
	 * shop�� ���콺 �÷��� �� �޴� �ҷ�����
	 * ��з� 3�� �ҷ�����
	 * �α��ǰ purchase���̺��� product_no �������� 3��
	 * ������ǰ ��,����,����
	 * �ֱٱ���(������ ��ĭ)
	 * */
	@RequestMapping("shopMenuLoading")
	public void shopMenuLoading() {
		
	}
	
	/**
	 * shop �޴��ٿ��� ī�װ� ������ �� 9�� ����Ʈ �ѷ��ֱ�
	 * ��ϼ�(product ���̺��� product_no ��������)
	 * */
	@RequestMapping("shopMenuListLoading")
	public void showMenuListLoading() {
		
	}
	
	/**
	 * ������ǰ ������
	 * �̸�,����,����,ī�װ�,����,�����ʻ���,���,����,������, �ش� ��ǰ�� ��ġ�ϴ� ������ũ����
	 * */
	@RequestMapping("showProductDetail")
	public void showProductDetail() {
		
	}
	
	/**
	 * ������ǰ���� ������ ���� Ŭ������ ��
	 * ��â���� ������ ���� �˷��ֱ�
	 * */
	@RequestMapping("showProducerInfo")
	public void showProducerInfo() {
		
	}
	
	/**
	 * ��ٱ��Ͽ� ���
	 * */
	@RequestMapping("addCart")
	public void addCart() {
		
	}
	
	/**
	 * ��ǰ ���������� �����ϱ��ư Ŭ������ ��
	 * */
	@RequestMapping("purchase")
	public void purchase() {
		
	}
	
	/**
	 * �ֹ�ȭ��
	 * */
	@RequestMapping("order")
	public void order() {
		
	}
	
	/**
	 * �ֹ�ȭ�鿡�� �����ȣ ��������
	 * */
	@RequestMapping("getPostcode")
	public void getPostcode() {
		
	}
	
	/**
	 * �ֹ�ȭ�鿡�� ������ư Ŭ������ ��
	 * */
	@RequestMapping("pay")
	public void pay() {
		
	}
	
	/**
	 * �˻�
	 * */
	@RequestMapping("search")
	public void search() {
		
	}
	
	// ��Ű��
	
	/**
	 * package �޴��ٿ��� ī�װ� ������ �� 9�� ����Ʈ �ѷ��ֱ�
	 * */
	@RequestMapping("packageMenuListLoading")
	public void packageMenuListLoading() {
		
	}
	
	/**
	 * ��Ű�� ��ǰ �󼼺���
	 * ��Ű��DTO
	 * */
	@RequestMapping("showPackageDetail")
	public void showPackageDetail() {
		
	}

}
