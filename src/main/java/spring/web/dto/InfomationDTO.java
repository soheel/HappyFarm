package spring.web.dto;

public class InfomationDTO {
	private String name;
	private String desc;
	
	public InfomationDTO() {
		// TODO Auto-generated constructor stub
	}

	public InfomationDTO(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
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
