package com.thecrims;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Run_JFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel nicknameLabel;
	static JLabel respectLabel;
	Core core;
	Character c = new Character();
	Robbery r = new Robbery();
	NightLife n = new NightLife();
	Hospital h = new Hospital();
	Thread t;
	static JLabel runLabel;
	private JButton btnLogout;
	static Run_JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Run_JFrame();
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
		setBounds(100, 100, 261, 170);
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

		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Arial", Font.PLAIN, 10));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RunThread worker = new RunThread(core, c, r, n, h);
				t = new Thread(worker);
				try {
					t.start();
					runLabel.setForeground(Color.GREEN);
					runLabel.setText("Running..");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					t.stop();
					System.out.println(e);
					runLabel.setForeground(Color.RED);
					runLabel.setText("Stopped..");
				}
			}
		});
		btnStart.setBounds(10, 98, 67, 23);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.setFont(new Font("Arial", Font.PLAIN, 10));
		btnStop.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				t.stop();
				runLabel.setForeground(Color.RED);
				runLabel.setText("Stopped..");
			}
		});
		btnStop.setBounds(87, 98, 67, 23);
		contentPane.add(btnStop);

		runLabel = new JLabel("");
		runLabel.setBounds(66, 73, 119, 14);
		contentPane.add(runLabel);

		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (t != null)
					btnStop.doClick();
				core.closeBrowser();
				Login_JFrame.frame.setVisible(true);
				// setVisible(false);
				dispose();
			}
		});
		btnLogout.setBounds(164, 98, 67, 23);
		contentPane.add(btnLogout);

		initialSetup();
	}

	public void initialSetup() {
		try {
			core = new Core();
			core.openBrowser();

			char[] passByte = Login_JFrame.frame.passwordTxt.getPassword();
			String password = new String(passByte);

			new Login(Login_JFrame.frame.loginTxt.getText(), password);

			c.populateCharacter();
			nicknameLabel.setText(c.getNickname().toString());
			respectLabel.setText(c.getRespect().toString());
			setTitle(c.getNickname().toUpperCase());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(
					"Oops.. something went wrong with initial setup.. Maybe an update going on?.. Check browser and/or Run_JFrame/initialSetup() ");
			JOptionPane.showMessageDialog(this, "Website down.. going to retry in 10s..");
			try {
				Thread.sleep(10000);
				initialSetup();
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}
	}
}
