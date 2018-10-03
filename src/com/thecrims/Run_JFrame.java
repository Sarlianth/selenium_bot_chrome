package com.thecrims;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Run_JFrame extends JFrame {

	private JPanel contentPane;
	JLabel nicknameLabel;
	JLabel respectLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run_JFrame frame = new Run_JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Run_JFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNickname = new JLabel("Nickname: ");
		lblNickname.setBounds(10, 11, 67, 14);
		contentPane.add(lblNickname);

		nicknameLabel = new JLabel("Null");
		nicknameLabel.setBounds(87, 11, 263, 14);
		contentPane.add(nicknameLabel);

		JLabel lblRespect = new JLabel("Respect:");
		lblRespect.setBounds(10, 36, 67, 14);
		contentPane.add(lblRespect);

		respectLabel = new JLabel("Null");
		respectLabel.setBounds(87, 36, 263, 14);
		contentPane.add(respectLabel);

		initialSetup();
	}

	public void initialSetup() {
		Core core = new Core();
		core.openBrowser();

		new Login(Login_JFrame.frame.loginTxt.getText(), Login_JFrame.frame.passwordTxt.getText());

		Character c = new Character();
		Robbery r = new Robbery();
		NightLife n = new NightLife();
		Hospital h = new Hospital();

		c.populateCharacter();
		nicknameLabel.setText(c.getNickname().toString());
		respectLabel.setText(c.getRespect().toString());

	}
}
