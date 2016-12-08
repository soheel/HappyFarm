package spring.web.dto;

public class CertificationDTO {
	private int no; //인증마크 번호
	private String image; //인증마크 이미지
	private String name; //인증마크 이름
	private String desc; //인증마크 설명
	
	public CertificationDTO() {}

	public CertificationDTO(int no, String image, String name, String desc) {
		super();
		this.no = no;
		this.image = image;
		this.name = name;
		this.desc = desc;
	}

	public int getno() {
		return no;
	}

	public void setno(int no) {
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
