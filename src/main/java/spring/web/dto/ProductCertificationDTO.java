package spring.web.dto;

import java.util.List;

public class ProductCertificationDTO {
	
	private int no; //��ǰ-������ũ ��ȣ
	private CertificationDTO certificationDto; //������ũ ��ȣ
	private List<ProductDTO> productDto; // ��ǰ��ȣ
	
	private int certificationNo;
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

	public CertificationDTO getCertificationDto() {
		return certificationDto;
	}

	public void setCertificationDto(CertificationDTO certificationDto) {
		this.certificationDto = certificationDto;
	}

	public List<ProductDTO> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDTO> productDto) {
		this.productDto = productDto;
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
