package spring.web.dto;

public class DonationDTO {
	
	private DonationOrgDTO donationOrgDto; //��δ�ü ��ȣ
	
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
