package spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.service.UserProductService;

@Controller
@RequestMapping("/user")
public class UserProductController {

	@Autowired
	UserProductService service;
	
	/**
	 * shop�� ���콺 �÷��� �� �޴� �ҷ�����
	 * ��з� 3�� �ҷ�����
	 * �α��ǰ purchase���̺��� product_no �������� 3��
	 * ������ǰ ��,����,����
	 * �ֱٱ���(������ ��ĭ)
	 * */
	@RequestMapping("shopMenuLoading")
	public List<ProductDTO> shopMenuLoading() {
		/**
		 * 1. shop�� ���콺 ����
		 * 2. �α��ǰ, ������ǰ, �ֱٱ��Ÿ� 
		 * List<ProductDTO>�� ������� 9�� ��Ƽ�
		 * ��� �����ֱ�
		 * �α��ǰ, ������ǰ, �ֱٱ��Ÿ� 3���� �̾��ִ� dao�� �޼ҵ尡 3�� �ʿ�
		 * �� 3���� �޼ҵ带 ��� ������ showMenuLoading���� �ҷ��༭ �̸� 
		 * list�� �־ ��Ʈ�ѷ��� ��ȯ
		 * */
		List<ProductDTO> list = null;
		list = service.shopMenuLoading();
		return list;
	}
	
	/**
	 * shop �޴��ٿ��� ī�װ� ������ �� 9�� ����Ʈ �ѷ��ֱ�
	 * ��ϼ�(product ���̺��� product_no ��������)
	 * */
	@RequestMapping("shopMenuListLoading")
	public ModelAndView showMenuListLoading(String categoryNo) {
		/**
		 * 1. ����ڰ� ������ ī�װ��� �μ��� ����
		 * 2. ���� ī�װ��� �̿��ؼ� dao�� ���� ��ϼ����� List<ProductDTO>�� ���� �� ��� ��ȯ����
		 * 
		 * categoryNo
		 * 1 - ����/�߰�
		 * 2 - ä��
		 * 3 - ��/���
		 * */
		
		List<ProductDTO> list = null;
		ModelAndView mv = new ModelAndView();
		list = service.showMenuListLoading(categoryNo);
		mv.addObject("list",list);
		mv.setViewName("searchProduct");
		return mv;
	}
	
	/**
	 * ������ǰ ������
	 * �̸�,����,����,ī�װ�,����,�����ʻ���,���,����,������, �ش� ��ǰ�� ��ġ�ϴ� ������ũ����
	 * */
	@RequestMapping("showProductDetail")
	public ModelAndView showProductDetail(String productNo) {
		/**
		 * 1. �ش� ��ǰ ������ ������ �ش� ��ǰ�� productNo�� ������ �μ��� �Ѱ���
		 * 2. ���� �μ�(productNo)�� dao�� �Ѱܼ� �ش� ��ǰ DTO(ProductDTO)�� �޾ƿ´�.
		 * 3. �޾ƿ� ��ǰ������ ��ȯ�Ѵ�.
		 * */
		ProductDTO productDTO = service.showProductDetail(productNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", productDTO);
		mv.setViewName("productDetail");
		return mv;
	}
	
	/**
	 * ������ǰ���� ������ ���� Ŭ������ ��
	 * ��â���� ������ ���� �˷��ֱ�
	 * */
	@RequestMapping("showProducerInfo")
	public ModelAndView showProducerInfo(String producerNo) {
		/**
		 * 1. �信�� ������ �̸��� Ŭ������ ��, ������ ��ȣ�� �Բ� �μ��� ���޵�
		 * 2. �μ��� dao�� ������ ������ DTO(ProducerDTO)�� �޾� �̸� ��� ��ȯ
		 * */
		
		ProducerDTO producerDTO = service.showProducerInfo(producerNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("producer",producerDTO);
		mv.setViewName("producerInfo"); // producerInfo.jsp�� ��������
		return mv;
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
