package com.amazon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.amazon.readexceldata.Readexceldata;


public class Resources {

	public Properties Repository = new Properties();
	public static File f;
	public static FileInputStream FI;
	
//chromesdsdsdsds


	@Test
	public void testLogin() throws Exception {

		//System.setProperty("webdriver.gecko.driver",
			//	"D:\\SeleniumTesting\\SeleinumTesting\\Library\\geckodriver.exe");
				System.setProperty("webdriver.chrome.driver",
						"D:\\SeleniumTesting\\SeleinumTesting\\Library\\Drivers\\chromedriver.exe");
		//WebDriver driver =new FirefoxDriver();
				WebDriver driver =new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

		f = new File("D:\\PageFactory\\Amazonkeyworddriven\\src\\test\\java\\Objects\\login.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);

		Readexceldata h = new Readexceldata(driver);
		h.readexcel("D:\\PageFactory\\Amazonkeyworddriven\\TestCase.xlsx", Repository);

	}



}
