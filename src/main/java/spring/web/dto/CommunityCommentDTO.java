package spring.web.dto;

public class CommunityCommentDTO {
	private int no;	//모임 댓글 번호
	private String content; //모임 댓글 내용
	private String registerdate; // 모임 댓글 날짜
	private String communityNo;
	private String email;
	
	private CommunityDTO communityDto; //모임 글 번호
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

	public CommunityCommentDTO() {}

	public CommunityCommentDTO(int no, String content, String registerdate, String communityNo, String email) {
		super();
		this.no = no;
		this.content = content;
		this.registerdate = registerdate;
		this.communityNo = communityNo;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(String communityNo) {
		this.communityNo = communityNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
