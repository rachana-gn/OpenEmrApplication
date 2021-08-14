package com.sg.openemrtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.openemrbase.WebDriverWrapper;
import com.sg.openemrpages.LoginPage;

public class LoginTest extends WebDriverWrapper {
	//Day5_Class_LoginTest
	
	@Test 
	public void validCredentialTest()	
	{
		//using creation constructor for webdriver from LoginPage
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass");
		
		//Non static method
//		LoginPage login = new LoginPage();
//		login.enterUsername(driver, "admin");
//		login.enterPassword(driver,"pass");
//		
		//static method
//		LoginPage.enterUsername(driver, "admin");
//		LoginPage.enterPassword(driver, "pass");
		
		//hardcoded
		//driver.findElement(By.id("authUser")).sendKeys("admin");
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Flow Board']")));

        String actualValue = driver.getTitle();
        //using POM
        
        Assert.assertEquals(actualValue, "OpenEMR");
	}
	
	@Test
	public void invalidCredentialTest() {
		
	
		//using creation constructor for webdriver from LoginPage
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass1");
		
		
		//Non static method
//		LoginPage login = new LoginPage();
//		login.enterUsername(driver, "admin");
//		login.enterPassword(driver,"pass");
//		
		//static method
//		LoginPage.enterUsername(driver, "admin");
//		LoginPage.enterPassword(driver, "pass");
		
		//hardcoded
		//driver.findElement(By.id("authUser")).sendKeys("admin12");
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String error = driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText();
		System.out.println(error);
		Assert.assertEquals(error, "Invalid username or password");
		
		//above code in single line 
	//	Assert.assertEquals(driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText(), "Invalid username or password");
		
	}

}
