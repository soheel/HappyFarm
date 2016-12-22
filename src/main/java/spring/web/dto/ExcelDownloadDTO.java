package spring.web.dto;

public class ExcelDownloadDTO {
	
	private int no;
	private String email;
	private int price;
	private int state;
	private String method;
	private String date;
	private String name;
	private String addr;
	private String phone;
	
	public ExcelDownloadDTO() {
		
	}

	public ExcelDownloadDTO(int no, String email, int price, int state, String method, String date, String name,
			String addr, String phone) {
		super();
		this.no = no;
		this.email = email;
		this.price = price;
		this.state = state;
		this.method = method;
		this.date = date;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
