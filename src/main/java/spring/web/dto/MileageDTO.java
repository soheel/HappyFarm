package spring.web.dto;

public class MileageDTO {
	private int mileageNo;
	private String mileageDate;
	private int mileagePrice;
	private String mileageState;
	private String email;
	
	
	public MileageDTO() {
		super();
	}
	public MileageDTO(int mileageNo, String mileageDate, int mileagePrice, String mileageState, String email) {
		super();
		this.mileageNo = mileageNo;
		this.mileageDate = mileageDate;
		this.mileagePrice = mileagePrice;
		this.mileageState = mileageState;
		this.email = email;
	}
	public int getMileageNo() {
		return mileageNo;
	}
	public void setMileageNo(int mileageNo) {
		this.mileageNo = mileageNo;
	}
	public String getMileageDate() {
		return mileageDate;
	}
	public void setMileageDate(String mileageDate) {
		this.mileageDate = mileageDate;
	}
	public int getMileagePrice() {
		return mileagePrice;
	}
	public void setMileagePrice(int mileagePrice) {
		this.mileagePrice = mileagePrice;
	}
	public String getMileageState() {
		return mileageState;
	}
	public void setMileageState(String mileageState) {
		this.mileageState = mileageState;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}