package spring.web.dto;

public class CommunityCommentDTO {
	private int no;	//모임 댓글 번호
	private String content; //모임 댓글 내용
	private String registerdate; // 모임 댓글 날짜
	private CommunityDTO communityDto; //모임 글 번호
	private MemberDTO memberDto; // 회원 이메일
	
	
	public CommunityCommentDTO() {
		super();
	}

	public CommunityCommentDTO(int no, String content, String registerdate, CommunityDTO communityDto,
			MemberDTO memberDto) {
		super();
		this.no = no;
		this.content = content;
		this.registerdate = registerdate;
		this.communityDto = communityDto;
		this.memberDto = memberDto;
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

	
	
}
