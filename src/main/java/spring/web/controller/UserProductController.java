package spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
		 * 3. ������ ������ �����´�.
		 * 4. �̶� ProductDTO�� ProducerDTO�� ���� �������� Map�� ��� ��Ʈ�ѷ����� ���� ��
		 * �̸� ModelandView�� ��� ��� �Ѱ��ش�.
		 * 
		 * + CertificationDTO, ProductCommentDTO�� �ʿ�
		 * */
		Map<String, Object> map = service.showProductDetail(productNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
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
	public int addCart(String productNo, int num, HttpSession session) {
		/**
		 * 1. ���� ��ǰ�� ���� ��ǰ��ȣ�� �μ��� �޴´�.
		 * 2. ȸ���� ���̵� �ش��ϴ� cart ���̺� �ش� ��ǰ�� ������ insert�Ѵ�.
		 * */
		
		String email = (String)session.getAttribute("email");
		int result = service.addCart(productNo, num, email);
		return result; // �信�� ��ȯ���� 1�̻��� �ƴϸ� ��ٱ��ϴ�� ���ж�� alert ����ֱ�
	}

	/**
	 * �ֹ�ȭ�鿡�� �ֹ��ϱ� ��ư ������ ��
	 * */
	@RequestMapping("order")
	public ModelAndView order(Map<String, Object> map, String num) {
		/**
		 * 1. ��ǰ �󼼺��⸦ ���� ���¶�� request�� �̹� ��ǰ����, ������������ ���� map�� ���� ���̹Ƿ�
		 * �� map�� �ٽ� ������ �����༭ �̸� ModelAndView�� ��� �ٽ� view�� �����ָ� �ȴ�.
		 * 2. �̶� ����ڰ� �����Ϸ����� ��ǰ�� ������ �Բ� �����ָ� �ȴ�. 
		 * */
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.addObject("num", num);
		mv.setViewName("purchase");
		return mv;
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
	public ModelAndView packageMenuListLoading() {
		/**
		 * 1. pacakage ���̺��� ��ϼ����� List<ProductDTO>�� ��� ����
		 * */
		
		List<ProductDTO> list = service.packageMenuListLoading();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("searchProduct");
		return mv;
	}
	
	/**
	 * ��Ű�� ��ǰ �󼼺���
	 * ��Ű��DTO
	 * */
	@RequestMapping("showPackageDetail")
	public void showPackageDetail() {
		
	}

}
