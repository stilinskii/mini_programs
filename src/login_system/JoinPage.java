package login_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinPage implements ActionListener{
	MemberDAO dao =  MemberDAO.getInstance();

	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		dao.joinMember(new MemberDTO("dfd","fd"));
		
		
	}
	
}
