package spring.web.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
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
	List<Integer> getRecentPurchase(String email);
	
	/**
	 * showMenuListLoading(int categoryNo)
	 * ī�װ��� �ش��ϴ� ��ǰ ����Ʈ ��������
	 * */
	List<ProductDTO> getProductByCategory(int categoryNo);
	
	/**
	 * showProductDetail(int productNo) / order(int productNo, int num)
	 * productNo�� ProductDTO ��������
	 * */
	ProductDTO getProductByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo) / order(int productNo, int num)
	 * productNo�� ProducerDTO ��������
	 * */
	ProducerDTO getProducerByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo�� ProductCommentDTO ����Ʈ ��������
	 * */
	List<ProductCommentDTO> getProductCommentByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo�� CertificationDTO ��������
	 * */
	List<CertificationDTO> getCertificationByProductNo(int productNo);
	
	/**
	 * showProducerInfo(int producerNo)
	 * producerNo�� ProducerDTO ��������
	 * */
	ProducerDTO getProducerByProducerNo(int producerNo);
	
	/**
	 * ��ǰ �󼼺��⿡�� �ش� ��ǰ�� ī�װ� ��������
	 * */
	String getCategoryName(int subcategoryNo);
	
	/**
	 * addCart(int productNo, int num, HttpSession session)
	 * ��ǰ�󼼺��⿡�� ��ٱ��Ͽ� �߰�
	 * */
	int registerProductToCart(CartDTO cartDTO);
	
	/**
	 * addCartDirect(int productNo, HttpSession session)
	 * ��ǰ����Ʈ���� ��ٱ��Ͽ� �߰�
	 * */
	int registerProductToCartDirect(CartDTO cartDTO);
	
	/**
	 * packageMenuListLoading()
	 * ��Ű�� ��ǰ ����Ʈ ��������
	 * */
	List<ProductDTO> getPackageList();
	
	/**
	 * ��Ű�� ��ǰ �󼼺���
	 * */
	ProductDTO getPackageDetail();
	
	/**
	 * ��Ű�� ��ǰ ���� ���ԵǾ� �ִ� ��ǰ�� ����ֱ�
	 * */
	List<ProductDTO> getPackageInnerProductList();
	
	/**
	 * search(String keyword)
	 * �˻��ϱ�
	 * */
	List<ProductDTO> search(String keyword);
	
	/**
	 * �� ���ϸ��� ��������
	 * */
	int getMileage(String email);
}
