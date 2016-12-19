package spring.web.dto;

import java.util.List;

public class ProductCertificationDTO {
	
	private int no; //��ǰ-������ũ ��ȣ
	
	
	private CertificationDTO certificationDTO; //������ũ ��ȣ
	private ProductDTO productDTO;
	/*private List<ProductDTO> productDto; // ��ǰ��ȣ
*/	
	private int certificationNo;
	

	
	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	private int productNo;
	
	public ProductCertificationDTO() {}

	public ProductCertificationDTO(int no, int certificationNo, int productNo) {
		super();
		this.no = no;
		this.certificationNo = certificationNo;
		this.productNo = productNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	
	
	public CertificationDTO getCertificationDTO() {
		return certificationDTO;
	}

	public void setCertificationDTO(CertificationDTO certificationDTO) {
		this.certificationDTO = certificationDTO;
	}

	public int getCertificationNo() {
		return certificationNo;
	}

	public void setCertificationNo(int certificationNo) {
		this.certificationNo = certificationNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	
}
