package spring.web.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
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
		System.out.println("productManage");
		List<ProductDTO> productlist = manageService.selectAllProduct();
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
	public String productRegisterManage(HttpServletRequest request, ProductDTO productDTO, HttpSession session, MultipartHttpServletRequest multipartRequest) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� productDTO ������ ��� �޾�, 
		 * 3. product���̺� �߰��Ѵ�(register)
		 */
		System.out.println("productRegisterManage");
		/**
		 * fileList���� ������� profile, desc ���ϸ��� �������
		 * �̸� ���� ������ productDTO�� ����
		 * */
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		String profile = fileList.get(0).getOriginalFilename();
		String desc = fileList.get(1).getOriginalFilename();
		productDTO.setProfile(profile);
		productDTO.setDesc(desc);
		
		if(profile.equals("") || desc.equals("")) {
			return "forward:productManage";
		}
		
		// ���� ���ε�
		String saveDir = session.getServletContext().getRealPath("/resources/img/product");
		try {
			fileList.get(0).transferTo(new File(saveDir + "/" + profile));
			fileList.get(1).transferTo(new File(saveDir + "/" + desc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = manageService.productRegisterManage(productDTO);
		return "forward:productManage";
	}
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� �����
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, ProductDTO productDTO, HttpSession session, MultipartHttpServletRequest multipartRequest) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		System.out.println("productModifyManage");
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		String profile = fileList.get(0).getOriginalFilename();
		String desc = fileList.get(1).getOriginalFilename();
		productDTO.setProfile(profile);
		productDTO.setDesc(desc);
		
		if(profile.equals("")) {
			profile = productDTO.getProfile();
		}else if(desc.equals("")) {
			desc = productDTO.getDesc();
		}
		
		productDTO.setProfile(profile);
		productDTO.setDesc(desc);

		// ���� ���ε�
		String saveDir = session.getServletContext().getRealPath("/resources/img/product");
		File profileFile = new File(saveDir + "/" + profile);
		File descFile = new File(saveDir + "/" + desc);
		try {
			// ������ ���� �̸��� ������ �ִٸ� �̸��� ��������
			// �տ� ���ڸ� ���� ������ System.currentTimeMillis()�� �ص� �ʹ� ����
			// ���� �̸��� �������� ����
			if(profileFile.exists()) {
				profileFile.delete();
				long tempProfileFileName = System.currentTimeMillis();
				profile = "1" + tempProfileFileName;
				profileFile = new File(saveDir + "/" + profile);
				productDTO.setProfile(profile);
			}else {
				profileFile.delete();
			}
			if(descFile.exists()) {
				descFile.delete();
				long tempDescFileName = System.currentTimeMillis();
				desc = "2" + tempDescFileName;
				descFile = new File(saveDir + "/" + desc);
				productDTO.setDesc(desc);
			}else {
				descFile.delete();
			}
			
			
			fileList.get(0).transferTo(profileFile);
			fileList.get(1).transferTo(descFile);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int result = manageService.productModifyManage(productDTO);
		return "forward:productManage";
	}
	
	/**
	 * ���� ��ǰ ������ ������ ��, ������ ������ ����ֱ�
	 * */
	@RequestMapping("productModifyShowManage")
	@ResponseBody
	public ProductDTO productModifyShowManage(int no) {
		System.out.println("productModifyShowManage");
		// ��ǰ��ȣ�� ���� ��ǰDTO ��������
		ProductDTO product = manageService.productInfoMangage(no);
		System.out.println(product.getEval() + "!!!");
		return product;
	}
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� ����� (alert)
	 * */
	@RequestMapping("productDeleteManage")
	@ResponseBody
	public int productDeleteManage(int no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		System.out.println("productDeleteManage");
		int result = manageService.productDeleteManage(no);
		return result;
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
		Map<String, Object> map = manageService.selectAllProducer();
		
		List<ProducerDTO> producerlist = (List<ProducerDTO>)map.get("producerList");
		List<Integer> evalList = (List<Integer>)map.get("evalList");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("producerlist", producerlist);
		mv.addObject("evalList", evalList);
		mv.setViewName("admin/adminProducer");  
		return mv;
	}
	
	/**
	 * ������ ���
	 * @return 
	 * */
	@RequestMapping("producerRegisterManage")
	public String producerRegisterManage(HttpServletRequest request, ProducerDTO producerDTO, @RequestParam MultipartFile file, HttpSession session) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� producerDTO ������ ��� �޾�, 
		 * 3. producer���̺� �߰��Ѵ�(register)
		 */
		System.out.println("producerRegisterManage");
		String saveDir = session.getServletContext().getRealPath("/resources/img/producer");
		// ��������Ȯ��
		String profile = file.getOriginalFilename();
		producerDTO.setProfile(profile);
		
		try {
			file.transferTo(new File(saveDir + "/" + profile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = manageService.producerRegisterManage(producerDTO);
		return "forward:producerManage";
	}

	/**
	 * ������ ����
	 * */
	@RequestMapping("producerModifyManage")
	public String producerModifyManage(HttpServletRequest request, ProducerDTO producerDTO, @RequestParam MultipartFile file, HttpSession session) {
		/**
		 * Ư�� �������� ��ȣ�� �޾ƿ� producerno
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� productManage ������ǰ������ ���� ������ �Ѿ��.
		 */
		System.out.println("producerModifyManage");
		String saveDir = session.getServletContext().getRealPath("/resources/img/producer");
		String profile = file.getOriginalFilename();
		if(profile.equals("")) {
			profile = producerDTO.getProfile();
		}
		
		producerDTO.setProfile(profile);
		
		try {
			file.transferTo(new File(saveDir + "/" + profile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = manageService.producerModifyManage(producerDTO);
		return "forward:producerManage";
	}
	
	/**
	 * ������ ����(�ش� ������ dto�� ��� ������ �������� �ѷ��ֱ�)
	 * */
	@RequestMapping("producerModifyShowManage")
	@ResponseBody
	public ProducerDTO producerModifyShowManage(int no) {
		System.out.println("producerModifyShowManage");
		// �����ڹ�ȣ�� ���� ������DTO ��������
		ProducerDTO producer = manageService.producerInfoMangage(no);
		return producer;
	}
	
	
	
	@RequestMapping("producerSendMessage")
	public String producerSendMessage(@RequestParam String phone, @RequestParam String adminMessage){
		
		String api_key = " NCS58438B39BFA5E";
        String api_secret = "0146B928483C7BC3FBD71788007A3DF0";
       
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phone);
        params.put("from", "01090786137");
        params.put("type", "SMS");
        params.put("text", adminMessage);
      
        try {
         org.json.simple.JSONObject obj= coolsms.send(params);
         
          System.out.println(obj.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
        return "forward:producerManage";
	}

	/**
	 * ������ ����
	 * (alert)
	 * */
	@RequestMapping("producerDeleteManage")
	@ResponseBody
	public int producerDeleteManage(int no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ�  (�μ� : no)
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * alert�� �޽��� ���.
		 */
		System.out.println("producerDeleteManage");
		System.out.println(no);
		int result = 0;
		result = manageService.producerDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "�������� �ʾҽ��ϴ�.");
			
		}
		return result;
	}
	
	/**
	 * �������
	 * �Ѹ����� �ٷ� ������
	 * �Ѹ���, ������, ������
	 * */
	@RequestMapping("salesManage")
	public String salesManage() {
		System.out.println("salesManage");
		
		return "admin/adminSales";
	}
	
	@RequestMapping("salesMonthManage")
	@ResponseBody
	public List<Integer> salesMonthManage() {
		System.out.println("salesMonthManage");
		List<Integer> list = new ArrayList<Integer>();
		list = manageService.getMonthSales();
		return list;
	}
	
	@RequestMapping("salesProductManage")
	@ResponseBody
	public List<Integer> salesProductManage() {
		System.out.println("salesProdcutManage");
		Integer[] arr = new Integer[23];
		for(int i = 0 ; i < 23 ; i++) {
			arr[i] = 0;
		}
		List<HashMap<String, String>> list = manageService.getSalesProduct();
		
		for(Map<String, String> map : list) {
			System.out.println(String.valueOf(map.get("COUNT")) + "!!!");
			String countStr = String.valueOf(map.get("COUNT"));
			String noStr = String.valueOf(map.get("NO"));
			int count = Integer.parseInt(countStr);
			int no = Integer.parseInt(noStr);
			
			if(count != 0) {
				arr[no - 1] = count;
			}
		}
		for(int i : arr) {
			System.out.println(i);
		}
		List<Integer> resultList = new ArrayList<Integer>(Arrays.asList(arr));
		return resultList;
	}
	
	/**2
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
		System.out.println("memberManage");
		List<MemberDTO> memberlist = manageService.selectAllMember();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("admin/adminUser");  
		return mv;
	}
	
	/**
	 * ȸ������(����)
	 * */
	@RequestMapping("memberDeleteManage")
	@ResponseBody
	public int memberDeleteManage(String email) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * alert�� �޽��� ���.
		 */
		System.out.println("memberDeleteManage");
		int result = manageService.memberDeleteManage(email);;
		return result;
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
		mv.setViewName("admin/adminCommunity");
		return mv;
	}
	
	/**
	 * ���Ӱ���(���)
	 * */
	@RequestMapping("communityRegisterManage")
	public String communityRegisterManage(HttpServletRequest request, CommunityDTO communityDTO, MultipartHttpServletRequest multipartRequest, HttpSession session) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� communityDTO ������ ��� �޾�, 
		 * 3. community���̺� �߰��Ѵ�(register)
		 */
		System.out.println("communityRegisterManage");
		System.out.println(communityDTO.getName());
		System.out.println(communityDTO.getProfile());
		System.out.println(communityDTO.getDesc());
		System.out.println(communityDTO.getProducerNo());
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		String profile = fileList.get(0).getOriginalFilename();
		String desc = fileList.get(1).getOriginalFilename();
		communityDTO.setProfile(profile);
		communityDTO.setDesc(desc);
		
		System.out.println(communityDTO.getProfile());
		System.out.println(communityDTO.getDesc());
		
		if(profile.equals("") || desc.equals("")) {
			return "forward:communityManage";
		}
		
		// ���� ���ε�
		String saveDir = session.getServletContext().getRealPath("/resources/img/community");
		try {
			fileList.get(0).transferTo(new File(saveDir + "/" + profile));
			fileList.get(1).transferTo(new File(saveDir + "/" + desc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = manageService.communityRegisterManage(communityDTO);
		System.out.println(result);
		return "forward:communityManage";
	}
	
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 * */
	@RequestMapping("communityModifyShowManage")
	@ResponseBody
	public CommunityDTO communityShowMangage(int no){
		CommunityDTO community = manageService.communityShowMangage(no);
		return community;
	}
	
	/**
	 * ���Ӱ���(����)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityModifyManage")
	public String communityModifyManage(HttpServletRequest request, CommunityDTO communityDTO, HttpSession session, MultipartHttpServletRequest multipartRequest) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� community�� ���� ������ �Ѿ��.
		 */
		System.out.println("communityModifyManage");
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		
		String profile = fileList.get(0).getOriginalFilename();
		String desc = fileList.get(1).getOriginalFilename();
		System.out.println(communityDTO.getDesc() + "!!!");
		
		if(!(profile.equals(""))) {
			communityDTO.setProfile(profile);
		}
		if(!(desc.equals(""))) {
			communityDTO.setDesc(desc);
		}
		
		System.out.println(communityDTO.getProfile());
		System.out.println(communityDTO.getDesc());
		
		String saveDir = session.getServletContext().getRealPath("/resources/img/community");
		int result = 0;
		File descFile = new File(saveDir + "/" + desc);
		File profileFile = new File(saveDir + "/" + profile);
		try {
			if(profile.equals("") && desc.equals("")) {
				System.out.println("profile, desc ��� ���� �ø��� ���� ���");
				System.out.println(communityDTO.getProfile());
				System.out.println(communityDTO.getDesc());
				result = manageService.communityModifyManage(communityDTO);
			}else if(profile.equals("")) {
				if(descFile.exists()) { // desc�� ���ε� �Ϸ� �ߴµ�, �̹� �� ������ ������ ������ ���
					result = manageService.communityModifyManage(communityDTO);
				}else { // ���ε� �Ϸ��� desc ������ ������ �ߺ����� ���� ���
					fileList.get(1).transferTo(descFile);
					result = manageService.communityModifyManage(communityDTO);
				}
			}else if(desc.equals("")) {
				System.out.println("desc ���� ��");
				System.out.println(communityDTO.getDesc());
				if(profileFile.exists()) {
					result = manageService.communityModifyManage(communityDTO);
				}else {
					fileList.get(0).transferTo(profileFile);
					result = manageService.communityModifyManage(communityDTO);
				}
			}else {
				System.out.println("����");
				System.out.println(communityDTO.getNo());
				System.out.println(communityDTO.getProfile());
				System.out.println(communityDTO.getDesc());
				fileList.get(1).transferTo(descFile);
				fileList.get(0).transferTo(profileFile);
				result = manageService.communityModifyManage(communityDTO);
				System.out.println(result);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "forward:communityManage";
	}
	
	/**
	 * ���Ӱ���(����)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityDeleteManage")
	@ResponseBody
	public int communityDeleteManage(String no) {
		/**
		 * Ư�� ��ǰ�� ��ȣ�� �޾ƿ� 
		 * �� ��ȣ�� ��ġ�ϴ� ������ �����Ѵ�.
		 * �� ���� div�±װ� ������� �ٽ� community������ ���� ������ �Ѿ��.
		 */
		System.out.println("communityDeleteManage");
		int result = manageService.communityDeleteManage(no);
		return result;
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
		System.out.println(qnalist.size()+"Ddd");
		if(qnalist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("qnalist",qnalist);
		mv.setViewName("admin/adminQna");
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
		System.out.println("donationOrgManage");
		List<DonationOrgDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = manageService.donationOrgManage();
		if(donationlist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("donationlist",donationlist);
		mv.setViewName("admin/adminDonate");
		return mv;
	}
	
	/**
	 * ��� ��ü ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@RequestMapping("donationOrgModifyShowManage")
	@ResponseBody
	public DonationOrgDTO donationOrgShowMangage(){
		DonationOrgDTO donation = manageService.donationOrgShowMangage();
		return donation;
	}
	
	/**
	 * ��ξ�ü ����(����)
	 * @return 
	 * */
	@RequestMapping("donationOrgModifyManage")
	public String donationOrgModifyManage(HttpServletRequest request, DonationOrgDTO donationOrgDTO, @RequestParam MultipartFile file, HttpSession session) {
		System.out.println("donationOrgModifyManage");
		if(!(file.getOriginalFilename().equals(""))) { // ���ο� ������ ���ε� �� ���
			donationOrgDTO.setProfile(file.getOriginalFilename());
			String saveDir = session.getServletContext().getRealPath("/resources/img/donation_org");	
			try {
				file.transferTo(new File(saveDir + "/" + donationOrgDTO.getProfile()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			int result = manageService.donationOrgModifyManage(donationOrgDTO);
			return "forward:donationOrgManage";
		}else { // ���ο� ������ ���ε����� �ʾƼ� ������ ������ �״�� ����� ���
			int result = manageService.donationOrgModifyManage(donationOrgDTO);
			return "forward:donationOrgManage";
		}
	}

	/**
	 * �����׽�Ʈ
	 * ��ξ�ü DTO
	 * @return 
	 * */
	@RequestMapping("sendSms")
	public ModelAndView sendSms() {
		/**
		 * ��� ��ü ������ Ŭ���ϸ�, �ش��ϴ� ��ξ�ü DTO�� ������ �޾Ƽ� (select) �信 �ѷ��ش�.
		 */
		List<DonationOrgDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = manageService.donationOrgManage();
		if(donationlist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("donationlist",donationlist);
		mv.setViewName("admin/adminMessage");
		return mv;
	}
	
	/**
	 * �����׽�Ʈ ��(���)
	 * @return 
	 * */
	@RequestMapping("sendSmsRegister")
	public String sendSmsRegister(DonationOrgDTO donationOrgDTO) {
		/**
		 * 1. ����� ������ jsp�� �ִ� div�� ��������.
		 * 2. ������ �Է��ϰ� ����� �Է��ϸ�, form�� �ִ� ���� communityDTO ������ ��� �޾�, 
		 * 3. community���̺� �߰��Ѵ�(register)
		 */
		int result = manageService.donationOrgRegisterManage(donationOrgDTO);
		if(result==0){
			//request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
		}
		return "forward:donationOrgManage";
	}
}
