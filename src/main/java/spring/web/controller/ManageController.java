package spring.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;
import spring.web.service.ManageService;

@Controller
@RequestMapping("/manageController")
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
		List<ProductDTO> productlist = manageService.selectAllProduct();
		System.out.println(productlist.get(0).getName());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", productlist);
		
		mv.setViewName("admin/adminShopItem");  
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
	
	/** div�� ������ �ҷ��ͼ� ...
	 * ������ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 
	@RequestMapping("productInfoMangage")
	public ProductDTO productInfoMangage(String no){
		ProductDTO product = manageService.productInfoMangage(no);
		
		return product;
	}*/
	
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� �����
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, ProductDTO productDTO) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		int result = manageService.productModifyManage(productDTO);
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
	public String productDeleteManage(HttpServletRequest request, int no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		int result =0;
		result = manageService.productDeleteManage(no);
		if(result==0){
			request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:productManage";
	}
	
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��
	 * package DTO ����Ʈ
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
		List<PackageDTO> packagelist = manageService.packageManage();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packagelist", packagelist);
		
		mv.setViewName("admin/packageItem");  
		return mv;
	}
	
	/**
	 * ��Ʈ��ǰ ������ packagename�� �μ��� �޴´�.
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	@RequestMapping("packageShowManage")
	public ModelAndView packageShowManage(String name) {
		/**
		 * 1.���� ��ǰ ���� list���� package�̸��� ������ �ش��ϴ� ��Ű�� �̸��� �޾ƿ´�.
		 * 2.package�� �ִ� package_no�� ã�� ��ġ�ϴ� package_product�� �ִ� product_no�� ��� ã�´�.
		 * 3.product�� �ִ� product_name, price, producer_no(no�� ã�� producer���̺��� name)�� ã��, product_no�� ��ġ�ϴ� certification_no�� ã�´�.
		 */
		
		//packagename�� ��ġ�ϴ� package_no�� ã�� package_product�� �ִ� product_no�� ã�´�.
		List<ProductDTO> packageproduct = manageService.packageShowManage(name);
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
	public String packageRegisterManage(PackageDTO packageDTO, String name) {
		Map<String, Object> packageRegister = new HashMap<String, Object>();
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. �Է��� ���� : �̸� (product���̺� �ִ� package_name)
		 * ����,����,���� : product���̺� �ִ� price, profile, desc
		 * ��ǰ�˻� : product_name�� ��ġ�ϴ� product�� ã���ش�
		 * �ؿ� ��ǰ�� productDTO���� insert�ȴ�.
		 */
		ProductDTO productDTO = packageSearchProduct(name);
		
		packageRegister.put("productDTO", productDTO);
		packageRegister.put("packageDTO", packageDTO);
		
		int result = manageService.packageRegisterManage(packageRegister);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:packageproduct";
	}
	
	/**
	 * ��Ʈ��ǰ ��Ͽ��� ������ǰ �˻�(ajax)- productname�� �޴´�.
	 * ��ǰ��ȣ, ��ǰ�̸� �Ʒ��� �߰�
	 * */
	@RequestMapping("packageSearchProduct")
	public ProductDTO packageSearchProduct(String name) {
		/**
		 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
		 */
		ProductDTO productDTO = manageService.packageSearchProduct(name);
		
		return productDTO;
	}
	
	//div�±��̹Ƿ�, �� �ʿ� ���� ���̴�. ���� ����Ǿ� �ֱ� ������
	/** div�� ������ �ҷ��ͼ� ...productno�� �޴´�.
	 * //���������� product�� �ش��ϴ� productname�� �ش��ϴ� ��ǰ dto�� ���� ������ �޾� ���� ���� �ʿ��� �޼ҵ�		
		ProductDTO product = manageService.selectByPackageName(productDTO)
	 * ��Ʈ��ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	
	@RequestMapping("packageInfoMangage")
	public ProductDTO packageInfoMangage(String no){
		ProductDTO product = null;
		product = manageService.packageInfoMangage(no);
		
		return product;
	} */
	
	/**
	 * ��Ʈ��ǰ���� ���� (productname�� �μ��� ����)
	 * �������� div�� �����
	 * @return 
	 * */
	@RequestMapping("packageModifyManage")
	public String packageModifyManage(ProductDTO productDTO, String name) {
		
		Map<String, Object> modifyinfo = new HashMap<String, Object>();
		/**
		 * ��Ű�� �̸��� ������ ������ ������ ������� ���� div�� �������.
		 * 2. �Է��� ���� : �̸� (product���̺� �ִ� package_name)
		 * ����,����,���� : product���̺� �ִ� price, profile, desc
		 * ��ǰ�˻� : product_name�� ��ġ�ϴ� product�� ã���ش�
		 * �ؿ� ��ǰ�� productDTO���� modify�ȴ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		
		//���������� ��ǰ �˻��ϱ� ���ؼ� �ʿ��� �޼ҵ�
		ProductDTO searchlist = packageSearchProduct(name);
		
		modifyinfo.put("productDTO", productDTO);
		modifyinfo.put("searchlist", searchlist);
		
		int result = manageService.packageModifyManage(modifyinfo);
		
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:packageproduct";
	}
	
	/**
	 * ��Ʈ��ǰ���� ����(�μ� : productname)
	 * �������� div�� ����� (alert)
	 * */
	@RequestMapping("packageDeleteManage")
	public String packageDeleteManage(String name) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		int result =0;
		result = manageService.packageDeleteManage(name);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:packageproduct";
	}
	
	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * @return 
	 * */
	@RequestMapping("producerManage")
	public ModelAndView producerManage() {
		/**
		 * 1. �����ڰ����� ������
		 * 2. proudcerDTO�� �ִ� ������ �� �޾ƿͼ� (producerlist)
		 * 3.���̺� �������� �ѷ��ش�. ����¡(Datatable�� ����¡)?
		 *  */
		List<ProductDTO> producerlist = manageService.selectAllProducer();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("producerlist", producerlist);
		
		mv.setViewName("producerManage");  
		return mv;
	}
	
	/**
	 * ������ ���
	 * @return 
	 * */
	@RequestMapping("producerRegisterManage")
	public String producerRegisterManage(ProducerDTO producerDTO) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� producerDTO ������ ��� �޾�, 
		 * 3. producer���̺� �߰��Ѵ�(register)
		 */
		int result = manageService.producerRegisterManage(producerDTO);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:producerManage";
	}
	
	
	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.producerno
	 */
	public ProducerDTO producerInfoMangage(String no){
		ProducerDTO producer = null;
		producer = manageService.producerInfoMangage(no);
		
		return producer;
	}
	/**
	 * ������ ����
	 * */
	@RequestMapping("producerModifyManage")
	public String producerModifyManage(ProducerDTO producerDTO) {
		/**
		 * Ư�� �������� ��ȣ�� �޾ƿ� producerno
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */

		int result = manageService.producerModifyManage(producerDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:producerManage";
	}
	
	/**
	 * ������ ����
	 * (alert)
	 * */
	@RequestMapping("producerDeleteManage")
	public String producerDeleteManage(int no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ�  (�μ� : producerno)
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * alert�� �޽��� ���.
		 */
		int result =0;
		result = manageService.producerDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:producerManage";
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
	 * @return 
	 * */
	@RequestMapping("memberManage")
	public ModelAndView memberManage() {
		/**
		 * 1. ȸ�������� ������
		 * 2. MemberDTO�� �ִ� ������ �� �޾ƿͼ� (memberlist)
		 * ���� : member_email, memeber_name, member_phone, member_register_date, 
		 * select�� �ϴµ� ������������ ���ش�.
		 * 3.���̺� �������� �ѷ��ش�. ����¡(Datatable�� ����¡)?
		 *  */
		List<ProductDTO> memberlist = manageService.selectAllMember();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		
		mv.setViewName("memberManage");  
		return mv;
	}
	
	/**
	 * ȸ������(����)
	 * */
	@RequestMapping("memberDeleteManage")
	public String memberDeleteManage(String email) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * alert�� �޽��� ���.
		 */
		int result =0;
		result = manageService.memberDeleteManage(email);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:memberManage";
	}
	
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * @return 
	 * */
	@RequestMapping("communityManage")
	public ModelAndView communityManage() {
		/**
		 * 1. commuity�� ������, 
		 * 2. �� 9���� ��Ƽ� ��� �����ش�. community_profile���� / commuinty_name, community_register_date�� �����ش�.
		 * 3. ��ü ��縦 �̴� dao �� ���� �޼ҵ�� (community_state ���¸� Ȯ�� �� ��)
		 * ������ ��� �޼ҵ尡 �ʿ�. 
		 */
		List<CommunityDTO> communitylist = null;
		ModelAndView mv = new ModelAndView();
		communitylist = manageService.communityManage();
		if(communitylist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("communitylist",communitylist);
		mv.setViewName("communityManage");
		return mv;
	}
	
	/**
	 * ���Ӱ���(���)
	 * */
	@RequestMapping("communityRegisterManage")
	public String communityRegisterManage(CommunityDTO communityDTO) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� communityDTO ������ ��� �޾�, 
		 * 3. community���̺� �߰��Ѵ�(register)
		 */
		int result = manageService.communityRegisterManage(communityDTO);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:communityManage";
	}
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.(comunityno)
	
	public CommunityDTO communityInfoMangage(String no){
		CommunityDTO community = null;
		community = manageService.communityInfoMangage(no);
		
		return community;
	} */
	
	/**
	 * ���Ӱ���(����)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityModifyManage")
	public String communityModifyManage(CommunityDTO communityDTO) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� community�� ���� ������ �Ѿ��.
		 */
		int result = manageService.communityModifyManage(communityDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:communityManage";
	}
	
	/**
	 * ���Ӱ���(����)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityDeleteManage")
	public String communityDeleteManage(String no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� community������ ���� ������ �Ѿ��.
		 */
		int result =0;
		result = manageService.communityDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:communityManage";
	}
	
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	@RequestMapping("qnaManage")
	public ModelAndView qnaManage() {
		/**
		 * 1. Q&A������ ������, 
		 * 2. ��ü Q&A������ �̴� dao �޼ҵ�/ ������ ��� �޼ҵ尡 �ʿ�. 
		 */
		List<QnaDTO> qnalist = null;
		ModelAndView mv = new ModelAndView();
		qnalist = manageService.qnaManage();
		if(qnalist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("qnalist",qnalist);
		mv.setViewName("qnaManage");
		return mv;
	}
	
	/**
	 * Q&A �亯 ���
	 * @return 
	 * */
	@RequestMapping("qnaRegisterManage")
	public String qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� communitycommentDTO ������ ��� �޾�, 
		 * 3. community���̺� �߰��Ѵ�(ajax)
		 */
		int result = manageService.qnaRegisterManage(communitycommentDTO);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:qnaManage";
	}
	
	/**
	 * �������� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.(qnano)
	 
	public QnaDTO qnaInfoMangage(String no){
		QnaDTO qna = null;
		qna = manageService.qnaInfoMangage(no);
		
		return qna;
	}*/
	/**
	 * Q&A �亯 ����(communitycommentno)
	 * */
	@RequestMapping("qnaModifyManage")
	public String qnaModifyManage(QnaDTO qnaDTO) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� qna�� ���� ������ �Ѿ��.
		 */
		int result = manageService.qnaModifyManage(qnaDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:qnaManage";
	}
	
	/**
	 * Q&A ���� ����(communitycommentno)
	 * @return 
	 * */
	@RequestMapping("qnaDeleteManage")
	public String qnaDeleteManage(String no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� qna�� ���� ������ �Ѿ��.
		 */
		int result =0;
		result = manageService.qnaDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:qnaManage";
	}
	
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * @return 
	 * */
	@RequestMapping("donationOrgManage")
	public ModelAndView donationOrgManage() {
		/**
		 * ��� ��ü ������ Ŭ���ϸ�, �ش��ϴ� ��ξ�ü DTO�� ������ �޾Ƽ� (select) �信 �ѷ��ش�.
		 */
		List<DonationDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = manageService.donationOrgManage();
		if(donationlist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("donationlist",donationlist);
		mv.setViewName("donationOrgManage");
		return mv;
	}
	
	/**
	 * ��ξ�ü ����(���)
	 * @return 
	 * */
	@RequestMapping("donationOrgRegisterManage")
	public String donationOrgRegisterManage(DonationDTO donationDTO) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� communityDTO ������ ��� �޾�, 
		 * 3. community���̺� �߰��Ѵ�(register)
		 */
		int result = manageService.donationOrgRegisterManage(donationDTO);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:donationOrgManage";
	}
	
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public DonationDTO donationOrgInfoMangage(String donationOrgno){
		DonationDTO donation = null;
		donation = manageService.donationOrgInfoMangage(donationOrgno);
		
		return donation;
	}
	
	/**
	 * ��ξ�ü ����(����)
	 * @return 
	 * */
	@RequestMapping("donationOrgModifyManage")
	public String donationOrgModifyManage(DonationDTO donationDTO) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� community������ ���� ������ �Ѿ��.
		 */
		int result = manageService.donationOrgModifyManage(donationDTO);
			if(result==0){
				//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");	
			}
			return "forward:donationOrgManage";
	}
	
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * @return 
	 * */
	@RequestMapping("donationOrgDeleteManage")
	public String donationOrgDeleteManage(int no) {
		/**
		 * Ư�� ��ξ�ü ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� donation������ ���� ������ �Ѿ��.
		 */
		int result =0;
		result = manageService.donationOrgDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return "forward:donationOrgManage";
	}
}
