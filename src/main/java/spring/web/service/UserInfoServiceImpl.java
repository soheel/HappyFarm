package spring.web.service;

import java.util.Map;

import spring.web.dto.MemberDTO;

public class UserInfoServiceImpl implements UserInfoService {

	/**
	 * ȸ������
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return 0;
	}
	
	/**
	 * ����ã��(id)
	 * */
	@Override
	public String searchId(MemberDTO memeberDto) {
		return null;
	}
	
	/**
	 * ����ã��(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return null;
	}
	
	/**
	 * ����ã��(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return null;
	}
	
	/**
	 * �α����ϱ�
	 * */
	@Override
	public MemberDTO login(String email, String pwd) {
		return null;
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * */
	@Override
	public boolean checkId(String email) {
		return false;
	}
	
	/**
	 * ���������� �̵��� -> ȸ�� ���ϸ��� �� ������������ �ŷ����� ��������
	 * */
	@Override
	public Map<String, Integer> myPageLoading(String email) {
		return null;
	}
	
	/**
	 * ȸ�� ���� �������� �̵��� �� �ʿ��� ������
	 * (�����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, �������(������ �� ��ݾ�,�̹��� �� ��ݾ�))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		return null;
	}
	
}
