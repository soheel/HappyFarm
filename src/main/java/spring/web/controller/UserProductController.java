package spring.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.nurigo.java_sdk.Coolsms;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import spring.web.dto.CartDTO;
import spring.web.dto.CartProductDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseOrderDTO;
import spring.web.dto.PurchaseProductDTO;
import spring.web.dto.PurchaseProductListDTO;
import spring.web.service.UserProductService;

@Controller
@RequestMapping("/userProductController")
public class UserProductController {

	@Autowired
	UserProductService service;
	
	/**
	 * shop에 마우스 올렸을 때 메뉴 불러오기
	 * 대분류 3개 불러오기
	 * 인기상품 purchase테이블에서 product_no 내림차순 3개
	 * 계절상품 귤,딸기,배추
	 * 최근구매(없으면 빈칸)
	 * */
	@RequestMapping("shopMenuLoading")
	@ResponseBody
	public List<ProductDTO> shopMenuLoading(HttpSession session) {
		/**
		 * 1. shop에 마우스 오버
		 * 2. 인기상품, 계절상품, 최근구매를 
		 * List<ProductDTO>에 순서대로 9개 담아서
		 * 뷰로 보내주기
		 * 인기상품, 계절상품, 최근구매를 3개씩 뽑아주는 dao의 메소드가 3개 필요
		 * 이 3가지 메소드를 모두 서비스의 showMenuLoading에서 불러줘서 이를 
		 * list에 넣어서 컨트롤러로 반환
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
	 * shop 메뉴바에서 카테고리 눌렀을 때 9개 리스트 뿌려주기
	 * 등록순(product 테이블에서 product_no 내림차순)
	 * */
	@RequestMapping("shopMenuListLoading")
	public ModelAndView showMenuListLoading(int categoryNo) {
		/**
		 * 1. 사용자가 선택한 카테고리를 인수로 받음
		 * 2. 받은 카테고리를 이용해서 dao로 가서 등록순으로 List<ProductDTO>에 저장 후 뷰로 반환해줌
		 * */
		System.out.println("shopMenuListLoading() 들어옴 " + categoryNo);
		List<ProductDTO> list = null;
		ModelAndView mv = new ModelAndView();
		list = service.showMenuListLoading(categoryNo);
		System.out.println(list.size() + " : list의 size");
		mv.addObject("list", list);
		mv.setViewName("shop/searchProduct");
		
		return mv;
	}
	
	/**
	 * 개별상품 상세정보
	 * 이름,가격,단위,카테고리,설명,프로필사진,댓글,평점,생산자, 해당 상품과 일치하는 인증마크정보
	 * */
	@RequestMapping("showProductDetail")
	public ModelAndView showProductDetail(int productNo) {
		/**
		 * 1. 해당 상품 사진을 누르면 해당 상품의 productNo를 서버로 인수로 넘겨줌
		 * 2. 받은 인수(productNo)를 dao로 넘겨서 해당 상품 DTO(ProductDTO)를 받아온다.
		 * 3. 생산자 정보도 가져온다.
		 * 4. 이때 ProductDTO와 ProducerDTO를 서비스 영역에서 Map에 담아 컨트롤러에서 받은 후
		 * 이를 ModelandView에 담아 뷰로 넘겨준다.
		 * 
		 * + CertificationDTO, ProductCommentDTO도 필요
		 * */
		Map<String, Object> map = service.showProductDetail(productNo);
		ModelAndView mv = new ModelAndView();
		ProductDTO product = (ProductDTO)map.get("product");
		List<ProductCommentDTO> productCommentList = (List<ProductCommentDTO>)map.get("productComment");
		List<CertificationDTO> certificationList = (List<CertificationDTO>)map.get("certification");
		ProducerDTO producer = (ProducerDTO)map.get("producer");
		String categoryName = (String)map.get("categoryName");
		
		
		/**
		 * 상품을 눌렀을 때 인증마크 폼 띄어주기
		 */
		List<ProductCertificationDTO> productCerti = service.showCertificationInfo(productNo);
		
		for(ProductCertificationDTO  list: productCerti){
			System.out.println(list.getCertificationDTO().getName()+"Dddd");
		}
		
		mv.addObject("product", product);
		mv.addObject("productCommentList", productCommentList);
		mv.addObject("certificationList", certificationList);
		mv.addObject("producer", producer);
		mv.addObject("categoryName", categoryName);
		mv.addObject("productCerti",productCerti);
		mv.setViewName("shop/productDetail");
		return mv;
	}
	
	/**
	 * 개별상품에서 생산자 정보 클릭했을 때
	 * 새창에서 생산자 정보 알려주기
	 * */
	@RequestMapping("showProducerInfo")
	public ModelAndView showProducerInfo(int producerNo) {
		/**
		 * 1. 뷰에서 생산자 이름을 클릭했을 때, 생산자 번호가 함께 인수로 전달됨
		 * 2. 인수를 dao로 보내어 생산자 DTO(ProducerDTO)를 받아 이를 뷰로 반환
		 * */
		
		ProducerDTO producerDTO = service.showProducerInfo(producerNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("producer",producerDTO);
		mv.setViewName("producerInfo"); // producerInfo.jsp를 만들어야함
		return mv;
	}
	
	/**
	 * 장바구니에 담기(상품 상세보기 화면에서 장바구니에 담을 경우)
	 * */
	@RequestMapping("addCart")
	@ResponseBody
	public int addCart(CartDTO cart, HttpSession session) {
		/**
		 * 1. 현재 상품에 관한 상품번호를 인수로 받는다.
		 * 2. 회원의 아이디에 해당하는 cart 테이블에 해당 상품과 갯수를 insert한다.
		 * */
		int result=0;
		String email = (String)session.getAttribute("email");
		if(email==null){
			result = -2;
		}
		cart.setEmail(email);
		System.out.println(cart.getEmail());
		System.out.println(cart.getProductNo());
		System.out.println(cart.getNum());
		if(email!=null){
			result = service.addCart(cart);
		}
		
		System.out.println("result : " + result);
		return result; // 뷰에서 반환값이 1이상이 아니면 장바구니담기 실패라고 alert 띄워주기
	}
	
	/**
	 * 장바구니에 담기(상품 리스트에서 바로 장바구니에 담을 경우)
	 * */
	@RequestMapping("addCartDirect")
	@ResponseBody
	public int addCartDirect(CartDTO cart, HttpSession session) {
		/**
		 * 1. 현재 상품에 관한 상품번호를 인수로 받는다.
		 * 2. 회원의 아이디에 해당하는 cart 테이블에 해당 상품을 insert한다. (개수는 1)
		 * */
		int result=0;
		String email = (String)session.getAttribute("email");
		cart.setEmail(email);
		if(email==null){
			result = -2;
		}
		cart.setNum(1);
		System.out.println(cart.getEmail());
		System.out.println(cart.getProductNo());
		System.out.println(cart.getNum());
		
		//cart.setEmail(email);
		if(email!=null){
			result = service.addCartDirect(cart);
		}
		System.out.println(result + " result 값");
		return result; // 뷰에서 반환값이 1이상이 아니면 장바구니담기 실패라고 alert 띄워주기
	}

	/**
	 * 상품 상세보기 화면에서 주문하기 버튼 눌렀을 때
	 * */
	@RequestMapping("order")
	public ModelAndView order(int productNo, int num) {
		/**
		 * 1. 뷰에서 상품번호(product_no)와 구매하려는 개수를 받아온다.
		 * 2. 상품번호를 이용해 상품DTO와 생산자DTO, 개수를 map에 담아 다시 뷰로 보낸다.
		 * */
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = service.order(productNo, num);
		mv.addObject("map", map);
		mv.addObject("num", num);
		mv.setViewName("purchase");
		return mv;
	}
	
	/**
	 * 주문화면에서 우편번호 가져오기
	 * */
	@RequestMapping("getPostcode")
	public void getPostcode() {
		
	}
	
	/**
	 * 상품 상세보기에서 purchase 클릭했을 때
	 * */
	@RequestMapping("purchase")
	public ModelAndView purchase(int productNo, int producerNo, int quantity, int price, HttpSession session) {
		System.out.println("purchase");
		Map<String, Object> map = null;
		ModelAndView mv = new ModelAndView();
		// productDTO 가져오기
		// producerDTO 가져오기
		// 위 두 가지를 한번에 처리할 service 호출
		map = service.showPurchase(productNo, producerNo, (String)session.getAttribute("email"));
		ProductDTO productDTO = (ProductDTO)map.get("productDTO");
		ProducerDTO producerDTO = (ProducerDTO)map.get("producerDTO");
		int mileage = (Integer)map.get("mileage");
				
		mv.addObject("product", productDTO);
		mv.addObject("producer", producerDTO);
		mv.addObject("mileage", mileage);
		mv.setViewName("order/orderCard");
		
		// 총 가격 가져오기
		int totalPrice = quantity * price;
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("quantity", quantity);
		
		return mv;
	}
	
	/**
	 * 장바구니에서 purchase 클릭했을 때
	 * */
	@RequestMapping("purchaseCart")
	public ModelAndView purchaseCart(CartProductDTO cartProduct, int totalPrice, HttpSession session) {
		System.out.println("purchaseCart");
		System.out.println(totalPrice);
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = null;
		String email = (String)session.getAttribute("email");
		map = service.purchaseCart(cartProduct, email);
		List<ProductDTO> productList = (List<ProductDTO>)map.get("productList");
		List<Integer> numList = (List<Integer>)map.get("numList");
		int mileage = (Integer)map.get("mileage");
		mv.addObject("productList", productList);
		mv.addObject("mileage", mileage);
		mv.addObject("numList", numList);
		mv.addObject("totalPrice", totalPrice); // 구매하려는 모든 상품들의 총 가격
		mv.setViewName("order/orderCardCart");
		
		return mv;
	}
	
	/**
	 * 주문화면에서 결제버튼 클릭했을 때
	 * */
	@RequestMapping("pay")
	public ModelAndView pay(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductDTO purchaseProductDTO, 
			HttpSession session) {
		System.out.println("pay");
		String email = (String)session.getAttribute("email");
		// purchaseDTO 세팅
		purchaseDTO.setEmail(email);
		// purchaseOrderDTO 세팅
		purchaseOrderDTO.setEmail(email);
		String phone = purchaseOrderDTO.getPhone().replace(',', '-');
		purchaseOrderDTO.setPhone(phone);
		// purchaseProductDTO 세팅
		// 통합 주소
		String addr = purchaseOrderDTO.getAddr() + " " + purchaseOrderDTO.getDetailAddr();
		int result = service.pay(purchaseDTO, purchaseOrderDTO, purchaseProductDTO);
		purchaseDTO.setNo(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.addObject("purchase", purchaseDTO);
		mv.addObject("purchaseOrder", purchaseOrderDTO);
		mv.addObject("purchaseProduct", purchaseProductDTO);
		mv.addObject("addr", addr);
		mv.setViewName("order/pay");
		return mv;
	}
	
	/**
	 * 장바구니에 저장된 상품들을 결제할 때
	 * */
	@RequestMapping("payCart")
	public ModelAndView payCart(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO,
			PurchaseProductListDTO purchaseProductListDTO, HttpSession session) {
		System.out.println("payCart");
		ModelAndView mv = new ModelAndView();
		String email = (String)session.getAttribute("email");
		purchaseDTO.setEmail(email);
		purchaseOrderDTO.setEmail(email);
		String addr = purchaseOrderDTO.getAddr() + " " + purchaseOrderDTO.getDetailAddr();
		int result = service.payCart(purchaseDTO, purchaseOrderDTO, purchaseProductListDTO);
		purchaseDTO.setNo(result);
		mv.addObject("result", result);
		mv.addObject("purchase", purchaseDTO);
		mv.addObject("purchaseOrder", purchaseOrderDTO);
		mv.addObject("purchaseProductList", purchaseProductListDTO);
		mv.addObject("addr", addr);		mv.setViewName("order/pay");
		return mv;
	}
	
	@RequestMapping("payComplete")
	public void payComplete(int no){
		System.out.println("payComplete");
		System.out.println(no + " : " + no);
		/**
		 * 카드, 실시간, 휴대폰은 바로 결제가 완료된 상태(state_no = 2) 이므로
		 * 이를 수정해줘야함
		 * */
		
		int result = service.setPurchaseStateNo(no);
	}
	
	@RequestMapping("paySendSms")
	public void paySendSms(@RequestParam String name, @RequestParam String phone, @RequestParam String bankNum,
	
		@RequestParam String bankName, @RequestParam String bankHolder){
		String api_key = "NCS58573A4F7EE6C";
        String api_secret = "B1BAFF5BE67B7DA379FB7F71821038F4";

       
        Message coolsms = new Message(api_key, api_secret);

        String str=name+"님 결제 되었습니다.\n"+bankName+" " + bankNum+" " + bankHolder + "로 입금 부탁드립니다.";
        
        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phone);
        params.put("from", "01043236137");
        params.put("type", "SMS");
        params.put("text", str);
      
        try {
         org.json.simple.JSONObject obj= coolsms.send(params);
         
          System.out.println(obj.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
	}
	
	/**
	 * 무통장 거래의 경우 가상계좌를 발급 받고나서 ajax로 바로 마일리지 차감
	 * 이 외의 경우 결제 후 state를 바꾸는 과정에서 마일리지 차감을 동시에 진행함
	 * */
	@RequestMapping("reduceMileage")
	public void reduceMileage(int useMileage, HttpSession session) {
		System.out.println("reduceMileage");
		String email = (String)session.getAttribute("email");
		int result = service.reduceMileage(useMileage, email);
	}
	
	/**
	 * 결제 완료 후, 장바구니에서 구매한 상품 제거(무통장거래)
	 * */
	@RequestMapping("deleteCartProductAfterPurchase")
	public void deleteCartProductAfterPurchase(int purchaseNo) {
		
	}
	
	/**
	 * 검색
	 * */
	@RequestMapping("search")
	public ModelAndView search(String keyword) {
		/**
		 * 1. 뷰로부터 전달된 keyword를 dao로 전달하여 product 테이블의 product_name에
		 * keyword가 포함되는 모든 상품들의 dto를 담은 list를 modelandview에 저장하고
		 * 이를 뷰에 반환한다.
		 * */
		
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> list = null;
		list = service.search(keyword);
		
		mv.addObject("list", list);
		mv.setViewName("shop/searchProduct"); // 검색 결과를 뿌려줄 뷰
		
		return mv;
	}
	
	// 패키지
	
	/**
	 * package 메뉴바를 눌렀을 때 9개 리스트 뿌려주기
	 * */
	@RequestMapping("packageMenuListLoading")
	public ModelAndView packageMenuListLoading() {
		/**
		 * 1. pacakage 테이블에서 등록순으로 List<ProductDTO>를 뷰로 전달
		 * */
		
		List<ProductDTO> list = service.packageMenuListLoading();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("package/package");
		return mv;
	}
	
	/**
	 * 패키지 상품 상세보기
	 * 패키지DTO
	 * */
	@RequestMapping("showPackageDetail")
	public ModelAndView showPackageDetail(int productNo) {
		System.out.println("showPackageDetail 메소드");
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = service.getPackageDetail(productNo);
		ProductDTO productDTO = (ProductDTO)map.get("productDTO");
		List<ProductDTO> list = (List<ProductDTO>)map.get("list");
		mv.addObject("packageProduct", productDTO);
		mv.addObject("list", list);
		mv.setViewName("package/packageDetail");
		return mv;
	}
}
