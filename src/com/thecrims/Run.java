package com.thecrims;

public class Run {

	public static void main(String args[]) {

		Core core = new Core();
		core.openBrowser();

		// new Login();

		Character c = new Character();
		Robbery r = new Robbery();
		NightLife n = new NightLife();
		Hospital h = new Hospital();

		while (core.getDriver() == WebDriverSingleton.getInstance()) {
			c.populateCharacter();

			if (c.getAddiction() >= 2) {
				h.cureAddiction();
			}

			if (c.getStamina() < 5) {
				n.doDrugs();
			}

			r.toRob(c, n);
		}

		core.closeBrowser();
	}

}
