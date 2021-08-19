package com.sg.openemrtest;

import com.sg.openemrbase.WebDriverWrapper;
import com.sg.openemrpages.LoginPage;

public class AboutTest extends WebDriverWrapper{
	//Day7
	
	public void checkAboutandVersionTest() 
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectlanguageByText("English (Indian)");
		login.clickOnLogin();
		
		
		//when we have huge text we use assertTrue
	}

	
	
}
