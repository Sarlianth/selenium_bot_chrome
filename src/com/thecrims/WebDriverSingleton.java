package com.thecrims;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

	public static WebDriver driver;

	public static WebDriver getInstance() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
		}

		return driver;
	}

}
