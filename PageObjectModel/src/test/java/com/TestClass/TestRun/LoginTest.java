package com.TestClass.TestRun;

import java.io.IOException;

import org.testng.annotations.DataProvider;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.TestClass.Pages.LoginPage;
import com.TestClass.Utils.CommanUtils;
import com.TestClass.Utils.Hooks;

public class LoginTest extends Hooks{
	
	
	
	@Test(dataProvider = "login_info")
	public void loginTest(String user,String pass) throws InterruptedException {
		LoginPage lg=new LoginPage(driver);
		lg.loginPage("https://demo.guru99.com/v2/", user, pass);
		Thread.sleep(2000);
	}
	
	
	@DataProvider(name="login_info")
	public Object[][] dataProvider() throws IOException{
		try {
			return CommanUtils.readExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
