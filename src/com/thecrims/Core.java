package com.thecrims;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Core {

	private WebDriver driver = WebDriverSingleton.getInstance();
	private WebDriverWait wait = new WebDriverWait(driver, 20);
	private String url = "https://www.thecrims.com";

	public WebDriver getDriver() {
		return driver;
	}

	public void openBrowser() {
		driver.navigate().to(this.url);
	}

	public void closeBrowser() {
		driver.close();
	}

	public String getElementValueById(String elementId) {
		return driver.findElement(By.id(elementId)).getText();
	}

	public void setElementValueById(String elementId, String value) {
		driver.findElement(By.id(elementId)).sendKeys(value);
	}

	public void clickElementById(String elementId) {
		driver.findElement(By.id(elementId)).click();
	}

	public String getElementValueByName(String elementName) {
		return driver.findElement(By.name(elementName)).getText();
	}

	public void setElementValueByName(String elementName, String value) {
		driver.findElement(By.name(elementName)).sendKeys(value);
	}

	public void clickElementByName(String elementName) {
		driver.findElement(By.name(elementName)).click();
	}

	public String getElementValueByCssSelector(String elementCssSelector) {
		return driver.findElement(By.cssSelector(elementCssSelector)).getText();
	}

	public void setElementValueByCssSelector(String elementCssSelector, String value) {
		driver.findElement(By.cssSelector(elementCssSelector)).sendKeys(value);
	}

	public void clickElementByCssSelector(String elementCssSelector) {
		driver.findElement(By.cssSelector(elementCssSelector)).click();
	}

	public WebElement findElementByCssSelector(String elementName) {
		return driver.findElement(By.cssSelector(elementName));
	}

	public String getElementValueByXpath(String elementXpath) {
		return driver.findElement(By.xpath(elementXpath)).getText();
	}

	public void setElementValueByXpath(String elementXpath, String value) {
		driver.findElement(By.xpath(elementXpath)).sendKeys(value);
	}

	public void clickElementByXpath(String elementXpath) {
		driver.findElement(By.xpath(elementXpath)).click();
	}

	public void waitSeconds(Integer seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitElementToBeVisible(String cssSelector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}

	public void waitUntilElementToBeClickable(String elementSelector, String selectorType) {

		switch (selectorType) {
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(elementSelector)));
			break;
		case "cssSelector":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementSelector)));
			break;
		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementSelector)));
			break;

		default:
			break;
		}
	}

	public void waitUntilJavascriptLoad() {
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete' ? true : false"));
	}

	public Boolean selectComboValue(final String cssSelector, Character c) {
		Select dropdown = new Select(this.findElementByCssSelector(cssSelector));

		WebElement safeOption = dropdown.getOptions().get(0);

		List<WebElement> options = dropdown.getOptions();
		for (WebElement option : options) {
			if (option.getText().contains("100%")) {
				String[] parts = option.getText().split(" - ");
				String[] parts2 = parts[1].split("%");
				Integer requiredStamina = Integer.parseInt(parts2[0]);

				if (c.getStamina() >= requiredStamina) {
					safeOption = option;
				}
			}
		}
		

		if (!safeOption.getText().contains("Choose") || c.getStamina() > 5) {
			safeOption.click();

			return true;
		}

		return false;
	}
}
