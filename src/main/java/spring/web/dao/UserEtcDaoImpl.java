package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

@Repository
public class UserEtcDaoImpl implements UserEtcDao {

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public Map<String, Object> communityLoading() {
		Map<String, Object> communityList = new HashMap<String, Object>();
		
		List<CommunityDTO> communityIngList = sqlsession.selectList("userEtcMapper.getCommunityIng");
		List<CommunityDTO> communityPastList = sqlsession.selectList("userEtcMapper.getCommunityPast");
		
		communityList.put("communityIngList", communityIngList);
		communityList.put("communityPastList", communityPastList);
		
		return communityList;
	}

	@Override
	public Map<String, Object> communityDetail(int no) {
		Map<String, Object> communityDetailList = new HashMap<String, Object>();
		//�ش��ȣ�� �ش��ϴ� ������ �̹��� �޾ƿ���
		String profile = sqlsession.selectOne("userEtcMapper.getCommunityProfile",no);
		
		//��� ���� �޾ƿ���
		List<CommunityDTO> commentlist = sqlsession.selectList("userEtcMapper.getCommunityComment",no);
		
		// ���� �������� ��� ��� �޾ƿ���
		List<CommunityDTO> communityIngList = sqlsession.selectList("userEtcMapper.getCommunityIng");
		
		communityDetailList.put("profile", profile);
		communityDetailList.put("commentlist", commentlist);
		communityDetailList.put("communityIngList", communityIngList);

		
		return communityDetailList;
	}

	@Override
	public int registerQnA(QnaDTO qnaDTO) {
		//Q&A �ش��ϴ� session�� ����Ǿ��ִ� email�� ���� �̸��� �� ���� �� �ش��ϴ� email�� qnaDTo�� �߰��Ѵ�.
		return sqlsession.insert("userEtcMapper.registerQnA",qnaDTO);
	}

	@Override
	public List<QnaDTO> qnaLoading() {
		//Qna�� �ε��Ѵ�. ���..!!   
		return sqlsession.selectList("userEtcMapper.qnaLoading");
	}

	@Override
	public List<InfomationDTO> infoLoading() {
		//������ ��� �ε��Ѵ� ���
		return sqlsession.selectList("userEtcMapper.infoLoading");
	}

	@Override
	public InfomationDTO infoDetail(int no) {
		//information_no�� request���� �޾� �װͿ� �ش��ϴ� ������ �ϳ� �޴´�.
		return sqlsession.selectOne("userEtcMapper.infoDetail",no);
	}

	@Override
	public List<DonationDTO> donationLoading() {
		//donation���̺��ִ�donation�������� ��� �޾ƿ´�.
		return sqlsession.selectList("userEtcMapper.donationLoadingg");
	}

	@Override
	public ProducerDTO producerDetail() {
		return sqlsession.selectOne("userEtcMapper.producerDetail");
	}
/*
	@Override
	public List<CommunityDTO> communityIngList() {
		return sqlsession.selectList("userEtcMapper.communityIngList");
	}

	@Override
	public List<CommunityCommentDTO> commmentList(int no) {
		return sqlsession.selectList("userEtcMapper.commmentList",no);
	}*/

}
