package login_system;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage implements ActionListener{

	
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel();
	JButton logoutButton = new JButton("Logout");
	
	//img
	ImageIcon icon = new ImageIcon(WelcomePage.class.getResource("/login_system/ggo.png"));
	JLabel img = new JLabel();
	
	
	
	public WelcomePage(String userID) {
		
		//img
		img.setIcon(icon);
		img.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(img);
        img.setBounds(30, 50, 350, 280);
		
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+userID);
		logoutButton.setBounds(300, 350, 100, 25);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		
		
		frame.add(logoutButton);
		frame.add(welcomeLabel);
		frame.add(img);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(550,200);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new LoginPage();
	}
}
