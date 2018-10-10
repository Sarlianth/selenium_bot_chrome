package com.thecrims;

public class Robbery extends Core {

	public void toRob(Character c, NightLife n) {
		try {
			this.waitSeconds(700);

			this.clickElementById("menu-robbery");

			this.waitSeconds(700);

			this.clickElementByCssSelector(
					"#content_middle > div > div:nth-child(3) > div:nth-child(4) > div > table > tr > td:nth-child(1) > select");

			Boolean isSelected = this.selectComboValue(
					"#content_middle > div > div:nth-child(3) > div:nth-child(4) > div > table > tr > td:nth-child(1) > select",
					c);

			if (isSelected) {

				this.waitUntilElementToBeClickable(
						"#content_middle > div > div:nth-child(3) > div:nth-child(4) > div > table > tr > td:nth-child(1) > button",
						"cssSelector");

				this.clickElementByCssSelector(
						"#content_middle > div > div:nth-child(3) > div:nth-child(4) > div > table > tr > td:nth-child(1) > button");

				c.populateCharacter();

			}
		} catch (Exception e) {
			System.out.println("Something went wrong with the robbery...");
		}
	}

}
