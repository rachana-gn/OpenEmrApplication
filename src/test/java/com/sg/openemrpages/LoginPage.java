package com.sg.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	//object repository
	private static By usernameLocator= By.id("authUser");
	private static By PasswordLocator= By.id("clearPass");
	
	//using static method
	public static void enterUsername(WebDriver driver, String username)
	{
		driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public static void enterPassword(WebDriver driver, String password)
	{
		driver.findElement(PasswordLocator).sendKeys(password);
	}

}
