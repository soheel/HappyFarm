package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserProductDAO;
import spring.web.dto.ProducerDTO;
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
		
		List<ProductDTO> list = userProductDAO.getProductByCategory(categoryNo);
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
		
		// ProductCommentDTO ��������
		
		// CertificationDTO ��������
		
		// ProducerDTO ��������
		
		return map;
	}

	@Override
	public ProducerDTO showProducerInfo(int producerNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCart(int productNo, int num, String email) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int addCartDirect(int productNo, String email) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Map<String, Object> order(int productNo, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// ProductDTO ��������
		
		// ProducerDTO ��������

		return null;
	}

	@Override
	public List<ProductDTO> packageMenuListLoading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showPackageDetail() {
		// TODO Auto-generated method stub
		return null;
	}
}
