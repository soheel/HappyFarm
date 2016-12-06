package spring.web.dto;

public class ProducerDTO {
	private int no;
	private String name;
	private String addr;
	private String phone;
	private String registerDate;
	
	public ProducerDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProducerDTO(int no, String name, String addr, String phone, String registerDate) {
		super();
		this.no = no;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.registerDate = registerDate;
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

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	
}