package com.sg.openemrtest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	//Data Provider
	
	//john,john123
	//peter,peter123
	//mark,mark123
	
	//2 dimensional array
	@DataProvider
	public Object[][] validData()
	{
		Object[][] main = new Object[3][2];
		//i--->3 test cases so 3(john,peter,mark)
		//j--->2 parameter- username and password so 2
		main[0][0]="john";
		main[0][1]="john123";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		
		main[2][0]="mark";
		main[2][1]="mark123";
		
		return main;
		
	}
		
	@Test(dataProvider = "validData")
		public void validTest(String username, String password){
		System.out.println("tested" +username+password);
		
		
	}
	

}
