package com.thecrims;

public class RunThread implements Runnable {

	private Core core;
	private Character c;
	private Robbery r;
	private NightLife n;
	private Hospital h;

	public RunThread(Core core, Character c, Robbery r, NightLife n, Hospital h) {
		this.core = core;
		this.c = c;
		this.r = r;
		this.n = n;
		this.h = h;
	}

	public void run() {
		while (core.getDriver() == WebDriverSingleton.getInstance()) {
			c.populateCharacter();
			Run_JFrame.respectLabel.setText(c.getRespect().toString());

//			String isHostpital = core.getElementValueByXpath("//*[@id=\"menu-hospital\"]/span");
//			if (isHostpital.equalsIgnoreCase("Hospital")) {
//				System.out.println("You're in a hospital");
//				Run_JFrame.runLabel.setText("You're in a hospital.. Check your profile :(..");
//			}

			if (c.getAddiction() >= 2) {
				h.cureAddiction();
			}

			if (c.getStamina() < 5) {
				n.doDrugs();
			}

			r.toRob(c, n);
		}
	}
}