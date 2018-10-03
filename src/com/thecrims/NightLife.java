package com.thecrims;

public class NightLife extends Core {

	public void doDrugs() {
		try {
			this.waitUntilElementToBeClickable("menu-nightlife", "id");

			this.clickElementById("menu-nightlife");

			this.waitUntilElementToBeClickable(
					"#content_middle > div > div:nth-child(3) > div > div:nth-child(4) > table > tbody > tr > td:nth-child(5) > div > button",
					"cssSelector");

			this.clickElementByCssSelector(
					"#content_middle > div > div:nth-child(3) > div > div:nth-child(4) > table > tbody > tr > td:nth-child(5) > div > button");

			this.waitUntilElementToBeClickable(
					"//*[@id=\"content_middle\"]/div/div[3]/div/table[2]/tbody/tr/td[4]/input", "xpath");

			this.setElementValueByXpath("//*[@id=\"content_middle\"]/div/div[3]/div/table[2]/tbody/tr/td[4]/input",
					"51");

			this.clickElementByXpath("//*[@id=\"content_middle\"]/div/div[3]/div/table[2]/tbody/tr/td[4]/button");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}

}
