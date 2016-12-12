package spring.web.dto;

public class InfomationDTO {
	private int no;
	private String name;
	private String desc;
	private String date;
	private String profile;
	
	public InfomationDTO() {}

	public InfomationDTO(int no, String name, String desc, String date, String profile) {
		super();
		this.no = no;
		this.name = name;
		this.desc = desc;
		this.date = date;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
