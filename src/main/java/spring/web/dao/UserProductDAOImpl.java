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
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;

@Repository
public class UserProductDAOImpl implements UserProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Integer> getBestProduct() {
		return sqlSession.selectList("UserProductMapper.getBestProduct", null, new RowBounds(0, 3));
	}

	@Override
	public List<Integer> getRecentPurchase() {
		return sqlSession.selectList("UserProductMapper.getRecentPurchase", null, new RowBounds(0, 3));
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
	public ProductCommentDTO getProductCommentByProductNo(int productNo) {
		return sqlSession.selectOne("UserProductMapper.getProductCommentByProductNo", productNo);
	}

	@Override
	public CertificationDTO getCertificationByProductNo(int productNo) {
		return sqlSession.selectOne("UserProductMapper.getCertificationByProductNo", productNo);
	}

	@Override
	public ProducerDTO getProducerByProducerNo(int producerNo) {
		return sqlSession.selectOne("UserProductMapper.getProducerByProducerNo", producerNo);
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

}
