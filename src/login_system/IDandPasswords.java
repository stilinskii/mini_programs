package login_system;
import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords() {
		
		logininfo.put("lhy","potato");
		logininfo.put("stilinski","PASSWORD");
		logininfo.put("BroCode","abc123");
	}
	
	
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
	
	
}
