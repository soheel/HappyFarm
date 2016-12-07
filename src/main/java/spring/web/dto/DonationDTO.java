package spring.web.dto;

public class DonationDTO {
	
	private DonationOrgDTO donationOrgDto; //기부단체 번호
	
	private int donationOrgNo;
	private long price;
	private String date;
	
	public DonationDTO() {}

	public DonationDTO(int donationOrgNo, long price, String date) {
		super();
		this.donationOrgNo = donationOrgNo;
		this.price = price;
		this.date = date;
	}
	
	

	
}
