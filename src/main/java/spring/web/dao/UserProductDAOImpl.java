package spring.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;

public class UserProductDAOImpl implements UserProductDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public List<Integer> getBestProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getRecentPurchase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> getProductByCategory(int categoryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getProductByProductNo(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProducerDTO getProducerByProductNo(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCommentDTO getProductCommentByProductNo(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CertificationDTO getCertificationByProductNo(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProducerDTO getProducerByProducerNo(int producerNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerProductToCart(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerProductToCartDirect(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PackageDTO> getPackageList() {
		// TODO Auto-generated method stub
		return null;
	}

}
