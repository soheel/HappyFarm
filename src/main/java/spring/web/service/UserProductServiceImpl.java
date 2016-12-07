package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserProductDAO;
import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;

@Service
public class UserProductServiceImpl implements UserProductService{
	
	@Autowired
	UserProductDAO userProductDAO;

	@Override
	public List<ProductDTO> shopMenuLoading() {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		// getBestProduct()를 통해 List<Integer> 받아오기
		List<Integer> listBestProduct = userProductDAO.getBestProduct();
		// 계절상품 담기
		// getRecentPurchase()를 통해 List<Integer> 받아오기
		List<Integer> listRecentPurchase = userProductDAO.getRecentPurchase();
		
		// getProductByProductNo(int productNo)를 통해 리스트에 있는 productNo들을 전달해줘서
		// ProductDTO들을 저장하는 리스트를 만들어 컨트롤러로 반환하기
		for(Integer i : listBestProduct) {
			list.add(userProductDAO.getProductByProductNo(i));
		}
		for(Integer i : listRecentPurchase) {
			list.add(userProductDAO.getProductByProductNo(i));
		}
		for(Integer i : listRecentPurchase) {
			list.add(userProductDAO.getProductByProductNo(i));
		}
		return list;
	}

	@Override
	public List<ProductDTO> showMenuListLoading(int categoryNo) {
		
		List<ProductDTO> list = userProductDAO.getProductByCategory(categoryNo);
		return list;
	}

	@Override
	public Map<String, Object> showProductDetail(int productNo) {
		/**
		 * Map에 ProductDTO, ProductCommentDTO, CertificationDTO, ProducerDTO를 담아서 
		 * 컨트롤러로 반환
		 * */
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ProductDTO 가져오기
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// ProductCommentDTO 가져오기
		ProductCommentDTO ProductCommentDTO = userProductDAO.getProductCommentByProductNo(productNo);
		map.put("ProductCommentDTO", ProductCommentDTO);
		// CertificationDTO 가져오기
		CertificationDTO CertificationDTO = userProductDAO.getCertificationByProductNo(productNo);
		map.put("CertificationDTO", CertificationDTO);
		// ProducerDTO 가져오기
		ProducerDTO ProducerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("ProducerDTO", ProducerDTO);
		
		return map;
	}

	@Override
	public ProducerDTO showProducerInfo(int producerNo) {
		ProducerDTO producerDTO = userProductDAO.getProducerByProducerNo(producerNo);
		return producerDTO;
	}

	@Override
	public int addCart(CartDTO cart) {
		int result = userProductDAO.registerProductToCart(cart);
		return result;
	}
	
	@Override
	public int addCartDirect(CartDTO cart) {
		int result = userProductDAO.registerProductToCartDirect(cart);
		return result;
	}
	
	@Override
	public Map<String, Object> order(int productNo, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// ProductDTO 가져오기
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// ProducerDTO 가져오기
		ProducerDTO ProducerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("ProducerDTO", ProducerDTO);
		
		return map;
	}

	@Override
	public List<PackageDTO> packageMenuListLoading() {
		List<PackageDTO> list = null;
		list = userProductDAO.getPackageList();
		return list;
	}

	@Override
	public Map<String, Object> showPackageDetail() {
		// TODO Auto-generated method stub
		return null;
	}
}
