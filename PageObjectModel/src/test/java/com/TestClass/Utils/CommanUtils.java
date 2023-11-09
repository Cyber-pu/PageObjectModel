package com.TestClass.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class CommanUtils {
	
	public static WebDriver driver;
	public CommanUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void navigate(String url) {
		driver.get(url);
	}
	
	public void sendKeys(By locator,String msg) {
		driver.findElement(locator).sendKeys(msg);
	}
	
	public void clikElement(By locator) {
		driver.findElement(locator).click();
	}
	
	public void validPage(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public String getElementText(By locator) {
		String text= driver.findElement(locator).getText().toString();
		return text;
	}

	public static void captureScreenshot() {
		Date scrDate = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotName = new File(Hooks.configData.getProperty("./test-output")+
				"/"+scrDate.toString().replace(" ", "_").replace(":", "_")+".png");
		try {
			FileUtils.copyFile(scrFile, screenshotName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("<br><img src='"+screenshotName.getAbsolutePath()+"' height='480' width='640' /><br>");
	}
	
	
	public static Object[][] readExcel() throws IOException{
		
		try {
			FileInputStream fis=new FileInputStream(new File("./data/data.xlsx"));
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("BankUser");
			int rownum=sheet.getLastRowNum();
			int cellnum=sheet.getRow(0).getLastCellNum();
			String arr[][]=new String[rownum][cellnum];
			for(int i=1;i<rownum+1;i++) {
				for(int j=0;j<cellnum;j++) {
					arr[i-1][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
			return arr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
