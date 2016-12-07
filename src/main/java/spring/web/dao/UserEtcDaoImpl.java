package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

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
	public CommunityDTO communityDetail(String no) {
		return sqlsession.selectOne("userEtcMapper.communityDetail",no);
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
