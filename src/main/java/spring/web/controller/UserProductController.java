package spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;
import spring.web.service.UserProductService;

@Controller
@RequestMapping("/userProductController")
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
	@ResponseBody
	public List<ProductDTO> shopMenuLoading(HttpSession session) {
		/**
		 * 1. shop�� ���콺 ����
		 * 2. �α��ǰ, ������ǰ, �ֱٱ��Ÿ� 
		 * List<ProductDTO>�� ������� 9�� ��Ƽ�
		 * ��� �����ֱ�
		 * �α��ǰ, ������ǰ, �ֱٱ��Ÿ� 3���� �̾��ִ� dao�� �޼ҵ尡 3�� �ʿ�
		 * �� 3���� �޼ҵ带 ��� ������ showMenuLoading���� �ҷ��༭ �̸� 
		 * list�� �־ ��Ʈ�ѷ��� ��ȯ
		 * */
		String email = (String)session.getAttribute("email");
		System.out.println(email);
		if(email == null) {
			email = " ";
		}
		List<ProductDTO> list = null;
		list = service.shopMenuLoading(email);
		
		System.out.println(list.size());
		return list;
	}
	 
	/**
	 * shop �޴��ٿ��� ī�װ� ������ �� 9�� ����Ʈ �ѷ��ֱ�
	 * ��ϼ�(product ���̺��� product_no ��������)
	 * */
	@RequestMapping("shopMenuListLoading")
	public ModelAndView showMenuListLoading(int categoryNo) {
		/**
		 * 1. ����ڰ� ������ ī�װ��� �μ��� ����
		 * 2. ���� ī�װ��� �̿��ؼ� dao�� ���� ��ϼ����� List<ProductDTO>�� ���� �� ��� ��ȯ����
		 * */
		System.out.println("shopMenuListLoading() ���� " + categoryNo);
		List<ProductDTO> list = null;
		ModelAndView mv = new ModelAndView();
		list = service.showMenuListLoading(categoryNo);
		System.out.println(list.size() + " : list�� size");
		mv.addObject("list", list);
		mv.setViewName("shop/searchProduct");
		
		return mv;
	}
	
	/**
	 * ������ǰ ������
	 * �̸�,����,����,ī�װ�,����,�����ʻ���,���,����,������, �ش� ��ǰ�� ��ġ�ϴ� ������ũ����
	 * */
	@RequestMapping("showProductDetail")
	public ModelAndView showProductDetail(int productNo) {
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
		ProductDTO product = (ProductDTO)map.get("product");
		List<ProductCommentDTO> productCommentList = (List<ProductCommentDTO>)map.get("productComment");
		List<CertificationDTO> certificationList = (List<CertificationDTO>)map.get("certification");
		ProducerDTO producer = (ProducerDTO)map.get("producer");
		String categoryName = (String)map.get("categoryName");
		
		mv.addObject("product", product);
		mv.addObject("productCommentList", productCommentList);
		mv.addObject("certificationList", certificationList);
		mv.addObject("producer", producer);
		mv.addObject("categoryName", categoryName);
		mv.setViewName("shop/productDetail");
		return mv;
	}
	
	/**
	 * ������ǰ���� ������ ���� Ŭ������ ��
	 * ��â���� ������ ���� �˷��ֱ�
	 * */
	@RequestMapping("showProducerInfo")
	public ModelAndView showProducerInfo(int producerNo) {
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
	 * ��ٱ��Ͽ� ���(��ǰ �󼼺��� ȭ�鿡�� ��ٱ��Ͽ� ���� ���)
	 * */
	@RequestMapping("addCart")
	@ResponseBody
	public int addCart(CartDTO cart, HttpSession session) {
		/**
		 * 1. ���� ��ǰ�� ���� ��ǰ��ȣ�� �μ��� �޴´�.
		 * 2. ȸ���� ���̵� �ش��ϴ� cart ���̺� �ش� ��ǰ�� ������ insert�Ѵ�.
		 * */
		
		String email = (String)session.getAttribute("email");
		cart.setEmail(email);
		System.out.println(cart.getEmail());
		System.out.println(cart.getProductNo());
		System.out.println(cart.getNum());
		int result = service.addCart(cart);
		
		System.out.println("result : " + result);
		return result; // �信�� ��ȯ���� 1�̻��� �ƴϸ� ��ٱ��ϴ�� ���ж�� alert ����ֱ�
	}
	
	/**
	 * ��ٱ��Ͽ� ���(��ǰ ����Ʈ���� �ٷ� ��ٱ��Ͽ� ���� ���)
	 * */
	@RequestMapping("addCartDirect")
	@ResponseBody
	public int addCartDirect(CartDTO cart, HttpSession session) {
		/**
		 * 1. ���� ��ǰ�� ���� ��ǰ��ȣ�� �μ��� �޴´�.
		 * 2. ȸ���� ���̵� �ش��ϴ� cart ���̺� �ش� ��ǰ�� insert�Ѵ�. (������ 1)
		 * */
		
		String email = (String)session.getAttribute("email");
		cart.setEmail(email);
		cart.setNum(1);
		System.out.println(cart.getEmail());
		System.out.println(cart.getProductNo());
		System.out.println(cart.getNum());
		
		//cart.setEmail(email);
		int result = service.addCartDirect(cart);
		System.out.println(result + " result ��");
		return result; // �信�� ��ȯ���� 1�̻��� �ƴϸ� ��ٱ��ϴ�� ���ж�� alert ����ֱ�
	}

	/**
	 * ��ǰ �󼼺��� ȭ�鿡�� �ֹ��ϱ� ��ư ������ ��
	 * */
	@RequestMapping("order")
	public ModelAndView order(int productNo, int num) {
		/**
		 * 1. �信�� ��ǰ��ȣ(product_no)�� �����Ϸ��� ������ �޾ƿ´�.
		 * 2. ��ǰ��ȣ�� �̿��� ��ǰDTO�� ������DTO, ������ map�� ��� �ٽ� ��� ������.
		 * */
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = service.order(productNo, num);
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
	 * ��ǰ �󼼺��⿡�� purchase Ŭ������ ��
	 * */
	@RequestMapping("purchase")
	public ModelAndView purchase(int productNo, int producerNo, int quantity, int price, HttpSession session) {
		System.out.println("purchase");
		Map<String, Object> map = null;
		ModelAndView mv = new ModelAndView();
		// productDTO ��������
		// producerDTO ��������
		// �� �� ������ �ѹ��� ó���� service ȣ��
		map = service.showPurchase(productNo, producerNo, (String)session.getAttribute("email"));
		ProductDTO productDTO = (ProductDTO)map.get("productDTO");
		ProducerDTO producerDTO = (ProducerDTO)map.get("producerDTO");
		int mileage = (Integer)map.get("mileage");
		mv.addObject("product", productDTO);
		mv.addObject("producer", producerDTO);
		mv.addObject("mileage", mileage);
		mv.setViewName("order/orderCard");
		
		// �� ���� ��������
		int totalPrice = quantity * price;
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("quantity", quantity);
		
		return mv;
	}
	
	/**
	 * �ֹ�ȭ�鿡�� ������ư Ŭ������ ��
	 * */
	@RequestMapping("pay")
	@ResponseBody
	public String pay() {
		return "pay";
	}
	
	/**
	 * �˻�
	 * */
	@RequestMapping("search")
	public ModelAndView search(String keyword) {
		/**
		 * 1. ��κ��� ���޵� keyword�� dao�� �����Ͽ� product ���̺��� product_name��
		 * keyword�� ���ԵǴ� ��� ��ǰ���� dto�� ���� list�� modelandview�� �����ϰ�
		 * �̸� �信 ��ȯ�Ѵ�.
		 * */
		
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> list = null;
		list = service.search(keyword);
		
		mv.addObject("list", list);
		mv.setViewName("shop/searchProduct"); // �˻� ����� �ѷ��� ��
		
		return mv;
	}
	
	// ��Ű��
	
	/**
	 * package �޴��ٸ� ������ �� 9�� ����Ʈ �ѷ��ֱ�
	 * */
	@RequestMapping("packageMenuListLoading")
	public ModelAndView packageMenuListLoading() {
		/**
		 * 1. pacakage ���̺��� ��ϼ����� List<ProductDTO>�� ��� ����
		 * */
		
		List<ProductDTO> list = service.packageMenuListLoading();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("package/package");
		return mv;
	}
	
	/**
	 * ��Ű�� ��ǰ �󼼺���
	 * ��Ű��DTO
	 * */
	@RequestMapping("showPackageDetail")
	public ModelAndView showPackageDetail() {
		System.out.println("showPackageDetail �޼ҵ�");
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = service.getPackageDetail();
		ProductDTO productDTO = (ProductDTO)map.get("productDTO");
		List<ProductDTO> list = (List<ProductDTO>)map.get("list");
		mv.addObject("packageProduct", productDTO);
		mv.addObject("list", list);
		mv.setViewName("package/packageDetail");
		return mv;
	}
}
