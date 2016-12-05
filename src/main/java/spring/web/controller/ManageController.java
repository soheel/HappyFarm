package spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.ProductDTO;
import spring.web.service.ManageService;

@Controller
public class ManageController {

	@Autowired
	ManageService managerService;
	/**
	 * ������ǰ���� Ŭ������ ��
	 * ��ǰ��ȣ ������� (category_subcategory_no�� null�� �ƴѰ͸� ��������)
	 * ����Ʈ��
	 * */
	@RequestMapping("productManage")
	public ModelAndView productManage() {
		/**
		 * 1. ���� ��ǰ ������ ������
		 * 2. proudctDTO�� �ִ� ������ �� �޾ƿͼ� (productlist)
		 * 3.���̺� �������� �ѷ��ش�. ����¡(Datatable�� ����¡)?
		 * 
		 */
		List<ProductDTO> productlist = managerService.selectAllProududct();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", productlist);
		
		mv.setViewName("productManage");
		return mv;
	}
	
	/**
	 * ������ǰ���� ���
	 * ������� div�� �����
	 * */
	@RequestMapping("productRegisterManage")
	public String productRegisterManage(HttpServletRequest request, ProductDTO productDTO ) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div
		 */
		int result = managerService.productRegisterManage(productDTO);
		if(result==0){
			request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "productManage";
	}
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� �����
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, String productno) {
		int result = managerService.productModifyManage(productno);
		if(result==0){
			request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:productManage";
	}
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� ����� (alert)
	 * */
	@RequestMapping("productDeleteManage")
	public String productDeleteManage(HttpServletRequest request, ProductDTO productdto) {
		int result =0;
		result = managerService.productDeleteManage(productdto);
		System.out.println(result);
		return "redirect:productManage";
	}
	
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��
	 * package DTO ����Ʈ
	 * */
	@RequestMapping("packageManage")
	public void packageManage() {
		
	}
	
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	@RequestMapping("packageShowManage")
	public void packageShowManage() {
		
	}
	
	/**
	 * ��Ʈ��ǰ���� ���
	 * ������� div�� �����
	 * */
	@RequestMapping("packageRegisterManage")
	public void packageRegisterManage() {
		
	}
	
	/**
	 * ��Ʈ��ǰ ��Ͽ��� ������ǰ �˻�(ajax)
	 * ��ǰ��ȣ, ��ǰ�̸� �Ʒ��� �߰�
	 * */
	@RequestMapping("packageSearchProduct")
	public void packageSearchProduct() {
		
	}
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	@RequestMapping("packageModifyManage")
	public void packageModifyManage() {
		
	}
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� ����� (alert)
	 * */
	@RequestMapping("packageDeleteManage")
	public void packageDeleteManage() {
		
	}
	
	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * */
	@RequestMapping("producerManage")
	public void producerManage() {
		
	}
	
	/**
	 * ������ ���
	 * */
	@RequestMapping("producerRegisterManage")
	public void producerRegisterManage() {
		
	}
	
	/**
	 * ������ ����
	 * */
	@RequestMapping("producerModifyManage")
	public void producerModifyManage() {
		
	}
	
	/**
	 * ������ ����
	 * (alert)
	 * */
	@RequestMapping("producerDeleteManage")
	public void producerDeleteManage() {
		
	}
	
	/**
	 * �������
	 * �Ѹ����� �ٷ� ������
	 * �Ѹ���, ������, ������
	 * */
	@RequestMapping("salesManage")
	public void salesManage() {
		
	}
	
	/**
	 * �������
	 * ��������
	 * ��Ʈ
	 * */
	@RequestMapping("salesByMonthsManage")
	public void salesByMonthsManage() {
		
	}
	
	/**
	 * �������
	 * �α��
	 * ������Ʈ
	 * */
	@RequestMapping("salesByBestManage")
	public void salesByBestManage() {
		
	}
	
	/**
	 * ȸ������
	 * ȸ�� DTO ����Ʈ(��������)
	 * */
	@RequestMapping("memberManage")
	public void memberManage() {
		
	}
	
	/**
	 * ȸ������(����)
	 * */
	@RequestMapping("memberDeleteManage")
	public void memberDeleteManage() {
		
	}
	
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * */
	@RequestMapping("communityManage")
	public void communityManage() {
		
	}
	
	/**
	 * ���Ӱ���(���)
	 * */
	@RequestMapping("communityRegisterManage")
	public void communityRegisterManage() {
		
	}
	
	/**
	 * ���Ӱ���(����)
	 * */
	@RequestMapping("communityModifyManage")
	public void communityModifyManage() {
		
	}
	
	/**
	 * ���Ӱ���(����)
	 * */
	@RequestMapping("communityDeleteManage")
	public void communityDeleteManage() {
		
	}
	
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	@RequestMapping("qnaManage")
	public void qnaManage() {
		
	}
	
	/**
	 * Q&A �亯 ���
	 * */
	@RequestMapping("qnaRegisterManage")
	public void qnaRegisterManage() {
		
	}
	
	/**
	 * Q&A �亯 ����
	 * */
	@RequestMapping("qnaModifyManage")
	public void qnaModifyManage() {
		
	}
	
	/**
	 * Q&A ���� ����
	 * */
	@RequestMapping("qnaDeleteManage")
	public void qnaDeleteManage() {
		
	}
	
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * */
	@RequestMapping("donationOrgManage")
	public void donationOrgManage() {
		
	}
	
	/**
	 * ��ξ�ü ����(���)
	 * */
	@RequestMapping("donationOrgRegisterManage")
	public void donationOrgRegisterManage() {
		
	}
	
	/**
	 * ��ξ�ü ����(����)
	 * */
	@RequestMapping("donationOrgModifyManage")
	public void donationOrgModifyManage() {
		
	}
	
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * */
	@RequestMapping("donationOrgDeleteManage")
	public void donationOrgDeleteManage() {
		
	}
}
