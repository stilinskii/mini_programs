package login_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JoinPage implements ActionListener {

	JFrame frame = new JFrame();

	JLabel joinLabel = new JLabel();
	JButton joinButton = new JButton("Join");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JTextField pwField = new JTextField();
	JLabel userIDLabel = new JLabel("ID:");
	JLabel userPasswordLabel = new JLabel("password:");

	public JoinPage() {

		joinLabel.setBounds(130, 40, 250, 35);
		joinLabel.setFont(new Font(null, Font.PLAIN, 25));
		joinLabel.setText("Join us now");

		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);

		userIDField.setBounds(125, 100, 200, 25);
		pwField.setBounds(125, 150, 200, 25);

		joinButton.setBounds(125, 200, 100, 25);
		joinButton.setFocusable(false);
		joinButton.addActionListener(this);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		frame.add(joinLabel);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(pwField);
		frame.add(joinButton);
		frame.add(resetButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLocation(550,200);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDAO dao = MemberDAO.getInstance();

		if (e.getSource() == resetButton) {
			userIDField.setText("");
			pwField.setText("");
		}

		if (e.getSource() == joinButton) {
			String userID = userIDField.getText();
			String pw = pwField.getText();
			dao.joinMember(userID, pw);
			frame.dispose();
			new LoginPage();
		}

	}

}
