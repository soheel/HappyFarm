package spring.web.dto;

public class MemberDTO {
	private int no;
	private String email;
	private String pwd;
	private String name;
	private String phone;
	private String registerDate;
	private int mileage;
	private String recommand; // 자기가 추천한 사람의 아이디
	private int donationOrgNo; // 기부될 단체 번호
	
	public MemberDTO() {

	}

	public MemberDTO(int no, String email, String pwd, String name, String phone, String registerDate, int mileage,
			String recommand, int donationOrgNo) {
		super();
		this.no = no;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.registerDate = registerDate;
		this.mileage = mileage;
		this.recommand = recommand;
		this.donationOrgNo = donationOrgNo;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
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

	public int getDonationOrgNo() {
		return donationOrgNo;
	}

	public void setDonationOrgNo(int donationOrgNo) {
		this.donationOrgNo = donationOrgNo;
	}
	
}
