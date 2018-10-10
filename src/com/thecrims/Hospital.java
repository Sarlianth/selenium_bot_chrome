package com.thecrims;

public class Hospital extends Core {

	public void cureAddiction() {
		this.waitUntilElementToBeClickable("menu-hospital", "id");

		this.clickElementById("menu-hospital");

		this.waitUntilElementToBeClickable("//*[@id=\"content_middle\"]/div/div[3]/table[1]/tbody/tr[5]/td[4]/input",
				"xpath");

		this.setElementValueByXpath("//*[@id=\"content_middle\"]/div/div[3]/table[1]/tbody/tr[5]/td[4]/input", "3");
		this.clickElementByXpath("//*[@id=\"content_middle\"]/div/div[3]/table[1]/tbody/tr[5]/td[4]/button");
	}

}
