package spring.web.service;

import java.util.Map;

import spring.web.dto.MemberDTO;

public class UserInfoServiceImpl implements UserInfoService {

	/**
	 * 회원가입
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return 0;
	}
	
	/**
	 * 계정찾기(id)
	 * */
	@Override
	public String searchId(MemberDTO memeberDto) {
		return null;
	}
	
	/**
	 * 계정찾기(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return null;
	}
	
	/**
	 * 계정찾기(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return null;
	}
	
	/**
	 * 로그인하기
	 * */
	@Override
	public MemberDTO login(String email, String pwd) {
		return null;
	}
	
	/**
	 * 아이디 중복확인
	 * */
	@Override
	public boolean checkId(String email) {
		return false;
	}
	
	/**
	 * 마이페이지 이동시 -> 회원 마일리지 및 현재진행중인 거래내역 가져오기
	 * */
	@Override
	public Map<String, Integer> myPageLoading(String email) {
		return null;
	}
	
	/**
	 * 회원 메인 페이지로 이동할 때 필요한 정보들
	 * (생산자에 대한 정보 , 인기 상품 3개에 대한 정보, 기부정보(저번달 총 모금액,이번달 총 모금액))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		return null;
	}
	
}
