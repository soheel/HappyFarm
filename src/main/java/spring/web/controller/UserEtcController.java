package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserEtcController {
	
	// ����
	
	/**
	 * ���Ӹ�� �ҷ�����
	 * ����DTO ����Ʈ
	 * */
	@RequestMapping("communityLoading")
	public void communityLoading() {
		
	}
	
	/**
	 * ���� �󼼺���
	 * ����DTO, ������ ���̵�ٿ� �������� ��� ��� ��������
	 * */
	@RequestMapping("communityDetail")
	public void communityDetail() {
		
	}
	
	// Q&A
	
	/**
	 * Q&A �Խ��� Ŭ������ ��
	 * qna DTO ����Ʈ
	 * */
	@RequestMapping("qnaLoading")
	public void qnaLoaidng() {
		
	}
	
	/**
	 * Q&A �۾���
	 * */
	@RequestMapping("qnaWrite")
	public void qnaWrite() {
		
	}
	
	// ����
	
	/**
	 * info ������ �� 
	 * info DTO ����Ʈ ��������
	 * */
	@RequestMapping("infoLoading")
	public void infoLoading() {
		
	}
	
	/**
	 * info �󼼺���
	 * info DTO ��������
	 * */
	@RequestMapping("infoDetail")
	public void infoDetail() {
		
	}
	
	// ���
	
	/**
	 * donation ������ ��
	 * ��ü�����Ȳ(5��) �������� �ٿ�ε�
	 * ��Ʈ
	 * */
	@RequestMapping("donationLoading")
	public void donationLoading() {
		
	}
	
	// ����
	
	/**
	 * ������ �󼼺���
	 * ������ DTO, ����
	 * */
	@RequestMapping("producerDetail")
	public void producerDetail() {
		
	}
}
