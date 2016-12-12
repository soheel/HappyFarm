package spring.web.dto;

import java.util.List;

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
