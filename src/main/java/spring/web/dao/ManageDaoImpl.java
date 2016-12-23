package spring.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.web.dto.CertificationDTO;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
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
	public List<CertificationDTO> selectCertification() {
		return sqlsession.selectList("manageMapper.selectCertification");
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
	public int productDeleteManage(int no) {
		return sqlsession.delete("manageMapper.productDeleteManage",no);
	}

	@Override
	public List<PackageDTO> packageManage() {
		List<PackageDTO> list = sqlsession.selectList("manageMapper.packageManage");
		return list;
	}

	@Override
	public List<String> packageShowManage(int packageNo) {
		return sqlsession.selectList("manageMapper.packageShowManage",packageNo);
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
	public int qnaRegisterManage(QnaDTO qnaDTO) {
		return sqlsession.insert("manageMapper.qnaRegisterManage",qnaDTO);
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
	public int qnaDeleteManage(int no) {
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

	@Override
	public List<Integer> getPackageProductNo(int no) {
		return sqlsession.selectList("manageMapper.getPackageProductNo", no);
	}

	@Override
	public PackageDTO getPackageByPackageNo(int no) {
		return sqlsession.selectOne("manageMapper.getPackageByPackageNo", no);
	}

	@Override
	public int packageModifyManage(ProductDTO product) {
		return sqlsession.update("manageMapper.packageModifyManage", product);
	}

	@Override
	public int packageModifyDeleteManage(int packageNo) {
		return sqlsession.delete("manageMapper.packageModifyDeleteManage", packageNo);
	}

	@Override
	public int packageModifyInsertManage(int packageNo, int productNo) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("packageNo", packageNo);
		map.put("productNo", productNo);
		return sqlsession.insert("manageMapper.packageModifyInsertManage", map);
	}

	@Override
	public List<PurchaseDTO> getPurchaseOrderState1() {
		return sqlsession.selectList("manageMapper.getPurchaseOrderState1");
	}

	@Override
	public List<PurchaseDTO> getPurchaseOrderState2() {
		return sqlsession.selectList("manageMapper.getPurchaseOrderState2");
	}

	@Override
	public List<PurchaseDTO> getPurchaseOrderState345() {
		return sqlsession.selectList("manageMapper.getPurchaseOrderState345");
	}

	@Override
	public List<PurchaseDTO> getPurchaseOrderState678() {
		return sqlsession.selectList("manageMapper.getPurchaseOrderState678");
	}

	@Override
	public int depositCompleteModify(int purchaseNo) {
		return sqlsession.update("manageMapper.depositCompleteModify", purchaseNo);
	}

	@Override
	public int etcCompleteModify(int purchaseNo) {
		return sqlsession.update("manageMapper.etcCompleteModify", purchaseNo);
	}

	@Override
	public int qnaModifyAnswerStateManage(int qnaNo) {
		return sqlsession.update("manageMapper.qnaModifyAnswerStateManage", qnaNo);
	}
	
}
