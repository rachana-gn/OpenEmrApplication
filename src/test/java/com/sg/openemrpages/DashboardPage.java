package com.sg.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	// to check the presence of flowboard
	private By flowBoardLocator = By.xpath("//div[text()='Flow Board']");
	
	private WebDriver driver;
	 
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForPresenceOfFlowBoard() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(flowBoardLocator));
	}
	
	public String getCurrentTitle(){
		
		return driver.getTitle().trim();
	}

}
