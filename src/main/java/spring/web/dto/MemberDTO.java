package spring.web.dto;

import java.util.List;

import javax.lang.model.type.PrimitiveType;

public class MemberDTO {
	private String email;
	private String pwd;
	private String name;
	private String phone;
	private String registerDate;
	private int mileage;
	private String recommand; // 자기가 추천한 사람의 아이디
	private int donationOrgNo;
	
	private DonationOrgDTO donationOrgDto;
	private List<PurchaseDTO> purchaseDto;
	private ProductDTO productDto;
	private List<PurchaseProductDTO> purchaseProductDto;
	private ProducerDTO producerDto;
	
	public ProducerDTO getProducerDto() {
		return producerDto;
	}
	public void setProducerDto(ProducerDTO producerDto) {
		this.producerDto = producerDto;
	}
	
	
	
	public List<PurchaseProductDTO> getPurchaseProductDto() {
		return purchaseProductDto;
	}
	public void setPurchaseProductDto(List<PurchaseProductDTO> purchaseProductDto) {
		this.purchaseProductDto = purchaseProductDto;
	}
	public ProductDTO getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}
	
	
	
	public List<PurchaseDTO> getPurchaseDto() {
		return purchaseDto;
	}
	public void setPurchaseDto(List<PurchaseDTO> purchaseDto) {
		this.purchaseDto = purchaseDto;
	}
	public MemberDTO() {}

	

	public MemberDTO(String email, String pwd, String name, String phone, String registerDate, int mileage,
			String recommand, int donationOrgNo) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.registerDate = registerDate;
		this.mileage = mileage;
		this.recommand = recommand;
		this.donationOrgNo = donationOrgNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getRecommand() {
		return recommand;
	}

	public void setRecommand(String recommand) {
		this.recommand = recommand;
	}

	public DonationOrgDTO getDonationOrgDto() {
		return donationOrgDto;
	}

	public void setDonationOrgDto(DonationOrgDTO donationOrgDto) {
		this.donationOrgDto = donationOrgDto;
	}

	public int getDonationOrgNo() {
		return donationOrgNo;
	}

	public void setDonationOrgNo(int donationOrgNo) {
		this.donationOrgNo = donationOrgNo;
	}

	
	

}
