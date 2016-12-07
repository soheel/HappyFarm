package spring.web.dao;

import java.util.List;
import java.util.Map;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcDao {

	Map<String, Object> communityLoading();

	Map<String, Object> communityDetail(int no);

	int registerQnA(QnaDTO qnaDTO);

	List<QnaDTO> qnaLoading();

	List<InfomationDTO> infoLoading();

	InfomationDTO infoDetail(int no);

	List<DonationDTO> donationLoading();

	Map<String, Object> producerDetail(int no);
/*
	List<CommunityDTO> communityIngList();

	List<CommunityCommentDTO> commmentList(int no);*/

}
