package com.thecrims;

public class Login extends Core {

	private String user;
	private String pass;

	public Login(String username, String password) {
		user = username;
		pass = password;

		this.setElementValueByName("username", user);
		this.setElementValueByName("password", pass);
		this.clickElementByXpath("//*[@id='loginform']/button");
	}

}
