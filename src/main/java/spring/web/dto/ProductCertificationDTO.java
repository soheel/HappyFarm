package spring.web.dto;

import java.util.List;

public class ProductCertificationDTO {
	
	private int no; //상품-인증마크 번호
	private CertificationDTO certificationDto; //인증마크 번호
	private List<ProductDTO> productDto; // 상품번호
	
	public ProductCertificationDTO() {}

	public ProductCertificationDTO(int no, CertificationDTO certificationDto, List<ProductDTO> productDto) {
		super();
		this.no = no;
		this.certificationDto = certificationDto;
		this.productDto = productDto;
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
	
	
	
	

}
