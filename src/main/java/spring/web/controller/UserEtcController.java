package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserEtcController {
	
	// 모임
	
	/**
	 * 모임목록 불러오기
	 * 모임DTO 리스트
	 * */
	@RequestMapping("communityLoading")
	public void communityLoading() {
		
	}
	
	/**
	 * 모임 상세보기
	 * 모임DTO, 오른쪽 사이드바에 진행중인 행사 목록 가져오기
	 * */
	@RequestMapping("communityDetail")
	public void communityDetail() {
		
	}
	
	// Q&A
	
	/**
	 * Q&A 게시판 클릭했을 때
	 * qna DTO 리스트
	 * */
	@RequestMapping("qnaLoading")
	public void qnaLoaidng() {
		
	}
	
	/**
	 * Q&A 글쓰기
	 * */
	@RequestMapping("qnaWrite")
	public void qnaWrite() {
		
	}
	
	// 정보
	
	/**
	 * info 눌렀을 때 
	 * info DTO 리스트 가져오기
	 * */
	@RequestMapping("infoLoading")
	public void infoLoading() {
		
	}
	
	/**
	 * info 상세보기
	 * info DTO 가져오기
	 * */
	@RequestMapping("infoDetail")
	public void infoDetail() {
		
	}
	
	// 기부
	
	/**
	 * donation 눌렀을 때
	 * 전체기부현황(5달) 나머지는 다운로드
	 * 차트
	 * */
	@RequestMapping("donationLoading")
	public void donationLoading() {
		
	}
	
	// 메인
	
	/**
	 * 생산자 상세보기
	 * 생산자 DTO, 지도
	 * */
	@RequestMapping("producerDetail")
	public void producerDetail() {
		
	}
}
