package spring.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;

@Service
public class UserProductServiceImpl implements UserProductService{
	
	

	@Override
	public List<ProductDTO> shopMenuLoading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> showMenuListLoading(String categoryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showProductDetail(String productNo) {
		/**
		 * Map에 ProductDTO, ProductCommentDTO, CertificationDTO, ProducerDTO를 담아서 
		 * 컨트롤러로 반환
		 * */
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ProductDTO 가져오기
		
		// ProductCommentDTO 가져오기
		
		// CertificationDTO 가져오기
		
		// ProducerDTO 가져오기
		
		return map;
	}

	@Override
	public ProducerDTO showProducerInfo(String producerNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCart(String productNo, int num, String email) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int addCartDirect(String productNo, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> packageMenuListLoading() {
		// TODO Auto-generated method stub
		return null;
	}

}
