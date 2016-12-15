package spring.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
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
		List<ProductDTO> list = sqlsession.selectList("manageMapper.selectAll");
		System.out.println(list.size()+"ddd");
		/*for(ProductDTO p :list){
			System.out.println("product_no : "+p.getNo());//99
			PackageDTO pd = p.getPackageDTO();
			System.out.println("package_pk : " + pd.getNo()); //1
			List<ProductDTO> li = pd.getProductlist();
			System.out.println("--------------------");
			for(ProductDTO dto :li){
				System.out.println(dto.getNo());
			}
			System.out.println("--------------------");
		}*/
		
		return list;
	}

	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return sqlsession.insert("manageMapper.productRegisterManage",productDTO);
		
	}

	/*@Override
	public ProductDTO productInfoMangage(String no) {
		return sqlsession.selectOne("userEtcMapper.productInfoMangage", no);
	}
*/
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
		return sqlsession.selectList("manageMapper.packageManage");
	}

	@Override
	public List<ProductDTO> packageShowManage(String name) {
		return sqlsession.selectList("manageMapper.packageShowManage",name);
		
	}

	@Override
	public int packageRegisterManage(Map<String, Object> packageRegister) {
		
		int result1=sqlsession.insert("manageMapper.packageRegisterManage",packageRegister);
		int result2=sqlsession.insert("manageMapper.packageRegisterPackage",packageRegister);
		int result3=sqlsession.insert("manageMapper.packageRegisterPackageProduct",packageRegister);
		
		return result3;
	}
	
	
	@Override
	public ProductDTO packageSearchProduct(String name) {
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
	public List<ProducerDTO> selectAllProducer() {
		return sqlsession.selectList("manageMapper.selectAllProducer");
	}

	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		return sqlsession.insert("manageMapper.producerRegisterManage",producerDTO);
	}

	@Override
	public ProducerDTO producerInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
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
		return sqlsession.insert("manageMapper.communityRegisterManage");
	}

	@Override
	public CommunityDTO communityInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
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
	public List<DonationDTO> donationOrgManage() {
		return sqlsession.selectList("manageMapper.donationOrgManage");
	}

	@Override
	public int donationOrgRegisterManage(DonationDTO donationDTO) {
		return sqlsession.insert("manageMapper.donationOrgRegisterManage",donationDTO);
	}

	@Override
	public DonationDTO donationOrgInfoMangage(String donationOrgno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int donationOrgModifyManage(DonationDTO donationDTO) {
		return sqlsession.update("manageMapper.donationOrgModifyManage",donationDTO);
	}

	@Override
	public int donationOrgDeleteManage(int no) {
		return sqlsession.delete("manageMapper.donationOrgDeleteManage",no);
	}

	


	

}
