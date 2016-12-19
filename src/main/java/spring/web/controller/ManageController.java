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
	 * 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기)
	 * 리스트로
	 * */
	@RequestMapping("productManage")
	public ModelAndView productManage() {
		/**
		 * 1. 개별 상품 관리를 누르면
		 * 2. proudctDTO에 있는 정보를 다 받아와서 (productlist)
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
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
	 * 개별상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	@RequestMapping("productRegisterManage")
	public String productRegisterManage(HttpServletRequest request, ProductDTO productDTO, HttpSession session, MultipartHttpServletRequest multipartRequest) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 productDTO 정보를 모두 받아, 
		 * 3. product테이블에 추가한다(register)
		 */
		System.out.println("productRegisterManage");
		/**
		 * fileList에는 순서대로 profile, desc 파일명이 들어있음
		 * 이를 각각 꺼내어 productDTO에 세팅
		 * */
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		String profile = fileList.get(0).getOriginalFilename();
		String desc = fileList.get(1).getOriginalFilename();
		productDTO.setProfile(profile);
		productDTO.setDesc(desc);
		
		if(profile.equals("") || desc.equals("")) {
			return "forward:productManage";
		}
		
		// 파일 업로드
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
	 * 개별상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, ProductDTO productDTO, HttpSession session, MultipartHttpServletRequest multipartRequest) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
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

		// 파일 업로드
		String saveDir = session.getServletContext().getRealPath("/resources/img/product");
		File profileFile = new File(saveDir + "/" + profile);
		File descFile = new File(saveDir + "/" + desc);
		try {
			// 폴더에 같은 이름의 파일이 있다면 이름을 변경해줌
			// 앞에 숫자를 붙인 이유는 System.currentTimeMillis()를 해도 너무 빨라서
			// 파일 이름이 같아지기 때문
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
	 * 개별 상품 수정을 눌렀을 때, 기존의 정보를 띄워주기
	 * */
	@RequestMapping("productModifyShowManage")
	@ResponseBody
	public ProductDTO productModifyShowManage(int no) {
		System.out.println("productModifyShowManage");
		// 상품번호를 통해 상품DTO 가져오기
		ProductDTO product = manageService.productInfoMangage(no);
		System.out.println(product.getEval() + "!!!");
		return product;
	}
	
	/**
	 * 개별상품관리 삭제
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	@RequestMapping("productDeleteManage")
	@ResponseBody
	public int productDeleteManage(int no) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		System.out.println("productDeleteManage");
		int result = manageService.productDeleteManage(no);
		return result;
	}
	
	/**
	 * 세트상품관리 클릭했을 때
	 * package DTO 리스트
	 * */
	@RequestMapping("packageManage")
	public ModelAndView packageManage() {
		/**
		 * 1. 세트 상품 관리를 누르면
		 * 2. packageDTO에 있는 정보를 다 받아와서 (packagelist) 
		 * * 정보 관련 :  package테이블의 package_name, 세트 가격은 product에 있는 price, 포함상품은package_product에 있는 product_no를 다 찾는다.
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
		 * 
		 */
		List<PackageDTO> packagelist = manageService.packageManage();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packagelist", packagelist);
		
		mv.setViewName("admin/packageItem");  
		return mv;
	}
	
	/**
	 * 세트상품 상세정보 packagename을 인수로 받는다.
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	@RequestMapping("packageShowManage")
	public ModelAndView packageShowManage(String name) {
		/**
		 * 1.세프 상품 정보 list에서 package이름을 누르면 해당하는 패키지 이름을 받아온다.
		 * 2.package에 있는 package_no를 찾고 일치하는 package_product에 있는 product_no를 모두 찾는다.
		 * 3.product에 있는 product_name, price, producer_no(no를 찾아 producer테이블의 name)을 찾고, product_no에 일치하는 certification_no를 찾는다.
		 */
		
		//packagename에 일치하는 package_no를 찾고 package_product에 있는 product_no를 찾는다.
		List<ProductDTO> packageproduct = manageService.packageShowManage(name);
		//다른 건 다 조인해서 받아올수있는건가...ㅎ
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packageproduct", packageproduct);
		
		mv.setViewName("packageproduct");  
		return mv;
	}
	
	/**
	 * 세트상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	@RequestMapping("packageRegisterManage")
	public String packageRegisterManage(PackageDTO packageDTO, String name) {
		Map<String, Object> packageRegister = new HashMap<String, Object>();
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 입력할 정보 : 이름 (product테이블에 있는 package_name)
		 * 가격,사진,설명 : product테이블에 있는 price, profile, desc
		 * 상품검색 : product_name에 일치하는 product를 찾아준다
		 * 밑에 상품이 productDTO들이 insert된다.
		 */
		ProductDTO productDTO = packageSearchProduct(name);
		
		packageRegister.put("productDTO", productDTO);
		packageRegister.put("packageDTO", packageDTO);
		
		int result = manageService.packageRegisterManage(packageRegister);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:packageproduct";
	}
	
	/**
	 * 세트상품 등록에서 개별상품 검색(ajax)- productname을 받는다.
	 * 상품번호, 상품이름 아래에 추가
	 * */
	@RequestMapping("packageSearchProduct")
	public ProductDTO packageSearchProduct(String name) {
		/**
		 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
		 */
		ProductDTO productDTO = manageService.packageSearchProduct(name);
		
		return productDTO;
	}
	
	//div태그이므로, 할 필요 없을 것이다. 정보 저장되어 있기 떄문에
	/** div에 정보를 불러와서 ...productno를 받는다.
	 * //수정폼에서 product에 해당하는 productname에 해당하는 제품 dto에 대한 정보를 받아 오기 위해 필요한 메소드		
		ProductDTO product = manageService.selectByPackageName(productDTO)
	 * 세트상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	
	@RequestMapping("packageInfoMangage")
	public ProductDTO packageInfoMangage(String no){
		ProductDTO product = null;
		product = manageService.packageInfoMangage(no);
		
		return product;
	} */
	
	/**
	 * 세트상품관리 수정 (productname을 인수로 받음)
	 * 수정폼을 div로 띄워줌
	 * @return 
	 * */
	@RequestMapping("packageModifyManage")
	public String packageModifyManage(ProductDTO productDTO, String name) {
		
		Map<String, Object> modifyinfo = new HashMap<String, Object>();
		/**
		 * 패키지 이름을 누르고 수정을 누르면 등록폼과 같은 div가 띄어진다.
		 * 2. 입력할 정보 : 이름 (product테이블에 있는 package_name)
		 * 가격,사진,설명 : product테이블에 있는 price, profile, desc
		 * 상품검색 : product_name에 일치하는 product를 찾아준다
		 * 밑에 상품이 productDTO들이 modify된다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		
		//수정폼에서 상품 검색하기 위해서 필요한 메소드
		ProductDTO searchlist = packageSearchProduct(name);
		
		modifyinfo.put("productDTO", productDTO);
		modifyinfo.put("searchlist", searchlist);
		
		int result = manageService.packageModifyManage(modifyinfo);
		
		if(result==0){
			//request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:packageproduct";
	}
	
	/**
	 * 세트상품관리 삭제(인수 : productname)
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	@RequestMapping("packageDeleteManage")
	public String packageDeleteManage(String name) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.packageDeleteManage(name);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:packageproduct";
	}
	
	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * @return 
	 * */
	@RequestMapping("producerManage")
	public ModelAndView producerManage() {
		/**
		 * 1. 생산자관리를 누르면
		 * 2. proudcerDTO에 있는 정보를 다 받아와서 (producerlist)
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
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
	 * 생산자 등록
	 * @return 
	 * */
	@RequestMapping("producerRegisterManage")
	public String producerRegisterManage(HttpServletRequest request, ProducerDTO producerDTO, @RequestParam MultipartFile file, HttpSession session) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 producerDTO 정보를 모두 받아, 
		 * 3. producer테이블에 추가한다(register)
		 */
		System.out.println("producerRegisterManage");
		String saveDir = session.getServletContext().getRealPath("/resources/img/producer");
		// 파일정보확인
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
	 * 생산자 수정
	 * */
	@RequestMapping("producerModifyManage")
	public String producerModifyManage(HttpServletRequest request, ProducerDTO producerDTO, @RequestParam MultipartFile file, HttpSession session) {
		/**
		 * 특정 생산자의 번호를 받아와 producerno
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
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
	 * 생산자 수정(해당 생산자 dto를 뷰로 보내어 수정폼에 뿌려주기)
	 * */
	@RequestMapping("producerModifyShowManage")
	@ResponseBody
	public ProducerDTO producerModifyShowManage(int no) {
		System.out.println("producerModifyShowManage");
		// 생산자번호를 통해 생산자DTO 가져오기
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
	 * 생산자 삭제
	 * (alert)
	 * */
	@RequestMapping("producerDeleteManage")
	@ResponseBody
	public int producerDeleteManage(int no) {
		/**
		 * 특정 상품의 번호를 받아와  (인수 : no)
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * alert로 메시지 뜬다.
		 */
		System.out.println("producerDeleteManage");
		System.out.println(no);
		int result = 0;
		result = manageService.producerDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return result;
	}
	
	/**
	 * 매출관리
	 * 총매출이 바로 보여짐
	 * 총매출, 총지출, 순이익
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
	 * 매출관리
	 * 월별매출
	 * 차트
	 * */
	@RequestMapping("salesByMonthsManage")
	public void salesByMonthsManage() {
		
	}
	
	/**
	 * 매출관리
	 * 인기순
	 * 도넛차트
	 * */
	@RequestMapping("salesByBestManage")
	public void salesByBestManage() {
		
	}
	
	/**
	 * 회원관리
	 * 회원 DTO 리스트(오름차순)
	 * @return 
	 * */
	@RequestMapping("memberManage")
	public ModelAndView memberManage() {
		/**
		 * 1. 회원관리를 누르면
		 * 2. MemberDTO에 있는 정보를 다 받아와서 (memberlist)
		 * 정보 : member_email, memeber_name, member_phone, member_register_date, 
		 * select를 하는데 오름차순으로 해준다.
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
		 *  */
		System.out.println("memberManage");
		List<MemberDTO> memberlist = manageService.selectAllMember();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("admin/adminUser");  
		return mv;
	}
	
	/**
	 * 회원관리(삭제)
	 * */
	@RequestMapping("memberDeleteManage")
	@ResponseBody
	public int memberDeleteManage(String email) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * alert로 메시지 뜬다.
		 */
		System.out.println("memberDeleteManage");
		int result = manageService.memberDeleteManage(email);;
		return result;
	}
	
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * @return 
	 * */
	@RequestMapping("communityManage")
	public ModelAndView communityManage() {
		/**
		 * 1. commuity를 누르면, 
		 * 2. 총 9개를 담아서 뷰로 보내준다. community_profile사진 / commuinty_name, community_register_date를 보여준다.
		 * 3. 전체 행사를 뽑는 dao 두 개의 메소드와 (community_state 상태를 확인 한 후)
		 * 페이지 기능 메소드가 필요. 
		 */
		List<CommunityDTO> communitylist = null;
		ModelAndView mv = new ModelAndView();
		communitylist = manageService.communityManage();
		if(communitylist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("communitylist",communitylist);
		mv.setViewName("admin/adminCommunity");
		return mv;
	}
	
	/**
	 * 모임관리(등록)
	 * */
	@RequestMapping("communityRegisterManage")
	public String communityRegisterManage(HttpServletRequest request, CommunityDTO communityDTO, MultipartHttpServletRequest multipartRequest, HttpSession session) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 communityDTO 정보를 모두 받아, 
		 * 3. community테이블에 추가한다(register)
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
		
		// 파일 업로드
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
	 * 모임관리 수정을 위해 해당 모임에 대한 정보를 불러와서 폼에 보여준다.
	 * */
	@RequestMapping("communityModifyShowManage")
	@ResponseBody
	public CommunityDTO communityShowMangage(int no){
		CommunityDTO community = manageService.communityShowMangage(no);
		return community;
	}
	
	/**
	 * 모임관리(수정)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityModifyManage")
	public String communityModifyManage(HttpServletRequest request, CommunityDTO communityDTO, HttpSession session, MultipartHttpServletRequest multipartRequest) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 community를 보는 쪽으로 넘어간다.
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
				System.out.println("profile, desc 모두 새로 올리지 않은 경우");
				System.out.println(communityDTO.getProfile());
				System.out.println(communityDTO.getDesc());
				result = manageService.communityModifyManage(communityDTO);
			}else if(profile.equals("")) {
				if(descFile.exists()) { // desc를 업로드 하려 했는데, 이미 그 파일이 폴더에 존재할 경우
					result = manageService.communityModifyManage(communityDTO);
				}else { // 업로드 하려는 desc 파일이 폴더에 중복되지 않을 경우
					fileList.get(1).transferTo(descFile);
					result = manageService.communityModifyManage(communityDTO);
				}
			}else if(desc.equals("")) {
				System.out.println("desc 없을 때");
				System.out.println(communityDTO.getDesc());
				if(profileFile.exists()) {
					result = manageService.communityModifyManage(communityDTO);
				}else {
					fileList.get(0).transferTo(profileFile);
					result = manageService.communityModifyManage(communityDTO);
				}
			}else {
				System.out.println("여기");
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
	 * 모임관리(삭제)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityDeleteManage")
	@ResponseBody
	public int communityDeleteManage(String no) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * 그 다음 div태그가 사라지고 다시 community관리를 보는 쪽으로 넘어간다.
		 */
		System.out.println("communityDeleteManage");
		int result = manageService.communityDeleteManage(no);
		return result;
	}
	
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	@RequestMapping("qnaManage")
	public ModelAndView qnaManage() {
		/**
		 * 1. Q&A관리를 누르면, 
		 * 2. 전체 Q&A정보를 뽑는 dao 메소드/ 페이지 기능 메소드가 필요. 
		 */
		List<QnaDTO> qnalist = null;
		ModelAndView mv = new ModelAndView();
		qnalist = manageService.qnaManage();
		System.out.println(qnalist.size()+"Ddd");
		if(qnalist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("qnalist",qnalist);
		mv.setViewName("admin/adminQna");
		return mv;
	}
	
	/**
	 * Q&A 답변 등록
	 * @return 
	 * */
	@RequestMapping("qnaRegisterManage")
	public String qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 communitycommentDTO 정보를 모두 받아, 
		 * 3. community테이블에 추가한다(ajax)
		 */
		int result = manageService.qnaRegisterManage(communitycommentDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:qnaManage";
	}
	
	/**
	 * 질문관리 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.(qnano)
	 
	public QnaDTO qnaInfoMangage(String no){
		QnaDTO qna = null;
		qna = manageService.qnaInfoMangage(no);
		
		return qna;
	}*/
	/**
	 * Q&A 답변 수정(communitycommentno)
	 * */
	@RequestMapping("qnaModifyManage")
	public String qnaModifyManage(QnaDTO qnaDTO) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 qna를 보는 쪽으로 넘어간다.
		 */
		int result = manageService.qnaModifyManage(qnaDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:qnaManage";
	}
	
	/**
	 * Q&A 질문 삭제(communitycommentno)
	 * @return 
	 * */
	@RequestMapping("qnaDeleteManage")
	public String qnaDeleteManage(String no) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * 그 다음 div태그가 사라지고 다시 qna를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.qnaDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:qnaManage";
	}
	
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * @return 
	 * */
	@RequestMapping("donationOrgManage")
	public ModelAndView donationOrgManage() {
		/**
		 * 기부 업체 관리를 클리하면, 해당하는 기부업체 DTO의 정보를 받아서 (select) 뷰에 뿌려준다.
		 */
		System.out.println("donationOrgManage");
		List<DonationOrgDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = manageService.donationOrgManage();
		if(donationlist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("donationlist",donationlist);
		mv.setViewName("admin/adminDonate");
		return mv;
	}
	
	/**
	 * 기부 업체 수정을 위해 정보를 불러와서 폼에 보여준다.
	 */
	@RequestMapping("donationOrgModifyShowManage")
	@ResponseBody
	public DonationOrgDTO donationOrgShowMangage(){
		DonationOrgDTO donation = manageService.donationOrgShowMangage();
		return donation;
	}
	
	/**
	 * 기부업체 관리(수정)
	 * @return 
	 * */
	@RequestMapping("donationOrgModifyManage")
	public String donationOrgModifyManage(HttpServletRequest request, DonationOrgDTO donationOrgDTO, @RequestParam MultipartFile file, HttpSession session) {
		System.out.println("donationOrgModifyManage");
		if(!(file.getOriginalFilename().equals(""))) { // 새로운 사진을 업로드 한 경우
			donationOrgDTO.setProfile(file.getOriginalFilename());
			String saveDir = session.getServletContext().getRealPath("/resources/img/donation_org");	
			try {
				file.transferTo(new File(saveDir + "/" + donationOrgDTO.getProfile()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			int result = manageService.donationOrgModifyManage(donationOrgDTO);
			return "forward:donationOrgManage";
		}else { // 새로운 사진을 업로드하지 않아서 기존의 사진을 그대로 사용할 경우
			int result = manageService.donationOrgModifyManage(donationOrgDTO);
			return "forward:donationOrgManage";
		}
	}

	/**
	 * 문자테스트
	 * 기부업체 DTO
	 * @return 
	 * */
	@RequestMapping("sendSms")
	public ModelAndView sendSms() {
		/**
		 * 기부 업체 관리를 클리하면, 해당하는 기부업체 DTO의 정보를 받아서 (select) 뷰에 뿌려준다.
		 */
		List<DonationOrgDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = manageService.donationOrgManage();
		if(donationlist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("donationlist",donationlist);
		mv.setViewName("admin/adminMessage");
		return mv;
	}
	
	/**
	 * 문자테스트 폼(등록)
	 * @return 
	 * */
	@RequestMapping("sendSmsRegister")
	public String sendSmsRegister(DonationOrgDTO donationOrgDTO) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 communityDTO 정보를 모두 받아, 
		 * 3. community테이블에 추가한다(register)
		 */
		int result = manageService.donationOrgRegisterManage(donationOrgDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:donationOrgManage";
	}
}
