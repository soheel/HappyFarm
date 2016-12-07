package spring.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<ProductDTO> selectAllProduct() {
		return sqlsession.selectList("userEtcMapper.selectAllProduct");
	}

	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return sqlsession.insert("userEtcMapper.insertProduct",productDTO);
		
	}

	/*@Override
	public ProductDTO productInfoMangage(String no) {
		return sqlsession.selectOne("userEtcMapper.productInfoMangage", no);
	}
*/
	@Override
	public int productModifyManage(ProductDTO productDTO) {
		return sqlsession.update("userEtcMapper.productModifyManage",productDTO);
	}

	@Override
	public int productDeleteManage(int no) {
		return sqlsession.delete("userEtcMapper.productDeleteManage",no);
	}

	@Override
	public List<PackageDTO> packageManage() {
		return sqlsession.selectList("userEtcMapper.packageManage");
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
	public int packageDeleteManage(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> selectAllProducer() {
		return sqlsession.selectList("userEtcMapper.selectAllProducer");
	}

	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		return sqlsession.insert("userEtcMapper.producerRegisterManage",producerDTO);
	}

	@Override
	public ProducerDTO producerInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int producerModifyManage(ProducerDTO producerDTO) {
		return sqlsession.update("userEtcMapper.producerModifyManage",producerDTO);
	}

	@Override
	public int producerDeleteManage(int no) {
		return sqlsession.delete("userEtcMapper.producerDeleteManage",no);
	}
	
	@Override
	public List<ProductDTO> selectAllMember() {
		return sqlsession.selectList("userEtcMapper.selectAllMember");
	}

	@Override
	public int memberDeleteManage(String email) {
		return sqlsession.delete("userEtcMapper.memberDeleteManage",email);
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
