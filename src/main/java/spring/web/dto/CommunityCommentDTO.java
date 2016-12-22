package spring.web.dto;

public class CommunityCommentDTO {
	private int no; // 모임 댓글 번호
	private String content; // 모임 댓글 내용
	private String registerdate; // 모임 댓글 날짜
	private int communityNo;
	private String email;
	private String parentNo;

	private CommunityDTO communityDto; // 모임 글 번호
	private MemberDTO memberDto; // 회원 이메일

	public CommunityDTO getCommunityDto() {
		return communityDto;
	}

	public void setCommunityDto(CommunityDTO communityDto) {
		this.communityDto = communityDto;
	}

	public MemberDTO getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDTO memberDto) {
		this.memberDto = memberDto;
	}

	public CommunityCommentDTO() {
	}

	public CommunityCommentDTO(int no, String content) {
		super();
		this.no = no;
		this.content = content;
	}
	
	public CommunityCommentDTO(String content, int communityNo, String email) {
		super();
		this.content = content;
		this.communityNo = communityNo;
		this.email = email;
	}

	public CommunityCommentDTO(int no, String content, int communityNo, String email) {
		super();
		this.no = no;
		this.content = content;
		this.communityNo = communityNo;
		this.email = email;
	}

	public CommunityCommentDTO(int no, String content, String registerdate, int communityNo, String email,
			String parentNo, CommunityDTO communityDto, MemberDTO memberDto) {
		super();
		this.no = no;
		this.content = content;
		this.registerdate = registerdate;
		this.communityNo = communityNo;
		this.email = email;
		this.parentNo = parentNo;
		this.communityDto = communityDto;
		this.memberDto = memberDto;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

}
