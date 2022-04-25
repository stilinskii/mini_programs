package login_system;

public class MemberDTO {
	private String id;
	private String password;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
// 들어있는 데이타	
//	hy	1234
//	mark	5678
//	kitty	cat
	
	@Override
	public String toString() {
		
		return String.format("%s %s", id,password);
	}
	
	
	//get set

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
