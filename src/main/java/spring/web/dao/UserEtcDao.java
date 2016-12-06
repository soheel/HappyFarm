package spring.web.dao;

import java.util.List;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcDao {

	List<CommunityDTO> communityLoading();

	CommunityDTO communityDetail(String no);

	int registerQnA(QnaDTO qnaDTO);

	List<QnaDTO> qnaLoading();

	List<InfomationDTO> infoLoading();

	InfomationDTO infoDetail(String no);

	List<DonationDTO> donationLoading();

	ProducerDTO producerDetail();

	List<CommunityDTO> communityIngList();

	List<CommunityCommentDTO> commmentList(String no);

}
