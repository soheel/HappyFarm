package spring.web.dao;

import java.util.List;
import java.util.Map;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcDao {

	Map<String, Object> communityLoading();

	Map<String, Object> communityDetail(int no);

	int registerQnA(QnaDTO qnaDto);

	List<QnaDTO> qnaLoading();

	List<InfomationDTO> infoLoading();

	InfomationDTO infoDetail(int no);

	List<ProductDTO> infoRelatedProduct(String name);
	
	List<DonationDTO> donationLoading();

	Map<String, Object> producerDetail(int no);
/*
	List<CommunityDTO> communityIngList();

	List<CommunityCommentDTO> commmentList(int no);*/
	
	DonationOrgDTO donationLoading2();

	

}
