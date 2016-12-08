package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserEtcDao;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

@Service
public class UserEtcServiceImpl implements UserEtcService{

	@Autowired
	private UserEtcDao userEtcDao;
	/**
	 * 모임목록 불러오기 
	 * 모임DTO 리스트(select + 페이징)
	 */
	@Override
	public Map<String, Object> communityLoading(CommunityDTO communityDTO) {
		return userEtcDao.communityLoading(communityDTO);
	}
	/**
	 * 모임상세 정보 불러오기 
	 */
	@Override
	public Map<String, Object> communityDetail(int no) {
		return userEtcDao.communityDetail(no);
	}
	/**
	 * Q&A 등록
	 */
	@Override
	public int registerQnA(QnaDTO qnaDTO) {
		return userEtcDao.registerQnA(qnaDTO);
	}
	/**
	 * Q&A 등록폼이 뜨고 + 목록 
	 * @return
	 */
	@Override
	public List<QnaDTO> qnaLoading() {
		return userEtcDao.qnaLoading();
	}
	/**
	 * 행사 정보 로딩
	 * @return
	 */
	@Override
	public List<InfomationDTO> infoLoading() {
		return userEtcDao.infoLoading();
	}
	/**
	 * 행사 상세 정보 로딩
	 */
	@Override
	public InfomationDTO infoDetail(int no) {
		return userEtcDao.infoDetail(no);
	}
	/**
	 * 기부 목록 5개 + 차트 로딩
	 */
	@Override
	public List<DonationDTO> donationLoading() {
		return userEtcDao.donationLoading();
	}
	/**
	 * 생산자 정보 불러오기(이미지 + 정보 + 지도)
	 * @return
	 */
	@Override
	public Map<String, Object> producerDetail(int no) {
		return userEtcDao.producerDetail(no);
	}
	/**
	 * 진행중인 행사만 모아서 불러오기)
	 * @return
	
	@Override
	public List<CommunityDTO> communityIngList() {
		return userEtcDao.communityIngList();
	}
	
	 * 행사 참여 여부를 댓글에 입력하는 데, 그 댓글에 대한 정보들을 불러온다
	 
	@Override
	public List<CommunityCommentDTO> commmentList(int no) {
		return userEtcDao.commmentList(no);
	} */

}
