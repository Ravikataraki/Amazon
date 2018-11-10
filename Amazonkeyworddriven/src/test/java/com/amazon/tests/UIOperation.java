package com.amazon.tests;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {
	public static WebDriver driver;
	
	public UIOperation(WebDriver driver) {
		UIOperation.driver = driver;
	}

	public static void perform(Properties Repository, String operation, String objectName, String objectType,String value) throws Exception {
		
		switch (operation.toUpperCase()) {
		case "CLICK":
			// Perform click

			driver.findElement(getObject(Repository, objectName, objectType)).click();

			break;
		case "SETTEXT":
			// Set text on control
			driver.findElement(getObject(Repository, objectName, objectType)).sendKeys(value);
			break;

		case "GOTOURL":
			// Get url of application
		
			driver.get(Repository.getProperty(value));
			break;
		case "GETTEXT":
			// Get text of an element
			driver.findElement(getObject(Repository, objectName, objectType)).getText();
			break;

		default:
			break;
		}
	}

	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private static By getObject(Properties Repository, String objectName, String objectType) throws Exception {
		// Find by xpath

		if (objectType.equalsIgnoreCase("XPATH")) {

			return By.xpath(Repository.getProperty(objectName));

		}

		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(Repository.getProperty(objectName));

		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {

			return By.name(Repository.getProperty(objectName));

		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(Repository.getProperty(objectName));

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {

			return By.linkText(Repository.getProperty(objectName));

		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(Repository.getProperty(objectName));

		} else {
			throw new Exception("Wrong object type");
		}
	}

}
