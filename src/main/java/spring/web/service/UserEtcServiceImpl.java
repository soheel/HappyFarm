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
	public CommunityDTO communityDetail(String communityNo) {
		return userEtcDao.communityDetail(communityNo);
	}
	/**
	 * Q&A ���
	 */
	@Override
	public int registerQnA(QnaDTO qnaDTO) {
		return userEtcDao.registerQnA(qnaDTO);
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
	public InfomationDTO infoDetail(String qnano) {
		return userEtcDao.infoDetail(qnano);
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
	public ProducerDTO producerDetail() {
		return userEtcDao.producerDetail();
	}
	/**
	 * �������� ��縸 ��Ƽ� �ҷ�����)
	 * @return
	 */
	@Override
	public List<CommunityDTO> communityIngList() {
		return userEtcDao.communityIngList();
	}
	/**
	 * ��� ���� ���θ� ��ۿ� �Է��ϴ� ��, �� ��ۿ� ���� �������� �ҷ��´�
	 */
	@Override
	public List<CommunityCommentDTO> commmentList(String communityNo) {
		return userEtcDao.commmentList(communityNo);
	}

}
