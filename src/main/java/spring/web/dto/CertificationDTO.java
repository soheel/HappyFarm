package spring.web.dto;

public class CertificationDTO {
	private int certificationNo; //������ũ ��ȣ
	private String image; //������ũ �̹���
	private String name; //������ũ �̸�
	private String desc; //������ũ ����
	
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
