package spring.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Repository
public class ManageDaoImpl implements ManageDao {

	@Override
	public List<ProductDTO> selectAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO productInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int productModifyManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productDeleteManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PackageDTO> packageManage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> packageShowManage(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> packageSearchProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO packageInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int packageModifyManage(Map<String, Object> modifyinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> selectAllProducer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProducerDTO producerInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int producerModifyManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberDeleteManage(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommunityDTO> communityManage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommunityDTO communityInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int communityModifyManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int communityDeleteManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QnaDTO> qnaManage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QnaDTO qnaInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int qnaModifyManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int qnaDeleteManage(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DonationDTO> donationOrgManage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int donationOrgRegisterManage(DonationDTO donationDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DonationDTO donationOrgInfoMangage(String donationOrgno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int donationOrgModifyManage(DonationDTO donationDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int donationOrgDeleteManage(String donationOrgNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
