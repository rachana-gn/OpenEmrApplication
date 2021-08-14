package com.sg.openemrtest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sg.openemrbase.WebDriverWrapper;
import com.sg.openemrpages.DashboardPage;
import com.sg.openemrpages.LoginPage;

public class LoginTest extends WebDriverWrapper {
	//Day5_Class_LoginTest and Day6_ClassDataPovider
	
	@DataProvider 
	public Object[][] validCredentialTestData()	
	{
		//using DataProvider
		//admin,pass,English (Indian),OpenEMR
	    //physician,physician,English (Indian),OpenEMR
	    //accountant,accountant,English (Indian),OpenEMR
		
	
		Object[][]main = new Object[3][4];
		{
			main[0][0]= "admin";
			main[0][1]= "pass";
			main[0][2]= "English (Indian)";
			main[0][3]= "OpenEMR";
			
			main[1][0]= "physician";
			main[1][1]= "physician";
			main[1][2]= "English (Indian)";
			main[1][3]= "OpenEMR";
			
			main[2][0]= "accountant";
			main[2][1]= "accountant";
			main[2][2]= "English (Indian)";
			main[2][3]= "OpenEMR";

			
			return main;
			}
			
		}
		
		@Test(dataProvider = "validCredentialTestData")
		public void validCredentialTest(String username, String password, String language, String expectedTitle)	
		{
			
			LoginPage login = new LoginPage(driver);
			login.enterUsername(username);
			login.enterPassword(password);
			login.selectlanguageByText(language);
			login.clickOnLogin();
		
			DashboardPage dashboard = new DashboardPage(driver);
			dashboard.waitForPresenceOfFlowBoard();
			
			Assert.assertEquals(dashboard.getCurrentTitle(), expectedTitle);
				
		
		
		//using creation constructor for webdriver from LoginPage
//		LoginPage login = new LoginPage(driver);
//		login.enterUsername("admin");
//		login.enterPassword("pass");
//		login.selectlanguageByText("English (Indian)");
//		login.clickOnLogin();
//		
//		DashboardPage dashboard = new DashboardPage(driver);
//		dashboard.waitForPresenceOfFlowBoard();
		
//		String actualValue = dashboard.getCurrentTitle();
//		Assert.assertEquals(actualValue, "OpenEMR");
		//above code can be written as 
//		Assert.assertEquals(dashboard.getCurrentTitle(), "OpenEMR");
		
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
//		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
//		selectLang.selectByVisibleText("English (Indian)");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Flow Board']")));

//        String actualValue = driver.getTitle();        
//        Assert.assertEquals(actualValue, "OpenEMR");
}
	
	@Test
	public void invalidCredentialTest() {
		
	
		//using creation constructor for webdriver from LoginPage
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass1");
		login.selectlanguageByText("English (Indian)");
		login.clickOnLogin();
		
		Assert.assertEquals(login.getInvalidLoginError(), "Invalid username or password");
		
		//Non static method
//		LoginPage login = new LoginPage();
//		login.enterUsername(driver, "admin");
//		login.enterPassword(driver,"pass");
//		
//		static method
//		LoginPage.enterUsername(driver, "admin");
//		LoginPage.enterPassword(driver, "pass");
		
		//hardcoded
		//driver.findElement(By.id("authUser")).sendKeys("admin12");
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
//		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
//		selectLang.selectByVisibleText("English (Indian)");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		String error = driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText();
//		System.out.println(error);
//		Assert.assertEquals(error, "Invalid username or password");
		
		//above code in single line 
	//	Assert.assertEquals(driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText(), "Invalid username or password");
		
	}

}
