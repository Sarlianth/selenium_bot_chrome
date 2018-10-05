package com.thecrims;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login_JFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField loginTxt;
	static Login_JFrame frame;
	public JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login_JFrame();
					frame.setLocationRelativeTo(null);
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
	public Login_JFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		loginTxt = new JTextField();
		loginTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		loginTxt.setBounds(80, 37, 171, 27);
		contentPane.add(loginTxt);
		loginTxt.setColumns(10);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(10, 44, 60, 14);
		contentPane.add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 89, 60, 14);
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Run_JFrame run = new Run_JFrame();
				run.setLocationRelativeTo(null);
				run.setVisible(true);
				loginTxt.setText("");
				passwordTxt.setText("");
				frame.setVisible(false);
			}
		});
		btnLogin.setBounds(80, 118, 80, 23);
		contentPane.add(btnLogin);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Arial", Font.PLAIN, 10));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginTxt.setText("");
				passwordTxt.setText("");
			}
		});
		btnClear.setBounds(171, 118, 80, 23);
		contentPane.add(btnClear);

		JLabel lblTheCrimsBot = new JLabel("The Crims Bot");
		lblTheCrimsBot.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheCrimsBot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTheCrimsBot.setBounds(80, 11, 171, 14);
		contentPane.add(lblTheCrimsBot);

		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(80, 83, 171, 27);
		contentPane.add(passwordTxt);
	}
}
