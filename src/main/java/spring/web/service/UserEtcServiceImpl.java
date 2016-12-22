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
	 * ���Ӹ�� �ҷ����� 
	 * ����DTO ����Ʈ(select + ����¡)
	 */
	@Override
	public Map<String, Object> communityLoading() {
		return userEtcDao.communityLoading();
	}
	/**
	 * ���ӻ� ���� �ҷ����� 
	 */
	@Override
	public Map<String, Object> communityDetail(int no) {
		return userEtcDao.communityDetail(no);
	}
	
	/**
	 * ���� ���� �ۼ�
	 */
	@Override
	public int communityReply(String content, int communityNo, String email) {
		CommunityCommentDTO dto = new CommunityCommentDTO(content, communityNo, email);
		return userEtcDao.communityReply(dto);
	}
	
	/**
	 * ���� ���� ����
	 */
	@Override
	public int communityReplyDelete(int no) {
		return userEtcDao.communityReplyDelete(no);
	}
	
	
	/**
	 * ���� ���� �߰�
	 */
	@Override
	public int communityReplyInsert(int no, String content, int comunityNo, String email) {
		CommunityCommentDTO dto = new CommunityCommentDTO(no, content, comunityNo, email);
		return userEtcDao.communityReplyInsert(dto);
	}
	
	/**
	 * ���� ���� ����
	 */
	@Override
	public int communityReplyUpdate(int no, String content) {
		CommunityCommentDTO dto = new CommunityCommentDTO(no, content);
		return userEtcDao.communityReplyUpdate(dto);
	}

	
	/**
	 * Q&A ���
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
	 * Q&A ������� �߰� + ��� 
	 * @return
	 */
	@Override
	public List<QnaDTO> qnaLoading() {
		return userEtcDao.qnaLoading();
	}
	/**
	 * ��� ���� �ε�
	 * @return
	 */
	@Override
	public List<InfomationDTO> infoLoading() {
		return userEtcDao.infoLoading();
	}
	/**
	 * ��� �� ���� �ε�
	 */
	@Override
	public InfomationDTO infoDetail(int no) {
		return userEtcDao.infoDetail(no);
	}
	
	/**
	 * ���� ���õ� ��ǰ �����ֱ�
	 */
	@Override
	public List<ProductDTO> infoRelatedProduct(String name) {
		return userEtcDao.infoRelatedProduct(name);
	}
	
	/**
	 * ��� ��� 5�� + ��Ʈ �ε�
	 */
	@Override
	public List<DonationDTO> donationLoading() {
		return userEtcDao.donationLoading();
	}
	/**
	 * ������ ���� �ҷ�����(�̹��� + ���� + ����)
	 * @return
	 */
	@Override
	public Map<String, Object> producerDetail(int no) {
		return userEtcDao.producerDetail(no);
	}
	/**
	 * �������� ��縸 ��Ƽ� �ҷ�����)
	 * @return
	
	@Override
	public List<CommunityDTO> communityIngList() {
		return userEtcDao.communityIngList();
	}
	
	 * ��� ���� ���θ� ��ۿ� �Է��ϴ� ��, �� ��ۿ� ���� �������� �ҷ��´�
	 
	@Override
	public List<CommunityCommentDTO> commmentList(int no) {
		return userEtcDao.commmentList(no);
	} */
	@Override
	public DonationOrgDTO donationLoading2() {
		return userEtcDao.donationLoading2();
	}
}
