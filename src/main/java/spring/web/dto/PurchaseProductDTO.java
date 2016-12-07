package spring.web.dto;

public class PurchaseProductDTO {
	
	private int purchaseNo;
	private int productNo;
	private int productNum;
	
	private ProductDTO productDto;
	private PurchaseDTO purchaseDto;
	
	public PurchaseProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseProductDTO(int purchaseNo, int productNo, int productNum) {
		super();
		this.purchaseNo = purchaseNo;
		this.productNo = productNo;
		this.productNum = productNum;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public ProductDTO getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}

	public PurchaseDTO getPurchaseDto() {
		return purchaseDto;
	}

	public void setPurchaseDto(PurchaseDTO purchaseDto) {
		this.purchaseDto = purchaseDto;
	}
	
	

}
