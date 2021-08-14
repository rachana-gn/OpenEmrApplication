package com.sg.openemrtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotationsTest {
	//Day5_Class_TestAnnotationsTest
	
	@BeforeMethod
	public void setUP()
	{
		System.out.println("Launch the browser");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Quit the browser");
	}
	
	@Test //(invocationCount = 5, priority = 1)// to give which should run first with priority and how many times with invocationCount
	public void validCredentialTest()
	{
		System.out.println("valid test");
	}
	
	@Test //(priority = 2)
	public void invalidCredentialTest()
	{
		System.out.println("invalid test");
	}


}
