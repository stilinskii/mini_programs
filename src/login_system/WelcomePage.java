package login_system;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage {
	
	
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("hi");
	
	public WelcomePage(String userID) {
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+userID);
		
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,4220);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
