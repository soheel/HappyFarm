package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserEtcDao;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
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
	public Map<String, Object> communityLoading() {
		return userEtcDao.communityLoading();
	}
	/**
	 * 모임상세 정보 불러오기 
	 */
	@Override
	public Map<String, Object> communityDetail(int no) {
		return userEtcDao.communityDetail(no);
	}
	
	/**
	 * 모임 덧글 작성
	 */
	@Override
	public int communityReply(String content, int communityNo, String email) {
		CommunityCommentDTO dto = new CommunityCommentDTO(content, communityNo, email);
		return userEtcDao.communityReply(dto);
	}
	
	/**
	 * 모임 덧글 삭제
	 */
	@Override
	public int communityReplyDelete(int no) {
		return userEtcDao.communityReplyDelete(no);
	}
	
	
	/**
	 * 모임 덧글 추가
	 */
	@Override
	public int communityReplyInsert(int no, String content, int comunityNo, String email) {
		CommunityCommentDTO dto = new CommunityCommentDTO(no, content, comunityNo, email);
		return userEtcDao.communityReplyInsert(dto);
	}
	
	/**
	 * 모임 덧글 수정
	 */
	@Override
	public int communityReplyUpdate(int no, String content) {
		CommunityCommentDTO dto = new CommunityCommentDTO(no, content);
		return userEtcDao.communityReplyUpdate(dto);
	}

	
	/**
	 * Q&A 등록
	 */
	@Override
	public int registerQnA(QnaDTO qnaDto) {
		return userEtcDao.registerQnA(qnaDto);
	}
	
	@Override
	public String answerQna(int no) {
		return userEtcDao.answerQna(no);
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
	 * 정보 관련된 상품 보여주기
	 */
	@Override
	public List<ProductDTO> infoRelatedProduct(String name) {
		return userEtcDao.infoRelatedProduct(name);
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
	@Override
	public DonationOrgDTO donationLoading2() {
		return userEtcDao.donationLoading2();
	}
}
