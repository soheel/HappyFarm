package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcService {
	/**
	 * 모임목록 불러오기 
	 * 모임DTO 리스트(select + 페이징)
	 * @param communityDTO 
	 */
	Map<String, Object> communityLoading();	

	/**
	 * 모임상세 정보 불러오기 
	 */
	Map<String, Object> communityDetail(int no);
	/**
	 * Q&A 등록
	 */
	int registerQnA(QnaDTO qnaDto);
	/**
	 * Q&A 등록폼이 뜨고 + 목록 
	 * @return
	 */
	List<QnaDTO> qnaLoading();

	/**
	 * 행사 정보 로딩
	 * @return
	 */
	List<InfomationDTO> infoLoading();
	/**
	 * 행사 상세 정보 로딩
	 */
	InfomationDTO infoDetail(int no);
	
	/**
	 * 정보 관련된 상품 보여주기
	 */
	List<ProductDTO> infoRelatedProduct(String name);

	
	/**
	 * 기부 목록 5개 + 차트 로딩
	 */
	List<DonationDTO> donationLoading();
	/**
	 * 생산자 정보 불러오기(이미지 + 정보 + 지도)
	 * @return
	 */
	Map<String, Object> producerDetail(int no);

	/**
	 * 진행중인 행사만 모아서 불러오기)
	 * @return
	
	List<CommunityDTO> communityIngList();
	
	 * 행사 참여 여부를 댓글에 입력하는 데, 그 댓글에 대한 정보들을 불러온다
	
	List<CommunityCommentDTO> commmentList(int no);
	 */
	
	/**
	 * 행사 덧글 입력
	 * @param comment
	 * @param communityNo
	 * @return
	 */
	int communityReply(String comment, int communityNo, String email);
	
	/**
	 * 행사 덧글 삭제
	 * @param no
	 * @return
	 */
	int communityReplyDelete(int no);
	
	/**
	 * admin 행사 덧글 입력
	 * @param no
	 * @param comment
	 * @param communityNo
	 * @return
	 */
	int communityReplyInsert(int no, String comment, int communityNo, String email);
	
	/**
	 * 행사 덧글 수정
	 * @param no
	 * @param comment
	 * @return
	 */
	int communityReplyUpdate(int no, String comment);
	
	/**
	 * 기부단체정보
	 * */
	DonationOrgDTO donationLoading2();

}
