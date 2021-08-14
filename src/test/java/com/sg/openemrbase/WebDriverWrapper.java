package com.sg.openemrbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverWrapper {

	protected WebDriver driver;

	@BeforeMethod
	public void setUP() {

		String browsers = "FF";

		if (browsers.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browsers.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			// System.setProperty("webdriver.gecko.driver","src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			// driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/b/openemr/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
