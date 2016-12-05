package spring.web.service;

import java.util.Map;

import spring.web.dto.MemberDTO;

public interface UserInfoService {

	/**
	 * 회원가입
	 * */
	int registerMember(MemberDTO memberDto);
	
	/**
	 * 계정찾기(id)
	 * */
	String searchId(MemberDTO memeberDto);
	
	/**
	 * 계정찾기(pwd-sendcode)
	 * */
	String searchPwdSendCode(String email);
	
	/**
	 * 계정찾기(pwd)
	 * */
	String searchPwd(String code);
	
	/**
	 * 로그인하기
	 * */
	MemberDTO login(String email,String pwd);
	
	/**
	 * 아이디 중복확인 / 추천인 아이디 중복확인
	 * */
	boolean checkId(String email);
	
	/**
	 * 회원 메인 페이지로 이동할 때 필요한 정보들
	 * (생산자에 대한 정보 , 인기 상품 3개에 대한 정보, 기부정보(저번달 총 모금액,이번달 총 모금액))
	 * */
	Map<String, Object> userMainLoading();
	
	/**
	 * 회원이 마이페이지를 눌렀을 때
	 * 마이페이지 메인 정보 로딩
	 * */
	Map<String, Integer> myPageLoading(String email); 
	
	
	
}
