package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface ManageDao {
	/** ������ǰ���� Ŭ������ ��
	 * ��ǰ��ȣ ������� (category_subcategory_no�� null�� �ƴѰ͸� ��������) ����Ʈ��
	 * */
	List<ProductDTO> selectAllProduct();
	/**
	 * ������ǰ���� ���(������� div�� �����)
	 * */
	int productRegisterManage(ProductDTO productDTO);
	
	
	/**
	 * ��ǰ ������ ���� �ش� ��ǰ�� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public ProductDTO productInfoMangage(int no);
	
	/**
	 * ������ǰ���� ���� ������ div�� �����
	 * */
	int productModifyManage(ProductDTO productDTO);
	
	/**
	 * ������ǰ���� ����  - �������� div�� ����� (alert)
	 * */
	int productDeleteManage(int no);
	
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��  package DTO ����Ʈ
	 * */
	List<PackageDTO> packageManage();
	
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	public List<String> packageShowManage(int packagePk);
	
	/**
	 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
	 */
	List<ProductDTO> packageSearchProduct(String productname);
	
	/**
	 * ��Ʈ��ǰ ���
	 * */
	int packageRegisterManage(PackageDTO packageDTO);
	
	/**
	 * ��Ʈ��ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 */
	ProductDTO packageInfoMangage(String productno);
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	int packageModifyManage(Map<String, Object> modifyinfo);
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	int packageDeleteManage(String name);
	
	/**
	 * ��� �� ����� ��Ű�� ��ǰ ��ȣ ��������
	 * */
	int getRecentPackageNo();
	
	/**
	 * ��Ű�� ��ǰ ���� ���� ��ǰ ���
	 * */
	int packageProductRegisterManage(int packageNo, int productNo);
	
	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * */
	List<ProducerDTO> selectAllProducer();
	
	/**
	 * ������ ���
	 * */
	int producerRegisterManage(ProducerDTO producerDTO);
	
	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	ProducerDTO producerInfoMangage(int producerno);
	
	/**
	 * ������ ����
	 * */
	int producerModifyManage(ProducerDTO producerDTO);
	
	/**
	 * ������ ����
	 * */
	int producerDeleteManage(int no);
	
	
	/**
	 * ȸ������
	 * ȸ�� DTO ����Ʈ(��������)
	 * */
	List<MemberDTO> selectAllMember();
	
	/**
	 * ȸ������(����)
	 * */
	int memberDeleteManage(String email);
	
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * */
	List<CommunityDTO> communityManage();
	
	/**
	 * ���Ӱ���(���)
	 * */
	int communityRegisterManage(CommunityDTO communityDTO);
	
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	CommunityDTO communityShowMangage(int communityno);
	
	/**
	 * ���Ӱ���(����)
	 * */
	int communityModifyManage(CommunityDTO communityDTO);
	
	/**
	 * ���Ӱ���(����)
	 * */
	int communityDeleteManage(String communityno);
	
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	List<QnaDTO> qnaManage();
	
	/**
	 * Q&A �亯 ���
	 * @return 
	 * */
	int qnaRegisterManage(CommunityCommentDTO communitycommentDTO);
	
	/**
	 * �������� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 
	QnaDTO qnaInfoMangage(String qnano);
	*/
	
	/**
	 * Q&A �亯 ����
	 * */
	int qnaModifyManage(QnaDTO qnaDTO);
	
	/**
	 * Q&A ���� ����
	 * */
	int qnaDeleteManage(String communitycommentno);
	
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * */
	List<DonationOrgDTO> donationOrgManage();
	
	/**
	 * ��ξ�ü ����(���)
	 **/
	int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO);
	
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	DonationOrgDTO donationOrgShowMangage();
	
	/**
	 * ��ξ�ü ����(����)
	 * */
	int donationOrgModifyManage(DonationOrgDTO donationOrgDTO);
	
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * */
	int donationOrgDeleteManage(int no);
	
	/**
	 * �����ں� ���� ����Ʈ ��������
	 * */
	float getProducerEval(int producerNo);
	
	/**
	 * ���� ���� ��������
	 * */
	List<Integer> getMonthSales();
	
	/**
	 * �ǸŻ�ǰ ���� ��������
	 * */
	List<HashMap<String, String>> getSalesProduct();
}
