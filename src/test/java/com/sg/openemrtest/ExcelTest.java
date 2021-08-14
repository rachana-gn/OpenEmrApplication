package com.sg.openemrtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	//Day6 Extracting data from excel

	public static void main(String[] args) throws IOException {
		
		//location
		FileInputStream file=new FileInputStream("src/test/resources/testdata/OpenEmrData.xlsx");//may throw file not found exception
		//open the excel sheet
		XSSFWorkbook book = new XSSFWorkbook(file);// may throw new IO exception
		//sheet
		XSSFSheet sheet= book.getSheet("inValidCrendentialTest");//may throw null pointer exception when sheet name is wrong
		
		//hardcoded code
//		XSSFRow row= sheet.getRow(1);//row
//		XSSFCell cell= row.getCell(2);//cell
//		
//		DataFormatter format = new DataFormatter();
//		String cellValue = format.formatCellValue(cell);
//		
//		System.out.println(cellValue);
		
		// above code in for loop
		
		//print cell values- index values
//		for(int r=0;r<3;r++)//for row
//		{
//			for (int c=0;c<4;c++)//for cell
//			{
//				System.out.println(r+" "+c);
//			}
//		}

		//using for loop with header values
//		for(int r=0;r<3;r++)
//		{
//			for (int c=0;c<4;c++)
//			{
//				XSSFRow row= sheet.getRow(r);
//				
//				XSSFCell cell= row.getCell(c);
//				
//				DataFormatter format = new DataFormatter();
//				String cellValue = format.formatCellValue(cell);
//				
//				System.out.println(cellValue);
//			}
//		}
		
		//exclude the header values
//		for(int r=1;r<3;r++)
//		{
//			for (int c=0;c<4;c++)
//			{
//				XSSFRow row= sheet.getRow(r);
//				
//				XSSFCell cell= row.getCell(c);
//				
//				DataFormatter format = new DataFormatter();
//				String cellValue = format.formatCellValue(cell);
//				
//				System.out.println(cellValue);
//			}
//		}
//		
		//for loop for putting in object array
		
//		Object[][] main = new Object[2][4];
//		//i--> no of rows=totalrows-1
//		//j-->cell count
//		for(int r=1;r<3;r++)
//		{
//			for (int c=0;c<4;c++)
//			{
//				XSSFRow row= sheet.getRow(r);
//				
//				XSSFCell cell= row.getCell(c);
//				
//				DataFormatter format = new DataFormatter();
//				String cellValue = format.formatCellValue(cell);
//				
//				System.out.println(cellValue);
//				main[r-1][c]=cellValue;
//			}
//		}
//		System.out.println(main);
//		//System.out.println(main[0][0]);
		
		
		//dynamically get row and cell count- works always
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cellCount);
		
		Object[][] main = new Object[rowCount-1][cellCount];
		for(int r=1;r<rowCount;r++)
		{
			for (int c=0;c<cellCount;c++)
			{
				XSSFRow row= sheet.getRow(r);
				
				XSSFCell cell= row.getCell(c);
				
				DataFormatter format = new DataFormatter();
				String cellValue = format.formatCellValue(cell);
				
				System.out.println(cellValue);
				main[r-1][c]=cellValue;
			}
			System.out.println("-------------");
		}
		
	}

}
