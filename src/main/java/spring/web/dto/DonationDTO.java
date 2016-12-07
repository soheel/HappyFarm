package spring.web.dto;

public class DonationDTO {
	private DonationOrgDTO donationOrgDto; //기부단체 번호
	private long price;
	private String date;
	
	public DonationDTO() {
		// TODO Auto-generated constructor stub
	}

	public DonationDTO(DonationOrgDTO donationOrgDto, long price, String date) {
		super();
		this.donationOrgDto = donationOrgDto;
		this.price = price;
		this.date = date;
	}
	
	public DonationOrgDTO getDonationOrgDto() {
		return donationOrgDto;
	}

	public void setDonationOrgDto(DonationOrgDTO donationOrgDto) {
		this.donationOrgDto = donationOrgDto;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
