package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserProductController {

	/**
	 * shop에 마우스 올렸을 때 메뉴 불러오기
	 * 대분류 3개 불러오기
	 * 인기상품 purchase테이블에서 product_no 내림차순 3개
	 * 계절상품 귤,딸기,배추
	 * 최근구매(없으면 빈칸)
	 * */
	@RequestMapping("shopMenuLoading")
	public void shopMenuLoading() {
		
	}
	
	/**
	 * shop 메뉴바에서 카테고리 눌렀을 때 9개 리스트 뿌려주기
	 * 등록순(product 테이블에서 product_no 내림차순)
	 * */
	@RequestMapping("shopMenuListLoading")
	public void showMenuListLoading() {
		
	}
	
	/**
	 * 개별상품 상세정보
	 * 이름,가격,단위,카테고리,설명,프로필사진,댓글,평점,생산자, 해당 상품과 일치하는 인증마크정보
	 * */
	@RequestMapping("showProductDetail")
	public void showProductDetail() {
		
	}
	
	/**
	 * 개별상품에서 생산자 정보 클릭했을 때
	 * 새창에서 생산자 정보 알려주기
	 * */
	@RequestMapping("showProducerInfo")
	public void showProducerInfo() {
		
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
