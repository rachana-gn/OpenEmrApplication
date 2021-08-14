package com.sg.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class LoginPage {
	//object repository in static method
//	private static By usernameLocator= By.id("authUser");
//	private static By PasswordLocator= By.id("clearPass");
//	
//	//using static method
//	public static void enterUsername(WebDriver driver, String username)
//	{
//		driver.findElement(usernameLocator).sendKeys(username);
//	}
//	
//	public static void enterPassword(WebDriver driver, String password)
//	{
//		driver.findElement(PasswordLocator).sendKeys(password);
//	}
	
	//object repository in non static method
	
	private  By usernameLocator= By.id("authUser");
	private  By PasswordLocator= By.id("clearPass");
	private By languageLocator = By.name("languageChoice");
	private By loginLocator = By.xpath("//button[@type='submit']");
	private By ackLicCertiLocator = By.xpath("//div[contains(text(),'Invalid')]");
	private By errorMessageLocator = By.xpath("//div[contains(text(),'Invalid')]");
	
//	public void enterUsername(WebDriver driver, String username)
//	{
//		driver.findElement(usernameLocator).sendKeys(username);
//	}
//	
//	public  void enterPassword(WebDriver driver, String password)
//	{
//		driver.findElement(PasswordLocator).sendKeys(password);
//	}
	
	//creating constructor for webdriver
	
	private WebDriver  driver;
	 
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public  void enterPassword(String password)
	{
		driver.findElement(PasswordLocator).sendKeys(password);
	}
	
	//selectLang By Text
	public void selectlanguageByText(String language) 
	{
		Select selectLang = new Select(driver.findElement(languageLocator));
		selectLang.selectByVisibleText(language);
	}
		
		public void clickOnLogin() {
			
		driver.findElement(loginLocator).click();
		}
		
		//click on Acknowledgements and License cetificate
		public void clickonAckandLicCerti()
		{
			driver.findElement(ackLicCertiLocator).click();
			
		}
		//get Application description
		//
		
		//get invalid login error method
		public String getInvalidLoginError()
	    {
	        String errorMSG=driver.findElement(errorMessageLocator).getText();
	        return errorMSG;
	        //above code in one line
	       //return.driver.findElement(errorMessageLocator).getText().trim()
	    }
		
		
	

}
