package spring.web.dto;

public class QnaDTO {
	private int no;
	private String name;
	private String desc;
	private String pwd;
	private String registerdate;
	private String email;
	private int qnaParent;
	
	private MemberDTO memberDto;
	
	public QnaDTO() {
		super();
	}

	public QnaDTO(int no, String name, String desc, String pwd, String registerdate, String email, int qnaParent) {
		super();
		this.no = no;
		this.name = name;
		this.desc = desc;
		this.pwd = pwd;
		this.registerdate = registerdate;
		this.email = email;
		this.qnaParent = qnaParent;
	}
	
	public MemberDTO getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDTO memberDto) {
		this.memberDto = memberDto;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQnaParent() {
		return qnaParent;
	}

	public void setQnaParent(int qnaParent) {
		this.qnaParent = qnaParent;
	}
	
}
