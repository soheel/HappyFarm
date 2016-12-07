package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.net.aso.e;
import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * ȸ������
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return sqlSession.insert("userInfoMapper.registerMember", memberDto);
	}
	
	/**
	 * ����ã��(id)
	 * */
	@Override
	public String searchId(MemberDTO memeberDto) {
		return sqlSession.selectOne("userInfoMapper.searchId", memeberDto);
	}
	
	/**
	 * ����ã��(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return sqlSession.selectOne("userInfoMapper.searchPwdSendCode", email);
	}
	
	/**
	 * ����ã��(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return sqlSession.selectOne("userInfoMapper.searchPwd",code);
	}
	
	/**
	 * �α����ϱ�
	 * */
	@Override
	public MemberDTO login(MemberDTO memberDto) {	
		return sqlSession.selectOne("userInfoMapper.login", memberDto);
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * */
	@Override
	public boolean checkId(String email) {
		return sqlSession.selectOne("userInfoMapper.checkId", email);
	}
	
	/**
	 * ���������� �̵��� -> ȸ�� ���ϸ��� �� ������������ �ŷ����� ��������
	 * */
	@Override
	public Map<String, Integer> myPageLoading(String email) {
		return sqlSession.selectOne("userInfoMapper.getMileageAndOrderlist", email);
	}
	
	/**
	 * ȸ�� ���� �������� �̵��� �� �ʿ��� ������
	 * (�����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, �������(������ �� ��ݾ�,�̹��� �� ��ݾ�))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		
		return null;
	}
	
	/**
	 * MyPage�� ���γ����� �������
	 * �ٷ� �ֹ�/�����ȸ�� �̷�����鼭
	 * ȸ���� 3������ �ֹ���ȸ ������ purchase���̺���
	 * �����ͼ� view�� �ѷ���
	 * */
	@Override
	public List<ProductDTO> myPageOrderList(String email) {
		return null;
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * �ش� ��� ����
	 * */
	@Override
	public int deleteOrderProduct(String email) {
		
		return 0;
	}
	
	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 * */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		
		return null;
	}
	
	/**
	 * �ش� �����ۿ� �޸� ��� ��������
	 * */
	@Override
	public String showAnswer(QnaDTO qnaDto) {
		
		return null;
	}
	
	/**
	 * ������ - ��������� ������ ��
	 * */
	@Override
	public List<DonationDTO> myPageDonation(String email) {
		
		return null;
	}
	
	/**
	 * ������ - ������������
	 * */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		
		return null;
	}
	
	/**
	 * ������ - ���ϸ��� ������ ��
	 * */
	public Map<String,Object> myPageMileage(String email) {
		
		return null;
	}
	
	/**
	 * ������ - ��ٱ��� �ε�
	 * */
	 @Override
	public Map<String, Object> myCart(String email) {
		
		return null;
	}
	 
	 /**
	  * ������ - ��ٱ��� -> �ֹ��ϱ� ��ư�� ������ ��
	  * */
	 @Override
	public List<ProductDTO> myCartOrder(String email) {
		
		return null;
	}
	 /**
	  * ������  - ��ٱ��� -> ��ٱ��� ���� ��ǰ ����
	  * */
	 @Override
	public int myCartDelete(int no) {
		
		return 0;
	}
	 
}
