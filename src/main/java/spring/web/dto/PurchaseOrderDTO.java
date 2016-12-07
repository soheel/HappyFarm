package spring.web.dto;

public class PurchaseOrderDTO {
	
	private PurchaseDTO purchaseDto;
	private String name;
	private String addr;
	private String detailAddr;
	private String postCode;
	private String email;
	private String phone;
	
	public PurchaseOrderDTO() {}
	
	public PurchaseOrderDTO(PurchaseDTO purchaseDto, String name, String addr, String detailAddr, String postCode,
			String email, String phone) {
		super();
		this.purchaseDto = purchaseDto;
		this.name = name;
		this.addr = addr;
		this.detailAddr = detailAddr;
		this.postCode = postCode;
		this.email = email;
		this.phone = phone;
	}

	public PurchaseDTO getPurchaseDto() {
		return purchaseDto;
	}

	public void setPurchaseDto(PurchaseDTO purchaseDto) {
		this.purchaseDto = purchaseDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
