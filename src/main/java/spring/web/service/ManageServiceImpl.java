package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.ManageDao;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	private ManageDao manageDao;
	/** ������ǰ���� Ŭ������ ��
	 * ��ǰ��ȣ ������� (category_subcategory_no�� null�� �ƴѰ͸� ��������) ����Ʈ��
	 * */
	@Override
	public List<ProductDTO> selectAllProduct() {
		return manageDao.selectAllProduct();
	}

	/**
	 * ������ǰ���� ���(������� div�� �����)
	 * */
	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return manageDao.productRegisterManage(productDTO);
	}

	/**
	 * ������ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 * */
	@Override
	public ProductDTO productInfoMangage(String productno) {
		return manageDao.productInfoMangage(productno);
	}

	/**
	 * ������ǰ���� ���� ������ div�� �����
	 * */
	@Override
	public int productModifyManage(String productno) {
		return manageDao.productModifyManage(productno);
	}

	/**
	 * ������ǰ���� ����  - �������� div�� ����� (alert)
	 * */
	@Override
	public int productDeleteManage(String productno) {
		return manageDao.productDeleteManage(productno);
	}
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��  package DTO ����Ʈ
	 * */
	@Override
	public List<PackageDTO> packageManage() {
		return manageDao.packageManage();
	}
	
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	@Override
	public List<ProductDTO> packageShowManage(String packagename) {
		return manageDao.packageShowManage(packagename);
	}

	/**
	 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
	 */
	@Override
	public List<ProductDTO> packageSearchProduct(String productname) {
		return manageDao.packageSearchProduct(productname);
	}
	/**
	 * ��Ʈ��ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 */
	@Override
	public ProductDTO packageInfoMangage(String productno) {
		return manageDao.packageInfoMangage(productno);
	}

	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	@Override
	public int packageModifyManage(Map<String, Object> modifyinfo) {
		return manageDao.packageModifyManage(modifyinfo);
	}

	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * */
	@Override
	public List<ProductDTO> selectAllProducer() {
		return manageDao.selectAllProducer();
	}

	/**
	 * ������ ���
	 * */
	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		return manageDao.producerRegisterManage(producerDTO);
	}

	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public ProducerDTO producerInfoMangage(String producerno) {
		return manageDao.producerInfoMangage(producerno);
	}

	/**
	 * ������ ����
	 * */
	@Override
	public int producerModifyManage(String producerno) {
		return manageDao.producerModifyManage(producerno);
	}

	/**
	 * ȸ������
	 * ȸ�� DTO ����Ʈ(��������)
	 * */
	@Override
	public List<ProductDTO> selectAllMember() {
		return manageDao.selectAllMember();
	}
	/**
	 * ȸ������(����)
	 * */
	@Override
	public int memberDeleteManage(String email) {
		return manageDao.memberDeleteManage(email);
	}
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * */
	@Override
	public List<CommunityDTO> communityManage() {
		return manageDao.communityManage();
	}

	/**
	 * ���Ӱ���(���)
	 * */
	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		return manageDao.communityRegisterManage(communityDTO);
	}
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public CommunityDTO communityInfoMangage(String communityno) {
		return manageDao.communityInfoMangage(communityno);
	}
	/**
	 * ���Ӱ���(����)
	 * */
	@Override
	public int communityModifyManage(String communityno) {
		return manageDao.communityModifyManage(communityno);
	}
	/**
	 * ���Ӱ���(����)
	 * @return 
	 * */
	@Override
	public int communityDeleteManage(String communityno) {
		return manageDao.communityDeleteManage(communityno);
	}
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	@Override
	public List<QnaDTO> qnaManage() {
		return manageDao.qnaManage();
	}
	/**
	 * Q&A �亯 ���
	 * @return 
	 * */
	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		return manageDao.qnaRegisterManage(communitycommentDTO);
	}
	/**
	 * �������� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public QnaDTO qnaInfoMangage(String qnano) {
		return manageDao.qnaInfoMangage(qnano);
	}
	/**
	 * Q&A �亯 ����
	 * */
	@Override
	public int qnaModifyManage(String communitycommentno) {
		return manageDao.qnaModifyManage(communitycommentno);
	}
	/**
	 * Q&A ���� ����
	 * */
	@Override
	public int qnaDeleteManage(String communitycommentno) {
		return manageDao.qnaDeleteManage(communitycommentno);
	}
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * */
	@Override
	public List<DonationDTO> donationOrgManage() {
		return manageDao.donationOrgManage();
	}
	/**
	 * ��ξ�ü ����(���)
	 **/
	@Override
	public int donationOrgRegisterManage(DonationDTO donationDTO) {
		return manageDao.donationOrgRegisterManage(donationDTO);
	}
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public DonationDTO donationOrgInfoMangage(String donationOrgno) {
		return manageDao.donationOrgInfoMangage(donationOrgno);
	}
	/**
	 * ��ξ�ü ����(����)
	 * */
	@Override
	public int donationOrgModifyManage(DonationDTO donationDTO) {
		return manageDao.donationOrgModifyManage(donationDTO);
	}
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * */
	@Override
	public int donationOrgDeleteManage(String donationOrgNo) {
		return manageDao.donationOrgDeleteManage(donationOrgNo);
	}

}
