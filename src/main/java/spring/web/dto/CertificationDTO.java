package spring.web.dto;

public class CertificationDTO {
	private int no;
	private String image;
	private String name;
	private String desc;
	
	public CertificationDTO() {
		// TODO Auto-generated constructor stub
	}

	public CertificationDTO(int no, String image, String name, String desc) {
		super();
		this.no = no;
		this.image = image;
		this.name = name;
		this.desc = desc;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
