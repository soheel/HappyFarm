package spring.web.dao;

import java.util.List;

import spring.web.dto.CertificationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;

public interface UserProductDAO {
	
	/**
	 * shopMenuLoading()
	 * �α��ǰ 3�� ��������
	 * */
	List<Integer> getBestProduct();
	
	/**
	 * showMenuLoading()
	 * �ֱٱ��Ż�ǰ 3�� ��������
	 * */
	List<Integer> getRecentPurchase();
	
	/**
	 * showMenuListLoading(int categoryNo)
	 * ī�װ��� �ش��ϴ� ��ǰ ����Ʈ ��������
	 * */
	List<ProductDTO> getProductByCategory(int categoryNo);
	
	/**
	 * showProductDetail(int productNo)
	 * productNo�� ProductDTO ��������
	 * */
	ProductDTO getProductByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo�� ProducerDTO ��������
	 * */
	ProducerDTO getProducerByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo�� ProductCommentDTO ��������
	 * */
	ProductCommentDTO getProductCommentByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo�� CertificationDTO ��������
	 * */
	CertificationDTO getCertificationByProductNo(int productNo);
}
