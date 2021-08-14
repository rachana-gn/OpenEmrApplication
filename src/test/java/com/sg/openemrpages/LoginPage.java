package com.sg.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
	
	

}
