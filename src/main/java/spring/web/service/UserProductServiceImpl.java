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
		
		// getBestProduct()�� ���� List<Integer> �޾ƿ���
		List<Integer> listBestProduct = userProductDAO.getBestProduct();
		// ������ǰ ���
		// getRecentPurchase()�� ���� List<Integer> �޾ƿ���
		List<Integer> listRecentPurchase = userProductDAO.getRecentPurchase();
		
		// getProductByProductNo(int productNo)�� ���� ����Ʈ�� �ִ� productNo���� �������༭
		// ProductDTO���� �����ϴ� ����Ʈ�� ����� ��Ʈ�ѷ��� ��ȯ�ϱ�
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
		System.out.println("service�� showMenuListLoading�޼ҵ� ����");
		List<ProductDTO> list = userProductDAO.getProductByCategory(categoryNo);
		System.out.println("service�� showMenuListLoading�޼ҵ� ����");
		System.out.println(list.size());
		return list;
	}

	@Override
	public Map<String, Object> showProductDetail(int productNo) {
		/**
		 * Map�� ProductDTO, ProductCommentDTO, CertificationDTO, ProducerDTO�� ��Ƽ� 
		 * ��Ʈ�ѷ��� ��ȯ
		 * */
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ProductDTO ��������
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("product", productDTO);
		// ProductCommentDTO ��������
		List<ProductCommentDTO> productCommentList = userProductDAO.getProductCommentByProductNo(productNo);
		map.put("productComment", productCommentList);
		// CertificationDTO ��������
		List<CertificationDTO> certificationList = userProductDAO.getCertificationByProductNo(productNo);
		map.put("certification", certificationList);
		// ProducerDTO ��������
		ProducerDTO producerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("producer", producerDTO);
		
		// productDTO�� categoryno�� ���� ��ǰ �󼼺��⿡�� �ѷ��� ī�װ� ��������
		int subcategoryNo = productDTO.getSubCategoryNo();
		String categoryName = userProductDAO.getCategoryName(subcategoryNo);
		map.put("categoryName", categoryName);
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
		System.out.println("service int�� : " + result);
		return result;
	}
	
	@Override
	public Map<String, Object> order(int productNo, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// ProductDTO ��������
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// ProducerDTO ��������
		ProducerDTO ProducerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("ProducerDTO", ProducerDTO);
		
		return map;
	}

	@Override
	public List<ProductDTO> packageMenuListLoading() {
		List<ProductDTO> list = null;
		list = userProductDAO.getPackageList();
		return list;
	}

	@Override
	public Map<String, Object> showPackageDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> search(String keyword) {
		List<ProductDTO> list = null;
		list = userProductDAO.search(keyword);
		return list;
	}
}
