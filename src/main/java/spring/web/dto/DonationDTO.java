package spring.web.dto;

public class DonationDTO {
	private String donationOrgNo;
	private long price;
	private String date;
	
	public DonationDTO() {
		// TODO Auto-generated constructor stub
	}

	public DonationDTO(String donationOrgNo, long price, String date) {
		super();
		this.donationOrgNo = donationOrgNo;
		this.price = price;
		this.date = date;
	}

	public String getDonationOrgName() {
		return donationOrgNo;
	}

	public void setDonationOrgName(String donationOrgNo) {
		this.donationOrgNo = donationOrgNo;
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
