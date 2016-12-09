package spring.web.dto;

public class DonationOrgDTO {
	
	private int no;
	private String name;
	private String phone;
	private String addr;
	private String desc;
	private String profile;
	private DonationDTO donationDto;
	
	public DonationOrgDTO() {}
	
	public DonationOrgDTO(int no, String name, String phone, String addr, String desc, String profile) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.desc = desc;
		this.profile = profile;
	}
	
	
	public DonationDTO getDonationDto() {
		return donationDto;
	}

	public void setDonationDto(DonationDTO donationDto) {
		this.donationDto = donationDto;
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
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
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	

}
