package spring.web.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcService {

	List<CommunityDTO> communityLoading();

	CommunityDTO communityDetail(String communityNo);

	int registerQnA(QnaDTO qnaDTO);

	List<QnaDTO> qnaLoading();

	List<InfomationDTO> infoLoading();

	InfomationDTO infoDetail(String qnano);

	List<DonationDTO> donationLoading();

	ProducerDTO producerDetail();

	List<CommunityDTO> communityIngList();

}
