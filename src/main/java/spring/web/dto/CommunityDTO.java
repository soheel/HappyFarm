package spring.web.dto;

public class CommunityDTO {
	private String name;
	private String profile;
	private String desc;
	private String registerDate;
	private String state;
	
	public CommunityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommunityDTO(String name, String profile, String desc, String registerDate, String state) {
		super();
		this.name = name;
		this.profile = profile;
		this.desc = desc;
		this.registerDate = registerDate;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
