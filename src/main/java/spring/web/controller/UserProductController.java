package spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CartDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
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
	public List<ProductDTO> shopMenuLoading() {
		/**
		 * 1. shop에 마우스 오버
		 * 2. 인기상품, 계절상품, 최근구매를 
		 * List<ProductDTO>에 순서대로 9개 담아서
		 * 뷰로 보내주기
		 * 인기상품, 계절상품, 최근구매를 3개씩 뽑아주는 dao의 메소드가 3개 필요
		 * 이 3가지 메소드를 모두 서비스의 showMenuLoading에서 불러줘서 이를 
		 * list에 넣어서 컨트롤러로 반환
		 * */
		List<ProductDTO> list = null;
		list = service.shopMenuLoading();
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
		
		List<ProductDTO> list = null;
		ModelAndView mv = new ModelAndView();
		list = service.showMenuListLoading(categoryNo);
		mv.addObject("list",list);
		mv.setViewName("searchProduct");
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
		mv.addObject("map", map);
		mv.setViewName("productDetail");
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
	public int addCart(CartDTO cart, HttpSession session) {
		/**
		 * 1. 현재 상품에 관한 상품번호를 인수로 받는다.
		 * 2. 회원의 아이디에 해당하는 cart 테이블에 해당 상품과 갯수를 insert한다.
		 * */
		
		String email = (String)session.getAttribute("email");
		cart.setEmail(email);
		int result = service.addCart(cart);
		return result; // 뷰에서 반환값이 1이상이 아니면 장바구니담기 실패라고 alert 띄워주기
	}
	
	/**
	 * 장바구니에 담기(상품 리스트에서 바로 장바구니에 담을 경우)
	 * */
	@RequestMapping("addCartDirect")
	public int addCartDirect(CartDTO cart, HttpSession session) {
		/**
		 * 1. 현재 상품에 관한 상품번호를 인수로 받는다.
		 * 2. 회원의 아이디에 해당하는 cart 테이블에 해당 상품을 insert한다. (개수는 1)
		 * */
		
		String email = (String)session.getAttribute("email");
		cart.setNum(1);
		cart.setEmail(email);
		int result = service.addCartDirect(cart);
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
	 * 주문화면에서 결제버튼 클릭했을 때
	 * */
	@RequestMapping("pay")
	public void pay() {
		
	}
	
	/**
	 * 검색
	 * */
	@RequestMapping("search")
	public void search() {
		
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
		mv.setViewName("searchProduct");
		return mv;
	}
	
	/**
	 * 패키지 상품 상세보기
	 * 패키지DTO
	 * */
	@RequestMapping("showPackageDetail")
	public ModelAndView showPackageDetail() {
		/**
		 * 1. 뷰로부터 해당하는 패키지 상품의 상품번호(packageNo)를 인수로 전달받는다.
		 * 2. 해당 패키지의 ProductDTO를 가져온다.
		 * 3. 해당 패키지에 포함되어있는 상품들의 ProductDTO들을 list에 담아 가져온다.
		 * 4. 해당 패키지상품에 대한 댓글의 ProductCommentDTO를 가져온다.
		 * 5. service에서는 map을 반환하는데, map에는 ProductDTO, ProductCommentDTO가 들어있는 list와
		 * ProductDTO들이 들어있는 list가 있다.
		 * 6. 이 map에서 두개의 list들을 꺼내어 modelandview에 저장하여 뷰로 보낸다.
		 * */
		
		ModelAndView mv = new ModelAndView();
		
		return null;
	}

}
