package spring.web.service;

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
	public ProducerDTO showProducerInfo(String producerNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showProductDetail(String productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCart(String productNo, int num, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
