package spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.PackageDTO;
import spring.web.dto.ProductDTO;
import spring.web.service.ManageService;

@Controller
public class ManageController {

	@Autowired
	ManageService manageService;
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
		List<ProductDTO> productlist = manageService.selectAllProududct();
		
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
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� productDTO ������ ��� �޾�, 
		 * 3. product���̺� �߰��Ѵ�(register)
		 */
		int result = manageService.productRegisterManage(productDTO);
		if(result==0){
			request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:productManage";
	}
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� �����
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, String productno) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		int result = manageService.productModifyManage(productno);
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
	public String productDeleteManage(HttpServletRequest request, String productno) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		int result =0;
		result = manageService.productDeleteManage(productno);
		if(result==0){
			request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:productManage";
	}
	
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��
	 * package DTO ����Ʈ
	 * @return 
	 * */
	@RequestMapping("packageManage")
	public ModelAndView packageManage() {
		/**
		 * 1. ��Ʈ ��ǰ ������ ������
		 * 2. packageDTO�� �ִ� ������ �� �޾ƿͼ� (packagelist) 
		 * * ���� ���� :  package���̺��� package_name, ��Ʈ ������ product�� �ִ� price, ���Ի�ǰ��package_product�� �ִ� product_no�� �� ã�´�.
		 * 3.���̺� �������� �ѷ��ش�. ����¡(Datatable�� ����¡)?
		 * 
		 */
		List<PackageDTO> packagelist = manageService.selectAllPackage();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packagelist", packagelist);
		
		mv.setViewName("packageManage");  
		return mv;
	}
	
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	@RequestMapping("packageShowManage")
	public ModelAndView packageShowManage(String packagename) {
		/**
		 * 1.���� ��ǰ ���� list���� package�̸��� ������ �ش��ϴ� ��Ű�� �̸��� �޾ƿ´�.
		 * 2.package�� �ִ� package_no�� ã�� ��ġ�ϴ� package_product�� �ִ� product_no�� ��� ã�´�.
		 * 3.product�� �ִ� product_name, price, producer_no(no�� ã�� producer���̺��� name)�� ã��, product_no�� ��ġ�ϴ� certification_no�� ã�´�.
		 */
		
		//packagename�� ��ġ�ϴ� package_no�� ã�� package_product�� �ִ� product_no�� ã�´�.
		List<ProductDTO> packageproduct = manageService.selectAllPackageProduct(packagename);
		//�ٸ� �� �� �����ؼ� �޾ƿü��ִ°ǰ�...��
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packageproduct", packageproduct);
		
		mv.setViewName("packageproduct");  
		return mv;
		
	}
	
	/**
	 * ��Ʈ��ǰ���� ���
	 * ������� div�� �����
	 * */
	@RequestMapping("packageRegisterManage")
	public String packageRegisterManage(ProductDTO productDTO, String packagename) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. �Է��� ���� : �̸� (product���̺� �ִ� package_name)
		 * ����,����,���� : product���̺� �ִ� price, profile, desc
		 * ��ǰ�˻� : product_name�� ��ġ�ϴ� product�� ã���ش�
		 * �ؿ� ��ǰ�� productDTO���� insert�ȴ�.
		 */
		packageSearchProduct(packagename);
		int result = manageService.productRegisterManage(productDTO);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:productManage";
	}
	
	/**
	 * ��Ʈ��ǰ ��Ͽ��� ������ǰ �˻�(ajax)
	 * ��ǰ��ȣ, ��ǰ�̸� �Ʒ��� �߰�
	 * */
	@RequestMapping("packageSearchProduct")
	public List<ProductDTO> packageSearchProduct(String productname) {
		/**
		 * 
		 */
		List<ProductDTO> list = null;
		
		list = manageService.packageSearchProduct(productname);
		
		return list;
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
