package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Repository
public class ManageDaoImpl implements ManageDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<ProductDTO> selectAllProduct() {
		List<ProductDTO> list = sqlsession.selectList("manageMapper.selectAll");
		return list;
	}

	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return sqlsession.insert("manageMapper.productRegisterManage",productDTO);
		
	}

	@Override
	public int productNoFind(String name) {
		return sqlsession.selectOne("manageMapper.productNoFind",name);
	}
	
	@Override
	public int productCertiRegisterManage(ProductCertificationDTO productCertificationDTO) {
		return sqlsession.insert("manageMapper.productCertiRegisterManage",productCertificationDTO);
	}
	
	@Override
	public int productModifyManage(ProductDTO productDTO) {
		return sqlsession.update("manageMapper.productModifyManage",productDTO);
	}
	@Override
	public int productCertiModifyManage(ProductCertificationDTO productCertificationDTO) {
		return sqlsession.update("manageMapper.productCertiModifyManage",productCertificationDTO);
	}
	@Override
	public int productDeleteManage(int no) {
		return sqlsession.delete("manageMapper.productDeleteManage",no);
	}

	@Override
	public List<PackageDTO> packageManage() {
		List<PackageDTO> list = sqlsession.selectList("manageMapper.packageManage");
		System.out.println(list.size() + "@@@22222222222222");
		System.out.println(list.get(0).getPackageNo());
		System.out.println(list.get(0).getProductDTO().getName());
		System.out.println(list.get(0).getProductDTO().getPrice());
		return list;
	}

	@Override
	public List<String> packageShowManage(int packagePk) {
		return sqlsession.selectList("manageMapper.packageShowManage",packagePk);
		
	}

	@Override
	public int packageRegisterManage(PackageDTO packageDTO) {
		return sqlsession.insert("manageMapper.packageRegisterManage", packageDTO.getProductDTO());
	}
	
	@Override
	public List<ProductDTO> packageSearchProduct(String name) {
		return sqlsession.selectList("manageMapper.packageSearchProduct", name);
	}

	@Override
	public ProductDTO packageInfoMangage(String no) {
		return null;
	}

	@Override
	public int packageModifyManage(Map<String, Object> modifyinfo) {
		return 0;
	}
	
	@Override
	public int packageDeleteManage(String name) {
		return 0;
	}

	@Override
	public List<ProducerDTO> selectAllProducer() {
		return sqlsession.selectList("manageMapper.selectAllProducer");
	}

	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		System.out.println("けけけけけけけけけけけけけけけけけけけけけけけ");
		return sqlsession.insert("manageMapper.producerRegisterManage",producerDTO);
	}

	@Override
	public ProducerDTO producerInfoMangage(int no) {
		ProducerDTO producer = sqlsession.selectOne("UserProductMapper.getProducerByProducerNo", no);
		return producer;
	}

	@Override
	public int producerModifyManage(ProducerDTO producerDTO) {
		return sqlsession.update("manageMapper.producerModifyManage",producerDTO);
	}

	@Override
	public int producerDeleteManage(int no) {
		return sqlsession.delete("manageMapper.producerDeleteManage",no);
	}
	
	@Override
	public List<MemberDTO> selectAllMember() {
		return sqlsession.selectList("manageMapper.selectAllMember");
	}

	@Override
	public int memberDeleteManage(String email) {
		return sqlsession.delete("manageMapper.memberDeleteManage",email);
	}

	@Override
	public List<CommunityDTO> communityManage() {
		return sqlsession.selectList("manageMapper.communityManage");
	}

	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		return sqlsession.insert("manageMapper.communityRegisterManage", communityDTO);
	}

	@Override
	public CommunityDTO communityShowMangage(int no) {
		return sqlsession.selectOne("manageMapper.communityModifyShowManage", no);
	}

	@Override
	public int communityModifyManage(CommunityDTO communityDTO) {
		return sqlsession.update("manageMapper.communityModifyManage",communityDTO);
	}

	@Override
	public int communityDeleteManage(String no) {
		return sqlsession.delete("manageMapper.communityDeleteManage",no);
	}

	@Override
	public List<QnaDTO> qnaManage() {
		return sqlsession.selectList("manageMapper.qnaManage");
	}

	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		return sqlsession.insert("manageMapper.qnaRegisterManage",communitycommentDTO);
	}

	/*@Override
	public QnaDTO qnaInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public int qnaModifyManage(QnaDTO qnaDTO) {
		return sqlsession.update("manageMapper.qnaModifyManage",qnaDTO);
	}

	@Override
	public int qnaDeleteManage(String no) {
		return sqlsession.update("manageMapper.qnaDeleteManage",no);
	}

	@Override
	public List<DonationOrgDTO> donationOrgManage() {
		return sqlsession.selectList("manageMapper.donationOrgManage");
	}

	@Override
	public int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO) {
		return sqlsession.insert("manageMapper.donationOrgRegisterManage",donationOrgDTO);
	}

	@Override
	public DonationOrgDTO donationOrgShowMangage() {
		return sqlsession.selectOne("manageMapper.donationOrgShowManage");
	}

	@Override
	public int donationOrgModifyManage(DonationOrgDTO donationOrgDTO) {
		return sqlsession.update("manageMapper.donationOrgModifyManage",donationOrgDTO);
	}

	@Override
	public int donationOrgDeleteManage(int no) {
		return sqlsession.delete("manageMapper.donationOrgDeleteManage",no);
	}

	@Override
	public float getProducerEval(int producerNo) {
		return sqlsession.selectOne("manageMapper.getProducerEval", producerNo);
	}

	@Override
	public ProductDTO productInfoMangage(int no) {
		return sqlsession.selectOne("UserProductMapper.getProductByProductNo", no);
	}

	@Override
	public List<Integer> getMonthSales() {
		return sqlsession.selectList("manageMapper.getMonthSales");
	}

	@Override
	public List<HashMap<String, String>> getSalesProduct() {
		return sqlsession.selectList("manageMapper.getSalesProduct");
	}

	@Override
	public int getRecentPackageNo() {
		return sqlsession.selectOne("manageMapper.getRecentPackageNo");
	}

	@Override
	public int packageProductRegisterManage(int packageNo, int productNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("packageNo", packageNo);
		map.put("productNo", productNo);
		return sqlsession.insert("manageMapper.packageProductRegisterManage", map);
	}

	

	

	
}
