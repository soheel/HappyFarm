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
	public ModelAndView showMenuListLoading(String categoryNo) {
		/**
		 * 1. 사용자가 선택한 카테고리를 인수로 받음
		 * 2. 받은 카테고리를 이용해서 dao로 가서 등록순으로 List<ProductDTO>에 저장 후 뷰로 반환해줌
		 * 
		 * categoryNo
		 * 1 - 과일/견과
		 * 2 - 채소
		 * 3 - 쌀/잡곡
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
	public ModelAndView showProductDetail(String productNo) {
		/**
		 * 1. 해당 상품 사진을 누르면 해당 상품의 productNo를 서버로 인수로 넘겨줌
		 * 2. 받은 인수(productNo)를 dao로 넘겨서 해당 상품 DTO(ProductDTO)를 받아온다.
		 * 3. 받아온 상품정보를 반환한다.
		 * */
		ProductDTO productDTO = service.showProductDetail(productNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", productDTO);
		mv.setViewName("productDetail");
		return mv;
	}
	
	/**
	 * 개별상품에서 생산자 정보 클릭했을 때
	 * 새창에서 생산자 정보 알려주기
	 * */
	@RequestMapping("showProducerInfo")
	public ModelAndView showProducerInfo(String producerNo) {
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
	 * 장바구니에 담기
	 * */
	@RequestMapping("addCart")
	public void addCart() {
		
	}
	
	/**
	 * 상품 상세정보에서 구매하기버튼 클릭했을 때
	 * */
	@RequestMapping("purchase")
	public void purchase() {
		
	}
	
	/**
	 * 주문화면
	 * */
	@RequestMapping("order")
	public void order() {
		
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
	 * package 메뉴바에서 카테고리 눌렀을 때 9개 리스트 뿌려주기
	 * */
	@RequestMapping("packageMenuListLoading")
	public void packageMenuListLoading() {
		
	}
	
	/**
	 * 패키지 상품 상세보기
	 * 패키지DTO
	 * */
	@RequestMapping("showPackageDetail")
	public void showPackageDetail() {
		
	}

}
