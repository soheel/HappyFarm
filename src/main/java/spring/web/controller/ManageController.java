package spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.ProductDTO;
import spring.web.service.ManageService;

@Controller
public class ManageController {

	@Autowired
	ManageService managerService;
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
		List<ProductDTO> productlist = managerService.selectAllProududct();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", productlist);
		
		mv.setViewName("productManage");
		return mv;
	}
	
	/**
	 * 개별상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	@RequestMapping("productRegisterManage")
	public String productRegisterManage(HttpServletRequest request, ProductDTO productDTO ) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div
		 */
		int result = managerService.productRegisterManage(productDTO);
		if(result==0){
			request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "productManage";
	}
	
	/**
	 * 개별상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, String productno) {
		int result = managerService.productModifyManage(productno);
		if(result==0){
			request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:productManage";
	}
	
	/**
	 * 개별상품관리 삭제
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	@RequestMapping("productDeleteManage")
	public String productDeleteManage(HttpServletRequest request, ProductDTO productdto) {
		int result =0;
		result = managerService.productDeleteManage(productdto);
		System.out.println(result);
		return "redirect:productManage";
	}
	
	/**
	 * 세트상품관리 클릭했을 때
	 * package DTO 리스트
	 * */
	@RequestMapping("packageManage")
	public void packageManage() {
		
	}
	
	/**
	 * 세트상품 상세정보
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	@RequestMapping("packageShowManage")
	public void packageShowManage() {
		
	}
	
	/**
	 * 세트상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	@RequestMapping("packageRegisterManage")
	public void packageRegisterManage() {
		
	}
	
	/**
	 * 세트상품 등록에서 개별상품 검색(ajax)
	 * 상품번호, 상품이름 아래에 추가
	 * */
	@RequestMapping("packageSearchProduct")
	public void packageSearchProduct() {
		
	}
	
	/**
	 * 세트상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	@RequestMapping("packageModifyManage")
	public void packageModifyManage() {
		
	}
	
	/**
	 * 세트상품관리 삭제
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	@RequestMapping("packageDeleteManage")
	public void packageDeleteManage() {
		
	}
	
	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * */
	@RequestMapping("producerManage")
	public void producerManage() {
		
	}
	
	/**
	 * 생산자 등록
	 * */
	@RequestMapping("producerRegisterManage")
	public void producerRegisterManage() {
		
	}
	
	/**
	 * 생산자 수정
	 * */
	@RequestMapping("producerModifyManage")
	public void producerModifyManage() {
		
	}
	
	/**
	 * 생산자 삭제
	 * (alert)
	 * */
	@RequestMapping("producerDeleteManage")
	public void producerDeleteManage() {
		
	}
	
	/**
	 * 매출관리
	 * 총매출이 바로 보여짐
	 * 총매출, 총지출, 순이익
	 * */
	@RequestMapping("salesManage")
	public void salesManage() {
		
	}
	
	/**
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
	 * */
	@RequestMapping("memberManage")
	public void memberManage() {
		
	}
	
	/**
	 * 회원관리(삭제)
	 * */
	@RequestMapping("memberDeleteManage")
	public void memberDeleteManage() {
		
	}
	
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * */
	@RequestMapping("communityManage")
	public void communityManage() {
		
	}
	
	/**
	 * 모임관리(등록)
	 * */
	@RequestMapping("communityRegisterManage")
	public void communityRegisterManage() {
		
	}
	
	/**
	 * 모임관리(수정)
	 * */
	@RequestMapping("communityModifyManage")
	public void communityModifyManage() {
		
	}
	
	/**
	 * 모임관리(삭제)
	 * */
	@RequestMapping("communityDeleteManage")
	public void communityDeleteManage() {
		
	}
	
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	@RequestMapping("qnaManage")
	public void qnaManage() {
		
	}
	
	/**
	 * Q&A 답변 등록
	 * */
	@RequestMapping("qnaRegisterManage")
	public void qnaRegisterManage() {
		
	}
	
	/**
	 * Q&A 답변 수정
	 * */
	@RequestMapping("qnaModifyManage")
	public void qnaModifyManage() {
		
	}
	
	/**
	 * Q&A 질문 삭제
	 * */
	@RequestMapping("qnaDeleteManage")
	public void qnaDeleteManage() {
		
	}
	
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * */
	@RequestMapping("donationOrgManage")
	public void donationOrgManage() {
		
	}
	
	/**
	 * 기부업체 관리(등록)
	 * */
	@RequestMapping("donationOrgRegisterManage")
	public void donationOrgRegisterManage() {
		
	}
	
	/**
	 * 기부업체 관리(수정)
	 * */
	@RequestMapping("donationOrgModifyManage")
	public void donationOrgModifyManage() {
		
	}
	
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
	 * */
	@RequestMapping("donationOrgDeleteManage")
	public void donationOrgDeleteManage() {
		
	}
}
