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
	public Map<String, Object> communityDetail(String no) {
		Map<String, Object> communityDetailList = new HashMap<String, Object>();
		//해당번호에 해당하는 프로필 이미지 받아오기
		String profile = sqlsession.selectOne("userEtcMapper.getCommunityProfile",no);
		
		//댓글 정보 받아오기
		List<CommunityDTO> commentlist = sqlsession.selectList("userEtcMapper.getCommunityComment",no);
		
		// 현재 진행중인 행사 목록 받아오기
		List<CommunityDTO> communityIngList = sqlsession.selectList("userEtcMapper.getCommunityIng");
		
		communityDetailList.put("profile", profile);
		communityDetailList.put("commentlist", commentlist);
		communityDetailList.put("communityIngList", communityIngList);

		
		return communityDetailList;
	}

	@Override
	public int registerQnA(QnaDTO qnaDTO) {
		return sqlsession.insert("userEtcMapper.registerQnA",qnaDTO);
	}

	@Override
	public List<QnaDTO> qnaLoading() {
		return sqlsession.selectList("userEtcMapper.qnaLoading");
	}

	@Override
	public List<InfomationDTO> infoLoading() {
		return sqlsession.selectList("userEtcMapper.infoLoading");
	}

	@Override
	public InfomationDTO infoDetail(String no) {
		return sqlsession.selectOne("userEtcMapper.infoDetail",no);
	}

	@Override
	public List<DonationDTO> donationLoading() {
		return sqlsession.selectList("userEtcMapper.donationLoadingg");
	}

	@Override
	public ProducerDTO producerDetail() {
		return sqlsession.selectOne("userEtcMapper.producerDetail");
	}

	@Override
	public List<CommunityDTO> communityIngList() {
		return sqlsession.selectList("userEtcMapper.communityIngList");
	}

	@Override
	public List<CommunityCommentDTO> commmentList(String no) {
		return sqlsession.selectList("userEtcMapper.commmentList",no);
	}

}
