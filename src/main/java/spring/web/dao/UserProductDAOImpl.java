package spring.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseOrderDTO;
import spring.web.dto.PurchaseProductDTO;

@Repository
public class UserProductDAOImpl implements UserProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Integer> getBestProduct() {
		return sqlSession.selectList("UserProductMapper.getBestProduct", null, new RowBounds(0, 3));
	}

	@Override
	public List<Integer> getRecentPurchase(String email) {
		return sqlSession.selectList("UserProductMapper.getRecentPurchase", email, new RowBounds(0, 3));
	}

	@Override
	public List<ProductDTO> getProductByCategory(int categoryNo) {
		System.out.println("dao의 getProductByCategory메소드 들어옴");
		return sqlSession.selectList("UserProductMapper.getProductByCategory", categoryNo);
	}

	@Override
	public ProductDTO getProductByProductNo(int productNo) {
		return sqlSession.selectOne("UserProductMapper.getProductByProductNo", productNo);
	}

	@Override
	public ProducerDTO getProducerByProductNo(int productNo) {
		return sqlSession.selectOne("UserProductMapper.getProducerByProductNo", productNo);
	}

	@Override
	public List<ProductCommentDTO> getProductCommentByProductNo(int productNo) {
		return sqlSession.selectList("UserProductMapper.getProductCommentByProductNo", productNo);
	}

	@Override
	public List<CertificationDTO> getCertificationByProductNo(int productNo) {
		return sqlSession.selectList("UserProductMapper.getCertificationByProductNo", productNo);
	}

	@Override
	public ProducerDTO getProducerByProducerNo(int producerNo) {
		return sqlSession.selectOne("UserProductMapper.getProducerByProducerNo", producerNo);
	}
	
	@Override
	public List<ProductCertificationDTO> showCertificationInfo(int no) {
		return sqlSession.selectList("UserProductMapper.getProductCertification", no);

	}

	@Override
	public int registerProductToCart(CartDTO cartDTO) {
		return sqlSession.insert("UserProductMapper.registerProductToCart", cartDTO);
	}

	@Override
	public int registerProductToCartDirect(CartDTO cartDTO) {
		return sqlSession.insert("UserProductMapper.registerProductToCartDirect", cartDTO);
	}

	@Override
	public List<ProductDTO> getPackageList() {
		return sqlSession.selectList("UserProductMapper.getPackageList");
	}

	@Override
	public List<ProductDTO> search(String keyword) {
		return sqlSession.selectList("UserProductMapper.search", keyword);
	}

	@Override
	public String getCategoryName(int subcategoryNo) {
		return sqlSession.selectOne("UserProductMapper.getCategoryName", subcategoryNo);
	}

	@Override
	public ProductDTO getPackageDetail() {
		return sqlSession.selectOne("UserProductMapper.getPackageDetail");
	}

	@Override
	public List<ProductDTO> getPackageInnerProductList() {
		return sqlSession.selectList("UserProductMapper.getPackageInnerProductList");
	}

	@Override
	public int getMileage(String email) {
		return sqlSession.selectOne("userInfoMapper.getMileage", email);
	}

	@Override
	public int registerPurchase(PurchaseDTO purchaseDTO) {
		return sqlSession.insert("UserProductMapper.registerPurchase", purchaseDTO);
	}

	@Override
	public int registerPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
		return sqlSession.insert("UserProductMapper.registerPurchaseOrder", purchaseOrderDTO);
	}

	@Override
	public int registerPurchaseProduct(PurchaseProductDTO purchaseProductDTO) {
		return sqlSession.insert("UserProductMapper.registerPurchaseProduct", purchaseProductDTO);
	}

	@Override
	public int getRecentPurchaseNo() {
		return sqlSession.selectOne("UserProductMapper.getRecentPurchaseNo");
	}

	@Override
	public int removeCartProduct(PurchaseDTO purchaseDTO) {
		return sqlSession.delete("UserProductMapper.removeCartProduct",purchaseDTO);
	}
	
	@Override
	public int setPurchaseStateNo(int no) {
		return sqlSession.update("UserProductMapper.setPurchaseStateNo", no);
	}

	

	

}
