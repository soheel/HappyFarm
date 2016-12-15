package spring.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProducerDTO {
	private int no;
	private String name;
	private String addr;
	private String phone;
	private String registerDate;
	private String profile;
	
	private MultipartFile file;
	
	public ProducerDTO() {}

	public ProducerDTO(int no, String name, String addr, String phone, String registerDate, String profile) {
		super();
		this.no = no;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.registerDate = registerDate;
		this.profile = profile;
	
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
	
	
	
}