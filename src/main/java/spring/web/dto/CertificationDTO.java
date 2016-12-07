package spring.web.dto;

public class CertificationDTO {
	private int certificationNo; //인증마크 번호
	private String image; //인증마크 이미지
	private String name; //인증마크 이름
	private String desc; //인증마크 설명
	
	public CertificationDTO() {}

	public CertificationDTO(int certificationNo, String image, String name, String desc) {
		super();
		this.certificationNo = certificationNo;
		this.image = image;
		this.name = name;
		this.desc = desc;
	}

	public int getCertificationNo() {
		return certificationNo;
	}

	public void setCertificationNo(int certificationNo) {
		this.certificationNo = certificationNo;
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
